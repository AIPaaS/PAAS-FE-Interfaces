package com.aic.paas.task.dep.peer.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.ActionType;
import com.aic.paas.task.dep.bean.AppImageSettings;
import com.aic.paas.task.dep.bean.AppImageSvcInfo;
import com.aic.paas.task.dep.bean.CPcAppDepHistory;
import com.aic.paas.task.dep.bean.GeneralDeployResp;
import com.aic.paas.task.dep.bean.GeneralReq;
import com.aic.paas.task.dep.bean.GeneralReq.Container;
import com.aic.paas.task.dep.bean.GeneralReq.Container.For;
import com.aic.paas.task.dep.bean.GeneralTimerReq;
import com.aic.paas.task.dep.bean.LogReq;
import com.aic.paas.task.dep.bean.Parameter;
import com.aic.paas.task.dep.bean.PcApp;
import com.aic.paas.task.dep.bean.PcAppDepHistory;
import com.aic.paas.task.dep.bean.PcAppImage;
import com.aic.paas.task.dep.bean.PcAppImgSvc;
import com.aic.paas.task.dep.bean.PcAppTask;
import com.aic.paas.task.dep.bean.PcKvPair;
import com.aic.paas.task.dep.peer.PcAppImagePeer;
import com.aic.paas.task.dep.rest.IDeployServiceManager;
import com.aic.paas.task.dep.rest.PcAppDepHistorySvc;
import com.aic.paas.task.dep.rest.PcAppImageSvc;
import com.aic.paas.task.dep.rest.PcAppSvc;
import com.aic.paas.task.dep.rest.PcAppTaskSvc;
import com.aic.paas.task.dep.rest.PcAppVersionSvc;
import com.aic.paas.task.dep.rest.PcKvPairSvc;
import com.aic.paas.task.dev.bean.CPcImage;
import com.aic.paas.task.dev.bean.PcImage;
import com.aic.paas.task.dev.rest.PcImageSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.json.JSON;

public class PcAppImagePeerImpl implements PcAppImagePeer {

	static final Logger logger = LoggerFactory.getLogger(PcAppImagePeerImpl.class);

	@Autowired
	PcAppImageSvc appImageSvc;

	@Autowired
	PcAppDepHistorySvc pcAppDepHistorySvc;

	@Autowired
	PcAppVersionSvc pcAppVersionSvc;

	@Autowired
	PcAppSvc appSvc;

	@Autowired
	PcImageSvc imageSvc;

	@Autowired
	PcAppTaskSvc pcAppTaskSvc;

	@Autowired
	PcKvPairSvc pcKvPairSvc;
	
	@Autowired
	PcAppImageSvc pcAppImageSvc;

	@Autowired
	IDeployServiceManager iDeployServiceManager;

	@Override
	public AppImageSettings getAppImageSettings(Long appImageId) {
		AppImageSettings settings = appImageSvc.getAppImageSettings(appImageId);
		if (settings != null) {
			Long imageId = settings.getAppImage().getImageId();
			if (imageId != null) {
				PcImage image = imageSvc.queryImageById(imageId);
				settings.setImage(image);
			}
		}
		return settings;
	}

	@Override
	public List<AppImageSettings> getAppImageSettingsList(Long appId, Long appVnoId) {
		List<AppImageSettings> settingsList = appImageSvc.getAppImageSettingsList(appId, appVnoId);

		if (settingsList != null && settingsList.size() > 0) {
			Set<Long> imageids = new HashSet<Long>();
			for (int i = 0; i < settingsList.size(); i++) {
				AppImageSettings settings = settingsList.get(i);
				imageids.add(settings.getAppImage().getImageId());
			}

			CPcImage imgcdt = new CPcImage();
			imgcdt.setIds(imageids.toArray(new Long[0]));
			List<PcImage> images;
			try {
				images = imageSvc.queryImageList(imgcdt, null);
			} catch (Exception e) {
				// in case of there is no dev service at all
				images = new ArrayList<PcImage>();
			}

			Map<Long, PcImage> imgmap = BinaryUtils.toObjectMap(images, "ID");

			for (int i = 0; i < settingsList.size(); i++) {
				AppImageSettings settings = settingsList.get(i);
				Long imageId = settings.getAppImage().getImageId();
				PcImage image = null;
				if (imageId != null)
					image = imgmap.get(imageId);
				if (image == null) {
					image = new PcImage();
					image.setImageName(settings.getAppImage().getImage());
				}
				settings.setImage(image);
				List<PcKvPair> params = pcKvPairSvc.getPcKvPairs(settings.getAppImage().getId(), 2);
				settings.setParams(params);
				List<PcAppImgSvc> imgSvcs = pcAppImageSvc.getPcAppImgSvc(settings.getAppImage().getId());
				List<PcKvPair> serviceParams = new ArrayList<>();
				for (PcAppImgSvc pcAppImgSvc : imgSvcs) {
					List<PcKvPair> serviceKv = pcKvPairSvc.getPcKvPairs(pcAppImgSvc.getId(), 3);
					serviceParams.addAll(serviceKv);
				}
				settings.setCallServiceParams(serviceParams);
			}
		}

		return settingsList;
	}

	private PcAppTask writeTaskLog(Long appId, Long appVnoId, GeneralDeployResp resp, ActionType actionType) {
		PcAppTask pcAppTask = new PcAppTask();
		pcAppTask.setId(resp.getReqId().longValue());
		pcAppTask.setAppId(appId);
		pcAppTask.setAppVnoId(appVnoId);
		pcAppTask.setTaskUserName(actionType.getName());
		pcAppTask.setStatus(2);
		pcAppTask.setTaskStartTime(BinaryUtils.getNumberDateTime());
		pcAppTaskSvc.save(pcAppTask);
		return pcAppTask;
	}

	public void writeAppDepHistory(Long appId, Long appVnoId, GeneralDeployResp resp) {
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		PcApp pcApp = appSvc.queryById(appId);
		logger.info("write history count ....." + appImageList.size());
		for (AppImageSettings setting : appImageList) {
			PcAppDepHistory pcAppDepHistory = new PcAppDepHistory();
			try {
				BeanUtils.copyProperties(pcAppDepHistory, pcApp);
				BeanUtils.copyProperties(pcAppDepHistory, setting);
				pcAppDepHistory.setTaskId(resp.getReqId().longValue());
				pcAppDepHistory.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
				pcAppDepHistory.setId(null);
				pcAppDepHistory.setAppVersionNo(pcApp.getVersionNo());
				pcAppDepHistory.setNetZoneId(setting.getAppImage().getNetZoneId());
				pcAppDepHistory.setImageName(setting.getImage().getImageName());
				pcAppDepHistory.setImageFullName(setting.getAppImage().getContainerFullName());
				pcAppDepHistory.setContainerFullName(setting.getAppImage().getContainerFullName());
				pcAppDepHistorySvc.saveOrUpdate(pcAppDepHistory);
			} catch (Exception e) {
				logger.error("", e);
			}
		}

	}

	@Override
	public void writeAppDepHistory(Long appId, Long appVnoId, GeneralDeployResp resp, Integer runStatus) {
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		PcApp pcApp = appSvc.queryById(appId);
		logger.info("write history count ....." + appImageList.size());
		for (AppImageSettings setting : appImageList) {
			PcAppDepHistory pcAppDepHistory = new PcAppDepHistory();
			try {
				BeanUtils.copyProperties(pcAppDepHistory, pcApp);
				BeanUtils.copyProperties(pcAppDepHistory, setting);
				pcAppDepHistory.setTaskId(resp.getReqId().longValue());
				pcAppDepHistory.setContainerName(setting.getAppImage().getContainerName());
				pcAppDepHistory.setAppVnoId(appVnoId);
				pcAppDepHistory.setAppId(appId);
				pcAppDepHistory.setRunStatus(runStatus);
				pcAppDepHistory.setId(null);
				pcAppDepHistory.setAppVersionNo(pcApp.getVersionNo());
				pcAppDepHistory.setNetZoneId(setting.getAppImage().getNetZoneId());
				pcAppDepHistory.setImageName(setting.getImage().getImageName());
				pcAppDepHistory.setContainerFullName(setting.getAppImage().getContainerFullName());
				pcAppDepHistory.setCreator(setting.getAppImage().getCreator());
				if(runStatus!=3){
					pcAppDepHistorySvc.saveOrUpdate(pcAppDepHistory);
				}
				else{
					CPcAppDepHistory cdt = new CPcAppDepHistory();
					cdt.setAppId(appId);
					cdt.setAppVnoId(appVnoId);
					pcAppDepHistory.setRunStatus(4);
					pcAppDepHistorySvc.update(pcAppDepHistory, cdt);
				}
			} catch (Exception e) {
				logger.error("", e);
			}
		}

	}
	
	@Override
	public void updateDepHistory(Long appId, Long appVnoId,  Integer runStatus,Integer preRunStatus){
		CPcAppDepHistory cdt = new CPcAppDepHistory();
		PcAppDepHistory pcAppDepHistory = new PcAppDepHistory();
		cdt.setAppId(appId);
		cdt.setAppVnoId(appVnoId);
			pcAppDepHistory.setRunStatus(runStatus);
			cdt.setRunStatus(preRunStatus);
			pcAppDepHistorySvc.update(pcAppDepHistory, cdt);
	}

	
	@Override
	public String startDeploy(Long appId, Long appVnoId) {
		logger.info("appId ++++:" + appId);
		logger.info("appVnoId" + appVnoId);
		pcAppVersionSvc.updateAppVersionStatusById(appVnoId, 2);
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);

		PcApp pcApp = appSvc.queryById(appId);

		GeneralReq generalReq = new GeneralReq();
		generalReq.setAppId(pcApp.getId().toString());
		generalReq.setAppName(pcApp.getAppCode());
		generalReq.setAppNameCN(pcApp.getAppName());
		generalReq.setClusterId(pcApp.getResCenterId().toString());
		// generalReq.setClusterName(clusterName)
		generalReq.setDataCenterId(pcApp.getDataCenterId().toString());

		List<Container> containers = new ArrayList<Container>();
		for (AppImageSettings setting : appImageList) {
			Container container = new Container();
			container.setContainerId(setting.getAppImage().getId().toString());
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
			container.setZoneId(setting.getAppImage().getNetZoneId().toString());
			List<Parameter> attrs = new ArrayList<Parameter>();
			List<PcKvPair> paramList = setting.getParams();
			for (PcKvPair pair : paramList) {
				Parameter pa = new Parameter();
				pa.setKey(pair.getKvKey());
				pa.setValue(pair.getKvVal());
				attrs.add(pa);
			}
			for (PcKvPair pair : setting.getCallServiceParams()) {
				Parameter pa = new Parameter();
				pa.setKey(pair.getKvKey());
				pa.setValue(pair.getKvVal());
				attrs.add(pa);
			}
			container.setAttrs(attrs);
			container.setVersion(pcApp.getVersionNo());
			List<PcAppImage> dependList = setting.getDependImages();

			List<String> containeIdList = new ArrayList<String>();
			for (PcAppImage image : dependList) {
				containeIdList.add(image.getId().toString());
			}
			PcImage image = setting.getImage();
			container.setImgFullName(image.getImageName());
			// crontainer.setDepends(containeIdList.toArray().toString());
			container.setCpu(setting.getAppImage().getCpuCount() / 100.0);
			container.setMem(Integer.parseInt(setting.getAppImage().getMemSize().toString()));
			// 硬盘大小单位是GB 需要转换成MB X1024
			container.setDisk(Integer.parseInt(setting.getAppImage().getDiskSize().toString()) * 1024);
			container.setInstances(setting.getAppImage().getInstanceCount());
			// containe.set
			if (setting.getAppImage().getIsSupportFlex().equals(1)) {

				container.setMaxInst(setting.getAppImage().getMaxInstanceCount());
				container.setMinInst(setting.getAppImage().getMinInstanceCount());
				container.setScaleInCpu(setting.getAppImage().getCpuFlexLowerLimit());
				container.setScaleOutCpu(setting.getAppImage().getCpuFlexUpperLimit());
			}

			List<For> servicesFor = new ArrayList<For>();
			List<AppImageSvcInfo> callServiceList = setting.getCallServices();
			for (AppImageSvcInfo imageSvcInfo : callServiceList) {
				imageSvcInfo.getSvc();
			}

			container.setServicesFor(servicesFor);
			container.setLogDir(setting.getAppImage().getLogMpPath());
			container.setDataDir(setting.getAppImage().getDataMpPath());
			// 拼装json数据
			containers.add(container);
		}
		generalReq.setContainers(containers);

		System.out.println(JSON.toString(generalReq));
		String resStr = iDeployServiceManager.createLongRun(JSON.toString(generalReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			// write task log and so on...
			writeTaskLog(appId, appVnoId, resp, ActionType.deploy);
			//writeAppDepHistory(appId, appVnoId, resp);
			writeAppDepHistory(appId, appVnoId, resp,2);

			// update app status
			pcApp.setStatus(2);
			appSvc.saveOrUpdate(pcApp);
		}
		logger.info(JSON.toString(resStr));
		return resStr;

	}

	@Override
	public String reDeploy(Long appId, Long appVnoId) {
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		PcApp pcApp = appSvc.queryById(appId);

		GeneralReq generalReq = new GeneralReq();
		generalReq.setAppId(pcApp.getId().toString());
		generalReq.setAppName(pcApp.getAppCode());
		generalReq.setAppNameCN(pcApp.getAppName());
		generalReq.setClusterId(pcApp.getResCenterId().toString());
		List<Container> containers = new ArrayList<Container>();
		for (AppImageSettings setting : appImageList) {
			Container container = new Container();
			container.setContainerId(setting.getAppImage().getId().toString());
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
			container.setInstances(setting.getAppImage().getInstanceCount());
			PcAppImage pcAppImage = setting.getAppImage();
			container.setImgFullName(pcAppImage.getImage());
			containers.add(container);
		}
		generalReq.setContainers(containers);
		logger.debug("upgrade req param is ====" + JSON.toString(generalReq));
		String resStr = iDeployServiceManager.upgrade(JSON.toString(generalReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			// write task log and so on...
			writeTaskLog(appId, appVnoId, resp, ActionType.upgrade);
			//writeAppDepHistory(appId, appVnoId, resp);
			updateDepHistory(appId, appVnoId, 4, null);
			writeAppDepHistory(appId, appVnoId, resp,2);

			// update app status
			pcApp.setStatus(2);
			appSvc.saveOrUpdate(pcApp);
		}
		return resStr;
	}

	@Override
	public String destroyDeploy(Long appId) {
		Long appVnoId = pcAppVersionSvc.getRunningAppVersionId(appId);
		if (appVnoId == null)
			appVnoId = pcAppVersionSvc.getStopedAppVersionId(appId);
		if (appVnoId == null) {
			logger.error("can't find app " + appId + " version info");
			// TODO: write some return info
			return "";
		}
		pcAppVersionSvc.updateAppVersionStatusById(appVnoId, 1);
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		PcApp pcApp = appSvc.queryById(appId);

		GeneralReq generalReq = new GeneralReq();
		generalReq.setAppId(pcApp.getId().toString());
		generalReq.setAppName(pcApp.getAppCode());
		generalReq.setAppNameCN(pcApp.getAppName());
		generalReq.setClusterId(pcApp.getResCenterId().toString());
		List<Container> containers = new ArrayList<Container>();
		for (AppImageSettings setting : appImageList) {
			Container container = new Container();
			container.setContainerId(setting.getAppImage().getId().toString());
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
			containers.add(container);
		}
		generalReq.setContainers(containers);
		String resStr = iDeployServiceManager.destroyLongRun(JSON.toString(generalReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			writeTaskLog(appId, appVnoId, resp, ActionType.destroy);
			//writeAppDepHistory(appId, appVnoId, resp);
			updateDepHistory(appId, appVnoId, 4, null);
			// update app status
			pcApp.setStatus(2);
			appSvc.saveOrUpdate(pcApp);
		}
		return resStr;
	}

	@Override
	public String startApp(Long appId) {
		Long appVnoId = pcAppVersionSvc.getStopedAppVersionId(appId);

		if (appVnoId == null) {
			logger.error("can't find app " + appId + " version info");
			// TODO: write some return info
			return "";
		}
		pcAppVersionSvc.updateAppVersionStatusById(appVnoId, 2);
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		PcApp pcApp = appSvc.queryById(appId);

		GeneralReq generalReq = new GeneralReq();
		generalReq.setAppId(pcApp.getId().toString());
		generalReq.setAppName(pcApp.getAppCode());
		generalReq.setAppNameCN(pcApp.getAppName());
		generalReq.setClusterId(pcApp.getResCenterId().toString());
		List<Container> containers = new ArrayList<Container>();
		for (AppImageSettings setting : appImageList) {
			Container container = new Container();
			container.setContainerId(setting.getAppImage().getId().toString());
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
			container.setInstances(setting.getAppImage().getInstanceCount());
			containers.add(container);
		}
		generalReq.setContainers(containers);
		String resStr = iDeployServiceManager.start(JSON.toString(generalReq));
		logger.info("start app return " + resStr);
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			writeTaskLog(appId, appVnoId, resp, ActionType.start);
			//writeAppDepHistory(appId, appVnoId, resp);
			writeAppDepHistory(appId, appVnoId, resp, 2);
			// update app status
			pcApp.setStatus(2);
			appSvc.saveOrUpdate(pcApp);
		}
		return resStr;
	}

	
	@Override
	public String pauseApp(Long appId) {
		Long appVnoId = pcAppVersionSvc.getRunningAppVersionId(appId);
		if (appVnoId == null) {
			logger.error("can't find app " + appId + " version info");
			// TODO: write some return info
			return "";
		}
		pcAppVersionSvc.updateAppVersionStatusById(appVnoId, 3);
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		PcApp pcApp = appSvc.queryById(appId);

		GeneralReq generalReq = new GeneralReq();
		generalReq.setAppId(pcApp.getId().toString());
		generalReq.setAppName(pcApp.getAppCode());
		generalReq.setAppNameCN(pcApp.getAppName());
		generalReq.setClusterId(pcApp.getResCenterId().toString());
		List<Container> containers = new ArrayList<Container>();
		for (AppImageSettings setting : appImageList) {
			Container container = new Container();
			container.setContainerId(setting.getAppImage().getId().toString());
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
			container.setInstances(0);
			containers.add(container);
		}
		generalReq.setContainers(containers);
		String resStr = iDeployServiceManager.stop(JSON.toString(generalReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			writeTaskLog(appId, appVnoId, resp, ActionType.stop);
			//writeAppDepHistory(appId, appVnoId, resp);
			updateDepHistory(appId, appVnoId, 4, 3);
			// update app status
			pcApp.setStatus(2);
			appSvc.saveOrUpdate(pcApp);
		}
		return resStr;
	}

	@Override
	public String fetchLog(Long appId, Long reqId, Long time) {
		LogReq logReq = new LogReq();
		logReq.setReqId(reqId.intValue());
		logReq.setLastFetchTime(time);
		String resp = iDeployServiceManager.log(JSON.toString(logReq));
		return resp;
	}

	@Override
	public String appStatus(Long appId) {
		Long appVnoId = pcAppVersionSvc.getRunningAppVersionId(appId);
		if (appVnoId == null)
			appVnoId = pcAppVersionSvc.getStopedAppVersionId(appId);
		if (appVnoId == null) {
			logger.error("can't find app " + appId + " version info");
			// TODO: write some return info
			return "";
		}
		GeneralReq generalReq = new GeneralReq();
		PcApp pcApp = appSvc.queryById(appId);
		generalReq.setAppId(appId + "");
		generalReq.setClusterId(pcApp.getResCenterId() + "");
		List<GeneralReq.Container> containers = new ArrayList<>();
		List<AppImageSettings> settings = getAppImageSettingsList(appId, appVnoId);
		for (AppImageSettings setting : settings) {
			if (setting.getAppImage() != null) {
				GeneralReq.Container container = new GeneralReq.Container();
				container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
				containers.add(container);
			}
		}
		generalReq.setContainers(containers);
		String resStr = iDeployServiceManager.status(JSON.toString(generalReq));
		return resStr;
	}

	@Override
	public String startTimerDeploy(Long appId, Long appVnoId) {
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);

		PcApp pcApp = appSvc.queryById(appId);
		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setAppId(appId + "");

		generalTimerReq.setAppName(pcApp.getAppCode());
		generalTimerReq.setAppNameCN(pcApp.getAppName());
		generalTimerReq.setClusterId(pcApp.getResCenterId().toString());
		generalTimerReq.setDataCenterId(pcApp.getDataCenterId().toString());
		// set default commond & retries
		generalTimerReq.setRetries(0);
		generalTimerReq.setCommond("");
		GeneralTimerReq.Container container = new GeneralTimerReq.Container();
		for (AppImageSettings setting : appImageList) {
			container.setContainerId(setting.getAppImage().getId().toString());
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
			container.setZoneId(setting.getAppImage().getNetZoneId().toString());
			generalTimerReq.setStart(setting.getAppImage().getTimerStartTime() + "");
			generalTimerReq.setPeriod("T" + setting.getAppImage().getTimerExp() + "S");
			// List<Parameter> attrs = new ArrayList<Parameter>();
			// List<PcKvPair> paramList = setting.getParams();
			// for (PcKvPair pair : paramList) {
			// Parameter pa = new Parameter();
			// pa.setKey(pair.getKvKey());
			// pa.setValue(pair.getKvVal());
			// }
			List<PcAppImage> dependList = setting.getDependImages();

			List<String> containeIdList = new ArrayList<String>();
			for (PcAppImage image : dependList) {
				containeIdList.add(image.getId().toString());
			}
			PcImage image = setting.getImage();
			container.setImgFullName(image.getImageName());
			// crontainer.setDepends(containeIdList.toArray().toString());
			container.setCpu("" + setting.getAppImage().getCpuCount() / 100.0);
			container.setMem("" + Integer.parseInt(setting.getAppImage().getMemSize().toString()));
			// 硬盘大小单位是GB 需要转换成MB X1024
			container.setDisk("" + Integer.parseInt(setting.getAppImage().getDiskSize().toString()) * 1024);

			// List<For> servicesFor = new ArrayList<For>();
			List<AppImageSvcInfo> callServiceList = setting.getCallServices();
			for (AppImageSvcInfo imageSvcInfo : callServiceList) {
				imageSvcInfo.getSvc();
			}

			container.setLogDir(setting.getAppImage().getLogMpPath());
			container.setDataDir(setting.getAppImage().getDataMpPath());
			break;
		}
		generalTimerReq.setContainer(container);

		String resStr = iDeployServiceManager.createTimer(JSON.toString(generalTimerReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		PcAppTask pcAppTask = writeTaskLog(appId, appVnoId, resp, ActionType.deploy);
		writeAppDepHistory(appId, appVnoId, resp);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			// update app status
			pcApp.setStatus(3);
			pcAppTask.setStatus(3);
			pcAppVersionSvc.updateAppVersionStatusById(appVnoId, 2);
		} else {
			pcApp.setStatus(5);
			pcAppTask.setStatus(4);
		}
		pcAppTask.setTaskEndTime(BinaryUtils.getNumberDateTime());
		appSvc.saveOrUpdate(pcApp);
		pcAppTaskSvc.update(pcAppTask);
		return resStr;
	}

	@Override
	public String reDeployTimer(Long appId, Long appVnoId) {
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);

		PcApp pcApp = appSvc.queryById(appId);
		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setAppId(appId + "");
		generalTimerReq.setAppName(pcApp.getAppCode());
		generalTimerReq.setAppNameCN(pcApp.getAppName());
		generalTimerReq.setClusterId(pcApp.getResCenterId().toString());
		generalTimerReq.setDataCenterId(pcApp.getDataCenterId().toString());
		generalTimerReq.setRetries(0);
		generalTimerReq.setCommond("");
		GeneralTimerReq.Container container = new GeneralTimerReq.Container();
		for (AppImageSettings setting : appImageList) {
			container.setContainerId(setting.getAppImage().getId().toString());
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
			container.setZoneId(setting.getAppImage().getNetZoneId().toString());
			generalTimerReq.setStart(setting.getAppImage().getTimerStartTime() + "");
			generalTimerReq.setPeriod("T" + setting.getAppImage().getTimerExp() + "S");

			List<PcAppImage> dependList = setting.getDependImages();
			List<String> containeIdList = new ArrayList<String>();
			for (PcAppImage image : dependList) {
				containeIdList.add(image.getId().toString());
			}
			PcImage image = setting.getImage();
			container.setImgFullName(image.getImageName());
			// crontainer.setDepends(containeIdList.toArray().toString());
			container.setCpu("" + setting.getAppImage().getCpuCount() / 100.0);
			container.setMem("" + Integer.parseInt(setting.getAppImage().getMemSize().toString()));
			// 硬盘大小单位是GB 需要转换成MB X1024
			container.setDisk("" + Integer.parseInt(setting.getAppImage().getDiskSize().toString()) * 1024);

			// List<For> servicesFor = new ArrayList<For>();
			List<AppImageSvcInfo> callServiceList = setting.getCallServices();
			for (AppImageSvcInfo imageSvcInfo : callServiceList) {
				imageSvcInfo.getSvc();
			}

			container.setLogDir(setting.getAppImage().getLogMpPath());
			container.setDataDir(setting.getAppImage().getDataMpPath());
			break;
		}
		generalTimerReq.setContainer(container);

		String resStr = iDeployServiceManager.upgradeTimer(JSON.toString(generalTimerReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		PcAppTask pcAppTask = writeTaskLog(appId, appVnoId, resp, ActionType.upgrade);
		writeAppDepHistory(appId, appVnoId, resp);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			// update app status
			pcAppTask.setStatus(3);
		} else {
			pcAppTask.setStatus(4);
		}
		pcAppTask.setTaskEndTime(BinaryUtils.getNumberDateTime());
		pcAppTaskSvc.update(pcAppTask);
		return resStr;
	}

	@Override
	public String destroyDeployTimer(Long appId) {
		Long appVnoId = pcAppVersionSvc.getRunningAppVersionId(appId);
		if (appVnoId == null)
			appVnoId = pcAppVersionSvc.getStopedAppVersionId(appId);
		if (appVnoId == null) {
			logger.error("can't find app " + appId + " version info");
			// TODO: write some return info
			return "";
		}
		PcApp pcApp = appSvc.queryById(appId);

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setAppId(appId + "");
		generalTimerReq.setAppName(pcApp.getAppCode());
		generalTimerReq.setAppNameCN(pcApp.getAppName());
		generalTimerReq.setClusterId(pcApp.getResCenterId().toString());
		generalTimerReq.setDataCenterId(pcApp.getDataCenterId().toString());
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		GeneralTimerReq.Container container = new GeneralTimerReq.Container();
		for (AppImageSettings setting : appImageList) {
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
		}
		generalTimerReq.setContainer(container);

		String resStr = iDeployServiceManager.destroyTimer(JSON.toString(generalTimerReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		PcAppTask pcAppTask = writeTaskLog(appId, appVnoId, resp, ActionType.destroy);
		writeAppDepHistory(appId, appVnoId, resp);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			// update app status
			pcApp.setStatus(1);
			pcAppTask.setStatus(3);
			pcAppVersionSvc.updateAppVersionStatusById(appVnoId, 1);
		} else {
			pcApp.setStatus(5);
			pcAppTask.setStatus(4);
		}
		pcAppTask.setTaskEndTime(BinaryUtils.getNumberDateTime());
		appSvc.saveOrUpdate(pcApp);
		pcAppTaskSvc.update(pcAppTask);
		return resStr;
	}

	@Override
	public String starTimertApp(Long appId) {
		Long appVnoId = pcAppVersionSvc.getStopedAppVersionId(appId);
		if (appVnoId == null) {
			logger.error("can't find app " + appId + " version info");
			// TODO: write some return info
			return "";
		}
		PcApp pcApp = appSvc.queryById(appId);

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setAppId(appId + "");
		generalTimerReq.setAppName(pcApp.getAppCode());
		generalTimerReq.setAppNameCN(pcApp.getAppName());
		generalTimerReq.setClusterId(pcApp.getResCenterId().toString());
		generalTimerReq.setDataCenterId(pcApp.getDataCenterId().toString());
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		GeneralTimerReq.Container container = new GeneralTimerReq.Container();
		for (AppImageSettings setting : appImageList) {
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
		}
		generalTimerReq.setContainer(container);

		String resStr = iDeployServiceManager.startTimer(JSON.toString(generalTimerReq));
		GeneralDeployResp resp = JSON.toObject(resStr, GeneralDeployResp.class);
		PcAppTask pcAppTask = writeTaskLog(appId, appVnoId, resp, ActionType.start);
		writeAppDepHistory(appId, appVnoId, resp);
		if (GeneralDeployResp.SUCCESS.equals(resp.getResultCode())) {
			// update app status
			pcAppTask.setStatus(3);
		} else {
			pcAppTask.setStatus(4);
		}
		pcAppTask.setTaskEndTime(BinaryUtils.getNumberDateTime());
		pcAppTaskSvc.update(pcAppTask);
		return resStr;
	}

	@Override
	public String appTimerStatus(Long appId) {
		Long appVnoId = pcAppVersionSvc.getRunningAppVersionId(appId);
		if (appVnoId == null)
			appVnoId = pcAppVersionSvc.getStopedAppVersionId(appId);
		if (appVnoId == null) {
			logger.error("can't find app " + appId + " version info");
			// TODO: write some return info
			return "";
		}
		PcApp pcApp = appSvc.queryById(appId);

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setAppId(appId + "");
		generalTimerReq.setAppName(pcApp.getAppCode());
		generalTimerReq.setAppNameCN(pcApp.getAppName());
		generalTimerReq.setClusterId(pcApp.getResCenterId().toString());
		generalTimerReq.setDataCenterId(pcApp.getDataCenterId().toString());
		List<AppImageSettings> appImageList = getAppImageSettingsList(appId, appVnoId);
		GeneralTimerReq.Container container = new GeneralTimerReq.Container();
		for (AppImageSettings setting : appImageList) {
			container.setContainerName(setting.getAppImage().getContainerFullName().toLowerCase());
		}
		generalTimerReq.setContainer(container);

		String resStr = iDeployServiceManager.statusTimer(JSON.toString(generalTimerReq));
		return resStr;
	}

}

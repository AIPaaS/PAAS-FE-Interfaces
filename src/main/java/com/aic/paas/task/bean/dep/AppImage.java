package com.aic.paas.task.bean.dep;


public class AppImage extends PcAppImage{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 镜像定义ID
	 */
	private Long imageDefId;
	
	/**
	 * 镜像库ID
	 */
	private Long imageRespId;
	
	/**
	 * 镜像名
	 */
	private String imageName;
	
	/**
	 * 镜像全名
	 */
	private String imageFullName;
	
	/**
	 * build号
	 */
	private String buildNo;
	
	
	
	/**
	 * 部署状态1=就绪 2=部署中 3=部署成功 4=部署失败
	 */
	private Integer depStatus;
	
	/**
	 * 运行状态1=待运行 2=运行中 3=停止
	 */
	private Integer runStatus;
	
	

	public Long getImageDefId() {
		return imageDefId;
	}

	public void setImageDefId(Long imageDefId) {
		this.imageDefId = imageDefId;
	}

	public Long getImageRespId() {
		return imageRespId;
	}

	public void setImageRespId(Long imageRespId) {
		this.imageRespId = imageRespId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageFullName() {
		return imageFullName;
	}

	public void setImageFullName(String imageFullName) {
		this.imageFullName = imageFullName;
	}

	public String getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

	public Integer getDepStatus() {
		return depStatus;
	}

	public void setDepStatus(Integer depStatus) {
		this.depStatus = depStatus;
	}

	public Integer getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(Integer runStatus) {
		this.runStatus = runStatus;
	}
	
	
	
}

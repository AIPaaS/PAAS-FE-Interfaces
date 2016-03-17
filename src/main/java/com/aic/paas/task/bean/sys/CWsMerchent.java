package com.aic.paas.task.bean.sys;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 租户信息表[WS_MERCHENT]
 */
public class CWsMerchent implements Condition {
	private static final long serialVersionUID = 1L;


	/**
	 * condition-field: ID[ID] operate-Equal[=]
	 * 对应组织ID
	 */
	private Long id;


	/**
	 * condition-field: ID[ID] operate-In[in]
	 * 对应组织ID
	 */
	private Long[] ids;


	/**
	 * condition-field: ID[ID] operate-GTEqual[>=]
	 * 对应组织ID
	 */
	private Long startId;

	/**
	 * condition-field: ID[ID] operate-LTEqual[<=]
	 * 对应组织ID
	 */
	private Long endId;


	/**
	 * condition-field: 租户代码[MNT_CODE] operate-Like[like]
	 */
	private String mntCode;


	/**
	 * condition-field: 租户代码[MNT_CODE] operate-Equal[=]
	 */
	private String mntCodeEqual;


	/**
	 * condition-field: 租户代码[MNT_CODE] operate-In[in]
	 */
	private String[] mntCodes;


	/**
	 * condition-field: 租户名称[MNT_NAME] operate-Like[like]
	 */
	private String mntName;


	/**
	 * condition-field: 登录密码[MNT_PWD] operate-Like[like]
	 */
	private String mntPwd;


	/**
	 * condition-field: 登录密码[MNT_PWD] operate-Equal[=]
	 */
	private String mntPwdEqual;


	/**
	 * condition-field: 登录密码[MNT_PWD] operate-In[in]
	 */
	private String[] mntPwds;


	/**
	 * condition-field: 成本中心编码[CC_CODE] operate-Like[like]
	 */
	private String ccCode;


	/**
	 * condition-field: 成本中心编码[CC_CODE] operate-Equal[=]
	 */
	private String ccCodeEqual;


	/**
	 * condition-field: 成本中心编码[CC_CODE] operate-In[in]
	 */
	private String[] ccCodes;


	/**
	 * condition-field: 联系人姓名[CONTACT_NAME] operate-Like[like]
	 */
	private String contactName;


	/**
	 * condition-field: 联系人姓名[CONTACT_NAME] operate-Equal[=]
	 */
	private String contactNameEqual;


	/**
	 * condition-field: 联系人姓名[CONTACT_NAME] operate-In[in]
	 */
	private String[] contactNames;


	/**
	 * condition-field: 联系人电话[CONTACT_PHONE] operate-Like[like]
	 */
	private String contactPhone;


	/**
	 * condition-field: 联系人电话[CONTACT_PHONE] operate-Equal[=]
	 */
	private String contactPhoneEqual;


	/**
	 * condition-field: 联系人电话[CONTACT_PHONE] operate-In[in]
	 */
	private String[] contactPhones;


	/**
	 * condition-field: 联系人电话2[CONTACT_PHONE2] operate-Like[like]
	 */
	private String contactPhone2;


	/**
	 * condition-field: 联系人电话2[CONTACT_PHONE2] operate-Equal[=]
	 */
	private String contactPhone2Equal;


	/**
	 * condition-field: 联系人电话2[CONTACT_PHONE2] operate-In[in]
	 */
	private String[] contactPhone2s;


	/**
	 * condition-field: 联系人邮箱[CONTACT_EMAIL] operate-Like[like]
	 */
	private String contactEmail;


	/**
	 * condition-field: 租户状态[STATUS] operate-Equal[=]
	 * 0=新建 1=审核通过 2=审核退回
	 */
	private Integer status;


	/**
	 * condition-field: 租户状态[STATUS] operate-In[in]
	 * 0=新建 1=审核通过 2=审核退回
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 租户状态[STATUS] operate-GTEqual[>=]
	 * 0=新建 1=审核通过 2=审核退回
	 */
	private Integer startStatus;

	/**
	 * condition-field: 租户状态[STATUS] operate-LTEqual[<=]
	 * 0=新建 1=审核通过 2=审核退回
	 */
	private Integer endStatus;


	/**
	 * condition-field: 审核人ID[CHECKER_ID] operate-Equal[=]
	 */
	private Long checkerId;


	/**
	 * condition-field: 审核人ID[CHECKER_ID] operate-In[in]
	 */
	private Long[] checkerIds;


	/**
	 * condition-field: 审核人ID[CHECKER_ID] operate-GTEqual[>=]
	 */
	private Long startCheckerId;

	/**
	 * condition-field: 审核人ID[CHECKER_ID] operate-LTEqual[<=]
	 */
	private Long endCheckerId;


	/**
	 * condition-field: 审核人姓名[CHECKER_NAME] operate-Like[like]
	 */
	private String checkerName;


	/**
	 * condition-field: 审核人姓名[CHECKER_NAME] operate-Equal[=]
	 */
	private String checkerNameEqual;


	/**
	 * condition-field: 审核人姓名[CHECKER_NAME] operate-In[in]
	 */
	private String[] checkerNames;


	/**
	 * condition-field: 审核时间[CHECK_TIME] operate-Equal[=]
	 */
	private Long checkTime;


	/**
	 * condition-field: 审核时间[CHECK_TIME] operate-In[in]
	 */
	private Long[] checkTimes;


	/**
	 * condition-field: 审核时间[CHECK_TIME] operate-GTEqual[>=]
	 */
	private Long startCheckTime;

	/**
	 * condition-field: 审核时间[CHECK_TIME] operate-LTEqual[<=]
	 */
	private Long endCheckTime;


	/**
	 * condition-field: 审核意见[CHECK_DESC] operate-Like[like]
	 */
	private String checkDesc;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-Equal[=]
	 */
	private Long custom1;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-In[in]
	 */
	private Long[] custom1s;


	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-GTEqual[>=]
	 */
	private Long startCustom1;

	/**
	 * condition-field: 备用字段_1[CUSTOM_1] operate-LTEqual[<=]
	 */
	private Long endCustom1;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-Equal[=]
	 */
	private Long custom2;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-In[in]
	 */
	private Long[] custom2s;


	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-GTEqual[>=]
	 */
	private Long startCustom2;

	/**
	 * condition-field: 备用字段_2[CUSTOM_2] operate-LTEqual[<=]
	 */
	private Long endCustom2;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-Equal[=]
	 */
	private Long custom3;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-In[in]
	 */
	private Long[] custom3s;


	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-GTEqual[>=]
	 */
	private Long startCustom3;

	/**
	 * condition-field: 备用字段_3[CUSTOM_3] operate-LTEqual[<=]
	 */
	private Long endCustom3;


	/**
	 * condition-field: 备用字段_4[CUSTOM_4] operate-Like[like]
	 */
	private String custom4;


	/**
	 * condition-field: 备用字段_5[CUSTOM_5] operate-Like[like]
	 */
	private String custom5;


	/**
	 * condition-field: 备用字段_6[CUSTOM_6] operate-Like[like]
	 */
	private String custom6;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-Equal[=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-In[in]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer[] dataStatuss;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-GTEqual[>=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer startDataStatus;

	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-LTEqual[<=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer endDataStatus;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] createTimes;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startCreateTime;

	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endCreateTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] modifyTimes;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startModifyTime;

	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endModifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Long[] getIds() {
		return this.ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}


	public Long getStartId() {
		return this.startId;
	}
	public void setStartId(Long startId) {
		this.startId = startId;
	}


	public Long getEndId() {
		return this.endId;
	}
	public void setEndId(Long endId) {
		this.endId = endId;
	}


	public String getMntCode() {
		return this.mntCode;
	}
	public void setMntCode(String mntCode) {
		this.mntCode = mntCode;
	}


	public String getMntCodeEqual() {
		return this.mntCodeEqual;
	}
	public void setMntCodeEqual(String mntCodeEqual) {
		this.mntCodeEqual = mntCodeEqual;
	}


	public String[] getMntCodes() {
		return this.mntCodes;
	}
	public void setMntCodes(String[] mntCodes) {
		this.mntCodes = mntCodes;
	}


	public String getMntName() {
		return this.mntName;
	}
	public void setMntName(String mntName) {
		this.mntName = mntName;
	}


	public String getMntPwd() {
		return this.mntPwd;
	}
	public void setMntPwd(String mntPwd) {
		this.mntPwd = mntPwd;
	}


	public String getMntPwdEqual() {
		return this.mntPwdEqual;
	}
	public void setMntPwdEqual(String mntPwdEqual) {
		this.mntPwdEqual = mntPwdEqual;
	}


	public String[] getMntPwds() {
		return this.mntPwds;
	}
	public void setMntPwds(String[] mntPwds) {
		this.mntPwds = mntPwds;
	}


	public String getCcCode() {
		return this.ccCode;
	}
	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}


	public String getCcCodeEqual() {
		return this.ccCodeEqual;
	}
	public void setCcCodeEqual(String ccCodeEqual) {
		this.ccCodeEqual = ccCodeEqual;
	}


	public String[] getCcCodes() {
		return this.ccCodes;
	}
	public void setCcCodes(String[] ccCodes) {
		this.ccCodes = ccCodes;
	}


	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getContactNameEqual() {
		return this.contactNameEqual;
	}
	public void setContactNameEqual(String contactNameEqual) {
		this.contactNameEqual = contactNameEqual;
	}


	public String[] getContactNames() {
		return this.contactNames;
	}
	public void setContactNames(String[] contactNames) {
		this.contactNames = contactNames;
	}


	public String getContactPhone() {
		return this.contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


	public String getContactPhoneEqual() {
		return this.contactPhoneEqual;
	}
	public void setContactPhoneEqual(String contactPhoneEqual) {
		this.contactPhoneEqual = contactPhoneEqual;
	}


	public String[] getContactPhones() {
		return this.contactPhones;
	}
	public void setContactPhones(String[] contactPhones) {
		this.contactPhones = contactPhones;
	}


	public String getContactPhone2() {
		return this.contactPhone2;
	}
	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}


	public String getContactPhone2Equal() {
		return this.contactPhone2Equal;
	}
	public void setContactPhone2Equal(String contactPhone2Equal) {
		this.contactPhone2Equal = contactPhone2Equal;
	}


	public String[] getContactPhone2s() {
		return this.contactPhone2s;
	}
	public void setContactPhone2s(String[] contactPhone2s) {
		this.contactPhone2s = contactPhone2s;
	}


	public String getContactEmail() {
		return this.contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer[] getStatuss() {
		return this.statuss;
	}
	public void setStatuss(Integer[] statuss) {
		this.statuss = statuss;
	}


	public Integer getStartStatus() {
		return this.startStatus;
	}
	public void setStartStatus(Integer startStatus) {
		this.startStatus = startStatus;
	}


	public Integer getEndStatus() {
		return this.endStatus;
	}
	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
	}


	public Long getCheckerId() {
		return this.checkerId;
	}
	public void setCheckerId(Long checkerId) {
		this.checkerId = checkerId;
	}


	public Long[] getCheckerIds() {
		return this.checkerIds;
	}
	public void setCheckerIds(Long[] checkerIds) {
		this.checkerIds = checkerIds;
	}


	public Long getStartCheckerId() {
		return this.startCheckerId;
	}
	public void setStartCheckerId(Long startCheckerId) {
		this.startCheckerId = startCheckerId;
	}


	public Long getEndCheckerId() {
		return this.endCheckerId;
	}
	public void setEndCheckerId(Long endCheckerId) {
		this.endCheckerId = endCheckerId;
	}


	public String getCheckerName() {
		return this.checkerName;
	}
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}


	public String getCheckerNameEqual() {
		return this.checkerNameEqual;
	}
	public void setCheckerNameEqual(String checkerNameEqual) {
		this.checkerNameEqual = checkerNameEqual;
	}


	public String[] getCheckerNames() {
		return this.checkerNames;
	}
	public void setCheckerNames(String[] checkerNames) {
		this.checkerNames = checkerNames;
	}


	public Long getCheckTime() {
		return this.checkTime;
	}
	public void setCheckTime(Long checkTime) {
		this.checkTime = checkTime;
	}


	public Long[] getCheckTimes() {
		return this.checkTimes;
	}
	public void setCheckTimes(Long[] checkTimes) {
		this.checkTimes = checkTimes;
	}


	public Long getStartCheckTime() {
		return this.startCheckTime;
	}
	public void setStartCheckTime(Long startCheckTime) {
		this.startCheckTime = startCheckTime;
	}


	public Long getEndCheckTime() {
		return this.endCheckTime;
	}
	public void setEndCheckTime(Long endCheckTime) {
		this.endCheckTime = endCheckTime;
	}


	public String getCheckDesc() {
		return this.checkDesc;
	}
	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}


	public Long getCustom1() {
		return this.custom1;
	}
	public void setCustom1(Long custom1) {
		this.custom1 = custom1;
	}


	public Long[] getCustom1s() {
		return this.custom1s;
	}
	public void setCustom1s(Long[] custom1s) {
		this.custom1s = custom1s;
	}


	public Long getStartCustom1() {
		return this.startCustom1;
	}
	public void setStartCustom1(Long startCustom1) {
		this.startCustom1 = startCustom1;
	}


	public Long getEndCustom1() {
		return this.endCustom1;
	}
	public void setEndCustom1(Long endCustom1) {
		this.endCustom1 = endCustom1;
	}


	public Long getCustom2() {
		return this.custom2;
	}
	public void setCustom2(Long custom2) {
		this.custom2 = custom2;
	}


	public Long[] getCustom2s() {
		return this.custom2s;
	}
	public void setCustom2s(Long[] custom2s) {
		this.custom2s = custom2s;
	}


	public Long getStartCustom2() {
		return this.startCustom2;
	}
	public void setStartCustom2(Long startCustom2) {
		this.startCustom2 = startCustom2;
	}


	public Long getEndCustom2() {
		return this.endCustom2;
	}
	public void setEndCustom2(Long endCustom2) {
		this.endCustom2 = endCustom2;
	}


	public Long getCustom3() {
		return this.custom3;
	}
	public void setCustom3(Long custom3) {
		this.custom3 = custom3;
	}


	public Long[] getCustom3s() {
		return this.custom3s;
	}
	public void setCustom3s(Long[] custom3s) {
		this.custom3s = custom3s;
	}


	public Long getStartCustom3() {
		return this.startCustom3;
	}
	public void setStartCustom3(Long startCustom3) {
		this.startCustom3 = startCustom3;
	}


	public Long getEndCustom3() {
		return this.endCustom3;
	}
	public void setEndCustom3(Long endCustom3) {
		this.endCustom3 = endCustom3;
	}


	public String getCustom4() {
		return this.custom4;
	}
	public void setCustom4(String custom4) {
		this.custom4 = custom4;
	}


	public String getCustom5() {
		return this.custom5;
	}
	public void setCustom5(String custom5) {
		this.custom5 = custom5;
	}


	public String getCustom6() {
		return this.custom6;
	}
	public void setCustom6(String custom6) {
		this.custom6 = custom6;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public Integer[] getDataStatuss() {
		return this.dataStatuss;
	}
	public void setDataStatuss(Integer[] dataStatuss) {
		this.dataStatuss = dataStatuss;
	}


	public Integer getStartDataStatus() {
		return this.startDataStatus;
	}
	public void setStartDataStatus(Integer startDataStatus) {
		this.startDataStatus = startDataStatus;
	}


	public Integer getEndDataStatus() {
		return this.endDataStatus;
	}
	public void setEndDataStatus(Integer endDataStatus) {
		this.endDataStatus = endDataStatus;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long[] getCreateTimes() {
		return this.createTimes;
	}
	public void setCreateTimes(Long[] createTimes) {
		this.createTimes = createTimes;
	}


	public Long getStartCreateTime() {
		return this.startCreateTime;
	}
	public void setStartCreateTime(Long startCreateTime) {
		this.startCreateTime = startCreateTime;
	}


	public Long getEndCreateTime() {
		return this.endCreateTime;
	}
	public void setEndCreateTime(Long endCreateTime) {
		this.endCreateTime = endCreateTime;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


	public Long[] getModifyTimes() {
		return this.modifyTimes;
	}
	public void setModifyTimes(Long[] modifyTimes) {
		this.modifyTimes = modifyTimes;
	}


	public Long getStartModifyTime() {
		return this.startModifyTime;
	}
	public void setStartModifyTime(Long startModifyTime) {
		this.startModifyTime = startModifyTime;
	}


	public Long getEndModifyTime() {
		return this.endModifyTime;
	}
	public void setEndModifyTime(Long endModifyTime) {
		this.endModifyTime = endModifyTime;
	}


}



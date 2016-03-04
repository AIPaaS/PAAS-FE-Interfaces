package com.aic.paas.task.bean.sys;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 操作员表[SYS_OP]
 */
public class SysOp implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 操作员编码[OP_CODE]
	 */
	private String opCode;


	/**
	 * mapping-field: 操作员姓名[OP_NAME]
	 */
	private String opName;


	/**
	 * mapping-field: 操作员类别[OP_KIND]
	 * 0-超级管理员 1-管理员 2-普通用户
	 */
	private Integer opKind;


	/**
	 * mapping-field: 手机号[MOBILE_NO]
	 */
	private String mobileNo;


	/**
	 * mapping-field: 电子邮件地址[EMAIL_ADRESS]
	 */
	private String emailAdress;


	/**
	 * mapping-field: 操作员级别[OP_LEVEL]
	 * 1-一级（正主管） 2-二级（副主管） 9-普通员工
	 */
	private Integer opLevel;


	/**
	 * mapping-field: 上级操作员ID[SUP_OP_ID]
	 */
	private Long supOpId;


	/**
	 * mapping-field: 登录工号[LOGIN_CODE]
	 */
	private String loginCode;


	/**
	 * mapping-field: 登录密码[LOGIN_PASSWD]
	 */
	private String loginPasswd;


	/**
	 * mapping-field: 简称[SHORT_NAME]
	 */
	private String shortName;


	/**
	 * mapping-field: 英文名[ENGLISH_NAME]
	 */
	private String englishName;


	/**
	 * mapping-field: 证件类型[CARD_TYPE_ID]
	 */
	private Integer cardTypeId;


	/**
	 * mapping-field: 证件号码[CARD_NO]
	 */
	private String cardNo;


	/**
	 * mapping-field: 生日[BIRTHDAY]
	 * yyyyMMdd
	 */
	private Integer birthday;


	/**
	 * mapping-field: 婚姻状况[MARRY_STATUS]
	 * 0-未婚 1-已婚 对应sys_static_data表code_type=10101
	 */
	private Integer marryStatus;


	/**
	 * mapping-field: 性别[GENDER]
	 * 1-男 2-女
	 */
	private Integer gender;


	/**
	 * mapping-field: 宗教信仰[RELIGION]
	 */
	private Integer religion;


	/**
	 * mapping-field: 民族[NATIONAL_TYPE]
	 */
	private Integer nationalType;


	/**
	 * mapping-field: 学历[EDUCATION_LEVEL]
	 */
	private Integer educationLevel;


	/**
	 * mapping-field: 收入[INCOME_LEVEL]
	 */
	private Long incomeLevel;


	/**
	 * mapping-field: 政治面貌[POLITICS_FACE]
	 */
	private Integer politicsFace;


	/**
	 * mapping-field: 办公电话[OFFICE_TEL]
	 */
	private String officeTel;


	/**
	 * mapping-field: 传真号[FAX_ID]
	 */
	private String faxId;


	/**
	 * mapping-field: 家庭电话[HOME_TEL]
	 */
	private String homeTel;


	/**
	 * mapping-field: 无限寻呼[WIRELESS_CALL]
	 */
	private String wirelessCall;


	/**
	 * mapping-field: 告警手机号[ALARM_MOBILE_NO]
	 */
	private String alarmMobileNo;


	/**
	 * mapping-field: 亲属信息[FAMILY_INFO]
	 */
	private String familyInfo;


	/**
	 * mapping-field: 联系地址[CONTACT_ADDRESS]
	 */
	private String contactAddress;


	/**
	 * mapping-field: 邮政编码[POSTAL_CODE]
	 */
	private Integer postalCode;


	/**
	 * mapping-field: 社保卡号[SECURITY_ID]
	 */
	private String securityId;


	/**
	 * mapping-field: 车牌号码[CAR_NO]
	 */
	private String carNo;


	/**
	 * mapping-field: 性格特点[CHARACTER_DESC]
	 */
	private String characterDesc;


	/**
	 * mapping-field: 备注[NOTES]
	 */
	private String notes;


	/**
	 * mapping-field: 最近使用密码[RECENT_PASSWORD]
	 */
	private String recentPassword;


	/**
	 * mapping-field: 最近使用密码次数[RECENT_PASS_TIMES]
	 */
	private Integer recentPassTimes;


	/**
	 * mapping-field: 最小密码长度[MIN_PASSWD_LENGTH]
	 */
	private Integer minPasswdLength;


	/**
	 * mapping-field: 是否允许修改密码[ALLOW_CHANGE_PASSWD]
	 */
	private Integer allowChangePasswd;


	/**
	 * mapping-field: 账号生效日期[ACCT_EFFECT_DATE]
	 * yyyyMMddHHmmss
	 */
	private Long acctEffectDate;


	/**
	 * mapping-field: 账号失效日期[ACCT_EXPIRE_DATE]
	 * yyyyMMddHHmmss
	 */
	private Long acctExpireDate;


	/**
	 * mapping-field: 多重登录标志[MULTI_LOGIN_FLAG]
	 */
	private Integer multiLoginFlag;


	/**
	 * mapping-field: 最后一次登录日志[LAST_LOGIN_LOG_ID]
	 */
	private Long lastLoginLogId;


	/**
	 * mapping-field: 登录尝试次数[TRY_TIMES]
	 */
	private Integer tryTimes;


	/**
	 * mapping-field: 登录标志[LOGIN_FLAG]
	 * 0-未登录 1-已登录
	 */
	private Integer loginFlag;


	/**
	 * mapping-field: 超级用户标志[SUPER_USER_FLAG]
	 * 0-否 1-是
	 */
	private Integer superUserFlag;


	/**
	 * mapping-field: 密码有效期[PASSWD_VALID_DAYS]
	 * 单位：天
	 */
	private Long passwdValidDays;


	/**
	 * mapping-field: 停止时限[CANCEL_DAYS]
	 * 单位：天 如果到了密码修改时，登陆用户还未修改密码，则过了“停止时限”后，该工号被强制回收，除非用户又修改了密码，才可以再继续使用。
	 */
	private Integer cancelDays;


	/**
	 * mapping-field: 密码生效时间[PASSWORD_VALID_DATE]
	 * yyyyMMddHHmmss
	 */
	private Long passwordValidDate;


	/**
	 * mapping-field: 密码过期提前通知[CHG_PASSWD_ALARM_DAYS]
	 */
	private Long chgPasswdAlarmDays;


	/**
	 * mapping-field: 短信校验密码[SMS_CHK_PASSWD]
	 */
	private String smsChkPasswd;


	/**
	 * mapping-field: 校验密码生效时间[CHKPW_EFFECT_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long chkpwEffectTime;


	/**
	 * mapping-field: 校验密码失效时间[CHKPW_EXPIRE_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long chkpwExpireTime;


	/**
	 * mapping-field: 锁定标志[LOCK_FLAG]
	 * 0-未锁定 1-锁定
	 */
	private Integer lockFlag;


	/**
	 * mapping-field: 是否需要修改密码[IS_UPDATE_PWD]
	 * 1=是 0=否
	 */
	private Integer isUpdatePwd;


	/**
	 * mapping-field: 登录认证代码[LOGIN_AUTH_CODE]
	 */
	private String loginAuthCode;


	/**
	 * mapping-field: 备用_1[CUSTOM_1]
	 */
	private String custom1;


	/**
	 * mapping-field: 备用_2[CUSTOM_2]
	 */
	private String custom2;


	/**
	 * mapping-field: 备用_3[CUSTOM_3]
	 */
	private String custom3;


	/**
	 * mapping-field: 备用_4[CUSTOM_4]
	 */
	private Long custom4;


	/**
	 * mapping-field: 备用_5[CUSTOM_5]
	 */
	private Long custom5;


	/**
	 * mapping-field: 备用_6[CUSTOM_6]
	 */
	private Long custom6;


	/**
	 * mapping-field: 状态[STATUS]
	 * 1-正常 0-停用
	 */
	private Integer status;


	/**
	 * mapping-field: 数据状态[DATA_STATUS]
	 * 1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建人[CREATOR]
	 */
	private String creator;


	/**
	 * mapping-field: 修改人[MODIFIER]
	 */
	private String modifier;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改时间[MODIFY_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getOpCode() {
		return this.opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}


	public String getOpName() {
		return this.opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}


	public Integer getOpKind() {
		return this.opKind;
	}
	public void setOpKind(Integer opKind) {
		this.opKind = opKind;
	}


	public String getMobileNo() {
		return this.mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmailAdress() {
		return this.emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}


	public Integer getOpLevel() {
		return this.opLevel;
	}
	public void setOpLevel(Integer opLevel) {
		this.opLevel = opLevel;
	}


	public Long getSupOpId() {
		return this.supOpId;
	}
	public void setSupOpId(Long supOpId) {
		this.supOpId = supOpId;
	}


	public String getLoginCode() {
		return this.loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}


	public String getLoginPasswd() {
		return this.loginPasswd;
	}
	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}


	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getEnglishName() {
		return this.englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}


	public Integer getCardTypeId() {
		return this.cardTypeId;
	}
	public void setCardTypeId(Integer cardTypeId) {
		this.cardTypeId = cardTypeId;
	}


	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	public Integer getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Integer birthday) {
		this.birthday = birthday;
	}


	public Integer getMarryStatus() {
		return this.marryStatus;
	}
	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}


	public Integer getGender() {
		return this.gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}


	public Integer getReligion() {
		return this.religion;
	}
	public void setReligion(Integer religion) {
		this.religion = religion;
	}


	public Integer getNationalType() {
		return this.nationalType;
	}
	public void setNationalType(Integer nationalType) {
		this.nationalType = nationalType;
	}


	public Integer getEducationLevel() {
		return this.educationLevel;
	}
	public void setEducationLevel(Integer educationLevel) {
		this.educationLevel = educationLevel;
	}


	public Long getIncomeLevel() {
		return this.incomeLevel;
	}
	public void setIncomeLevel(Long incomeLevel) {
		this.incomeLevel = incomeLevel;
	}


	public Integer getPoliticsFace() {
		return this.politicsFace;
	}
	public void setPoliticsFace(Integer politicsFace) {
		this.politicsFace = politicsFace;
	}


	public String getOfficeTel() {
		return this.officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}


	public String getFaxId() {
		return this.faxId;
	}
	public void setFaxId(String faxId) {
		this.faxId = faxId;
	}


	public String getHomeTel() {
		return this.homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}


	public String getWirelessCall() {
		return this.wirelessCall;
	}
	public void setWirelessCall(String wirelessCall) {
		this.wirelessCall = wirelessCall;
	}


	public String getAlarmMobileNo() {
		return this.alarmMobileNo;
	}
	public void setAlarmMobileNo(String alarmMobileNo) {
		this.alarmMobileNo = alarmMobileNo;
	}


	public String getFamilyInfo() {
		return this.familyInfo;
	}
	public void setFamilyInfo(String familyInfo) {
		this.familyInfo = familyInfo;
	}


	public String getContactAddress() {
		return this.contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}


	public Integer getPostalCode() {
		return this.postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}


	public String getSecurityId() {
		return this.securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}


	public String getCarNo() {
		return this.carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	public String getCharacterDesc() {
		return this.characterDesc;
	}
	public void setCharacterDesc(String characterDesc) {
		this.characterDesc = characterDesc;
	}


	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getRecentPassword() {
		return this.recentPassword;
	}
	public void setRecentPassword(String recentPassword) {
		this.recentPassword = recentPassword;
	}


	public Integer getRecentPassTimes() {
		return this.recentPassTimes;
	}
	public void setRecentPassTimes(Integer recentPassTimes) {
		this.recentPassTimes = recentPassTimes;
	}


	public Integer getMinPasswdLength() {
		return this.minPasswdLength;
	}
	public void setMinPasswdLength(Integer minPasswdLength) {
		this.minPasswdLength = minPasswdLength;
	}


	public Integer getAllowChangePasswd() {
		return this.allowChangePasswd;
	}
	public void setAllowChangePasswd(Integer allowChangePasswd) {
		this.allowChangePasswd = allowChangePasswd;
	}


	public Long getAcctEffectDate() {
		return this.acctEffectDate;
	}
	public void setAcctEffectDate(Long acctEffectDate) {
		this.acctEffectDate = acctEffectDate;
	}


	public Long getAcctExpireDate() {
		return this.acctExpireDate;
	}
	public void setAcctExpireDate(Long acctExpireDate) {
		this.acctExpireDate = acctExpireDate;
	}


	public Integer getMultiLoginFlag() {
		return this.multiLoginFlag;
	}
	public void setMultiLoginFlag(Integer multiLoginFlag) {
		this.multiLoginFlag = multiLoginFlag;
	}


	public Long getLastLoginLogId() {
		return this.lastLoginLogId;
	}
	public void setLastLoginLogId(Long lastLoginLogId) {
		this.lastLoginLogId = lastLoginLogId;
	}


	public Integer getTryTimes() {
		return this.tryTimes;
	}
	public void setTryTimes(Integer tryTimes) {
		this.tryTimes = tryTimes;
	}


	public Integer getLoginFlag() {
		return this.loginFlag;
	}
	public void setLoginFlag(Integer loginFlag) {
		this.loginFlag = loginFlag;
	}


	public Integer getSuperUserFlag() {
		return this.superUserFlag;
	}
	public void setSuperUserFlag(Integer superUserFlag) {
		this.superUserFlag = superUserFlag;
	}


	public Long getPasswdValidDays() {
		return this.passwdValidDays;
	}
	public void setPasswdValidDays(Long passwdValidDays) {
		this.passwdValidDays = passwdValidDays;
	}


	public Integer getCancelDays() {
		return this.cancelDays;
	}
	public void setCancelDays(Integer cancelDays) {
		this.cancelDays = cancelDays;
	}


	public Long getPasswordValidDate() {
		return this.passwordValidDate;
	}
	public void setPasswordValidDate(Long passwordValidDate) {
		this.passwordValidDate = passwordValidDate;
	}


	public Long getChgPasswdAlarmDays() {
		return this.chgPasswdAlarmDays;
	}
	public void setChgPasswdAlarmDays(Long chgPasswdAlarmDays) {
		this.chgPasswdAlarmDays = chgPasswdAlarmDays;
	}


	public String getSmsChkPasswd() {
		return this.smsChkPasswd;
	}
	public void setSmsChkPasswd(String smsChkPasswd) {
		this.smsChkPasswd = smsChkPasswd;
	}


	public Long getChkpwEffectTime() {
		return this.chkpwEffectTime;
	}
	public void setChkpwEffectTime(Long chkpwEffectTime) {
		this.chkpwEffectTime = chkpwEffectTime;
	}


	public Long getChkpwExpireTime() {
		return this.chkpwExpireTime;
	}
	public void setChkpwExpireTime(Long chkpwExpireTime) {
		this.chkpwExpireTime = chkpwExpireTime;
	}


	public Integer getLockFlag() {
		return this.lockFlag;
	}
	public void setLockFlag(Integer lockFlag) {
		this.lockFlag = lockFlag;
	}


	public Integer getIsUpdatePwd() {
		return this.isUpdatePwd;
	}
	public void setIsUpdatePwd(Integer isUpdatePwd) {
		this.isUpdatePwd = isUpdatePwd;
	}


	public String getLoginAuthCode() {
		return this.loginAuthCode;
	}
	public void setLoginAuthCode(String loginAuthCode) {
		this.loginAuthCode = loginAuthCode;
	}


	public String getCustom1() {
		return this.custom1;
	}
	public void setCustom1(String custom1) {
		this.custom1 = custom1;
	}


	public String getCustom2() {
		return this.custom2;
	}
	public void setCustom2(String custom2) {
		this.custom2 = custom2;
	}


	public String getCustom3() {
		return this.custom3;
	}
	public void setCustom3(String custom3) {
		this.custom3 = custom3;
	}


	public Long getCustom4() {
		return this.custom4;
	}
	public void setCustom4(Long custom4) {
		this.custom4 = custom4;
	}


	public Long getCustom5() {
		return this.custom5;
	}
	public void setCustom5(Long custom5) {
		this.custom5 = custom5;
	}


	public Long getCustom6() {
		return this.custom6;
	}
	public void setCustom6(Long custom6) {
		this.custom6 = custom6;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


}



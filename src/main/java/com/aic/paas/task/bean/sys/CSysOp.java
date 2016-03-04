package com.aic.paas.task.bean.sys;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 操作员表[SYS_OP]
 */
public class CSysOp implements Condition {
	private static final long serialVersionUID = 1L;


	/**
	 * condition-field: ID[ID] operate-Equal[=]
	 */
	private Long id;


	/**
	 * condition-field: ID[ID] operate-In[in]
	 */
	private Long[] ids;


	/**
	 * condition-field: ID[ID] operate-GTEqual[>=]
	 */
	private Long startId;

	/**
	 * condition-field: ID[ID] operate-LTEqual[<=]
	 */
	private Long endId;


	/**
	 * condition-field: 操作员编码[OP_CODE] operate-Like[like]
	 */
	private String opCode;


	/**
	 * condition-field: 操作员编码[OP_CODE] operate-Equal[=]
	 */
	private String opCodeEqual;


	/**
	 * condition-field: 操作员编码[OP_CODE] operate-In[in]
	 */
	private String[] opCodes;


	/**
	 * condition-field: 操作员姓名[OP_NAME] operate-Like[like]
	 */
	private String opName;


	/**
	 * condition-field: 操作员类别[OP_KIND] operate-Equal[=]
	 * 0-超级管理员 1-管理员 2-普通用户
	 */
	private Integer opKind;


	/**
	 * condition-field: 操作员类别[OP_KIND] operate-In[in]
	 * 0-超级管理员 1-管理员 2-普通用户
	 */
	private Integer[] opKinds;


	/**
	 * condition-field: 操作员类别[OP_KIND] operate-GTEqual[>=]
	 * 0-超级管理员 1-管理员 2-普通用户
	 */
	private Integer startOpKind;

	/**
	 * condition-field: 操作员类别[OP_KIND] operate-LTEqual[<=]
	 * 0-超级管理员 1-管理员 2-普通用户
	 */
	private Integer endOpKind;


	/**
	 * condition-field: 手机号[MOBILE_NO] operate-Like[like]
	 */
	private String mobileNo;


	/**
	 * condition-field: 手机号[MOBILE_NO] operate-Equal[=]
	 */
	private String mobileNoEqual;


	/**
	 * condition-field: 手机号[MOBILE_NO] operate-In[in]
	 */
	private String[] mobileNos;


	/**
	 * condition-field: 电子邮件地址[EMAIL_ADRESS] operate-Like[like]
	 */
	private String emailAdress;


	/**
	 * condition-field: 电子邮件地址[EMAIL_ADRESS] operate-Equal[=]
	 */
	private String emailAdressEqual;


	/**
	 * condition-field: 电子邮件地址[EMAIL_ADRESS] operate-In[in]
	 */
	private String[] emailAdresss;


	/**
	 * condition-field: 操作员级别[OP_LEVEL] operate-Equal[=]
	 * 1-一级（正主管） 2-二级（副主管） 9-普通员工
	 */
	private Integer opLevel;


	/**
	 * condition-field: 操作员级别[OP_LEVEL] operate-In[in]
	 * 1-一级（正主管） 2-二级（副主管） 9-普通员工
	 */
	private Integer[] opLevels;


	/**
	 * condition-field: 操作员级别[OP_LEVEL] operate-GTEqual[>=]
	 * 1-一级（正主管） 2-二级（副主管） 9-普通员工
	 */
	private Integer startOpLevel;

	/**
	 * condition-field: 操作员级别[OP_LEVEL] operate-LTEqual[<=]
	 * 1-一级（正主管） 2-二级（副主管） 9-普通员工
	 */
	private Integer endOpLevel;


	/**
	 * condition-field: 上级操作员ID[SUP_OP_ID] operate-Equal[=]
	 */
	private Long supOpId;


	/**
	 * condition-field: 上级操作员ID[SUP_OP_ID] operate-In[in]
	 */
	private Long[] supOpIds;


	/**
	 * condition-field: 上级操作员ID[SUP_OP_ID] operate-GTEqual[>=]
	 */
	private Long startSupOpId;

	/**
	 * condition-field: 上级操作员ID[SUP_OP_ID] operate-LTEqual[<=]
	 */
	private Long endSupOpId;


	/**
	 * condition-field: 登录工号[LOGIN_CODE] operate-Like[like]
	 */
	private String loginCode;


	/**
	 * condition-field: 登录工号[LOGIN_CODE] operate-Equal[=]
	 */
	private String loginCodeEqual;


	/**
	 * condition-field: 登录工号[LOGIN_CODE] operate-In[in]
	 */
	private String[] loginCodes;


	/**
	 * condition-field: 登录密码[LOGIN_PASSWD] operate-Like[like]
	 */
	private String loginPasswd;


	/**
	 * condition-field: 简称[SHORT_NAME] operate-Like[like]
	 */
	private String shortName;


	/**
	 * condition-field: 英文名[ENGLISH_NAME] operate-Like[like]
	 */
	private String englishName;


	/**
	 * condition-field: 证件类型[CARD_TYPE_ID] operate-Equal[=]
	 */
	private Integer cardTypeId;


	/**
	 * condition-field: 证件类型[CARD_TYPE_ID] operate-In[in]
	 */
	private Integer[] cardTypeIds;


	/**
	 * condition-field: 证件类型[CARD_TYPE_ID] operate-GTEqual[>=]
	 */
	private Integer startCardTypeId;

	/**
	 * condition-field: 证件类型[CARD_TYPE_ID] operate-LTEqual[<=]
	 */
	private Integer endCardTypeId;


	/**
	 * condition-field: 证件号码[CARD_NO] operate-Like[like]
	 */
	private String cardNo;


	/**
	 * condition-field: 证件号码[CARD_NO] operate-Equal[=]
	 */
	private String cardNoEqual;


	/**
	 * condition-field: 证件号码[CARD_NO] operate-In[in]
	 */
	private String[] cardNos;


	/**
	 * condition-field: 生日[BIRTHDAY] operate-Equal[=]
	 * yyyyMMdd
	 */
	private Integer birthday;


	/**
	 * condition-field: 生日[BIRTHDAY] operate-In[in]
	 * yyyyMMdd
	 */
	private Integer[] birthdays;


	/**
	 * condition-field: 生日[BIRTHDAY] operate-GTEqual[>=]
	 * yyyyMMdd
	 */
	private Integer startBirthday;

	/**
	 * condition-field: 生日[BIRTHDAY] operate-LTEqual[<=]
	 * yyyyMMdd
	 */
	private Integer endBirthday;


	/**
	 * condition-field: 婚姻状况[MARRY_STATUS] operate-Equal[=]
	 * 0-未婚 1-已婚 对应sys_static_data表code_type=10101
	 */
	private Integer marryStatus;


	/**
	 * condition-field: 婚姻状况[MARRY_STATUS] operate-In[in]
	 * 0-未婚 1-已婚 对应sys_static_data表code_type=10101
	 */
	private Integer[] marryStatuss;


	/**
	 * condition-field: 婚姻状况[MARRY_STATUS] operate-GTEqual[>=]
	 * 0-未婚 1-已婚 对应sys_static_data表code_type=10101
	 */
	private Integer startMarryStatus;

	/**
	 * condition-field: 婚姻状况[MARRY_STATUS] operate-LTEqual[<=]
	 * 0-未婚 1-已婚 对应sys_static_data表code_type=10101
	 */
	private Integer endMarryStatus;


	/**
	 * condition-field: 性别[GENDER] operate-Equal[=]
	 * 1-男 2-女
	 */
	private Integer gender;


	/**
	 * condition-field: 性别[GENDER] operate-In[in]
	 * 1-男 2-女
	 */
	private Integer[] genders;


	/**
	 * condition-field: 性别[GENDER] operate-GTEqual[>=]
	 * 1-男 2-女
	 */
	private Integer startGender;

	/**
	 * condition-field: 性别[GENDER] operate-LTEqual[<=]
	 * 1-男 2-女
	 */
	private Integer endGender;


	/**
	 * condition-field: 宗教信仰[RELIGION] operate-Equal[=]
	 */
	private Integer religion;


	/**
	 * condition-field: 宗教信仰[RELIGION] operate-In[in]
	 */
	private Integer[] religions;


	/**
	 * condition-field: 宗教信仰[RELIGION] operate-GTEqual[>=]
	 */
	private Integer startReligion;

	/**
	 * condition-field: 宗教信仰[RELIGION] operate-LTEqual[<=]
	 */
	private Integer endReligion;


	/**
	 * condition-field: 民族[NATIONAL_TYPE] operate-Equal[=]
	 */
	private Integer nationalType;


	/**
	 * condition-field: 民族[NATIONAL_TYPE] operate-In[in]
	 */
	private Integer[] nationalTypes;


	/**
	 * condition-field: 民族[NATIONAL_TYPE] operate-GTEqual[>=]
	 */
	private Integer startNationalType;

	/**
	 * condition-field: 民族[NATIONAL_TYPE] operate-LTEqual[<=]
	 */
	private Integer endNationalType;


	/**
	 * condition-field: 学历[EDUCATION_LEVEL] operate-Equal[=]
	 */
	private Integer educationLevel;


	/**
	 * condition-field: 学历[EDUCATION_LEVEL] operate-In[in]
	 */
	private Integer[] educationLevels;


	/**
	 * condition-field: 学历[EDUCATION_LEVEL] operate-GTEqual[>=]
	 */
	private Integer startEducationLevel;

	/**
	 * condition-field: 学历[EDUCATION_LEVEL] operate-LTEqual[<=]
	 */
	private Integer endEducationLevel;


	/**
	 * condition-field: 收入[INCOME_LEVEL] operate-Equal[=]
	 */
	private Long incomeLevel;


	/**
	 * condition-field: 收入[INCOME_LEVEL] operate-In[in]
	 */
	private Long[] incomeLevels;


	/**
	 * condition-field: 收入[INCOME_LEVEL] operate-GTEqual[>=]
	 */
	private Long startIncomeLevel;

	/**
	 * condition-field: 收入[INCOME_LEVEL] operate-LTEqual[<=]
	 */
	private Long endIncomeLevel;


	/**
	 * condition-field: 政治面貌[POLITICS_FACE] operate-Equal[=]
	 */
	private Integer politicsFace;


	/**
	 * condition-field: 政治面貌[POLITICS_FACE] operate-In[in]
	 */
	private Integer[] politicsFaces;


	/**
	 * condition-field: 政治面貌[POLITICS_FACE] operate-GTEqual[>=]
	 */
	private Integer startPoliticsFace;

	/**
	 * condition-field: 政治面貌[POLITICS_FACE] operate-LTEqual[<=]
	 */
	private Integer endPoliticsFace;


	/**
	 * condition-field: 办公电话[OFFICE_TEL] operate-Like[like]
	 */
	private String officeTel;


	/**
	 * condition-field: 办公电话[OFFICE_TEL] operate-Equal[=]
	 */
	private String officeTelEqual;


	/**
	 * condition-field: 办公电话[OFFICE_TEL] operate-In[in]
	 */
	private String[] officeTels;


	/**
	 * condition-field: 传真号[FAX_ID] operate-Like[like]
	 */
	private String faxId;


	/**
	 * condition-field: 传真号[FAX_ID] operate-Equal[=]
	 */
	private String faxIdEqual;


	/**
	 * condition-field: 传真号[FAX_ID] operate-In[in]
	 */
	private String[] faxIds;


	/**
	 * condition-field: 家庭电话[HOME_TEL] operate-Like[like]
	 */
	private String homeTel;


	/**
	 * condition-field: 家庭电话[HOME_TEL] operate-Equal[=]
	 */
	private String homeTelEqual;


	/**
	 * condition-field: 家庭电话[HOME_TEL] operate-In[in]
	 */
	private String[] homeTels;


	/**
	 * condition-field: 无限寻呼[WIRELESS_CALL] operate-Like[like]
	 */
	private String wirelessCall;


	/**
	 * condition-field: 无限寻呼[WIRELESS_CALL] operate-Equal[=]
	 */
	private String wirelessCallEqual;


	/**
	 * condition-field: 无限寻呼[WIRELESS_CALL] operate-In[in]
	 */
	private String[] wirelessCalls;


	/**
	 * condition-field: 告警手机号[ALARM_MOBILE_NO] operate-Like[like]
	 */
	private String alarmMobileNo;


	/**
	 * condition-field: 告警手机号[ALARM_MOBILE_NO] operate-Equal[=]
	 */
	private String alarmMobileNoEqual;


	/**
	 * condition-field: 告警手机号[ALARM_MOBILE_NO] operate-In[in]
	 */
	private String[] alarmMobileNos;


	/**
	 * condition-field: 亲属信息[FAMILY_INFO] operate-Like[like]
	 */
	private String familyInfo;


	/**
	 * condition-field: 联系地址[CONTACT_ADDRESS] operate-Like[like]
	 */
	private String contactAddress;


	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-Equal[=]
	 */
	private Integer postalCode;


	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-In[in]
	 */
	private Integer[] postalCodes;


	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-GTEqual[>=]
	 */
	private Integer startPostalCode;

	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-LTEqual[<=]
	 */
	private Integer endPostalCode;


	/**
	 * condition-field: 社保卡号[SECURITY_ID] operate-Like[like]
	 */
	private String securityId;


	/**
	 * condition-field: 社保卡号[SECURITY_ID] operate-Equal[=]
	 */
	private String securityIdEqual;


	/**
	 * condition-field: 社保卡号[SECURITY_ID] operate-In[in]
	 */
	private String[] securityIds;


	/**
	 * condition-field: 车牌号码[CAR_NO] operate-Like[like]
	 */
	private String carNo;


	/**
	 * condition-field: 车牌号码[CAR_NO] operate-Equal[=]
	 */
	private String carNoEqual;


	/**
	 * condition-field: 车牌号码[CAR_NO] operate-In[in]
	 */
	private String[] carNos;


	/**
	 * condition-field: 性格特点[CHARACTER_DESC] operate-Like[like]
	 */
	private String characterDesc;


	/**
	 * condition-field: 备注[NOTES] operate-Like[like]
	 */
	private String notes;


	/**
	 * condition-field: 最近使用密码[RECENT_PASSWORD] operate-Like[like]
	 */
	private String recentPassword;


	/**
	 * condition-field: 最近使用密码次数[RECENT_PASS_TIMES] operate-Equal[=]
	 */
	private Integer recentPassTimes;


	/**
	 * condition-field: 最近使用密码次数[RECENT_PASS_TIMES] operate-In[in]
	 */
	private Integer[] recentPassTimess;


	/**
	 * condition-field: 最近使用密码次数[RECENT_PASS_TIMES] operate-GTEqual[>=]
	 */
	private Integer startRecentPassTimes;

	/**
	 * condition-field: 最近使用密码次数[RECENT_PASS_TIMES] operate-LTEqual[<=]
	 */
	private Integer endRecentPassTimes;


	/**
	 * condition-field: 最小密码长度[MIN_PASSWD_LENGTH] operate-Equal[=]
	 */
	private Integer minPasswdLength;


	/**
	 * condition-field: 最小密码长度[MIN_PASSWD_LENGTH] operate-In[in]
	 */
	private Integer[] minPasswdLengths;


	/**
	 * condition-field: 最小密码长度[MIN_PASSWD_LENGTH] operate-GTEqual[>=]
	 */
	private Integer startMinPasswdLength;

	/**
	 * condition-field: 最小密码长度[MIN_PASSWD_LENGTH] operate-LTEqual[<=]
	 */
	private Integer endMinPasswdLength;


	/**
	 * condition-field: 是否允许修改密码[ALLOW_CHANGE_PASSWD] operate-Equal[=]
	 */
	private Integer allowChangePasswd;


	/**
	 * condition-field: 是否允许修改密码[ALLOW_CHANGE_PASSWD] operate-In[in]
	 */
	private Integer[] allowChangePasswds;


	/**
	 * condition-field: 是否允许修改密码[ALLOW_CHANGE_PASSWD] operate-GTEqual[>=]
	 */
	private Integer startAllowChangePasswd;

	/**
	 * condition-field: 是否允许修改密码[ALLOW_CHANGE_PASSWD] operate-LTEqual[<=]
	 */
	private Integer endAllowChangePasswd;


	/**
	 * condition-field: 账号生效日期[ACCT_EFFECT_DATE] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long acctEffectDate;


	/**
	 * condition-field: 账号生效日期[ACCT_EFFECT_DATE] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] acctEffectDates;


	/**
	 * condition-field: 账号生效日期[ACCT_EFFECT_DATE] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startAcctEffectDate;

	/**
	 * condition-field: 账号生效日期[ACCT_EFFECT_DATE] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endAcctEffectDate;


	/**
	 * condition-field: 账号失效日期[ACCT_EXPIRE_DATE] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long acctExpireDate;


	/**
	 * condition-field: 账号失效日期[ACCT_EXPIRE_DATE] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] acctExpireDates;


	/**
	 * condition-field: 账号失效日期[ACCT_EXPIRE_DATE] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startAcctExpireDate;

	/**
	 * condition-field: 账号失效日期[ACCT_EXPIRE_DATE] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endAcctExpireDate;


	/**
	 * condition-field: 多重登录标志[MULTI_LOGIN_FLAG] operate-Equal[=]
	 */
	private Integer multiLoginFlag;


	/**
	 * condition-field: 多重登录标志[MULTI_LOGIN_FLAG] operate-In[in]
	 */
	private Integer[] multiLoginFlags;


	/**
	 * condition-field: 多重登录标志[MULTI_LOGIN_FLAG] operate-GTEqual[>=]
	 */
	private Integer startMultiLoginFlag;

	/**
	 * condition-field: 多重登录标志[MULTI_LOGIN_FLAG] operate-LTEqual[<=]
	 */
	private Integer endMultiLoginFlag;


	/**
	 * condition-field: 最后一次登录日志[LAST_LOGIN_LOG_ID] operate-Equal[=]
	 */
	private Long lastLoginLogId;


	/**
	 * condition-field: 最后一次登录日志[LAST_LOGIN_LOG_ID] operate-In[in]
	 */
	private Long[] lastLoginLogIds;


	/**
	 * condition-field: 最后一次登录日志[LAST_LOGIN_LOG_ID] operate-GTEqual[>=]
	 */
	private Long startLastLoginLogId;

	/**
	 * condition-field: 最后一次登录日志[LAST_LOGIN_LOG_ID] operate-LTEqual[<=]
	 */
	private Long endLastLoginLogId;


	/**
	 * condition-field: 登录尝试次数[TRY_TIMES] operate-Equal[=]
	 */
	private Integer tryTimes;


	/**
	 * condition-field: 登录尝试次数[TRY_TIMES] operate-In[in]
	 */
	private Integer[] tryTimess;


	/**
	 * condition-field: 登录尝试次数[TRY_TIMES] operate-GTEqual[>=]
	 */
	private Integer startTryTimes;

	/**
	 * condition-field: 登录尝试次数[TRY_TIMES] operate-LTEqual[<=]
	 */
	private Integer endTryTimes;


	/**
	 * condition-field: 登录标志[LOGIN_FLAG] operate-Equal[=]
	 * 0-未登录 1-已登录
	 */
	private Integer loginFlag;


	/**
	 * condition-field: 登录标志[LOGIN_FLAG] operate-In[in]
	 * 0-未登录 1-已登录
	 */
	private Integer[] loginFlags;


	/**
	 * condition-field: 登录标志[LOGIN_FLAG] operate-GTEqual[>=]
	 * 0-未登录 1-已登录
	 */
	private Integer startLoginFlag;

	/**
	 * condition-field: 登录标志[LOGIN_FLAG] operate-LTEqual[<=]
	 * 0-未登录 1-已登录
	 */
	private Integer endLoginFlag;


	/**
	 * condition-field: 超级用户标志[SUPER_USER_FLAG] operate-Equal[=]
	 * 0-否 1-是
	 */
	private Integer superUserFlag;


	/**
	 * condition-field: 超级用户标志[SUPER_USER_FLAG] operate-In[in]
	 * 0-否 1-是
	 */
	private Integer[] superUserFlags;


	/**
	 * condition-field: 超级用户标志[SUPER_USER_FLAG] operate-GTEqual[>=]
	 * 0-否 1-是
	 */
	private Integer startSuperUserFlag;

	/**
	 * condition-field: 超级用户标志[SUPER_USER_FLAG] operate-LTEqual[<=]
	 * 0-否 1-是
	 */
	private Integer endSuperUserFlag;


	/**
	 * condition-field: 密码有效期[PASSWD_VALID_DAYS] operate-Equal[=]
	 * 单位：天
	 */
	private Long passwdValidDays;


	/**
	 * condition-field: 密码有效期[PASSWD_VALID_DAYS] operate-In[in]
	 * 单位：天
	 */
	private Long[] passwdValidDayss;


	/**
	 * condition-field: 密码有效期[PASSWD_VALID_DAYS] operate-GTEqual[>=]
	 * 单位：天
	 */
	private Long startPasswdValidDays;

	/**
	 * condition-field: 密码有效期[PASSWD_VALID_DAYS] operate-LTEqual[<=]
	 * 单位：天
	 */
	private Long endPasswdValidDays;


	/**
	 * condition-field: 停止时限[CANCEL_DAYS] operate-Equal[=]
	 * 单位：天 如果到了密码修改时，登陆用户还未修改密码，则过了“停止时限”后，该工号被强制回收，除非用户又修改了密码，才可以再继续使用。
	 */
	private Integer cancelDays;


	/**
	 * condition-field: 停止时限[CANCEL_DAYS] operate-In[in]
	 * 单位：天 如果到了密码修改时，登陆用户还未修改密码，则过了“停止时限”后，该工号被强制回收，除非用户又修改了密码，才可以再继续使用。
	 */
	private Integer[] cancelDayss;


	/**
	 * condition-field: 停止时限[CANCEL_DAYS] operate-GTEqual[>=]
	 * 单位：天 如果到了密码修改时，登陆用户还未修改密码，则过了“停止时限”后，该工号被强制回收，除非用户又修改了密码，才可以再继续使用。
	 */
	private Integer startCancelDays;

	/**
	 * condition-field: 停止时限[CANCEL_DAYS] operate-LTEqual[<=]
	 * 单位：天 如果到了密码修改时，登陆用户还未修改密码，则过了“停止时限”后，该工号被强制回收，除非用户又修改了密码，才可以再继续使用。
	 */
	private Integer endCancelDays;


	/**
	 * condition-field: 密码生效时间[PASSWORD_VALID_DATE] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long passwordValidDate;


	/**
	 * condition-field: 密码生效时间[PASSWORD_VALID_DATE] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] passwordValidDates;


	/**
	 * condition-field: 密码生效时间[PASSWORD_VALID_DATE] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startPasswordValidDate;

	/**
	 * condition-field: 密码生效时间[PASSWORD_VALID_DATE] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endPasswordValidDate;


	/**
	 * condition-field: 密码过期提前通知[CHG_PASSWD_ALARM_DAYS] operate-Equal[=]
	 */
	private Long chgPasswdAlarmDays;


	/**
	 * condition-field: 密码过期提前通知[CHG_PASSWD_ALARM_DAYS] operate-In[in]
	 */
	private Long[] chgPasswdAlarmDayss;


	/**
	 * condition-field: 密码过期提前通知[CHG_PASSWD_ALARM_DAYS] operate-GTEqual[>=]
	 */
	private Long startChgPasswdAlarmDays;

	/**
	 * condition-field: 密码过期提前通知[CHG_PASSWD_ALARM_DAYS] operate-LTEqual[<=]
	 */
	private Long endChgPasswdAlarmDays;


	/**
	 * condition-field: 短信校验密码[SMS_CHK_PASSWD] operate-Like[like]
	 */
	private String smsChkPasswd;


	/**
	 * condition-field: 短信校验密码[SMS_CHK_PASSWD] operate-Equal[=]
	 */
	private String smsChkPasswdEqual;


	/**
	 * condition-field: 短信校验密码[SMS_CHK_PASSWD] operate-In[in]
	 */
	private String[] smsChkPasswds;


	/**
	 * condition-field: 校验密码生效时间[CHKPW_EFFECT_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long chkpwEffectTime;


	/**
	 * condition-field: 校验密码生效时间[CHKPW_EFFECT_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] chkpwEffectTimes;


	/**
	 * condition-field: 校验密码生效时间[CHKPW_EFFECT_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startChkpwEffectTime;

	/**
	 * condition-field: 校验密码生效时间[CHKPW_EFFECT_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endChkpwEffectTime;


	/**
	 * condition-field: 校验密码失效时间[CHKPW_EXPIRE_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long chkpwExpireTime;


	/**
	 * condition-field: 校验密码失效时间[CHKPW_EXPIRE_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] chkpwExpireTimes;


	/**
	 * condition-field: 校验密码失效时间[CHKPW_EXPIRE_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startChkpwExpireTime;

	/**
	 * condition-field: 校验密码失效时间[CHKPW_EXPIRE_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endChkpwExpireTime;


	/**
	 * condition-field: 锁定标志[LOCK_FLAG] operate-Equal[=]
	 * 0-未锁定 1-锁定
	 */
	private Integer lockFlag;


	/**
	 * condition-field: 锁定标志[LOCK_FLAG] operate-In[in]
	 * 0-未锁定 1-锁定
	 */
	private Integer[] lockFlags;


	/**
	 * condition-field: 锁定标志[LOCK_FLAG] operate-GTEqual[>=]
	 * 0-未锁定 1-锁定
	 */
	private Integer startLockFlag;

	/**
	 * condition-field: 锁定标志[LOCK_FLAG] operate-LTEqual[<=]
	 * 0-未锁定 1-锁定
	 */
	private Integer endLockFlag;


	/**
	 * condition-field: 是否需要修改密码[IS_UPDATE_PWD] operate-Equal[=]
	 * 1=是 0=否
	 */
	private Integer isUpdatePwd;


	/**
	 * condition-field: 是否需要修改密码[IS_UPDATE_PWD] operate-In[in]
	 * 1=是 0=否
	 */
	private Integer[] isUpdatePwds;


	/**
	 * condition-field: 是否需要修改密码[IS_UPDATE_PWD] operate-GTEqual[>=]
	 * 1=是 0=否
	 */
	private Integer startIsUpdatePwd;

	/**
	 * condition-field: 是否需要修改密码[IS_UPDATE_PWD] operate-LTEqual[<=]
	 * 1=是 0=否
	 */
	private Integer endIsUpdatePwd;


	/**
	 * condition-field: 登录认证代码[LOGIN_AUTH_CODE] operate-Like[like]
	 */
	private String loginAuthCode;


	/**
	 * condition-field: 登录认证代码[LOGIN_AUTH_CODE] operate-Equal[=]
	 */
	private String loginAuthCodeEqual;


	/**
	 * condition-field: 登录认证代码[LOGIN_AUTH_CODE] operate-In[in]
	 */
	private String[] loginAuthCodes;


	/**
	 * condition-field: 备用_1[CUSTOM_1] operate-Like[like]
	 */
	private String custom1;


	/**
	 * condition-field: 备用_2[CUSTOM_2] operate-Like[like]
	 */
	private String custom2;


	/**
	 * condition-field: 备用_3[CUSTOM_3] operate-Like[like]
	 */
	private String custom3;


	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-Equal[=]
	 */
	private Long custom4;


	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-In[in]
	 */
	private Long[] custom4s;


	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-GTEqual[>=]
	 */
	private Long startCustom4;

	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-LTEqual[<=]
	 */
	private Long endCustom4;


	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-Equal[=]
	 */
	private Long custom5;


	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-In[in]
	 */
	private Long[] custom5s;


	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-GTEqual[>=]
	 */
	private Long startCustom5;

	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-LTEqual[<=]
	 */
	private Long endCustom5;


	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-Equal[=]
	 */
	private Long custom6;


	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-In[in]
	 */
	private Long[] custom6s;


	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-GTEqual[>=]
	 */
	private Long startCustom6;

	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-LTEqual[<=]
	 */
	private Long endCustom6;


	/**
	 * condition-field: 状态[STATUS] operate-Equal[=]
	 * 1-正常 0-停用
	 */
	private Integer status;


	/**
	 * condition-field: 状态[STATUS] operate-In[in]
	 * 1-正常 0-停用
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 状态[STATUS] operate-GTEqual[>=]
	 * 1-正常 0-停用
	 */
	private Integer startStatus;

	/**
	 * condition-field: 状态[STATUS] operate-LTEqual[<=]
	 * 1-正常 0-停用
	 */
	private Integer endStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-Equal[=]
	 * 1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-In[in]
	 * 1-正常 0-删除
	 */
	private Integer[] dataStatuss;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-GTEqual[>=]
	 * 1-正常 0-删除
	 */
	private Integer startDataStatus;

	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-LTEqual[<=]
	 * 1-正常 0-删除
	 */
	private Integer endDataStatus;


	/**
	 * condition-field: 创建人[CREATOR] operate-Like[like]
	 */
	private String creator;


	/**
	 * condition-field: 创建人[CREATOR] operate-Equal[=]
	 */
	private String creatorEqual;


	/**
	 * condition-field: 创建人[CREATOR] operate-In[in]
	 */
	private String[] creators;


	/**
	 * condition-field: 修改人[MODIFIER] operate-Like[like]
	 */
	private String modifier;


	/**
	 * condition-field: 修改人[MODIFIER] operate-Equal[=]
	 */
	private String modifierEqual;


	/**
	 * condition-field: 修改人[MODIFIER] operate-In[in]
	 */
	private String[] modifiers;


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


	public String getOpCode() {
		return this.opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}


	public String getOpCodeEqual() {
		return this.opCodeEqual;
	}
	public void setOpCodeEqual(String opCodeEqual) {
		this.opCodeEqual = opCodeEqual;
	}


	public String[] getOpCodes() {
		return this.opCodes;
	}
	public void setOpCodes(String[] opCodes) {
		this.opCodes = opCodes;
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


	public Integer[] getOpKinds() {
		return this.opKinds;
	}
	public void setOpKinds(Integer[] opKinds) {
		this.opKinds = opKinds;
	}


	public Integer getStartOpKind() {
		return this.startOpKind;
	}
	public void setStartOpKind(Integer startOpKind) {
		this.startOpKind = startOpKind;
	}


	public Integer getEndOpKind() {
		return this.endOpKind;
	}
	public void setEndOpKind(Integer endOpKind) {
		this.endOpKind = endOpKind;
	}


	public String getMobileNo() {
		return this.mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getMobileNoEqual() {
		return this.mobileNoEqual;
	}
	public void setMobileNoEqual(String mobileNoEqual) {
		this.mobileNoEqual = mobileNoEqual;
	}


	public String[] getMobileNos() {
		return this.mobileNos;
	}
	public void setMobileNos(String[] mobileNos) {
		this.mobileNos = mobileNos;
	}


	public String getEmailAdress() {
		return this.emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}


	public String getEmailAdressEqual() {
		return this.emailAdressEqual;
	}
	public void setEmailAdressEqual(String emailAdressEqual) {
		this.emailAdressEqual = emailAdressEqual;
	}


	public String[] getEmailAdresss() {
		return this.emailAdresss;
	}
	public void setEmailAdresss(String[] emailAdresss) {
		this.emailAdresss = emailAdresss;
	}


	public Integer getOpLevel() {
		return this.opLevel;
	}
	public void setOpLevel(Integer opLevel) {
		this.opLevel = opLevel;
	}


	public Integer[] getOpLevels() {
		return this.opLevels;
	}
	public void setOpLevels(Integer[] opLevels) {
		this.opLevels = opLevels;
	}


	public Integer getStartOpLevel() {
		return this.startOpLevel;
	}
	public void setStartOpLevel(Integer startOpLevel) {
		this.startOpLevel = startOpLevel;
	}


	public Integer getEndOpLevel() {
		return this.endOpLevel;
	}
	public void setEndOpLevel(Integer endOpLevel) {
		this.endOpLevel = endOpLevel;
	}


	public Long getSupOpId() {
		return this.supOpId;
	}
	public void setSupOpId(Long supOpId) {
		this.supOpId = supOpId;
	}


	public Long[] getSupOpIds() {
		return this.supOpIds;
	}
	public void setSupOpIds(Long[] supOpIds) {
		this.supOpIds = supOpIds;
	}


	public Long getStartSupOpId() {
		return this.startSupOpId;
	}
	public void setStartSupOpId(Long startSupOpId) {
		this.startSupOpId = startSupOpId;
	}


	public Long getEndSupOpId() {
		return this.endSupOpId;
	}
	public void setEndSupOpId(Long endSupOpId) {
		this.endSupOpId = endSupOpId;
	}


	public String getLoginCode() {
		return this.loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}


	public String getLoginCodeEqual() {
		return this.loginCodeEqual;
	}
	public void setLoginCodeEqual(String loginCodeEqual) {
		this.loginCodeEqual = loginCodeEqual;
	}


	public String[] getLoginCodes() {
		return this.loginCodes;
	}
	public void setLoginCodes(String[] loginCodes) {
		this.loginCodes = loginCodes;
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


	public Integer[] getCardTypeIds() {
		return this.cardTypeIds;
	}
	public void setCardTypeIds(Integer[] cardTypeIds) {
		this.cardTypeIds = cardTypeIds;
	}


	public Integer getStartCardTypeId() {
		return this.startCardTypeId;
	}
	public void setStartCardTypeId(Integer startCardTypeId) {
		this.startCardTypeId = startCardTypeId;
	}


	public Integer getEndCardTypeId() {
		return this.endCardTypeId;
	}
	public void setEndCardTypeId(Integer endCardTypeId) {
		this.endCardTypeId = endCardTypeId;
	}


	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	public String getCardNoEqual() {
		return this.cardNoEqual;
	}
	public void setCardNoEqual(String cardNoEqual) {
		this.cardNoEqual = cardNoEqual;
	}


	public String[] getCardNos() {
		return this.cardNos;
	}
	public void setCardNos(String[] cardNos) {
		this.cardNos = cardNos;
	}


	public Integer getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Integer birthday) {
		this.birthday = birthday;
	}


	public Integer[] getBirthdays() {
		return this.birthdays;
	}
	public void setBirthdays(Integer[] birthdays) {
		this.birthdays = birthdays;
	}


	public Integer getStartBirthday() {
		return this.startBirthday;
	}
	public void setStartBirthday(Integer startBirthday) {
		this.startBirthday = startBirthday;
	}


	public Integer getEndBirthday() {
		return this.endBirthday;
	}
	public void setEndBirthday(Integer endBirthday) {
		this.endBirthday = endBirthday;
	}


	public Integer getMarryStatus() {
		return this.marryStatus;
	}
	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}


	public Integer[] getMarryStatuss() {
		return this.marryStatuss;
	}
	public void setMarryStatuss(Integer[] marryStatuss) {
		this.marryStatuss = marryStatuss;
	}


	public Integer getStartMarryStatus() {
		return this.startMarryStatus;
	}
	public void setStartMarryStatus(Integer startMarryStatus) {
		this.startMarryStatus = startMarryStatus;
	}


	public Integer getEndMarryStatus() {
		return this.endMarryStatus;
	}
	public void setEndMarryStatus(Integer endMarryStatus) {
		this.endMarryStatus = endMarryStatus;
	}


	public Integer getGender() {
		return this.gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}


	public Integer[] getGenders() {
		return this.genders;
	}
	public void setGenders(Integer[] genders) {
		this.genders = genders;
	}


	public Integer getStartGender() {
		return this.startGender;
	}
	public void setStartGender(Integer startGender) {
		this.startGender = startGender;
	}


	public Integer getEndGender() {
		return this.endGender;
	}
	public void setEndGender(Integer endGender) {
		this.endGender = endGender;
	}


	public Integer getReligion() {
		return this.religion;
	}
	public void setReligion(Integer religion) {
		this.religion = religion;
	}


	public Integer[] getReligions() {
		return this.religions;
	}
	public void setReligions(Integer[] religions) {
		this.religions = religions;
	}


	public Integer getStartReligion() {
		return this.startReligion;
	}
	public void setStartReligion(Integer startReligion) {
		this.startReligion = startReligion;
	}


	public Integer getEndReligion() {
		return this.endReligion;
	}
	public void setEndReligion(Integer endReligion) {
		this.endReligion = endReligion;
	}


	public Integer getNationalType() {
		return this.nationalType;
	}
	public void setNationalType(Integer nationalType) {
		this.nationalType = nationalType;
	}


	public Integer[] getNationalTypes() {
		return this.nationalTypes;
	}
	public void setNationalTypes(Integer[] nationalTypes) {
		this.nationalTypes = nationalTypes;
	}


	public Integer getStartNationalType() {
		return this.startNationalType;
	}
	public void setStartNationalType(Integer startNationalType) {
		this.startNationalType = startNationalType;
	}


	public Integer getEndNationalType() {
		return this.endNationalType;
	}
	public void setEndNationalType(Integer endNationalType) {
		this.endNationalType = endNationalType;
	}


	public Integer getEducationLevel() {
		return this.educationLevel;
	}
	public void setEducationLevel(Integer educationLevel) {
		this.educationLevel = educationLevel;
	}


	public Integer[] getEducationLevels() {
		return this.educationLevels;
	}
	public void setEducationLevels(Integer[] educationLevels) {
		this.educationLevels = educationLevels;
	}


	public Integer getStartEducationLevel() {
		return this.startEducationLevel;
	}
	public void setStartEducationLevel(Integer startEducationLevel) {
		this.startEducationLevel = startEducationLevel;
	}


	public Integer getEndEducationLevel() {
		return this.endEducationLevel;
	}
	public void setEndEducationLevel(Integer endEducationLevel) {
		this.endEducationLevel = endEducationLevel;
	}


	public Long getIncomeLevel() {
		return this.incomeLevel;
	}
	public void setIncomeLevel(Long incomeLevel) {
		this.incomeLevel = incomeLevel;
	}


	public Long[] getIncomeLevels() {
		return this.incomeLevels;
	}
	public void setIncomeLevels(Long[] incomeLevels) {
		this.incomeLevels = incomeLevels;
	}


	public Long getStartIncomeLevel() {
		return this.startIncomeLevel;
	}
	public void setStartIncomeLevel(Long startIncomeLevel) {
		this.startIncomeLevel = startIncomeLevel;
	}


	public Long getEndIncomeLevel() {
		return this.endIncomeLevel;
	}
	public void setEndIncomeLevel(Long endIncomeLevel) {
		this.endIncomeLevel = endIncomeLevel;
	}


	public Integer getPoliticsFace() {
		return this.politicsFace;
	}
	public void setPoliticsFace(Integer politicsFace) {
		this.politicsFace = politicsFace;
	}


	public Integer[] getPoliticsFaces() {
		return this.politicsFaces;
	}
	public void setPoliticsFaces(Integer[] politicsFaces) {
		this.politicsFaces = politicsFaces;
	}


	public Integer getStartPoliticsFace() {
		return this.startPoliticsFace;
	}
	public void setStartPoliticsFace(Integer startPoliticsFace) {
		this.startPoliticsFace = startPoliticsFace;
	}


	public Integer getEndPoliticsFace() {
		return this.endPoliticsFace;
	}
	public void setEndPoliticsFace(Integer endPoliticsFace) {
		this.endPoliticsFace = endPoliticsFace;
	}


	public String getOfficeTel() {
		return this.officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}


	public String getOfficeTelEqual() {
		return this.officeTelEqual;
	}
	public void setOfficeTelEqual(String officeTelEqual) {
		this.officeTelEqual = officeTelEqual;
	}


	public String[] getOfficeTels() {
		return this.officeTels;
	}
	public void setOfficeTels(String[] officeTels) {
		this.officeTels = officeTels;
	}


	public String getFaxId() {
		return this.faxId;
	}
	public void setFaxId(String faxId) {
		this.faxId = faxId;
	}


	public String getFaxIdEqual() {
		return this.faxIdEqual;
	}
	public void setFaxIdEqual(String faxIdEqual) {
		this.faxIdEqual = faxIdEqual;
	}


	public String[] getFaxIds() {
		return this.faxIds;
	}
	public void setFaxIds(String[] faxIds) {
		this.faxIds = faxIds;
	}


	public String getHomeTel() {
		return this.homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}


	public String getHomeTelEqual() {
		return this.homeTelEqual;
	}
	public void setHomeTelEqual(String homeTelEqual) {
		this.homeTelEqual = homeTelEqual;
	}


	public String[] getHomeTels() {
		return this.homeTels;
	}
	public void setHomeTels(String[] homeTels) {
		this.homeTels = homeTels;
	}


	public String getWirelessCall() {
		return this.wirelessCall;
	}
	public void setWirelessCall(String wirelessCall) {
		this.wirelessCall = wirelessCall;
	}


	public String getWirelessCallEqual() {
		return this.wirelessCallEqual;
	}
	public void setWirelessCallEqual(String wirelessCallEqual) {
		this.wirelessCallEqual = wirelessCallEqual;
	}


	public String[] getWirelessCalls() {
		return this.wirelessCalls;
	}
	public void setWirelessCalls(String[] wirelessCalls) {
		this.wirelessCalls = wirelessCalls;
	}


	public String getAlarmMobileNo() {
		return this.alarmMobileNo;
	}
	public void setAlarmMobileNo(String alarmMobileNo) {
		this.alarmMobileNo = alarmMobileNo;
	}


	public String getAlarmMobileNoEqual() {
		return this.alarmMobileNoEqual;
	}
	public void setAlarmMobileNoEqual(String alarmMobileNoEqual) {
		this.alarmMobileNoEqual = alarmMobileNoEqual;
	}


	public String[] getAlarmMobileNos() {
		return this.alarmMobileNos;
	}
	public void setAlarmMobileNos(String[] alarmMobileNos) {
		this.alarmMobileNos = alarmMobileNos;
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


	public Integer[] getPostalCodes() {
		return this.postalCodes;
	}
	public void setPostalCodes(Integer[] postalCodes) {
		this.postalCodes = postalCodes;
	}


	public Integer getStartPostalCode() {
		return this.startPostalCode;
	}
	public void setStartPostalCode(Integer startPostalCode) {
		this.startPostalCode = startPostalCode;
	}


	public Integer getEndPostalCode() {
		return this.endPostalCode;
	}
	public void setEndPostalCode(Integer endPostalCode) {
		this.endPostalCode = endPostalCode;
	}


	public String getSecurityId() {
		return this.securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}


	public String getSecurityIdEqual() {
		return this.securityIdEqual;
	}
	public void setSecurityIdEqual(String securityIdEqual) {
		this.securityIdEqual = securityIdEqual;
	}


	public String[] getSecurityIds() {
		return this.securityIds;
	}
	public void setSecurityIds(String[] securityIds) {
		this.securityIds = securityIds;
	}


	public String getCarNo() {
		return this.carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	public String getCarNoEqual() {
		return this.carNoEqual;
	}
	public void setCarNoEqual(String carNoEqual) {
		this.carNoEqual = carNoEqual;
	}


	public String[] getCarNos() {
		return this.carNos;
	}
	public void setCarNos(String[] carNos) {
		this.carNos = carNos;
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


	public Integer[] getRecentPassTimess() {
		return this.recentPassTimess;
	}
	public void setRecentPassTimess(Integer[] recentPassTimess) {
		this.recentPassTimess = recentPassTimess;
	}


	public Integer getStartRecentPassTimes() {
		return this.startRecentPassTimes;
	}
	public void setStartRecentPassTimes(Integer startRecentPassTimes) {
		this.startRecentPassTimes = startRecentPassTimes;
	}


	public Integer getEndRecentPassTimes() {
		return this.endRecentPassTimes;
	}
	public void setEndRecentPassTimes(Integer endRecentPassTimes) {
		this.endRecentPassTimes = endRecentPassTimes;
	}


	public Integer getMinPasswdLength() {
		return this.minPasswdLength;
	}
	public void setMinPasswdLength(Integer minPasswdLength) {
		this.minPasswdLength = minPasswdLength;
	}


	public Integer[] getMinPasswdLengths() {
		return this.minPasswdLengths;
	}
	public void setMinPasswdLengths(Integer[] minPasswdLengths) {
		this.minPasswdLengths = minPasswdLengths;
	}


	public Integer getStartMinPasswdLength() {
		return this.startMinPasswdLength;
	}
	public void setStartMinPasswdLength(Integer startMinPasswdLength) {
		this.startMinPasswdLength = startMinPasswdLength;
	}


	public Integer getEndMinPasswdLength() {
		return this.endMinPasswdLength;
	}
	public void setEndMinPasswdLength(Integer endMinPasswdLength) {
		this.endMinPasswdLength = endMinPasswdLength;
	}


	public Integer getAllowChangePasswd() {
		return this.allowChangePasswd;
	}
	public void setAllowChangePasswd(Integer allowChangePasswd) {
		this.allowChangePasswd = allowChangePasswd;
	}


	public Integer[] getAllowChangePasswds() {
		return this.allowChangePasswds;
	}
	public void setAllowChangePasswds(Integer[] allowChangePasswds) {
		this.allowChangePasswds = allowChangePasswds;
	}


	public Integer getStartAllowChangePasswd() {
		return this.startAllowChangePasswd;
	}
	public void setStartAllowChangePasswd(Integer startAllowChangePasswd) {
		this.startAllowChangePasswd = startAllowChangePasswd;
	}


	public Integer getEndAllowChangePasswd() {
		return this.endAllowChangePasswd;
	}
	public void setEndAllowChangePasswd(Integer endAllowChangePasswd) {
		this.endAllowChangePasswd = endAllowChangePasswd;
	}


	public Long getAcctEffectDate() {
		return this.acctEffectDate;
	}
	public void setAcctEffectDate(Long acctEffectDate) {
		this.acctEffectDate = acctEffectDate;
	}


	public Long[] getAcctEffectDates() {
		return this.acctEffectDates;
	}
	public void setAcctEffectDates(Long[] acctEffectDates) {
		this.acctEffectDates = acctEffectDates;
	}


	public Long getStartAcctEffectDate() {
		return this.startAcctEffectDate;
	}
	public void setStartAcctEffectDate(Long startAcctEffectDate) {
		this.startAcctEffectDate = startAcctEffectDate;
	}


	public Long getEndAcctEffectDate() {
		return this.endAcctEffectDate;
	}
	public void setEndAcctEffectDate(Long endAcctEffectDate) {
		this.endAcctEffectDate = endAcctEffectDate;
	}


	public Long getAcctExpireDate() {
		return this.acctExpireDate;
	}
	public void setAcctExpireDate(Long acctExpireDate) {
		this.acctExpireDate = acctExpireDate;
	}


	public Long[] getAcctExpireDates() {
		return this.acctExpireDates;
	}
	public void setAcctExpireDates(Long[] acctExpireDates) {
		this.acctExpireDates = acctExpireDates;
	}


	public Long getStartAcctExpireDate() {
		return this.startAcctExpireDate;
	}
	public void setStartAcctExpireDate(Long startAcctExpireDate) {
		this.startAcctExpireDate = startAcctExpireDate;
	}


	public Long getEndAcctExpireDate() {
		return this.endAcctExpireDate;
	}
	public void setEndAcctExpireDate(Long endAcctExpireDate) {
		this.endAcctExpireDate = endAcctExpireDate;
	}


	public Integer getMultiLoginFlag() {
		return this.multiLoginFlag;
	}
	public void setMultiLoginFlag(Integer multiLoginFlag) {
		this.multiLoginFlag = multiLoginFlag;
	}


	public Integer[] getMultiLoginFlags() {
		return this.multiLoginFlags;
	}
	public void setMultiLoginFlags(Integer[] multiLoginFlags) {
		this.multiLoginFlags = multiLoginFlags;
	}


	public Integer getStartMultiLoginFlag() {
		return this.startMultiLoginFlag;
	}
	public void setStartMultiLoginFlag(Integer startMultiLoginFlag) {
		this.startMultiLoginFlag = startMultiLoginFlag;
	}


	public Integer getEndMultiLoginFlag() {
		return this.endMultiLoginFlag;
	}
	public void setEndMultiLoginFlag(Integer endMultiLoginFlag) {
		this.endMultiLoginFlag = endMultiLoginFlag;
	}


	public Long getLastLoginLogId() {
		return this.lastLoginLogId;
	}
	public void setLastLoginLogId(Long lastLoginLogId) {
		this.lastLoginLogId = lastLoginLogId;
	}


	public Long[] getLastLoginLogIds() {
		return this.lastLoginLogIds;
	}
	public void setLastLoginLogIds(Long[] lastLoginLogIds) {
		this.lastLoginLogIds = lastLoginLogIds;
	}


	public Long getStartLastLoginLogId() {
		return this.startLastLoginLogId;
	}
	public void setStartLastLoginLogId(Long startLastLoginLogId) {
		this.startLastLoginLogId = startLastLoginLogId;
	}


	public Long getEndLastLoginLogId() {
		return this.endLastLoginLogId;
	}
	public void setEndLastLoginLogId(Long endLastLoginLogId) {
		this.endLastLoginLogId = endLastLoginLogId;
	}


	public Integer getTryTimes() {
		return this.tryTimes;
	}
	public void setTryTimes(Integer tryTimes) {
		this.tryTimes = tryTimes;
	}


	public Integer[] getTryTimess() {
		return this.tryTimess;
	}
	public void setTryTimess(Integer[] tryTimess) {
		this.tryTimess = tryTimess;
	}


	public Integer getStartTryTimes() {
		return this.startTryTimes;
	}
	public void setStartTryTimes(Integer startTryTimes) {
		this.startTryTimes = startTryTimes;
	}


	public Integer getEndTryTimes() {
		return this.endTryTimes;
	}
	public void setEndTryTimes(Integer endTryTimes) {
		this.endTryTimes = endTryTimes;
	}


	public Integer getLoginFlag() {
		return this.loginFlag;
	}
	public void setLoginFlag(Integer loginFlag) {
		this.loginFlag = loginFlag;
	}


	public Integer[] getLoginFlags() {
		return this.loginFlags;
	}
	public void setLoginFlags(Integer[] loginFlags) {
		this.loginFlags = loginFlags;
	}


	public Integer getStartLoginFlag() {
		return this.startLoginFlag;
	}
	public void setStartLoginFlag(Integer startLoginFlag) {
		this.startLoginFlag = startLoginFlag;
	}


	public Integer getEndLoginFlag() {
		return this.endLoginFlag;
	}
	public void setEndLoginFlag(Integer endLoginFlag) {
		this.endLoginFlag = endLoginFlag;
	}


	public Integer getSuperUserFlag() {
		return this.superUserFlag;
	}
	public void setSuperUserFlag(Integer superUserFlag) {
		this.superUserFlag = superUserFlag;
	}


	public Integer[] getSuperUserFlags() {
		return this.superUserFlags;
	}
	public void setSuperUserFlags(Integer[] superUserFlags) {
		this.superUserFlags = superUserFlags;
	}


	public Integer getStartSuperUserFlag() {
		return this.startSuperUserFlag;
	}
	public void setStartSuperUserFlag(Integer startSuperUserFlag) {
		this.startSuperUserFlag = startSuperUserFlag;
	}


	public Integer getEndSuperUserFlag() {
		return this.endSuperUserFlag;
	}
	public void setEndSuperUserFlag(Integer endSuperUserFlag) {
		this.endSuperUserFlag = endSuperUserFlag;
	}


	public Long getPasswdValidDays() {
		return this.passwdValidDays;
	}
	public void setPasswdValidDays(Long passwdValidDays) {
		this.passwdValidDays = passwdValidDays;
	}


	public Long[] getPasswdValidDayss() {
		return this.passwdValidDayss;
	}
	public void setPasswdValidDayss(Long[] passwdValidDayss) {
		this.passwdValidDayss = passwdValidDayss;
	}


	public Long getStartPasswdValidDays() {
		return this.startPasswdValidDays;
	}
	public void setStartPasswdValidDays(Long startPasswdValidDays) {
		this.startPasswdValidDays = startPasswdValidDays;
	}


	public Long getEndPasswdValidDays() {
		return this.endPasswdValidDays;
	}
	public void setEndPasswdValidDays(Long endPasswdValidDays) {
		this.endPasswdValidDays = endPasswdValidDays;
	}


	public Integer getCancelDays() {
		return this.cancelDays;
	}
	public void setCancelDays(Integer cancelDays) {
		this.cancelDays = cancelDays;
	}


	public Integer[] getCancelDayss() {
		return this.cancelDayss;
	}
	public void setCancelDayss(Integer[] cancelDayss) {
		this.cancelDayss = cancelDayss;
	}


	public Integer getStartCancelDays() {
		return this.startCancelDays;
	}
	public void setStartCancelDays(Integer startCancelDays) {
		this.startCancelDays = startCancelDays;
	}


	public Integer getEndCancelDays() {
		return this.endCancelDays;
	}
	public void setEndCancelDays(Integer endCancelDays) {
		this.endCancelDays = endCancelDays;
	}


	public Long getPasswordValidDate() {
		return this.passwordValidDate;
	}
	public void setPasswordValidDate(Long passwordValidDate) {
		this.passwordValidDate = passwordValidDate;
	}


	public Long[] getPasswordValidDates() {
		return this.passwordValidDates;
	}
	public void setPasswordValidDates(Long[] passwordValidDates) {
		this.passwordValidDates = passwordValidDates;
	}


	public Long getStartPasswordValidDate() {
		return this.startPasswordValidDate;
	}
	public void setStartPasswordValidDate(Long startPasswordValidDate) {
		this.startPasswordValidDate = startPasswordValidDate;
	}


	public Long getEndPasswordValidDate() {
		return this.endPasswordValidDate;
	}
	public void setEndPasswordValidDate(Long endPasswordValidDate) {
		this.endPasswordValidDate = endPasswordValidDate;
	}


	public Long getChgPasswdAlarmDays() {
		return this.chgPasswdAlarmDays;
	}
	public void setChgPasswdAlarmDays(Long chgPasswdAlarmDays) {
		this.chgPasswdAlarmDays = chgPasswdAlarmDays;
	}


	public Long[] getChgPasswdAlarmDayss() {
		return this.chgPasswdAlarmDayss;
	}
	public void setChgPasswdAlarmDayss(Long[] chgPasswdAlarmDayss) {
		this.chgPasswdAlarmDayss = chgPasswdAlarmDayss;
	}


	public Long getStartChgPasswdAlarmDays() {
		return this.startChgPasswdAlarmDays;
	}
	public void setStartChgPasswdAlarmDays(Long startChgPasswdAlarmDays) {
		this.startChgPasswdAlarmDays = startChgPasswdAlarmDays;
	}


	public Long getEndChgPasswdAlarmDays() {
		return this.endChgPasswdAlarmDays;
	}
	public void setEndChgPasswdAlarmDays(Long endChgPasswdAlarmDays) {
		this.endChgPasswdAlarmDays = endChgPasswdAlarmDays;
	}


	public String getSmsChkPasswd() {
		return this.smsChkPasswd;
	}
	public void setSmsChkPasswd(String smsChkPasswd) {
		this.smsChkPasswd = smsChkPasswd;
	}


	public String getSmsChkPasswdEqual() {
		return this.smsChkPasswdEqual;
	}
	public void setSmsChkPasswdEqual(String smsChkPasswdEqual) {
		this.smsChkPasswdEqual = smsChkPasswdEqual;
	}


	public String[] getSmsChkPasswds() {
		return this.smsChkPasswds;
	}
	public void setSmsChkPasswds(String[] smsChkPasswds) {
		this.smsChkPasswds = smsChkPasswds;
	}


	public Long getChkpwEffectTime() {
		return this.chkpwEffectTime;
	}
	public void setChkpwEffectTime(Long chkpwEffectTime) {
		this.chkpwEffectTime = chkpwEffectTime;
	}


	public Long[] getChkpwEffectTimes() {
		return this.chkpwEffectTimes;
	}
	public void setChkpwEffectTimes(Long[] chkpwEffectTimes) {
		this.chkpwEffectTimes = chkpwEffectTimes;
	}


	public Long getStartChkpwEffectTime() {
		return this.startChkpwEffectTime;
	}
	public void setStartChkpwEffectTime(Long startChkpwEffectTime) {
		this.startChkpwEffectTime = startChkpwEffectTime;
	}


	public Long getEndChkpwEffectTime() {
		return this.endChkpwEffectTime;
	}
	public void setEndChkpwEffectTime(Long endChkpwEffectTime) {
		this.endChkpwEffectTime = endChkpwEffectTime;
	}


	public Long getChkpwExpireTime() {
		return this.chkpwExpireTime;
	}
	public void setChkpwExpireTime(Long chkpwExpireTime) {
		this.chkpwExpireTime = chkpwExpireTime;
	}


	public Long[] getChkpwExpireTimes() {
		return this.chkpwExpireTimes;
	}
	public void setChkpwExpireTimes(Long[] chkpwExpireTimes) {
		this.chkpwExpireTimes = chkpwExpireTimes;
	}


	public Long getStartChkpwExpireTime() {
		return this.startChkpwExpireTime;
	}
	public void setStartChkpwExpireTime(Long startChkpwExpireTime) {
		this.startChkpwExpireTime = startChkpwExpireTime;
	}


	public Long getEndChkpwExpireTime() {
		return this.endChkpwExpireTime;
	}
	public void setEndChkpwExpireTime(Long endChkpwExpireTime) {
		this.endChkpwExpireTime = endChkpwExpireTime;
	}


	public Integer getLockFlag() {
		return this.lockFlag;
	}
	public void setLockFlag(Integer lockFlag) {
		this.lockFlag = lockFlag;
	}


	public Integer[] getLockFlags() {
		return this.lockFlags;
	}
	public void setLockFlags(Integer[] lockFlags) {
		this.lockFlags = lockFlags;
	}


	public Integer getStartLockFlag() {
		return this.startLockFlag;
	}
	public void setStartLockFlag(Integer startLockFlag) {
		this.startLockFlag = startLockFlag;
	}


	public Integer getEndLockFlag() {
		return this.endLockFlag;
	}
	public void setEndLockFlag(Integer endLockFlag) {
		this.endLockFlag = endLockFlag;
	}


	public Integer getIsUpdatePwd() {
		return this.isUpdatePwd;
	}
	public void setIsUpdatePwd(Integer isUpdatePwd) {
		this.isUpdatePwd = isUpdatePwd;
	}


	public Integer[] getIsUpdatePwds() {
		return this.isUpdatePwds;
	}
	public void setIsUpdatePwds(Integer[] isUpdatePwds) {
		this.isUpdatePwds = isUpdatePwds;
	}


	public Integer getStartIsUpdatePwd() {
		return this.startIsUpdatePwd;
	}
	public void setStartIsUpdatePwd(Integer startIsUpdatePwd) {
		this.startIsUpdatePwd = startIsUpdatePwd;
	}


	public Integer getEndIsUpdatePwd() {
		return this.endIsUpdatePwd;
	}
	public void setEndIsUpdatePwd(Integer endIsUpdatePwd) {
		this.endIsUpdatePwd = endIsUpdatePwd;
	}


	public String getLoginAuthCode() {
		return this.loginAuthCode;
	}
	public void setLoginAuthCode(String loginAuthCode) {
		this.loginAuthCode = loginAuthCode;
	}


	public String getLoginAuthCodeEqual() {
		return this.loginAuthCodeEqual;
	}
	public void setLoginAuthCodeEqual(String loginAuthCodeEqual) {
		this.loginAuthCodeEqual = loginAuthCodeEqual;
	}


	public String[] getLoginAuthCodes() {
		return this.loginAuthCodes;
	}
	public void setLoginAuthCodes(String[] loginAuthCodes) {
		this.loginAuthCodes = loginAuthCodes;
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


	public Long[] getCustom4s() {
		return this.custom4s;
	}
	public void setCustom4s(Long[] custom4s) {
		this.custom4s = custom4s;
	}


	public Long getStartCustom4() {
		return this.startCustom4;
	}
	public void setStartCustom4(Long startCustom4) {
		this.startCustom4 = startCustom4;
	}


	public Long getEndCustom4() {
		return this.endCustom4;
	}
	public void setEndCustom4(Long endCustom4) {
		this.endCustom4 = endCustom4;
	}


	public Long getCustom5() {
		return this.custom5;
	}
	public void setCustom5(Long custom5) {
		this.custom5 = custom5;
	}


	public Long[] getCustom5s() {
		return this.custom5s;
	}
	public void setCustom5s(Long[] custom5s) {
		this.custom5s = custom5s;
	}


	public Long getStartCustom5() {
		return this.startCustom5;
	}
	public void setStartCustom5(Long startCustom5) {
		this.startCustom5 = startCustom5;
	}


	public Long getEndCustom5() {
		return this.endCustom5;
	}
	public void setEndCustom5(Long endCustom5) {
		this.endCustom5 = endCustom5;
	}


	public Long getCustom6() {
		return this.custom6;
	}
	public void setCustom6(Long custom6) {
		this.custom6 = custom6;
	}


	public Long[] getCustom6s() {
		return this.custom6s;
	}
	public void setCustom6s(Long[] custom6s) {
		this.custom6s = custom6s;
	}


	public Long getStartCustom6() {
		return this.startCustom6;
	}
	public void setStartCustom6(Long startCustom6) {
		this.startCustom6 = startCustom6;
	}


	public Long getEndCustom6() {
		return this.endCustom6;
	}
	public void setEndCustom6(Long endCustom6) {
		this.endCustom6 = endCustom6;
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


	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getCreatorEqual() {
		return this.creatorEqual;
	}
	public void setCreatorEqual(String creatorEqual) {
		this.creatorEqual = creatorEqual;
	}


	public String[] getCreators() {
		return this.creators;
	}
	public void setCreators(String[] creators) {
		this.creators = creators;
	}


	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	public String getModifierEqual() {
		return this.modifierEqual;
	}
	public void setModifierEqual(String modifierEqual) {
		this.modifierEqual = modifierEqual;
	}


	public String[] getModifiers() {
		return this.modifiers;
	}
	public void setModifiers(String[] modifiers) {
		this.modifiers = modifiers;
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



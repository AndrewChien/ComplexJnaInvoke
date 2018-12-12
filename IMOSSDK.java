/**
 * 用途：jna 调用imos_sdk
 */
package imos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;

import imos.IMOSSDK.MAC_ADDRESS_INFO_S.ByValue;

public interface IMOSSDK extends StdCallLibrary {

	IMOSSDK INSTANCE = (IMOSSDK) Native.loadLibrary(DllPath.DLL_PATH + "imos_sdk.dll", IMOSSDK.class);

	public static final int ERR_COMMON_SUCCEED = 0;
	/* @brief 通用64位字符串 */
	public static final int IMOS_STRING_LEN_64 = 64;// 通用64位字符串
	public static final int IMOS_STRING_LEN_128 = 128;// 通用128位字符串
	public static final int IMOS_STRING_LEN_256 = 256;// 通用256位字符串
	public static final int IMOS_STRING_LEN_512 = 512;// 通用512位字符串
	public static final int BROADCAST_DEV_NORMAL = 0;
	/** < 设备在线 */
	public static final int BROADCAST_DEV_OFFLINE = 1;
	/** < 设备离线 */
	public static final int BROADCAST_DEV_PLAYING = 2;
	/** < 设备正在播放 */
	public static final int BRAODCAST_VOICE_FILE = 1;
	public static final int BRAODCAST_VOICE_MIC = 2;
	public static final int BROADCAST_PLAY_MODE_SEQUENCE = 0;
	public static final int BROADCAST_SRV_NONE = 0; /* 无业务 */
	public static final int BROADCAST_SRV_BRDCAST = 1; /* 广播 */
	public static final int BROADCAST_SRV_INTERCUT = 2; /* 插播 */
	public static final int IMOS_PAGE_QUERY_ROW_MAX_NUM = 200;
	/// <summary>
	/// 报警订阅中最大项个数 200
	/// </summary>
	public static final int SDK_SPS_MAX_ITEM_NUM = 200;
	public static final int IMOS_NAME_LEN = 64;
	public static final int IMOS_CODE_LEN = 48;
	public static final int IMOS_IPADDR_LEN = 64;
	/* @brief 资源编码信息字符串长度 */
	public static final int IMOS_RES_CODE_LEN = IMOS_CODE_LEN;
	/* @brief 设备编码信息字符串长度 */
	public static final int IMOS_DEVICE_CODE_LEN = IMOS_CODE_LEN;
	/* @brief 用户编码信息字符串长度 */
	public static final int IMOS_USER_CODE_LEN = IMOS_CODE_LEN;
	/* @brief 域编码信息字符串长度 */
	public static final int IMOS_DOMAIN_CODE_LEN = IMOS_CODE_LEN;
	/* @brief 域名称信息字符串长度 */
	public static final int IMOS_DOMAIN_NAME_LEN = IMOS_NAME_LEN;
	/* @brief 权限编码信息字符串长度 */
	public static final int IMOS_AUTH_CODE_LEN = IMOS_CODE_LEN;
	// 每次查询时返回的最大符合条件的结果的个数
	public static final int QUERY_ITEM_MAX = 200;
	/* @brief imos_time 时间信息字符串长度 "2008-10-02 09:25:33.001 GMT" */
	public static final int IMOS_TIME_LEN = 32;
	/* @brief 文件名长度 */
	public static final int IMOS_FILE_NAME_LEN = 64;
	public static final int ERR_XP_FAIL_TO_SETUP_PROTOCOL = 0x0007B0;
	/** < 建立流控协商失败 */
	public static final int ERR_XP_FAIL_TO_PLAY_PROTOCOL = 0x0007B1;
	/** < 流控协商播放失败 */
	public static final int ERR_XP_FAIL_TO_PAUSE_PROTOCOL = 0x0007B2;
	/** < 流控协商暂停失败 */
	public static final int ERR_XP_FAIL_TO_STOP_PROTOCOL = 0x0007B3;
	/** < 停止流控协商失败 */
	public static final int ERR_XP_RTSP_COMPLETE = 0x0007B4;
	/** < RTSP播放或下载完成 */
	public static final int ERR_XP_RTSP_ABNORMAL_TEATDOWN = 0x0007B5;
	/** < RTSP异常下线，服务器读取文件错误或数据被覆写 */
	public static final int ERR_XP_RTSP_KEEP_LIVE_TIME_OUT = 0x0007B6;
	/** < RTSP保活失败 */
	public static final int ERR_XP_RTSP_ENCODE_CHANGE = 0x0007B7;
	/** < RTSP中码流格式切换 */
	public static final int ERR_XP_RTSP_DISCONNECT = 0x0007B8;
	/** < RTSP连接断开，点播回放或下载已自动终止，请检查网络 */
	public static final int ERR_XP_DISK_CAPACITY_WARN = 0x00079B;
	/** < 硬盘剩余空间低于阈值 */
	public static final int ERR_XP_DISK_CAPACITY_NOT_ENOUGH = 0x00079C;
	/** < 硬盘剩余空间不足，无法继续业务 */
	public static final int ERR_XP_FAIL_TO_WRITE_FILE = 0x000723;
	/** < 写文件操作失败 */
	public static final int ERR_XP_FAIL_TO_PROCESS_MEDIA_DATA = 0x0007A9;
	/** < 媒体数据处理失败 */
	public static final int ERR_XP_NOT_SUPPORT_MEDIA_ENCODE_TYPE = 0x000735;
	/** < 播放通道的媒体编码格式不支持此操作 */
	public static final int ERR_XP_MEDIA_RESOLUTION_CHANGE = 0x000736;
	/** < 播放通道的媒体流分辨率发生变化 */
	/* @brief imos_description 描述信息字符串长度 */
	public static final int IMOS_DESC_LEN = (128 * 3);
	public static final int IMOS_IE_URL_LEN = 512;
	public static final int IMOS_PASSWD_ENCRYPT_LEN = 64;
	public static final int IMOS_QUERY_ITEM_MAX_NUM = 16;
	public static final int IMOS_QUERY_DATA_MAX_LEN = 64;
	public static final int IMOS_DEV_STATUS_ONLINE = 1;
	public static final int IMOS_DEV_STATUS_OFFLINE = 2;
	public static final int IMOS_STREAM_MAXNUM = 2;
	public static final int IMOS_MS_MAX_NUM_PER_CHANNEL = 1;
	public static final int IMOS_DETECT_AREA_MAXNUM = 4;
	public static final int IMOS_MASK_AREA_MAXNUM = 4;
	public static final int IMOS_OSD_NAME_MAXNUM = 1;

	public enum IMOS_TYPE_E {
		IMOS_TYPE_ORG(1),
		/** < 组织域 */
		IMOS_TYPE_OUTER_DOMAIN(2),
		/** < 外域 */
		IMOS_TYPE_LOCAL_DOMAIN(3),
		/** < 本域 */

		IMOS_TYPE_DM(11),
		/** < DM */
		IMOS_TYPE_MS(12),
		/** < MS */
		IMOS_TYPE_VX500(13),
		/** < VX500 */
		IMOS_TYPE_MONITOR(14),
		/** < 监视器 */

		IMOS_TYPE_EC(15),
		/** < EC */
		IMOS_TYPE_DC(16),
		/** < DC */

		IMOS_TYPE_GENERAL(17),
		/** < 通用设备 */

		IMOS_TYPE_MCU(201),
		/** < MCU */
		IMOS_TYPE_MG(202),
		/** < MG */

		IMOS_TYPE_CAMERA(1001),
		/** < 摄像机 */
		IMOS_TYPE_ALARM_SOURCE(1003),
		/** < 告警源 */

		IMOS_TYPE_STORAGE_DEV(1004),
		/** < 存储设备 */
		IMOS_TYPE_TRANS_CHANNEL(1005),
		/** < 透明通道 */

		IMOS_TYPE_ALARM_OUTPUT(1200),
		/** < 告警输出 */

		IMOS_TYPE_GUARD_TOUR_RESOURCE(2001),
		/** < 轮切资源 */
		IMOS_TYPE_GUARD_TOUR_PLAN(2002),
		/** < 轮切计划 */
		IMOS_TYPE_MAP(2003),
		/** < 地图 */

		IMOS_TYPE_XP(2005),
		/** < XP */
		IMOS_TYPE_XP_WIN(2006),
		/** < XP窗格 */
		IMOS_TYPE_GUARD_PLAN(2007),
		/** < 布防计划 */

		IMOS_TYPE_DEV_ALL(2008),
		/** < 所有的设备类型(EC/DC/MS/DM/VX500/摄像头/监视器) */
		IMOS_TYPE_TV_WALL(3001),
		/** < 电视墙 */

		IMOS_TYPE_CONFERENCE(4001),
		/** < 会议资源 */

		IMOS_TYPE_MAX(4002);

		private final int value;

		// 构造方法必须是private或者默认
		private IMOS_TYPE_E(int value) {
			this.value = value;
		}
	}

	/// <summary>
	/// 复杂查询条件约束中的逻辑关系定义
	/// </summary>
	public enum LOGIC_FLAG_E {
		/// <summary>
		/// /* 等于 */
		/// </summary>
		EQUAL_FLAG(0),
		/// <summary>
		/// /* 大于 */
		/// </summary>
		GREAT_FLAG(1),
		/// <summary>
		/// /* 小于 */
		/// </summary>
		LITTLE_FLAG(2),
		/// <summary>
		/// /*大于等于 */
		/// </summary>
		GEQUAL_FLAG(3),
		/// <summary>
		/// /*小于等于 */
		/// </summary>
		LEQUAL_FLAG(4),
		/// <summary>
		/// /*模糊查询 */
		/// </summary>
		LIKE_FLAG(5),
		/// <summary>
		/// /*升序 */
		/// </summary>
		ASCEND_FLAG(6),
		/// <summary>
		/// /*降序 */
		/// </summary>
		DESCEND_FLAG(7),
		/// <summary>
		/// /*不等于 */
		/// </summary>
		NEQUAL_FLAG(8),
		/// <summary>
		/// /*NOT LIKE */
		/// </summary>
		NLIKE_FLAG(13),
		/// <summary>
		/// in 99
		/// </summary>
		IN_FLAG(99),
		/// <summary>
		/// /*无效值 */
		/// </summary>
		LOGIC_FLAG_MAX(100);

		private final int value;

		// 构造方法必须是private或者默认
		private LOGIC_FLAG_E(int value) {
			this.value = value;
		}
	}

	/// <summary>
	/// 查询项类型
	/// @attention 300~500 视讯使用
	/// </summary>
	public enum QUERY_TYPE_E {
		NAME_TYPE(1),
		/** < 名称类型(除用户名称之外) */

		RES_SUB_TYPE(11),
		/** < 资源子类型 */

		/* Begin: Add by x06948 for VVD38087, 20100115 */
		SRV_TYPE(12),
		/** < 业务类型 */
		MONITOR_TYPE(13),
		/** < 监视器类型 */
		MONITOR_NAME(14),
		/** < 监视器名称 */
		MONITOR_DOMAIN(15),
		/** < 监视器所在域 */
		CAMERA_NAME(16),
		/** < 摄像机名称 */
		USER_LOGIN_IP(17),
		/** < 用户登录IP */
		MON_SRV_STATUS(18),
		/** < 实况状态 */
		VOCBRD_SRV_STATUS(19),
		/** < 广播状态 */
		/* End: Add by x06948 for VVD38087, 20100115 */
		// RES_TYPE = 20, /**< 资源类型 */

		CASE_DESC(20),
		/** < 案例描述 */
		TASK_STATUS(21),
		/** < 任务状态 */
		TASK_SUB_TIME(22),
		/** < 任务提交时间 */
		TASK_END_TIME(23),
		/** < 任务结束时间 */
		BAK_START_TIME(24),
		/** < 备份开始时间 */
		BAK_END_TIME(25),
		/** < 备份结束时间 */
		FILE_CREATE_TIME(26),
		/** < 文件创建时间 */
		FILE_CAPACITY(27),
		/** < 文件容量 */
		FILE_TYPE(28),
		/** < 文件类型 */
		FILE_LOCK_FLAG(29),
		/** < 文件锁定标识 */
		LAYOUT_TYPE(30),
		/** < 布局类型，取值为#LAYOUT_TYPE_E */

		/* BEGIN: ADD BY shendongchun 07108 FOR 报表统计 2011-05-30 */
		PHY_DEV_IP(31),
		/* END: ADD BY shendongchun 07108 FOR 报表统计 2011-05-30 */

		ASSET_TYPE(32),
		/** < 资产类型，取值为#ASSET_TYPE_E */
		ASSET_MODEL(33),
		/** < 资产型号 */
		ASSET_MANUFACTURE(34),
		/** < 资产厂商 */
		ASSET_STATUS(35),
		/** < 资产状态，取值为#ASSET_STATUS_E */
		ASSET_PURCHASE_TIME(36),
		/** < 资产采购时间 */
		ASSET_WARRANT_TIME(37),
		/** < 资产保修时间 */
		ASSET_INSTALL_TIME(38),
		/** < 资产安装时间 */
		ASSET_INSTALL_LOCATION(39),
		/** < 资产安装地点 */
		ASSET_PRODEALER(40),
		/** < 资产工程商 */
		FAULT_STAT_TIME(41),
		/** < 故障统计时间 */
		FAULT_TYPE(42),
		/** < 故障类型 */
		FAULT_RECO_TIME(43),
		/** < 故障恢复时间 */
		FAULT_INTERVAL(44),
		/** < 故障时长 */
		FAULT_COUNT(45),
		/** < 故障次数 */

		PLATE_CODE(46),
		/** < 车牌号码 */
		STUFF_TYPE(47),
		/** < 涉案物品类型 */
		STUFF_PROPERTY(48),
		/** < 涉案物品性质 */
		SERIESCASE_TYPE(49),
		/** < 串并案类型 */
		CASEINSE_CODE(50),
		/** < 串并案中案件编号 */
		CASESHARE_TYPE(51),
		/** < 案件共享类型 */
		CASE_PROPERTY(52),
		/** < 案件性质 */
		CASE_TYPE(53),
		/** < 案件类型 */
		CASE_STATUS(54),
		/** < 案件状态 */
		POLICE_INTSRC(55),
		/** < 案件警情来源 */
		CASE_BEGIN_TIME(56),
		/** < 案件开始时间 */
		CASE_END_TIME(57),
		/** < 案件结束时间 */
		STAT_START_TIME(58),
		/** < 统计开始时间 */
		STAT_END_TIME(59),
		/** < 统计结束时间 */
		EBULLETIN_EXPIRE_FLAG(60),
		/** < 电子公告过期标志 */
		CASE_DATA_TYPE(61),
		/** < 案件资料类型 */
		CASE_SOLVED_TIME(63),
		/** < 案件破案时间 */
		CASE_CLOSED_TIME(64),
		/** < 案件结案时间 */
		CASE_UPLOAD_TIME(65),
		/** < 案件资料上传时间 */
		CASE_CREATE_TIME(66),
		/** < 案件创建时间 */
		DEPT_CODE(67),
		/** < 部门编码 */

		DOMAIN_TYPE(100),
		/** < 域类型,现只支持本外域 */

		EXT_DOMAIN_TPYE(200),
		/** < 外域类型:上/下/平级域 */
		EXT_DOMAIN_IP(201),
		/** < 外域IP */
		EXT_DOMAIN_PORT(202),
		/** < 外域PORT */
		EXT_DOMAIN_TRUNK_NUM(203),
		/** < 外域干线数量 */
		EXT_DOMAIN_MULTICAST(204),
		/** < 域间组播策略 */
		EXT_DOMAIN_SESSION(205),
		/** < 外域引流标志 */

		JOB_STATUS(210),
		/** < 升级任务状态 */
		JOB_CREATOR(211),
		/** < 升级任务创建者 */
		JOB_EXEC_TIME(212),
		/** < 升级任务调度时间 */
		JOB_ESTB_TIME(213),
		/** < 升级任务制定时间 */
		JOB_END_TIME(214),
		/** < 升级任务完成时间 */
		JOB_RESULT(215),
		/** < 升级结果 */

		OPER_TIME(220),
		/** < 操作时间 */
		OPER_IP(221),
		/** < 操作者IP地址 */
		OPER_TYPE(222),
		/** < 操作类型 */
		OPER_RESULT(223),
		/** < 操作结果 */
		OPER_SERVICE_TYPE(224),
		/** < 操作的业务类型 */
		OPER_OBJ(225),
		/** < 操作对象 */

		LABEL_TIME(230),
		/** < 标签时间点 */
		REC_START_TIME(231),
		/** < 标签录像开始时间，格式为"hh:mm:ss" */
		REC_END_TIME(232),
		/** < 标签录像结束时间，格式为"hh:mm:ss" */

		USER_FULL_NAME(240),
		/** < 用户全名 */
		USER_TEL_PHONE(241),
		/** < 用户座机电话 */
		USER_MOBILE_PHONE(242),
		/** < 用户移动电话 */
		USER_EMAIL(243),
		/** < 用户电子邮件 */
		USER_IS_LOCKED(244),
		/** < 用户是否被锁定 */

		/* BEGIN: ADD BY lkf2607 FOR PKI 认证 2011-07-06 */
		USER_DESC(245),
		/** < 用户描述 */
		/* END: ADD BY lkf2607 FOR PKI 认证 2011-07-06 */

		ROLE_PRIORITY(250),
		/** < 角色优先级 */

		DEV_TYPE(255),
		/** < 设备类型 */
		RES_TYPE(256),
		/** < 资源类型 */
		IS_QUERY_SUB(257),
		/** < 是否查下级(需要调AS_CON_Parse进行解析) */
		RES_ID(258),
		/** < 资源ID */
		SUPPORT_LINK(259),
		/** < 是否支持联动 */
		SUPPORT_GUARD(260),
		/** < 是否支持布防 */
		RES_ATTRIBUTE(261),
		/** < 资源属性 */
		IS_QUERY_ENCODESET(262),
		/** < 是否查询摄像机或者监视器所在设备的流套餐，对应szQueryData为0-不查询，1-查询 */

		TYPE_ACTION_PLAN(263),
		/** < 预案类型 */
		IS_PLAN_ALARM(264),
		/** < 是否预案告警 */
		IS_ONCE_PLAN_ALARM(265),
		/** < 是否启动过预案 */
		IS_MISINFORM(266),
		/** < 是否误报 */
		CHK_USER_NAME_TYPE(267),
		/** < 核警用户名 */
		TRIGGER_ID(268),
		/** < 触发器ID */

		IS_HIDE_EMPTY_ORG(269),
		/** < 是否隐藏空组织 */
		IS_QUERY_SHARED(270),
		/** < 是查询已共享资源=1还是查未共享资源=0 */

		IS_LEACH_SHARED_BELONG(271),
		/** < 是否过滤掉因为资源共享给外域而在资源表中生成的划归记录(需要调AS_CON_Parse进行解析) */
		RESULT_CODE(272),
		/** < 结果码 */
		RES_ORDER_NUMBER(273),
		/** < 资源排序序号 */

		AUTOID(273),
		/** < 主键 */

		EVENT_TYPE_NAME(273),
		/** < 事件类型名称 */

		CONF_START_TIME(300),
		/** < 会议开始时间，1970年以来的秒数 */
		CONF_END_TIME(301),
		/** < 会议结束时间，1970年以来的秒数 */

		DOMAIN_CODE(350),
		/** < 域编码 */
		TOLLGATE_CODE(351),
		/** < 卡口编号 */
		TOLLGATE_NAME(352),
		/** < 卡口名称 */
		TOLLGATE_CAMERA_CODE(353),
		/** < 卡口相机编码 */
		LANE_NUMBER(354),
		/** < 车道编号 */
		LANE_DIRECTION(355),
		/** < 车道方向编号 */
		PASS_TIME(356),
		/** < 通过时间 */
		VEHICLE_LICENSE_PLATE(357),
		/** < 号牌号码 */
		VEHICLE_LICENSE_PLATE_TYPE(358),
		/** < 号牌种类 */
		VEHICLE_LICENSE_PLATE_COLOR(359),
		/** < 号牌颜色 */
		SPEED_TYPE(360),
		/** < 速度 */
		LIMIT_SPEED(361),
		/** < 限速 */
		VEHICLE_LOGO(362),
		/** < 车辆品牌 */
		VEHICLE_TYPE(363),
		/** < 车辆类型 */
		VEHICLE_COLOR_DEPTH(364),
		/** < 车身颜色深浅 */
		VEHICLE_COLOR(365),
		/** < 车身颜色 */
		VEHICLE_IDENTIFY_STATUS(366),
		/** < 识别状态 */
		VEHICLE_STATUS(367),
		/** < 行驶状态 */
		VEHICLE_DEAL_STATUS(368),
		/** < 车辆处理标记 */
		DISPOSITION_CODE(369),
		/** < 布控编号 */
		DISPOSITION_TYPE(370),
		/** < 布控类别 */
		DISPOSITION_DEPT(371),
		/** < 布控单位 */
		DISPOSITION_USER(372),
		/** < 布控人员 */
		DISPOSITION_STATUS(373),
		/** < 布控状态 */
		DISPOSITION_UNDO_DEPT(374),
		/** < 撤控单位 */
		DISPOSITION_UNDO_USER(375),
		/** < 撤控人员 */
		PRIORITY_TYPE(376),
		/** < 优先级 */
		ALARM_TYPE(377),
		/** < 告警类型 */
		PLATE_ANALYSE_STATUS(378),
		/** < 套牌分析状态 */

		UPLOAD_USER_CODE(519),
		/** < 文件上传用户登录编码 */
		FILE_STATUS(521),
		/** <文件审核状态 */

		QUERY_TYPE_MAX(522);
		/** < 无效值 */

		private final int value;

		// 构造方法必须是private或者默认
		private QUERY_TYPE_E(int value) {
			this.value = value;
		}
	}

	/// <summary>
	/// 用户登录限制MAC地址结构
	/// </summary>
	public static class MAC_ADDRESS_INFO_S extends Structure {
		// 构造函数定义
		public MAC_ADDRESS_INFO_S() {
			super();
		}

		public MAC_ADDRESS_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.MAC_ADDRESS_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.MAC_ADDRESS_INFO_S implements Structure.ByValue {
		}

		/// <summary>
		/// Mac地址
		/// </summary>
		public byte[] szMacAddress = new byte[20];

		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "szMacAddress" });
		}

		public static MAC_ADDRESS_INFO_S.ByValue GetInstance() {
			MAC_ADDRESS_INFO_S.ByValue instance = new MAC_ADDRESS_INFO_S.ByValue();
			instance.szMacAddress = new byte[20];
			return instance;
		}
	}

	/// <summary>
	/// 用户登录扩展信息
	/// </summary>
	public static class LOGIN_EXT_INFO_S extends Structure {
		// 构造函数定义
		public LOGIN_EXT_INFO_S() {
			super();
		}

		public LOGIN_EXT_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.LOGIN_EXT_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.LOGIN_EXT_INFO_S implements Structure.ByValue {
		}

		/// <summary>
		/// IP地址
		/// </summary>
		public byte[] szIpAddress = new byte[IMOS_IPADDR_LEN];
		/// <summary>
		/// Mac地址数量
		/// </summary>
		public int ulOperMachineMacNum;
		/// <summary>
		/// MAC地址列表
		/// </summary>
//		public MAC_ADDRESS_INFO_S.ByValue[] astOperMachineMac = (MAC_ADDRESS_INFO_S.ByValue[]) new MAC_ADDRESS_INFO_S.ByValue()
//				.toArray(20);
		public MAC_ADDRESS_INFO_S.ByValue[] astOperMachineMac = new MAC_ADDRESS_INFO_S.ByValue[20];
		/// <summary>
		/// 用户登录名类型, 区分是用户名称/用户编码, 取值#USER_LOGIN_NAME_TYPE
		/// </summary>
		public int ulLoginNameType;
		/// <summary>
		/// 用户前端的类型 (0~999):BS客户端 0：BS客户端 1：多屏BS客户端 (1000~1999):CS客户端 (2000~2999):移动客户端
		/// </summary>
		public int ulLoginType;
		/// <summary>
		/// 操作系统类型 保留
		/// </summary>
		public int ulOSType;
		/// <summary>
		/// 保留字段
		/// </summary>
		public byte[] szReserve = new byte[116];

		@Override
		protected List getFieldOrder() {
			List fidList = new ArrayList();
			fidList.add("szIpAddress");
			fidList.add("ulOperMachineMacNum");
			fidList.add("astOperMachineMac");
			fidList.add("ulLoginNameType");
			fidList.add("ulLoginType");
			fidList.add("ulOSType");
			fidList.add("szReserve");
			return fidList;
		}

		public static LOGIN_EXT_INFO_S.ByReference GetInstance() {
			LOGIN_EXT_INFO_S.ByReference instance = new LOGIN_EXT_INFO_S.ByReference();
			instance.szIpAddress = new byte[IMOSSDK.IMOS_IPADDR_LEN];
			instance.astOperMachineMac = (MAC_ADDRESS_INFO_S.ByValue[]) new MAC_ADDRESS_INFO_S.ByValue().toArray(20);
			instance.ulOperMachineMacNum = 0;
			for (int i = 0; i < 20; i++) {
				instance.astOperMachineMac[i] = MAC_ADDRESS_INFO_S.GetInstance();
			}
			instance.szReserve = new byte[116];
			return instance;
		}
	}

	/// <summary>
	/// 用户登录ID信息结构
	/// </summary>
	public static class USER_LOGIN_ID_INFO_S extends Structure {
		// 构造函数定义
		public USER_LOGIN_ID_INFO_S() {
			super();
		}

		public USER_LOGIN_ID_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.USER_LOGIN_ID_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.USER_LOGIN_ID_INFO_S implements Structure.ByValue {
		}

		/// <summary>
		/// 用户编码
		/// </summary>
		public byte[] szUserCode = new byte[IMOS_USER_CODE_LEN];

		/// <summary>
		/// 用户登录ID，是用户登录后服务器分配的，它是标记一次用户登录的唯一标识
		/// </summary>
		public byte[] szUserLoginCode = new byte[IMOS_RES_CODE_LEN];

		/// <summary>
		/// 用户登录的客户端IP地址
		/// </summary>
		public byte[] szUserIpAddress = new byte[IMOS_IPADDR_LEN];

		// 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "szUserCode", "szUserLoginCode", "szUserIpAddress" });
		}

		public static USER_LOGIN_ID_INFO_S.ByReference GetInstance() {
			USER_LOGIN_ID_INFO_S.ByReference instance = new USER_LOGIN_ID_INFO_S.ByReference();
			instance.szUserCode = new byte[IMOSSDK.IMOS_USER_CODE_LEN];
			instance.szUserLoginCode = new byte[IMOSSDK.IMOS_RES_CODE_LEN];
			instance.szUserIpAddress = new byte[IMOSSDK.IMOS_IPADDR_LEN];
			return instance;
		}
	}

	/**
	 * @struct tagLoginInfo
	 * @brief 用户登录信息结构体
	 * @attention 无
	 */
	public static class LOGIN_INFO_S extends Structure {
		// 构造函数定义
		public LOGIN_INFO_S() {
			super();
		}

		public LOGIN_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.LOGIN_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.LOGIN_INFO_S implements Structure.ByValue {
		}

		/** 用户登录ID信息 */
		public USER_LOGIN_ID_INFO_S.ByReference stUserLoginIDInfo=new USER_LOGIN_ID_INFO_S.ByReference();

		/** 用户所属组织编码 */
		public byte[] szOrgCode = new byte[IMOS_DOMAIN_CODE_LEN];

		/** 用户所属域名称 */
		public byte[] szDomainName = new byte[IMOS_NAME_LEN];

		/**
		 * 用户所属域类型,
		 * 取值为#MM_DOMAIN_SUBTYPE_LOCAL_PHYSICAL和#MM_DOMAIN_SUBTYPE_LOCAL_VIRTUAL
		 */
		public int ulDomainType;
		
	    /** XP编码 */
		public byte[] szXpCode = new byte[IMOS_DEVICE_CODE_LEN];

	    /** XP第一窗格编码 */
		public byte[] szXpFirstWndCode = new byte[IMOS_RES_CODE_LEN];

	    /** 语音对讲编码 */
		public byte[] szVoiceTalkCode = new byte[IMOS_RES_CODE_LEN];

	    /** 语音广播编码 */
		public byte[] szVoiceBroadcastCode = new byte[IMOS_RES_CODE_LEN];

	    /** SIP通信地址类型，值为:IMOS_IPADDR_TYPE_IPV4/IMOS_IPADDR_TYPE_IPV6 */
		int ulSipAddrType;

	    /** SIP服务器通信IP地址，仅在使用XP的时候有效 */
		public byte[] szSipIpAddress = new byte[IMOS_IPADDR_LEN];

	    /** SIP服务器通信端口号 */
		int ulSipPort;

	    /** 本域服务器编码 */
		public byte[] szServerCode = new byte[IMOS_DEVICE_CODE_LEN];

		@Override
		protected List getFieldOrder() {
			List fidList = new ArrayList();
			fidList.add("stUserLoginIDInfo");
			fidList.add("szOrgCode");
			fidList.add("szDomainName");
			fidList.add("ulDomainType");
			fidList.add("szXpCode");
			fidList.add("szXpFirstWndCode");
			fidList.add("szVoiceTalkCode");
			fidList.add("szVoiceBroadcastCode");
			fidList.add("ulSipAddrType");
			fidList.add("szSipIpAddress");
			fidList.add("ulSipPort");
			fidList.add("szServerCode");
			return fidList;
		}
	}

	public static class QUERY_CONDITION_ITEM_S extends Structure {
		// 构造函数定义
		public QUERY_CONDITION_ITEM_S() {
			super();
		}

		public QUERY_CONDITION_ITEM_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.QUERY_CONDITION_ITEM_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.QUERY_CONDITION_ITEM_S implements Structure.ByValue {
		}

		/// <summary>
		/// 查询条件类型: #QUERY_TYPE_E
		/// </summary>
		public int ulQueryType;

		/// <summary>
		/// 查询条件逻辑关系类型: #LOGIC_FLAG_E
		/// </summary>
		public int ulLogicFlag;

		/// <summary>
		/// 查询条件
		/// </summary>
		public byte[] szQueryData = new byte[IMOS_QUERY_DATA_MAX_LEN];

		// 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulQueryType", "ulLogicFlag", "szQueryData" });
		}

		public static QUERY_CONDITION_ITEM_S.ByReference GetInstance() {
			QUERY_CONDITION_ITEM_S.ByReference instance = new QUERY_CONDITION_ITEM_S.ByReference();
			instance.ulQueryType = 0;
			instance.ulLogicFlag = 0;
			instance.szQueryData = new byte[IMOSSDK.IMOS_QUERY_DATA_MAX_LEN];
			return instance;
		}
	}

	/// <summary>
	/// 通用查询条件
	/// </summary>
	public static class COMMON_QUERY_CONDITION_S extends Structure {
		// 构造函数定义
		public COMMON_QUERY_CONDITION_S() {
			super();
		}

		public COMMON_QUERY_CONDITION_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.COMMON_QUERY_CONDITION_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.COMMON_QUERY_CONDITION_S implements Structure.ByValue {
		}

		/// <summary>
		/// 查询条件数组中查询条件的实际个数,最大取值为#IMOS_QUERY_ITEM_MAX_NUM
		/// </summary>
		public int ulItemNum;

		public QUERY_CONDITION_ITEM_S.ByReference[] astQueryConditionList = (QUERY_CONDITION_ITEM_S.ByReference[]) new QUERY_CONDITION_ITEM_S.ByReference()
				.toArray(IMOS_QUERY_ITEM_MAX_NUM);

		// 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulItemNum", "astQueryConditionList" });
		}

		public static COMMON_QUERY_CONDITION_S.ByReference GetInstance() {
			COMMON_QUERY_CONDITION_S.ByReference stQueryCondition = new COMMON_QUERY_CONDITION_S.ByReference();
			stQueryCondition.astQueryConditionList = (QUERY_CONDITION_ITEM_S.ByReference[]) new QUERY_CONDITION_ITEM_S.ByReference()
					.toArray(IMOS_QUERY_ITEM_MAX_NUM);
			for (int i = 0; i < IMOSSDK.IMOS_QUERY_ITEM_MAX_NUM; i++) {
				stQueryCondition.astQueryConditionList[i] = QUERY_CONDITION_ITEM_S.ByReference.GetInstance();
			}
			stQueryCondition.ulItemNum = 0;
			return stQueryCondition;
		}
	}

	/// <summary>
	/// 分页请求信息
	/// </summary>
	public static class QUERY_PAGE_INFO_S extends Structure {
		// 构造函数定义
		public QUERY_PAGE_INFO_S() {
			super();
		}

		public QUERY_PAGE_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.QUERY_PAGE_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.QUERY_PAGE_INFO_S implements Structure.ByValue {
		}

		/// <summary>
		/// 分页查询中每页的最大条目数, 不能为0, 也不能大于#IMOS_PAGE_QUERY_ROW_MAX_NUM
		/// </summary>
		public int ulPageRowNum;

		/// <summary>
		/// 分页查询中第一条数据的序号(即查询从第ulPageFirstRowNumber条数据开始的符合条件的数据), 取值符合ULONG类型的范围即可
		/// </summary>
		public int ulPageFirstRowNumber;

		/// <summary>
		/// 是否查询条目总数, BooleanRUE时查询; BOOL_FALSE时不查询
		/// </summary>
		public boolean bQueryCount;

		// 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulPageRowNum", "ulPageFirstRowNumber", "bQueryCount" });
		}
	}

	/**
	 * @struct tagRspPageInfo
	 * @brief 分页响应信息
	 * @attention
	 */
	public static class RSP_PAGE_INFO_S extends Structure {
		// 构造函数定义
		public RSP_PAGE_INFO_S() {
			super();
		}

		public RSP_PAGE_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.RSP_PAGE_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.RSP_PAGE_INFO_S implements Structure.ByValue {
		}

		/** 实际返回的条目数 */
		public int ulRowNum;

		/** 符合条件的总条目数 */
		public int ulTotalRowNum;

		// 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulRowNum", "ulTotalRowNum" });
		}
	}

	public static class ORG_RES_QUERY_ITEM_S extends Structure {
		// 构造函数定义
		public ORG_RES_QUERY_ITEM_S() {
			super();
		}

		public ORG_RES_QUERY_ITEM_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.ORG_RES_QUERY_ITEM_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.ORG_RES_QUERY_ITEM_S implements Structure.ByValue {
		}

		/** 资源编码 */
		public byte[] szResCode = new byte[IMOS_RES_CODE_LEN];

		/** 资源名称 */
		public byte[] szResName = new byte[IMOS_NAME_LEN];

		/** 资源类型，取值范围为#IMOS_TYPE_E */
		public int ulResType;

		/**
		 * 资源子类型,目前资源子类型只对摄像机/组织/组显示/组轮巡有效，对摄像机而言为云台/非云台;
		 * 对组织而言为:1-本物理域，2-本域的虚拟域，3-外域的虚拟域. 4-上级外物理域. 5-下级外物理域.6-平级外物理域.
		 * 对组显示资源代表组显示类型，取值为#SALVO_TYPE_E 对组轮巡资源代表组轮巡类型，取值为#GROUP_SWITCH_TYPE_E
		 * 对枪球联动组类型，取值为#BALLLINKAGE_TYPE_E
		 */
		public int ulResSubType;

		/**
		 * 资源状态,取值为:#IMOS_DEV_STATUS_ONLINE,#IMOS_DEV_STATUS_OFFLINE -
		 * 这里的资源,包括物理设备(摄像机/监视器/EC/DC)和外域(对外域来说,该字段代表接收注册状态)
		 */
		public int ulResStatus;

		/**
		 * 资源额外状态 -
		 * 对于摄像机,此字段在其上线并第一次主动上报其视频状态信息后(或视频丢失告警/或视频恢复告警),才有意义,取值为:#IMOS_DEV_EXT_STATUS_E
		 * - 对于外域,该字段代表主动注册状态,取值为:#IMOS_DEV_STATUS_ONLINE,#IMOS_DEV_STATUS_OFFLINE
		 */
		public int ulResExtStatus;

		/** 该资源是否是被划归的资源, 1为被划归的资源; 0为非划归的资源 */
		public int ulResIsBeShare;

		/** 资源所属组织编码 */
		public byte[] szOrgCode = new byte[IMOS_DOMAIN_CODE_LEN];

		/** 支持的流数目，仅当资源类型为摄像机时有效，0:无效值，1:单流，2:双流 3:三流 */
		public int ulStreamNum;

		/** 是否为外域资源，1为外域资源; 0为非外域资源 */
		public int ulResIsForeign;

		@Override
		protected List getFieldOrder() {
			List fidList = new ArrayList();
			fidList.add("szResCode");
			fidList.add("szResName");
			fidList.add("ulResType");
			fidList.add("ulResSubType");
			fidList.add("ulResStatus");
			fidList.add("ulResExtStatus");
			fidList.add("ulResIsBeShare");
			fidList.add("szOrgCode");
			fidList.add("ulStreamNum");
			fidList.add("ulResIsForeign");
			return fidList;
		}

		public static ORG_RES_QUERY_ITEM_S.ByReference GetInstance() {
			ORG_RES_QUERY_ITEM_S.ByReference stRes = new ORG_RES_QUERY_ITEM_S.ByReference();
			stRes.szOrgCode = new byte[IMOSSDK.IMOS_DOMAIN_CODE_LEN];
			stRes.szResCode = new byte[IMOSSDK.IMOS_RES_CODE_LEN];
			stRes.szResName = new byte[IMOSSDK.IMOS_NAME_LEN];
			stRes.ulResExtStatus = 0;
			stRes.ulResIsBeShare = 0;
			stRes.ulResIsForeign = 0;
			stRes.ulResStatus = 0;
			stRes.ulResSubType = 0;
			stRes.ulResType = 0;
			stRes.ulStreamNum = 0;
			return stRes;
		}
	}

	public static class RES_ITEM_V2_S extends Structure {
		// 构造函数定义
		public RES_ITEM_V2_S() {
			super();
		}

		public RES_ITEM_V2_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.RES_ITEM_V2_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.RES_ITEM_V2_S implements Structure.ByValue {
		}

		/** V1资源信息项 */
		public ORG_RES_QUERY_ITEM_S.ByReference stResItemV1;

		/** 资源所属组织的名称 */
		public byte[] szOrgName = new byte[IMOS_NAME_LEN];

		/** 资源属性信息，对于资源类型是摄像机时，取值为#CAMERA_ATTRIBUTE_E，其他资源类型该字段暂未使用 */
		public int ulResAttribute;

		/**
		 * 本域非ECR HF系列的摄像机或者监视器所在的设备的流套餐， 其他资源类型,或者通用查询条件IS_QUERY_ENCODESET没有填写,
		 * 或者填了"不查询", 该字段均为无效值#IMOS_SR_INVALID 取值为#IMOS_STREAM_RELATION_SET_E
		 */
		public int ulDevEncodeSet;

		/* Begin: Modified by lw0581, 2013.12.19 for MPPD06992 */
		/**
		 * 语音业务状态, 对于资源类型为对讲资源、广播资源或者摄像机时有效; 0代表普通状态, 1代表正在对讲, 2代表正在广播,
		 * 枚举为#VOICE_STATUS_FOR_ECR_E
		 */
		public int ulVoiceStatus;

		/** 是否有子资源, 仅当资源类型为广播组时有效 */
		public boolean bHasBrdSubRes;

		/** 是否有资源绑定 BOOL_FALSE--没有绑定, BOOL_TRUE--有绑定 */
		public boolean bIsBind;

		/**
		 * 资源绑定对应信息, 当资源类型为摄像机时, 代表对应绑定关系的语音资源编码, 当资源类型为语音资源时,代码对应绑定关系的摄像机编码, 其他情况无效
		 */
		public byte[] szResBindCode = new byte[IMOS_DEVICE_CODE_LEN];

		/* Begin:Modified by h00275, 2013.4.12 for of V2R1开发 */
		/* 此字段只在资源类型为组织有效，用于区分虚拟域 */
		public int ulSubTypeOfSubType;

		/** 保留字段 */
		public byte[] szReserve = new byte[120];

		@Override
		protected List getFieldOrder() {
			List fidList = new ArrayList();
			fidList.add("stResItemV1");
			fidList.add("szOrgName");
			fidList.add("ulResAttribute");
			fidList.add("ulDevEncodeSet");
			fidList.add("ulVoiceStatus");
			fidList.add("bHasBrdSubRes");
			fidList.add("bIsBind");
			fidList.add("szResBindCode");
			fidList.add("ulSubTypeOfSubType");
			fidList.add("szReserve");
			return fidList;
		}

		public static RES_ITEM_V2_S.ByReference GetInstance(ORG_RES_QUERY_ITEM_S.ByReference stRes) {
			RES_ITEM_V2_S.ByReference stRes_V2 = new RES_ITEM_V2_S.ByReference();
			stRes_V2.stResItemV1 = stRes;
			stRes_V2.szOrgName = new byte[IMOSSDK.IMOS_NAME_LEN];
			stRes_V2.szResBindCode = new byte[IMOSSDK.IMOS_DEVICE_CODE_LEN];
			stRes_V2.szReserve = new byte[120];
			stRes_V2.ulDevEncodeSet = 0;
			stRes_V2.ulResAttribute = 0;
			stRes_V2.ulVoiceStatus = 0;
			stRes_V2.bHasBrdSubRes = false;
			stRes_V2.bIsBind = false;
			stRes_V2.ulSubTypeOfSubType = 0;
			return stRes_V2;
		}
	}

	/**
	 * @struct tagBroadcastParamInfo
	 * @brief 广/插播列表设备信息
	 * @note
	 */
	public static class BROADCAST_DEV_S extends Structure {
		// 构造函数定义
		public BROADCAST_DEV_S() {
			super();
		}

		public BROADCAST_DEV_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.BROADCAST_DEV_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.BROADCAST_DEV_S implements Structure.ByValue {
		}

		/* <设备信息 */
		public byte[] szDevinfo = new byte[IMOS_CODE_LEN];

		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "szDevinfo" });
		}

		public static BROADCAST_DEV_S.ByReference GetInstance() {
			BROADCAST_DEV_S.ByReference stBCDInfo = new BROADCAST_DEV_S.ByReference();
			stBCDInfo.szDevinfo = new byte[IMOSSDK.IMOS_CODE_LEN];
			return stBCDInfo;
		}
	}

	/**
	 * @struct tagBroadcastDevListInfo
	 * @brief 广/插播设备列表信息
	 * @note
	 */
	public static class BROADCAST_DEV_LIST_S extends Structure {
		// 构造函数定义
		public BROADCAST_DEV_LIST_S() {
			super();
		}

		public BROADCAST_DEV_LIST_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.BROADCAST_DEV_LIST_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.BROADCAST_DEV_LIST_S implements Structure.ByValue {
		}

		/* <设备数量,不超过MAX_BROADCAST_DEV_LIST_NUM */
		public int ulDevNum;
		/* <设备列表 */
		public BROADCAST_DEV_S.ByReference[] szDevList = (BROADCAST_DEV_S.ByReference[]) new BROADCAST_DEV_S.ByReference()
				.toArray(SDK_SPS_MAX_ITEM_NUM);
		/* <预留字段 */
		public byte[] szReserved = new byte[IMOS_STRING_LEN_256];

		// 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulDevNum", "szDevList", "szReserved" });
		}

		public static BROADCAST_DEV_LIST_S.ByReference GetInstance() {
			BROADCAST_DEV_LIST_S.ByReference stBCPInfo = new BROADCAST_DEV_LIST_S.ByReference();
			stBCPInfo.szDevList = (BROADCAST_DEV_S.ByReference[]) new BROADCAST_DEV_S.ByReference()
					.toArray(SDK_SPS_MAX_ITEM_NUM);
			for (int i = 0; i < IMOSSDK.SDK_SPS_MAX_ITEM_NUM; i++)
				stBCPInfo.szDevList[i] = BROADCAST_DEV_S.GetInstance();
			stBCPInfo.szReserved = new byte[IMOSSDK.IMOS_STRING_LEN_256];
			stBCPInfo.ulDevNum = 0;
			return stBCPInfo;
		}
	}

	/**
	 * @struct tagBroadcastDevInfo
	 * @brief 广/插播设备列表信息
	 * @note
	 */
	public static class BROADCAST_DEV_INFO_S extends Structure {
		// 构造函数定义
		public BROADCAST_DEV_INFO_S() {
			super();
		}

		public BROADCAST_DEV_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.BROADCAST_DEV_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.BROADCAST_DEV_INFO_S implements Structure.ByValue {
		}

		/* <设备编码 */
		public byte[] szDevCode = new byte[IMOS_CODE_LEN];

		/* <设备名称 */
		public byte[] szDevName = new byte[IMOS_NAME_LEN];

		/* <设备IP地址 */
		public byte[] szIPAddr = new byte[IMOS_IPADDR_LEN];

		/* 设备广播信息 */
		public byte[] szBroadcastCode = new byte[IMOS_STRING_LEN_64];

		/* 设备插播信息 */
		public byte[] szInterCutCode = new byte[IMOS_STRING_LEN_64];

		/* <当前设备状态，表示是否正在播放，取值范围BROADCAST_DEV_STATUS_E */
		public int ulDevBrdStatus;

		/* <预留字段 */
		public byte[] szReserved = new byte[IMOS_STRING_LEN_256];

		@Override
		protected List getFieldOrder() {
			List fidList = new ArrayList();
			fidList.add("szDevCode");
			fidList.add("szDevName");
			fidList.add("szIPAddr");
			fidList.add("szBroadcastCode");
			fidList.add("szInterCutCode");
			fidList.add("ulDevBrdStatus");
			fidList.add("szReserved");
			return fidList;
		}
		
		public static BROADCAST_DEV_INFO_S.ByReference GetInstance() {
			BROADCAST_DEV_INFO_S.ByReference stBCDInfo = new BROADCAST_DEV_INFO_S.ByReference();
			stBCDInfo.szDevCode = new byte[IMOSSDK.IMOS_CODE_LEN];
			stBCDInfo.szDevName = new byte[IMOSSDK.IMOS_NAME_LEN];
			stBCDInfo.szIPAddr = new byte[IMOSSDK.IMOS_IPADDR_LEN];
			stBCDInfo.szBroadcastCode = new byte[IMOSSDK.IMOS_STRING_LEN_64];
			stBCDInfo.szInterCutCode = new byte[IMOSSDK.IMOS_STRING_LEN_64];
			stBCDInfo.szReserved = new byte[IMOSSDK.IMOS_STRING_LEN_256];
			stBCDInfo.ulDevBrdStatus = 0;
			return stBCDInfo;
		}
	}

	public static class PLAY_WND_INFO_S extends Structure {
		// 构造函数定义
		public PLAY_WND_INFO_S() {
			super();
		}

		public PLAY_WND_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.PLAY_WND_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.PLAY_WND_INFO_S implements Structure.ByValue {
		}

		public byte[] szPlayWndCode = new byte[IMOS_RES_CODE_LEN];

		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "szPlayWndCode" });
		}
	}

	/**
	 * @struct tagBroadcastParamInfo
	 * @brief 广/插播信息
	 * @note
	 */
	public static class BROADCAST_PARAM_INFO_S extends Structure {
		// 构造函数定义
		public BROADCAST_PARAM_INFO_S() {
			super();
		}

		public BROADCAST_PARAM_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.BROADCAST_PARAM_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.BROADCAST_PARAM_INFO_S implements Structure.ByValue {
		}

		/* <语音类型，取值范围BRAODCAST_VOICE_TYPE_E */
		public int ulVoiceType;
		/* <播放方式 ，取值范围BROADCAST_PLAY_MODE_E，当前只取BROADCAST_PLAY_MODE_SEQUENCE */
		public int ulModeType;
		/* <URL or 文件名 or 节目ID */
		public byte[] szBroacastInfo = new byte[IMOS_STRING_LEN_512];
		/* <该动作备注描述, 用于记录日志 */
		public byte[] szBroadcastDesc = new byte[IMOS_STRING_LEN_128];
		/* <预留字段 */
		public byte[] szReserved = new byte[IMOS_STRING_LEN_256];

		@Override
		protected List getFieldOrder() {
			List fidList = new ArrayList();
			fidList.add("ulVoiceType");
			fidList.add("ulModeType");
			fidList.add("szBroacastInfo");
			fidList.add("szBroadcastDesc");
			fidList.add("szReserved");
			return fidList;
		}

		public static BROADCAST_PARAM_INFO_S.ByReference GetInstance() {
			BROADCAST_PARAM_INFO_S.ByReference stBCPInfo = new BROADCAST_PARAM_INFO_S.ByReference();
			stBCPInfo.szBroacastInfo = new byte[IMOSSDK.IMOS_STRING_LEN_512];
			stBCPInfo.szBroadcastDesc = new byte[IMOSSDK.IMOS_STRING_LEN_128];
			stBCPInfo.szReserved = new byte[IMOSSDK.IMOS_STRING_LEN_256];
			stBCPInfo.ulModeType = 0;
			stBCPInfo.ulVoiceType = 0;
			return stBCPInfo;
		}
	}

	/**
	 * @struct tagBroadcastInfo
	 * @brief 广播信息
	 * @attention
	 */
	public static class BROADCAST_INFO_S extends Structure {
		// 构造函数定义
		public BROADCAST_INFO_S() {
			super();
		}

		public BROADCAST_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.BROADCAST_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.BROADCAST_INFO_S implements Structure.ByValue {
		}

		/** 用户编码 */
		public byte[] szUserCode = new byte[IMOS_USER_CODE_LEN];

		/** 用户登录ID，是用户登录后服务器分配 */
		public byte[] szUserLoginCode = new byte[IMOS_RES_CODE_LEN];

		/** 用户登录的客户端IP地址 */
		public byte[] szUserIpAddress = new byte[IMOS_IPADDR_LEN];

		/* 广播或插播编码 */
		public byte[] szXPVocBrdCode = new byte[IMOS_RES_CODE_LEN];

		/* 业务类型，取值范围BROADCAST_SRV_TYPE_E */
		public int ulSrvType;

		/* <插播/广播类型 ，取值范围BRAODCAST_VOICE_TYPE_E */
		public int ulVoiceType;

		/* <URL or 文件名 */
		public byte[] szBroacastInfo = new byte[IMOS_STRING_LEN_512];

		/* <预留字段 */
		public byte[] szReserved = new byte[IMOS_STRING_LEN_256];

		@Override
		protected List getFieldOrder() {
			List fidList = new ArrayList();
			fidList.add("szUserCode");
			fidList.add("szUserLoginCode");
			fidList.add("szUserIpAddress");
			fidList.add("szXPVocBrdCode");
			fidList.add("ulSrvType");
			fidList.add("ulVoiceType");
			fidList.add("szBroacastInfo");
			fidList.add("szReserved");
			return fidList;
		}
		
		public static BROADCAST_INFO_S.ByReference GetInstance() {
			BROADCAST_INFO_S.ByReference stBCInfo = new BROADCAST_INFO_S.ByReference();
			stBCInfo.szUserCode = new byte[IMOSSDK.IMOS_USER_CODE_LEN];
			stBCInfo.szUserLoginCode = new byte[IMOSSDK.IMOS_RES_CODE_LEN];
			stBCInfo.szUserIpAddress = new byte[IMOSSDK.IMOS_IPADDR_LEN];
			stBCInfo.szXPVocBrdCode = new byte[IMOSSDK.IMOS_RES_CODE_LEN];
			stBCInfo.szBroacastInfo = new byte[IMOSSDK.IMOS_STRING_LEN_512];
			stBCInfo.szReserved = new byte[IMOSSDK.IMOS_STRING_LEN_256];
			stBCInfo.ulSrvType = 100; // 初始化一个非法值
			stBCInfo.ulVoiceType = 101;
			return stBCInfo;
		}
	}

	public static class PRESET_INFO_S extends Structure {
		// 构造函数定义
		public PRESET_INFO_S() {
			super();
		}

		public PRESET_INFO_S(Pointer _a) {
			super(_a);
		}

		public static class ByReference extends IMOSSDK.PRESET_INFO_S implements Structure.ByReference {
		}

		public static class ByValue extends IMOSSDK.PRESET_INFO_S implements Structure.ByValue {
		}

		/** 预置位值, 取值范围为#PTZ_PRESET_MINVALUE~服务器配置文件里配置的预置位最大值 */
		public int ulPresetValue;

		/** 预置位描述, 需要填写 */
		public byte[] szPresetDesc = new byte[IMOS_DESC_LEN];

		// 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulPresetValue", "szPresetDesc" });
		}
	}

	public int IMOS_Initiate(byte[] szServerAdd, int ulServerPort, int bUIFlag, int bXPFlag);

	/// 用户登录接口V2
	/// </summary>
	/// <param name="szUserLoginName">用户登录用户名</param>
	/// <param name="szPassword">用户登录密码</param>
	/// <param name="szIpAddress">用户登录IP</param>
	/// <param name="pstLoginExtInfo">用户登录扩展信息</param>
	/// <param name="IntPtr">用户登录信息</param>
	/// <returns></returns>
	public int IMOS_LoginV2(byte[] szUserLoginName, byte[] szPassword, byte[] szIpAddress,
			LOGIN_EXT_INFO_S.ByReference pstLoginExtInfo, LOGIN_INFO_S.ByReference pstSDKLoginInfo);

	public int IMOS_Encrypt(String strInput, int ulInLen, byte[] ptrOutput);

	public int IMOS_QueryResourceListV2(USER_LOGIN_ID_INFO_S.ByReference pstUserLogIDInfo, byte[] szOrgCode,
			COMMON_QUERY_CONDITION_S.ByReference pstQueryCondition, QUERY_PAGE_INFO_S.ByReference pstQueryPageInfo,
			RSP_PAGE_INFO_S.ByReference pstRspPageInfo, RES_ITEM_V2_S.ByReference pstResList);

	/**
	 * 查询组织下资源信息列表(V2,扩展返回"资源所属组织的名称") \n
	 * 
	 * @param [IN]
	 *            pstUserLogIDInfo 用户登录ID信息标识
	 * @param [IN]
	 *            szOrgCode 组织编码
	 * @param [IN]
	 *            pstQueryCondition 查询条件
	 * @param [IN]
	 *            pstQueryPageInfo 请求分页信息
	 * @param [OUT]
	 *            pstRspPageInfo 响应分页信息
	 * @param [OUT]
	 *            pstResList 资源信息列表
	 * @return ULONG 返回如下结果： - 成功： - #ERR_COMMON_SUCCEED - 失败： -
	 *         #ERR_DAO_DOMAIN_NOT_EXIST - 返回操作结果码，见错误码文件
	 * @note - 过滤 - 1.条件可以为NULL,表示查指定组织下所有资源(不查子组织); -
	 *       2.支持按"是否查子组织"条件查询:#IS_QUERY_SUB = 1 是;= 0 否; -
	 *       3.支持按"资源名称"模糊查询:#NAME_TYPE; - 4.支持按"是否外域资源"查询:#DOMAIN_TYPE = 1 是;= 0 否;
	 *       - 5.支持按"资源类型"查询:#RES_TYPE,取值为#IMOS_TYPE_E, 仅支持逻辑关系类型为#EQUAL_FLAG; -
	 *       6.支持按"资源子类型"查询:#RES_SUB_TYPE(资源类型为摄像机时,取值为#CAMERA_TYPE_E); -
	 *       7.支持按"资源属性"查询:#RES_ATTRIBUTE(资源类型为摄像机时,取值为#CAMERA_ATTRIBUTE_E); -
	 *       8.支持"流套餐"查询:#IS_QUERY_ENCODESET (资源类型为摄像机或监视器时,
	 *       取值为#0-不查询，则pstResList中的ulDevEncodeSet无效;
	 *       取值为#1-查询，则pstResList中的ulDevEncodeSet有效); - 9.支持是否开启隐藏空组织:
	 *       #IS_HIDE_EMPTY_ORG = 1 是; =0 否 - 10.支持是否过滤掉因为资源共享给外域而在资源表中生成的划归记录:
	 *       #IS_LEACH_SHARED_BELONG = 1 是; = 0 否 - 排序 - 1.不指定排序条件情况下,默认按"资源名称"升序排序
	 *       -
	 *       2.支持的排序条件,包括:#NAME_TYPE(资源名称),#CODE_TYPE(资源编码),#RES_TYPE(资源类型),#RES_SUB_TYPE(资源子类型),
	 *       - #DOMAIN_TYPE(是否外域资源),#RES_ATTRIBUTE(资源属性),#RES_ORDER_NUMBER(资源序号)
	 */
	// IMOS_EXPORT ULONG_32 STDCALL IMOS_QueryResourceListV2
	// (
	// IN USER_LOGIN_ID_INFO_S *pstUserLogIDInfo,
	// IN CHAR szOrgCode[IMOS_DOMAIN_CODE_LEN],
	// IN COMMON_QUERY_CONDITION_S *pstQueryCondition,
	// IN QUERY_PAGE_INFO_S *pstQueryPageInfo,
	// OUT RSP_PAGE_INFO_S *pstRspPageInfo,
	// OUT RES_ITEM_V2_S *pstResList
	// );

	public int IMOS_QueryBroadcastDevInfo(USER_LOGIN_ID_INFO_S.ByReference pstUserLoginIDInfo,
			BROADCAST_DEV_LIST_S.ByReference pstDevListInfo, int pulDevNum,
			BROADCAST_DEV_INFO_S.ByReference pstBroadcastDevList);

	public void IMOS_LogoutEx(USER_LOGIN_ID_INFO_S.ByReference stUserLoginInfo);

	public int IMOS_StartPlayer(USER_LOGIN_ID_INFO_S.ByReference stUserLoginInfo, int ulPlayWndNum,
			PLAY_WND_INFO_S.ByReference ptrPlayWndInfo);

	/// <summary>
	/// 共用，开启MP3广播、喊话
	/// </summary>
	/// <param name="pstUserLoginIDInfo"></param>
	/// <param name="pstParamInfo"></param>
	/// <param name="pstBrdcastDevList"></param>
	/// <param name="pstBrdcastInfo"></param>
	/// <returns></returns>
	public int IMOS_StartBroadCast(USER_LOGIN_ID_INFO_S.ByReference pstUserLoginIDInfo,
			BROADCAST_PARAM_INFO_S.ByReference pstParamInfo, BROADCAST_DEV_LIST_S.ByReference pstBrdcastDevList,
			BROADCAST_INFO_S.ByReference pstBrdcastInfo);

	/// <summary>
	/// 共用，关闭MP3广播、喊话
	/// </summary>
	/// <param name="pstUserLoginIDInfo"></param>
	/// <param name="pstBroadCastListInfo"></param>
	/// <returns></returns>
	public int IMOS_CloseDevBroadCast(USER_LOGIN_ID_INFO_S.ByReference pstUserLoginIDInfo,
			BROADCAST_DEV_LIST_S.ByReference pstBroadCastListInfo);

	public class IMOS_Device {
		/// <summary>
		/// 设备名称
		/// </summary>
		public String DeviceName;
		/// <summary>
		/// 设备编码
		/// </summary>
		public String DeviceCode;
		/// <summary>
		/// 设备IP
		/// </summary>
		public String DeviceIP;
		/// <summary>
		/// 设备类型
		/// </summary>
		public String DeviceType;
		/// <summary>
		/// 设备状态
		/// </summary>
		public String DeviceStatus;
	}
}
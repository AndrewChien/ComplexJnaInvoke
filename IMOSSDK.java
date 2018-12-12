/**
 * ��;��jna ����imos_sdk
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
	/* @brief ͨ��64λ�ַ��� */
	public static final int IMOS_STRING_LEN_64 = 64;// ͨ��64λ�ַ���
	public static final int IMOS_STRING_LEN_128 = 128;// ͨ��128λ�ַ���
	public static final int IMOS_STRING_LEN_256 = 256;// ͨ��256λ�ַ���
	public static final int IMOS_STRING_LEN_512 = 512;// ͨ��512λ�ַ���
	public static final int BROADCAST_DEV_NORMAL = 0;
	/** < �豸���� */
	public static final int BROADCAST_DEV_OFFLINE = 1;
	/** < �豸���� */
	public static final int BROADCAST_DEV_PLAYING = 2;
	/** < �豸���ڲ��� */
	public static final int BRAODCAST_VOICE_FILE = 1;
	public static final int BRAODCAST_VOICE_MIC = 2;
	public static final int BROADCAST_PLAY_MODE_SEQUENCE = 0;
	public static final int BROADCAST_SRV_NONE = 0; /* ��ҵ�� */
	public static final int BROADCAST_SRV_BRDCAST = 1; /* �㲥 */
	public static final int BROADCAST_SRV_INTERCUT = 2; /* �岥 */
	public static final int IMOS_PAGE_QUERY_ROW_MAX_NUM = 200;
	/// <summary>
	/// ������������������ 200
	/// </summary>
	public static final int SDK_SPS_MAX_ITEM_NUM = 200;
	public static final int IMOS_NAME_LEN = 64;
	public static final int IMOS_CODE_LEN = 48;
	public static final int IMOS_IPADDR_LEN = 64;
	/* @brief ��Դ������Ϣ�ַ������� */
	public static final int IMOS_RES_CODE_LEN = IMOS_CODE_LEN;
	/* @brief �豸������Ϣ�ַ������� */
	public static final int IMOS_DEVICE_CODE_LEN = IMOS_CODE_LEN;
	/* @brief �û�������Ϣ�ַ������� */
	public static final int IMOS_USER_CODE_LEN = IMOS_CODE_LEN;
	/* @brief �������Ϣ�ַ������� */
	public static final int IMOS_DOMAIN_CODE_LEN = IMOS_CODE_LEN;
	/* @brief ��������Ϣ�ַ������� */
	public static final int IMOS_DOMAIN_NAME_LEN = IMOS_NAME_LEN;
	/* @brief Ȩ�ޱ�����Ϣ�ַ������� */
	public static final int IMOS_AUTH_CODE_LEN = IMOS_CODE_LEN;
	// ÿ�β�ѯʱ���ص������������Ľ���ĸ���
	public static final int QUERY_ITEM_MAX = 200;
	/* @brief imos_time ʱ����Ϣ�ַ������� "2008-10-02 09:25:33.001 GMT" */
	public static final int IMOS_TIME_LEN = 32;
	/* @brief �ļ������� */
	public static final int IMOS_FILE_NAME_LEN = 64;
	public static final int ERR_XP_FAIL_TO_SETUP_PROTOCOL = 0x0007B0;
	/** < ��������Э��ʧ�� */
	public static final int ERR_XP_FAIL_TO_PLAY_PROTOCOL = 0x0007B1;
	/** < ����Э�̲���ʧ�� */
	public static final int ERR_XP_FAIL_TO_PAUSE_PROTOCOL = 0x0007B2;
	/** < ����Э����ͣʧ�� */
	public static final int ERR_XP_FAIL_TO_STOP_PROTOCOL = 0x0007B3;
	/** < ֹͣ����Э��ʧ�� */
	public static final int ERR_XP_RTSP_COMPLETE = 0x0007B4;
	/** < RTSP���Ż�������� */
	public static final int ERR_XP_RTSP_ABNORMAL_TEATDOWN = 0x0007B5;
	/** < RTSP�쳣���ߣ���������ȡ�ļ���������ݱ���д */
	public static final int ERR_XP_RTSP_KEEP_LIVE_TIME_OUT = 0x0007B6;
	/** < RTSP����ʧ�� */
	public static final int ERR_XP_RTSP_ENCODE_CHANGE = 0x0007B7;
	/** < RTSP��������ʽ�л� */
	public static final int ERR_XP_RTSP_DISCONNECT = 0x0007B8;
	/** < RTSP���ӶϿ����㲥�طŻ��������Զ���ֹ���������� */
	public static final int ERR_XP_DISK_CAPACITY_WARN = 0x00079B;
	/** < Ӳ��ʣ��ռ������ֵ */
	public static final int ERR_XP_DISK_CAPACITY_NOT_ENOUGH = 0x00079C;
	/** < Ӳ��ʣ��ռ䲻�㣬�޷�����ҵ�� */
	public static final int ERR_XP_FAIL_TO_WRITE_FILE = 0x000723;
	/** < д�ļ�����ʧ�� */
	public static final int ERR_XP_FAIL_TO_PROCESS_MEDIA_DATA = 0x0007A9;
	/** < ý�����ݴ���ʧ�� */
	public static final int ERR_XP_NOT_SUPPORT_MEDIA_ENCODE_TYPE = 0x000735;
	/** < ����ͨ����ý������ʽ��֧�ִ˲��� */
	public static final int ERR_XP_MEDIA_RESOLUTION_CHANGE = 0x000736;
	/** < ����ͨ����ý�����ֱ��ʷ����仯 */
	/* @brief imos_description ������Ϣ�ַ������� */
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
		/** < ��֯�� */
		IMOS_TYPE_OUTER_DOMAIN(2),
		/** < ���� */
		IMOS_TYPE_LOCAL_DOMAIN(3),
		/** < ���� */

		IMOS_TYPE_DM(11),
		/** < DM */
		IMOS_TYPE_MS(12),
		/** < MS */
		IMOS_TYPE_VX500(13),
		/** < VX500 */
		IMOS_TYPE_MONITOR(14),
		/** < ������ */

		IMOS_TYPE_EC(15),
		/** < EC */
		IMOS_TYPE_DC(16),
		/** < DC */

		IMOS_TYPE_GENERAL(17),
		/** < ͨ���豸 */

		IMOS_TYPE_MCU(201),
		/** < MCU */
		IMOS_TYPE_MG(202),
		/** < MG */

		IMOS_TYPE_CAMERA(1001),
		/** < ����� */
		IMOS_TYPE_ALARM_SOURCE(1003),
		/** < �澯Դ */

		IMOS_TYPE_STORAGE_DEV(1004),
		/** < �洢�豸 */
		IMOS_TYPE_TRANS_CHANNEL(1005),
		/** < ͸��ͨ�� */

		IMOS_TYPE_ALARM_OUTPUT(1200),
		/** < �澯��� */

		IMOS_TYPE_GUARD_TOUR_RESOURCE(2001),
		/** < ������Դ */
		IMOS_TYPE_GUARD_TOUR_PLAN(2002),
		/** < ���мƻ� */
		IMOS_TYPE_MAP(2003),
		/** < ��ͼ */

		IMOS_TYPE_XP(2005),
		/** < XP */
		IMOS_TYPE_XP_WIN(2006),
		/** < XP���� */
		IMOS_TYPE_GUARD_PLAN(2007),
		/** < �����ƻ� */

		IMOS_TYPE_DEV_ALL(2008),
		/** < ���е��豸����(EC/DC/MS/DM/VX500/����ͷ/������) */
		IMOS_TYPE_TV_WALL(3001),
		/** < ����ǽ */

		IMOS_TYPE_CONFERENCE(4001),
		/** < ������Դ */

		IMOS_TYPE_MAX(4002);

		private final int value;

		// ���췽��������private����Ĭ��
		private IMOS_TYPE_E(int value) {
			this.value = value;
		}
	}

	/// <summary>
	/// ���Ӳ�ѯ����Լ���е��߼���ϵ����
	/// </summary>
	public enum LOGIC_FLAG_E {
		/// <summary>
		/// /* ���� */
		/// </summary>
		EQUAL_FLAG(0),
		/// <summary>
		/// /* ���� */
		/// </summary>
		GREAT_FLAG(1),
		/// <summary>
		/// /* С�� */
		/// </summary>
		LITTLE_FLAG(2),
		/// <summary>
		/// /*���ڵ��� */
		/// </summary>
		GEQUAL_FLAG(3),
		/// <summary>
		/// /*С�ڵ��� */
		/// </summary>
		LEQUAL_FLAG(4),
		/// <summary>
		/// /*ģ����ѯ */
		/// </summary>
		LIKE_FLAG(5),
		/// <summary>
		/// /*���� */
		/// </summary>
		ASCEND_FLAG(6),
		/// <summary>
		/// /*���� */
		/// </summary>
		DESCEND_FLAG(7),
		/// <summary>
		/// /*������ */
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
		/// /*��Чֵ */
		/// </summary>
		LOGIC_FLAG_MAX(100);

		private final int value;

		// ���췽��������private����Ĭ��
		private LOGIC_FLAG_E(int value) {
			this.value = value;
		}
	}

	/// <summary>
	/// ��ѯ������
	/// @attention 300~500 ��Ѷʹ��
	/// </summary>
	public enum QUERY_TYPE_E {
		NAME_TYPE(1),
		/** < ��������(���û�����֮��) */

		RES_SUB_TYPE(11),
		/** < ��Դ������ */

		/* Begin: Add by x06948 for VVD38087, 20100115 */
		SRV_TYPE(12),
		/** < ҵ������ */
		MONITOR_TYPE(13),
		/** < ���������� */
		MONITOR_NAME(14),
		/** < ���������� */
		MONITOR_DOMAIN(15),
		/** < ������������ */
		CAMERA_NAME(16),
		/** < ��������� */
		USER_LOGIN_IP(17),
		/** < �û���¼IP */
		MON_SRV_STATUS(18),
		/** < ʵ��״̬ */
		VOCBRD_SRV_STATUS(19),
		/** < �㲥״̬ */
		/* End: Add by x06948 for VVD38087, 20100115 */
		// RES_TYPE = 20, /**< ��Դ���� */

		CASE_DESC(20),
		/** < �������� */
		TASK_STATUS(21),
		/** < ����״̬ */
		TASK_SUB_TIME(22),
		/** < �����ύʱ�� */
		TASK_END_TIME(23),
		/** < �������ʱ�� */
		BAK_START_TIME(24),
		/** < ���ݿ�ʼʱ�� */
		BAK_END_TIME(25),
		/** < ���ݽ���ʱ�� */
		FILE_CREATE_TIME(26),
		/** < �ļ�����ʱ�� */
		FILE_CAPACITY(27),
		/** < �ļ����� */
		FILE_TYPE(28),
		/** < �ļ����� */
		FILE_LOCK_FLAG(29),
		/** < �ļ�������ʶ */
		LAYOUT_TYPE(30),
		/** < �������ͣ�ȡֵΪ#LAYOUT_TYPE_E */

		/* BEGIN: ADD BY shendongchun 07108 FOR ����ͳ�� 2011-05-30 */
		PHY_DEV_IP(31),
		/* END: ADD BY shendongchun 07108 FOR ����ͳ�� 2011-05-30 */

		ASSET_TYPE(32),
		/** < �ʲ����ͣ�ȡֵΪ#ASSET_TYPE_E */
		ASSET_MODEL(33),
		/** < �ʲ��ͺ� */
		ASSET_MANUFACTURE(34),
		/** < �ʲ����� */
		ASSET_STATUS(35),
		/** < �ʲ�״̬��ȡֵΪ#ASSET_STATUS_E */
		ASSET_PURCHASE_TIME(36),
		/** < �ʲ��ɹ�ʱ�� */
		ASSET_WARRANT_TIME(37),
		/** < �ʲ�����ʱ�� */
		ASSET_INSTALL_TIME(38),
		/** < �ʲ���װʱ�� */
		ASSET_INSTALL_LOCATION(39),
		/** < �ʲ���װ�ص� */
		ASSET_PRODEALER(40),
		/** < �ʲ������� */
		FAULT_STAT_TIME(41),
		/** < ����ͳ��ʱ�� */
		FAULT_TYPE(42),
		/** < �������� */
		FAULT_RECO_TIME(43),
		/** < ���ϻָ�ʱ�� */
		FAULT_INTERVAL(44),
		/** < ����ʱ�� */
		FAULT_COUNT(45),
		/** < ���ϴ��� */

		PLATE_CODE(46),
		/** < ���ƺ��� */
		STUFF_TYPE(47),
		/** < �永��Ʒ���� */
		STUFF_PROPERTY(48),
		/** < �永��Ʒ���� */
		SERIESCASE_TYPE(49),
		/** < ���������� */
		CASEINSE_CODE(50),
		/** < �������а������ */
		CASESHARE_TYPE(51),
		/** < ������������ */
		CASE_PROPERTY(52),
		/** < �������� */
		CASE_TYPE(53),
		/** < �������� */
		CASE_STATUS(54),
		/** < ����״̬ */
		POLICE_INTSRC(55),
		/** < ����������Դ */
		CASE_BEGIN_TIME(56),
		/** < ������ʼʱ�� */
		CASE_END_TIME(57),
		/** < ��������ʱ�� */
		STAT_START_TIME(58),
		/** < ͳ�ƿ�ʼʱ�� */
		STAT_END_TIME(59),
		/** < ͳ�ƽ���ʱ�� */
		EBULLETIN_EXPIRE_FLAG(60),
		/** < ���ӹ�����ڱ�־ */
		CASE_DATA_TYPE(61),
		/** < ������������ */
		CASE_SOLVED_TIME(63),
		/** < �����ư�ʱ�� */
		CASE_CLOSED_TIME(64),
		/** < �����᰸ʱ�� */
		CASE_UPLOAD_TIME(65),
		/** < ���������ϴ�ʱ�� */
		CASE_CREATE_TIME(66),
		/** < ��������ʱ�� */
		DEPT_CODE(67),
		/** < ���ű��� */

		DOMAIN_TYPE(100),
		/** < ������,��ֻ֧�ֱ����� */

		EXT_DOMAIN_TPYE(200),
		/** < ��������:��/��/ƽ���� */
		EXT_DOMAIN_IP(201),
		/** < ����IP */
		EXT_DOMAIN_PORT(202),
		/** < ����PORT */
		EXT_DOMAIN_TRUNK_NUM(203),
		/** < ����������� */
		EXT_DOMAIN_MULTICAST(204),
		/** < ����鲥���� */
		EXT_DOMAIN_SESSION(205),
		/** < ����������־ */

		JOB_STATUS(210),
		/** < ��������״̬ */
		JOB_CREATOR(211),
		/** < �������񴴽��� */
		JOB_EXEC_TIME(212),
		/** < �����������ʱ�� */
		JOB_ESTB_TIME(213),
		/** < ���������ƶ�ʱ�� */
		JOB_END_TIME(214),
		/** < �����������ʱ�� */
		JOB_RESULT(215),
		/** < ������� */

		OPER_TIME(220),
		/** < ����ʱ�� */
		OPER_IP(221),
		/** < ������IP��ַ */
		OPER_TYPE(222),
		/** < �������� */
		OPER_RESULT(223),
		/** < ������� */
		OPER_SERVICE_TYPE(224),
		/** < ������ҵ������ */
		OPER_OBJ(225),
		/** < �������� */

		LABEL_TIME(230),
		/** < ��ǩʱ��� */
		REC_START_TIME(231),
		/** < ��ǩ¼��ʼʱ�䣬��ʽΪ"hh:mm:ss" */
		REC_END_TIME(232),
		/** < ��ǩ¼�����ʱ�䣬��ʽΪ"hh:mm:ss" */

		USER_FULL_NAME(240),
		/** < �û�ȫ�� */
		USER_TEL_PHONE(241),
		/** < �û������绰 */
		USER_MOBILE_PHONE(242),
		/** < �û��ƶ��绰 */
		USER_EMAIL(243),
		/** < �û������ʼ� */
		USER_IS_LOCKED(244),
		/** < �û��Ƿ����� */

		/* BEGIN: ADD BY lkf2607 FOR PKI ��֤ 2011-07-06 */
		USER_DESC(245),
		/** < �û����� */
		/* END: ADD BY lkf2607 FOR PKI ��֤ 2011-07-06 */

		ROLE_PRIORITY(250),
		/** < ��ɫ���ȼ� */

		DEV_TYPE(255),
		/** < �豸���� */
		RES_TYPE(256),
		/** < ��Դ���� */
		IS_QUERY_SUB(257),
		/** < �Ƿ���¼�(��Ҫ��AS_CON_Parse���н���) */
		RES_ID(258),
		/** < ��ԴID */
		SUPPORT_LINK(259),
		/** < �Ƿ�֧������ */
		SUPPORT_GUARD(260),
		/** < �Ƿ�֧�ֲ��� */
		RES_ATTRIBUTE(261),
		/** < ��Դ���� */
		IS_QUERY_ENCODESET(262),
		/** < �Ƿ��ѯ��������߼����������豸�����ײͣ���ӦszQueryDataΪ0-����ѯ��1-��ѯ */

		TYPE_ACTION_PLAN(263),
		/** < Ԥ������ */
		IS_PLAN_ALARM(264),
		/** < �Ƿ�Ԥ���澯 */
		IS_ONCE_PLAN_ALARM(265),
		/** < �Ƿ�������Ԥ�� */
		IS_MISINFORM(266),
		/** < �Ƿ��� */
		CHK_USER_NAME_TYPE(267),
		/** < �˾��û��� */
		TRIGGER_ID(268),
		/** < ������ID */

		IS_HIDE_EMPTY_ORG(269),
		/** < �Ƿ����ؿ���֯ */
		IS_QUERY_SHARED(270),
		/** < �ǲ�ѯ�ѹ�����Դ=1���ǲ�δ������Դ=0 */

		IS_LEACH_SHARED_BELONG(271),
		/** < �Ƿ���˵���Ϊ��Դ��������������Դ�������ɵĻ����¼(��Ҫ��AS_CON_Parse���н���) */
		RESULT_CODE(272),
		/** < ����� */
		RES_ORDER_NUMBER(273),
		/** < ��Դ������� */

		AUTOID(273),
		/** < ���� */

		EVENT_TYPE_NAME(273),
		/** < �¼��������� */

		CONF_START_TIME(300),
		/** < ���鿪ʼʱ�䣬1970������������ */
		CONF_END_TIME(301),
		/** < �������ʱ�䣬1970������������ */

		DOMAIN_CODE(350),
		/** < ����� */
		TOLLGATE_CODE(351),
		/** < ���ڱ�� */
		TOLLGATE_NAME(352),
		/** < �������� */
		TOLLGATE_CAMERA_CODE(353),
		/** < ����������� */
		LANE_NUMBER(354),
		/** < ������� */
		LANE_DIRECTION(355),
		/** < ���������� */
		PASS_TIME(356),
		/** < ͨ��ʱ�� */
		VEHICLE_LICENSE_PLATE(357),
		/** < ���ƺ��� */
		VEHICLE_LICENSE_PLATE_TYPE(358),
		/** < �������� */
		VEHICLE_LICENSE_PLATE_COLOR(359),
		/** < ������ɫ */
		SPEED_TYPE(360),
		/** < �ٶ� */
		LIMIT_SPEED(361),
		/** < ���� */
		VEHICLE_LOGO(362),
		/** < ����Ʒ�� */
		VEHICLE_TYPE(363),
		/** < �������� */
		VEHICLE_COLOR_DEPTH(364),
		/** < ������ɫ��ǳ */
		VEHICLE_COLOR(365),
		/** < ������ɫ */
		VEHICLE_IDENTIFY_STATUS(366),
		/** < ʶ��״̬ */
		VEHICLE_STATUS(367),
		/** < ��ʻ״̬ */
		VEHICLE_DEAL_STATUS(368),
		/** < ���������� */
		DISPOSITION_CODE(369),
		/** < ���ر�� */
		DISPOSITION_TYPE(370),
		/** < ������� */
		DISPOSITION_DEPT(371),
		/** < ���ص�λ */
		DISPOSITION_USER(372),
		/** < ������Ա */
		DISPOSITION_STATUS(373),
		/** < ����״̬ */
		DISPOSITION_UNDO_DEPT(374),
		/** < ���ص�λ */
		DISPOSITION_UNDO_USER(375),
		/** < ������Ա */
		PRIORITY_TYPE(376),
		/** < ���ȼ� */
		ALARM_TYPE(377),
		/** < �澯���� */
		PLATE_ANALYSE_STATUS(378),
		/** < ���Ʒ���״̬ */

		UPLOAD_USER_CODE(519),
		/** < �ļ��ϴ��û���¼���� */
		FILE_STATUS(521),
		/** <�ļ����״̬ */

		QUERY_TYPE_MAX(522);
		/** < ��Чֵ */

		private final int value;

		// ���췽��������private����Ĭ��
		private QUERY_TYPE_E(int value) {
			this.value = value;
		}
	}

	/// <summary>
	/// �û���¼����MAC��ַ�ṹ
	/// </summary>
	public static class MAC_ADDRESS_INFO_S extends Structure {
		// ���캯������
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
		/// Mac��ַ
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
	/// �û���¼��չ��Ϣ
	/// </summary>
	public static class LOGIN_EXT_INFO_S extends Structure {
		// ���캯������
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
		/// IP��ַ
		/// </summary>
		public byte[] szIpAddress = new byte[IMOS_IPADDR_LEN];
		/// <summary>
		/// Mac��ַ����
		/// </summary>
		public int ulOperMachineMacNum;
		/// <summary>
		/// MAC��ַ�б�
		/// </summary>
//		public MAC_ADDRESS_INFO_S.ByValue[] astOperMachineMac = (MAC_ADDRESS_INFO_S.ByValue[]) new MAC_ADDRESS_INFO_S.ByValue()
//				.toArray(20);
		public MAC_ADDRESS_INFO_S.ByValue[] astOperMachineMac = new MAC_ADDRESS_INFO_S.ByValue[20];
		/// <summary>
		/// �û���¼������, �������û�����/�û�����, ȡֵ#USER_LOGIN_NAME_TYPE
		/// </summary>
		public int ulLoginNameType;
		/// <summary>
		/// �û�ǰ�˵����� (0~999):BS�ͻ��� 0��BS�ͻ��� 1������BS�ͻ��� (1000~1999):CS�ͻ��� (2000~2999):�ƶ��ͻ���
		/// </summary>
		public int ulLoginType;
		/// <summary>
		/// ����ϵͳ���� ����
		/// </summary>
		public int ulOSType;
		/// <summary>
		/// �����ֶ�
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
	/// �û���¼ID��Ϣ�ṹ
	/// </summary>
	public static class USER_LOGIN_ID_INFO_S extends Structure {
		// ���캯������
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
		/// �û�����
		/// </summary>
		public byte[] szUserCode = new byte[IMOS_USER_CODE_LEN];

		/// <summary>
		/// �û���¼ID�����û���¼�����������ģ����Ǳ��һ���û���¼��Ψһ��ʶ
		/// </summary>
		public byte[] szUserLoginCode = new byte[IMOS_RES_CODE_LEN];

		/// <summary>
		/// �û���¼�Ŀͻ���IP��ַ
		/// </summary>
		public byte[] szUserIpAddress = new byte[IMOS_IPADDR_LEN];

		// ����ȡֵ������Ҫ��C/C++�ж��룬��Ȼ�����NoSuchFieldError
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
	 * @brief �û���¼��Ϣ�ṹ��
	 * @attention ��
	 */
	public static class LOGIN_INFO_S extends Structure {
		// ���캯������
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

		/** �û���¼ID��Ϣ */
		public USER_LOGIN_ID_INFO_S.ByReference stUserLoginIDInfo=new USER_LOGIN_ID_INFO_S.ByReference();

		/** �û�������֯���� */
		public byte[] szOrgCode = new byte[IMOS_DOMAIN_CODE_LEN];

		/** �û����������� */
		public byte[] szDomainName = new byte[IMOS_NAME_LEN];

		/**
		 * �û�����������,
		 * ȡֵΪ#MM_DOMAIN_SUBTYPE_LOCAL_PHYSICAL��#MM_DOMAIN_SUBTYPE_LOCAL_VIRTUAL
		 */
		public int ulDomainType;
		
	    /** XP���� */
		public byte[] szXpCode = new byte[IMOS_DEVICE_CODE_LEN];

	    /** XP��һ������� */
		public byte[] szXpFirstWndCode = new byte[IMOS_RES_CODE_LEN];

	    /** �����Խ����� */
		public byte[] szVoiceTalkCode = new byte[IMOS_RES_CODE_LEN];

	    /** �����㲥���� */
		public byte[] szVoiceBroadcastCode = new byte[IMOS_RES_CODE_LEN];

	    /** SIPͨ�ŵ�ַ���ͣ�ֵΪ:IMOS_IPADDR_TYPE_IPV4/IMOS_IPADDR_TYPE_IPV6 */
		int ulSipAddrType;

	    /** SIP������ͨ��IP��ַ������ʹ��XP��ʱ����Ч */
		public byte[] szSipIpAddress = new byte[IMOS_IPADDR_LEN];

	    /** SIP������ͨ�Ŷ˿ں� */
		int ulSipPort;

	    /** ������������� */
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
		// ���캯������
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
		/// ��ѯ��������: #QUERY_TYPE_E
		/// </summary>
		public int ulQueryType;

		/// <summary>
		/// ��ѯ�����߼���ϵ����: #LOGIC_FLAG_E
		/// </summary>
		public int ulLogicFlag;

		/// <summary>
		/// ��ѯ����
		/// </summary>
		public byte[] szQueryData = new byte[IMOS_QUERY_DATA_MAX_LEN];

		// ����ȡֵ������Ҫ��C/C++�ж��룬��Ȼ�����NoSuchFieldError
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
	/// ͨ�ò�ѯ����
	/// </summary>
	public static class COMMON_QUERY_CONDITION_S extends Structure {
		// ���캯������
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
		/// ��ѯ���������в�ѯ������ʵ�ʸ���,���ȡֵΪ#IMOS_QUERY_ITEM_MAX_NUM
		/// </summary>
		public int ulItemNum;

		public QUERY_CONDITION_ITEM_S.ByReference[] astQueryConditionList = (QUERY_CONDITION_ITEM_S.ByReference[]) new QUERY_CONDITION_ITEM_S.ByReference()
				.toArray(IMOS_QUERY_ITEM_MAX_NUM);

		// ����ȡֵ������Ҫ��C/C++�ж��룬��Ȼ�����NoSuchFieldError
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
	/// ��ҳ������Ϣ
	/// </summary>
	public static class QUERY_PAGE_INFO_S extends Structure {
		// ���캯������
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
		/// ��ҳ��ѯ��ÿҳ�������Ŀ��, ����Ϊ0, Ҳ���ܴ���#IMOS_PAGE_QUERY_ROW_MAX_NUM
		/// </summary>
		public int ulPageRowNum;

		/// <summary>
		/// ��ҳ��ѯ�е�һ�����ݵ����(����ѯ�ӵ�ulPageFirstRowNumber�����ݿ�ʼ�ķ�������������), ȡֵ����ULONG���͵ķ�Χ����
		/// </summary>
		public int ulPageFirstRowNumber;

		/// <summary>
		/// �Ƿ��ѯ��Ŀ����, BooleanRUEʱ��ѯ; BOOL_FALSEʱ����ѯ
		/// </summary>
		public boolean bQueryCount;

		// ����ȡֵ������Ҫ��C/C++�ж��룬��Ȼ�����NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulPageRowNum", "ulPageFirstRowNumber", "bQueryCount" });
		}
	}

	/**
	 * @struct tagRspPageInfo
	 * @brief ��ҳ��Ӧ��Ϣ
	 * @attention
	 */
	public static class RSP_PAGE_INFO_S extends Structure {
		// ���캯������
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

		/** ʵ�ʷ��ص���Ŀ�� */
		public int ulRowNum;

		/** ��������������Ŀ�� */
		public int ulTotalRowNum;

		// ����ȡֵ������Ҫ��C/C++�ж��룬��Ȼ�����NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulRowNum", "ulTotalRowNum" });
		}
	}

	public static class ORG_RES_QUERY_ITEM_S extends Structure {
		// ���캯������
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

		/** ��Դ���� */
		public byte[] szResCode = new byte[IMOS_RES_CODE_LEN];

		/** ��Դ���� */
		public byte[] szResName = new byte[IMOS_NAME_LEN];

		/** ��Դ���ͣ�ȡֵ��ΧΪ#IMOS_TYPE_E */
		public int ulResType;

		/**
		 * ��Դ������,Ŀǰ��Դ������ֻ�������/��֯/����ʾ/����Ѳ��Ч�������������Ϊ��̨/����̨;
		 * ����֯����Ϊ:1-��������2-�����������3-�����������. 4-�ϼ���������. 5-�¼���������.6-ƽ����������.
		 * ������ʾ��Դ��������ʾ���ͣ�ȡֵΪ#SALVO_TYPE_E ������Ѳ��Դ��������Ѳ���ͣ�ȡֵΪ#GROUP_SWITCH_TYPE_E
		 * ��ǹ�����������ͣ�ȡֵΪ#BALLLINKAGE_TYPE_E
		 */
		public int ulResSubType;

		/**
		 * ��Դ״̬,ȡֵΪ:#IMOS_DEV_STATUS_ONLINE,#IMOS_DEV_STATUS_OFFLINE -
		 * �������Դ,���������豸(�����/������/EC/DC)������(��������˵,���ֶδ������ע��״̬)
		 */
		public int ulResStatus;

		/**
		 * ��Դ����״̬ -
		 * ���������,���ֶ��������߲���һ�������ϱ�����Ƶ״̬��Ϣ��(����Ƶ��ʧ�澯/����Ƶ�ָ��澯),��������,ȡֵΪ:#IMOS_DEV_EXT_STATUS_E
		 * - ��������,���ֶδ�������ע��״̬,ȡֵΪ:#IMOS_DEV_STATUS_ONLINE,#IMOS_DEV_STATUS_OFFLINE
		 */
		public int ulResExtStatus;

		/** ����Դ�Ƿ��Ǳ��������Դ, 1Ϊ���������Դ; 0Ϊ�ǻ������Դ */
		public int ulResIsBeShare;

		/** ��Դ������֯���� */
		public byte[] szOrgCode = new byte[IMOS_DOMAIN_CODE_LEN];

		/** ֧�ֵ�����Ŀ��������Դ����Ϊ�����ʱ��Ч��0:��Чֵ��1:������2:˫�� 3:���� */
		public int ulStreamNum;

		/** �Ƿ�Ϊ������Դ��1Ϊ������Դ; 0Ϊ��������Դ */
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
		// ���캯������
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

		/** V1��Դ��Ϣ�� */
		public ORG_RES_QUERY_ITEM_S.ByReference stResItemV1;

		/** ��Դ������֯������ */
		public byte[] szOrgName = new byte[IMOS_NAME_LEN];

		/** ��Դ������Ϣ��������Դ�����������ʱ��ȡֵΪ#CAMERA_ATTRIBUTE_E��������Դ���͸��ֶ���δʹ�� */
		public int ulResAttribute;

		/**
		 * �����ECR HFϵ�е���������߼��������ڵ��豸�����ײͣ� ������Դ����,����ͨ�ò�ѯ����IS_QUERY_ENCODESETû����д,
		 * ��������"����ѯ", ���ֶξ�Ϊ��Чֵ#IMOS_SR_INVALID ȡֵΪ#IMOS_STREAM_RELATION_SET_E
		 */
		public int ulDevEncodeSet;

		/* Begin: Modified by lw0581, 2013.12.19 for MPPD06992 */
		/**
		 * ����ҵ��״̬, ������Դ����Ϊ�Խ���Դ���㲥��Դ���������ʱ��Ч; 0������ͨ״̬, 1�������ڶԽ�, 2�������ڹ㲥,
		 * ö��Ϊ#VOICE_STATUS_FOR_ECR_E
		 */
		public int ulVoiceStatus;

		/** �Ƿ�������Դ, ������Դ����Ϊ�㲥��ʱ��Ч */
		public boolean bHasBrdSubRes;

		/** �Ƿ�����Դ�� BOOL_FALSE--û�а�, BOOL_TRUE--�а� */
		public boolean bIsBind;

		/**
		 * ��Դ�󶨶�Ӧ��Ϣ, ����Դ����Ϊ�����ʱ, �����Ӧ�󶨹�ϵ��������Դ����, ����Դ����Ϊ������Դʱ,�����Ӧ�󶨹�ϵ�����������, ���������Ч
		 */
		public byte[] szResBindCode = new byte[IMOS_DEVICE_CODE_LEN];

		/* Begin:Modified by h00275, 2013.4.12 for of V2R1���� */
		/* ���ֶ�ֻ����Դ����Ϊ��֯��Ч���������������� */
		public int ulSubTypeOfSubType;

		/** �����ֶ� */
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
	 * @brief ��/�岥�б��豸��Ϣ
	 * @note
	 */
	public static class BROADCAST_DEV_S extends Structure {
		// ���캯������
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

		/* <�豸��Ϣ */
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
	 * @brief ��/�岥�豸�б���Ϣ
	 * @note
	 */
	public static class BROADCAST_DEV_LIST_S extends Structure {
		// ���캯������
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

		/* <�豸����,������MAX_BROADCAST_DEV_LIST_NUM */
		public int ulDevNum;
		/* <�豸�б� */
		public BROADCAST_DEV_S.ByReference[] szDevList = (BROADCAST_DEV_S.ByReference[]) new BROADCAST_DEV_S.ByReference()
				.toArray(SDK_SPS_MAX_ITEM_NUM);
		/* <Ԥ���ֶ� */
		public byte[] szReserved = new byte[IMOS_STRING_LEN_256];

		// ����ȡֵ������Ҫ��C/C++�ж��룬��Ȼ�����NoSuchFieldError
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
	 * @brief ��/�岥�豸�б���Ϣ
	 * @note
	 */
	public static class BROADCAST_DEV_INFO_S extends Structure {
		// ���캯������
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

		/* <�豸���� */
		public byte[] szDevCode = new byte[IMOS_CODE_LEN];

		/* <�豸���� */
		public byte[] szDevName = new byte[IMOS_NAME_LEN];

		/* <�豸IP��ַ */
		public byte[] szIPAddr = new byte[IMOS_IPADDR_LEN];

		/* �豸�㲥��Ϣ */
		public byte[] szBroadcastCode = new byte[IMOS_STRING_LEN_64];

		/* �豸�岥��Ϣ */
		public byte[] szInterCutCode = new byte[IMOS_STRING_LEN_64];

		/* <��ǰ�豸״̬����ʾ�Ƿ����ڲ��ţ�ȡֵ��ΧBROADCAST_DEV_STATUS_E */
		public int ulDevBrdStatus;

		/* <Ԥ���ֶ� */
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
		// ���캯������
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
	 * @brief ��/�岥��Ϣ
	 * @note
	 */
	public static class BROADCAST_PARAM_INFO_S extends Structure {
		// ���캯������
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

		/* <�������ͣ�ȡֵ��ΧBRAODCAST_VOICE_TYPE_E */
		public int ulVoiceType;
		/* <���ŷ�ʽ ��ȡֵ��ΧBROADCAST_PLAY_MODE_E����ǰֻȡBROADCAST_PLAY_MODE_SEQUENCE */
		public int ulModeType;
		/* <URL or �ļ��� or ��ĿID */
		public byte[] szBroacastInfo = new byte[IMOS_STRING_LEN_512];
		/* <�ö�����ע����, ���ڼ�¼��־ */
		public byte[] szBroadcastDesc = new byte[IMOS_STRING_LEN_128];
		/* <Ԥ���ֶ� */
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
	 * @brief �㲥��Ϣ
	 * @attention
	 */
	public static class BROADCAST_INFO_S extends Structure {
		// ���캯������
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

		/** �û����� */
		public byte[] szUserCode = new byte[IMOS_USER_CODE_LEN];

		/** �û���¼ID�����û���¼����������� */
		public byte[] szUserLoginCode = new byte[IMOS_RES_CODE_LEN];

		/** �û���¼�Ŀͻ���IP��ַ */
		public byte[] szUserIpAddress = new byte[IMOS_IPADDR_LEN];

		/* �㲥��岥���� */
		public byte[] szXPVocBrdCode = new byte[IMOS_RES_CODE_LEN];

		/* ҵ�����ͣ�ȡֵ��ΧBROADCAST_SRV_TYPE_E */
		public int ulSrvType;

		/* <�岥/�㲥���� ��ȡֵ��ΧBRAODCAST_VOICE_TYPE_E */
		public int ulVoiceType;

		/* <URL or �ļ��� */
		public byte[] szBroacastInfo = new byte[IMOS_STRING_LEN_512];

		/* <Ԥ���ֶ� */
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
			stBCInfo.ulSrvType = 100; // ��ʼ��һ���Ƿ�ֵ
			stBCInfo.ulVoiceType = 101;
			return stBCInfo;
		}
	}

	public static class PRESET_INFO_S extends Structure {
		// ���캯������
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

		/** Ԥ��λֵ, ȡֵ��ΧΪ#PTZ_PRESET_MINVALUE~�����������ļ������õ�Ԥ��λ���ֵ */
		public int ulPresetValue;

		/** Ԥ��λ����, ��Ҫ��д */
		public byte[] szPresetDesc = new byte[IMOS_DESC_LEN];

		// ����ȡֵ������Ҫ��C/C++�ж��룬��Ȼ�����NoSuchFieldError
		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "ulPresetValue", "szPresetDesc" });
		}
	}

	public int IMOS_Initiate(byte[] szServerAdd, int ulServerPort, int bUIFlag, int bXPFlag);

	/// �û���¼�ӿ�V2
	/// </summary>
	/// <param name="szUserLoginName">�û���¼�û���</param>
	/// <param name="szPassword">�û���¼����</param>
	/// <param name="szIpAddress">�û���¼IP</param>
	/// <param name="pstLoginExtInfo">�û���¼��չ��Ϣ</param>
	/// <param name="IntPtr">�û���¼��Ϣ</param>
	/// <returns></returns>
	public int IMOS_LoginV2(byte[] szUserLoginName, byte[] szPassword, byte[] szIpAddress,
			LOGIN_EXT_INFO_S.ByReference pstLoginExtInfo, LOGIN_INFO_S.ByReference pstSDKLoginInfo);

	public int IMOS_Encrypt(String strInput, int ulInLen, byte[] ptrOutput);

	public int IMOS_QueryResourceListV2(USER_LOGIN_ID_INFO_S.ByReference pstUserLogIDInfo, byte[] szOrgCode,
			COMMON_QUERY_CONDITION_S.ByReference pstQueryCondition, QUERY_PAGE_INFO_S.ByReference pstQueryPageInfo,
			RSP_PAGE_INFO_S.ByReference pstRspPageInfo, RES_ITEM_V2_S.ByReference pstResList);

	/**
	 * ��ѯ��֯����Դ��Ϣ�б�(V2,��չ����"��Դ������֯������") \n
	 * 
	 * @param [IN]
	 *            pstUserLogIDInfo �û���¼ID��Ϣ��ʶ
	 * @param [IN]
	 *            szOrgCode ��֯����
	 * @param [IN]
	 *            pstQueryCondition ��ѯ����
	 * @param [IN]
	 *            pstQueryPageInfo �����ҳ��Ϣ
	 * @param [OUT]
	 *            pstRspPageInfo ��Ӧ��ҳ��Ϣ
	 * @param [OUT]
	 *            pstResList ��Դ��Ϣ�б�
	 * @return ULONG �������½���� - �ɹ��� - #ERR_COMMON_SUCCEED - ʧ�ܣ� -
	 *         #ERR_DAO_DOMAIN_NOT_EXIST - ���ز�������룬���������ļ�
	 * @note - ���� - 1.��������ΪNULL,��ʾ��ָ����֯��������Դ(��������֯); -
	 *       2.֧�ְ�"�Ƿ������֯"������ѯ:#IS_QUERY_SUB = 1 ��;= 0 ��; -
	 *       3.֧�ְ�"��Դ����"ģ����ѯ:#NAME_TYPE; - 4.֧�ְ�"�Ƿ�������Դ"��ѯ:#DOMAIN_TYPE = 1 ��;= 0 ��;
	 *       - 5.֧�ְ�"��Դ����"��ѯ:#RES_TYPE,ȡֵΪ#IMOS_TYPE_E, ��֧���߼���ϵ����Ϊ#EQUAL_FLAG; -
	 *       6.֧�ְ�"��Դ������"��ѯ:#RES_SUB_TYPE(��Դ����Ϊ�����ʱ,ȡֵΪ#CAMERA_TYPE_E); -
	 *       7.֧�ְ�"��Դ����"��ѯ:#RES_ATTRIBUTE(��Դ����Ϊ�����ʱ,ȡֵΪ#CAMERA_ATTRIBUTE_E); -
	 *       8.֧��"���ײ�"��ѯ:#IS_QUERY_ENCODESET (��Դ����Ϊ������������ʱ,
	 *       ȡֵΪ#0-����ѯ����pstResList�е�ulDevEncodeSet��Ч;
	 *       ȡֵΪ#1-��ѯ����pstResList�е�ulDevEncodeSet��Ч); - 9.֧���Ƿ������ؿ���֯:
	 *       #IS_HIDE_EMPTY_ORG = 1 ��; =0 �� - 10.֧���Ƿ���˵���Ϊ��Դ��������������Դ�������ɵĻ����¼:
	 *       #IS_LEACH_SHARED_BELONG = 1 ��; = 0 �� - ���� - 1.��ָ���������������,Ĭ�ϰ�"��Դ����"��������
	 *       -
	 *       2.֧�ֵ���������,����:#NAME_TYPE(��Դ����),#CODE_TYPE(��Դ����),#RES_TYPE(��Դ����),#RES_SUB_TYPE(��Դ������),
	 *       - #DOMAIN_TYPE(�Ƿ�������Դ),#RES_ATTRIBUTE(��Դ����),#RES_ORDER_NUMBER(��Դ���)
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
	/// ���ã�����MP3�㲥������
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
	/// ���ã��ر�MP3�㲥������
	/// </summary>
	/// <param name="pstUserLoginIDInfo"></param>
	/// <param name="pstBroadCastListInfo"></param>
	/// <returns></returns>
	public int IMOS_CloseDevBroadCast(USER_LOGIN_ID_INFO_S.ByReference pstUserLoginIDInfo,
			BROADCAST_DEV_LIST_S.ByReference pstBroadCastListInfo);

	public class IMOS_Device {
		/// <summary>
		/// �豸����
		/// </summary>
		public String DeviceName;
		/// <summary>
		/// �豸����
		/// </summary>
		public String DeviceCode;
		/// <summary>
		/// �豸IP
		/// </summary>
		public String DeviceIP;
		/// <summary>
		/// �豸����
		/// </summary>
		public String DeviceType;
		/// <summary>
		/// �豸״̬
		/// </summary>
		public String DeviceStatus;
	}
}
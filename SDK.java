package imos;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import imos.IMOSSDK;
import imos.XpFrame;
import imos.IMOSSDK.BROADCAST_DEV_LIST_S;
import imos.IMOSSDK.BROADCAST_INFO_S;
import imos.IMOSSDK.BROADCAST_PARAM_INFO_S;
import imos.IMOSSDK.LOGIN_EXT_INFO_S;
import imos.IMOSSDK.LOGIN_INFO_S;
import imos.IMOSSDK.MAC_ADDRESS_INFO_S;
import imos.IMOSSDK.USER_LOGIN_ID_INFO_S;

public class SDK {
	static IMOSSDK IMOSSDKObj = IMOSSDK.INSTANCE;
	static XpFrame XpFrameObj = XpFrame.INSTANCE;

	public static LOGIN_INFO_S.ByReference stLoginInfo;

	/**
	 * �ر�ָ���豸�ϵĹ㲥
	 * 
	 * @param [IN]
	 *            pstUserLoginIDInfo �û���Ϣ
	 * @param [IN]
	 *            pstBroadCastListInfo �豸�б�
	 * @return �������½���� - �ɹ��� - ʧ�ܣ� - ���ز�������룬���������ļ�
	 * @note - 1. �رչ㲥��ͬʱ�رղ岥
	 */
	public static int IMOS_StopBroadCastByDev(USER_LOGIN_ID_INFO_S.ByReference pstUserLoginIDInfo,
			BROADCAST_DEV_LIST_S.ByReference pstBroadCastListInfo) throws Exception {
		return IMOSSDKObj.IMOS_CloseDevBroadCast(pstUserLoginIDInfo, pstBroadCastListInfo);
	}

	/**
	 * �����㲥
	 * 
	 * @param [IN]
	 *            pstUserLoginIDInfo �û���Ϣ
	 * @param [IN]
	 *            pstParamInfo �㲥������Ϣ
	 * @param [IN]
	 *            pstDevListInfo ��Ҫ�㲥���豸�б�
	 * @param [IN]
	 *            pstBrdcastInfo �㲥��Ϣ
	 * @return �������½���� - �ɹ��� - ʧ�ܣ� - ���ز�������룬���������ļ�
	 * @note - 1. ��һ�ν���ʱ�������ɹ��Ĺ㲥��Ϣͨ��pstBrdcastInfo���� - 2.
	 *       ��������Ѵ��ڵĹ㲥�м����µĹ㲥�豸������Ҫָ��pstBrdcastInfo->szXPVocBrdCodeΪ�Ѵ��ڵı���
	 */
	public static int IMOS_StartBroadCast_T(USER_LOGIN_ID_INFO_S.ByReference pstUserLoginIDInfo,
			BROADCAST_PARAM_INFO_S.ByReference pstParamInfo, BROADCAST_DEV_LIST_S.ByReference pstBrdcastDevList,
			BROADCAST_INFO_S.ByReference pstBrdcastInfo) throws Exception {
		try {
			int result = IMOSSDKObj.IMOS_StartBroadCast(pstUserLoginIDInfo, pstParamInfo, pstBrdcastDevList,
					pstBrdcastInfo);
			return result;
		} catch (Exception ex) {
			return 1;
		}
	}

	/// <summary>
	/// ����MP3�㲥
	/// </summary>
	/// <param name="mp3filepath">MP3�ļ�·��</param>
	/// <param name="pstBroadCastListInfo">�㲥�����б���Ϣ</param>
	/// <returns></returns>
	// public static int IMOS_StartMP3BroadCast(String mp3filepath,
	// BROADCAST_DEV_LIST_S.ByReference pstBroadCastListInfo)
	// {
	// int uResult = 0;
	// /*��֯�û���Ϣ*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	// /*�㲥������Ϣ*/
	// BROADCAST_PARAM_INFO_S.ByReference pstParamInfo = new
	// BROADCAST_PARAM_INFO_S.ByReference();
	// pstParamInfo.ulVoiceType = IMOSSDKObj.BRAODCAST_VOICE_FILE;
	// pstParamInfo.ulModeType = IMOSSDKObj.BROADCAST_PLAY_MODE_SEQUENCE;
	// //pstParamInfo.szBroadcastDesc =; // �ö�����ע����, ���ڼ�¼��־
	//
	// // URL or �ļ��� or ��ĿID
	// Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstParamInfo.szBroacastInfo,
	// 0);
	// /*�㲥��Ϣ*/
	// BROADCAST_INFO_S pstBrdcastInfo = BROADCAST_INFO_S.GetInstance();
	// // URL or �ļ��� or ��ĿID
	// Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstBrdcastInfo.szBroacastInfo,
	// 0);
	// pstBrdcastInfo.szUserCode = stLoginInfo.stUserLoginIDInfo.szUserCode;
	// pstBrdcastInfo.szUserLoginCode =
	// stLoginInfo.stUserLoginIDInfo.szUserLoginCode;
	// //pstBrdcastInfo.szXPVocBrdCode =; // �㲥��岥����
	// pstBrdcastInfo.ulSrvType = BROADCAST_SRV_BRDCAST;
	// pstBrdcastInfo.ulVoiceType = BRAODCAST_VOICE_FILE;
	//
	// uResult = IMOSSDKObj.IMOS_StartBroadCast_T(ref pstUserLogIDInfo, ref
	// pstParamInfo, ref pstBroadCastListInfo, ref pstBrdcastInfo);
	//
	// return uResult;
	// }

	/// <summary>
	/// ����MIC�㲥
	/// </summary>
	/// <param name="pstBroadCastListInfo">�㲥�����б���Ϣ</param>
	/// <returns></returns>
	// private static uint IMOS_StartMICBroadCast(ref BROADCAST_DEV_LIST_S
	// pstBroadCastListInfo)
	// {
	// uint uResult = 0;
	// /*��֯�û���Ϣ*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	// /*�㲥������Ϣ*/
	// BROADCAST_PARAM_INFO_S pstParamInfo = BROADCAST_PARAM_INFO_S.GetInstance();
	// pstParamInfo.ulVoiceType = BRAODCAST_VOICE_MIC;
	// pstParamInfo.ulModeType = BROADCAST_PLAY_MODE_SEQUENCE;
	// //pstParamInfo.szBroadcastDesc =; // �ö�����ע����, ���ڼ�¼��־
	// // URL or �ļ��� or ��ĿID
	// //Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstParamInfo.szBroacastInfo,
	// 0);
	// /*�㲥��Ϣ*/
	// BROADCAST_INFO_S pstBrdcastInfo = BROADCAST_INFO_S.GetInstance();
	// // URL or �ļ��� or ��ĿID
	// //Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstBrdcastInfo.szBroacastInfo,
	// 0);
	// pstBrdcastInfo.szUserCode = stLoginInfo.stUserLoginIDInfo.szUserCode;
	// pstBrdcastInfo.szUserLoginCode =
	// stLoginInfo.stUserLoginIDInfo.szUserLoginCode;
	// //pstBrdcastInfo.szXPVocBrdCode =; // �㲥��岥����
	// pstBrdcastInfo.ulSrvType = BROADCAST_SRV_BRDCAST;
	// pstBrdcastInfo.ulVoiceType = BRAODCAST_VOICE_MIC;
	//
	// uResult = IMOSSDKObj.IMOS_StartBroadCast(ref pstUserLogIDInfo, ref
	// pstParamInfo, ref pstBroadCastListInfo, ref pstBrdcastInfo);
	//
	// return uResult;
	// }

	/// <summary>
	/// �رչ㲥
	/// </summary>
	/// <param name="pstBroadCastListInfo">�㲥�����б���Ϣ</param>
	/// <returns></returns>
	// private static uint IMOS_StopBroadCast(ref BROADCAST_DEV_LIST_S
	// pstBroadCastListInfo)
	// {
	// uint uResult = 0;
	// /*��֯�û���Ϣ*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	//
	// uResult = IMOSSDKObj.IMOS_StopBroadCastByDev(ref pstUserLogIDInfo, ref
	// pstBroadCastListInfo);
	//
	// return uResult;
	// }

	/// <summary>
	/// ��¼
	/// </summary>
	/// <param name="ip"></param>
	/// <param name="usr"></param>
	/// <param name="pwd"></param>
	/// <param name="port"></param>
	/// <returns></returns>
	public static String Login(String ip, String usr, String pwd, int port) throws Exception {
		try {
			// String cltIpAddr = "N/A";
			// 3.��¼����
			// IntPtr ptrLoginInfo =
			// Marshal.AllocHGlobal(Marshal.SizeOf(typeof(LOGIN_INFO_S)));
			IMOSSDK.LOGIN_INFO_S.ByReference ptrLoginInfo = new IMOSSDK.LOGIN_INFO_S.ByReference();
			int ulRet = 0;
			int srvPort = port;
			// byte[] szServerAddB = InetAddress.getByName(ip).getAddress();
			byte[] szServerAddB = ip.getBytes();
			// 1.��ʼ��
			ulRet = IMOSSDKObj.IMOS_Initiate(szServerAddB, srvPort, 1, 1);
			if (0 != ulRet) {
				return "��ʼ��ʧ��!";
			}
			// 2.��������
			// IntPtr ptr_MD_Pwd = Marshal.AllocHGlobal(sizeof(char) *
			// IMOS_PASSWD_ENCRYPT_LEN);
			byte[] buf = new byte[512];
			ulRet = IMOSSDKObj.IMOS_Encrypt(pwd, pwd.length(), buf);
			String MD_PWD = Native.toString(buf);
			if (0 != ulRet) {
				return "��������ʧ��!";
			}
			// String MD_PWD = Marshal.PtrToStringAnsi(ptr_MD_Pwd);
			// String MD_PWD = ptr_MD_Pwd;
			// Marshal.FreeHGlobal(ptr_MD_Pwd);
			String localip = GetLocalIp();
			int result = UsrLoginV2(usr, MD_PWD, "208.208.101.15", 0, ptrLoginInfo);
			// �û��Ѿ���¼
			if (12351 == result) {
				// ����LoginV2���������û�����������¼
				result = UsrLoginV2(usr, MD_PWD, "208.208.101.15", 1, ptrLoginInfo);
			}
			if (0 != result) {
				return "��¼ʧ�ܣ������룺" + result;
			}
			stLoginInfo = ptrLoginInfo;
			// stLoginInfo = (LOGIN_INFO_S)Marshal.PtrToStructure(ptrLoginInfo,
			// typeof(LOGIN_INFO_S));
			// Marshal.FreeHGlobal(ptrLoginInfo);

			// 4.����������
			// IntPtr ptrPlayWndInfo = Marshal.AllocHGlobal(25 *
			// Marshal.SizeOf(typeof(PLAY_WND_INFO_S)));

			IMOSSDK.PLAY_WND_INFO_S.ByReference ptrPlayWndInfo = new IMOSSDK.PLAY_WND_INFO_S.ByReference();
			ulRet = IMOSSDKObj.IMOS_StartPlayer(stLoginInfo.stUserLoginIDInfo, 25, ptrPlayWndInfo);
			if (0 != ulRet) {
				return "����������ʧ�ܣ������룺" + ulRet;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return "0";
	}

	/// <summary>
	/// �ǳ�
	/// </summary>
	public String Logout() {
		IMOSSDKObj.IMOS_LogoutEx(stLoginInfo.stUserLoginIDInfo);
		return "0";
	}

	/// <summary>
	/// ��ʾ�豸�б�
	/// </summary>
	// public string GetDevices()
	// {
	// /*��֯�û���Ϣ*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	// /*�����ҳ�ڴ�ռ�*/
	// Int32 iSize =
	// Marshal.SizeOf(typeof(RES_ITEM_V2_S));//��ʾÿһ��RES_ITEM_V2_S�ṹ������Ҫ�Ĵ洢�ռ�
	// Int32 iSize1 = Marshal.SizeOf(typeof(BROADCAST_DEV_INFO_S));
	// /*��ѯҳ��Ľṹ��Ϣ*/
	// QUERY_PAGE_INFO_S stQueryPageInfo = new QUERY_PAGE_INFO_S();
	// stQueryPageInfo.bQueryCount = true;
	// stQueryPageInfo.ulPageFirstRowNumber = 0;
	// stQueryPageInfo.ulPageRowNum = 200;//���ֵ200
	// IntPtr pstPageInfo = IntPtr.Zero;
	// int iPageInfoSize = Marshal.SizeOf(typeof(RSP_PAGE_INFO_S));
	// IntPtr pstDevStatItem = IntPtr.Zero;
	// int iItemSize = Marshal.SizeOf(typeof(BROADCAST_DEV_INFO_S));
	// IntPtr pstDevQueryItem = IntPtr.Zero;
	// iItemSize = Marshal.SizeOf(typeof(RES_ITEM_V2_S));
	// try
	// {
	// /*����Ϊ�����б�ռ�*/
	// RSP_PAGE_INFO_S stRspPageInfo = new RSP_PAGE_INFO_S();
	// /*��ѯ�������豸����ΪIPB�豸*/
	// COMMON_QUERY_CONDITION_S stQueryCondition =
	// COMMON_QUERY_CONDITION_S.GetInstance();
	// stQueryCondition.astQueryConditionList[0].ulQueryType =
	// (uint)QUERY_TYPE_E.RES_TYPE;
	// stQueryCondition.astQueryConditionList[0].ulLogicFlag =
	// (uint)LOGIC_FLAG_E.EQUAL_FLAG;
	// Encoding.UTF8.GetBytes("1001").CopyTo(stQueryCondition.astQueryConditionList[0].szQueryData,
	// 0);
	// stQueryCondition.astQueryConditionList[1].ulQueryType =
	// (uint)QUERY_TYPE_E.RES_SUB_TYPE;
	// stQueryCondition.astQueryConditionList[1].ulLogicFlag =
	// (uint)LOGIC_FLAG_E.EQUAL_FLAG;
	// Encoding.UTF8.GetBytes("12").CopyTo(stQueryCondition.astQueryConditionList[1].szQueryData,
	// 0);
	// stQueryCondition.ulItemNum = 2;
	// //��ѯ����֯
	// stQueryCondition.astQueryConditionList[2].ulQueryType =
	// (uint)QUERY_TYPE_E.IS_QUERY_SUB;
	// stQueryCondition.astQueryConditionList[2].ulLogicFlag =
	// (uint)LOGIC_FLAG_E.EQUAL_FLAG;
	// Encoding.UTF8.GetBytes("1").CopyTo(stQueryCondition.astQueryConditionList[2].szQueryData,
	// 0);
	// stQueryCondition.ulItemNum++;
	// stQueryCondition.astQueryConditionList[stQueryCondition.ulItemNum].ulQueryType
	// = (uint)QUERY_TYPE_E.NAME_TYPE;
	// stQueryCondition.astQueryConditionList[stQueryCondition.ulItemNum].ulLogicFlag
	// = (uint)LOGIC_FLAG_E.LIKE_FLAG;
	// //Encoding.UTF8.GetBytes(tbDevName.Text).CopyTo(stQueryCondition.astQueryConditionList[stQueryCondition.ulItemNum].szQueryData,
	// 0);
	// stQueryCondition.ulItemNum++;
	// byte[] szOrgCode = stLoginInfo.szOrgCode;
	// /* ��ѯ�豸�б���Ϣ */
	// ORG_RES_QUERY_ITEM_S stRes = ORG_RES_QUERY_ITEM_S.GetInstance();
	// RES_ITEM_V2_S sps_DevInfo = RES_ITEM_V2_S.GetInstance(stRes);
	// BROADCAST_DEV_INFO_S sps_DevStats = BROADCAST_DEV_INFO_S.GetInstance();
	// pstPageInfo = Marshal.AllocHGlobal(iPageInfoSize * 1);
	// pstDevStatItem = Marshal.AllocHGlobal(iItemSize * 200);
	// pstDevQueryItem = Marshal.AllocHGlobal(iItemSize * 200);
	// //uint uResult = IMOSSDK.IMOS_QueryBroadcastDevList(ref pstUserLogIDInfo, ref
	// sps_stQueryCondition, ref stQueryPageInfo, pstPageInfo, pstDevQueryItem);
	// //uint uResult = IMOSSDK.IMOS_QueryNormalEcList(ref pstUserLogIDInfo,
	// szOrgCode, ref stQueryCondition, ref stQueryPageInfo, pstPageInfo,
	// pstDevQueryItem);
	// uint uResult = IMOS_QueryResourceListV2(ref pstUserLogIDInfo, szOrgCode, ref
	// stQueryCondition, ref stQueryPageInfo, pstPageInfo, pstDevQueryItem);
	// if (uResult == ERR_COMMON_SUCCEED)
	// {
	// /*��ָ��ת��Ϊ�ṹ��*/
	// stRspPageInfo = (RSP_PAGE_INFO_S)Marshal.PtrToStructure(pstPageInfo,
	// typeof(RSP_PAGE_INFO_S));
	// /* �����豸�����ȡ�豸״̬ */
	// BROADCAST_DEV_LIST_S pstDevListInfo = BROADCAST_DEV_LIST_S.GetInstance();
	// for (int i = 0; i < stRspPageInfo.ulRowNum; i++)
	// {
	// sps_DevInfo = (RES_ITEM_V2_S)Marshal.PtrToStructure((pstDevQueryItem + iSize
	// * i), typeof(RES_ITEM_V2_S));//�����ص�ָ��ת����RES_ITEM_V2_S
	// pstDevListInfo.szDevList[i].szDevinfo = sps_DevInfo.stResItemV1.szResCode;
	// }
	// pstDevListInfo.ulDevNum = stRspPageInfo.ulRowNum;
	// uint pulDevNum = 0;
	// if (pstDevListInfo.ulDevNum > 0)
	// {
	// uResult = IMOS_QueryBroadcastDevInfo(ref pstUserLogIDInfo, ref
	// pstDevListInfo, ref pulDevNum, pstDevStatItem);
	// /* ��ȡ״̬�ɹ� �����б����豸״̬ */
	// if (uResult == ERR_COMMON_SUCCEED)
	// {
	// var devices = new List<IMOS_Device>();
	// //this.listView1.BeginUpdate();
	// //���ݸ��£�UI��ʱ����ֱ��EndUpdate���ƿؼ���������Ч������˸�������߼����ٶ�
	// for (int i = 0; i < (int)pulDevNum; i++)
	// {
	// /*����б�����*/
	// sps_DevInfo = (RES_ITEM_V2_S)Marshal.PtrToStructure((pstDevQueryItem + iSize
	// * i), typeof(RES_ITEM_V2_S));//�����ص�ָ��ת����RES_ITEM_V2_S
	// sps_DevStats = (BROADCAST_DEV_INFO_S)Marshal.PtrToStructure((pstDevStatItem +
	// iSize1 * i), typeof(BROADCAST_DEV_INFO_S));
	// var device = new IMOS_Device
	// {
	// DeviceName = Encoding.UTF8.GetString(sps_DevStats.szDevName).Replace("\0",
	// ""),
	// DeviceCode = Encoding.UTF8.GetString(sps_DevStats.szDevCode).Replace("\0",
	// ""),
	// DeviceIP = Encoding.UTF8.GetString(sps_DevStats.szIPAddr).Replace("\0", ""),
	// DeviceType =
	// ((IMOS_TYPE_E)sps_DevInfo.stResItemV1.ulResType).ToString().Replace("\0", "")
	// };
	// //��һ�У��豸����
	// //�ڶ��У��豸����
	// //�����У��豸IP
	// //�����У��豸����
	// switch (sps_DevStats.ulDevBrdStatus)
	// {
	// case BROADCAST_DEV_PLAYING:
	// device.DeviceStatus = "����";//�����У��豸״̬
	// break;
	// case BROADCAST_DEV_NORMAL:
	// device.DeviceStatus = "����";//�����У��豸״̬
	// break;
	// case BROADCAST_DEV_OFFLINE:
	// device.DeviceStatus = "����";//�����У��豸״̬
	// break;
	// default:
	// device.DeviceStatus = "��Ч";//�����У��豸״̬
	// break;
	// }
	// devices.Add(device);
	// }
	// return JsonConvert.SerializeObject(devices);//���������豸��״̬�б�json���л��ַ���
	// }
	// else
	// {
	// return "��ѯ�豸��Ϣʧ�ܣ������룺" + uResult;
	// }
	// }
	// else
	// {
	// return "û�л�ȡ���κ��豸��";
	// }
	// }
	// else
	// {
	// return "��ѯ��Դ�б�ʧ�ܣ������룺" + uResult;
	// }
	// }
	// catch (Exception ex)
	// {
	// return ex.Message;
	// }
	// finally
	// {
	// Marshal.FreeHGlobal(pstPageInfo);
	// Marshal.FreeHGlobal(pstDevStatItem);
	// Marshal.FreeHGlobal(pstDevQueryItem);
	// }
	// }

	/// <summary>
	/// MP3�ļ��㲥
	/// </summary>
	// public string BroadcastMp3(string filepath, string[] devicecodes)
	// {
	// try
	// {
	// uint uResult = 0;
	// //��Ҫ���ŵĹ㲥�豸�б�
	// var pstBroadCastListInfo = BROADCAST_DEV_LIST_S.GetInstance();
	// var selecteditems = devicecodes;
	// if (selecteditems.Length < 1)
	// {
	// return "�豸����С��1";
	// }
	// //�Ȳ��ŵ�ǰ�豸�б���ѡ�е��豸
	// if (selecteditems.Length > 0)
	// {
	// BROADCAST_DEV_S[] szDevList = new BROADCAST_DEV_S[selecteditems.Length];
	// for (int i = 0; i < selecteditems.Length; i++)
	// {
	// szDevList[i] = BROADCAST_DEV_S.GetInstance();
	// }
	// //��ȡ��ѡ�е��豸����
	// int indexcnt = 0;
	// foreach (var devicecode in selecteditems)
	// {
	// /*��ȡѡ���豸��Ϣ*/
	// Encoding.UTF8.GetBytes(devicecode).CopyTo(szDevList[indexcnt].szDevinfo, 0);
	// indexcnt++;
	// }
	// for (int i = 0; i < selecteditems.Length; i++)
	// {
	// pstBroadCastListInfo.szDevList[i].szDevinfo = szDevList[i].szDevinfo;
	// }
	// pstBroadCastListInfo.ulDevNum = (uint)selecteditems.Length;
	// uResult = IMOS_StartMP3BroadCast(filepath, ref pstBroadCastListInfo);
	// }
	// return uResult.ToString();
	// }
	// catch (Exception ex)
	// {
	// return ex.Message;
	// }
	// }

	/// <summary>
	/// ��˷纰��
	/// </summary>
	// public string BroadcastMic(string[] devicecodes)
	// {
	// uint uResult = 0;
	// try
	// {
	// var selecteditems = devicecodes;
	// if (selecteditems.Length < 1)
	// {
	// return "�豸����С��1";
	// }
	// /* ���豸����洢��һ����ṹ���� */
	// int indexcnt = 0;
	// BROADCAST_DEV_S[] szDevList = new BROADCAST_DEV_S[selecteditems.Length];
	// for (int i = 0; i < selecteditems.Length; i++)
	// szDevList[i] = BROADCAST_DEV_S.GetInstance();
	// foreach (var devicecode in selecteditems)
	// {
	// /*��ȡѡ���豸��Ϣ*/
	// Encoding.UTF8.GetBytes(devicecode).CopyTo(szDevList[indexcnt].szDevinfo, 0);
	// indexcnt++;
	// }
	// // ��Ϊ���ɲ�������Ϊ200���������SDK_SPS_MAX_ITEM_NUM��200���������ѭ��
	// int cyclescnt = selecteditems.Length / SDK_SPS_MAX_ITEM_NUM + 1;
	// for (int j = 0; j < cyclescnt; j++)
	// {
	// // ����ÿ��ѭ���豸�ĸ���
	// int count = 0;
	// if (selecteditems.Length > (j + 1) * SDK_SPS_MAX_ITEM_NUM)
	// {
	// count = SDK_SPS_MAX_ITEM_NUM;
	// }
	// else
	// {
	// count = selecteditems.Length - j * SDK_SPS_MAX_ITEM_NUM;
	// }
	// // ��ȡÿ��ѡ���豸�ı���
	// var pstBroadCastListInfo = BROADCAST_DEV_LIST_S.GetInstance();
	// pstBroadCastListInfo.ulDevNum = (uint)count;
	// for (int i = 0; i < count; i++)
	// {
	// pstBroadCastListInfo.szDevList[i].szDevinfo = szDevList[i + j *
	// SDK_SPS_MAX_ITEM_NUM].szDevinfo;
	// }
	// uResult = IMOS_StartMICBroadCast(ref pstBroadCastListInfo);
	// }
	// return uResult.ToString();
	// }
	// catch (Exception ex)
	// {
	// return ex.Message;
	// }
	// }

	/// <summary>
	/// ֹͣ�㲥������
	/// </summary>
	// public string StopBroadcast(string[] devicecodes)
	// {
	// try
	// {
	// BROADCAST_DEV_LIST_S pstBroadCastListInfo =
	// BROADCAST_DEV_LIST_S.GetInstance();
	// uint uResult = 0;
	// var selecteditems = devicecodes;
	// if (selecteditems.Length < 1)
	// {
	// return "�豸����С��1";
	// }
	// /* ���豸����洢��һ����ṹ���� */
	// int indexcnt = 0;
	// BROADCAST_DEV_S[] szDevList = new BROADCAST_DEV_S[selecteditems.Length];
	// for (int i = 0; i < selecteditems.Length; i++)
	// szDevList[i] = BROADCAST_DEV_S.GetInstance();
	// foreach (var devicecode in selecteditems)
	// {
	// /*��ȡѡ���豸��Ϣ*/
	// Encoding.UTF8.GetBytes(devicecode).CopyTo(szDevList[indexcnt].szDevinfo, 0);
	// indexcnt++;
	// }
	// // ��Ϊ���ɹرո���Ϊ200���������SDK_SPS_MAX_ITEM_NUM��200���������ѭ��
	// int cyclescnt = selecteditems.Length / SDK_SPS_MAX_ITEM_NUM + 1;
	// for (int j = 0; j < cyclescnt; j++)
	// {
	// // ����ÿ��ѭ���ر��豸�ĸ���
	// int count = 0;
	// if (selecteditems.Length > (j + 1) * SDK_SPS_MAX_ITEM_NUM)
	// {
	// count = SDK_SPS_MAX_ITEM_NUM;
	// }
	// else
	// {
	// count = selecteditems.Length - j * SDK_SPS_MAX_ITEM_NUM;
	// }
	// // ��ȡÿ��ѡ���豸�ı���
	// pstBroadCastListInfo = BROADCAST_DEV_LIST_S.GetInstance();
	// pstBroadCastListInfo.ulDevNum = (uint)count;
	// for (int i = 0; i < count; i++)
	// {
	// pstBroadCastListInfo.szDevList[i].szDevinfo = szDevList[i + j *
	// SDK_SPS_MAX_ITEM_NUM].szDevinfo;
	// }
	// uResult = IMOS_StopBroadCast(ref pstBroadCastListInfo);
	// }
	// return uResult.ToString();
	// }
	// catch (Exception ex)
	// {
	// return ex.Message;
	// }
	// }
	
    public static int UsrLoginV3(String szUserLoginName, String szPasswd, String szIpAddress, int iLoginNameType, LOGIN_INFO_S.ByReference ptrSDKLoginInfo) throws Exception
    {
        LOGIN_EXT_INFO_S.ByReference stLoginExtInfo = LOGIN_EXT_INFO_S.ByReference.GetInstance();
        stLoginExtInfo.ulLoginType = 0;
        stLoginExtInfo.ulLoginNameType = iLoginNameType;
		stLoginExtInfo.szIpAddress = szIpAddress.getBytes();
        //Encoding.UTF8.GetBytes(szIpAddress).CopyTo(stLoginExtInfo.szIpAddress, 0);

		String macString=getMACAddress();
		MAC_ADDRESS_INFO_S.ByValue[] aomm = (MAC_ADDRESS_INFO_S.ByValue[])new MAC_ADDRESS_INFO_S.ByValue().toArray(20);
		int num = stLoginExtInfo.ulOperMachineMacNum;
		MAC_ADDRESS_INFO_S.ByValue aomByReference = new MAC_ADDRESS_INFO_S.ByValue();
		aomByReference.szMacAddress = macString.getBytes();
		aomm[num] = aomByReference;
		stLoginExtInfo.astOperMachineMac = aomm;
		stLoginExtInfo.ulOperMachineMacNum++;
		

		byte[] szUsrLoginNameB = new byte[IMOSSDK.IMOS_NAME_LEN];
		szUsrLoginNameB = szUserLoginName.getBytes();
		// Encoding.UTF8.GetBytes(szUserLoginName).CopyTo(szUsrLoginNameB, 0);
		byte[] szPasswordB = new byte[IMOSSDK.IMOS_PASSWD_ENCRYPT_LEN];
		szPasswordB = szPasswd.getBytes();
		// Encoding.UTF8.GetBytes(szPasswd).CopyTo(szPasswordB, 0);
		byte[] szIpAddressB = new byte[IMOSSDK.IMOS_IPADDR_LEN];
		szIpAddressB = szIpAddress.getBytes();
		// Encoding.UTF8.GetBytes(szIpAddress).CopyTo(szIpAddressB, 0);
		/* �ж�ָ����Σ�Ϊ����ֱ�ӷ���ָ��Ϊ�� */
		if (ptrSDKLoginInfo == null) {
			return 1002;
		}
		int ret = IMOSSDKObj.IMOS_LoginV2(szUsrLoginNameB, szPasswordB, szIpAddressB, stLoginExtInfo,
				ptrSDKLoginInfo);
		return ret;
    }

	/// <summary>
	/// ��¼����2
	/// </summary>
	/// <param name="szUserLoginName"></param>
	/// <param name="szPasswd"></param>
	/// <param name="szIpAddress">�û���¼���Ե�IP��ַ</param>
	/// <param name="iLoginNameType"></param>
	/// <param name="ptrSDKLoginInfo"></param>
	/// <returns></returns>
	private static int UsrLoginV2(String szUserLoginName, String szPasswd, String szIpAddress, int iLoginNameType,
			LOGIN_INFO_S.ByReference ptrSDKLoginInfo) throws Exception {
		try {
			LOGIN_EXT_INFO_S.ByReference stLoginExtInfo = new LOGIN_EXT_INFO_S.ByReference();
			stLoginExtInfo.ulLoginType = 0;
			stLoginExtInfo.ulLoginNameType = iLoginNameType;
			stLoginExtInfo.szIpAddress = szIpAddress.getBytes();
			// Encoding.UTF8.GetBytes(szIpAddress).CopyTo(stLoginExtInfo.szIpAddress, 0);
			// foreach (string mac in GetMacAddress())
			// {
			// Encoding.UTF8.GetBytes(mac.Replace(":",
			// "-")).CopyTo(stLoginExtInfo.astOperMachineMac[stLoginExtInfo.ulOperMachineMacNum++].szMacAddress,
			// 0);
			// }

			Object[] macsArrayList = GetMacAddress().toArray();
			MAC_ADDRESS_INFO_S.ByValue[] aomm = (MAC_ADDRESS_INFO_S.ByValue[])new MAC_ADDRESS_INFO_S.ByValue().toArray(20);
			for (int i = 0; i < macsArrayList.length; i++) {
				if (!macsArrayList[i].toString().isEmpty()) {
					int num = stLoginExtInfo.ulOperMachineMacNum;
					MAC_ADDRESS_INFO_S.ByValue aomByReference = new MAC_ADDRESS_INFO_S.ByValue();
					aomByReference.szMacAddress = macsArrayList[i].toString().getBytes();
					aomm[num] = aomByReference;
					stLoginExtInfo.astOperMachineMac = aomm;
					stLoginExtInfo.ulOperMachineMacNum++;
					// stLoginExtInfo.astOperMachineMac[stLoginExtInfo.ulOperMachineMacNum++].szMacAddress=macsArrayList[i].toString().getBytes();
				}
			}

			byte[] szUsrLoginNameB = new byte[IMOSSDK.IMOS_NAME_LEN];
			szUsrLoginNameB = szUserLoginName.getBytes();
			// Encoding.UTF8.GetBytes(szUserLoginName).CopyTo(szUsrLoginNameB, 0);
			byte[] szPasswordB = new byte[IMOSSDK.IMOS_PASSWD_ENCRYPT_LEN];
			szPasswordB = szPasswd.getBytes();
			// Encoding.UTF8.GetBytes(szPasswd).CopyTo(szPasswordB, 0);
			byte[] szIpAddressB = new byte[IMOSSDK.IMOS_IPADDR_LEN];
			szIpAddressB = szIpAddress.getBytes();
			// Encoding.UTF8.GetBytes(szIpAddress).CopyTo(szIpAddressB, 0);
			/* �ж�ָ����Σ�Ϊ����ֱ�ӷ���ָ��Ϊ�� */
			if (ptrSDKLoginInfo == null) {
				return 1002;
			}
			int ret = IMOSSDKObj.IMOS_LoginV2(szUsrLoginNameB, szPasswordB, szIpAddressB, stLoginExtInfo,
					ptrSDKLoginInfo);
			return ret;
		} catch (Exception e) {
			return -1;
		}
	}

	/// <summary>
	/// ����MAC��ַ
	/// </summary>
	/// <returns></returns>
	public static ArrayList<String> GetMacAddress() throws Exception {
		ArrayList<String> ret = new ArrayList<String>();
		Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
		while (enumeration.hasMoreElements()) {
			StringBuffer stringBuffer = new StringBuffer();
			NetworkInterface networkInterface = enumeration.nextElement();
			if (networkInterface != null) {
				byte[] bytes = networkInterface.getHardwareAddress();
				if (bytes != null) {
					for (int i = 0; i < bytes.length; i++) {
						if (i != 0) {
							stringBuffer.append("-");
						}
						int tmp = bytes[i] & 0xff; // �ֽ�ת��Ϊ����
						String str = Integer.toHexString(tmp);
						if (str.length() == 1) {
							stringBuffer.append("0" + str);
						} else {
							stringBuffer.append(str);
						}
					}
					String mac = stringBuffer.toString().toUpperCase();
					ret.add(mac);
				}
			}
		}
		return ret;
	}
	

	// ��ȡMAC��ַ�ķ���
	private static String getMACAddress() throws Exception {
		InetAddress ia = InetAddress.getLocalHost();// ��ȡ����IP����
		// �������ӿڶ��󣨼������������õ�mac��ַ��mac��ַ������һ��byte�����С�
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

		// ��������ǰ�mac��ַƴװ��String
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			// mac[i] & 0xFF ��Ϊ�˰�byteת��Ϊ������
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		// ���ַ�������Сд��ĸ��Ϊ��д��Ϊ�����mac��ַ������
		return sb.toString().toUpperCase();
	}

	/// <summary>
	/// ��ȡ����IP��ַ
	/// </summary>
	/// <returns></returns>
	public static String GetLocalIp() throws Exception {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString(); // ��ȡ����ip
			return ip;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* ָ��ת�ṹ�壬https://www.cnblogs.com/kumu/p/7696524.html */
	public static <T extends Structure> T pointer2Structure(Pointer pParam, Class<T> res) throws Exception {
		T Param;
		Param = res.newInstance();
		Pointer facePointer = Param.getPointer();
		facePointer.write(0, pParam.getByteArray(0, Param.size()), 0, Param.size());
		Param.read();
		return Param;
	}

}
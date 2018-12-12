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
	 * 关闭指定设备上的广播
	 * 
	 * @param [IN]
	 *            pstUserLoginIDInfo 用户信息
	 * @param [IN]
	 *            pstBroadCastListInfo 设备列表
	 * @return 返回如下结果： - 成功： - 失败： - 返回操作结果码，见错误码文件
	 * @note - 1. 关闭广播会同时关闭插播
	 */
	public static int IMOS_StopBroadCastByDev(USER_LOGIN_ID_INFO_S.ByReference pstUserLoginIDInfo,
			BROADCAST_DEV_LIST_S.ByReference pstBroadCastListInfo) throws Exception {
		return IMOSSDKObj.IMOS_CloseDevBroadCast(pstUserLoginIDInfo, pstBroadCastListInfo);
	}

	/**
	 * 开启广播
	 * 
	 * @param [IN]
	 *            pstUserLoginIDInfo 用户信息
	 * @param [IN]
	 *            pstParamInfo 广播参数信息
	 * @param [IN]
	 *            pstDevListInfo 需要广播的设备列表
	 * @param [IN]
	 *            pstBrdcastInfo 广播信息
	 * @return 返回如下结果： - 成功： - 失败： - 返回操作结果码，见错误码文件
	 * @note - 1. 第一次建立时，建立成功的广播信息通过pstBrdcastInfo返回 - 2.
	 *       如果想向已存在的广播中加入新的广播设备，则需要指定pstBrdcastInfo->szXPVocBrdCode为已存在的编码
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
	/// 开启MP3广播
	/// </summary>
	/// <param name="mp3filepath">MP3文件路径</param>
	/// <param name="pstBroadCastListInfo">广播播放列表信息</param>
	/// <returns></returns>
	// public static int IMOS_StartMP3BroadCast(String mp3filepath,
	// BROADCAST_DEV_LIST_S.ByReference pstBroadCastListInfo)
	// {
	// int uResult = 0;
	// /*组织用户信息*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	// /*广播参数信息*/
	// BROADCAST_PARAM_INFO_S.ByReference pstParamInfo = new
	// BROADCAST_PARAM_INFO_S.ByReference();
	// pstParamInfo.ulVoiceType = IMOSSDKObj.BRAODCAST_VOICE_FILE;
	// pstParamInfo.ulModeType = IMOSSDKObj.BROADCAST_PLAY_MODE_SEQUENCE;
	// //pstParamInfo.szBroadcastDesc =; // 该动作备注描述, 用于记录日志
	//
	// // URL or 文件名 or 节目ID
	// Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstParamInfo.szBroacastInfo,
	// 0);
	// /*广播信息*/
	// BROADCAST_INFO_S pstBrdcastInfo = BROADCAST_INFO_S.GetInstance();
	// // URL or 文件名 or 节目ID
	// Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstBrdcastInfo.szBroacastInfo,
	// 0);
	// pstBrdcastInfo.szUserCode = stLoginInfo.stUserLoginIDInfo.szUserCode;
	// pstBrdcastInfo.szUserLoginCode =
	// stLoginInfo.stUserLoginIDInfo.szUserLoginCode;
	// //pstBrdcastInfo.szXPVocBrdCode =; // 广播或插播编码
	// pstBrdcastInfo.ulSrvType = BROADCAST_SRV_BRDCAST;
	// pstBrdcastInfo.ulVoiceType = BRAODCAST_VOICE_FILE;
	//
	// uResult = IMOSSDKObj.IMOS_StartBroadCast_T(ref pstUserLogIDInfo, ref
	// pstParamInfo, ref pstBroadCastListInfo, ref pstBrdcastInfo);
	//
	// return uResult;
	// }

	/// <summary>
	/// 开启MIC广播
	/// </summary>
	/// <param name="pstBroadCastListInfo">广播播放列表信息</param>
	/// <returns></returns>
	// private static uint IMOS_StartMICBroadCast(ref BROADCAST_DEV_LIST_S
	// pstBroadCastListInfo)
	// {
	// uint uResult = 0;
	// /*组织用户信息*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	// /*广播参数信息*/
	// BROADCAST_PARAM_INFO_S pstParamInfo = BROADCAST_PARAM_INFO_S.GetInstance();
	// pstParamInfo.ulVoiceType = BRAODCAST_VOICE_MIC;
	// pstParamInfo.ulModeType = BROADCAST_PLAY_MODE_SEQUENCE;
	// //pstParamInfo.szBroadcastDesc =; // 该动作备注描述, 用于记录日志
	// // URL or 文件名 or 节目ID
	// //Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstParamInfo.szBroacastInfo,
	// 0);
	// /*广播信息*/
	// BROADCAST_INFO_S pstBrdcastInfo = BROADCAST_INFO_S.GetInstance();
	// // URL or 文件名 or 节目ID
	// //Encoding.UTF8.GetBytes(mp3filepath.ToString()).CopyTo(pstBrdcastInfo.szBroacastInfo,
	// 0);
	// pstBrdcastInfo.szUserCode = stLoginInfo.stUserLoginIDInfo.szUserCode;
	// pstBrdcastInfo.szUserLoginCode =
	// stLoginInfo.stUserLoginIDInfo.szUserLoginCode;
	// //pstBrdcastInfo.szXPVocBrdCode =; // 广播或插播编码
	// pstBrdcastInfo.ulSrvType = BROADCAST_SRV_BRDCAST;
	// pstBrdcastInfo.ulVoiceType = BRAODCAST_VOICE_MIC;
	//
	// uResult = IMOSSDKObj.IMOS_StartBroadCast(ref pstUserLogIDInfo, ref
	// pstParamInfo, ref pstBroadCastListInfo, ref pstBrdcastInfo);
	//
	// return uResult;
	// }

	/// <summary>
	/// 关闭广播
	/// </summary>
	/// <param name="pstBroadCastListInfo">广播播放列表信息</param>
	/// <returns></returns>
	// private static uint IMOS_StopBroadCast(ref BROADCAST_DEV_LIST_S
	// pstBroadCastListInfo)
	// {
	// uint uResult = 0;
	// /*组织用户信息*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	//
	// uResult = IMOSSDKObj.IMOS_StopBroadCastByDev(ref pstUserLogIDInfo, ref
	// pstBroadCastListInfo);
	//
	// return uResult;
	// }

	/// <summary>
	/// 登录
	/// </summary>
	/// <param name="ip"></param>
	/// <param name="usr"></param>
	/// <param name="pwd"></param>
	/// <param name="port"></param>
	/// <returns></returns>
	public static String Login(String ip, String usr, String pwd, int port) throws Exception {
		try {
			// String cltIpAddr = "N/A";
			// 3.登录方法
			// IntPtr ptrLoginInfo =
			// Marshal.AllocHGlobal(Marshal.SizeOf(typeof(LOGIN_INFO_S)));
			IMOSSDK.LOGIN_INFO_S.ByReference ptrLoginInfo = new IMOSSDK.LOGIN_INFO_S.ByReference();
			int ulRet = 0;
			int srvPort = port;
			// byte[] szServerAddB = InetAddress.getByName(ip).getAddress();
			byte[] szServerAddB = ip.getBytes();
			// 1.初始化
			ulRet = IMOSSDKObj.IMOS_Initiate(szServerAddB, srvPort, 1, 1);
			if (0 != ulRet) {
				return "初始化失败!";
			}
			// 2.加密密码
			// IntPtr ptr_MD_Pwd = Marshal.AllocHGlobal(sizeof(char) *
			// IMOS_PASSWD_ENCRYPT_LEN);
			byte[] buf = new byte[512];
			ulRet = IMOSSDKObj.IMOS_Encrypt(pwd, pwd.length(), buf);
			String MD_PWD = Native.toString(buf);
			if (0 != ulRet) {
				return "加密密码失败!";
			}
			// String MD_PWD = Marshal.PtrToStringAnsi(ptr_MD_Pwd);
			// String MD_PWD = ptr_MD_Pwd;
			// Marshal.FreeHGlobal(ptr_MD_Pwd);
			String localip = GetLocalIp();
			int result = UsrLoginV2(usr, MD_PWD, "208.208.101.15", 0, ptrLoginInfo);
			// 用户已经登录
			if (12351 == result) {
				// 调用LoginV2函数，以用户编码和密码登录
				result = UsrLoginV2(usr, MD_PWD, "208.208.101.15", 1, ptrLoginInfo);
			}
			if (0 != result) {
				return "登录失败，错误码：" + result;
			}
			stLoginInfo = ptrLoginInfo;
			// stLoginInfo = (LOGIN_INFO_S)Marshal.PtrToStructure(ptrLoginInfo,
			// typeof(LOGIN_INFO_S));
			// Marshal.FreeHGlobal(ptrLoginInfo);

			// 4.启动播放器
			// IntPtr ptrPlayWndInfo = Marshal.AllocHGlobal(25 *
			// Marshal.SizeOf(typeof(PLAY_WND_INFO_S)));

			IMOSSDK.PLAY_WND_INFO_S.ByReference ptrPlayWndInfo = new IMOSSDK.PLAY_WND_INFO_S.ByReference();
			ulRet = IMOSSDKObj.IMOS_StartPlayer(stLoginInfo.stUserLoginIDInfo, 25, ptrPlayWndInfo);
			if (0 != ulRet) {
				return "启动播放器失败，错误码：" + ulRet;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return "0";
	}

	/// <summary>
	/// 登出
	/// </summary>
	public String Logout() {
		IMOSSDKObj.IMOS_LogoutEx(stLoginInfo.stUserLoginIDInfo);
		return "0";
	}

	/// <summary>
	/// 显示设备列表
	/// </summary>
	// public string GetDevices()
	// {
	// /*组织用户信息*/
	// USER_LOGIN_ID_INFO_S pstUserLogIDInfo = stLoginInfo.stUserLoginIDInfo;
	// /*申请分页内存空间*/
	// Int32 iSize =
	// Marshal.SizeOf(typeof(RES_ITEM_V2_S));//表示每一个RES_ITEM_V2_S结构体所需要的存储空间
	// Int32 iSize1 = Marshal.SizeOf(typeof(BROADCAST_DEV_INFO_S));
	// /*查询页面的结构信息*/
	// QUERY_PAGE_INFO_S stQueryPageInfo = new QUERY_PAGE_INFO_S();
	// stQueryPageInfo.bQueryCount = true;
	// stQueryPageInfo.ulPageFirstRowNumber = 0;
	// stQueryPageInfo.ulPageRowNum = 200;//最大值200
	// IntPtr pstPageInfo = IntPtr.Zero;
	// int iPageInfoSize = Marshal.SizeOf(typeof(RSP_PAGE_INFO_S));
	// IntPtr pstDevStatItem = IntPtr.Zero;
	// int iItemSize = Marshal.SizeOf(typeof(BROADCAST_DEV_INFO_S));
	// IntPtr pstDevQueryItem = IntPtr.Zero;
	// iItemSize = Marshal.SizeOf(typeof(RES_ITEM_V2_S));
	// try
	// {
	// /*申请为分配列表空间*/
	// RSP_PAGE_INFO_S stRspPageInfo = new RSP_PAGE_INFO_S();
	// /*查询条件，设备类型为IPB设备*/
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
	// //查询子组织
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
	// /* 查询设备列表信息 */
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
	// /*将指针转化为结构体*/
	// stRspPageInfo = (RSP_PAGE_INFO_S)Marshal.PtrToStructure(pstPageInfo,
	// typeof(RSP_PAGE_INFO_S));
	// /* 根据设备编码获取设备状态 */
	// BROADCAST_DEV_LIST_S pstDevListInfo = BROADCAST_DEV_LIST_S.GetInstance();
	// for (int i = 0; i < stRspPageInfo.ulRowNum; i++)
	// {
	// sps_DevInfo = (RES_ITEM_V2_S)Marshal.PtrToStructure((pstDevQueryItem + iSize
	// * i), typeof(RES_ITEM_V2_S));//将返回的指针转换成RES_ITEM_V2_S
	// pstDevListInfo.szDevList[i].szDevinfo = sps_DevInfo.stResItemV1.szResCode;
	// }
	// pstDevListInfo.ulDevNum = stRspPageInfo.ulRowNum;
	// uint pulDevNum = 0;
	// if (pstDevListInfo.ulDevNum > 0)
	// {
	// uResult = IMOS_QueryBroadcastDevInfo(ref pstUserLogIDInfo, ref
	// pstDevListInfo, ref pulDevNum, pstDevStatItem);
	// /* 获取状态成功 更新列表中设备状态 */
	// if (uResult == ERR_COMMON_SUCCEED)
	// {
	// var devices = new List<IMOS_Device>();
	// //this.listView1.BeginUpdate();
	// //数据更新，UI暂时挂起，直到EndUpdate绘制控件，可以有效避免闪烁并大大提高加载速度
	// for (int i = 0; i < (int)pulDevNum; i++)
	// {
	// /*添加列表数据*/
	// sps_DevInfo = (RES_ITEM_V2_S)Marshal.PtrToStructure((pstDevQueryItem + iSize
	// * i), typeof(RES_ITEM_V2_S));//将返回的指针转换成RES_ITEM_V2_S
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
	// //第一列，设备名称
	// //第二列，设备编码
	// //第三列，设备IP
	// //第四列，设备类型
	// switch (sps_DevStats.ulDevBrdStatus)
	// {
	// case BROADCAST_DEV_PLAYING:
	// device.DeviceStatus = "播放";//第五列，设备状态
	// break;
	// case BROADCAST_DEV_NORMAL:
	// device.DeviceStatus = "在线";//第五列，设备状态
	// break;
	// case BROADCAST_DEV_OFFLINE:
	// device.DeviceStatus = "离线";//第五列，设备状态
	// break;
	// default:
	// device.DeviceStatus = "无效";//第五列，设备状态
	// break;
	// }
	// devices.Add(device);
	// }
	// return JsonConvert.SerializeObject(devices);//返回所有设备及状态列表json序列化字符串
	// }
	// else
	// {
	// return "查询设备信息失败！错误码：" + uResult;
	// }
	// }
	// else
	// {
	// return "没有获取到任何设备！";
	// }
	// }
	// else
	// {
	// return "查询资源列表失败！错误码：" + uResult;
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
	/// MP3文件广播
	/// </summary>
	// public string BroadcastMp3(string filepath, string[] devicecodes)
	// {
	// try
	// {
	// uint uResult = 0;
	// //需要播放的广播设备列表
	// var pstBroadCastListInfo = BROADCAST_DEV_LIST_S.GetInstance();
	// var selecteditems = devicecodes;
	// if (selecteditems.Length < 1)
	// {
	// return "设备数量小于1";
	// }
	// //先播放当前设备列表中选中的设备
	// if (selecteditems.Length > 0)
	// {
	// BROADCAST_DEV_S[] szDevList = new BROADCAST_DEV_S[selecteditems.Length];
	// for (int i = 0; i < selecteditems.Length; i++)
	// {
	// szDevList[i] = BROADCAST_DEV_S.GetInstance();
	// }
	// //获取已选中的设备编码
	// int indexcnt = 0;
	// foreach (var devicecode in selecteditems)
	// {
	// /*获取选中设备信息*/
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
	/// 麦克风喊话
	/// </summary>
	// public string BroadcastMic(string[] devicecodes)
	// {
	// uint uResult = 0;
	// try
	// {
	// var selecteditems = devicecodes;
	// if (selecteditems.Length < 1)
	// {
	// return "设备数量小于1";
	// }
	// /* 将设备编码存储到一个大结构体中 */
	// int indexcnt = 0;
	// BROADCAST_DEV_S[] szDevList = new BROADCAST_DEV_S[selecteditems.Length];
	// for (int i = 0; i < selecteditems.Length; i++)
	// szDevList[i] = BROADCAST_DEV_S.GetInstance();
	// foreach (var devicecode in selecteditems)
	// {
	// /*获取选中设备信息*/
	// Encoding.UTF8.GetBytes(devicecode).CopyTo(szDevList[indexcnt].szDevinfo, 0);
	// indexcnt++;
	// }
	// // 因为最大可操作个数为200，如果大于SDK_SPS_MAX_ITEM_NUM（200），则进行循环
	// int cyclescnt = selecteditems.Length / SDK_SPS_MAX_ITEM_NUM + 1;
	// for (int j = 0; j < cyclescnt; j++)
	// {
	// // 计算每次循环设备的个数
	// int count = 0;
	// if (selecteditems.Length > (j + 1) * SDK_SPS_MAX_ITEM_NUM)
	// {
	// count = SDK_SPS_MAX_ITEM_NUM;
	// }
	// else
	// {
	// count = selecteditems.Length - j * SDK_SPS_MAX_ITEM_NUM;
	// }
	// // 获取每个选中设备的编码
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
	/// 停止广播及喊话
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
	// return "设备数量小于1";
	// }
	// /* 将设备编码存储到一个大结构体中 */
	// int indexcnt = 0;
	// BROADCAST_DEV_S[] szDevList = new BROADCAST_DEV_S[selecteditems.Length];
	// for (int i = 0; i < selecteditems.Length; i++)
	// szDevList[i] = BROADCAST_DEV_S.GetInstance();
	// foreach (var devicecode in selecteditems)
	// {
	// /*获取选中设备信息*/
	// Encoding.UTF8.GetBytes(devicecode).CopyTo(szDevList[indexcnt].szDevinfo, 0);
	// indexcnt++;
	// }
	// // 因为最大可关闭个数为200，如果大于SDK_SPS_MAX_ITEM_NUM（200），则进行循环
	// int cyclescnt = selecteditems.Length / SDK_SPS_MAX_ITEM_NUM + 1;
	// for (int j = 0; j < cyclescnt; j++)
	// {
	// // 计算每次循环关闭设备的个数
	// int count = 0;
	// if (selecteditems.Length > (j + 1) * SDK_SPS_MAX_ITEM_NUM)
	// {
	// count = SDK_SPS_MAX_ITEM_NUM;
	// }
	// else
	// {
	// count = selecteditems.Length - j * SDK_SPS_MAX_ITEM_NUM;
	// }
	// // 获取每个选中设备的编码
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
		/* 判断指针入参，为空则直接返回指针为空 */
		if (ptrSDKLoginInfo == null) {
			return 1002;
		}
		int ret = IMOSSDKObj.IMOS_LoginV2(szUsrLoginNameB, szPasswordB, szIpAddressB, stLoginExtInfo,
				ptrSDKLoginInfo);
		return ret;
    }

	/// <summary>
	/// 登录方法2
	/// </summary>
	/// <param name="szUserLoginName"></param>
	/// <param name="szPasswd"></param>
	/// <param name="szIpAddress">用户登录电脑的IP地址</param>
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
			/* 判断指针入参，为空则直接返回指针为空 */
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
	/// 网卡MAC地址
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
						int tmp = bytes[i] & 0xff; // 字节转换为整数
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
	

	// 获取MAC地址的方法
	private static String getMACAddress() throws Exception {
		InetAddress ia = InetAddress.getLocalHost();// 获取本地IP对象
		// 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

		// 下面代码是把mac地址拼装成String
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			// mac[i] & 0xFF 是为了把byte转化为正整数
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		// 把字符串所有小写字母改为大写成为正规的mac地址并返回
		return sb.toString().toUpperCase();
	}

	/// <summary>
	/// 获取本机IP地址
	/// </summary>
	/// <returns></returns>
	public static String GetLocalIp() throws Exception {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString(); // 获取本机ip
			return ip;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* 指针转结构体，https://www.cnblogs.com/kumu/p/7696524.html */
	public static <T extends Structure> T pointer2Structure(Pointer pParam, Class<T> res) throws Exception {
		T Param;
		Param = res.newInstance();
		Pointer facePointer = Param.getPointer();
		facePointer.write(0, pParam.getByteArray(0, Param.size()), 0, Param.size());
		Param.read();
		return Param;
	}

}
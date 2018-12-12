/**
 * 用途：jna 调用xp_frame
 */
package imos;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface XpFrame extends StdCallLibrary {

	XpFrame INSTANCE = (XpFrame) Native.loadLibrary(DllPath.DLL_PATH + "xp_frame.dll", XpFrame.class);

	/// <summary>
	/// 设置广播终端音量
	/// </summary>
	/// <param name="ulVolume">音量值（取值从0到255,255为最大音量）</param>
	/// <returns></returns>
	public int IMOS_SetVolume(int ulVolume);

	/// <summary>
	/// 设置话筒输入音量
	/// </summary>
	/// <param name="ulVolume"></param>
	/// <returns></returns>
	public int IMOS_SetWaveInVolume(int ulVolume);

	/// <summary>
	/// 获取广播终端音量
	/// </summary>
	/// <param name="volume"></param>
	/// <returns></returns>
	public int IMOS_GetVolume(IntByReference volume);

	/// <summary>
	/// 获取话筒音量
	/// </summary>
	/// <param name="volume"></param>
	/// <returns></returns>
	public int IMOS_GetMicVolume(IntByReference volume);
}

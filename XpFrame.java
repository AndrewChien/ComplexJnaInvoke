/**
 * ��;��jna ����xp_frame
 */
package imos;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface XpFrame extends StdCallLibrary {

	XpFrame INSTANCE = (XpFrame) Native.loadLibrary(DllPath.DLL_PATH + "xp_frame.dll", XpFrame.class);

	/// <summary>
	/// ���ù㲥�ն�����
	/// </summary>
	/// <param name="ulVolume">����ֵ��ȡֵ��0��255,255Ϊ���������</param>
	/// <returns></returns>
	public int IMOS_SetVolume(int ulVolume);

	/// <summary>
	/// ���û�Ͳ��������
	/// </summary>
	/// <param name="ulVolume"></param>
	/// <returns></returns>
	public int IMOS_SetWaveInVolume(int ulVolume);

	/// <summary>
	/// ��ȡ�㲥�ն�����
	/// </summary>
	/// <param name="volume"></param>
	/// <returns></returns>
	public int IMOS_GetVolume(IntByReference volume);

	/// <summary>
	/// ��ȡ��Ͳ����
	/// </summary>
	/// <param name="volume"></param>
	/// <returns></returns>
	public int IMOS_GetMicVolume(IntByReference volume);
}

package test;

import imos.DllPath;
import imos.SDK;

public class TestConsole {

	private SDK sdk = new SDK();

	public static void main(String[] args) {
		try {

			String aString = DllPath.DLL_PATH + "imos_sdk.dll";

			SDK.Login("173.173.21.2", "loadmin", "loadmin", 8800);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
}
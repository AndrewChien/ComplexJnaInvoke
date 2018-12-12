package imos;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class ByteArray extends Structure {
	public static final int MAX_LENGTH = 512;
 
	public byte[] data = new byte[MAX_LENGTH];
 
	public static class ByReference extends ByteArray implements
			Structure.ByReference {
	}
 
	public static class ByValue extends ByteArray implements Structure.ByValue {
	}
 
	public ByteArray() {
		super();
		this.setAlignType(Structure.ALIGN_DEFAULT);
	}
 
	public ByteArray(Pointer pointer) {
		super(pointer);
		this.setAlignType(Structure.ALIGN_DEFAULT);
	}
 
	public void init(byte[] data) {
		if (data != null) {
			int minLen = (data.length > MAX_LENGTH) ? MAX_LENGTH : data.length;
			System.arraycopy(data, 0, this.data, 0, minLen);
		}
	}
 
	public byte[] getData() {
		return this.data;
	}
 
	@SuppressWarnings("unchecked")
	protected List getFieldOrder() {
		return Arrays.asList(new String[] { "data" });
	}
}
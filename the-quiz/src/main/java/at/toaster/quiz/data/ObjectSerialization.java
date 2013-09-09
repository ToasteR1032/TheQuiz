package at.toaster.quiz.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ObjectSerialization {
	static private BASE64Encoder encode = new BASE64Encoder();
	static private BASE64Decoder decode = new BASE64Decoder();

	static public String OToS(Object obj) {
		String out = null;
		if (obj != null) {
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(obj);
				out = encode.encode(baos.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return out;
	}

	static public Object SToO(String str) {
		Object out = null;
		if (str != null) {
			try {

				ByteArrayInputStream bios = new ByteArrayInputStream(decode.decodeBuffer(str));
				ObjectInputStream ois = new ObjectInputStream(bios);
				out = ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		return out;
	}
}
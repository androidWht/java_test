package classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		File path = new File(name +".class");
		
		try {
			InputStream input = new FileInputStream(path);
			byte[] data = new byte[1024];
			int n = input.read(data);
			input.close();
			
			/**
			 * JVM��֤��name.�ַ���������ַ����Ƿ����ֽ����е�����һ��
			 * ��һ�¾ͻᱨNoClassDefFoundError(wrong name)
			 */
			return defineClass(name,data, 0, n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new ClassNotFoundException();
	}
	
	
	
}

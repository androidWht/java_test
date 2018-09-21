package io.serializable;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Test Java Seriablizble
 * seriablizable not need call construction
 * serialVersionUID不同会造成InvideClassException
 * Externalizable 会调用构造器
 * [writeObject , readObject]不会调用构造器
 * @author wanghaitao
 *
 */
public class Test {
	private static File file = new File("d:/seriablizable.txt");
	public static void main(String[] args) throws IOException ,ClassNotFoundException{
		seriablizable();
		
	}
	
	private static void seriablizable() throws IOException ,ClassNotFoundException{
		writeObject(file, new Inner1()); 
		readObject(file,Inner1.class); 
	}
	
	
	
	private static <T> void readObject(File file,Class<T> cls) throws IOException ,ClassNotFoundException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		T obj =  cls.cast(ois.readObject()); 
		ois.close();
		System.out.println(obj); 
	}
	
	private static <T> void writeObject(File file,T obj) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream ous = new ObjectOutputStream(fos);
		ous.writeObject(obj);
		ous.close();
	}
	
	private static class Inner implements Serializable{
		private static final long serialVersionUID = 2l;
		
		private static final String what = "what";
		private String name = "Inner";
		private boolean good = true;
		private transient int random = 1024;
		
		
		public Inner(){
			System.out.println("Inner Construction");
		}


		@Override
		public String toString() {
			return "Inner [name=" + name + ", good=" + good + "]";
		}
		
		
		
		
	}
	
	
	private static class Inner1 implements Externalizable{
		private static final long serialVersionUID = 20l;
		
		private static final String what = "what";
		
		private String name = "Inner1";
		
		private boolean result = true;
		private int n = 1;
		
		public Inner1(){
			System.out.println("Inner1 Construction");
		}
		
		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			System.out.println("writeExternal");
			out.writeUTF(name);
			out.writeBoolean(result);
			out.writeInt(n);
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			System.out.println("readExternal");
			name = in.readUTF();
			result = in.readBoolean();
			n = in.readInt();
		}

		@Override
		public String toString() {
			return "Inner1 [what="+ what +", name=" + name + ", result=" + result + ", n=" + n + "]";
		}
		
		
		
	}
	
	
	private static class Inner2 implements Serializable{
		private static final long serialVersionUID = 200l;
		private static  String what = "what";
		
		private String name = "Inner1";
		private boolean result = true;
		private int n = 1;
		
		public Inner2() {
			System.out.println("Inner2 Construction");
		}
		
		private void writeObject(ObjectOutputStream out) throws IOException{
			System.out.println("writeObject");
			out.writeUTF("a"); 
			out.writeUTF(name);
			out.writeBoolean(result);
			out.writeInt(n);
		}
		
		private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException{
			System.out.println("readObject");
			what = in.readUTF();
			name = in.readUTF();
			result = in.readBoolean();
			n = in.readInt();
		}
		
		@Override
		public String toString() {
			return "Inner1 [what="+ what +", name=" + name + ", result=" + result + ", n=" + n + "]";
		}
	}
	
}



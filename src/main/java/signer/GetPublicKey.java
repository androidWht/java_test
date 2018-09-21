package signer;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * 获取公钥
 * @author Administrator
 *
 */
public class GetPublicKey {

	 /** 
     * Java密钥库(Java Key Store，JKS)KEY_STORE 
     */  
    public static final String KEY_STORE = "JKS";  
  
    public static final String X509 = "X.509";  
    
    
    
    public static void main(String[] args){
    	String keystorePath = "C:/Users/Administrator/Desktop/class/signer/ijvmkeys";
    	String keyStorePwd = "ijvm2ed";
    	String keyAlias = "friend";
    	String keyPwd = "friend4life";
    	byte[] publicKey = getPublickKey(keystorePath, keyStorePwd, keyAlias);
    	byte[] privateKey = getPrivateKey(keystorePath, keyStorePwd, keyAlias, keyPwd);
    	System.out.println("publicKey : " + toString(publicKey));
    	System.out.println("privateKey : " + toString(privateKey));
    }
    
    
    public static KeyStore getKeyStore(String keystorePath,String storePwd){
    	KeyStore keystore = null;
		try {
			keystore = KeyStore.getInstance(KEY_STORE);
	    	keystore.load(new FileInputStream(keystorePath), storePwd.toCharArray()); 
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return keystore;
    }
    
    /**
     * 获取私钥
     * @param keystorePath
     * @param storePwd
     * @param keyAlias
     * @param keyPwd
     * @return
     */
    public static byte[] getPrivateKey(String keystorePath,String storePwd,String keyAlias,String keyPwd){
    	KeyStore keyStore = getKeyStore(keystorePath, storePwd);
    	PrivateKey pk = null;
    	try {
			 pk = (PrivateKey)keyStore.getKey(keyAlias, keyPwd.toCharArray());
			 return pk.getEncoded();
		} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	return null;
    }
	
    
    public static byte[] getPublickKey(String keystorePath,String storePwd,String keyAlias){
    	KeyStore keyStore = getKeyStore(keystorePath, storePwd);
    	PublicKey pk = null;
    	try {
			 pk = (PublicKey)keyStore.getCertificate(keyAlias).getPublicKey();
			 return pk.getEncoded();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    private static String toString(byte[] data){
    	String str = "";
    	for(byte b:data){
    		str = str + b;
    	}
    	return str;
    }
    
}




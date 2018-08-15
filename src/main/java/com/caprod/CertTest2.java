package com.caprod;

import org.bouncycastle.util.encoders.Base64;

import javax.crypto.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;

public class CertTest2 {
	
	/**
	 * KeyStore存储类型（编码和文件格式）
	 */
	public static final String PKCS12 = "pkcs12";
	
	/**
	 * @throws NoSuchPaddingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws ShortBufferException
	 */
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException,
											IOException, UnrecoverableKeyException,
											InvalidKeyException, NoSuchPaddingException,
											ShortBufferException, IllegalBlockSizeException, BadPaddingException {
		
		String charsetName = "UTF-8";
		String message = "子龙";
		//加密
		//cer格式的数字证书里面只有公钥没有私钥
		X509Certificate publicCert;
		CertificateFactory factory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("E:\\项目\\5caprod证书\\online\\itrus\\cafiles\\yjf-cert-2048.cer");
		try {
			publicCert = (X509Certificate) factory.generateCertificate(in);
		} finally {
			in.close();
		}
		Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
		cipher.init(Cipher.ENCRYPT_MODE, publicCert);
		byte[] raw = new byte[256];
		cipher.doFinal(message.getBytes(), 0, message.getBytes().length, raw, 0);
		byte[] base64EncryptedMessageBytes = Base64.encode(raw);
		String encryptedMessage = new String(base64EncryptedMessageBytes, charsetName);
		System.out.println(encryptedMessage);
		
		// 解密
		byte[] inbytes = Base64.decode(encryptedMessage.getBytes(charsetName));
		//pfx格式的数字证书是包含有私钥
		KeyStore ks = file2KeyStore("E:\\项目\\5caprod证书\\online\\itrus\\cafiles\\yjf-cert-2048.pfx", "123456");
		String certAlias = getCertificateAlias(ks, publicCert);
		PrivateKey key = getPrivateKey(ks, certAlias, "123456");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] output = cipher.doFinal(inbytes);
		String outputStr = new String(output, charsetName);
		System.out.println(outputStr);
		
	}
	
	public static KeyStore file2KeyStore(String filename, String password) throws KeyStoreException,
																			NoSuchAlgorithmException,
																			CertificateException, IOException {
		KeyStore ks = KeyStore.getInstance(PKCS12);
		FileInputStream in = new FileInputStream(filename);
		try {
			ks.load(in, password.toCharArray());
			return ks;
		} finally {
			in.close();
		}
	}
	
	public static String getCertificateAlias(KeyStore keyStore, Certificate cert) throws KeyStoreException {
		return keyStore.getCertificateAlias(cert);
	}
	
	public static PrivateKey getPrivateKey(KeyStore keyStore, String alias, String password)
																							throws UnrecoverableKeyException,
																							KeyStoreException,
																							NoSuchAlgorithmException {
		return (PrivateKey) keyStore.getKey(alias, password.toCharArray());
	}
}

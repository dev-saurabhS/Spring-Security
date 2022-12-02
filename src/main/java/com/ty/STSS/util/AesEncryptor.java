//package com.ty.STSS.util;
//
//import java.security.GeneralSecurityException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.spec.SecretKeySpec;
//import javax.persistence.AttributeConverter;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.SerializationUtils;
//
//import lombok.SneakyThrows;
//
//public class AesEncryptor implements AttributeConverter<Object, String>{
//	
//	@Value("${aes.encryption.key}")
//	private  String encryptionkey;
//	private final String encryptionCipher="AES";
//	
//	private Key key;
//	private Cipher cipher;
//	
//	
//	private Key getKey() {
//		if(key==null) {
//			key=new SecretKeySpec(encryptionkey.getBytes(),encryptionCipher);
//		}
//		return key;
//	}
//
//	
//	private Cipher getCipher() throws GeneralSecurityException{
//		if(cipher==null) {
//			cipher= Cipher.getInstance(encryptionCipher);
//		}
//		return cipher;
//	}
//
//	private void initCipher(int encryptMode) throws GeneralSecurityException {
//		getCipher().init(encryptMode,getKey());
//	}
//
//	
//	@SneakyThrows
//	@Override
//	public String convertToDatabaseColumn(Object attribute)  {
//		if(attribute==null)
//			return null;
//		try {
//			initCipher(Cipher.ENCRYPT_MODE);
//		} catch (GeneralSecurityException e) {
//			e.printStackTrace();
//		}
//		byte[] bytes=SerializationUtils.serialize(attribute);
//		try {
//			return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
//		} catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
//				| NoSuchPaddingException e) {
//			e.printStackTrace();
//		}
//		return encryptionCipher;
//		
//	}
//	
//	@SneakyThrows
//	@Override
//	public Object convertToEntityAttribute(String dbData) {
//		if(dbData == null)
//		return null;
//		try {
//			initCipher(Cipher.DECRYPT_MODE);
//		} catch (GeneralSecurityException e) {
//			e.printStackTrace();
//		}
//		byte[] bytes=null;
//		try {
//			bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
//		} catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
//				| NoSuchPaddingException e) {
//			e.printStackTrace();
//		}
//		return SerializationUtils.deserialize(bytes);
//	}
//
//}

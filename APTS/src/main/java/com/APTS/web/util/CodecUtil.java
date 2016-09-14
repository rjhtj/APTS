package com.APTS.web.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class CodecUtil {
	private static final String md5SecrectKey="cdEaaklDF36gXGxDPql40Y5b";
	/**
	 * 功能描述： 进行md5签名并返回16进制字符串
	 *
	 * @param text
	 * @return
	 * @author chenheng 2016 Jan 6, 2016 2:25:00 PM
	 */
	public static String md5Hex(String text) {
		return DigestUtils.md5Hex(text + md5SecrectKey);
	}

	public static final String AES_ALGORITHM = "AES";
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	/**
	 *
	 * 功能描述：初始化密钥
	 *
	 * @return
	 * @throws Exception
	 * @author chenheng 2016 Jan 6, 2016 3:08:22 PM
	 * @throws NoSuchAlgorithmException
	 */
	public static String initkey() throws NoSuchAlgorithmException {
		KeyGenerator kg = KeyGenerator.getInstance(AES_ALGORITHM); // 实例化密钥生成器
		kg.init(128); // 初始化密钥生成器:AES要求密钥长度为128,192,256位
		SecretKey secretKey = kg.generateKey(); // 生成密钥
		return Base64.encodeBase64String(secretKey.getEncoded()); // 获取二进制密钥编码形式
	}

	/**
	 *
	 * 功能描述：字节密钥转换
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 * @author chenheng 2016 Jan 6, 2016 3:10:16 PM
	 */
	public static Key toKey(byte[] key) {
		return new SecretKeySpec(key, AES_ALGORITHM);
	}

	/**
	 *
	 * 功能描述：加密数据
	 *
	 * @param data
	 *            待加密数据
	 * @param key
	 *            字符密钥
	 * @return
	 * @throws Exception
	 * @author chenheng 2016 Jan 6, 2016 3:11:17 PM
	 * @throws Exception
	 */
	public static String encrypt(String data, String key) throws Exception {
		Key k = toKey(Base64.decodeBase64(key));
		// 使用PKCS7Padding填充方式,这里就得这么写了(即调用BouncyCastle组件实现)
		// Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM); // 实例化Cipher对象，它用于完成实际的加密操作
		cipher.init(Cipher.ENCRYPT_MODE, k); // 初始化Cipher对象，设置为加密模式
		return Base64.encodeBase64String(cipher.doFinal(data.getBytes())); // 执行加密操作。加密后的结果通常都会用Base64编码进行传输
	}

	/**
	 *
	 * 功能描述：解密数据
	 *
	 * @param data
	 *            已加密数据
	 * @param key
	 *            字符密钥
	 * @return
	 * @throws Exception
	 * @author chenheng 2016 Jan 6, 2016 3:13:19 PM
	 */
	public static String decrypt(String data, String key) throws Exception {
		Key k = toKey(Base64.decodeBase64(key));
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k); // 初始化Cipher对象，设置为解密模式
		return new String(cipher.doFinal(Base64.decodeBase64(data))); // 执行解密操作
	}
}

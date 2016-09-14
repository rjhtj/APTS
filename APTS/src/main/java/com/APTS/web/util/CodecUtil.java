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
	 * ���������� ����md5ǩ��������16�����ַ���
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
	 * ������������ʼ����Կ
	 *
	 * @return
	 * @throws Exception
	 * @author chenheng 2016 Jan 6, 2016 3:08:22 PM
	 * @throws NoSuchAlgorithmException
	 */
	public static String initkey() throws NoSuchAlgorithmException {
		KeyGenerator kg = KeyGenerator.getInstance(AES_ALGORITHM); // ʵ������Կ������
		kg.init(128); // ��ʼ����Կ������:AESҪ����Կ����Ϊ128,192,256λ
		SecretKey secretKey = kg.generateKey(); // ������Կ
		return Base64.encodeBase64String(secretKey.getEncoded()); // ��ȡ��������Կ������ʽ
	}

	/**
	 *
	 * �����������ֽ���Կת��
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
	 * ������������������
	 *
	 * @param data
	 *            ����������
	 * @param key
	 *            �ַ���Կ
	 * @return
	 * @throws Exception
	 * @author chenheng 2016 Jan 6, 2016 3:11:17 PM
	 * @throws Exception
	 */
	public static String encrypt(String data, String key) throws Exception {
		Key k = toKey(Base64.decodeBase64(key));
		// ʹ��PKCS7Padding��䷽ʽ,����͵���ôд��(������BouncyCastle���ʵ��)
		// Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM); // ʵ����Cipher�������������ʵ�ʵļ��ܲ���
		cipher.init(Cipher.ENCRYPT_MODE, k); // ��ʼ��Cipher��������Ϊ����ģʽ
		return Base64.encodeBase64String(cipher.doFinal(data.getBytes())); // ִ�м��ܲ��������ܺ�Ľ��ͨ��������Base64������д���
	}

	/**
	 *
	 * ������������������
	 *
	 * @param data
	 *            �Ѽ�������
	 * @param key
	 *            �ַ���Կ
	 * @return
	 * @throws Exception
	 * @author chenheng 2016 Jan 6, 2016 3:13:19 PM
	 */
	public static String decrypt(String data, String key) throws Exception {
		Key k = toKey(Base64.decodeBase64(key));
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k); // ��ʼ��Cipher��������Ϊ����ģʽ
		return new String(cipher.doFinal(Base64.decodeBase64(data))); // ִ�н��ܲ���
	}
}

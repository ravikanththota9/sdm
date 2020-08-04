package com.sdm.utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class Encryption {
  private static final Logger logger = LoggerFactory.getLogger(Encryption.class);

  //public static final String encPropFile = "secret-file";

  private static final com.sdm.utils.Encryption instance = new com.sdm.utils.Encryption();
  private final Cipher cipher;
  private final Key key;

  public static com.sdm.utils.Encryption getInstance() {
    return instance;
  }

  /**
   * default constructor.
   */
  public Encryption() {
    try {
      this.cipher = Cipher.getInstance("AES");
      String[] salt = new String[2];
      BufferedReader br = null;
     /* try {
        File file = new File(getClass().getResource("key.txt").getFile());
        br = new BufferedReader(new FileReader(file));
        String sCurrentLine = "";
        while ((sCurrentLine = br.readLine()) != null) {
          salt = sCurrentLine.split("=");
        }
        br.close();
      } catch (IOException e) {
        logger.error(e.getMessage(), e);
      } finally {
        if (br != null) {
          try {
            br.close();
          } catch (IOException ignore) {
            logger.warn(ignore.getMessage(), ignore);
          }
        }
      }*/
      salt[0] = "salt";
      salt[1] = "D3c1s10nsdmD3c1s";
      byte[] raw = salt[1].getBytes();
      this.key = new SecretKeySpec(raw, "AES");
    } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
      logger.error("Unable to perform Encryption, Error message [" + e.getMessage() + "]", e);
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  /**
   * generatePasswordHash.
   *
   * @param password password.
   * @return hash String.
   * @throws NoSuchAlgorithmException NoSuchAlgorithmException
   * @throws InvalidKeySpecException  InvalidKeySpecException
   */
  public String generatePasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    String passwordHash = generateStrongPasswordHash(password);
    return passwordHash;
  }

  /**
   * generatePasswordHash.
   *
   * @param password password.
   * @return hash String.
   * @throws NoSuchAlgorithmException NoSuchAlgorithmException
   * @throws InvalidKeySpecException  InvalidKeySpecException
   */
  private String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    int iterations = 1000;
    char[] chars = password.toCharArray();
    byte[] salt = getSalt().getBytes();

    PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    byte[] hash = skf.generateSecret(spec).getEncoded();
    return iterations + ":" + toHex(salt) + ":" + toHex(hash);
  }

  /**
   * Returns salt code.
   *
   * @return salt.
   * @throws NoSuchAlgorithmException NoSuchAlgorithmException
   */
  private String getSalt() throws NoSuchAlgorithmException {
    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
    byte[] salt = new byte[16];
    sr.nextBytes(salt);
    return salt.toString();
  }

  /**
   * Returns hexadecimal string.
   *
   * @param array byte array.
   * @return hexadecimal string.
   * @throws NoSuchAlgorithmException NoSuchAlgorithmException
   */
  private String toHex(byte[] array) throws NoSuchAlgorithmException {
    BigInteger bi = new BigInteger(1, array);
    String hex = bi.toString(16);
    int paddingLength = (array.length * 2) - hex.length();
    if (paddingLength > 0) {
      return String.format("%0" + paddingLength + "d", 0) + hex;
    } else {
      return hex;
    }
  }

  /**
   * Validates given password.
   *
   * @param originalPassword password.
   * @param storedPassword   password.
   * @return true or false.
   * @throws NoSuchAlgorithmException NoSuchAlgorithmException
   * @throws InvalidKeySpecException  InvalidKeySpecException
   */
  public boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
    logger.info("Validating the password");
    String[] parts = storedPassword.split(":");
    int iterations = Integer.parseInt(parts[0]);
    byte[] salt = fromHex(parts[1]);
    byte[] hash = fromHex(parts[2]);

    PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    byte[] testHash = skf.generateSecret(spec).getEncoded();

    int diff = hash.length ^ testHash.length;
    for (int i = 0; i < hash.length && i < testHash.length; i++) {
      diff |= hash[i] ^ testHash[i];
    }
    return diff == 0;
  }

  /**
   * Hex String ot byte array.
   *
   * @param hex hex string.
   * @return byte array.
   * @throws NoSuchAlgorithmException NoSuchAlgorithmException
   */
  private byte[] fromHex(String hex) throws NoSuchAlgorithmException {
    byte[] bytes = new byte[hex.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
    }
    return bytes;
  }

  /**
   * Encrypts given string.
   *
   * @param data input String
   * @return encrypted string.
   * @throws Exception Exception
   */
  public String encrypt(String data) throws Exception {
    String result = "";
    try {
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] utf8 = data.getBytes("UTF8");
      byte[] encryptedData = cipher.doFinal(utf8);
      result = new Base64().encodeToString(encryptedData);
    } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
      logger.error("Unable to perform decrypt for given data:{}, Error:{} ", data, e);
      throw e;
    }
    return result;
  }

  /**
   * Decrypts encrypted string to decrypted String.
   * @param data encrypted string.
   * @return decrypted string
   * @throws Exception Exception
   */
  public String decrypt(String data) throws Exception {
    String result = "";
    try {
      cipher.init(Cipher.DECRYPT_MODE, key);
      byte[] decodedData = new Base64().decode(data);
      byte[] utf8 = cipher.doFinal(decodedData);
      result = new String(utf8, "UTF8");
    } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
      logger.error("Unable to perform decrypt for given data:{}, Error:{} ", data, e);
      throw e;
    }
    return result;
  }

  public static void main(String[] args) throws Exception {
    Encryption en = Encryption.getInstance();
    String password = "highlyconfidentialstringhere";
    String passwordHash = en.generatePasswordHash(password);
    System.out.println(passwordHash);
    String enc = en.encrypt(password);
    System.out.println(enc);
    String dec = en.decrypt(enc);
    System.out.println(dec);
  }
}

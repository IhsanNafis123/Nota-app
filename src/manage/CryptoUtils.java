package manage;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

public class CryptoUtils {
    private static final String ALGO = "AES";
    private static final byte[] keyValue = "1234567890123456".getBytes(); // 16-byte key untuk AES-128

    public static CipherOutputStream encryptStream(OutputStream out) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new CipherOutputStream(out, cipher);
    }

    public static CipherInputStream decryptStream(InputStream in) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new CipherInputStream(in, cipher);
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = cipher.doFinal(decodedValue);
        return new String(decValue);
    }
}

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TokenBuilder {

    public static String algorithm = "AES/CBC/PKCS5Padding";
    private final String key = "34583567890394856789012345678901";
    private final String initializationVector = key.substring(0, 16); 

    public String encrypt(String userId) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec initializationVectorParam = new IvParameterSpec(initializationVector.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, initializationVectorParam);
        byte[] encryption = cipher.doFinal(userId.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryption);
    }

    public String decrypt(String token) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec initializationVectorParam = new IvParameterSpec(initializationVector.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKey, initializationVectorParam);
        byte[] decodedBytes = Base64.getDecoder().decode(token);
        byte[] decryption = cipher.doFinal(decodedBytes);
        return new String(decryption, "UTF-8");
    }

}
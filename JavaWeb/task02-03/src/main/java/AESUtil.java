import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

public class AESUtil {
/**
 *
 * @param str 加密前数据
 * @param key 对称密钥，必须为16位
 * @return 返回加密后数据
 */
public static String encrypt(String str,String key){
    AES aes = SecureUtil.aes(key.getBytes());
    return aes.encryptBase64(str);
}
    /**
     *
     * @param str 加密后的数据
     * @param key 盐，必须为16位
     * @return 返回解密后数据
     */
    public static String decrypt (String str,String key){
        AES aes = SecureUtil.aes(key.getBytes());
        return aes.decryptStr(str);
    }
}
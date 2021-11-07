package com.yy.example.google;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

public class GoogleAuthenticatorDemo2 {

    public static final int SECRET_SIZE = 10;

    public static final String SEED = "g8GjEvTbW5oVSV7avLBdwIHqGlUYNzKFI7izOF8GwLDVKs2m0QN7vxRs2im5MDaNCWGmcD2rvcZx";

    public static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

    int window_size = 3; // default 3 - max 17 (from google docs)最多可偏移的时间

    public void setWindowSize(int s) {
        if (s >= 1 && s <= 17){
            window_size = s;
        }
    }

    /**
     * 验证身份验证码是否正确
     *
     * @param codes
     *            输入的身份验证码
     * @param savedSecret
     *            密钥
     * @return
     */
    public static Boolean authcode(String codes, String savedSecret) {
        long t = System.currentTimeMillis();
        GoogleAuthenticatorDemo2 ga = new GoogleAuthenticatorDemo2();
        // should give 5 * 30 seconds of grace...
        ga.setWindowSize(3);
        boolean r = ga.check_code(savedSecret, codes, t);
        return r;
    }

    /**
     * 获取密钥
     *
     * @param user
     *            用户
     * @param host
     *            域
     * @return 密钥
     */
    public static String genSecret(String user, String host) {
        String secret = GoogleAuthenticatorDemo2.generateSecretKey();
        GoogleAuthenticatorDemo2.getQRBarcodeURL(user, host, secret);
        return secret;
    }

    private static String generateSecretKey() {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance(RANDOM_NUMBER_ALGORITHM);
            sr.setSeed(Base64.decodeBase64(SEED));
            byte[] buffer = sr.generateSeed(SECRET_SIZE);
            Base32 codec = new Base32();
            byte[] bEncodedKey = codec.encode(buffer);
            String encodedKey = new String(bEncodedKey);
            return encodedKey;
        } catch (NoSuchAlgorithmException e) {
            // should never occur... configuration error
        }
        return null;
    }

    /**
     * 获取二维码图片URL
     *
     * @param user
     *            用户
     * @param host
     *            域
     * @param secret
     *            密钥
     * @return 二维码URL
     */
    public static String getQRBarcodeURL(String user, String host, String secret) {
        String format = "https://www.google.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s";
        return String.format(format, user, host, secret);
    }

    private boolean check_code(String secret, String code, long timeMsec) {
        Base32 codec = new Base32();
        byte[] decodedKey = codec.decode(secret);
        long time = (timeMsec / 1000L) / 30L;
        for (int i = -window_size; i <= window_size; ++i) {
            String totp = getTOTP(new String(decodedKey), time + i);
            if (code.equals(totp)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据密钥获取验证码
     * 返回字符串是因为验证码有可能以 0 开头
     * @param secretKey 密钥
     * @param time      第几个 30 秒 System.currentTimeMillis() / 1000 / 30
     */
    public static String getTOTP(String secretKey, long time) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey.toUpperCase());
        String hexKey = Hex.encodeHexString(bytes);
        String hexTime = Long.toHexString(time);
        return TOTP.generateTOTP(hexKey, hexTime, "6");
    }

    public static void main(String[] args) {
        /*
         * 注意：先运行前两步，获取密钥和二维码url。 然后只运行第三步，填写需要验证的验证码，和第一步生成的密钥
         */
//        String user = "skyler";
//        String host = "skyler";
//        // 第一步：获取密钥,生成的密钥要添加到手机的GoogleAuthenticator app中，由此来获取验证码
//        String secret = genSecret(user, host);
//        System.out.println("secret:" + secret);
//        // 第二步：根据密钥获取二维码图片url（可忽略）
//        String url = getQRBarcodeURL(user, host, secret);
//        System.out.println("url:" + url);
        // 第三步：验证（第一个参数是需要验证的验证码，第二个参数是第一步生成的secret运行）
        boolean result = authcode("756256", "GSMHQ3CHISYAQ3CY");
        System.out.println("当前时间：" + new Date() + "result:" + result);


        System.out.println(Long.valueOf("0111"));
    }
}

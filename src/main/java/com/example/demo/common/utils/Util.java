package com.example.demo.common.utils;

import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author:chengbg
 * @date:2018/6/5
 */
public class Util {

    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String salt = DatatypeConverter.printHexBinary(bytes);
        return salt;
    }

}

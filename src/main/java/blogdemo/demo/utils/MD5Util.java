package blogdemo.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author admin
 * @date 2019/9/25 23:08
 */
public class MD5Util {

    /**
     * 为密码加密
     *
     */
    public static String code(String password){
        try{
            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteDigest=md.digest();
            int i;
            StringBuffer buf=new StringBuffer();

            for(int offset=0;offset<byteDigest.length;offset++) {
                i=byteDigest[offset];
                if(i<0)
                    i+=256;
                if(i<16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));

            }

            //32位加密
            return buf.toString();

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String [] args){
        //System.err.println(code("123456"));
    }
}

package cn.icexmoon.webdemo;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : web-demo
 * @Package : cn.icexmoon.webdemo
 * @ClassName : .java
 * @createTime : 2023/9/9 10:47
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class UrlEncodeTests {
    @Test
    public void testUrlEncode() throws UnsupportedEncodingException {
        String msg = "魔芋红茶";
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        // 以二进制的方式打印字节数组
        for (byte b : bytes) {
            System.out.print(Integer.toBinaryString(b & 0xFF)); //打印二进制字符串
            System.out.print(" ");
        }
        System.out.println();
        String encode = URLEncoder.encode(msg, StandardCharsets.UTF_8.name());
        System.out.println(encode);
    }

    @Test
    public void test88591() {
        String msg = "魔芋红茶";
        // 获取 UTF-8 编码后的字节数组
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        // 将字节数组以 ISO-8859-1 的方式解码
        String decode = new String(bytes, StandardCharsets.ISO_8859_1);
        System.out.println(decode);
    }
}

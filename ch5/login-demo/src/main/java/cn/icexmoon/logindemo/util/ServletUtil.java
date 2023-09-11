package cn.icexmoon.logindemo.util;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.util
 * @ClassName : .java
 * @createTime : 2023/9/10 21:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class ServletUtil {
    /**
     * 处理 Tomcat7 以下（包含）的入参乱码问题
     * @param request 请求对象
     * @return 正确的 UTF-8 请求参数
     */
    public static Map<String, List<String>> getUTF8Params(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, List<String>> utf8Params = new HashMap<>();
        parameterMap.forEach((pName,pVals)->{
            List<String> utf8PVals = new ArrayList<>();
            for(String pVal : pVals){
                utf8PVals.add(dealMessyCode(pVal));
            }
            utf8Params.put(pName, utf8PVals);
        });
        return utf8Params;
    }

    /**
     * 获取只包含第一个值的 UTF-8 编码的请求参数
     * @param request 请求对象
     * @return 请求参数（只包含第一个值）
     */
    public static Map<String, String> getSimpleUtf8Params(HttpServletRequest request){
        Map<String, List<String>> utf8Params = getUTF8Params(request);
        Map<String, String> simpleUtf8Params = new HashMap<>();
        utf8Params.forEach((pName,pVals)->{
            if (pVals.isEmpty()){
                simpleUtf8Params.put(pName, null);
                return;
            }
            simpleUtf8Params.put(pName, pVals.get(0));
        });
        return simpleUtf8Params;
    }

    /**
     * 处理传参乱码
     * @param messyCode 因为用 ISO-8859-1 解码导致的乱码
     * @return 正确的 UTF-8 字符串
     */
    private static String dealMessyCode(String messyCode){
        byte[] bytes = messyCode.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}

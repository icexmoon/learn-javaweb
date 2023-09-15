package cn.icexmoon.logindemo.controller.user;

import cn.icexmoon.logindemo.service.UserService;
import cn.icexmoon.logindemo.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.controller.user
 * @ClassName : .java
 * @createTime : 2023/9/13 12:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/user/exist")
public class ExistController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        do{
            String line = reader.readLine();
            if (line == null){
                break;
            }
            sb.append(line);
        }
        while (true);
        String content = sb.toString();
        System.out.println(content);
        JSONObject jsonObject = JSON.parseObject(content);
        String username = (String) jsonObject.get("username");
        boolean exists = userService.checkUsernameExists(username);
        JSONObject resultJO = new JSONObject();
        if (exists){
            resultJO.put("exist", true);
        }
        else{
            resultJO.put("exist", false);
        }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(resultJO.toJSONString());
    }
}

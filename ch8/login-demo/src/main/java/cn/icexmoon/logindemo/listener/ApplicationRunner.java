package cn.icexmoon.logindemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.controller.listener
 * @ClassName : .java
 * @createTime : 2023/9/12 22:28
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebListener
public class ApplicationRunner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 这里执行一些应用的初始化工作
        System.out.println("Web Application is already run...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 这里执行应用退出时的清理工作
    }
}

package cn.icexmoon.logindemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.dto
 * @ClassName : .java
 * @createTime : 2023/9/16 20:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 分页查询结果
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    @Data
    @AllArgsConstructor
    public static class ResultPage{
        /**
         * 总数据条数
         */
        private Integer total;
        /**
         * 当前页码
         */
        private Integer currentPage;
        /**
         * 每页数据条数
         */
        private Integer size;
    }
    private List<T> list;
    private ResultPage resultPage;
}

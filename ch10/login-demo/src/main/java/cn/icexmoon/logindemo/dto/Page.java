package cn.icexmoon.logindemo.dto;

import cn.icexmoon.logindemo.entity.Limit;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.dto
 * @ClassName : .java
 * @createTime : 2023/9/16 19:50
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@AllArgsConstructor
public class Page {
    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 每页数据条数
     */
    private Integer size;

    public Limit getLimit(){
        if (currentPage == null || currentPage <= 0
                || size == null || size <= 0) {
            return null;
        }
        Integer begin = (currentPage - 1) * size;
        return new Limit(begin,size);
    }

//    public Integer getLimitBegin() {
//        if (currentPage == null || currentPage <= 0
//                || size == null || size <= 0) {
//            return null;
//        }
//        return (currentPage - 1) * size;
//    }
//
//    public Integer getLimitSize(){
//        if (size == null || size <= 0) {
//            return null;
//        }
//        return size;
//    }
}

package com.test.sun.dao;

import com.test.sun.domain.UserBean;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface User2Dao {
    @Select("SELECT USER_ID,USERNAME,REALNAME FROM SYS_USER WHERE ROWNUM < 10")
    @ResultMap("UserMap")
    List<UserBean> getTestList();
}

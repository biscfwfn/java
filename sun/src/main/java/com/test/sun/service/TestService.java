package com.test.sun.service;

import com.test.sun.dao.User2Dao;
import com.test.sun.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static Logger log = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User2Dao user2Dao;

    public Object GetTestList(){
        return userMapper.getTestList();
    }

    public Object GetTestDao(){
        return user2Dao.getTestList();
    }
}

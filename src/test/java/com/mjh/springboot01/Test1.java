package com.mjh.springboot01;

import com.demo.bean.User;
import com.demo.dao.UserDao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

/**
 * Created by majianghua on 2019/5/23.
 */
@RunWith(SpringRunner.class)
public class Test1 {


    @Test
    public void test(){
        User user = new User();
        user.setId((long) 29);
        user.setNickName("nickname");
        int update = 0;
        System.out.println(update);
    }
}
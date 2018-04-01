package com.shp.serviceImpl;

import com.shp.Application;
import com.shp.model.User;
import com.shp.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Shape on 2018/4/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserByName() throws Exception {

    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUserName("孙海鹏");
        user.setUserPassword("123456");
        user.setUserEmail("1328445041@qq.com");
        user.setUserBirthday(new Date(2018,3,30));
        user.setUserQq("13245451514");
        user.setUserPhone("15145441542");
        int Id = userService.insertUser(user);
        Assert.assertNotNull(Id);
        System.out.println("插入的Id:" + Id);
    }

}
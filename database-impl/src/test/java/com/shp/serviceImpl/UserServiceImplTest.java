package com.shp.serviceImpl;

import com.shp.Application;
import com.shp.model.User;
import com.shp.query.UserQuery;
import com.shp.result.BaseResult;
import com.shp.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
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
    public void queryUser() throws Exception {
        UserQuery query = new UserQuery();
        query.setUserName("孙海鹏");
        BaseResult<User> userBaseResult = userService.getUserByQuery(query);
        System.out.println(userBaseResult.getData());
    }

    @Test
    public void insertUser() throws Exception {
        Date date = new Date("2018/03/02");
        User user = new User();
        user.setUserName("孙海鹏23");
        user.setUserPassword("12345621");
        user.setUserEmail("13284450412@qq.com");
        user.setUserBirthday(date);
        user.setUserQq("13245451515");
        user.setUserPhone("15145441512");
        BaseResult result = userService.insertUser(user);
        System.out.println(result.getResultCode());
    }




}
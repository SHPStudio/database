package com.shp.serviceImpl.user;

import com.shp.mapper.UserMapper;
import com.shp.model.User;
import com.shp.model.UserExample;
import com.shp.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shape on 2018/4/2.
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(name);
        List<User> user = userMapper.selectByExample(example);
        return user.get(0);
    }

    @Override
    public Integer insertUser(User user) {
        int n = userMapper.insert(user);
        if (n > 0) {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserNameEqualTo(user.getUserName());
            criteria.andUserPasswordEqualTo(user.getUserPassword());
            List<User> users = userMapper.selectByExample(example);
            return users.get(0).getId();
        }
        return -1;
    }
}

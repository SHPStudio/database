package com.shp.service;

import com.shp.model.User;

/**
 * Created by Shape on 2018/4/1.
 */
public interface UserService {
    User getUserByName(String name);

    Integer insertUser(User user);
}

package com.shp.serviceImpl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shp.Contant.ResultEnum;
import com.shp.mapper.UserMapper;
import com.shp.model.User;
import com.shp.model.UserExample;
import com.shp.query.UserQuery;
import com.shp.result.BaseResult;
import com.shp.result.PageResult;
import com.shp.service.UserService;
import com.shp.util.ResultFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created by Shape on 2018/4/2.
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public BaseResult<User> getUserByQuery(UserQuery query) {
        if (Objects.isNull(query)) {
            return ResultFactory.getErrorResult(ResultEnum.QUERY_NULL);
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(query.getUserName())) {
            criteria.andUserNameEqualTo(query.getUserName());
        }
        if (Objects.nonNull(query.getUserBirthday())) {
            criteria.andUserBirthdayEqualTo(query.getUserBirthday());
        }
        if (Objects.nonNull(query.getUserEmail())) {
            criteria.andUserEmailEqualTo(query.getUserEmail());
        }
        if (Objects.nonNull(query.getUserPhone())) {
            criteria.andUserPhoneEqualTo(query.getUserPhone());
        }
        if (Objects.nonNull(query.getUserPassword())) {
            criteria.andUserPasswordEqualTo(query.getUserPassword());
        }
        List<User> userList = userMapper.selectByExample(example);

        return new BaseResult<>(0, CollectionUtils.isEmpty(userList) ? null : userList.get(0));
    }

    @Override
    public BaseResult<User> queryUserById(Integer id) {
        if (Objects.isNull(id)) {
            return ResultFactory.getErrorResult(ResultEnum.ID_NULL);
        }
        User user = userMapper.selectByPrimaryKey(id);
        return new BaseResult<User>(0, user);
    }

    @Override
    public BaseResult<Integer> insertUser(User user) {
        if (Objects.isNull(user)) {
            return ResultFactory.getErrorResult(ResultEnum.QUERY_NULL);
        }
        if (StringUtils.isEmpty(user.getUserPassword()) || StringUtils.isEmpty(user.getUserName())) {
            return ResultFactory.getErrorResult(ResultEnum.NAME_PASSWORD_NULL);
        }
        int n = userMapper.insertSelective(user);
        BaseResult result = n > 0 ? BaseResult.SUCCESS : ResultFactory.getErrorResult(ResultEnum.SYSTEM_ERROR);
        return result;
    }

    @Override
    public PageResult<User> queryUserByPage(UserQuery query) {
        if (Objects.isNull(query)) {
            throw new RuntimeException(ResultEnum.QUERY_NULL.getMessage());
        }
        PageResult<User> result = new PageResult<>();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(query.getUserName())) {
            criteria.andUserNameEqualTo(query.getUserName());
        }
        if (Objects.nonNull(query.getUserBirthday())) {
            criteria.andUserBirthdayEqualTo(query.getUserBirthday());
        }
        if (Objects.nonNull(query.getUserEmail())) {
            criteria.andUserEmailEqualTo(query.getUserEmail());
        }
        if (Objects.nonNull(query.getUserPhone())) {
            criteria.andUserPhoneEqualTo(query.getUserPhone());
        }
        PageHelper.startPage(query.getPageIndex(), query.getPageSize());
        List<User> users = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        long total = pageInfo.getTotal(); //获取总记录数
        result.setPageIndex(query.getPageIndex());
        result.setPageSize(query.getPageSize());
        result.setTotal(total);
        result.setContent(pageInfo.getList());
        return result;
    }

    @Override
    public BaseResult<Integer> deleteUser(Integer id) {
        if (Objects.isNull(id)) {
            return ResultFactory.getErrorResult(ResultEnum.ID_NULL);
        }
        int n = userMapper.deleteByPrimaryKey(id);
        BaseResult result = n > 0 ? BaseResult.SUCCESS : ResultFactory.getErrorResult(ResultEnum.SYSTEM_ERROR);
        return result;
    }

    @Override
    public BaseResult updateUser(User user) {
        if (Objects.isNull(user)) {
            return ResultFactory.getErrorResult(ResultEnum.UPDATE_PARAM_NULL);
        }
        int n = userMapper.updateByPrimaryKeySelective(user);
        BaseResult result = n > 0 ? BaseResult.SUCCESS : ResultFactory.getErrorResult(ResultEnum.SYSTEM_ERROR);
        return result;
    }
}

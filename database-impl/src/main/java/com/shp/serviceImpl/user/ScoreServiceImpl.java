package com.shp.serviceImpl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shp.Contant.ResultEnum;
import com.shp.mapper.ScoreMapper;
import com.shp.mapper.UserMapper;
import com.shp.model.Score;
import com.shp.model.ScoreExample;
import com.shp.model.User;
import com.shp.model.UserExample;
import com.shp.query.ScoreQuery;
import com.shp.result.BaseResult;
import com.shp.result.PageResult;
import com.shp.service.ScoreService;
import com.shp.util.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 18:00
 * To change this template use File | Settings | File Templates.
 */
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResult insertScore(Score score) {
        int n = scoreMapper.insertSelective(score);
        BaseResult result = n > 0 ? BaseResult.SUCCESS : ResultFactory.getErrorResult(ResultEnum.SYSTEM_ERROR);
        return result;
    }

    @Override
    public PageResult<Score> queryScoreByPage(ScoreQuery query) {
        PageResult<Score> result = new PageResult();
        result.setPageSize(query.getPageSize());
        result.setPageIndex(query.getPageIndex());
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        User user = null;
        if (Objects.nonNull(query.getUserName())) {
            criteria.andUserNameEqualTo(query.getUserName());
        }
        if (Objects.nonNull(query.getUserPhone())) {
            criteria.andUserPhoneEqualTo(query.getUserPhone());
        }
        List<User> users = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(users)) {
            user = users.get(0);
        }
        ScoreExample example2 = new ScoreExample();
        ScoreExample.Criteria criteria2 = example2.createCriteria();
        if (Objects.nonNull(user)) {
            criteria2.andUserIdEqualTo(user.getId());
        }
        PageHelper.startPage(result.getPageIndex(),result.getPageSize());
        List<Score> scoreList = scoreMapper.selectByExample(example2);
        PageInfo<Score> scorePageInfo = new PageInfo<>(scoreList);
        result.setTotal(scorePageInfo.getTotal());
        result.setContent(scorePageInfo.getList());
        return result;
    }

    @Override
    public BaseResult<Score> queryScoreById(Integer id) {
        Score score = scoreMapper.selectByPrimaryKey(id);
        return new BaseResult<Score>(0, score);
    }

    @Override
    public BaseResult updateScore(Score score) {
        int n = scoreMapper.updateByPrimaryKey(score);
        BaseResult result = n > 0 ? BaseResult.SUCCESS : ResultFactory.getErrorResult(ResultEnum.SYSTEM_ERROR);
        return result;
    }

    @Override
    public BaseResult deleteScore(Integer id) {
        int n = scoreMapper.deleteByPrimaryKey(id);
        BaseResult result = n > 0 ? BaseResult.SUCCESS : ResultFactory.getErrorResult(ResultEnum.SYSTEM_ERROR);
        return result;
    }
}

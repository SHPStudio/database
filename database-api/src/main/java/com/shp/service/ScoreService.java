package com.shp.service;

import com.shp.model.Score;
import com.shp.query.ScoreQuery;
import com.shp.result.BaseResult;
import com.shp.result.PageResult;

/**
 * Created by IntelliJ IDEA.
 * User: sunhaipeng
 * Date: 2018/4/4
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 */
public interface ScoreService {

    BaseResult insertScore(Score score);

    PageResult<Score> queryScoreByPage(ScoreQuery query);

    BaseResult<Score> queryScoreById(Integer id);

    BaseResult updateScore(Score score);

    BaseResult deleteScore(Integer id);
}

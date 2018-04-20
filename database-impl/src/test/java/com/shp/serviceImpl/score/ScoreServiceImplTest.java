package com.shp.serviceImpl.score;

import com.shp.Application;
import com.shp.mapper.ScoreMapper;
import com.shp.model.Score;
import com.shp.query.ScoreQuery;
import com.shp.result.PageResult;
import com.shp.service.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Shape on 2018/4/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ScoreServiceImplTest {
    @Autowired
    private ScoreService scoreService;

    @Test
    public void insertScore() throws Exception {

    }

    @Test
    public void queryScoreByPage() throws Exception {
        ScoreQuery query = new ScoreQuery();
        PageResult<Score> scorePageResult = scoreService.queryScoreByPage(query);
    }

    @Test
    public void queryScoreById() throws Exception {

    }

    @Test
    public void updateScore() throws Exception {

    }

    @Test
    public void deleteScore() throws Exception {

    }

}
package com.test.springboot.mapper;

import com.test.first.Application;
import com.test.first.domain.City;
import com.test.first.mapper.firstdata.CityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by liuning on 2017/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void testQuery(){
        List<City> citys = cityMapper.getCitys();
        System.out.println(citys.toString());
    }

    @Test
    public void testGetOne(){
        City city = cityMapper.getOneCity((long) 1);
        System.out.println(city.toString());

    }
}

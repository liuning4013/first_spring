package com.test.first.service.serviceimpl;


import com.test.first.domain.City;
import com.test.first.mapper.firstdata.CityMapper;
import com.test.first.service.CityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuning on 2017/9/18.
 */
@CacheConfig(cacheNames = "citys")
@Service
public class CityServiceImpl implements CityService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getCitys() {
        List<City> list = new ArrayList();
        list = cityMapper.getCitys();
        //将数据放入缓存
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        LOGGER.info("将查询到的数据放入缓存！");
        for(City setcity : list) {
            operations.set("city_"+setcity.getId().toString(),setcity);
        }
        return list;
    }

    /*
    * @Cacheable先走缓存，没有时再走数据库
    *
    * */
    @Cacheable(key = "'city_'+#id")
    @Override
    public City getOneCity(Long id) {
        City city = new City();
        /*ValueOperations<String, City> operations = redisTemplate.opsForValue();
        boolean haskey = redisTemplate.hasKey(id.toString());
        if(haskey){
            city = operations.get(id.toString());
            LOGGER.info("从缓存中获取了城市信息！");
            return city;
        }*/
        System.out.println("没走缓存！");
        city =  cityMapper.getOneCity(id);
        return city;
    }

    /*
    * @cacheput每次都会真实的调用方法，常用于修改和新增
    * */
    @CachePut(key = "'city_'+ #city.getId()")
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void edit(City city) {
        cityMapper.edit(city);
        //int a = -1/0;//测试事物
    }

   /* @CacheEvict(key = "'city'")*/
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void save(City city) {
        cityMapper.save(city);
    }

    @CacheEvict(key = "'city_'+#id")
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void delete(long id) {
        cityMapper.delete(id);
    }

}

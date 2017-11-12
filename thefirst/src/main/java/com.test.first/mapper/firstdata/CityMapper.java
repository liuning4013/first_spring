package com.test.first.mapper.firstdata;

import com.test.first.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by liuning on 2017/9/18.
 */
public interface CityMapper {

   /* @Select("select * from city")
    @Results({
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })*/
    List<City> getCitys();

   /* @Select("select * from city where province_id = #{provinceId}")
    @Results({
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })*/
    City getOneCity(@Param("id") Long id);

    void edit(City city);

    void save(City city);

    void delete(long id);
}

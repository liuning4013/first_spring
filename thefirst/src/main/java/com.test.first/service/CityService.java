package com.test.first.service;

import com.test.first.domain.City;

import java.util.List;

/**
 * Created by liuning on 2017/9/18.
 */
public interface CityService {
    public List<City> getCitys();
    public City getOneCity(Long id);
    public void edit(City city);
    public void save(City city);
    public void delete(long id);
}

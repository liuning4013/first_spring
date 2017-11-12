package com.test.first.controller;

import com.test.first.domain.City;
import com.test.first.domain.User;
import com.test.first.service.CityService;
import com.test.first.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liuning on 2017/9/18.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/getCitys";
    }

    /*
    * @pathvariable 将url中占位符的参数通过@pathvariable,绑定到处理方法的入参中
    * @requestparam 在处理方法入参处使用 @RequestParam 可以把请求参数传递给请求方法，
    * @Modelattribute  @ModelAttribute注释的方法会在此controller每个方法执行前被执行
    * @requestbody  @RequestBody接收的是一个Json对象的字符串，而不是一个Json对象
    * @responsebody   返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用
    *
    * */

    @ApiOperation(value = "获取城市列表",notes = "")
    @RequestMapping("/getCitys")
    public String getCitys(Model model){
        List<City> citys = cityService.getCitys();

        model.addAttribute("citys",citys);
        return "list";
    }

    @ApiOperation(value="获取城市信息",notes = "根据url的id来获取城市的详细信息")
    @ApiImplicitParam(name = "id", value = "城市ID", required = true, dataType = "Long")
    @RequestMapping("/toEdit")
    public String getOneCity(Long id, Model model){
        City city = cityService.getOneCity(id);
        User test_user = userService.getUser(id);
        model.addAttribute("city",city);
        model.addAttribute("user",test_user);
        return "editcity";
    }

    @ApiOperation(value="修改城市信息",notes = "根据city实体来修改城市的详细信息")
    @ApiImplicitParam(name = "city", value = "城市实体", required = true, dataType = "City")
    @RequestMapping("/edit")
    public String edit(City city){
        cityService.edit(city);
        return "redirect:/getCitys";
    }

    @ApiOperation(value="初始化城市添加页面",notes = "")
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "city";
    }

    @ApiOperation(value="提交城市信息",notes = "根据city实体来提交城市的详细信息")
    @ApiImplicitParam(name = "city", value = "城市实体", required = true, dataType = "City")
    @RequestMapping("/add")
    public String add(City city) {
        cityService.save(city);
        return "redirect:/getCitys";
    }

    @ApiOperation(value="删除城市信息",notes = "根据url的id来删除城市的详细信息")
    @ApiImplicitParam(name = "id", value = "城市ID", required = true, dataType = "Long")
    @RequestMapping("/delete")
    public String delete(Long id){
        cityService.delete(id);
        return "redirect:/getCitys";
    }
}

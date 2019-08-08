package com.kangswx.springbootswagger2.controller;

import com.kangswx.springbootswagger2.entity.JsonData;
import com.kangswx.springbootswagger2.entity.User;
import com.kangswx.springbootswagger2.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询接口
     * @param id
     * @return
     */
    @ApiOperation(value = "查询用户信息", notes = "根据url的id来查询用户详细信息")
    @ApiImplicitParam(name="id", value = "用户的id", required = true, dataType = "int", paramType = "path")
    @GetMapping(value = "{id}")
    public Object getById(@PathVariable int id){
        User user = userService.getByid(id);
        return JsonData.buildSuccess(user);
    }

    /**
     * 修改接口
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户信息", notes = "根据传入对象的非空字段值和id修改用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "Json", paramType = "body")
    @PutMapping()
    public Object updateUserById(@RequestBody User user){
        int ret = userService.updateUser(user);
        JsonData jsonData = null;
        if(ret > 0){
            jsonData = JsonData.buildSuccess("修改成功");
        } else {
            jsonData = JsonData.buildError("修改失败");
        }
        return jsonData;
    }

    /**
     * 添加接口
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "将传入的用户对象添加到数据库")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "Json", paramType = "body")
    @PostMapping()
    public Object addUser(@RequestBody User user){
        int ret = userService.addUser(user);
        JsonData jsonData = null;
        if(ret > 0){
            jsonData = JsonData.buildSuccess("添加成功");
        } else {
            jsonData = JsonData.buildError("添加失败");
        }
        return jsonData;
    }

    /**
     * 删除接口
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来删除数据库中对应的用户")
    @ApiImplicitParam(name="id", value = "用户的id", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("{id}")
    public Object deleteUser(@PathVariable int id){
        int ret = userService.deleteUserById(id);
        JsonData jsonData = null;
        if(ret > 0){
            jsonData = JsonData.buildSuccess("删除成功");
        } else {
            jsonData = JsonData.buildError("删除失败");
        }
        return jsonData;
    }

}

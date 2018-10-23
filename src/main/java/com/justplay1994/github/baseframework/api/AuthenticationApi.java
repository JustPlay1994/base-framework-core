package com.justplay1994.github.baseframework.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Package: com.justplay1994.github.baseframework.api
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 11:29
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 11:29
 * @Update_Description: huangzezhou 补充
 **/
@Api(description = "统一认证授权")
public interface AuthenticationApi {

    @ApiOperation(value = "登录接口", notes = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "username", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "password", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/tokenLogin", method = RequestMethod.GET)
    public String tokenLogin(String username, String password);


}

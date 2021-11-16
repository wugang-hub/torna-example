package cn.torna.tornaexample.controller.login;

import cn.torna.tornaexample.common.Result;
import cn.torna.tornaexample.controller.login.param.LoginParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author tanghc
 */
@RestController
@RequestMapping("login")
@Api(value = "登录模块", position = 2)
public class LoginController {

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("login")
    public Result<LoginVO> login(@RequestBody LoginParam param) {
        LoginVO loginVO = new LoginVO();
        loginVO.setUserId(1);
        loginVO.setUsername(param.getUsername());
        loginVO.setToken(UUID.randomUUID().toString());
        return Result.ok(loginVO);
    }

    @Data
    public static class LoginVO {
        @ApiModelProperty(value = "用户id", required = true, example = "11")
        private Integer userId;

        @ApiModelProperty(value = "用户名", required = true, example = "jim")
        private String username;

        @ApiModelProperty(value = "token", required = true, example = "xx")
        private String token;
    }


}

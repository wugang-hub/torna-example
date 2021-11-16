package cn.torna.tornaexample.controller.login.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class LoginParam {

    @ApiModelProperty(value = "用户名", required = true, example = "jim")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "123")
    private String password;

}

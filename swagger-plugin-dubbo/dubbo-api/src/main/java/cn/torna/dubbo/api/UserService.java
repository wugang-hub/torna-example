package cn.torna.dubbo.api;

import cn.torna.dubbo.api.param.UserParam;
import cn.torna.dubbo.api.result.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "用户接口")
public interface UserService {

    @ApiOperation(value = "获取用户信息")
    UserInfo getUserInfo(Integer userId);

    @ApiOperation(value = "修改昵称")
    void updateNickname(
            @ApiParam(value = "用户id", required = true, example = "111")
            Integer userId,
            @ApiParam(value = "用户昵称", required = true, example = "Jim")
            String nickname);

    @ApiOperation(value = "添加用户")
    void addUser(UserParam param);
}

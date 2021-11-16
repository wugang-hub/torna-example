package cn.torna.dubbo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserParam {

    @ApiModelProperty(value = "昵称", required = true, example = "Jim")
    private String nickname;

    @ApiModelProperty(value = "年龄", required = true, example = "22")
    private int age;

    @ApiModelProperty(value = "地址信息")
    private AddressInfo addressInfo;

}

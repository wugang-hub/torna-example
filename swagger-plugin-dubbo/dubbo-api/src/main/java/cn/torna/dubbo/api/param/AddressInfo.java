package cn.torna.dubbo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressInfo {

    @ApiModelProperty(value = "详细地址", example = "xxx")
    private String address;

    @ApiModelProperty(value = "邮政编码", example = "10000")
    private String postcode;

}

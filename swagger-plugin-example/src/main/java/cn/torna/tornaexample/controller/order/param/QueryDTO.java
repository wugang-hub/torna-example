package cn.torna.tornaexample.controller.order.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryDTO {
    @ApiModelProperty(value = "id", example = "123")
    private Integer id;

    @ApiModelProperty(value = "订单id", example = "aaaa")
    private String orderNo;
}
package cn.torna.tornaexample.controller.order.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderDTO {
    @ApiModelProperty(value = "订单id", example = "aaaa", position = 0)
    private String orderNo;

    @ApiModelProperty(value = "备注", example = "订单", position = 1)
    private String remark;
}
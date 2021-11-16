package cn.torna.tornaexample.controller.order.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderQuery {
    @ApiModelProperty(value = "查询id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "订单id", example = "xxx")
    private Integer orderNo;
}
package cn.torna.tornaexample.controller.order.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDetail {
    @ApiModelProperty(value = "用户id", example = "123", dataType = "number")
    private Long userId;

    @ApiModelProperty(value = "订单号", example = "xxx")
    private String orderNo;

    @ApiModelProperty(value = "订单id", example = "2021-05-24 19:59:51")
    private Date payTime;

    private String remark;
}
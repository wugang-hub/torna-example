package cn.torna.tornaexample.controller.product.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class CycleProduct {

    @ApiModelProperty(value = "产品id", example = "aaaa")
    private String productNo;

    @ApiModelProperty(value = "订单详情")
    private CycleOrder cycleOrder;

}

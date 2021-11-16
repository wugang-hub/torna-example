package cn.torna.tornaexample.controller.product.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class CycleOrder {
    @ApiModelProperty(value = "订单id", example = "bbbb", position = 0)
    private String orderNo;

    @ApiModelProperty(value = "产品详情", position = 2)
    private CycleProduct cycleProduct;

    @ApiModelProperty(value = "产品详情B", position = 2)
    private CycleProduct cycleProductB;
}

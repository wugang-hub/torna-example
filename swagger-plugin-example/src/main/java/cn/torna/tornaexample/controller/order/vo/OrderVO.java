package cn.torna.tornaexample.controller.order.vo;

import cn.torna.tornaexample.controller.product.vo.ProductVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tanghc
 */
@Data
public class OrderVO {
    @ApiModelProperty(value = "订单id", example = "aaaa", position = 0)
    private String orderNo;

    @ApiModelProperty(value = "备注", example = "订单" , position = 1)
    private String remark;

    @ApiModelProperty(value = "订单详情", position = 2)
    private OrderDetail orderDetail;

    @ApiModelProperty(value = "产品详情", position = 3)
    private List<ProductVO> products;

    @ApiModelProperty(value = "产品详情2", position = 4)
    private List<ProductVO> products2;

    @ApiModelProperty(value = "产品详情3", position = 5)
    private List<ProductVO> products3;

    @ApiModelProperty(value = "产品详情arr", position = 6)
    private ProductVO[] productArr;
}

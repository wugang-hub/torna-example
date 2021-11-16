package cn.torna.tornaexample.controller.product.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class ProductVO {
    @ApiModelProperty(value = "产品id", example = "aaaa")
    private String productNo;

    @ApiModelProperty(value = "备注", example = "小米")
    private String remark;

    @ApiModelProperty(value = "产品详情")
    private ProductDetailVO productDetailVO;

}

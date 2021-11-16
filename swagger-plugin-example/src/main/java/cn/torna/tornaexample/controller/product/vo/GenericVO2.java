package cn.torna.tornaexample.controller.product.vo;

import cn.torna.tornaexample.controller.order.vo.OrderVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GenericVO2 {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("orders")
    private List<List<OrderVO>> orderVOS;

}

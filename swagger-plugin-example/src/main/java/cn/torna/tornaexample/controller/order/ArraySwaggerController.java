package cn.torna.tornaexample.controller.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tanghc
 */
@RestController
@RequestMapping("order")
@Api(value = "订单模块", position = 10)
public class ArraySwaggerController {

    @ApiOperation(value = "参数/返回都是List<OrderDTO>", notes = "List方式", position = 100)
    @PostMapping("postArr4")
    public List<OrderDTO> postArr4(@RequestBody List<OrderDTO> orderDTOS) {
        return orderDTOS;
    }

    @ApiOperation(value = "参数/返回都是OrderDTO[]", notes = "参数/返回都是OrderDTO[]", position = 101)
    @PostMapping("postArr")
    public OrderDTO[] postArr(@RequestBody OrderDTO[] orderDTOS) {
        return orderDTOS;
    }

    @ApiOperation(value = "参数Integer[],返回OrderDTO[]", notes = "参数Integer[],返回OrderDTO[]", position = 102)
    @PostMapping("postArr2")
    public OrderDTO[] postArr2(
            @ApiParam(value = "订单id", example = "1,2,3")
            @RequestBody Integer[] orderDTOS) {
        OrderDTO[] arr = new OrderDTO[orderDTOS.length];
        for (int i = 0; i < orderDTOS.length; i++) {
            OrderDTO orderDTO = new OrderDTO();
            Integer item = orderDTOS[i];
            orderDTO.setOrderNo("" + item);
            arr[i] = orderDTO;
        }
        return arr;
    }

    @ApiOperation(value = "参数OrderDTO[],返回Integer[]", position = 103)
    @PostMapping("postArr3")
    public
    @ApiParam(value = "订单id", example = "1,2,3")
    Integer[] postArr3(@RequestBody OrderDTO[] orderDTOS) {
        int len = orderDTOS.length;
        return new Integer[]{len};
    }


    @ApiOperation(value = "参数/返回都是List<Integer>", notes = "List方式", position = 104)
    @PostMapping("postArr5")
    public
    @ApiParam(value = "返回订单id", example = "4,5,6")
    List<Integer> postArr5(@RequestBody
                           @ApiParam(value = "订单id", example = "1,2,3")
                                   List<Integer> orderDTOS) {
        return orderDTOS;
    }

    @ApiOperation(value = "参数/返回都是List<OrderDTO>2", notes = "List方式", position = 105)
    @PostMapping("postArr6")
    public List<OrderDTO> postArr4(@RequestBody List<OrderDTO> orderDTOS,
                                   @ApiParam(value = "id", example = "xxx")
                                   @RequestParam String id) {
        return orderDTOS;
    }


    @Data
    public static class OrderDTO {
        @ApiModelProperty(value = "订单id", example = "aaaa", position = 0)
        private String orderNo;

        @ApiModelProperty(value = "备注", example = "订单" , position = 1)
        private String remark;
    }

}

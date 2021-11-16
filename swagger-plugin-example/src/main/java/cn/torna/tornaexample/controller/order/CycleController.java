package cn.torna.tornaexample.controller.order;

import cn.torna.tornaexample.common.Result;
import cn.torna.tornaexample.controller.product.vo.CycleOrder;
import cn.torna.tornaexample.controller.product.vo.TreeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanghc
 */
@RestController
@RequestMapping("order")
@Api(value = "订单模块", position = 0)
public class CycleController {

    @ApiOperation(value = "循环属性")
    @GetMapping("cycle")
    public CycleOrder cycle() {
        return new CycleOrder();
    }

    @ApiOperation(value = "返回树")
    @GetMapping("cycle2")
    public Result<TreeVO> get() {
        return Result.ok(new TreeVO());
    }

}

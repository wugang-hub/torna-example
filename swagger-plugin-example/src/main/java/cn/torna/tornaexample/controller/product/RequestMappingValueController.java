package cn.torna.tornaexample.controller.product;

import cn.torna.tornaexample.controller.product.vo.ProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示方法没有path
 * @author thc
 */
@RestController
@RequestMapping("shop/product")
@Api(value = "商城产品")
public class RequestMappingValueController {

    @ApiOperation(value = "修改产品")
    @PutMapping
    public ProductVO put(@RequestBody ProductVO productVO) {
        return null;
    }

    @ApiOperation(value = "新增产品")
    @RequestMapping(method = RequestMethod.POST)
    public ProductVO post(@RequestBody ProductVO productVO) {
        return null;
    }

    @ApiOperation(value = "查询产品")
    @GetMapping
    public ProductVO get(
            @ApiParam(value = "产品id", example = "123")
            @PathVariable Integer productNo) {
        return null;
    }

}

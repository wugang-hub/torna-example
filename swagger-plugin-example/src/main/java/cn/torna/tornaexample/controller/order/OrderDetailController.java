package cn.torna.tornaexample.controller.order;

import cn.torna.tornaexample.common.MyPage;
import cn.torna.tornaexample.common.ParamVo;
import cn.torna.tornaexample.common.Result;
import cn.torna.tornaexample.controller.order.param.OrderQuery;
import cn.torna.tornaexample.controller.order.vo.OrderDetail;
import cn.torna.tornaexample.controller.product.vo.ProductVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 此文件中的接口会跟OrderDetailController中的接口合并到一个文件夹下，只要@Api.value一致就行
 * @author tanghc
 */
@RestController
@RequestMapping("order")
@Api(value = "订单模块", position = 0)
public class OrderDetailController {


    @ApiOperation(value = "获取某个产品下的订单", notes = "<strong>注意：</strong>html演示。。")
    @GetMapping("get2/{productNo}")
    public Result<List<OrderDetail>> get(
            @RequestParam("qid") String qid,
            @PathVariable Integer productNo,
            @RequestHeader("token") String token,
            OrderQuery query

    ) {
        List<OrderDetail> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder()
                .append("qid=").append(qid)
                .append(", productNo=").append(productNo)
                .append(", token=").append(token)
                .append(", query=").append(query);
        for (int i = 0; i < 3; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPayTime(new Date());
            orderDetail.setUserId((long)i + 1);
            orderDetail.setOrderNo(qid + i);
            orderDetail.setRemark(sb.toString());
            list.add(orderDetail);
        }
        return Result.ok(list);
    }

    @ApiOperation(value = "只1层泛型")
    @PostMapping("moreGeneric2")
    public Result<OrderDetail> query2(@RequestBody Page<ProductVO> paramVo) {
        return Result.ok(new OrderDetail());
    }

    @ApiOperation(value = "没有泛型")
    @PostMapping("moreGeneric3")
    public Result query3(@RequestBody ProductVO paramVo) {
        return Result.ok(new OrderDetail());
    }

    @ApiOperation(value = "嵌套泛型，2层泛型")
    @PostMapping("moreGeneric")
    public Result<Page<OrderDetail>> query(@RequestBody ParamVo<Page<ProductVO>, OrderQuery> paramVo) {
        return Result.ok(new Page<>());
    }


}

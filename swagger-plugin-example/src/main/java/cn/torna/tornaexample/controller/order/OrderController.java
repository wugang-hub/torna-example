package cn.torna.tornaexample.controller.order;

import cn.torna.tornaexample.common.Result;
import cn.torna.tornaexample.controller.order.param.OrderDTO;
import cn.torna.tornaexample.controller.order.param.OrderQuery;
import cn.torna.tornaexample.controller.order.param.QueryDTO;
import cn.torna.tornaexample.controller.order.vo.OrderDetail;
import cn.torna.tornaexample.controller.order.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Optional;

/**
 * 此文件中的接口会跟OrderDetailController中的接口合并到一个文件夹下，只要@Api.value一致就行
 * @author tanghc
 */
@RestController
@RequestMapping("order")
@Api(value = "订单模块", position = 0)
public class OrderController {

    @ApiOperation(value = "提交订单信息，application/json", notes = "提交订单信息，application/json", extensions = {
            // 指定维护人
            @Extension(name = "author", properties = {
                    @ExtensionProperty(name = "Tom", value = "")
            }),
            // 指定错误码
            @Extension(name = "code", properties = {
                    @ExtensionProperty(name = "100001", value = "id错误"),
                    @ExtensionProperty(name = "100002", value = "错误描述2"),
                    @ExtensionProperty(name = "100003", value = "错误描述3")
            })
    })
    @PostMapping("create")
    public Result<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        return Result.ok(orderDTO);
    }

    @ApiOperation(value = "提交订单信息，application/x-www-form-urlencoded", notes = "提交订单信息，application/x-www-form-urlencoded")
    @PostMapping("create2")
    public Result<OrderDTO> create2(OrderDTO orderDTO) {
        return Result.ok(orderDTO);
    }

    @ApiOperation(value = "演示query参数,不加@RequestParam", notes = "演示query参数,不加@RequestParam")
    @GetMapping("get")
    public Result<OrderDetail> get(
            @ApiParam(value = "订单id", example = "xxx", required = true)
            String orderNo
    ) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNo(orderNo);
        orderDetail.setUserId(11L);
        orderDetail.setPayTime(new Date());
        return Result.ok(orderDetail);
    }

    @ApiOperation(value = "演示query参数,加@RequestParam", notes = "演示query参数,加@RequestParam")
    @GetMapping("get2")
    public Result<OrderDetail> get2(
            @ApiParam(value = "订单id", example = "xxx")
            @RequestParam String orderNo
    ) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNo(orderNo);
        orderDetail.setUserId(11L);
        orderDetail.setPayTime(new Date());
        return Result.ok(orderDetail);
    }

    @ApiOperation(value = "演示query参数,放在对象里面")
    @GetMapping("get4")
    public Result<OrderDetail> get4(OrderQuery orderQuery) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNo("orderQuery:" + orderQuery);
        orderDetail.setUserId(11L);
        orderDetail.setPayTime(new Date());
        return Result.ok(orderDetail);
    }

    @ApiOperation(value = "演示query参数,放在对象里面+外面一个")
    @GetMapping("get5")
    public Result<OrderDetail> get5(OrderQuery orderQuery,
                                    @ApiParam(value = "产品id，外面的", example = "111")
                                    String pid) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNo("orderQuery:" + orderQuery);
        orderDetail.setUserId(11L);
        orderDetail.setPayTime(new Date());
        return Result.ok(orderDetail);
    }


    @ApiOperation(value = "演示path参数", notes = "演示path参数")
    @GetMapping("get/{orderNo}")
    public Result<OrderDetail> get3(
            @ApiParam(value = "订单id", example = "xxx")
            @PathVariable String orderNo
    ) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNo(orderNo);
        orderDetail.setUserId(11L);
        orderDetail.setPayTime(new Date());
        return Result.ok(orderDetail);
    }

    @ApiOperation(value = "演示path参数+query参数+body参数+header", notes = "提交订单信息说明。。")
    @PostMapping("submit/{productNo}")
    public Result<OrderVO> submit(
            @RequestBody QueryDTO queryDTO,
            @ApiParam(value = "查询id", example = "xx")
            @RequestParam("qid") String qid,
            @ApiParam(value = "产品id", example = "11")
            @PathVariable Integer productNo,
            @ApiParam(value = "token", example = "asdfe")
            @RequestHeader("token") String token
    ) {

        OrderVO orderVO = new OrderVO();
        orderVO.setOrderNo(queryDTO.getOrderNo());
        StringBuilder sb = new StringBuilder()
                .append("queryDTO=").append(queryDTO)
                .append(", qid=").append(qid)
                .append(", productNo=").append(productNo)
                .append(", token=").append(token);
        orderVO.setRemark(sb.toString());
        return Result.ok(orderVO);
    }


    @ApiOperation(value = "全部参数json，全部由@ApiImplicitParams实现", notes = "全部由@ApiImplicitParams实现")
    /*
        name：参数名
        value：参数的说明、解释
        required：参数是否必须传
        paramType：参数放在哪个地方，详见：springfox.documentation.service.ParameterType
            · header --> 请求参数的获取：@RequestHeader
            · query --> 请求参数的获取：@RequestParam
            · path（用于restful接口）--> 请求参数的获取：@PathVariable
            · body（application/json）
            · form（application/x-www-form-urlencoded）
        dataType：参数类型，默认String，其它值dataType="Integer"
        defaultValue：参数的默认值
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "productNo", value = "产品id", dataType = "integer", required = true, example = "11"),
            @ApiImplicitParam(paramType = "header", name = "token", value = "token", dataType = "integer", required = true, example = "asdfe"),
            @ApiImplicitParam(paramType = "query", name = "qid", value = "查询id", dataType = "string", required = true, example = "xx"),
            @ApiImplicitParam(paramType = "body", name = "queryDTO", required = true, dataTypeClass = QueryDTO.class)
    })
    @PostMapping("submit2/{productNo}")
    public Result<OrderVO> submit2(
            @RequestBody QueryDTO queryDTO,
            @RequestParam("qid") String qid,
            @PathVariable Integer productNo,
            @RequestHeader("token") String token
    ) {
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderNo(queryDTO.getOrderNo());
        StringBuilder sb = new StringBuilder()
                .append("queryDTO=").append(queryDTO)
                .append(", qid=").append(qid)
                .append(", productNo=").append(productNo)
                .append(", token=").append(token);
        orderVO.setRemark(sb.toString());
        return Result.ok(orderVO);
    }

    @ApiOperation(value = "全部参数form，全部由@ApiImplicitParams实现", notes = "全部由@ApiImplicitParams实现")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "productNo", value = "产品id", dataType = "integer", required = true, example = "11"),
            @ApiImplicitParam(paramType = "header", name = "token", value = "token", dataType = "integer", required = true, example = "asdfe"),
            @ApiImplicitParam(paramType = "query", name = "qid", value = "查询id", dataType = "string", required = true, example = "xx"),
            @ApiImplicitParam(paramType = "form", name = "queryDTO", required = true, dataTypeClass = QueryDTO.class)
    })
    @PostMapping("submit3/{productNo}")
    public Result submit3(
            QueryDTO queryDTO,
            @RequestParam("qid") String qid,
            @PathVariable Integer productNo,
            @RequestHeader("token") String token
    ) {
        StringBuilder sb = new StringBuilder()
                .append("queryDTO=").append(queryDTO)
                .append(", qid=").append(qid)
                .append(", productNo=").append(productNo)
                .append(", token=").append(token);
        return Result.ok(sb);
    }

    @ApiOperation(value = "全部参数upload，全部由@ApiImplicitParams实现", notes = "全部由@ApiImplicitParams实现")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "productNo", value = "产品id", dataType = "integer", required = true, example = "11"),
            @ApiImplicitParam(paramType = "header", name = "token", value = "token", dataType = "integer", required = true, example = "asdfe"),
            @ApiImplicitParam(paramType = "query", name = "qid", value = "查询id", dataType = "string", required = true, example = "xx"),
            @ApiImplicitParam(paramType = "formData", name = "file", value = "文件", dataType = "file", required = true)
    })
    @PostMapping("submit4/{productNo}")
    public Result submit4(
            MultipartFile file,
            @RequestParam("qid") String qid,
            @PathVariable Integer productNo,
            @RequestHeader("token") String token
    ) {
        StringBuilder sb = new StringBuilder()
                .append("file=").append(Optional.ofNullable(file).map(MultipartFile::getOriginalFilename).orElse(null))
                .append(", qid=").append(qid)
                .append(", productNo=").append(productNo)
                .append(", token=").append(token);
        return Result.ok(sb);
    }


}

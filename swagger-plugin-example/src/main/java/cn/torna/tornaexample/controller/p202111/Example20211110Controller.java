package cn.torna.tornaexample.controller.p202111;

import cn.torna.tornaexample.common.MyPage;
import cn.torna.tornaexample.common.Result;
import cn.torna.tornaexample.controller.order.vo.OrderDetail;
import cn.torna.tornaexample.controller.product.param.VideoStructuredAnalysisTasksDTO;
import cn.torna.tornaexample.controller.product.vo.ProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Api(value = "测试用例202111", position = -1)
@RestController
public class Example20211110Controller {

    @ApiOperation(value = "继承第三方类")
    @PostMapping("extendThirdClass")
    public Result<OrderDetail> extendThirdClass(@RequestBody MyPage<ProductVO> paramVo) {
        return Result.ok(new OrderDetail());
    }

}

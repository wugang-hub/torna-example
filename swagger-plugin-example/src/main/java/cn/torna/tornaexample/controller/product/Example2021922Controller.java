package cn.torna.tornaexample.controller.product;

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

@Api(value = "测试用例", position = -1)
@RestController
public class Example2021922Controller {

    @ApiOperation(value = "example2021922")
    @PostMapping("example2021922")
    public ResponseEntity a(@RequestBody VideoStructuredAnalysisTasksDTO dto) {
        return null;
    }


    @ApiOperation(value = "delete method with body")
    @DeleteMapping("2021111/delete")
    public Result delete(HttpServletRequest request) {
        try {
            ServletInputStream inputStream = request.getInputStream();
            String body = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            return Result.ok(body);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("参数错误");
        }
    }

}

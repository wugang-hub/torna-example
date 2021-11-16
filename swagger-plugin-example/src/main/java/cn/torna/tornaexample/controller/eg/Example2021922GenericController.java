package cn.torna.tornaexample.controller.eg;

import cn.torna.tornaexample.common.Result;
import cn.torna.tornaexample.controller.product.param.VideoStructuredAnalysisTasksDTO;
import cn.torna.tornaexample.controller.product.vo.GenericVO;
import cn.torna.tornaexample.controller.product.vo.GenericVO2;
import cn.torna.tornaexample.controller.product.vo.SurveyQuestionOptions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试用例", position = -1)
@RestController
public class Example2021922GenericController {

    @ApiOperation("泛型")
    @GetMapping("example72021923")
    public GenericVO b() {
        return null;
    }

    @ApiOperation("泛型2")
    @GetMapping("example6220219232")
    public GenericVO2 b2() {
        return null;
    }

    @ApiOperation("泛型3")
    @GetMapping("test/item/{id}")
    public Result<SurveyQuestionOptions> get(@PathVariable String id) {
        return null;
    }

    @ApiOperation("问号泛型")
    @GetMapping("test/generic/q")
    public Result<?> genericQ(String id) {
        return null;
    }
}

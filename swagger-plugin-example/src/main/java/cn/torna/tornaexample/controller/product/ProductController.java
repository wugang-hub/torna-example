package cn.torna.tornaexample.controller.product;

import cn.torna.tornaexample.common.Result;
import cn.torna.tornaexample.controller.product.vo.ProductVO;
import cn.torna.tornaexample.controller.product.vo.TreeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author tanghc
 */
@RestController
@RequestMapping("product")
@Api(value = "产品模块", position = -1)
public class ProductController {


    @ApiOperation(value = "获取产品", notes = "获取产品说明。。", extensions = {
            // 指定维护人
            @Extension(name = "author", properties = {
                    @ExtensionProperty(name = "Tom", value = ""),
                    @ExtensionProperty(name = "Jim", value = ""),
            }),
            // 指定错误码
            @Extension(name = "code", properties = {
                    @ExtensionProperty(name = "100001", value = "id错误"),
                    @ExtensionProperty(name = "100002", value = "错误描述2"),
                    @ExtensionProperty(name = "100003", value = "错误描述3")
            })
    })
    @GetMapping("get/{productNo}")
    public ProductVO get(
            @ApiParam(value = "产品id", example = "123")
            @PathVariable Integer productNo) {
        return null;
    }

    @ApiOperation(value = "上传文件")
    @PostMapping("upload")
    @Order(11)
    public Result upload(
            @ApiParam(value = "产品模板文件", required = true)
            MultipartFile file,
            @ApiParam(value = "产品id", required = true, example = "111")
            String productNo) {
        return new Result("file:" + Optional.ofNullable(file)
                .map(MultipartFile::getOriginalFilename).orElse(null) + ", productNo:" + productNo);
    }

    @ApiOperation(value = "上传文件2")
    @PostMapping("upload2")
    @Order(12)
    public Result upload2(UploadParam param) {
        StringBuilder sb = new StringBuilder();
        sb.append("file name:")
                .append(Optional.ofNullable(param.getFile())
                        .map(MultipartFile::getOriginalFilename).orElse(null));
        sb.append(", fileArr name:").append(Optional.ofNullable(param.getFiles()).map(multipartFiles -> {
            return "[" + Arrays.stream(multipartFiles)
                    .map(MultipartFile::getOriginalFilename)
                    .collect(Collectors.joining(",")) + "]";
        }).orElse(null));
        sb.append(", fileList name:").append(Optional.ofNullable(param.getFileList()).map(multipartFiles -> {
            return "[" + multipartFiles.stream()
                    .map(MultipartFile::getOriginalFilename)
                    .collect(Collectors.joining(",")) + "]";
        }).orElse(null))
        ;
        return Result.ok(sb);
    }

    @ApiOperation(value = "上传文件3")
    @PostMapping("upload3")
    @Order(13)
    public Result upload3(
            @ApiParam(value = "产品模板文件", required = true)
                    MultipartFile[] files,
            @ApiParam(value = "产品id", required = true, example = "111")
                    String productNo) {
        String fileName = Optional.ofNullable(files).map(multipartFiles -> {
            return "[" + Arrays.stream(multipartFiles)
                    .map(MultipartFile::getOriginalFilename)
                    .collect(Collectors.joining(",")) + "]";
        }).orElse(null);
        return new Result("file:" + fileName + ", productNo:" + productNo);
    }

    @Data
    public static class UploadParam {
        @ApiModelProperty(value = "产品模板文件")
        MultipartFile file;

        @ApiModelProperty(value = "产品模板文件Array")
        MultipartFile[] files;

        @ApiModelProperty(value = "产品模板文件List")
        List<MultipartFile> fileList;

        @ApiModelProperty(value = "产品id", required = true, example = "111")
        String productNo;
    }


    @ApiOperation(value = "返回树")
    @GetMapping("getTree")
    public Result<TreeVO> get() {
        return null;
    }

}

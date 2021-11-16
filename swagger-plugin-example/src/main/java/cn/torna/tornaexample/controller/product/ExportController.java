package cn.torna.tornaexample.controller.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(value = "产品模块", position = -1)
@RestController
public class ExportController {

    @ApiOperation(value = "导出")
    @GetMapping("export")
    public ResponseEntity<byte[]> download() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        // 假设下载classpath下的application.properties文件
        ClassPathResource resource = new ClassPathResource("/application.properties");

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", resource.getFilename());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(IOUtils.toByteArray(resource.getInputStream()));
    }

    @ApiOperation(value = "导出zip")
    @GetMapping("exportZip")
    public ResponseEntity<byte[]> download2() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        // 假设下载classpath下的application.properties文件
        ClassPathResource resource = new ClassPathResource("/res.zip");

        headers.setContentType(MediaType.valueOf("application/zip"));
        headers.setContentDispositionFormData("attachment", resource.getFilename());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(IOUtils.toByteArray(resource.getInputStream()));
    }

}

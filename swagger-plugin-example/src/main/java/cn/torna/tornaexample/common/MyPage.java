package cn.torna.tornaexample.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
public class MyPage<T> extends Page<T> {

    @ApiModelProperty(value = "描述")
    @NotBlank
    private String remark;

    @ApiModelProperty(value = "版本", example = "1.0")
    @NotBlank
    private String version;
}

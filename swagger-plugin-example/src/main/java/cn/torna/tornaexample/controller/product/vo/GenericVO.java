package cn.torna.tornaexample.controller.product.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class GenericVO {

    @ApiModelProperty("坐标值")
    public List<List<String>> values;
    @ApiModelProperty("X名称")
    public List<String> x_aix;
    @ApiModelProperty("Y名称")
    public List<String> y_aix;
}

package cn.torna.tornaexample.controller.product.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinhu.yang
 * @date 2021/4/7 下午4:48
 */
@Data
@ApiModel("布控时间段")
public class TimeRange implements Serializable {

    @ApiModelProperty(value = "必填,布控开始时间,ISO8601_time 格式,只需要时间", example = "17:30:08")
    private String startTime;

    @ApiModelProperty(value = "必填,布控结束时间, ISO8601_time 格式", example = "17:30:08")
    private String endTime;
}

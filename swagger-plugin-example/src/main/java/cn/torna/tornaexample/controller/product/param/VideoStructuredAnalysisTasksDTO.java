package cn.torna.tornaexample.controller.product.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 视频结构化任务信息数据传输对象
 *
 * @author linming.luo
 * @date 2021/9/15 下午4:53
 */
@Data
@ApiModel("视频结构化任务信息数据传输对象")
public class VideoStructuredAnalysisTasksDTO {

    @ApiModelProperty(value = "必填,任务名称", required = true)
    private String taskName;

    @ApiModelProperty(value = "取流 url", required = true)
    private String streamUrl;

    @ApiModelProperty(value = "流地址用户名")
    private String streamUserName;

    @ApiModelProperty(value = "取流密码")
    private String streamPassword;

    @ApiModelProperty("任务时间类型")
    private VSTITaskTypeEnum taskType;

    @ApiModelProperty("taskType为计划任务-plan时的时间布控列表")
    private List<ExeTimeList> exeTimeList;


    @ApiModelProperty(value = "数据分析完成后的保存地址")
    private String dataPullAdd;

    @Data
    @ApiModel("布控时间计划时间列表,必填")
    public class ExeTimeList {

        @ApiModelProperty(value = "计划日时间段列表", required = true)
        private List<TimeRange> timeRange;
    }

}

package cn.torna.tornaexample.controller.product.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 投票问卷问题
 * @author sunyuan
 * @date 2021-09-15 17:24:23
 */
@Data
@TableName("survey_question")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "投票问卷问题")
public class SurveyQuestion extends Model<SurveyQuestion> {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value="问题id")
    private Long id;

    @ApiModelProperty(value="问卷的id")
    private Integer surveyId;

    @ApiModelProperty(value="问题的类型（1是单选，2是多选，3是填空）")
    private String questionType;

    @ApiModelProperty(value="当问题是多选时答案的数量，最少个数")
    private Integer optionMin;

    @ApiModelProperty(value="当问题是多选时答案的数量，最多个数")
    private Integer optionMax;

    @ApiModelProperty(value="问题描述")
    private String questionDesc;

    @ApiModelProperty(value="问题顺序号")
    private Integer sortNum;

}

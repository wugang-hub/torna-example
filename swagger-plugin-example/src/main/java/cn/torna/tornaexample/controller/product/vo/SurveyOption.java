package cn.torna.tornaexample.controller.product.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 投票问卷选项
 * @author sunyuan
 * @date 2021-09-15 17:24:23
 */
@Data
@TableName("survey_option")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "投票问卷选项")
public class SurveyOption extends Model<SurveyOption> {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value="选项的id")
    private Long id;

    @ApiModelProperty(value="选项对应问题的id")
    private Long questionId;

    @ApiModelProperty(value="选项的描述")
    private String optionDesc;

    @ApiModelProperty(value="选项的图片(只能有1张)")
    private String optionImg;

    @ApiModelProperty(value="选项是否要求录入答案，0不可录入，1可以录入，2必须录入")
    private String optionInput;

    @ApiModelProperty(value="选项的顺序号")
    private Integer sortNum;



	@ApiModelProperty(value="选择此项目的总人数")
	private Integer selectedCount;

	@ApiModelProperty(value="当前用户是否选择了此答案")
	@TableField(exist = false)
	private boolean userSelected;

	@ApiModelProperty(value="当前用户输入的文本答案")
	@TableField(exist = false)
	private String optionText;

}

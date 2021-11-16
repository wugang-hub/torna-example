package cn.torna.tornaexample.controller.product.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liujie
 */
@ApiModel(value = "问卷的问题及选项")
@Data
public class SurveyQuestionOptions {

	@ApiModelProperty(value="问题")
	private SurveyQuestion question;

	@ApiModelProperty(value="问题所有的可选项")
	private List<SurveyOption> options;

	@ApiModelProperty(value="当前用户输入的文本答案/只有填空题才有")
	private String optionText;
}

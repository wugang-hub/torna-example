package cn.torna.tornaexample.controller.product.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tanghc
 */
@Data
public class TreeVO {
    @ApiModelProperty
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private Integer parentId;

    @ApiModelProperty(value = "子节点")
    private List<TreeVO> children;
}

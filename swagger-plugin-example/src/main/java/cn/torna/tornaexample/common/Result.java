package cn.torna.tornaexample.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Result<T> {
    @ApiModelProperty(value = "状态码，0：成功", example = "0", position = 0)
    private Integer code = 0;

    @ApiModelProperty(value = "数据", position = 1)
    private T data;

    @ApiModelProperty(value = "消息", position = 2)
    private String msg;

    public Result(T data) {
        this.data = data;
    }

    public static <E> Result<E> ok(E obj) {
        return new Result<>(obj);
    }

    public static Result<?> error(String msg) {
        Result<Object> result = new Result<>(null);
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }


}
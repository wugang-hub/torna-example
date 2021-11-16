package cn.torna.tornaexample.controller.product.param;

/**
 * 视频结构化任务信息-布控时间任务事件类型 taskType 枚举类
 *
 * @author linming.luo
 * @date 221/9/14 下午4:8
 */
public enum VSTITaskTypeEnum {

    PLAN("plan", "计划任务-实时流有效"),
    TEMP("temp", "临时任务-实时流、历史流都有效"),

    ;

    public final String value;
    public final String message;

    VSTITaskTypeEnum(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

}

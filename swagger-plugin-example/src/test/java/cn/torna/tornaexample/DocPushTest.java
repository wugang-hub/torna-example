package cn.torna.tornaexample;

import cn.torna.swaggerplugin.SwaggerPlugin;

/**
 * 推送swagger文档
 * @author thc
 */
public class DocPushTest {
    public static void main(String[] args) {
        SwaggerPlugin.pushDoc();
        // 默认查找resources下的torna.json
        // 可复制一份用来区分不同环境，然后参数传文件名称
        //SwaggerPlugin.pushDoc("torna-test.json");
    }
}

package org.mybatis.generator.api.dom.java;
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yanxin
 * @create 2018/3/2
 * @since 1.0.0
 */

/**
 * Created by yanxin on 2018/3/2.
 */
public class AnnotationClass {

    private String name;

    private String value;

    private String dynamic;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynamic() {
        return dynamic;
    }

    public void setDynamic(String dynamic) {
        this.dynamic = dynamic;
    }
}

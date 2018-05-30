package org.mybatis.generator.config;

import org.mybatis.generator.api.dom.java.AnnotationClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanxin
 */
public abstract class AnnotationClassHolder {
    private List<AnnotationClass> annotationClassList;

    public AnnotationClassHolder() {
        super();
        annotationClassList = new ArrayList<AnnotationClass>();
    }

    public void addAnnotationClass(AnnotationClass annotationClass) {
        annotationClassList.add(annotationClass);
    }

    public List<AnnotationClass> getAnnotationClassList() {
        return annotationClassList;
    }

}
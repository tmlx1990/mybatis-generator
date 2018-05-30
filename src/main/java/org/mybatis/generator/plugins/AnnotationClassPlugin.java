/**
 * Copyright 2006-2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mybatis.generator.plugins;

import static org.mybatis.generator.internal.util.JavaBeansUtil.getValidPropertyName;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.AnnotationClass;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Properties;

/**
 * This plugin adds the java.io.Serializable marker interface to all generated
 * model objects.
 * <p>
 * This plugin demonstrates adding capabilities to generated Java artifacts, and
 * shows the proper way to add imports to a compilation unit.
 * <p>
 * Important: This is a simplistic implementation of serializable and does not
 * attempt to do any versioning of classes.
 *
 * @author Jeff Butler
 */
public class AnnotationClassPlugin extends PluginAdapter {

    private List<AnnotationClass> annotationClassList;

    private boolean dynamic;

    public AnnotationClassPlugin() {
        super();
    }

    public boolean validate(List<String> warnings) {
        // this plugin is always valid
        return true;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public void setAnnotationClassList(List<AnnotationClass> annotationClassList) {
        super.setAnnotationClassList(annotationClassList);
        this.annotationClassList = annotationClassList; //$NON-NLS-1$
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {
        makeSerializable(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {
        makeSerializable(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        makeSerializable(topLevelClass, introspectedTable);
        return true;
    }

    protected void makeSerializable(TopLevelClass topLevelClass,
                                    IntrospectedTable introspectedTable) {
        for( AnnotationClass annotationClass : annotationClassList){
            StringBuffer sb = new StringBuffer();
            if(Boolean.valueOf(annotationClass.getDynamic())){
                sb.append("@")
                        .append(annotationClass.getName())
                        .append("(value = \"")
                        .append(getValidPropertyName(introspectedTable.getFullyQualifiedTable().getDomainObjectName()))
                        .append("\")");
            }else {
                sb.append("@")
                        .append(annotationClass.getName())
                        .append("(value = \"")
                        .append(topLevelClass.getType().getShortName())
                        .append("\")");
            }
            topLevelClass.addAnnotation(sb.toString());
        }


    }
}

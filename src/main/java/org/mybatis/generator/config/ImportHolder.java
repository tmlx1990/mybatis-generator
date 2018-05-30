package org.mybatis.generator.config;

import org.mybatis.generator.api.dom.java.Import;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanxin
 */
public abstract class ImportHolder extends AnnotationClassHolder{
    private List<Import> importList;

    public ImportHolder() {
        super();
        importList = new ArrayList<Import>();
    }

    public void addImport(Import iImport) {
        importList.add(iImport);
    }

    public List<Import> getImportList() {
        return importList;
    }

}
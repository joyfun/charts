/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public class FieldMapping extends AbstractChartObject {

    private static final long serialVersionUID = 2656776286364228750L;
    
    private String fromField;
    
    private String toField;

    public String getFromField() {
        return fromField;
    }

    public FieldMapping setFromField(String fromField) {
        this.fromField = fromField;
        return this;
    }

    public String getToField() {
        return toField;
    }

    public FieldMapping setToField(String toField) {
        this.toField = toField;
        return this;
    }
}

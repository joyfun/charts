/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsonEnum;

public enum ExportFormat implements JsonEnum {
    JPG("jpg"),
    PNG("png"),
    SVG("svg"),
    PDF("pdf"),
    CSV("csv"),
    JSON("json"),
    XLSX("xlsx"),
    PRINT("print");

    private String id;

    ExportFormat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
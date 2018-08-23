/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsonEnum;

public enum StockEventType implements JsonEnum {
    FLAG("flag"),
    SIGN("sign"),
    PIN("pin"),
    TRIANGLE_UP("triangleUp"),
    TRIANGLE_DOWN("triangleDown"),
    TRIANGLE_LEFT("triangleLeft"),
    TRIANGLE_RIGHT("triangleRight"),
    TEXT("text"),
    ARROW_UP("arrowUp"),
    ARROW_DOWN("arrowDown");

    private String id;

    StockEventType(String id) {
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
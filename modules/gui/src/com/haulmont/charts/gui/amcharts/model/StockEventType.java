/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public enum StockEventType implements ChartEnum {
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

    @Override
    public String toString() {
        return id;
    }
}

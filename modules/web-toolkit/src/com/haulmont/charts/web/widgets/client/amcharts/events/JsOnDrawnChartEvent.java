/*
 * Copyright (c) 2008-2019 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsOnDrawnChartEvent extends JavaScriptObject {

    protected JsOnDrawnChartEvent() {
    }

    public final native int getStartDuration() /*-{
         return this.startDuration;
    }-*/;

    public final native String getChartType() /*-{
         return this.type;
    }-*/;
}

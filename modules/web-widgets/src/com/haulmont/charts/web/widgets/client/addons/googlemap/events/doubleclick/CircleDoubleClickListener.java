/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.events.doubleclick;

import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapCircle;

/**
 * @author korotkov
 * @version $Id$
 */
public interface CircleDoubleClickListener {
    void circleDoubleClicked(GoogleMapCircle circle);
}
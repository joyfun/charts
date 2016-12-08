/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.impl.DateDatatype;
import com.haulmont.chile.core.datatypes.impl.TimeDatatype;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PivotDataItemsSerializer {

    protected Messages messages = AppBeans.get(Messages.class);
    protected Metadata metadata = AppBeans.get(Metadata.class);

    public List<JsonObject> serialize(List<DataItem> items, JsonSerializationContext context) {
        List<JsonObject> serialized = new ArrayList<>();

        if (context instanceof PivotJsonSerializationContext) {
            PivotJsonSerializationContext pivotContext = (PivotJsonSerializationContext) context;
            for (DataItem item : items) {
                JsonObject itemElement = new JsonObject();
                for (String property : pivotContext.getProperties()) {
                    Object value = item.getValue(property);
                    addProperty(itemElement, property, value, pivotContext, item);
                }

                serialized.add(itemElement);
            }
        }

        return serialized;
    }

    protected void addProperty(JsonObject jsonObject, String property, Object value,
                               PivotJsonSerializationContext context, DataItem item) {
        if (value instanceof Date) {
            String formatStr;
            if (item instanceof EntityDataItem) {
                EntityDataItem entityItem = (EntityDataItem) item;
                MetaClass metaClass = metadata.getClassNN(entityItem.getItem().getClass());
                MetaProperty metaProperty = metaClass.getPropertyNN(property);

                if (metaProperty.getRange().asDatatype().equals(Datatypes.get(DateDatatype.NAME))) {
                    formatStr = messages.getMainMessage("dateFormat");
                } else if (metaProperty.getRange().asDatatype().equals(Datatypes.get(TimeDatatype.NAME))) {
                    formatStr = messages.getMainMessage("timeFormat");
                } else {
                    formatStr = messages.getMainMessage("dateTimeFormat");
                }
            } else {
                formatStr = messages.getMainMessage("dateTimeFormat");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
            value = dateFormat.format((Date) value);
        }
        jsonObject.add(context.getLocalizedPropertyName(property), context.serialize(value));
    }
}
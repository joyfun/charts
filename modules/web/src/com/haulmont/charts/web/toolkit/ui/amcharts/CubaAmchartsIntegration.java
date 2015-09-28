/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.haulmont.charts.gui.amcharts.model.Settings;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsIntegrationState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractExtension;
import com.vaadin.server.Extension;
import com.vaadin.ui.UI;

import java.util.*;

/**
 * @author artamonov
 * @version $Id$
 */
@JavaScript({"vaadin://resources/amcharts/amcharts-all.min.js",
        "vaadin://resources/amcharts/themes.min.js",
        "vaadin://resources/amcharts/exporting.min.js"})
public class CubaAmchartsIntegration extends AbstractExtension {

    private Settings settings;

    private Locale locale;

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
        applySettings();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void applySettings() {
        getState().version++;
    }

    public Map<String, String> getChartMessages(String localeCode) {
        if (getState(false).chartMessages == null) {
            return Collections.emptyMap();
        }

        String jsonLocaleMap = getState(false).chartMessages.get(localeCode);
        //noinspection unchecked
        Map<String, String> localeMap = new Gson().fromJson(jsonLocaleMap, Map.class);
        return Collections.unmodifiableMap(localeMap);
    }

    public void setChartMessages(String localeCode, Map<String, List<String>> localeMap) {
        if (getState(false).chartMessages == null) {
            getState().chartMessages = new HashMap<>();
        }

        JsonObject jsonLocaleMap = new JsonObject();
        for (Map.Entry<String, List<String>> localeEntry : localeMap.entrySet()) {
            JsonArray array = new JsonArray();
            for (String value : localeEntry.getValue()) {
                array.add(new JsonPrimitive(value));
            }
            jsonLocaleMap.add(localeEntry.getKey(), array);
        }

        getState().chartMessages.put(localeCode, jsonLocaleMap.toString());
    }

    public Map<String, String> getExportMessages(String localeCode) {
        if (getState(false).exportMessages == null) {
            return Collections.emptyMap();
        }

        String jsonLocaleMap = getState(false).exportMessages.get(localeCode);
        //noinspection unchecked
        Map<String, String> localeMap = new Gson().fromJson(jsonLocaleMap, Map.class);
        return Collections.unmodifiableMap(localeMap);
    }

    public void setExportMessages(String localeCode, Map<String, String> localeMap) {
        if (getState(false).exportMessages == null) {
            getState().exportMessages = new HashMap<>();
        }

        JsonObject jsonLocaleMap = new JsonObject();
        for (Map.Entry<String, String> localeEntry : localeMap.entrySet()) {
            jsonLocaleMap.addProperty(localeEntry.getKey(), localeEntry.getValue());
        }

        getState().exportMessages.put(localeCode, jsonLocaleMap.toString());
    }

    @Override
    protected CubaAmchartsIntegrationState getState() {
        return (CubaAmchartsIntegrationState) super.getState();
    }

    @Override
    protected CubaAmchartsIntegrationState getState(boolean markAsDirty) {
        return (CubaAmchartsIntegrationState) super.getState(markAsDirty);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);

        if (settings != null) {
            getState().json = settings.toString();
        }
    }

    public static CubaAmchartsIntegration get(UI ui) {
        CubaAmchartsIntegration optioner = null;

        // Search singleton optioner
        for (Extension extension : ui.getExtensions()) {
            if (extension instanceof CubaAmchartsIntegration) {
                optioner = (CubaAmchartsIntegration) extension;
                break;
            }
        }

        // Create new optioner if not found
        if (optioner == null) {
            optioner = new CubaAmchartsIntegration();
            optioner.extend(ui);
        }

        return optioner;

    }

    public static CubaAmchartsIntegration get() {
        UI ui = UI.getCurrent();

        if (ui == null) {
            throw new IllegalStateException(
                    "This method must be used from UI thread");
        }
        return get(ui);
    }
}
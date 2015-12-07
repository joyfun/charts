/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmStockChart JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/AmStockChart">http://docs.amcharts.com/3/javascriptstockchart/AmStockChart</a>
 *
 * @author gorelov
 * @version $Id$
 */
public class StockChartGroup extends AbstractChartObject
        implements HasColors<StockChartGroup> {

    private static final long serialVersionUID = -8514686195948609709L;

    private Boolean addClassNames;

    private Export export;

    private Boolean animationPlayed;

    private Boolean autoResize;

    private Balloon balloon;

    private CategoryAxesSettings categoryAxesSettings;

    private ChartCursorSettings chartCursorSettings;

    private ChartScrollbarSettings chartScrollbarSettings;

    private String classNamePrefix;

    private List<Color> colors;

    private List<String> comparedDataSets;

    private String dataDateFormat;

    private List<DataSet> dataSets;

    private DataSetSelector dataSetSelector;

    private Boolean extendToFullPeriod;

    private Integer firstDayOfWeek;

    private Boolean glueToTheEnd;

    private String language;

    private LegendSettings legendSettings;

    private String mainDataSet;

    private Boolean mouseWheelScrollEnabled;

    private List<StockPanel> panels;

    private PanelsSettings panelsSettings;

    private String path = "VAADIN/resources/amcharts/";

    private String pathToImages;

    private PeriodSelector periodSelector;

    private StockEventsSettings stockEventsSettings;

    private ChartTheme theme;

    private ChartType type = ChartType.STOCK;

    private ValueAxesSettings valueAxesSettings;

    private Boolean zoomOutOnDataSetChange;

    public Boolean getAddClassNames() {
        return addClassNames;
    }

    public StockChartGroup setAddClassNames(Boolean addClassNames) {
        this.addClassNames = addClassNames;
        return this;
    }

    public Export getExport() {
        return export;
    }

    public StockChartGroup setExport(Export export) {
        this.export = export;
        return this;
    }

    public Boolean getAnimationPlayed() {
        return animationPlayed;
    }

    public StockChartGroup setAnimationPlayed(Boolean animationPlayed) {
        this.animationPlayed = animationPlayed;
        return this;
    }

    public Boolean getAutoResize() {
        return autoResize;
    }

    public StockChartGroup setAutoResize(Boolean autoResize) {
        this.autoResize = autoResize;
        return this;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public StockChartGroup setBalloon(Balloon balloon) {
        this.balloon = balloon;
        return this;
    }

    public CategoryAxesSettings getCategoryAxesSettings() {
        return categoryAxesSettings;
    }

    public StockChartGroup setCategoryAxesSettings(CategoryAxesSettings categoryAxesSettings) {
        this.categoryAxesSettings = categoryAxesSettings;
        return this;
    }

    public ChartCursorSettings getChartCursorSettings() {
        return chartCursorSettings;
    }

    public StockChartGroup setChartCursorSettings(ChartCursorSettings chartCursorSettings) {
        this.chartCursorSettings = chartCursorSettings;
        return this;
    }

    public ChartScrollbarSettings getChartScrollbarSettings() {
        return chartScrollbarSettings;
    }

    public StockChartGroup setChartScrollbarSettings(ChartScrollbarSettings chartScrollbarSettings) {
        this.chartScrollbarSettings = chartScrollbarSettings;
        return this;
    }

    public String getClassNamePrefix() {
        return classNamePrefix;
    }

    public StockChartGroup setClassNamePrefix(String classNamePrefix) {
        this.classNamePrefix = classNamePrefix;
        return this;
    }

    @Override
    public List<Color> getColors() {
        return colors;
    }

    @Override
    public StockChartGroup setColors(List<Color> colors) {
        this.colors = colors;
        return this;
    }

    public List<String> getComparedDataSets() {
        return comparedDataSets;
    }

    public StockChartGroup setComparedDataSets(List<String> comparedDataSets) {
        this.comparedDataSets = comparedDataSets;
        return this;
    }

    public StockChartGroup addComparedDataSets(String... comparedDataSets) {
        if (comparedDataSets != null) {
            if (this.comparedDataSets == null) {
                this.comparedDataSets = new ArrayList<>();
            }
            this.comparedDataSets.addAll(Arrays.asList(comparedDataSets));
        }
        return this;
    }

    public String getDataDateFormat() {
        return dataDateFormat;
    }

    public StockChartGroup setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
        return this;
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public StockChartGroup setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
        return this;
    }

    public StockChartGroup addDataSets(DataSet... dataSets) {
        if (dataSets != null) {
            if (this.dataSets == null) {
                this.dataSets = new ArrayList<>();
            }
            this.dataSets.addAll(Arrays.asList(dataSets));
        }
        return this;
    }

    public DataSetSelector getDataSetSelector() {
        return dataSetSelector;
    }

    public StockChartGroup setDataSetSelector(DataSetSelector dataSetSelector) {
        this.dataSetSelector = dataSetSelector;
        return this;
    }

    public Boolean getExtendToFullPeriod() {
        return extendToFullPeriod;
    }

    public StockChartGroup setExtendToFullPeriod(Boolean extendToFullPeriod) {
        this.extendToFullPeriod = extendToFullPeriod;
        return this;
    }

    public Integer getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public StockChartGroup setFirstDayOfWeek(Integer firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
        return this;
    }

    public Boolean getGlueToTheEnd() {
        return glueToTheEnd;
    }

    public StockChartGroup setGlueToTheEnd(Boolean glueToTheEnd) {
        this.glueToTheEnd = glueToTheEnd;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public StockChartGroup setLanguage(String language) {
        this.language = language;
        return this;
    }

    public LegendSettings getLegendSettings() {
        return legendSettings;
    }

    public StockChartGroup setLegendSettings(LegendSettings legendSettings) {
        this.legendSettings = legendSettings;
        return this;
    }

    public String getMainDataSet() {
        return mainDataSet;
    }

    public StockChartGroup setMainDataSet(String mainDataSet) {
        this.mainDataSet = mainDataSet;
        return this;
    }

    public Boolean getMouseWheelScrollEnabled() {
        return mouseWheelScrollEnabled;
    }

    public StockChartGroup setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled) {
        this.mouseWheelScrollEnabled = mouseWheelScrollEnabled;
        return this;
    }

    public List<StockPanel> getPanels() {
        return panels;
    }

    public StockChartGroup setPanels(List<StockPanel> panels) {
        this.panels = panels;
        return this;
    }

    public StockChartGroup addPanels(StockPanel... panels) {
        if (panels != null) {
            if (this.panels == null) {
                this.panels = new ArrayList<>();
            }
            this.panels.addAll(Arrays.asList(panels));
        }
        return this;
    }

    public PanelsSettings getPanelsSettings() {
        return panelsSettings;
    }

    public StockChartGroup setPanelsSettings(PanelsSettings panelsSettings) {
        this.panelsSettings = panelsSettings;
        return this;
    }

    public String getPath() {
        return path;
    }

    public StockChartGroup setPath(String path) {
        this.path = path;
        return this;
    }

    public String getPathToImages() {
        return pathToImages;
    }

    public StockChartGroup setPathToImages(String pathToImages) {
        this.pathToImages = pathToImages;
        return this;
    }

    public PeriodSelector getPeriodSelector() {
        return periodSelector;
    }

    public StockChartGroup setPeriodSelector(PeriodSelector periodSelector) {
        this.periodSelector = periodSelector;
        return this;
    }

    public StockEventsSettings getStockEventsSettings() {
        return stockEventsSettings;
    }

    public StockChartGroup setStockEventsSettings(StockEventsSettings stockEventsSettings) {
        this.stockEventsSettings = stockEventsSettings;
        return this;
    }

    public ChartTheme getTheme() {
        return theme;
    }

    public StockChartGroup setTheme(ChartTheme theme) {
        this.theme = theme;
        return this;
    }

    public ValueAxesSettings getValueAxesSettings() {
        return valueAxesSettings;
    }

    public StockChartGroup setValueAxesSettings(ValueAxesSettings valueAxesSettings) {
        this.valueAxesSettings = valueAxesSettings;
        return this;
    }

    public Boolean getZoomOutOnDataSetChange() {
        return zoomOutOnDataSetChange;
    }

    public StockChartGroup setZoomOutOnDataSetChange(Boolean zoomOutOnDataSetChange) {
        this.zoomOutOnDataSetChange = zoomOutOnDataSetChange;
        return this;
    }

    public DataSet getDataSet(String id) {
        for (DataSet dataSet : dataSets) {
            if (id.equals(dataSet.getId())) {
                return dataSet;
            }
        }
        return null;
    }
}

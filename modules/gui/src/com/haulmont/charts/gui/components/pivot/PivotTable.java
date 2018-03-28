/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.pivot;

import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.pivottable.model.*;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.annotation.Nullable;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

public interface PivotTable extends Component, Component.BelongToFrame, Component.HasXmlDescriptor, Component.Editable {

    String NAME = "pivotTable";

    CollectionDatasource getDatasource();
    void setDatasource(CollectionDatasource datasource);

    /**
     * Resend all items and properties to client and repaint pivot table.
     * Use this method if you change some property of already displayed pivot table.
     */
    void repaint();

    /**
     * @return the map whose keys are {@link DataItem} property names to use as pivot table data
     * and values they localized names
     */
    Map<String, String> getProperties();

    /**
     * Sets the map whose keys are {@link DataItem} property names to use as pivot table data
     * and values they localized names.
     *
     * @param properties a map of properties names with localized values
     */
    void setProperties(Map<String, String> properties);

    /**
     * Adds a map whose keys are {@link DataItem} property names to use as pivot table data
     * and values they localized names.
     *
     * @param properties a map of properties names with localized values
     */
    void addProperties(Map<String, String> properties);

    /**
     * Add a property eith its localized value
     *
     * @param property property name
     * @param value    localized value
     */
    void addProperty(String property, String value);

    /**
     * @return the list of properties names to use as rows.
     */
    List<String> getRows();

    /**
     * Sets the list of properties names to use as rows.
     *
     * @param rows a list of properties names
     */
    void setRows(List<String> rows);

    /**
     * Adds an array of properties names to use as rows.
     *
     * @param rows an array of properties names
     */
    void addRows(String... rows);

    /**
     * @return the list of property names to use as columns.
     */
    List<String> getColumns();

    /**
     * Sets the list of property names to use as columns.
     *
     * @param cols a list of properties names
     */
    void setColumns(List<String> cols);

    /**
     * Adds an array of property names to use as columns.
     *
     * @param cols an array of properties names
     */
    void addColumns(String... cols);

    /**
     * @return the aggregation object which defines how pivot table
     * will aggregate results per cell
     */
    Aggregation getAggregation();

    /**
     * Sets the aggregation object.
     * <p>
     * Applies only when {@code editable=false}.
     *
     * @param aggregation an aggregation object
     */
    void setAggregation(Aggregation aggregation);

    /**
     * @return the renderer object which generates output from pivot data structure
     */
    Renderer getRenderer();

    /**
     * Sets the renderer object.
     * <p>
     * Applies only when {@code editable=false}.
     *
     * @param renderer a renderer object
     */
    void setRenderer(Renderer renderer);

    /**
     * @return the list of properties names to prepopulate
     * in vals area (gets passed to aggregator generating function)
     */
    List<String> getAggregationProperties();

    /**
     * Sets the list of properties names to prepopulate
     * in vals area (gets passed to aggregator generating function).
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param aggregationProperties a list of properties names
     */
    void setAggregationProperties(List<String> aggregationProperties);

    /**
     * Adds an array of properties names to prepopulate
     * in vals area (gets passed to aggregator generating function).
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param aggregationProperties an array of properties names
     */
    void addAggregationProperties(String... aggregationProperties);

    /**
     * @return the aggregations object which defines the collection of aggregations
     * to use in pivot table and additional settings for them.
     */
    Aggregations getAggregations();

    /**
     * Sets the aggregations object which defines the collection of aggregations
     * to use in pivot table and additional settings for them.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param aggregations an aggregations object
     */
    void setAggregations(Aggregations aggregations);

    /**
     * @return the renderers object which defines the collection of renderers to use
     * in pivot table and additional settings for them.
     */
    Renderers getRenderers();

    /**
     * Sets the renderers object which defines the collection of renderers to use
     * in pivot table and additional settings for them.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param renderers a renderers object
     */
    void setRenderers(Renderers renderers);

    /**
     * @return the list of properties names to omit from the UI
     */
    List<String> getHiddenProperties();

    /**
     * Sets the list of properties names to omit from the UI.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param hiddenProperties a list of properties names
     */
    void setHiddenProperties(List<String> hiddenProperties);

    /**
     * Adds an array of properties names to omit from the UI.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param hiddenProperties an array of properties names
     */
    void addHiddenProperties(String... hiddenProperties);

    /**
     * @return list of properties names to omit from the aggregation arguments dropdowns
     */
    List<String> getHiddenFromAggregations();

    /**
     * Sets the list of properties names to omit from the aggregation arguments dropdowns.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param hiddenFromAggregations a list of properties names
     */
    void setHiddenFromAggregations(List<String> hiddenFromAggregations);

    /**
     * Adds an array of properties names to omit from the aggregation arguments dropdowns.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param hiddenFromAggregations an array of properties names
     */
    void addHiddenFromAggregations(String... hiddenFromAggregations);

    /**
     * @return list of properties names to omit from the drag'n'drop portion of the UI
     */
    List<String> getHiddenFromDragDrop();

    /**
     * Sets the list of properties names to omit from the drag'n'drop portion of the UI.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param hiddenFromDragDrop a list of properties names
     */
    void setHiddenFromDragDrop(List<String> hiddenFromDragDrop);

    /**
     * Adds an array of properties names to omit from the drag'n'drop portion of the UI.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param hiddenFromDragDrop an array of properties names
     */
    void addHiddenFromDragDrop(String... hiddenFromDragDrop);

    /**
     * @return the order in which column data is provided to the renderer
     */
    ColumnOrder getColumnOrder();

    /**
     * Set the order in which column data is provided to the renderer.
     * <p>
     * Ordering by value orders by column total.
     *
     * @param columnOrder the order in which column data is provided to the renderer
     */
    void setColumnOrder(ColumnOrder columnOrder);

    /**
     * @return the order in which row data is provided to the renderer
     */
    RowOrder getRowOrder();

    /**
     * Sets the order in which row data is provided to the renderer.
     * <p>
     * Ordering by value orders by row total.
     *
     * @param rowOrder the order in which row data is provided to the renderer
     */
    void setRowOrder(RowOrder rowOrder);

    /**
     * @return maximum number of values to list in the double-click menu
     */
    Integer getMenuLimit();

    /**
     * Sets maximum number of values to list in the double-click menu.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param menuLimit maximum number of values to list in the double-click menu
     */
    void setMenuLimit(Integer menuLimit);

    /**
     * @return {@code true} if unused properties are kept sorted in the UI and {@code false} otherwise
     */
    Boolean getAutoSortUnusedProperties();

    /**
     * Controls whether or not unused properties are kept sorted in the UI.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @param autoSortUnusedProperties {@code true} if unused properties are
     *                                 kept sorted in the UI and {@code false} otherwise
     */
    void setAutoSortUnusedProperties(Boolean autoSortUnusedProperties);

    /**
     * @return {@code true} if unused attributes are shown always vertical,
     * {@code false} if always horizontal. If set to
     * a number (as is the default) then if the properties' names' combined
     * length in characters exceeds the number then the properties will be shown vertically.
     */
    UnusedPropertiesVertical getUnusedPropertiesVertical();

    /**
     * Controls whether or not unused properties are shown vertically
     * instead of the default which is horizontally. {@code true} means
     * always vertical, {@code false} means always horizontal. If set to
     * a number (as is the default) then if the properties' names' combined
     * length in characters exceeds the number then the properties will be shown vertically.
     * <p>
     * Applies only when {@code editable=true}.
     */
    void setUnusedPropertiesVertical(UnusedPropertiesVertical unusedPropertiesVertical);

    /**
     * @return data provider for PivotTable. Contains items which will be shown on PivotTable.
     */
    DataProvider getDataProvider();

    /**
     * Sets data provider for PivotTable. Contains items which will be shown on PivotTable.
     *
     * @param dataProvider a data provider
     */
    void setDataProvider(DataProvider dataProvider);

    /**
     * Adds a data item to data provider.
     *
     * @param dataItems a data item to add
     */
    void addData(DataItem... dataItems);

    /**
     * @return the {@link JsFunction} which defines a javascript code
     * called on each record, returns {@code false} if the record is to be
     * excluded from the input before rendering or {@code true} otherwise
     */
    JsFunction getFilterFunction();

    /**
     * Sets the {@link JsFunction} which defines a javascript code
     * called on each record, returns {@code false} if the record is to be
     * excluded from the input before rendering or {@code true} otherwise
     *
     * @param filter a {@link JsFunction} to use as a filter
     */
    void setFilterFunction(JsFunction filter);

    /**
     * @return the {@link JsFunction} which defines a javascript code
     * called with an property name and can return a function which can be used
     * as an argument to {@code Array.sort} for output purposes. If no function
     * is returned, the default sorting mechanism is a built-in "natural sort"
     * implementation. Useful for sorting attributes like month names
     */
    JsFunction getSortersFunction();

    /**
     * Sets the {@link JsFunction} which defines a javascript code
     * called with an property name and can return a function which can be used
     * as an argument to {@code Array.sort} for output purposes. If no function
     * is returned, the default sorting mechanism is a built-in "natural sort"
     * implementation. Useful for sorting attributes like month names
     *
     * @param sorters a {@link JsFunction} to use as a sorters
     */
    void setSortersFunction(JsFunction sorters);

    /**
     * @return the object passed through to renderer as options
     */
    RendererOptions getRendererOptions();

    /**
     * Sets object passed through to renderer as options.
     *
     * @param rendererOptions object defines renderer options
     */
    void setRendererOptions(RendererOptions rendererOptions);

    /**
     * @return map whose keys are properties names and values are lists of properties values
     * which denote records to include in rendering; used to prepopulate the filter menus
     * that appear on double-click
     */
    Map<String, List<String>> getInclusions();

    /**
     * Sets map whose keys are properties names and values are lists of properties values
     * which denote records to include in rendering; used to prepopulate the filter menus
     * that appear on double-click (overrides {@code exclusions}).
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @see #setInclusions(String, List)
     * @see #addInclusions(String, String...)
     * @see #setExclusions(Map)
     * @see #setExclusions(String, List)
     * @see #addExclusions(String, String...)
     */
    void setInclusions(Map<String, List<String>> inclusions);

    /**
     * Sets the value of inclusions map.
     *
     * @param property   property name
     * @param inclusions a list of properties values
     * @see #setInclusions(Map)
     * @see #addInclusions(String, String...)
     * @see #setExclusions(Map)
     * @see #setExclusions(String, List)
     * @see #addExclusions(String, String...)
     */
    void setInclusions(String property, List<String> inclusions);

    /**
     * Adds a values to given key of inclusions map.
     *
     * @param property   a property name
     * @param inclusions an array of properties values
     * @see #setInclusions(Map)
     * @see #setInclusions(String, List)
     * @see #setExclusions(Map)
     * @see #setExclusions(String, List)
     * @see #addExclusions(String, String...)
     */
    void addInclusions(String property, String... inclusions);

    /**
     * @return map whose keys are properties names and values are lists of properties values
     * which denote records to exclude from rendering; used to prepopulate the filter menus
     * that appear on double-click
     */
    Map<String, List<String>> getExclusions();

    /**
     * Sets map whose keys are properties names and values are lists of properties values
     * which denote records to exclude from rendering; used to prepopulate the filter menus
     * that appear on double-click.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @see #setExclusions(String, List)
     * @see #addExclusions(String, String...)
     * @see #setInclusions(Map)
     * @see #setInclusions(String, List)
     * @see #addInclusions(String, String...)
     */
    void setExclusions(Map<String, List<String>> exclusions);

    /**
     * Sets the value of exclusions map.
     *
     * @param property   property name
     * @param exclusions a list of properties values
     * @see #setExclusions(Map)
     * @see #addExclusions(String, String...)
     * @see #setInclusions(Map)
     * @see #setInclusions(String, List)
     * @see #addInclusions(String, String...)
     */
    void setExclusions(String property, List<String> exclusions);

    /**
     * Adds a values to given key of exclusions map.
     *
     * @param property   a property name
     * @param exclusions an array of properties values
     * @see #setExclusions(Map)
     * @see #setExclusions(String, List)
     * @see #setInclusions(Map)
     * @see #setInclusions(String, List)
     * @see #addInclusions(String, String...)
     */
    void addExclusions(String property, String... exclusions);

    /**
     * @return object to define derived properties
     */
    DerivedProperties getDerivedProperties();

    /**
     * Sets object to define derived properties.
     *
     * @param derivedProperties object to define derived properties
     */
    void setDerivedProperties(DerivedProperties derivedProperties);

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);

    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();

    /**
     * @return the message that will be displayed in case of empty data
     */
    String getEmptyDataMessage();

    /**
     * Sets the message that will be displayed in case of empty data.
     *
     * @param emptyDataMessage the message that will be displayed in case of empty data
     */
    void setEmptyDataMessage(String emptyDataMessage);

    void addRefreshListener(RefreshListener refreshListener);
    void removeRefreshListener(RefreshListener refreshListener);

    /**
     * Describes PivotTable refresh event.
     */
    class RefreshEvent extends EventObject {
        protected List<String> rows;
        protected List<String> cols;
        protected Renderer renderer;
        protected Aggregation aggregation;
        protected List<String> aggregationProperties;
        protected Map<String, List<String>> inclusions;
        protected Map<String, List<String>> exclusions;
        protected ColumnOrder columnOrder;
        protected RowOrder rowOrder;

        public RefreshEvent(PivotTable pivotTable,
                            List<String> rows, List<String> cols, Renderer renderer,
                            Aggregation aggregation, List<String> aggregationProperties,
                            Map<String, List<String>> inclusions, Map<String, List<String>> exclusions,
                            ColumnOrder columnOrder, RowOrder rowOrder) {
            super(pivotTable);
            this.rows = rows;
            this.cols = cols;
            this.renderer = renderer;
            this.aggregation = aggregation;
            this.aggregationProperties = aggregationProperties;
            this.inclusions = inclusions;
            this.exclusions = exclusions;
            this.columnOrder = columnOrder;
            this.rowOrder = rowOrder;
        }

        @Override
        public PivotTable getSource() {
            return (PivotTable) super.getSource();
        }

        /**
         * @return currently selected properties as rows
         */
        public List<String> getRows() {
            return rows;
        }

        /**
         * @return currently selected properties as columns
         */
        public List<String> getCols() {
            return cols;
        }

        /**
         * @return currently selected renderer, or null if not selected
         */
        @Nullable
        public Renderer getRenderer() {
            return renderer;
        }

        /**
         * @return currently selected aggregation, or null if not selected
         */
        @Nullable
        public Aggregation getAggregation() {
            return aggregation;
        }

        /**
         * @return currently selected aggregation properties, or empty if not selected
         */
        public List<String> getAggregationProperties() {
            return aggregationProperties;
        }

        /**
         * @return currently defined map whose keys are properties names and values are lists
         * of properties values which denote records to include in rendering; used to prepopulate
         * the filter menus that appear on double-click
         */
        public Map<String, List<String>> getInclusions() {
            return inclusions;
        }

        /**
         * @return currently defined map whose keys are properties names and values are lists
         * of properties values which denote records to exclude from rendering; used to prepopulate
         * the filter menus that appear on double-click
         */
        public Map<String, List<String>> getExclusions() {
            return exclusions;
        }

        /**
         * @return currently selected columns order
         */
        public ColumnOrder getColumnOrder() {
            return columnOrder;
        }

        /**
         * @return currently selected rows order
         */
        public RowOrder getRowOrder() {
            return rowOrder;
        }

        /**
         * @return source of event
         * @deprecated Use {@link #getSource()}
         */
        @Deprecated
        public PivotTable getPivotTable() {
            return getSource();
        }
    }

    /**
     * Listener to the pivot table refresh events. Fired only for editable PivotTable.
     */
    @FunctionalInterface
    interface RefreshListener {
        void onRefresh(RefreshEvent event);
    }

    /**
     * Adds a listener to the pivot table cell click events. Fired only for table
     * renderers (table, heatmap, table barchart, col heatmap, row heatmap).
     *
     * @param listener a listener to add
     */
    void addCellClickListener(CellClickListener listener);

    /**
     * @param listener a listener to remove
     */
    void removeCellClickListener(CellClickListener listener);

    /**
     * Describes PivotTable cell click event.
     */
    class CellClickEvent extends EventObject {

        protected Double value;
        protected Map<String, String> filters;

        public CellClickEvent(PivotTable pivotTable, Double value, Map<String, String> filters) {
            super(pivotTable);
            this.value = value;
            this.filters = filters;
        }

        @Override
        public PivotTable getSource() {
            return (PivotTable) super.getSource();
        }

        /**
         * @return value of the clicked cell
         */
        @Nullable
        public Double getValue() {
            return value;
        }

        /**
         * @return a map in which keys are localized property names used in columns or rows
         * and values are localized property values.
         */
        public Map<String, String> getFilters() {
            return filters;
        }
    }

    /**
     * Listener to the pivot table cell click events. Fired only for table
     * renderers (table, heatmap, table barchart, col heatmap, row heatmap).
     */
    @FunctionalInterface
    interface CellClickListener {
        void onCellClick(CellClickEvent event);
    }
}
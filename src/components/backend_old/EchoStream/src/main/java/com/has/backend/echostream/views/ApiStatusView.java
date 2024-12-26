package com.has.backend.echostream.views;

import com.has.backend.echostream.models.app.SystemLog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "api-status", layout = MainLayout.class)
public class ApiStatusView extends VerticalLayout {

    private final Grid<SystemLog> grid;

    public ApiStatusView() {
        grid = new Grid<>(SystemLog.class);
        grid.setColumns("timestamp", "httpMethod", "endpoint", "statusCode", "latency");
        grid.getColumnByKey("timestamp").setHeader("Timestamp");
        grid.getColumnByKey("httpMethod").setHeader("HTTP Method");
        grid.getColumnByKey("endpoint").setHeader("Endpoint");
        grid.getColumnByKey("statusCode").setHeader("Status Code");
        grid.getColumnByKey("latency").setHeader("Latency (ms)");

        add(grid);
    }
}

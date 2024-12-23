package com.has.backend.echostream.views;

import com.has.backend.echostream.models.app.SystemLog;
import com.has.backend.echostream.repos.app.SystemLogRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "logs", layout = MainLayout.class)
public class LogView extends VerticalLayout {

    private final SystemLogRepository systemLogRepository;
    private final Grid<SystemLog> grid;

    public LogView(SystemLogRepository systemLogRepository) {
        this.systemLogRepository = systemLogRepository;
        this.grid = new Grid<>(SystemLog.class);

        grid.setColumns("timestamp", "logLevel", "message");
        grid.getColumnByKey("timestamp").setHeader("Timestamp");
        grid.getColumnByKey("logLevel").setHeader("Log Level");
        grid.getColumnByKey("message").setHeader("Message");

        loadLogs();
        add(grid);
    }

    private void loadLogs() {
        grid.setItems(systemLogRepository.findAll());
    }
}

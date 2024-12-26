package com.has.backend.echostream.views;

import com.has.backend.echostream.models.Configuration;
import com.has.backend.echostream.repos.ConfigurationRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "configurations", layout = MainLayout.class)
public class ConfigurationView extends VerticalLayout {

    private final ConfigurationRepository configurationRepository;
    private final Grid<Configuration> grid;

    public ConfigurationView(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
        this.grid = new Grid<>(Configuration.class);

        grid.setColumns("key", "value");
        grid.getColumnByKey("key").setHeader("Key");
        grid.getColumnByKey("value").setHeader("Value");

        loadConfigurations();

        TextField keyField = new TextField("Key");
        TextField valueField = new TextField("Value");
        Button saveButton = new Button("Save", event -> saveConfiguration(keyField, valueField));

        add(grid, keyField, valueField, saveButton);
    }

    private void loadConfigurations() {
        grid.setItems(configurationRepository.findAll());
    }

    private void saveConfiguration(TextField keyField, TextField valueField) {
        Configuration config = new Configuration();
        config.setKey(keyField.getValue());
        config.setValue(valueField.getValue());
        configurationRepository.save(config);
        Notification.show("Configuration saved");
        loadConfigurations();
    }
}

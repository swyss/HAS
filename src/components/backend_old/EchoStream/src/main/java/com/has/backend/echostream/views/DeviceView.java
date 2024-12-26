package com.has.backend.echostream.views;

import com.has.backend.echostream.models.Device;
import com.has.backend.echostream.repos.DeviceRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "devices", layout = MainLayout.class)
public class DeviceView extends VerticalLayout {

    private final DeviceRepository deviceRepository;
    private final Grid<Device> grid;

    public DeviceView(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
        this.grid = new Grid<>(Device.class);

        grid.setColumns("id", "name", "type", "status", "location");
        grid.getColumnByKey("name").setHeader("Name");
        grid.getColumnByKey("type").setHeader("Type");
        grid.getColumnByKey("status").setHeader("Status");
        grid.getColumnByKey("location").setHeader("Location");

        loadDevices();

        TextField nameField = new TextField("Name");
        TextField typeField = new TextField("Type");
        Button addButton = new Button("Add Device", event -> addDevice(nameField, typeField));

        add(grid, nameField, typeField, addButton);
    }

    private void loadDevices() {
        grid.setItems(deviceRepository.findAll());
    }

    private void addDevice(TextField nameField, TextField typeField) {
        Device device = new Device();
        device.setName(nameField.getValue());
        device.setType(typeField.getValue());
        deviceRepository.save(device);
        Notification.show("Device added");
        loadDevices();
    }
}

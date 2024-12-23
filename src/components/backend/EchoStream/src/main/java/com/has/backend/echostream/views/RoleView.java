package com.has.backend.echostream.views;

import com.has.backend.echostream.models.Role;
import com.has.backend.echostream.repos.RoleRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "roles", layout = MainLayout.class)
public class RoleView extends VerticalLayout {

    private final RoleRepository roleRepository;
    private final Grid<Role> grid;

    public RoleView(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.grid = new Grid<>(Role.class);

        grid.setColumns("id", "name");
        grid.getColumnByKey("name").setHeader("Role Name");

        loadRoles();

        TextField roleNameField = new TextField("Role Name");
        Button addButton = new Button("Add Role", event -> addRole(roleNameField));

        add(grid, roleNameField, addButton);
    }

    private void loadRoles() {
        grid.setItems(roleRepository.findAll());
    }

    private void addRole(TextField roleNameField) {
        String roleName = roleNameField.getValue();
        if (!roleName.isEmpty() && roleRepository.findByName(roleName) == null) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
            Notification.show("Role added");
            loadRoles();
        } else {
            Notification.show("Role already exists or is invalid");
        }
    }
}

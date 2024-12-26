package com.has.backend.echostream.views;

import com.has.backend.echostream.models.User;
import com.has.backend.echostream.repos.UserRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "users", layout = MainLayout.class)
public class UserView extends VerticalLayout {

    private final UserRepository userRepository;
    private final Grid<User> grid;

    public UserView(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.grid = new Grid<>(User.class);

        grid.setColumns("id", "username", "role");
        grid.getColumnByKey("username").setHeader("Username");
        grid.getColumnByKey("role").setHeader("Role");

        loadUsers();

        TextField usernameField = new TextField("Username");
        TextField roleField = new TextField("Role");
        Button addButton = new Button("Add User", event -> addUser(usernameField, roleField));

        add(grid, usernameField, roleField, addButton);
    }

    private void loadUsers() {
        grid.setItems(userRepository.findAll());
    }

    private void addUser(TextField usernameField, TextField roleField) {
        User user = new User();
        user.setUsername(usernameField.getValue());
        user.setRole(roleField.getValue());
        userRepository.save(user);
        Notification.show("User added");
        loadUsers();
    }
}

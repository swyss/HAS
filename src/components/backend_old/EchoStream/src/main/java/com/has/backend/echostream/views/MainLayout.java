package com.has.backend.echostream.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 title = new H1("HAS Admin Console");
        title.addClassNames("text-l", "m-m");

        HorizontalLayout header = new HorizontalLayout(title);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

    private void createDrawer() {
        VerticalLayout navigation = new VerticalLayout(
                new RouterLink("API Status", ApiStatusView.class),
                new RouterLink("Configuration", ConfigurationView.class),
                new RouterLink("Devices", DeviceView.class),
                new RouterLink("Logs", LogView.class),
                new RouterLink("Users", UserView.class),
                new RouterLink("Roles", RoleView.class) // New RoleView link
        );
        addToDrawer(navigation);
    }
}

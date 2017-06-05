package com.liftuz.demovaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by RawinNgamloet on 6/5/2017.
 */
@SpringUI
@Theme("valo")
public class MainUI extends UI {

    private VerticalLayout layout;

    @Autowired
    private TodoList todoList;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        addTodo();
        addAction();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("TODO");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        layout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setSpacing(true);
        formLayout.setWidth("80%");

        TextField taskField = new TextField();
        taskField.setWidth("100%");
        Button addButton = new Button();
        addButton.setIcon(FontAwesome.PLUS);
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        formLayout.addComponents(taskField, addButton);
        formLayout.setExpandRatio(taskField, 1);
        layout.addComponent(formLayout);

        addButton.addClickListener( click -> {
           todoList.add(new Todo(taskField.getValue()));
           taskField.clear();
           taskField.focus();
        });

        taskField.focus();

        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addTodo() {
        todoList.setWidth("80%");
        layout.addComponent(todoList);
    }

    private void addAction() {
        Button deleteButton = new Button("Delete completed");
        layout.addComponent(deleteButton);
    }
}

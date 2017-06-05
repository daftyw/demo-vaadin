package com.liftuz.demovaadin;

import com.vaadin.data.Binder;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;

/**
 * Created by RawinNgamloet on 6/5/2017.
 */
public class TodoLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;

    public TodoLayout(Todo t, TodoChangedListener listener) {
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setWidth("100%");

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bind(text, "text");
        binder.bind(done, "done");

        addComponents(done, text);
        setExpandRatio(text, 1);

        binder.readBean(t);

        Arrays.asList(text, done).forEach( c -> {
            c.addValueChangeListener( cl -> {
                listener.todoChanged(t);
            });
        });
    }
}

package com.erixrivas.vaadinplayground.views.helloworld;

import com.erixrivas.vaadinplayground.components.ColorPickerElement;
import com.erixrivas.vaadinplayground.components.HelloWorld;
import com.erixrivas.vaadinplayground.components.PaperToggleButtonElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.erixrivas.vaadinplayground.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.Lumo;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public HelloWorldView() {
        addClassName("hello-world-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });


        HelloWorld hello = new HelloWorld();
        PaperToggleButtonElement paperToggleButtonElement = new PaperToggleButtonElement();
        ColorPickerElement colorPickerElement = new ColorPickerElement();
        paperToggleButtonElement.addToggleChangeEventlistener(e->this.toggleClick(e));
        Div layout = new Div();
        layout.add(hello,paperToggleButtonElement,colorPickerElement);

        add(layout);

    }
    private void toggleClick(PaperToggleButtonElement.ToggleChangeEvent e) {
        // Called from the template click handler
       System.out.println(e.getSource());
        PaperToggleButtonElement   source=e.getSource();

        System.out.println(e.getSource().getValue());

      /*System.out.println("valor de value toggleClick "+ value);
        if ( getValue()) {
            System.out.println("va en negro toggleClick");
        } else {
            System.out.println("va en blanco toggleClick");
        }*/
        ThemeList themeList = UI.getCurrent().getElement().getThemeList(); //

        if (themeList.contains(Lumo.DARK)) { //

            themeList.remove(Lumo.DARK);
            //toggleButton.setText("Toggle dark theme");
        } else {
            themeList.add(Lumo.DARK);
            //toggleButton.setText("Toggle  light theme");
        }

    }
}

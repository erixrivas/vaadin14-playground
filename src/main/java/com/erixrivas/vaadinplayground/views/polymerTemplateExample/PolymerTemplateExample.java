package com.erixrivas.vaadinplayground.views.polymerTemplateExample;

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
import com.wontlost.zxing.Constants;
import com.wontlost.zxing.ZXingVaadinReader;

@Route(value = "hello", layout = MainView.class)
@PageTitle("POLYMER ELEMENT EXAMPLE")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class PolymerTemplateExample extends HorizontalLayout {


    public PolymerTemplateExample() {
        addClassName("hello-world-view");
       
//        ZXingVaadinReader zXingVaadin = new ZXingVaadinReader();
//        zXingVaadin.setFrom(Constants.From.camera);
//        zXingVaadin.setId("video"); //id needs to be 'video' if From.camera.
//        zXingVaadin.setWidth("350");
//        zXingVaadin.setStyle("border : 1px solid gray");
//        zXingVaadin.addValueChangeListener(e->{
//            System.out.println("=QR=:"+e.getValue());
//        });

        //add(name, sayHello);
      

      //  HelloWorld hello = new HelloWorld();

        ColorPickerElement colorPickerElement = new ColorPickerElement();
        PaperToggleButtonElement paperToggleButtonElement = new PaperToggleButtonElement();
        paperToggleButtonElement.addToggleChangeEventlistener(e->this.toggleClick(e));
        Div layout = new Div();
        layout.add(paperToggleButtonElement,colorPickerElement);

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

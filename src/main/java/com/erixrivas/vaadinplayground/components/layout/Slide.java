package com.erixrivas.vaadinplayground.components.layout;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
@CssImport("./styles/views/layouting/slide.css")
public class Slide extends FlexLayout {
    private Div Info= new Div();
    private Div Code=new Div();

    public Slide() {

        add(Info,Code);

    }

    public Slide(Div info, Div code) {
        //setFlexWrap(FlexWrap.WRAP_REVERSE);
        Info = info;
        Code = code;
        info.setWidth("40%");
        info.setClassName("text-div");
        Code.setClassName("text-div");
        Code.setWidth("40%");
        add(Info,Code);
        addClassName("slide");
        //setAlignItems(FlexComponent.Alignment.STRETCH);
       // setFlexWrap(FlexWrap.WRAP_REVERSE);
       setJustifyContentMode(JustifyContentMode.EVENLY);
    }

    public Div getInfo() {
        return Info;
    }

    public void setInfo(Div info) {
        Info = info;
    }

    public Div getCode() {
        return Code;
    }

    public void setCode(Div code) {
        Code = code;
    }
}


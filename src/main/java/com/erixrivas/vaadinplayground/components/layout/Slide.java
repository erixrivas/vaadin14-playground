package com.erixrivas.vaadinplayground.components.layout;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import org.apache.commons.codec.digest.MurmurHash3;

@CssImport("./styles/views/layouting/slide.css")
public class Slide extends Div {
    private H3 title = new H3();
    private FlexLayout containWrapper= new FlexLayout();
    private Div Info= new Div();
    private Div Code=new Div();

    public Slide() {

        add(Info,Code);

    }

    public Slide(String title,Div info, Div code) {
        //setFlexWrap(FlexWrap.WRAP_REVERSE);
        this.title.setText(title);
        Info = info;
        Code = code;
        info.setWidth("40%");
        info.setClassName("text-div");
        Code.setClassName("text-div");
        Code.setWidth("40%");
        containWrapper.add(Info,Code);
        containWrapper.addClassName("slide");
        //setAlignItems(FlexComponent.Alignment.STRETCH);
       // setFlexWrap(FlexWrap.WRAP_REVERSE);
        containWrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        containWrapper.expand(info);
        containWrapper.expand(code);
        add( this.title,containWrapper);
        setClassName( "slide-div");

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


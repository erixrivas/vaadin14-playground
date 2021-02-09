package com.erixrivas.vaadinplayground.components;

import com.erixrivas.vaadinplayground.components.model.ColorPickerElementModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.Element;
import elemental.json.JsonObject;

@Tag("color-picker-element")
@NpmPackage(value = "@polymer/paper-input", version = "3.0.2")
@JsModule("./src/color-picker-element.js")
public class ColorPickerElement extends PolymerTemplate<ColorPickerElementModel> {

    @Id("red")
    private Element red;

    @Id("green")
    private Element green;


    @Id("blue")
    private Element blue;


    @Id("divColor")
    private Div divColor;

    public ColorPickerElement() {
        setId("template");
        getModel().setRedColor(0.0);
        getModel().setBlueColor(0.0);
        getModel().setGreenColor(0.0);
        getModel().setGrbColor("rgb(0,0,0)");

        red.addEventListener("value-change",e->updateColor(e));
        green.addEventListener("value-change",e->updateColor(e));
        blue.addEventListener("value-change",e->updateColor(e));

    }

    private void updateColor(DomEvent event) {
        JsonObject eventData = event.getEventData();

        getModel().setGrbColor("rgb("+getModel().getRedColor().intValue()+","+getModel().getGreenColor().intValue()+","+getModel().getBlueColor().intValue()+")");
        divColor.getElement().getStyle().set("background-color",  getModel().getGrbColor());

    }

}

//
//helloButton.addEventListener("click", this::handleClick)
//        .addEventData("event.shiftKey")
//        .addEventData("element.offsetWidth");
//
//private void handleClick(DomEvent event) {
//        JsonObject eventData = event.getEventData();
//        boolean shiftKey = eventData
//        .getBoolean("event.shiftKey");
//        double width = eventData
//        .getNumber("element.offsetWidth");
//
//        String text = "Shift " + (shiftKey ? "down" : "up");
//        text += " on button whose width is " + width + "px";
//
//        Element response = ElementFactory.createDiv(text);
//        getElement().appendChild(response);
//        }
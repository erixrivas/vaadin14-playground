package com.erixrivas.vaadinplayground.components;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Tag("paper-toggle-button-element")
@NpmPackage(value = "@polymer/paper-input", version = "3.0.2")
@JsModule("./src/paper-toggle-button-element.js")
public class PaperToggleButtonElement extends AbstractSinglePropertyField<PaperToggleButtonElement, Boolean> {
    public PaperToggleButtonElement(){


        super("checked", false, false);
        setId("template");
       // addListener ( ToggleChangeEvent.class,e->this.toggleShow() );


    }
    public void addToggleChangeEventlistener( ComponentEventListener<ToggleChangeEvent> listener){

        addListener ( ToggleChangeEvent.class,listener );
    }
    @EventHandler
    private void change() {
        // Called from the template click handler
        Boolean value = getValue();
        System.out.println("valor de value change"+ value);
        if ( getValue()) {
            System.out.println("va en negro change");
        } else {
            System.out.println("va en blanco change");
        }
    }
    @EventHandler
    private void toggleShow() {
        // Called from the template click handler
        Boolean value = getValue();
        System.out.println("valor de value toggleShow "+ value);
        if ( getValue()) {
            System.out.println("va en negro toggleShow");
        } else {
            System.out.println("va en blanco toggleShow");
        }
    }

    @EventHandler
    private void toggleClick() {
        // Called from the template click handler
        Boolean value = getValue();
        System.out.println("valor de value toggleClick "+ value);
        if ( getValue()) {
            System.out.println("va en negro toggleClick");
        } else {
            System.out.println("va en blanco toggleClick");
        }
    }


@DomEvent("change")
static public class ToggleChangeEvent
        extends ComponentEvent<PaperToggleButtonElement> {

    public ToggleChangeEvent(PaperToggleButtonElement source, boolean fromClient) {
        super(source, true);

    }


}
}

//
//
//public class PaperToggleButton extends Component implements HasStyle {
//
//    private Label captionLabel;
//
//    public PaperToggleButton() {
//        getElement().synchronizeProperty("checked", "change");
//    }
//
//    public PaperToggleButton(String caption) {
//        this();
//        setCaption(caption);
//    }
//
//    public PaperToggleButton(String caption,
//            ComponentEventListener<ToggleChangeEvent> listener) {
//        this(caption);
//        addChangeListener(listener);
//    }
//
//    /**
//     * Adds a listener that is notified when toggle state changes due to user
//     * interaction
//     */
//public Registration addChangeListener(
//        ComponentEventListener<ToggleChangeEvent> listener) {
//    return addListener(ToggleChangeEvent.class, listener);
//}
//
//    /**
//     * Sets the caption for the toggle component
//     */
//    public void setCaption(final String caption) {
//        getElement().removeAllChildren();
//        captionLabel = new Label(Objects.toString(caption, ""));
//        getElement().appendChild(captionLabel.getElement());
//    }
//
//    /**
//     * Returns the caption of the toggle component
//     */
//    public String getCaption() {
//        return captionLabel.getText();
//    }
//
//    /**
//     * Toggle the state of the component
//     */
//    public void toggle() {
//        getElement().setProperty("checked", !getToggleState());
//    }
//
//    /**
//     * Returns the state of the toggle component: true if toggle is in active
//     * state, otherwise false
//     */
//    public boolean getToggleState() {
//        return new Boolean(getElement().getProperty("checked"));
//    }
//
//    /**
//     * Sets the state of the toggle component
//     */
//    public void setToggleState(boolean state) {
//        getElement().setProperty("checked", state);
//    }
//
//@DomEvent("change")
//static public class ToggleChangeEvent
//        extends ComponentEvent<PaperToggleButton> {
//    private boolean checked = false;
//
//    public ToggleChangeEvent(PaperToggleButton source, boolean fromClient) {
//        super(source, true);
//        checked = source.getToggleState();
//    }
//
//    public boolean getToggleState() {
//        return checked;
//    }
//}
//}

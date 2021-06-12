package com.erixrivas.vaadinplayground.views.layout;

import com.erixrivas.vaadinplayground.components.layout.Slide;
import com.erixrivas.vaadinplayground.views.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Route(value = "Layouting", layout = MainView.class)
@CssImport("./styles/views/layouting/slide.css")
@PageTitle("Layouting")
//@CssImport("./styles/views/helloworld/hello-world-view.css")
//@RouteAlias(value = "", layout = MainView.class)
public class Layouting extends VerticalLayout {
        private List<Slide> horizontalLayouts = new ArrayList<>();
        private List<Slide> verticalLayouts = new ArrayList<>();
        private List<Slide> formLayouts = new ArrayList<>();
        private List<Slide> flexLayouts =new ArrayList<>();

    public Layouting() {
        drawHorizontalLayout();
        drawVerticalLayout();
        drawFormLayout();
        drawFlexLayouts();


        flexLayouts.forEach(slide->add(slide));
        formLayouts.forEach(slide->add(slide));
        //add(horizontalLayouts.,verticalLayouts,flexLayouts,formLayouts);


    }

    private void drawFlexLayouts() {
        /*flex-direction
flex-direction is a CSS property
that applies to the container.*/
        drawFlexDirection();
        drawFlexDivJustifyContentMode();
        drawFlexDivAlignmentContentMode();

    }

    private void drawFlexDivAlignmentContentMode() {
        Html htmlFlexDirection = new Html("<div>"+"Alignment\n" +
                "\n" +
                "align-items determines how the items are positioned on the secondary axis.\n" +
                "\n" +
                "For a horizontal layout, it’s the vertical axis For a vertical layout, it’s the horizontal axis.\n" +
                "\n" +
                "\n" +
                "flex-start: Items are positioned at the start of the secondary axis.\n" +
                "flex-end: Items are positioned at the end of the secondary axis.\n" +
                "align-items: flex-end center: Items are positioned at the center of the secondary axis.\n" +
                "\n" +
                "flex-baseline: Items are aligned on the baseline.\n" +
                "align-items: baseline flex-stretch: Items are stretched across the whole secondary axis.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Also possible to align an individual item differently with align-item align-item: flex-end (item 2)\n" +
                "\n" +
                "There is a Alignment enum and a Java API for doing the alignment on the secondary axis\n" +
                "//For the container, to align all the items\n" +
                "layout.setAlignItems(FlexComponent.Alignment.BASELINE);\n" +
                "layout.setAlignItems(FlexComponent.Alignment.CENTER);\n" +
                "layout.setAlignItems(FlexComponent.Alignment.END);\n" +
                "layout.setAlignItems(FlexComponent.Alignment.START);\n" +
                "layout.setAlignItems(FlexComponent.Alignment.STRETCH);"+"</div>");
        Div  divFlexAlignment = new Div();
        setDivAlignmentContentModeContent(divFlexAlignment);
        flexLayouts.add(new Slide("FlexDivAlignmentContentMode",new Div(htmlFlexDirection),divFlexAlignment));

    }

    private void setDivAlignmentContentModeContent(Div divFlexAlignment) {

        Stream.of(FlexComponent.Alignment.values()).forEach(
                mode->{

                    FlexLayout flexLayout = generateFlexLayoutWithLabel1to3DistinctWithAndHeight();
                    flexLayout.setAlignItems(mode);
                    divFlexAlignment.add(new H2("FLex align-items:" +mode),flexLayout);
                }
        );
        FlexLayout flexLayout = generateFlexLayoutWithLabel1to3DistinctWithAndHeight();
        //Also possible to align an individual item differently with align-item align-item: flex-end (item 2);
        List components= flexLayout.getChildren().collect(Collectors.toList());
        Label label1 = (Label) components.get(0);
        Label label2 = (Label) components.get(1);
        Label label3 = (Label) components.get(2);
        label1.getStyle().set("align-self", "flex-start");
        label2.getStyle().set("align-self", "center");
        label3.getStyle().set("align-self", "flex-end");
        flexLayout.setHeight("10em");
        divFlexAlignment.add(new H2("FLex align-items:" + "item differently" ),flexLayout);
    }

    private FlexLayout generateFlexLayoutWithLabel1to3DistinctWithAndHeight() {
        Label label1 = new Label("1");
        Label label2 = new Label("2");
        Label label3 = new Label("3");
        label1.setClassName("flex-label");
        label2.setClassName("flex-label");
        label3.setClassName("flex-label");
        label2.setWidth("3em");

        label1.setHeight("2em");
        label2.setHeight("1.5em");
        label3.setWidth("3em");
        FlexLayout flex = new FlexLayout(label1, label2, label3);
        flex.setHeight("5em");
        flex.setClassName("flex-layout");
        return  flex   ;
    }

    public void drawFlexDivJustifyContentMode(){
       String text="Alignment on the primary axis\n" +
                "\n" +
                "flex-start: Default value. Items are positioned at the beginning of the primary axis.\n" +
                "flex-end: Items are positioned at the end of the primary axis.\n" +
                "justify-content: flex-end center: Items are positioned at the center of the primary axis.\n" +
                "space-between: items are evenlydistributed in the primary axis; the first item is on the start line,\n " +
                "the lastitem on the end line.\n" +
                "space-around: items are evenly distributed in the primary axis with equal space around them.\n" +
                "space-evenly: items are distributed so that the spacing between any two items (and the space to the edges)\n" +
                " is equal.\n" +
                "There is a JustifyContentMode enum and a Java API for doing the alignment on the primary axis \n" +
                "layout.setJustifyContentMode(FlexComponent.JustifyContentMode.AROUND);\n" +
                "layout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);\n" +
                "layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);\n" +
                "layout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);\n" +
                "layout.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);\n" +
                "layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);\n";
        Html htmlFlexDirection = new Html("<div>"+text+"</div>");
        Div  divFlexAlignment = new Div();
        setDivJustifyContentModeContent(divFlexAlignment);

        //flexLayouts.add(new Slide("FlexDirection",new Div(htmlFlexDirection),divFlexDirection));
        flexLayouts.add(new Slide("FlexDivJustifyContentMode",new Div(htmlFlexDirection),divFlexAlignment));

    }

    private void setDivJustifyContentModeContent(Div divFlexAlignment) {

        Stream.of(FlexComponent.JustifyContentMode.values()).forEach(
               mode->{

                   FlexLayout flexLayout = generateFlexLayoutWithLabel1to3Distinct();
                   flexLayout.setJustifyContentMode(mode);
                //   flexLayout.setClassName("flex-layout");
                   divFlexAlignment.add(new H2("FLex justify-content:" +mode),flexLayout);
               }
        );

    }

    public void drawFlexDirection(){
        Html htmlFlexDirection = new Html("<div>"+"flex-direction\n" +
                "flex-direction is a CSS property\n" +
                "that applies to the container." +
                "For older versions, can use Element API\n" +
                "flexLayout.getStyle().set(\"flex-direction\", \"row\");\n" +
                "flexLayout.getStyle().set(\"flex-direction\", \"row-reverse\");\n" +
                "flexLayout.getStyle().set(\"flex-direction\", \"column\");\n" +
                "flexLayout.getStyle().set(\"flex-direction\", \"column-reverse\");" +
                "There is a FlexDirection enum and a Java API for setting the flex-direction of a FlexLayout since 14.1\n" +
                "flexLayout.setFlexDirection(FlexDirection.ROW);\n" +
                "flexLayout.setFlexDirection(FlexDirection.ROW_REVERSE);\n" +
                "flexLayout.setFlexDirection(FlexDirection.COLUMN);\n" +
                "flexLayout.setFlexDirection(FlexDirection.COLUMN_REVERSE);"+"</div>");
        Div  divFlexDirection = new Div();


        FlexLayout flexLayoutDirectionRow = generateFlexLayoutWithLabel1to3Equals();
        flexLayoutDirectionRow.setFlexDirection(FlexLayout.FlexDirection.ROW);

        FlexLayout flexLayoutDirectionRowReverse = generateFlexLayoutWithLabel1to3Equals();
        flexLayoutDirectionRowReverse.setFlexDirection(FlexLayout.FlexDirection.ROW_REVERSE);


        FlexLayout flexLayoutDirectionColumn = generateFlexLayoutWithLabel1to3Equals();
        flexLayoutDirectionColumn.setFlexDirection(FlexLayout.FlexDirection.COLUMN );

        FlexLayout flexLayoutDirectionColumnReverse = generateFlexLayoutWithLabel1to3Equals();
        flexLayoutDirectionColumnReverse.setFlexDirection(FlexLayout.FlexDirection.COLUMN_REVERSE);


        Div wrapperDiv=new Div(new H3("FLex Direction: Column"),flexLayoutDirectionColumn);
        //wrapperDiv.setClassName("flex-layout");
        wrapperDiv.setWidth("50%");
        Div wrapperDiv2=new Div(new H3("FLex Direction: Column-Reverse"), flexLayoutDirectionColumnReverse);
        //wrapperDiv2.setClassName("flex-layout");
        wrapperDiv.setWidth("50%");

        divFlexDirection.add(new H2("FLex Direction: Row"),flexLayoutDirectionRow,
                new H2("FLex Direction: Reverse-Row"),flexLayoutDirectionRowReverse,
                new FlexLayout(wrapperDiv,wrapperDiv2)
        );
        flexLayouts.add(new Slide("FlexDirection",new Div(htmlFlexDirection),divFlexDirection));

    }
    public FlexLayout generateFlexLayoutWithLabel1to3Equals(){
        Label label1 = new Label("1");
        Label label2 = new Label("2");
        Label label3 = new Label("3");
        label1.setClassName("flex-label");
        label2.setClassName("flex-label");
        label3.setClassName("flex-label");
        FlexLayout flex = new FlexLayout(label1, label2, label3);
        flex.setClassName("flex-layout");
        return  flex   ;
    }
    public FlexLayout generateFlexLayoutWithLabel1to3Distinct(){
        Label label1 = new Label("1");
        Label label2 = new Label("2");
        Label label3 = new Label("3");
        label1.setClassName("flex-label");
        label2.setClassName("flex-label");
        label3.setClassName("flex-label");
        label2.setWidth("3em");
        FlexLayout flex = new FlexLayout(label1, label2, label3);
        flex.setClassName("flex-layout");
        return  flex   ;
    }

    private void drawFormLayout() {

        drawFormLayoutBasicInfo();

    }

    private void drawFormLayoutBasicInfo() {

        Html htmlFormLayout= new Html("<div>htmlFormLayout </div>");

        Div divFormLayout = new Div();
        FormLayout formLayout = createBasicFormLayout();
        divFormLayout.add(formLayout);



        formLayouts.add(new Slide("FlexDirection",new Div(htmlFormLayout),divFormLayout));
    }

    private FormLayout createBasicFormLayout() {
        FormLayout formLayout = new FormLayout();
        TextField firstName= new TextField();
        TextField lastName= new TextField();
        TextField email= new TextField();
        DatePicker date = new DatePicker();
        formLayout.addFormItem(firstName,"First Name");
        formLayout.addFormItem(lastName,"First Name");
        formLayout.addFormItem(date,"Date");
        formLayout.addFormItem(email,"Email");
        formLayout.setWidthFull();
        return  formLayout;

    }

    private void drawVerticalLayout() {
    }

    private void drawHorizontalLayout() {
    }


}

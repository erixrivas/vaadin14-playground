package com.erixrivas.vaadinplayground.components.model;

import com.vaadin.flow.templatemodel.TemplateModel;

public interface ColorPickerElementModel extends TemplateModel {

    public Double getRedColor();
    public Double getGreenColor();
    public  Double getBlueColor();
    public void setRedColor(Double redColor);
    public void setGreenColor(Double greenColor);
    public  void setBlueColor(Double blueColor);
    public  String getGrbColor();
    public  void   setGrbColor(String GrbColor);



}

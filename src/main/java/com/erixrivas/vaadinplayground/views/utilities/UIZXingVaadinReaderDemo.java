package com.erixrivas.vaadinplayground.views.utilities;

import com.erixrivas.vaadinplayground.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.wontlost.zxing.Constants;
import com.wontlost.zxing.ZXingVaadinReader;
import sk.smartbase.component.barcodescanner.BarcodeScanner;
import sk.smartbase.component.barcodescanner.DecoderEnum;

@Route(value = "ZXingVaadinReaderDemo", layout = MainView.class)
//@CssImport("./styles/views/layouting/slide.css")
@PageTitle("ZXingVaadinReaderDemo")
public class UIZXingVaadinReaderDemo extends VerticalLayout {


    public UIZXingVaadinReaderDemo() {
        Label label = new Label("the QR value is:");
        ZXingVaadinReader zXingVaadin = new ZXingVaadinReader();
        zXingVaadin.setFrom(Constants.From.camera);
        zXingVaadin.setId("video"); //id needs to be 'video' if From.camera.
        zXingVaadin.setWidth("350");
        zXingVaadin.setStyle("border : 1px solid gray");
        zXingVaadin.addValueChangeListener(e->{
            System.out.println("=QR=:"+e.getValue());
            label.setText("the QR value is:"+e.getValue());
        });

    add(zXingVaadin,label);





    }
}

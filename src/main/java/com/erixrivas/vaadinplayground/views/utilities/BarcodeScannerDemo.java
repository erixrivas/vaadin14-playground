package com.erixrivas.vaadinplayground.views.utilities;

import com.erixrivas.vaadinplayground.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import sk.smartbase.component.barcodescanner.BarcodeScanner;
import sk.smartbase.component.barcodescanner.DecoderEnum;

@Route(value = "BarcodeScannerDemo", layout = MainView.class)
//@CssImport("./styles/views/layouting/slide.css")
@PageTitle("BarcodeScannerDemo")
public class BarcodeScannerDemo extends VerticalLayout {


    public BarcodeScannerDemo() {
        Label lastScannedLabel = new Label("Last scanned value: unknown");
        BarcodeScanner barcodeScanner = new BarcodeScanner(event ->{
            System.out.println("data: " + event.toString());
            lastScannedLabel.setText("Last scanned value: "+event.getCodeResult().getCode());
        });


        add(barcodeScanner);
        add(lastScannedLabel);
        barcodeScanner.setReaders(DecoderEnum.CODE_39_READER.getValue());

        barcodeScanner.setStopAfterScan(false);
        add(new Button("stop", e->{
            barcodeScanner.stop();
        }));
        add(new Button("start",e->{
            barcodeScanner.initAndStart();
        }));
    }
}

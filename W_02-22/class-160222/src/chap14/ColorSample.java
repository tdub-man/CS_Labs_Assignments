package chap14;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Slider;

/**
 * Created by tanner on 2/25/16.
 */
public class ColorSample extends Application {
    @Override
    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();

        Label[] labels = {new Label("Hue"),new Label("Saturation"),new Label("Brightness")};
        Slider[] sliders = {new Slider(0,360,0),new Slider(0,1,0),new Slider(0,1,0)};
        sliderTicks(0.1,9,.01,sliders[1],sliders[2]);
        sliderTicks(30,14,2,sliders[0]);
        GridPane allSliders = sliderGrid(labels,sliders);

        Button[] buttons = {
                new Button("More Saturated"),
                new Button("Less Saturated"),
                new Button("Hue Up"),
                new Button("Hue Down"),
                new Button("Lighter"),
                new Button("Darker")
        };
        for (Button b : buttons) {
            b.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        }

        ColorPane colorP = initColorPane(sliders,buttons);

        VBox allRight = new VBox(30);
        allRight.getChildren().addAll(
                new VBox(buttons[0],buttons[1]),
                new VBox(buttons[4],buttons[5]),
                new VBox(buttons[2],buttons[3])
        );
        allRight.setPadding(new Insets(15,15,15,15));

        pane.setBottom(allSliders);
        pane.setRight(allRight);
        pane.setCenter(colorP);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Color Sample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void sliderTicks(double mjTU,int mnTC,double blckInc,Slider... sliders) {
        for (Slider s : sliders) {
            s.setShowTickMarks(true);
            s.setShowTickLabels(true);

            s.setMajorTickUnit(mjTU);
            s.setMinorTickCount(mnTC);
            s.setBlockIncrement(blckInc);
        }
    }
    private GridPane sliderGrid(Label[] labels, Slider[] sliders) {
        GridPane gp = new GridPane();
        for (int i=0;i<labels.length;++i) {
            gp.add(labels[i],1,i+1);
        }
        for (int i=0;i<sliders.length;++i) {
            gp.add(sliders[i],2,i+1);
        }
        return gp;
    }
    private ColorPane initColorPane(Slider[] sliders, Button[] buttons) {
        ColorPane cp = new ColorPane();

        sliders[0].setValue(cp.getFill().getHue());
        sliders[1].setValue(cp.getFill().getSaturation());
        sliders[2].setValue(cp.getFill().getBrightness());

        buttons[2].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cp.hueInc();
                sliders[0].setValue(cp.getFill().getHue());
            }
        });
        buttons[3].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cp.hueDec();
                sliders[0].setValue(cp.getFill().getHue());
            }
        });
        buttons[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cp.satInc();
                sliders[1].setValue(cp.getFill().getSaturation());
            }
        });
        buttons[1].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cp.satDec();
                sliders[1].setValue(cp.getFill().getSaturation());
            }
        });
        buttons[4].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cp.lightInc();
                sliders[2].setValue(cp.getFill().getBrightness());
            }
        });
        buttons[5].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cp.lightDec();
                sliders[2].setValue(cp.getFill().getBrightness());
            }
        });

        sliders[0].valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Color c = cp.getFill();
                cp.setFill(Color.hsb((double) newValue,c.getSaturation(),c.getBrightness()));
            }
        });
        sliders[1].valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Color c = cp.getFill();
                cp.setFill(Color.hsb(c.getHue(),(double) newValue,c.getBrightness()));
            }
        });
        sliders[2].valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Color c = cp.getFill();
                cp.setFill(Color.hsb(c.getHue(),c.getSaturation(),(double) newValue));
            }
        });

        return cp;
    }
}

class ColorPane extends Pane {
    public Rectangle rect;

    public ColorPane() {
        this.setMinSize(200,200);
        this.rect = new Rectangle(0,0,0,0);
        this.rect.widthProperty().bind(this.widthProperty());
        this.rect.heightProperty().bind(this.heightProperty());
        this.rect.setFill(Color.GOLD);
        this.getChildren().add(this.rect);
    }

    public Color getFill() {
        return (Color) rect.getFill();
    }
    public void setFill(Color color) {
        this.rect.setFill(color);
    }
    private double minMax(double min,double max,double n) {
        if (n < min) {
            n=min;
        }
        else if (n > max) {
            n=max;
        }
        return n;
    }
    public void hueInc() {
        Color before = this.getFill();
        double hue = before.getHue()+30;
        this.setFill(Color.hsb(hue,before.getSaturation(),before.getBrightness()));
    }
    public void hueDec() {
        Color before = this.getFill();
        double hue = before.getHue()-30;
        this.setFill(Color.hsb(hue,before.getSaturation(),before.getBrightness()));
    }
    public void satInc() {
        Color before = this.getFill();
//        double sat = Math.pow(before.getSaturation(),.5);
        double sat = minMax(0,1,before.getSaturation()+0.01);
        this.setFill(Color.hsb(before.getHue(),sat,before.getBrightness()));
    }
    public void satDec() {
        Color before = this.getFill();
//        double sat = Math.pow(before.getSaturation(),2);
        double sat = minMax(0,1,before.getSaturation()-0.01);
        this.setFill(Color.hsb(before.getHue(),sat,before.getBrightness()));
    }
    public void lightInc() {
        Color before = this.getFill();
//        double light = Math.pow(before.getBrightness(),.5);
        double light = minMax(0,1,before.getBrightness()+0.01);
        this.setFill(Color.hsb(before.getHue(),before.getSaturation(),light));
    }
    public void lightDec() {
        Color before = this.getFill();
//        double light = Math.pow(before.getBrightness(),2);
        double light = minMax(0,1,before.getBrightness()-0.01);
        this.setFill(Color.hsb(before.getHue(),before.getSaturation(),light));
    }
}

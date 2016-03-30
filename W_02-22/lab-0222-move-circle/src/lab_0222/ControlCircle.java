package lab_0222;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class ControlCircle extends Application {
    private CirclePane circlePane = new CirclePane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Hold two buttons in an HBox
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.addAll(Arrays.asList(
                new Button("Enlarge"),
                new Button("Shrink"),
                new Button("North"),
                new Button("South"),
                new Button("West"),
                new Button("East")
        ));
        HBox bBox = new HBox();
        HBox tBox = new HBox();
        bBox.getChildren().addAll(buttons.subList(0,2));
        tBox.getChildren().addAll(buttons.subList(2,6));

        bBox.setSpacing(10);
        bBox.setAlignment(Pos.CENTER);
        tBox.setSpacing(10);
        tBox.setAlignment(Pos.CENTER);

        // Create and register the handler
        buttons.get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circlePane.enlarge();
            }
        });
        buttons.get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circlePane.shrink();
            }
        });
        buttons.get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circlePane.moveNorth();
            }
        });
        buttons.get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circlePane.moveSouth();
            }
        });
        buttons.get(4).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circlePane.moveWest();
            }
        });
        buttons.get(5).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circlePane.moveEast();
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(bBox);
        BorderPane.setAlignment(bBox, Pos.CENTER);
        borderPane.setTop(tBox);
        BorderPane.setAlignment(tBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 600, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                    case W: circlePane.moveNorth(); break;
                    case DOWN:
                    case S: circlePane.moveSouth(); break;
                    case LEFT:
                    case A: circlePane.moveWest(); break;
                    case RIGHT:
                    case D: circlePane.moveEast(); break;
                }
            }
        });
        scene.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                switch ((int) event.getDeltaY()) {
                    case 40: circlePane.enlarge(); break;
                    case -40: circlePane.shrink(); break;
                }
            }
        });

        primaryStage.setTitle("ControlCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

}


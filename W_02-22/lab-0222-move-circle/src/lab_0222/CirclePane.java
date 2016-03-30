package lab_0222;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Ben on 2/24/2016.
 */
public class CirclePane extends Pane {
    private Circle circle = new Circle(250, 300, 50);

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink() {
        circle.setRadius(circle.getRadius() > 2 ?
                circle.getRadius() - 2 : circle.getRadius());
    }

    public void moveNorth() {
        circle.setCenterY(circle.getCenterY()-20);
    }
    public void moveSouth() {
        circle.setCenterY(circle.getCenterY()+20);
    }
    public void moveWest() {
        circle.setCenterX(circle.getCenterX()-20);
    }
    public void moveEast() {
        circle.setCenterX(circle.getCenterX()+20);
    }

    public static final double stepAmount = 20;

}

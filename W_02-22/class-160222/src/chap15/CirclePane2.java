package chap15;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Define a class that encapsulates presenting a circle and provides methods
 * to change the size of the circle.
 */
class CirclePane2 extends StackPane {
    private Circle crc;

    public CirclePane2() {
        crc = new Circle();
        crc.setRadius(30);
        // crc.setCenterX(60);
        // crc.setCenterY(70);
        crc.setStroke(Color.BURLYWOOD);
        crc.setFill(Color.WHITESMOKE);
        this.getChildren().add(crc);
    }

    public void enlarge() {
        double rad = crc.getRadius();
        rad += 2;
        crc.setRadius(rad);

        //crc.setRadius(crc.getRadius()+2);
    }

    public void shrink() {
        double rad = crc.getRadius();
        if (rad > 2) {
            rad -= 2;
            crc.setRadius(rad);
        } else {
            // do nothing
        }
    }
}
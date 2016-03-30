import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Created by tanner on 3/18/16.
 */

class CirclesPane extends Pane {
    private ArrayList<Circle> circles = new ArrayList<>();
    private Rectangle boundBox = null;
    private static final int strokeWidth = 5;

    CirclesPane() {}

    void addCircle(double x, double y) {
//        Create Circle object
        Circle c = new Circle(x,y,15, Color.LIGHTBLUE);
        c.setStroke(Color.DARKBLUE);

//        Create circle event handler
        c.setOnMouseClicked(me -> {
            if(me.getButton().toString().equals("SECONDARY")) {
                this.removeCircle(c);
                me.consume();
            }
        });

//        Hours of struggling to find that
//        I just needed to add the boundary before any circles
        updateBounds(c);
        this.getChildren().add(c);
        this.circles.add(c);
    }
    private void removeCircle(Circle c) {
        this.getChildren().remove(c);
        circles.remove(c);
        double[] bounds = boundaries();
        if(bounds.length==0) {
            this.getChildren().remove(boundBox);
            boundBox = null;
        }
        else {
            boundBox.setX(bounds[0]);
            boundBox.setWidth(bounds[1]-bounds[0]);
            boundBox.setY(bounds[2]);
            boundBox.setHeight(bounds[3]-bounds[2]);
        }

    }

//    Returns array containing the x or y values of the four boundaries
    private double[] boundaries() {
        double[] bounds = {};

        for(Circle c : circles) {
            if(bounds.length==0) {
                bounds = new double[] {
                        c.getCenterX()-c.getRadius()-(strokeWidth/2), // West
                        c.getCenterX()+c.getRadius()+(strokeWidth/2), // East
                        c.getCenterY()-c.getRadius()-(strokeWidth/2), // North
                        c.getCenterY()+c.getRadius()+(strokeWidth/2)};// South
            }
            else {
                if(c.getCenterX()-c.getRadius()-(strokeWidth/2) < bounds[0]) { // West
                    bounds[0] = c.getCenterX()-c.getRadius()-(strokeWidth/2);
                }
                if(c.getCenterX()+c.getRadius()+(strokeWidth/2) > bounds[1]) { // East
                    bounds[1] = c.getCenterX()+c.getRadius()+(strokeWidth/2);
                }
                if(c.getCenterY()-c.getRadius()-(strokeWidth/2) < bounds[2]) { // North
                    bounds[2] = c.getCenterY()-c.getRadius()-(strokeWidth/2);
                }
                if(c.getCenterY()+c.getRadius()+(strokeWidth/2) > bounds[3]) { // South
                    bounds[3] = c.getCenterY()+c.getRadius()+(strokeWidth/2);
                }
            }
        }

        return bounds;
    }

//    Changes the boundaries after adding the circle c
    private void updateBounds(Circle c) {
        if (boundBox==null) {
            boundBox = new Rectangle(
                    c.getCenterX()-c.getRadius()-(strokeWidth/2),
                    c.getCenterY()-c.getRadius()-(strokeWidth/2),
                    (c.getRadius()*2)+strokeWidth,
                    (c.getRadius()*2)+strokeWidth);
            boundBox.setFill(Color.web("0x00000000"));
            boundBox.setStroke(Color.GREEN);
            boundBox.setStrokeWidth(strokeWidth);
            this.getChildren().add(boundBox); // Problem: Interfering with other children
        }
        else {
            if(c.getCenterX()-c.getRadius() < boundBox.getX()) {
                boundBox.setWidth(boundBox.getWidth()+boundBox.getX()-
                        c.getCenterX()+c.getRadius()+(strokeWidth/2));
                boundBox.setX(c.getCenterX()-c.getRadius()-(strokeWidth/2));
            }
            if(c.getCenterY()-c.getRadius() < boundBox.getY()) {
                boundBox.setHeight(boundBox.getHeight()+boundBox.getY()-
                        c.getCenterY()+c.getRadius()+(strokeWidth/2));
                boundBox.setY(c.getCenterY()-c.getRadius()-(strokeWidth/2));
            }
            if(c.getCenterX()+c.getRadius() > boundBox.getWidth()+boundBox.getX()) {
                boundBox.setWidth(c.getCenterX()-boundBox.getX()+
                        c.getRadius()+(strokeWidth/2));
            }
            if(c.getCenterY()+c.getRadius() > boundBox.getHeight()+boundBox.getY()) {
                boundBox.setHeight(c.getCenterY()-boundBox.getY()+
                        c.getRadius()+(strokeWidth/2));
            }
        }
    }
}

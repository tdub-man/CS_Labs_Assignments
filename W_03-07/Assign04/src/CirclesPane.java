import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * Created by tanner on 3/7/16.
 */
public class CirclesPane extends Pane {
    private Circle circA = new Circle(100,150,15);   // Shown circle
    private Circle noCircA = new Circle(100,150,15); // Clicked circle, tied to circA
    private Circle circB = new Circle(200,150,15);   // Shown circle
    private Circle noCircB = new Circle(200,150,15); // Clicked Circle, tied to circB
    private Line distLine = new Line(100,150,200,150);
    private Text dist = new Text("100.000");

    public CirclesPane() {
        this.getChildren().add(distLine);
        this.getChildren().addAll(circA, circB);
        this.getChildren().add(dist);
        this.getChildren().addAll(noCircA,noCircB); // Placed above everything else
        distLine.setStroke(Color.YELLOW);
        this.dist.setX(this.getDistMidPoint()[0]);
        this.dist.setY(this.getDistMidPoint()[1]);
        this.dist.setFill(Color.WHITE);
        circA.setFill(Color.web("0x00FF0040"));
        circB.setFill(Color.web("0x0000FF40"));
        noCircA.setFill(Color.web("0x00000000"));
        noCircB.setFill(Color.web("0x00000000"));
    }

    public Circle getCircA() {
        return noCircA;
    }
    public Circle getCircB() {
        return noCircB;
    }

    private double getDistance() {
        double xsqr = Math.pow(this.distLine.getStartX()-this.distLine.getEndX(),2);
        double ysqr = Math.pow(this.distLine.getStartY()-this.distLine.getEndY(),2);
        return Math.sqrt(xsqr + ysqr);
    }
    private double[] getDistMidPoint() {
        double[] mid = new double[2];
        mid[0] = (this.distLine.getStartX()+this.distLine.getEndX())/2;
        mid[1] = (this.distLine.getStartY()+this.distLine.getEndY())/2;

        return mid;
    }
    public void moveCircA(double x, double y) {
        this.noCircA.setCenterX(x);
        this.noCircA.setCenterY(y);
        this.circA.setCenterX(x);
        this.circA.setCenterY(y);
        this.distLine.setStartX(x);
        this.distLine.setStartY(y);
        this.dist.setX(getDistMidPoint()[0]);
        this.dist.setY(getDistMidPoint()[1]);
        this.dist.setText(String.format("%.3f", this.getDistance()));
    }
    public void moveCircB(double x, double y) {
        this.noCircB.setCenterX(x);
        this.noCircB.setCenterY(y);
        this.circB.setCenterX(x);
        this.circB.setCenterY(y);
        this.distLine.setEndX(x);
        this.distLine.setEndY(y);
        this.dist.setX(getDistMidPoint()[0]);
        this.dist.setY(getDistMidPoint()[1]);
        this.dist.setText(String.format("%.3f", this.getDistance()));
    }
}

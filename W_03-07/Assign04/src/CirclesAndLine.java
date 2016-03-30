import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by tanner on 3/7/16.
 */
public class CirclesAndLine extends Application {
    @Override
    public void start (Stage primaryStage) {
        CirclesPane cp = new CirclesPane();
        // Holds the difference between
        // mouse coordinates and circle center coordinates
        double[] mouseCDif = new double[2];

        Scene scene = new Scene(cp);
        scene.setFill(Color.web("444444FF"));

        // Setup circle dragging
        // Constrain circle movement to the scene
        // Constraint works best with maximized window
        handleEvents(cp,mouseCDif,scene);

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(300);
        primaryStage.setTitle("Two Vertices");
        primaryStage.show();
    }

    private void handleEvents(CirclesPane cp,double[] mouseCDif,Scene scene) {
        cp.getCircA().setOnMousePressed(me -> {
            mouseCDif[0] = cp.getCircA().getCenterX() - me.getSceneX();
            mouseCDif[1] = cp.getCircA().getCenterY() - me.getSceneY();
        });
        cp.getCircA().setOnMouseDragged(me -> {
            double[] point = {me.getSceneX()+mouseCDif[0],me.getSceneY()+mouseCDif[1]};
            if(point[0] < scene.getX()+cp.getCircA().getRadius()) {
                point[0] = cp.getCircA().getRadius();
            }
            if(point[0] > scene.getWidth()-cp.getCircA().getRadius()) {
                point[0] = scene.getWidth()-cp.getCircA().getRadius();
            }
            if(point[1] < scene.getY()+cp.getCircA().getRadius()) {
                point[1] = scene.getY()+cp.getCircA().getRadius();
            }
            if(point[1] > scene.getHeight()-cp.getCircA().getRadius()) {
                point[1] = scene.getHeight()-cp.getCircA().getRadius();
            }
            cp.moveCircA(point[0],point[1]);
        });
        cp.getCircB().setOnMousePressed(me -> {
            mouseCDif[0] = cp.getCircB().getCenterX() - me.getSceneX();
            mouseCDif[1] = cp.getCircB().getCenterY() - me.getSceneY();
        });
        cp.getCircB().setOnMouseDragged(me -> {
            double[] point = {me.getSceneX()+mouseCDif[0],me.getSceneY()+mouseCDif[1]};
            if(point[0] < scene.getX()+cp.getCircB().getRadius()) {
                point[0] = cp.getCircB().getRadius();
            }
            if(point[0] > scene.getWidth()-cp.getCircB().getRadius()) {
                point[0] = scene.getWidth()-cp.getCircB().getRadius();
            }
            if(point[1] < scene.getY()+cp.getCircB().getRadius()) {
                point[1] = scene.getY()+cp.getCircB().getRadius();
            }
            if(point[1] > scene.getHeight()-cp.getCircB().getRadius()) {
                point[1] = scene.getHeight()-cp.getCircB().getRadius();
            }
            cp.moveCircB(point[0],point[1]);
        });
    }
}

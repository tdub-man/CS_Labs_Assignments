import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by tanner on 3/18/16.
 */
public class BoundingCircles extends Application {
    @Override
    public void start(Stage primaryStage) {
        CirclesPane cp = new CirclesPane();
//        cp.addCircle(60,60);
//        cp.addCircle(90,120);
//        cp.addCircle(30,30);
//        cp.addCircle(210,90);
//
//        for(int i=0; i<4; ++i) {
//            cp.removeCircle(cp.circles.get(0));
//        }
//        cp.addCircle(270,270);

        Scene scene = new Scene(cp);

        scene.setOnMouseClicked(me -> {
            if(me.getButton().toString().equals("PRIMARY")) {
                cp.addCircle(me.getSceneX(),me.getSceneY());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("Bounding Circles");
        primaryStage.show();
    }
}

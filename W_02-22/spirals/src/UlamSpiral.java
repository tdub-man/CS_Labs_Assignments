import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by tanner on 2/29/16.
 */
public class UlamSpiral extends Application {
    @Override
    public void start(Stage primaryStage) {
        int start = 41;
        int size = 2500;
        SpiralGridMap sgm = new SpiralGridMap(start,size,30,30);
        sgm.colorBlocks(Color.LIGHTGREEN);
        sgm.setHgap(5);
        sgm.setVgap(5);
//        sgm.setAlignment(Pos.CENTER);
        sgm.colorPrimes();

        ScrollPane scroll = new ScrollPane(sgm);

        Scene scene = new Scene(scroll);
        scene.setFill(Color.LIGHTBLUE);

        primaryStage.setFullScreen(false);
        primaryStage.setTitle("Ulam Spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

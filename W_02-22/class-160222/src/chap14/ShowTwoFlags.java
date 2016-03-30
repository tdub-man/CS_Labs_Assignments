package chap14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by bsetzer on 2/23/2015.
 */
public class ShowTwoFlags extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image flag1 = new Image("http://ksuweb.kennesaw" +
                ".edu/~bsetzer/2302sp15/extra/projects/class-150223-javafx/image/india.gif");
        Image flag2 = new Image("http://ksuweb.kennesaw" +
                ".edu/~bsetzer/2302sp15/extra/projects/class-150223-javafx/image/malaysia.jpg");
        ImageView iv1 = new ImageView(flag1);
        ImageView iv2 = new ImageView(flag2);
        iv2.setRotate(45);


        Pane hp = new HBox();  // Pane that places its children in a horizontal row
        hp.getChildren().add(iv1);
        hp.getChildren().add(iv2);

        Pane sp = new StackPane();
        sp.getChildren().add(hp);

        Scene sc = new Scene(sp, 600, 600);

        primaryStage.setScene(sc);
        primaryStage.setTitle("Two flags");
        primaryStage.show();
    }
}

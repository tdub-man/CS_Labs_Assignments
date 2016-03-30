package chap14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by bsetzer on 2/23/2015.
 */
public class ShowImageOurs extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //InputStream instr = new FileInputStream("image/us.gif");
        //Image flag = new Image(instr);

        Image flag = new Image("http://ksuweb.kennesaw" +
                ".edu/~bsetzer/2302sp15/extra/projects/class-150223-javafx/image/india.gif");
        //instr.close();
        ImageView iv = new ImageView(flag);
        //iv.setFitWidth(200);
        //iv.setFitHeight(200);

        Pane sp = new StackPane();
        sp.getChildren().add(iv);

        Scene sc = new Scene(sp, 400,400);

        primaryStage.setScene(sc);
        primaryStage.setTitle("Image of a flag");
        primaryStage.show();
    }
}

package chap14;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Ben on 2/23/2015.
 */
public class WorkingDir extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        File f = new File("image/us.gif");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.exists());
    }
}

package chap14;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;

/**
 * Created by bsetzer on 2/23/2015.
 */
public class TryImage {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream instr = new FileInputStream("image/germany.gif");
        Image flag = new Image(instr);
        System.out.println("flag width is " + flag.getWidth());
        System.out.println("flag height is " + flag.getHeight());
    }
}

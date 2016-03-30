import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by tanner on 3/1/16.
 */
public class SpiralGridMap extends GridPane {
    private int[] minMax = {0,0,0,0}; // (Xmax,Ymax) and (Xmin,Ymin)
    private int base;
    ArrayList<Block> spiralBlocks = new ArrayList<>();

    public SpiralGridMap(int start, int size, int blockWidth, int blockHeight) {
        base = start;
        ArrayList<int[]> gridCoordinates = buildSpiralCoord(size);
        fillBlockList(gridCoordinates,blockWidth,blockHeight,start);
        fillGrid();
    }

    private ArrayList<int[]> buildSpiralCoord(int n) {
        int[] coord = {0,0}; // (X,Y)
        ArrayList<int[]> coords = new ArrayList<>();
        coords.add(new int[] {coord[0],coord[1]});

        int i=1;
        while (i<n) {
            while(coord[0] <= minMax[0] && i<n) {
                coord[0] = coord[0] + 1;
                coords.add(new int[] {coord[0],coord[1]});
                ++i;
            }
            if (coord[0] > minMax[0]) {
                minMax[0] = coord[0];
            }
            while(coord[1] <= minMax[1] && i<n) {
                coord[1] = coord[1] + 1;
                coords.add(new int[] {coord[0],coord[1]});
                ++i;
            }
            if (coord[1] > minMax[1]) {
                minMax[1] = coord[1];
            }
            while(coord[0] >= minMax[2] && i<n) {
                coord[0] = coord[0] - 1;
                coords.add(new int[] {coord[0],coord[1]});
                ++i;
            }
            if (coord[0] < minMax[2]) {
                minMax[2] = coord[0];
            }
            while(coord[1] >= minMax[3] && i<n) {
                coord[1] = coord[1] - 1;
                coords.add(new int[] {coord[0],coord[1]});
                ++i;
            }
            if (coord[1] < minMax[3]) {
                minMax[3] = coord[0];
            }
        }

        if (minMax[2] < 0 || minMax[3] < 0) {
            for (int[] c : coords) {
                c[0] = c[0] + Math.abs(minMax[2]);
                c[1] = c[1] + Math.abs(minMax[3]);
            }
            minMax[0] = minMax[0] + Math.abs(minMax[2]);
            minMax[1] = minMax[1] + Math.abs(minMax[3]);
            minMax[2] = 0;
            minMax[3] = 0;
        }

        return coords;
    }
    private ArrayList<int[]> sortCoords(ArrayList<int[]> coords) {
        ArrayList<int[]> newArray = new ArrayList<>();
        for (int[] c : coords) {
            newArray.add(c);
        }
        quicksort(newArray,0,newArray.size()-1);

        return newArray;
    }

    private int compareCoord(int[] a, int[] b) {
        if (a[0] < b[0]) {
            return -1;
        }
        else if (a[0] == b[0]) {
            if (a[1] < b[1]) {
                return -1;
            }
            else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        }
        else {
            return 1;
        }
    }
    private int partition(ArrayList<int[]> arr, int left, int right) {
        int i=left, j=right;
        int[] tmp;
        int[] pivot = arr.get((left+right)/2);

        while(i <= j) {
            while(compareCoord(arr.get(i),pivot) == -1) {
                ++i;
            }
            while(compareCoord(arr.get(j),pivot) == 1) {
                --j;
            }
            if (i <= j) {
                tmp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,tmp);
                ++i;
                --j;
            }
        }

        return i;
    }
    private void quicksort(ArrayList<int[]> arr, int left, int right) {
        int index = partition(arr,left,right);
        if (left < index-1) {
            quicksort(arr,left,index-1);
        }
        if (index < right) {
            quicksort(arr,index,right);
        }
    }
    private void fillBlockList(ArrayList<int[]> coords, int w, int h, int n) {
        int i = 0;
        for (int[] c : coords) {
            this.spiralBlocks.add(new Block(c[0]+1,minMax[1]-c[1]+1,w,h,n));
            ++n;
        }
    }
    private void fillGrid() {
        for (Block b : spiralBlocks) {
            this.add(b,b.getCoord()[0],b.getCoord()[1]);
        }
    }

    public void colorBlocks(Color color) {
        for (Block b : spiralBlocks) {
            b.setFillColor(color);
        }
    }

    public boolean primeTest(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(n) + 1; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
//        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
//        _ _ 3 _ 5 _ 7 _ 9 __ 11 __ 13 __ 15
//        _ _ _ _ 5 _ 7 _ _ __ 11 __ 13 __ 15

        return true;
    }
    public void colorPrimes() {
        Block cache = new Block(0,0,0,0,this.base);
        for (Block b : spiralBlocks) {
            if(primeTest(b.getNum())) {
                if (b.getNum() == cache.getNum()+2) {
                    cache.setFillColor(Color.HOTPINK);
                    b.setFillColor(Color.HOTPINK);
                }
                else {
                    b.setFillColor(Color.ORANGE);
                }
                cache = b;
            }
        }
    }

    public void printCoords (ArrayList<int[]> arr) {
        for (int[] c : arr) {
            System.out.printf("(%d,%d) ",c[0],c[1]);
        }
        System.out.println();
    }
}

class Block extends StackPane {
    private Label l;
    private int[] coord;

    public Block(int x, int y, int width, int height, int num) {
        this.coord = new int[] {x,y};
        this.l = new Label(Integer.toString(num));
        l.setPadding(new Insets(3,3,3,3));
        this.getChildren().add(l);
        this.setFillColor(Color.WHITE);
    }

    public int[] getCoord() {
        return this.coord;
    }
    public void setCoord(int[] c) {
        this.coord = new int[] {c[0],c[1]};
    }
    public int getNum() {
        return Integer.valueOf(l.getText());
    }
    public void setNum(int n) {
        this.l.setText(Integer.toString(n));
    }
    public void setFillColor(Color color) {
        String hexColor = String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
        this.setStyle("-fx-background-color: " + hexColor + ";");
    }
}

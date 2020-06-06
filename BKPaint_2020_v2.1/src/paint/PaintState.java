
package paint;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.Serializable;
import java.util.ArrayList;
import shape.DrawType;


public class PaintState implements Serializable{
    // Bien enum luu cac kieu xoay va trang thai ve
    public static final int ROTATE_RIGHT=1,ROTATE_LEFT = 2,ROTATE_REVERSE = 3,V_FLIP = 4,H_FLIP = 5,PAINTTING = 6;
    private ArrayList<Integer> drawStepList;
    private ArrayList<DrawType> listShape;
    private DrawType drawType;
    // Mang luu pixels
    private int[] data = null;  
    private int w,h;
    public PaintState(){
        listShape = new ArrayList<>();
        drawStepList = new ArrayList<>();
        listShape.add(drawType);
    }
    public void addDrawStep(int drawStep){
        drawStepList.add(drawStep);
    }
    public ArrayList<Integer> getDrawStepList(){
        return drawStepList;
    }
    public void addDrawState(DrawType drawType){
        listShape.add(drawType);
    }
    public ArrayList<DrawType> getListState(){
        return listShape;
    }
    public DrawType removeEndShape(){
        if(listShape.isEmpty())
            return null;
        return listShape.remove(listShape.size()-1);
    }
    public int removeEndStep(){
        if(drawStepList.isEmpty())
            return -1;
        return drawStepList.remove(drawStepList.size()-1);
    }
    public boolean isEmpty(){
        return drawStepList.isEmpty();
    }
    public void removeAll(){
        listShape = new ArrayList<>();
        drawStepList = new ArrayList<>();
        System.gc();
    }
    
    // Raster dai dien cho mot hinh hop chu nhat pixels
    public void setData(BufferedImage buff_img){
        // Lay chieu dai chieu rong cua Buff_img
        w = buff_img.getWidth();
        h = buff_img.getHeight();
        data = new int[w*h*3];
        // Tra ve WriableRaster
        final WritableRaster wr = buff_img.getRaster();
        /**
         * 0 0 la toa do cua goc trai padPaint
         * w h la do dai padPaint
         */
        data = wr.getPixels(0, 0, w, h,data);
    }
    public int[] getData(){
        return data;
    }
    public int getWidth(){
        return w;
    }
    public int getHeight(){
        return h;
    }
}
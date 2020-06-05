
package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;


public class Shape implements Serializable {

    protected Color strokeColor;
    protected ArrayList<Point> draggPoint = new ArrayList<Point>();
    protected Point start, end;
    public void setPoint(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void addDraggedPoint(Point drag) {
        draggPoint.add(drag);
    }

    public ArrayList<Point> getDraggedPoint() {
        return draggPoint;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Color getStrokeColor() {
        return this.strokeColor;
    }
    
    /**
     * Do day net ve.
     */
    protected float strokeThickness;
    /**
     * Quy dinh phan vien o goc doan thang.
     */
    protected int endStrokeCap;
    /**
     * Quy dinh kieu duong cong noi giua 2 doan thang.
     */
    protected int lineStrokeJoin;
    /**
     * Dinh nghia kieu ve giua các phan hien va cac phan an.
     */
    protected float dashPhase;
    protected float miterLimit = 1.0f;
    protected float[] dashArray;
    
    /**
     * Lay thong tin cua mot net chu 
     */
    public void setStroke(BasicStroke stroke){
        strokeThickness = stroke.getLineWidth();
        endStrokeCap = stroke.getEndCap();
        lineStrokeJoin = stroke.getLineJoin();
        dashPhase = stroke.getDashPhase();
        dashArray = stroke.getDashArray();
        
    }
}

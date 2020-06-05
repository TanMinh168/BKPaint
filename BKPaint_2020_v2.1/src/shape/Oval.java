
package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;


public class Oval extends Shape implements DrawType {

    private Color fillColor;
    /**
     * Neu fillcolor khac mau trang thi do mau va ve vien .
     * Neu khong thi chi ve vien.
     * @param g2d doi tuong do hoa 2D
     */
    public void draw(Graphics2D g2d) {
         BasicStroke stroke = new BasicStroke(strokeThickness,endStrokeCap,lineStrokeJoin,miterLimit,
        dashArray,dashPhase);
        g2d.setStroke(stroke);
        if (fillColor != Color.WHITE) {
            g2d.setColor(fillColor);
            g2d.fillOval(Math.min(start.x, end.x), Math.min(start.y, end.y),
                    Math.abs(start.x - end.x), Math.abs(start.y - end.y));
        }
        // strokeColor o class Shape
        g2d.setColor(strokeColor);
        /*
        Diem bat dau luon la diem ben tren va ben trai ( goc phan tu thu 2 )
        Hai tham so sau la duong kinh
        */
        g2d.drawOval(Math.min(start.x, end.x), Math.min(start.y, end.y),
                Math.abs(start.x - end.x), Math.abs(start.y - end.y));
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

}

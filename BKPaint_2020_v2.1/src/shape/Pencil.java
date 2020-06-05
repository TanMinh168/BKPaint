
package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class Pencil extends Shape implements DrawType {

    @Override
    public void draw(Graphics2D g2d) {
        BasicStroke stroke = null;
        if(miterLimit>=1.0f)
             stroke = new BasicStroke(strokeThickness,endStrokeCap,lineStrokeJoin,miterLimit,
        dashArray,dashPhase);
        /*
        Neu khoi tao stroke thanh cong thi setStroke cho doi tuong do hoa
        */
        if (stroke != null) {
            g2d.setStroke(stroke);
        }
        /*
        Neu diem va diem cuoi khong trung nhau thi bat dau ve duong thang
        */
        g2d.setColor(strokeColor);
        if (start != null && end != null) {
            g2d.drawLine(start.x, start.y, end.x, end.y);
        }

    }

    @Override
    public Color getStrokeColor() {
        return strokeColor;
    }

}


package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


//hình tam giác vuông cần phải được đổ màu, ở đầy phải dùng fillPolygon
public class RightTriangle extends Shape implements DrawType {
    private Color fillColor;
    
    public void draw(Graphics2D g2d) {
         BasicStroke stroke = new BasicStroke(strokeThickness,endStrokeCap,lineStrokeJoin,miterLimit,
        dashArray,dashPhase);
        g2d.setStroke(stroke);
        int[] xPoints = {start.x,start.x,end.x};
        int[] yPoints = {start.y,end.y,end.y};
        if (fillColor != Color.WHITE && !fillColor.equals(new Color(255, 255, 255))){
            g2d.setColor(fillColor);
            g2d.fillPolygon(xPoints,yPoints,3);
        }
        g2d.setColor(strokeColor);
        g2d.drawPolygon(xPoints, yPoints, 3);

    }

    public Color getStrokeColor() {
        return strokeColor;
    }
    public void setFillColor(Color fillColor ){
        this.fillColor = fillColor;
    }
}

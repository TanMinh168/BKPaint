
package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Triangle extends Shape implements DrawType {

    private Color fillColor;
    GeneralPath gp = new GeneralPath();

    public void draw(Graphics2D g2d) {
        
        int[] xPoints = {start.x, end.x, 2 * start.x - end.x};
        int[] yPoints = {start.y, end.y, end.y};
         BasicStroke stroke = new BasicStroke(strokeThickness,endStrokeCap,lineStrokeJoin,miterLimit,
        dashArray,dashPhase);
        g2d.setStroke(stroke);
        if (fillColor != Color.WHITE && !fillColor.equals(new Color(255, 255, 255))) {
            g2d.setColor(fillColor);
            g2d.fillPolygon(xPoints, yPoints, 3);
        }
        g2d.setColor(strokeColor);
        g2d.drawPolygon(xPoints, yPoints, 3);

    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

}

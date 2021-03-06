
package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class RoundRect extends Shape implements DrawType {

    private Color fillColor;
    private static final int ARC_WIDTH = 50;
    private static final int ARC_HEIGHT = 50;
    

    /**
     * Hinh chu nhat co cac canh tron.
     * @param g2d 
     */
    @Override
    public void draw(Graphics2D g2d) {
         BasicStroke stroke = new BasicStroke(strokeThickness,endStrokeCap,lineStrokeJoin,miterLimit,
        dashArray,dashPhase);
        g2d.setStroke(stroke);
        if (fillColor != Color.WHITE) {
            g2d.setColor(fillColor);
            g2d.fillRoundRect(Math.min(start.x, end.x), Math.min(start.y, end.y),
                    Math.abs(start.x - end.x), Math.abs(start.y - end.y), ARC_WIDTH, ARC_HEIGHT);

        }
        g2d.setColor(strokeColor);
        g2d.drawRoundRect(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.abs(end.x - start.x),
                Math.abs(end.y - start.y), ARC_WIDTH, ARC_HEIGHT);

    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}

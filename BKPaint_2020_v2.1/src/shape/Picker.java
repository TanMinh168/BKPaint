
package shape;

import java.awt.Color;
import java.awt.Graphics2D;


public class Picker extends Shape implements DrawType {
    
    private Color color;
    /**
     * Tra ve mau tai noi con tro tro toi.
     * @param g2d 
     */
    @Override
    public void draw(Graphics2D g2d) {

    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return this.color;
    }
}


package property;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ColorCell extends ImageIcon{
    public static final int WIDTH = 25;
    public static final int HEIGHT = 25;
    private Point location;
    private Color color = Color.WHITE;
    
    /**
     * Constructor
     */
    public ColorCell(Color color){
        this.color = color;
    }
    
    /**
     * Getter & Setter 
     */
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(6, 6, WIDTH+8, HEIGHT+8);
    }
}

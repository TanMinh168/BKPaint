
package shape;



import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;


public class Polygon extends Shape implements DrawType {
    private ArrayList<Line> listLine = new ArrayList<>();
    public ArrayList<Line> getListLine(){
        return listLine;
    }
    //them mot duong thang moi vao danh sach
    public void addElement(Line line){
        listLine.add(line);
    }
    
    
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(strokeColor);
        for(int i=0;i<listLine.size();i++){
            listLine.get(i).draw(g2d);
        }
    }
}

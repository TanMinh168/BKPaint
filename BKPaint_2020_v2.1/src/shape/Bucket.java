
package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Stack;


public class Bucket extends Shape implements DrawType {

    /**
     * Diem bat dau do mau
     */
    private Point start;
    /**
     * Mau duoc chon
     */
    private Color color;
    private boolean filled = true;

    private ArrayList<Point> arrPoint = new ArrayList<Point>();

    public void setStart(Point start) {
        this.start = start;
    }

    @Override
    public Point getStart() {
        return this.start;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void draw(BufferedImage img) {
  //      floodFill(img);
        boundaryFill(img);
//        boundaryFill2(this.start.x, this.start.y, img);
    }

    
    public boolean checkFilled() {
        return filled;
    }

    
    private void floodFill(BufferedImage img) {
        Point start;
        Stack<Point> stack = new Stack<>();                                    
        int backgroundColor = img.getRGB(this.start.x, this.start.y);                    
        int fillColor = color.getRGB();                                         
        int x = this.start.x, y = this.start.y, x1, x2;
        boolean addedUp = false, addedDown = false;
        Graphics g = img.getGraphics();
        g.setColor(color);

        //kiem tra neu mau tai diem an chuot trung mau diem can to thi return, ko can to
        if (backgroundColor == fillColor) {
            filled = false;
            return;
        }

        //to ve phia trai den khi gap mau khac mau nen
        while (x >= 0 && img.getRGB(x, y) == backgroundColor) {
            x--;
        }
        if (x != 0) {
            x1 = x + 1;
        } else {
            x1 = x;
        }

        stack.push(new Point(x1, y));                                          
        while (stack.isEmpty() == false) {
            addedUp = false;
            addedDown = false;
            start = stack.pop();
            x = start.x;
            y = start.y;

            
            while (x >= 0 && img.getRGB(x, y) == backgroundColor) {
                x--;
            }
            if (x != 0) {
                x1 = x + 1;
            } else {
                x1 = x;
            }

            //tim diem ket thuc va diem bat dau tren va bat dau duoi
            x++;
            while (x <= img.getWidth() - 1 && img.getRGB(x, y) == backgroundColor) {
                if (addedUp == false && y - 1 >= 0 && img.getRGB(x, y - 1) == backgroundColor) {
                    stack.push(new Point(x, y - 1));
                    addedUp = true;
                } else if (y - 1 >= 0 && img.getRGB(x, y - 1) != backgroundColor) {
                    addedUp = false;
                }

                if (addedDown == false && y + 1 <= img.getHeight() - 1 && img.getRGB(x, y + 1) == backgroundColor) {
                    stack.push(new Point(x, y + 1));
                    addedDown = true;
                } else if (y + 1 <= img.getHeight() - 1 && img.getRGB(x, y + 1) != backgroundColor) {
                    addedDown = false;
                }
                x++;
            }

            if (x != img.getWidth()) {
                x2 = x - 1;
            } else {
                x2 = x;
            }

            g.drawLine(x1, y, x2, y);
        }
        g.dispose();
    }

    private void boundaryFill(BufferedImage image) {
        // tra ve mau tai diem bat dau
        int startColor = image.getRGB(this.start.x, this.start.y);
        // mau duoc chon
        int fillColor = this.color.getRGB();
        // Neu mau duoc chon trung vs mau tai diem bat dau thi ket thuc
        if (startColor == fillColor) {
            return;
        }
        // Doi mau tai diem bat dau thanh mau duoc chon
        image.setRGB(this.start.x, this.start.y, fillColor);


        ArrayList<Point> listPoint = new ArrayList<>();
        listPoint.add(this.start);
        while (!listPoint.isEmpty()) {
            Point temp = listPoint.get(0);
            if ((temp.x >= 0 && temp.x <= image.getWidth() - 2 && temp.y >= 0) && temp.y <= image.getHeight() - 2) {
                /**
                 * Lan mau ra 8 huong dong thoi them diem vua doi mau vao listPoint.
                 * Lay dan trong listPoint ra dan de tiep tuc de quy
                 * Chua toi uu vi duyet trung nhieu diem
                 */
                if (temp.x - 1 >= 0 && temp.y - 1 >= 0 && (image.getRGB(temp.x - 1, temp.y - 1) == startColor)) {
                    image.setRGB(temp.x - 1, temp.y - 1, fillColor);
                    listPoint.add(new Point(temp.x - 1, temp.y - 1));
                }
                if (temp.x - 1 >= 0 && image.getRGB(temp.x - 1, temp.y) == startColor) {
                    image.setRGB(temp.x - 1, temp.y, fillColor);
                    listPoint.add(new Point(temp.x - 1, temp.y));
                }
                if (temp.x - 1 >= 0 && image.getRGB(temp.x - 1, temp.y + 1) == startColor) {
                    image.setRGB(temp.x - 1, temp.y + 1, fillColor);
                    listPoint.add(new Point(temp.x - 1, temp.y + 1));
                }
                if (temp.y - 1 >= 0 && image.getRGB(temp.x, temp.y - 1) == startColor) {
                    image.setRGB(temp.x, temp.y - 1, fillColor);
                    listPoint.add(new Point(temp.x, temp.y - 1));
                }
                if (image.getRGB(temp.x, temp.y + 1) == startColor) {
                    image.setRGB(temp.x, temp.y + 1, fillColor);
                    listPoint.add(new Point(temp.x, temp.y + 1));
                }
                if (temp.x - 1 >= 0 && image.getRGB(temp.x - 1, temp.y + 1) == startColor) {
                    image.setRGB(temp.x - 1, temp.y + 1, fillColor);
                    listPoint.add(new Point(temp.x - 1, temp.y + 1));
                }
                if (image.getRGB(temp.x, temp.y + 1) == startColor) {
                    image.setRGB(temp.x, temp.y + 1, fillColor);
                    listPoint.add(new Point(temp.x, temp.y + 1));
                }
                if (image.getRGB(temp.x + 1, temp.y + 1) == startColor) {
                    image.setRGB(temp.x + 1, temp.y + 1, fillColor);
                    listPoint.add(new Point(temp.x + 1, temp.y + 1));
                }

            } else {

            }
            listPoint.remove(0);
        }

    }

    public void boundaryFill2(int x, int y, BufferedImage image) {
        int startColor = image.getRGB(x, y);
        int fillColor = this.color.getRGB();

        if (startColor == fillColor) {
            return;
        }


        if (x >= 0 && x <= image.getWidth() - 2 && y >= 0 && y <= image.getHeight() - 2) {
            image.setRGB(x, y, fillColor);
            if (x - 1 >= 0 && y - 1 >= 0 && image.getRGB(x - 1, y - 1) == startColor) {
                boundaryFill2(x - 1, y - 1, image);
            }
            if (x - 1 >= 0 && image.getRGB(x - 1, y) == startColor) {
                boundaryFill2(x - 1, y, image);
            }
            if (x - 1 >= 0 && image.getRGB(x - 1, y + 1) == startColor) {
                boundaryFill2(x - 1, y + 1, image);
            }
            if (y - 1 >= 0 && image.getRGB(x, y - 1) == startColor) {
                boundaryFill2(x, y - 1, image);
            }
            if (image.getRGB(x, y + 1) == startColor) {
                boundaryFill2(x, y + 1, image);
            }
            if (x - 1 >= 0 && image.getRGB(x - 1, y + 1) == startColor) {
                boundaryFill2(x - 1, y + 1, image);
            }
            if (image.getRGB(x, y + 1) == startColor) {
                boundaryFill2(x, y + 1, image);
            }
            if (image.getRGB(x + 1, y + 1) == startColor) {
                boundaryFill2(x + 1, y + 1, image);
            }
        }
    }

    /**
     * @return diem bat dau lan mau
     */
    public Point getPoint() {
        return this.start;
    }

    public void setArrPoint(Point point) {
        arrPoint.add(point);
    }

    public ArrayList<Point> getArrPoint() {
        return arrPoint;
    }

    @Override
    public void draw(Graphics2D g2d) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

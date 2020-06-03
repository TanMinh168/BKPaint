
package property;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;


public class ColorDialog extends javax.swing.JPanel {

    private ImageIcon strokeIcon;
    private ImageIcon fillIcon;
    private Color strokeColor;
    private Color fillColor;

    private Color colorPicker;

    /**
     * Tao form ColorDialog
     */
    public ColorDialog() {
        strokeIcon = new ColorCell(Color.BLACK);
        fillIcon = new ColorCell(Color.WHITE);
        strokeColor = Color.BLACK;
        fillColor = Color.WHITE;
        initComponents();
        bStrokeColor.setIcon(strokeIcon);
        bFillColor.setIcon(fillIcon);
        
        colorChooser.setIcon(new ImageIcon(getImageIcon("/icon/ColorChooser.png")));
    }
    public Image getImageIcon(String path) {
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path));
        return image;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        bFillColor = new javax.swing.JToggleButton();
        colorPane = new property.ColorPane();
        jLabel2 = new javax.swing.JLabel();
        colorChooser = new javax.swing.JButton();
        bStrokeColor = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        buttonGroup1.add(bFillColor);
        bFillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFillColorActionPerformed(evt);
            }
        });

        colorPane.setBackground(new java.awt.Color(204, 204, 255));
        colorPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                colorPaneMousePressed(evt);
            }
        });

        jLabel2.setText("      Fill");

        colorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorChooserActionPerformed(evt);
            }
        });

        buttonGroup1.add(bStrokeColor);
        bStrokeColor.setSelected(true);

        jLabel1.setText("  Stroke");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bStrokeColor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addComponent(colorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bStrokeColor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addComponent(bFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2))
            .addComponent(colorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bFillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFillColorActionPerformed
    }//GEN-LAST:event_bFillColorActionPerformed
    /**
     * 
     * set color khi bấm chọn màu trong Colordialog
     */
    
    private void colorPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorPaneMousePressed
        /**
         * Set color cho net ve khi chon StrokeColor
         */
    	if (bStrokeColor.isSelected()) {
            strokeIcon = colorPane.getImage();
            strokeColor = colorPane.getColor();
            bStrokeColor.setIcon(strokeIcon);
        }
    	/**
    	 * Set color cho tool to mau khi chon fillColor
    	 */
    	else if (bFillColor.isSelected()) {
            fillIcon = colorPane.getImage();
            fillColor = colorPane.getColor();
            bFillColor.setIcon(fillIcon);
        }
    }//GEN-LAST:event_colorPaneMousePressed

    /**
     * show bang chon mau mo rong va set su kien lay mau khi bam chon mau
     */
    private void colorChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserActionPerformed
        Color color = JColorChooser.showDialog(this, "specify your color", Color.yellow);
        colorPane.setImage(color);
        if (bStrokeColor.isSelected()) {
            strokeIcon = colorPane.getImage();
            strokeColor = color;
            bStrokeColor.setIcon(strokeIcon);
        } else if (bFillColor.isSelected()) {
            fillIcon = colorPane.getImage();
            fillColor = color;
            bFillColor.setIcon(fillIcon);
        }
    }//GEN-LAST:event_colorChooserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bFillColor;
    private javax.swing.JToggleButton bStrokeColor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton colorChooser;
    private property.ColorPane colorPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    public Color getStrokeColor() {
        return strokeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }
    /**
     * lay mau duoc chon va thiet lap lay mau
     */
    public void setColorPicker(Color c) {
        if (bStrokeColor.isSelected()) {
            colorPane.setImage(c);
            strokeIcon = colorPane.getImage();
            strokeColor = c;
            bStrokeColor.setIcon(strokeIcon);
        } else if (bFillColor.isSelected()) {
            colorPane.setImage(c);
            fillIcon = colorPane.getImage();
            fillColor = c;
            bFillColor.setIcon(fillIcon);
        }
    }

    public Color getColorPicker() {
        return this.colorPicker;
    }

}

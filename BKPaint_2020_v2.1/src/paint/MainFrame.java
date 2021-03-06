
package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import library.Library;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Tao form MainFrame
     * update 21h45
     * last update
     */
    public static boolean isSaved;
    private BufferedImage buff_img = null;
    private String fileName = "";
    private File fileImage = null;
    private PadPaint padPaint = null;
    private final JFileChooser fc = new JFileChooser();
    private JPanel backgroundPanel = new JPanel();
    private int width = 900, height = 450;

    public MainFrame() {
        initComponents();
        bCopy.setIcon(new ImageIcon(getImageIcon("/icon/copy2.png")));
        bUndo.setIcon(new ImageIcon(getImageIcon("/icon/undo2.png")));
        bRedo.setIcon(new ImageIcon(getImageIcon("/icon/redo2.png")));
        bCut.setIcon(new ImageIcon(getImageIcon("/icon/cut2.png")));
        bZoomadd.setIcon(new ImageIcon(getImageIcon("/icon/zoomplus.png")));
        bZoomMinus.setIcon(new ImageIcon(getImageIcon("/icon/zoomMinus.png")));
        bZoomorg.setIcon(new ImageIcon(getImageIcon("/icon/zoomorg.png")));
        bReplay.setIcon(new ImageIcon(getImageIcon("/icon/replay.png")));
        bLibrary.setIcon(new ImageIcon(getImageIcon("/icon/library.png")));
        //bZoomOut.setIcon(new ImageIcon(getImageIcon("/icon/zoomout.png")));
        //bZoomIn.setIcon(new ImageIcon(getImageIcon("/icon/zoomin.png")));
        newFile.setIcon(new ImageIcon(getImageIcon("/icon/new.png")));
        openFile.setIcon(new ImageIcon(getImageIcon("/icon/open.png")));
        saveFile.setIcon(new ImageIcon(getImageIcon("/icon/save.png")));
        saveAsFile.setIcon(new ImageIcon(getImageIcon("/icon/saveAs.png")));
        exitFile.setIcon(new ImageIcon(getImageIcon("/icon/exit.png")));
        bDelete.setIcon(new ImageIcon(getImageIcon("/icon/delete.png")));
        bPaste.setIcon(new ImageIcon(getImageIcon("/icon/paste.png")));

        
        width_tf.setText("900");
        height_tf.setText("450");
        
        padPaint = new PadPaint(width, height);
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(new Color(204, 204, 255));
        buff_img = padPaint.getBuffer();
        backgroundPanel.setPreferredSize(new Dimension(buff_img.getWidth() + 20, buff_img.getHeight() + 50));
        backgroundPanel.add(padPaint);
        scrollPane.setViewportView(backgroundPanel);
        padPaint.setColorChooser(colorDialog1);
        padPaint.setPaintTool(paintTool);
        padPaint.setStrokeState(strokeState);
        padPaint.setTextPanel(textPanel1);

        padPaint.flush();

        padPaint.setLocationStatus(lbLocation);
        padPaint.setSizeStatus(lbSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("BKPaint");
        this.setIconImage(getImageIcon("/icon/icon_image.png"));
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (padPaint.isSaving() == false) {
                    Object[] option = {"Save", "Don't Save", "Cancel"};
                    int specify = JOptionPane.showOptionDialog(null, "Do you want to save file ?", "BKPaint", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, rootPane);
                    if (specify != JOptionPane.CANCEL_OPTION && specify != JOptionPane.CLOSED_OPTION) {
                        if (specify == JOptionPane.YES_OPTION) {
                            saveImageToFile();
                            //phai luu duoc thi moi thoat
                            if (padPaint.isSaving()) {
                                System.exit(0);
                            }
                        } else {
                            System.exit(0);
                        }

                    } else {
                        return;
                    }
                } else {
                    System.exit(0);
                }

            }
        });
        paintTool.addPropertyChangeListener("tool change", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                padPaint.toolChange();
            }

        });
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
   // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        SettingPane = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        bPaste = new javax.swing.JButton();
        cbTransform = new javax.swing.JComboBox();
        bCopy = new javax.swing.JButton();
        bCut = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bUndo = new javax.swing.JButton();
        bRedo = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        colorDialog1 = new property.ColorDialog();
        strokeState = new property.StrokeState();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        paintTool = new paint.PaintTool();
        jPanel1 = new javax.swing.JPanel();
        bReplay = new JButton();
        bLibrary = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        bZoomadd = new javax.swing.JButton();
        bZoomMinus = new javax.swing.JButton();
        bZoomorg = new javax.swing.JButton();
        textPanel1 = new property.TextPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        width_tf = new javax.swing.JTextField();
        height_tf = new javax.swing.JTextField();
        OK_btn = new javax.swing.JToggleButton();
        sZoom = new javax.swing.JSlider();
        bZoomOut = new javax.swing.JButton();
        bZoomIn = new javax.swing.JButton();
        lbLocation = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        lbZoomInfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        miNew = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        saveAsFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(233, 247, 247));

        SettingPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel4.setBackground(new java.awt.Color(233, 247, 247));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel6.setBackground(new java.awt.Color(233, 247, 247));

        bPaste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPasteMouseClicked(evt);
            }
        });
        bPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPasteActionPerformed(evt);
            }
        });

        cbTransform.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rotate", "Rotate right 90", "Rotate left 90", "Rotate 180", "Flip vertical", "Flip horizontal" }));
        cbTransform.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTransformItemStateChanged(evt);
            }
        });
        cbTransform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTransformActionPerformed(evt);
            }
        });

        bCopy.setPreferredSize(new Dimension(39,39));
        bCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCopyActionPerformed(evt);
            }
        });

        bCut.setPreferredSize(new Dimension(39,39));
        bCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCutActionPerformed(evt);
            }
        });

        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUndoActionPerformed(evt);
            }
        });

        bRedo.setBorder(null);
        bRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRedoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bCopy, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(bPaste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCut, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTransform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(bUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbTransform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bPaste, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 13, Short.MAX_VALUE))
        );

        colorDialog1.setBackground(new java.awt.Color(233, 247, 247));

        paintTool.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paintToolMouseClicked(evt);
            }
        });
        paintTool.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                paintToolPropertyChange(evt);
            }
        });

        jLayeredPane1.setLayer(paintTool, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(paintTool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(paintTool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strokeState, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(colorDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(strokeState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(colorDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SettingPane.addTab("Home", jPanel4);

        jPanel1.setBackground(new java.awt.Color(233, 247, 247));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        bReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReplayActionPerformed(evt);
            }
        });

        bLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLibraryActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(233, 247, 247));

        bZoomadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZoomaddActionPerformed(evt);
            }
        });

        bZoomMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZoomMinusActionPerformed(evt);
            }
        });

        bZoomorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZoomorgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(bZoomadd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(bZoomMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(bZoomorg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bZoomadd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bZoomMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bZoomorg, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        textPanel1.setBackground(new java.awt.Color(233, 247, 247));

        jPanel2.setBackground(new java.awt.Color(233, 247, 247));

        jLabel4.setText("Width:");

        jLabel3.setText("Height:");

        width_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                width_tfActionPerformed(evt);
            }
        });

        OK_btn.setText("OK");
        OK_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(width_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(height_tf)))
                    .addComponent(OK_btn))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(width_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(height_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(OK_btn)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(textPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(bReplay, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bReplay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SettingPane.addTab("Option", jPanel1);

        sZoom.setMajorTickSpacing(10);
        sZoom.setMinimum(20);
        sZoom.setMinorTickSpacing(10);
        sZoom.setValue(60);
        sZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sZoomStateChanged(evt);
            }
        });

        bZoomOut.setPreferredSize(new Dimension(20,20));
        bZoomOut.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\BKPaint_v2.8\\BKPaint_2020_v2.1\\build\\classes\\icon\\zoomout2 .png")); // NOI18N
        bZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZoomOutActionPerformed(evt);
            }
        });

        bZoomIn.setPreferredSize(new Dimension(20,20));
        bZoomIn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\BKPaint_v2.8\\BKPaint_2020_v2.1\\build\\classes\\icon\\zoomin2.png")); // NOI18N
        bZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZoomInActionPerformed(evt);
            }
        });

        lbZoomInfo.setText("100%");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/location.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/size.png"))); // NOI18N

        jMenuBar1.setMargin(new java.awt.Insets(0, 0, 0, 500));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(20, 21));

        miNew.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        miNew.add(newFile);

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        miNew.add(openFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        miNew.add(saveFile);

        saveAsFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsFile.setText("Save As");
        saveAsFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsFileActionPerformed(evt);
            }
        });
        miNew.add(saveAsFile);
        miNew.add(jSeparator1);

        exitFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitFile.setText("Exit");
        exitFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFileActionPerformed(evt);
            }
        });
        miNew.add(exitFile);

        jMenuBar1.add(miNew);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbZoomInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(SettingPane)
            .addComponent(scrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SettingPane, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbZoomInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        openAnImage();
    }//GEN-LAST:event_openFileActionPerformed

    public void openAnImage() {
        JFileChooser filechooser = new JFileChooser("Open A File");
        int result = 0;
        FileNameExtensionFilter bitmap = new FileNameExtensionFilter("Bitmap Files (*.bmp;*.dib)", "bmp", "dib");
        filechooser.setFileFilter(bitmap);
        FileNameExtensionFilter jpeg = new FileNameExtensionFilter("JPEG (*.jpg;*.jpeg;*.jpe;*jfif)", "jpg", "jpeg", "jpe", "jfif");
        filechooser.setFileFilter(jpeg);
        FileNameExtensionFilter gif = new FileNameExtensionFilter("GIF (*.gif)", "gif");
        filechooser.setFileFilter(gif);
        FileNameExtensionFilter tiff = new FileNameExtensionFilter("TIFF (*.tif;*.tiff)", "tif", "tiff");
        filechooser.setFileFilter(tiff);
        FileNameExtensionFilter png = new FileNameExtensionFilter("PNG (*.png)", "png");
        filechooser.setFileFilter(png);
        FileNameExtensionFilter ico = new FileNameExtensionFilter("ICO (*.ico)", "ico");
        filechooser.setFileFilter(ico);
        FileNameExtensionFilter allFile = new FileNameExtensionFilter("All Picture Files", "bmp", "dib", "jpg", "jpeg", "jpe", "jfif", "gif", "tif", "tiff", "png", "ico");
        filechooser.setFileFilter(allFile);

        result = filechooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(file.getPath()));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (img != null) {
                if (padPaint.isSaving() == false) {
                    Object[] option = {"Save", "Don't Save", "Cancel"};
                    int specify = JOptionPane.showOptionDialog(this, "Do you want to save file ?", "BKPaint", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, rootPane);
                    if (specify != JOptionPane.CANCEL_OPTION && specify != JOptionPane.CLOSED_OPTION) {
                        if (specify == JOptionPane.YES_OPTION) {
                            saveImageToFile();
                        }
                    } else {
                        return;
                    }

                }
                padPaint.loadImage(img);
               
                backgroundPanel.setPreferredSize(new Dimension(img.getWidth() + 20, img.getHeight() + 20));
            }
        }
    }
    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        if (padPaint.isSaving() == false) {
            Object[] option = {"Save", "Don't Save", "Cancel"};
            int specify = JOptionPane.showOptionDialog(this, "Do you want to save file ?", "BKPaint", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, rootPane);
            if (specify != JOptionPane.CANCEL_OPTION && specify != JOptionPane.CLOSED_OPTION) {
                if (specify == JOptionPane.YES_OPTION) {
                    if (saveImageToFile()) {
                        padPaint.flush();
                        padPaint.SetSize(width,height);
                    } else {
                        return;
                    }
                }

                padPaint.flush();
            } else {
                return;
            }
        } else if (padPaint.isSaving() == true) {
            padPaint.flush();
        }

    }//GEN-LAST:event_newFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {
        if (padPaint.isSaving() == false) {
            saveImageToFile();
        }
    }

    public boolean saveImageToFile() {
        JFileChooser saveFile = new JFileChooser("Save File");
        int result = 0;
        FileFilter filler;
        BufferedImage img = null;

        FileNameExtensionFilter jpeg = new FileNameExtensionFilter("JPEG (*.jpg;*.jpeg;*.jpe;*jfif)", "jpg", "jpeg", "jpe", "jfif");
        saveFile.setFileFilter(jpeg);
        FileNameExtensionFilter gif = new FileNameExtensionFilter("GIF (*.gif)", "gif");
        saveFile.setFileFilter(gif);

        FileNameExtensionFilter png = new FileNameExtensionFilter("PNG (*.png)", "png");
        saveFile.setFileFilter(png);

        File demo = new File("Untitled.png");
        saveFile.setSelectedFile(demo);
        result = saveFile.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {                              
            filler = saveFile.getFileFilter();                                  
            fileImage = saveFile.getCurrentDirectory();                         
            fileName = fileImage.getPath() + "\\" + saveFile.getSelectedFile().getName();  
            fileImage = new File(fileName);                                              

            String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            if (fileImage.exists() == true) {
                int r = JOptionPane.showConfirmDialog(this, saveFile.getSelectedFile().getName() + " already exists." + "\nDo you want to replace it?", "hello", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (r == JOptionPane.YES_OPTION) {

                    padPaint.saveImage(fileImage, extension);
                    return true;
                }
            } else {
                padPaint.saveImage(fileImage, extension);
                return true;
            }
        }
        return false;
    }

    private void bZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZoomInActionPerformed
        sZoom.setValue(sZoom.getValue() + 10);
    }//GEN-LAST:event_bZoomInActionPerformed

    private void bZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZoomOutActionPerformed
        sZoom.setValue(sZoom.getValue() - 10);
    }//GEN-LAST:event_bZoomOutActionPerformed

    private void exitFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFileActionPerformed
        if (padPaint.isSaving() == false) {
            Object[] option = {"Save", "Don't Save", "Cancel"};
            int specify = JOptionPane.showOptionDialog(null, "Do you want to save file ?", "BKPaint", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, rootPane);
            if (specify != JOptionPane.CANCEL_OPTION && specify != JOptionPane.CLOSED_OPTION) {
                if (specify == JOptionPane.YES_OPTION) {
                    saveImageToFile();
                    //phai luu duoc thi moi thoat
                    if (padPaint.isSaving()) {
                        System.exit(0);
                    }
                } else {
                    System.exit(0);
                }

            } else {
                return;
            }
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_exitFileActionPerformed

    private void saveAsFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsFileActionPerformed
        saveImageToFile();
    }//GEN-LAST:event_saveAsFileActionPerformed

    private void sZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sZoomStateChanged
        padPaint.setZoom(sZoom.getValue());
        int zoom = (int) (padPaint.getZoom() * 100);
        String zoomInfo = zoom + "%";
        lbZoomInfo.setText(zoomInfo);
        backgroundPanel.setPreferredSize(new Dimension(padPaint.getWidth() + 30, padPaint.getHeight() + 30));

    }//GEN-LAST:event_sZoomStateChanged

    private void OK_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_btnActionPerformed
        // TODO add your handling code here:
        /**
        * Neu file chua duoc luu ma muon mo rong nen ve thi can hien dialog hoi xem nguoi dung co muon luu hay khong
        */

        if (padPaint.isSaving() == false) {
            Object[] option = {"Save", "Don't Save", "Cancel"};
            int specify = JOptionPane.showOptionDialog(null, "Do you want to save file ?", "BKPaint", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, rootPane);
            if (specify != JOptionPane.CANCEL_OPTION && specify != JOptionPane.CLOSED_OPTION) {
                if (specify == JOptionPane.YES_OPTION) {
                    saveImageToFile();
                }

            }
            else {
                return;
            }
        }

        try{
            int value = Integer.parseInt(width_tf.getText());
            if(value > 0)
            width = value;
            else{
                JOptionPane.showMessageDialog(null,"Width value must be larger than 0!", "Invalid value", JOptionPane.ERROR_MESSAGE);
                width_tf.setText(String.valueOf(width));
                height_tf.setText(String.valueOf(height));
                return;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Width value must be integer!", "Invalid value", JOptionPane.ERROR_MESSAGE);
            width_tf.setText(String.valueOf(width));
            height_tf.setText(String.valueOf(height));
            return;
        }

        try{
            int value = Integer.parseInt(height_tf.getText());
            if(value > 0)
            height = value;
            else{
                JOptionPane.showMessageDialog(null,"Height value must be larger than 0!", "Invalid value", JOptionPane.ERROR_MESSAGE);
                width_tf.setText(String.valueOf(width));
                height_tf.setText(String.valueOf(height));
                return;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Height value must be integer!", "Invalid value", JOptionPane.ERROR_MESSAGE);
            width_tf.setText(String.valueOf(width));
            height_tf.setText(String.valueOf(height));
            return;
        }
        padPaint.SetSize(width, height);
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(new Color(204, 204, 255));
        buff_img = padPaint.getBuffer();
        backgroundPanel.setPreferredSize(new Dimension(buff_img.getWidth() + 120, buff_img.getHeight() + 50));
        backgroundPanel.add(padPaint);
        scrollPane.setViewportView(backgroundPanel);
        padPaint.setColorChooser(colorDialog1);
        padPaint.setPaintTool(paintTool);
        padPaint.setStrokeState(strokeState);
        padPaint.setTextPanel(textPanel1);

        padPaint.flush();

        padPaint.setLocationStatus(lbLocation);
        padPaint.setSizeStatus(lbSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("BKPaint");
        this.setIconImage(getImageIcon("/icon/icon_image.png"));
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (padPaint.isSaving() == false) {
                    Object[] option = {"Save", "Don't Save", "Cancel"};
                    int specify = JOptionPane.showOptionDialog(null, "Do you want to save file ?", "BKPaint", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, rootPane);
                    if (specify != JOptionPane.CANCEL_OPTION && specify != JOptionPane.CLOSED_OPTION) {
                        if (specify == JOptionPane.YES_OPTION) {
                            saveImageToFile();
                            //phai luu duoc thi moi thoat
                            if (padPaint.isSaving()) {
                                System.exit(0);
                            }
                        } else {
                            System.exit(0);
                        }

                    } else {
                        return;
                    }
                } else {
                    System.exit(0);
                }

            }
        });
        paintTool.addPropertyChangeListener("tool change", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                padPaint.toolChange();
            }

        });
    }//GEN-LAST:event_OK_btnActionPerformed

    private void width_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_width_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_width_tfActionPerformed

    private void bZoomorgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZoomorgActionPerformed
        sZoom.setValue(60);
    }//GEN-LAST:event_bZoomorgActionPerformed

    private void bZoomMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZoomMinusActionPerformed
        sZoom.setValue(sZoom.getValue() - 10);
    }//GEN-LAST:event_bZoomMinusActionPerformed

    private void bZoomaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZoomaddActionPerformed
        sZoom.setValue(sZoom.getValue() + 10);
    }//GEN-LAST:event_bZoomaddActionPerformed

    private void bLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLibraryActionPerformed
        Library library = new Library(this, true);
        buff_img = library.getBufferedImage();
        if (buff_img != null) {
            //anh chua duoc luu
            if (padPaint.isSaving() == false) {
                Object[] option = {"Save", "Don't Save", "Cancel"};
                int specify = JOptionPane.showOptionDialog(this, "Do you want to save file ?", "BKPaint", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, rootPane);
                if (specify != JOptionPane.CANCEL_OPTION && specify != JOptionPane.CLOSED_OPTION) {
                    if (specify == JOptionPane.YES_OPTION) {
                        saveImageToFile();
                    }
                    padPaint.loadImage(library.getBufferedImage());
                    backgroundPanel.setPreferredSize(new Dimension(buff_img.getWidth() + 120, buff_img.getHeight() + 50));
                }
            } else if (padPaint.isSaving() == true) {
                padPaint.loadImage(library.getBufferedImage());
                backgroundPanel.setPreferredSize(new Dimension(buff_img.getWidth() + 120, buff_img.getHeight() + 50));
            }

        }
    }//GEN-LAST:event_bLibraryActionPerformed

    private void bReplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReplayActionPerformed
        padPaint.toolChange();
        System.gc();
        new ReplayDialog(this, true, padPaint.getListState());
    }//GEN-LAST:event_bReplayActionPerformed

    private void paintToolPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_paintToolPropertyChange
        System.out.println("tool change");
    }//GEN-LAST:event_paintToolPropertyChange

    private void paintToolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintToolMouseClicked

    }//GEN-LAST:event_paintToolMouseClicked

    private void bRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRedoActionPerformed
        // TODO add your handling code here:
        padPaint.redo();
    }//GEN-LAST:event_bRedoActionPerformed

    private void bUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUndoActionPerformed
        // TODO add your handling code here:
        padPaint.undo();
    }//GEN-LAST:event_bUndoActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        padPaint.delete();
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCutActionPerformed
        padPaint.cut();
    }//GEN-LAST:event_bCutActionPerformed

    private void bCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCopyActionPerformed
        padPaint.copy();
    }//GEN-LAST:event_bCopyActionPerformed

//update by hung
    private void cbTransformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTransformActionPerformed
        if (cbTransform.getSelectedItem() == cbTransform.getItemAt(1)) {
            padPaint.rotate(90);

        } else if (cbTransform.getSelectedItem() == cbTransform.getItemAt(2)) {
            padPaint.rotate(-90);

        } else if (cbTransform.getSelectedItem() == cbTransform.getItemAt(3)) {
            padPaint.rotate(180);

        } else if (cbTransform.getSelectedItem() == cbTransform.getItemAt(4)) {
            padPaint.flipping(1);

        } else if (cbTransform.getSelectedItem() == cbTransform.getItemAt(5)) {
            padPaint.flipping(2);

        }
        buff_img = padPaint.getBuffer();
        backgroundPanel.setPreferredSize(new Dimension(padPaint.getWidth() + 30, padPaint.getHeight() + 30));
        cbTransform.setSelectedIndex(0);
    }//GEN-LAST:event_cbTransformActionPerformed

    private void cbTransformItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTransformItemStateChanged

    }//GEN-LAST:event_cbTransformItemStateChanged

    private void bPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPasteActionPerformed
        padPaint.paste();
    }//GEN-LAST:event_bPasteActionPerformed

    private void bPasteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPasteMouseClicked
        // TODO add your handling code here:
        padPaint.paste();
    }//GEN-LAST:event_bPasteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /**
         *  Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton OK_btn;
    private javax.swing.JTabbedPane SettingPane;
    private javax.swing.JButton bCopy;
    private javax.swing.JButton bCut;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bLibrary;
    private javax.swing.JButton bPaste;
    private javax.swing.JButton bRedo;
    private javax.swing.JButton bReplay;
    private javax.swing.JButton bUndo;
    private javax.swing.JButton bZoomIn;
    private javax.swing.JButton bZoomMinus;
    private javax.swing.JButton bZoomOut;
    private javax.swing.JButton bZoomadd;
    private javax.swing.JButton bZoomorg;
    private javax.swing.JComboBox cbTransform;
    private property.ColorDialog colorDialog1;
    private javax.swing.JMenuItem exitFile;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField height_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lbLocation;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbZoomInfo;
    private javax.swing.JMenu miNew;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private paint.PaintTool paintTool;
    private javax.swing.JSlider sZoom;
    private javax.swing.JMenuItem saveAsFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JScrollPane scrollPane;
    private property.StrokeState strokeState;
    private property.TextPanel textPanel1;
    private javax.swing.JTextField width_tf;
    // End of variables declaration//GEN-END:variables
}

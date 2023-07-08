package View;

import ViewModels.SanPhamResponse;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;

public class Item extends javax.swing.JPanel {
    private boolean selected;
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    private SanPhamResponse data;

    public SanPhamResponse getData() {
        return data;
    }
    public void setData(SanPhamResponse data) {
        this.data = data;   
        Image img = new ImageIcon(data.getDuongDanAnh()).getImage();
        hinhAnh.setImage(new ImageIcon(img));
        lbTenSP.setText(data.getTenSP());
        lbDanhMuc.setText(data.getTenDM());
        DecimalFormat df = new DecimalFormat("###,###.##");
        lbDonGia.setText(df.format(data.getGia()) + " VNÐ");
        lbSize.setText(data.getTenSize());
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if(selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        g2.dispose();
        super.paint(g); 
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lbDonGia = new javax.swing.JLabel();
        lbDanhMuc = new javax.swing.JLabel();
        hinhAnh = new View.Swing.PictureBox();
        lbTenSP = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setOpaque(false);

        lbDonGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDonGia.setForeground(new java.awt.Color(76, 76, 76));
        lbDonGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDonGia.setText("0 VNÐ");

        lbDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDanhMuc.setForeground(new java.awt.Color(178, 178, 178));
        lbDanhMuc.setText("Item name");

        hinhAnh.setImage(new javax.swing.ImageIcon(getClass().getResource("/Image/HongTraDauTay.png"))); // NOI18N

        lbTenSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSP.setForeground(new java.awt.Color(76, 76, 76));
        lbTenSP.setText("Item name");
        lbTenSP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbTenSP.setRequestFocusEnabled(false);

        lbSize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSize.setForeground(new java.awt.Color(76, 76, 76));
        lbSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSize.setText("M");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTenSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDanhMuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDonGia)
                .addGap(0, 0, 0)
                .addComponent(lbSize)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private View.Swing.PictureBox hinhAnh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbDanhMuc;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbTenSP;
    // End of variables declaration//GEN-END:variables
}

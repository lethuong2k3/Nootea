package View;

import Utilities.Auth;
import Utilities.Msgbox;
import java.awt.Color;

public class TrangChu extends javax.swing.JFrame {
    Color DefaultColor, ClickedColor;
    public TrangChu() {
        initComponents();
        DefaultColor = new Color(13,36,51);
        ClickedColor = new Color(240,151,57);
        
       menuBanHang.setBackground(ClickedColor);
       menuHoaDon.setBackground(DefaultColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(DefaultColor);
       menuSanPham.setBackground(DefaultColor);
       menuKhuyenMai.setBackground(DefaultColor);
       menuThongKe.setBackground(DefaultColor);
       menuThoat.setBackground(DefaultColor);
       BanHang bh = new BanHang();
       jDesktopPanel.removeAll();
       jDesktopPanel.add(bh).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pictureBox1 = new View.Swing.PictureBox();
        menuHoaDon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menuBanHang = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        menuSanPham = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        menuKhuyenMai = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        menuNhanVien = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        menuKhachHang = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        menuThoat = new javax.swing.JPanel();
        lbThoat = new javax.swing.JLabel();
        menuThongKe = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jDesktopPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(13, 36, 51));

        jPanel5.setBackground(new java.awt.Color(255, 204, 0));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Image/logoNootea.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        menuHoaDon.setBackground(new java.awt.Color(13, 36, 51));
        menuHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuHoaDonMousePressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(13, 36, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-paid-bill-32.png"))); // NOI18N
        jLabel2.setText("Hóa đơn");

        javax.swing.GroupLayout menuHoaDonLayout = new javax.swing.GroupLayout(menuHoaDon);
        menuHoaDon.setLayout(menuHoaDonLayout);
        menuHoaDonLayout.setHorizontalGroup(
            menuHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuHoaDonLayout.setVerticalGroup(
            menuHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        menuBanHang.setBackground(new java.awt.Color(13, 36, 51));
        menuBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBanHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuBanHangMousePressed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(13, 36, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-shopping-cart-30.png"))); // NOI18N
        jLabel9.setText("Bán hàng");

        javax.swing.GroupLayout menuBanHangLayout = new javax.swing.GroupLayout(menuBanHang);
        menuBanHang.setLayout(menuBanHangLayout);
        menuBanHangLayout.setHorizontalGroup(
            menuBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuBanHangLayout.setVerticalGroup(
            menuBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBanHangLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
        );

        menuSanPham.setBackground(new java.awt.Color(13, 36, 51));
        menuSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuSanPhamMousePressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(13, 36, 51));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-shipping-product-24.png"))); // NOI18N
        jLabel11.setText("Sản phẩm");

        javax.swing.GroupLayout menuSanPhamLayout = new javax.swing.GroupLayout(menuSanPham);
        menuSanPham.setLayout(menuSanPhamLayout);
        menuSanPhamLayout.setHorizontalGroup(
            menuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuSanPhamLayout.setVerticalGroup(
            menuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        menuKhuyenMai.setBackground(new java.awt.Color(13, 36, 51));
        menuKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuKhuyenMai.setPreferredSize(new java.awt.Dimension(121, 75));
        menuKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuKhuyenMaiMousePressed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(13, 36, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-sale-price-tag-30.png"))); // NOI18N
        jLabel12.setText("Khuyến mại");

        javax.swing.GroupLayout menuKhuyenMaiLayout = new javax.swing.GroupLayout(menuKhuyenMai);
        menuKhuyenMai.setLayout(menuKhuyenMaiLayout);
        menuKhuyenMaiLayout.setHorizontalGroup(
            menuKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        menuKhuyenMaiLayout.setVerticalGroup(
            menuKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        menuNhanVien.setBackground(new java.awt.Color(13, 36, 51));
        menuNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuNhanVien.setPreferredSize(new java.awt.Dimension(121, 75));
        menuNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuNhanVienMousePressed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(13, 36, 51));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-staff-30.png"))); // NOI18N
        jLabel13.setText("Nhân viên");

        javax.swing.GroupLayout menuNhanVienLayout = new javax.swing.GroupLayout(menuNhanVien);
        menuNhanVien.setLayout(menuNhanVienLayout);
        menuNhanVienLayout.setHorizontalGroup(
            menuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuNhanVienLayout.setVerticalGroup(
            menuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        menuKhachHang.setBackground(new java.awt.Color(13, 36, 51));
        menuKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuKhachHang.setPreferredSize(new java.awt.Dimension(121, 75));
        menuKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuKhachHangMousePressed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(13, 36, 51));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-search-client-30.png"))); // NOI18N
        jLabel14.setText("Khách hàng");

        javax.swing.GroupLayout menuKhachHangLayout = new javax.swing.GroupLayout(menuKhachHang);
        menuKhachHang.setLayout(menuKhachHangLayout);
        menuKhachHangLayout.setHorizontalGroup(
            menuKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuKhachHangLayout.setVerticalGroup(
            menuKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        menuThoat.setBackground(new java.awt.Color(13, 36, 51));
        menuThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuThoat.setPreferredSize(new java.awt.Dimension(121, 75));
        menuThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThoatMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuThoatMouseReleased(evt);
            }
        });

        lbThoat.setBackground(new java.awt.Color(13, 36, 51));
        lbThoat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbThoat.setForeground(new java.awt.Color(255, 255, 255));
        lbThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-log-out-25.png"))); // NOI18N
        lbThoat.setText("Thoát");
        lbThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThoatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuThoatLayout = new javax.swing.GroupLayout(menuThoat);
        menuThoat.setLayout(menuThoatLayout);
        menuThoatLayout.setHorizontalGroup(
            menuThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuThoatLayout.setVerticalGroup(
            menuThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        menuThongKe.setBackground(new java.awt.Color(13, 36, 51));
        menuThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuThongKeMousePressed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(13, 36, 51));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-statistical-32.png"))); // NOI18N
        jLabel16.setText("Thống kê");
        jLabel16.setPreferredSize(new java.awt.Dimension(121, 75));

        javax.swing.GroupLayout menuThongKeLayout = new javax.swing.GroupLayout(menuThongKe);
        menuThongKe.setLayout(menuThongKeLayout);
        menuThongKeLayout.setHorizontalGroup(
            menuThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuThongKeLayout.setVerticalGroup(
            menuThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuBanHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
            .addComponent(menuNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
            .addComponent(menuKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
            .addComponent(menuThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
            .addComponent(menuThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDesktopPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1415, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDesktopPanel))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuBanHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBanHangMousePressed
       menuBanHang.setBackground(ClickedColor);
       menuHoaDon.setBackground(DefaultColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(DefaultColor);
       menuSanPham.setBackground(DefaultColor);
       menuKhuyenMai.setBackground(DefaultColor);
       menuThongKe.setBackground(DefaultColor);
       menuThoat.setBackground(DefaultColor);
    }//GEN-LAST:event_menuBanHangMousePressed

    private void menuHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHoaDonMousePressed
       menuBanHang.setBackground(DefaultColor);
       menuHoaDon.setBackground(ClickedColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(DefaultColor);
       menuSanPham.setBackground(DefaultColor);
       menuKhuyenMai.setBackground(DefaultColor);
       menuThongKe.setBackground(DefaultColor);
       menuThoat.setBackground(DefaultColor);
    }//GEN-LAST:event_menuHoaDonMousePressed

    private void menuSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSanPhamMousePressed
       menuBanHang.setBackground(DefaultColor);
       menuHoaDon.setBackground(DefaultColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(DefaultColor);
       menuSanPham.setBackground(ClickedColor);
       menuKhuyenMai.setBackground(DefaultColor);
       menuThongKe.setBackground(DefaultColor);
       menuThoat.setBackground(DefaultColor);
    }//GEN-LAST:event_menuSanPhamMousePressed

    private void menuKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKhuyenMaiMousePressed
       menuBanHang.setBackground(DefaultColor);
       menuHoaDon.setBackground(DefaultColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(DefaultColor);
       menuSanPham.setBackground(DefaultColor);
       menuKhuyenMai.setBackground(ClickedColor);
       menuThongKe.setBackground(DefaultColor);
       menuThoat.setBackground(DefaultColor);
    }//GEN-LAST:event_menuKhuyenMaiMousePressed

    private void menuNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNhanVienMousePressed
       menuBanHang.setBackground(DefaultColor);
       menuHoaDon.setBackground(DefaultColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(ClickedColor);
       menuSanPham.setBackground(DefaultColor);
       menuKhuyenMai.setBackground(DefaultColor);
       menuThongKe.setBackground(DefaultColor);
       menuThoat.setBackground(DefaultColor);
    }//GEN-LAST:event_menuNhanVienMousePressed

    private void menuThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongKeMousePressed
       menuBanHang.setBackground(DefaultColor);
       menuHoaDon.setBackground(DefaultColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(DefaultColor);
       menuSanPham.setBackground(DefaultColor);
       menuKhuyenMai.setBackground(DefaultColor);
       menuThongKe.setBackground(ClickedColor);
       menuThoat.setBackground(DefaultColor);
    }//GEN-LAST:event_menuThongKeMousePressed

    private void menuThoatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThoatMouseReleased
       menuBanHang.setBackground(DefaultColor);
       menuHoaDon.setBackground(DefaultColor);
       menuKhachHang.setBackground(DefaultColor);
       menuNhanVien.setBackground(DefaultColor);
       menuSanPham.setBackground(DefaultColor);
       menuKhuyenMai.setBackground(DefaultColor);
       menuThongKe.setBackground(DefaultColor);
       menuThoat.setBackground(ClickedColor);
    }//GEN-LAST:event_menuThoatMouseReleased

    private void menuBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBanHangMouseClicked
        BanHang bh = new BanHang();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(bh).setVisible(true);
    }//GEN-LAST:event_menuBanHangMouseClicked

    private void lbThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThoatMouseClicked
        if (Msgbox.confirm(this, "Bạn muốn thoát ứng dụng ?")) {    
            Auth.clear();
            System.exit(0);
        }
    }//GEN-LAST:event_lbThoatMouseClicked

    private void menuThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThoatMouseClicked
        
    }//GEN-LAST:event_menuThoatMouseClicked

    private void menuKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKhachHangMousePressed
        menuBanHang.setBackground(DefaultColor);
        menuHoaDon.setBackground(DefaultColor);
        menuKhachHang.setBackground(ClickedColor);
        menuNhanVien.setBackground(DefaultColor);
        menuSanPham.setBackground(DefaultColor);
        menuKhuyenMai.setBackground(DefaultColor);
        menuThongKe.setBackground(DefaultColor);
        menuThoat.setBackground(DefaultColor);
    }//GEN-LAST:event_menuKhachHangMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbThoat;
    private javax.swing.JPanel menuBanHang;
    private javax.swing.JPanel menuHoaDon;
    private javax.swing.JPanel menuKhachHang;
    private javax.swing.JPanel menuKhuyenMai;
    private javax.swing.JPanel menuNhanVien;
    private javax.swing.JPanel menuSanPham;
    private javax.swing.JPanel menuThoat;
    private javax.swing.JPanel menuThongKe;
    private View.Swing.PictureBox pictureBox1;
    // End of variables declaration//GEN-END:variables
}

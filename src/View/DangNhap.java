package View;

import DomainModels.NhanVien;
import Services.NhanVienService;
import Services.impl.NhanVienServiceImpl;
import Utilities.Auth;
import Utilities.Msgbox;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author thuon
 */
public class DangNhap extends javax.swing.JDialog {
    NhanVienService nvService = new NhanVienServiceImpl();
    public DangNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pictureBox2 = new View.Swing.PictureBox();
        jPanel3 = new javax.swing.JPanel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        jpanelClose = new javax.swing.JPanel();
        lbClose = new javax.swing.JLabel();
        errorTaiKhoan = new javax.swing.JLabel();
        errorMatKhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(74, 31, 61));

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Image/logoNootea.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 144, 221, 30));
        jPanel3.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 221, 221, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tài khoản");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 118, 84, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mật khẩu");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 195, 84, -1));

        btnDangNhap.setBackground(new java.awt.Color(186, 79, 84));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel3.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 280, 152, 37));

        jpanelClose.setBackground(new java.awt.Color(186, 79, 84));
        jpanelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbClose.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbClose.setForeground(new java.awt.Color(74, 31, 61));
        lbClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClose.setText("X");
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpanelCloseLayout = new javax.swing.GroupLayout(jpanelClose);
        jpanelClose.setLayout(jpanelCloseLayout);
        jpanelCloseLayout.setHorizontalGroup(
            jpanelCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelCloseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpanelCloseLayout.setVerticalGroup(
            jpanelCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelCloseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbClose))
        );

        jPanel3.add(jpanelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 0, -1, -1));

        errorTaiKhoan.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(errorTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 221, -1));

        errorMatKhau.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(errorMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 257, 221, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void dangNhap() {
        try {
            String taiKhoan = txtTaiKhoan.getText();
            String pass = new String(txtMatKhau.getPassword());
            NhanVien nv = nvService.getOne(taiKhoan);
            if (taiKhoan.trim().length()==0) {
                errorTaiKhoan.setText("Tài khoản không được để trống!");
            } else if (pass.trim().length()==0) {
                errorTaiKhoan.setText("");
                errorMatKhau.setText("Mật khẩu không được để trống!");
            } else if (nv == null) {
                errorTaiKhoan.setText("Sai tài khoản!");
                errorMatKhau.setText("");
            } else if (!pass.equals(nv.getMatKhau())) {
                errorMatKhau.setText("Sai mật khẩu!");
                errorTaiKhoan.setText("");
            } else {
                Msgbox.alert(this, "Đăng nhập thành công!");
                Auth.user = nv;
                this.dispose();
                TrangChu trangChu = new TrangChu();
                trangChu.setVisible(true);
            }
        } catch (Exception e) {
            Msgbox.alert(this, "Đăng nhập thất bại!");
            e.printStackTrace();
        }
    }
    
    public void setColor(JPanel p) {
        p.setBackground(new Color(74,31,61));
    }
    
    public void resetColor(JPanel p) {
        p.setBackground(new Color(186,79,84));
    }
    
    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbCloseMouseClicked

    private void lbCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseEntered
        setColor(jpanelClose);
        lbClose.setForeground(new Color(186,79,84));
    }//GEN-LAST:event_lbCloseMouseEntered

    private void lbCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseExited
        resetColor(jpanelClose);
        lbClose.setForeground(new Color(74,31,61));
    }//GEN-LAST:event_lbCloseMouseExited

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhap dialog = new DangNhap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel errorMatKhau;
    private javax.swing.JLabel errorTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpanelClose;
    private javax.swing.JLabel lbClose;
    private View.Swing.PictureBox pictureBox2;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}

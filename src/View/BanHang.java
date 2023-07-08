package View;

import DomainModels.DanhMucSP;
import DomainModels.HinhThucThanhToan;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import DomainModels.Size;
import DomainModels.SanPham;
import Services.DanhMucSPService;
import Services.HinhThucTTService;
import Services.HoaDonCTService;
import Services.HoaDonService;
import Services.KhachHangService;
import Services.SanPhamService;
import Services.SizeService;
import Services.impl.DanhMucSPServiceImpl;
import Services.impl.HinhThucTTServiceImpl;
import Services.impl.HoaDonCTServiceImpl;
import Services.impl.HoaDonServiceImpl;
import Services.impl.KhachHangServiceImpl;
import Services.impl.SanPhamServiceImpl;
import Services.impl.SizeServiceImpl;
import Utilities.Auth;
import Utilities.Msgbox;
import Utilities.XMoney;
import View.Swing.EventItem;
import View.Swing.ScrollBarCustom;
import ViewModels.SanPhamResponse;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class BanHang extends javax.swing.JInternalFrame {
    private FormSPCT formSPCT;
    KhachHang kh = null;
    String maSP = null;
    int row1 = -1;
    int row2 = -1;
    int row3 = -1;
    
    List<SanPhamResponse> listSanPhamRes;
    List<Size> listSize;
    List<DanhMucSP> listDMSP;
    List<HinhThucThanhToan> listHTTT;
    List<HoaDon> listHoaDon;
    List<HoaDonChiTiet> listHDCT;
    
    SanPhamService SPService = new SanPhamServiceImpl();
    SizeService sizeService = new SizeServiceImpl();
    DanhMucSPService DMSPService = new DanhMucSPServiceImpl();
    HinhThucTTService HTTTService = new HinhThucTTServiceImpl();
    KhachHangService khService = new KhachHangServiceImpl();
    HoaDonService hdService = new HoaDonServiceImpl();
    HoaDonCTService hdctSerice = new HoaDonCTServiceImpl();
    
    DecimalFormat df = new DecimalFormat("#.##");
    DefaultTableModel dtmHoaDonCho;
    DefaultTableModel dtmGioHang;
    
    
    public BanHang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        scrollGhiChu.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollGhiChu.setHorizontalScrollBar(sp);
        // ----------------------------------------------------------------------
        dtmHoaDonCho = (DefaultTableModel) tblHoaDonCho.getModel();
        dtmGioHang = (DefaultTableModel) tblGioHang.getModel();
        formSPCT = new FormSPCT();
        listSanPhamRes = SPService.getALL();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formSPCT);
        showDetailsSPCT(listSanPhamRes);
        fillCbbSize();
        fillCbbDanhMucSP();
        fillCbbHinhThucTT();
        showHoaDonCho();
    }
    
    public void themSanPham(SanPhamResponse item) {
        if (txtTienKhachDua.getText().trim().equals("")) {
            txtTienKhachDua.setText("0");
        }
        row3 = tblHoaDonCho.getSelectedRow();
        try {
            if (row3 < 0) {
                Msgbox.alert(this, "Vui lòng chọn hóa đơn chờ\nNếu chưa có vui lòng tạo!");
            } else {
                String soLuong = Msgbox.prompt(this, "Mời bạn nhập số lượng sản phẩm:");
                
                if (soLuong != null) {
                    if (Integer.parseInt(soLuong) < 0) {
                        Msgbox.alert(this, "Số lượng sản phẩm không được nhỏ hơn 0!");
                        return;
                    } else {
                        for(int i = 0; i < tblGioHang.getRowCount(); i++) {
                            if (tblGioHang.getValueAt(i, 0).toString().equals(maSP)) {
                                int soLuongGoc = Integer.parseInt(tblGioHang.getValueAt(i, 3).toString());
                                tblGioHang.setValueAt(soLuongGoc + Integer.parseInt(soLuong), i, 3);
                                tblGioHang.setValueAt(Integer.parseInt(tblGioHang.getValueAt(i, 3).toString()) * item.getGia(), i, 4);
                                donHang();
                                capNhatHoaDon();
                                return;
                            }
                        }
                        
                        Vector v = new Vector();
                        v.add(item.getMaSP());
                        v.add(item.getTenSP());
                        v.add(item.getGia());
                        v.add(soLuong);
                        v.add(item.getGia() * Integer.parseInt(soLuong));
                        dtmGioHang.addRow(v);
                        donHang();
                        capNhatHoaDon();
                    }
                }
            }
        } catch (NumberFormatException e) {
            Msgbox.alert(this, "Số lượng sản phẩm phải là số nguyên");
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void thanhToan() {
        HinhThucThanhToan httt = (HinhThucThanhToan) cbbHTTT.getSelectedItem();
        HoaDon hd = new HoaDon();
        hd.setMaHD(lbMaHD.getText());
        NhanVien nv = new NhanVien();
        KhachHang kh1 = getFormKH();
        nv.setID(Auth.user.getID());
        hd.setNv(nv);
        if (kh1 != null) {
            hd.setKh(kh1);
        }
        hd.setHttt(httt);
        double tongTien = Double.parseDouble(lbTongTien.getText());
        double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
        hd.setTienThua(tienKhachDua - tongTien);
        hd.setTongTien(Double.parseDouble(lbTongTien.getText()));
        hd.setGhiChu(txtghiChu1.getText());
        hd.setTrangThai("Ðã thanh toán");
        try {
            if (lbMaHD.getText().equals("Vui lòng tạo!")) {
                Msgbox.alert(this, "Vui lòng chọn hóa đơn trước khi nhấn thanh toán");
                return;
            } else if (tblGioHang.getRowCount() == 0) {
                Msgbox.alert(this, "Vui lòng chọn sản phẩm trước khi nhấn thanh toán");
                return;
            } else {
                if (Msgbox.confirm(this, "Bạn chắc chắn muốn thanh toán hóa đơn này chứ?")) {
                    if (tienKhachDua < tongTien) {
                        Msgbox.alert(this, "Số tiền khách đưa không đủ để thanh toán");
                        txtTienKhachDua.setBackground(Color.red);
                        return;
                    } else {
                        txtTienKhachDua.setBackground(Color.white);
                        if (kh1 != null) {
                            hdService.update(hd);
                        } else {
                            hdService.updateNoKH(hd);
                        }
                        
                        if (Msgbox.confirm(this, "Bạn muốn in hóa đơn này không ??")) {
                            
                        }
                        Msgbox.alert(this, "Thanh toán thành công!");
                        lamMoi();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msgbox.alert(this, "Thanh toán thất bại");
        }
    }
    
    public void fillCbbHinhThucTT() {
        DefaultComboBoxModel<HinhThucThanhToan> model = (DefaultComboBoxModel) cbbHTTT.getModel();
        model.removeAllElements();
        listHTTT = HTTTService.getALL();
        for (HinhThucThanhToan httt : listHTTT) {
            model.addElement(httt);
        }
    }
    
    public void fillCbbDanhMucSP() {
        cbbDanhMucSP.removeAllItems();
        listDMSP = DMSPService.getALL();
        // update
        cbbDanhMucSP.addItem("ALL");
        for (int i = 0; i < listDMSP.size(); i++) {
            cbbDanhMucSP.addItem(listDMSP.get(i).getTenDM());
        }
    }
    
    public void fillCbbSize() {
        cbbSize.removeAllItems();
        listSize = sizeService.getALL();
        // update
        cbbSize.addItem("ALL");
        for (int i = 0; i < listSize.size(); i++) {
            cbbSize.addItem(listSize.get(i).getTenSize());
        }
    }
    
    public void showDetailsSPCT(List<SanPhamResponse> listSanPhamRes) {
        // update
        formSPCT.removeItem();
        //
         formSPCT.setEvent(new EventItem(){
            @Override
            public void itemClick(Component com, SanPhamResponse item) {
                maSP = item.getMaSP();
                formSPCT.setselected(com);
                themSanPham(item);
            }
        });
        for (SanPhamResponse x : listSanPhamRes) {
            formSPCT.addItem(x);
        }
    }
    
    public void clickHoaDonCho() {
        row3 = tblHoaDonCho.getSelectedRow();
        txtSDT.setEnabled(true);
        btnTKKhachHang.setEnabled(true);
        btnPanelKH.setEnabled(true);
        btnThanhToan.setEnabled(true);
        chkDoiDiem.setEnabled(true);
        lbMaHD.setText(tblHoaDonCho.getValueAt(row3, 0).toString());
        try {
            HoaDon hd = hdService.selectByMaHD(lbMaHD.getText());
            if (hd.getKh() == null) {
                txtSDT.setText("");
                lbHoTen.setText("");
            } else {
                txtSDT.setText(hd.getKh().getSDT());
                lbHoTen.setText(hd.getKh().getHoTen());
            }
            lbTongTien.setText(df.format(hd.getTongTien()));
            txtTienKhachDua.setText("0");
            double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
            lbTienThua.setText(df.format(tienKhachDua - hd.getTongTien()));
            cbbHTTT.setSelectedItem(hd.getHttt().getTen());
            dtmGioHang.setRowCount(0);
            HoaDon hd2 = hdService.selectByMaHD(lbMaHD.getText());
            List<HoaDonChiTiet> list = hdctSerice.selectByID(hd2.getID());
            for (HoaDonChiTiet x : list) {
                dtmGioHang.addRow(new Object[]{
                    x.getSp().getMaSP(), x.getSp().getTenSP(), x.getDonGia(), x.getSoLuong(), x.getThanhToan()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void showHoaDonCho() {
        dtmHoaDonCho.setRowCount(0);
        listHoaDon = hdService.selectByHDChoTT();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for (HoaDon x : listHoaDon) {
            dtmHoaDonCho.addRow(new Object[] {
                x.getMaHD(), x.getNv().getHoTen(), x.getKh().getHoTen(), sdf.format(x.getNgayTao()), x.getTrangThai(), x.getGhiChu()
            });
        }
    }
    
    public void capNhatHoaDon() {
        HoaDon hd = getFormHD();
        HoaDon hd2 = hdService.selectByMaHD(lbMaHD.getText());
        if (kh == null) {
            hdService.updateNoKH(hd);
        } else {
            hdService.update(hd);
        }
        hdctSerice.delete(hd2.getID());
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            SanPham sp = SPService.getOne(tblGioHang.getValueAt(i, 0).toString());
            hdct.setHd(hd2);
            hdct.setSp(sp);
            hdct.setSoLuong(Integer.parseInt(tblGioHang.getValueAt(i, 3).toString()));
            hdct.setDonGia(Double.parseDouble(tblGioHang.getValueAt(i, 2).toString()));
            hdct.setThanhToan(Double.parseDouble(tblGioHang.getValueAt(i, 4).toString()));
            hdctSerice.insert(hdct);
        }
    }
    
    public void donHang() {
        double tongTien = 0;
        int soDong = tblGioHang.getRowCount();
        if (soDong == 0) {
            lbTongTien.setText("0");
            txtTienKhachDua.setText("0");
            lbTienThua.setText("0");
        } else {
            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                double donGia = Double.parseDouble(tblGioHang.getValueAt(i, 2).toString());
                int soLuong = Integer.parseInt(tblGioHang.getValueAt(i, 3).toString());
                tongTien += soLuong * donGia;
                lbTongTien.setText(df.format(tongTien));
                double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
                lbTienThua.setText(df.format(tienKhachDua - tongTien));
            }
        }
    }
    
    
    public void lamMoi() {
        dtmGioHang.setRowCount(0);
        lbMaHD.setText("Vui lòng tạo!");
        txtSDT.setText("");
        lbHoTen.setText("");
        lbDiemTL.setText("0");
        kh = null;  
        lbTongTien.setText("0");
        txtTienKhachDua.setText("0");
        lbTienThua.setText("0");
        cbbHTTT.setSelectedIndex(0);
        txtghiChu1.setText("");
        row2 = -1;
        kh = null;
        showHoaDonCho();
        btnTao.setEnabled(true);
        btnTKKhachHang.setEnabled(false);
        btnPanelKH.setEnabled(false);
        txtSDT.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }
    
    HoaDon getFormHD() {
        HinhThucThanhToan httt = (HinhThucThanhToan) cbbHTTT.getSelectedItem();
        HoaDon hd = new HoaDon();
        NhanVien nv = new NhanVien();
        KhachHang kh = getFormKH();
        nv.setID(Auth.user.getID());
        hd.setMaHD(lbMaHD.getText());
        hd.setNv(nv);
        if (kh != null) {
            hd.setKh(kh);
        }
        java.util.Date date=new java.util.Date();  
        hd.setNgayTao(date);
        hd.setTienThua(0);
        hd.setTongTien(Double.parseDouble(lbTongTien.getText()));
        hd.setThanhToan(0);
        hd.setHttt(httt);
        hd.setTrangThai("Chờ thanh toán");
        hd.setGhiChu(txtghiChu1.getText());
        return hd;
    }
    
    
    KhachHang getFormKH() {
        String sdt = txtSDT.getText().trim();
        KhachHang kh = new KhachHang();
        kh = khService.getOne(sdt);
        return kh;
    }
    
    public void xoaTatCa() {
        try {
            if (tblGioHang.getRowCount() == 0) {
                Msgbox.alert(this, "Không có sản phẩm để xóa");
            } else {
                if (Msgbox.confirm(this, "Bạn chắc chắn muốn xóa hết tất cả sản phẩm này khỏi giỏ hàng?")) {
                    dtmGioHang.setRowCount(0);
                    donHang();
                    capNhatHoaDon();
                    Msgbox.alert(this, "Xóa tất cả sản phẩm thành công");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msgbox.alert(this, "Xóa tất cả sản phẩm thất bại");
        }
    }
    
    public void xoaSanPham() {
        row2 = tblGioHang.getSelectedRow();
        try {
            if (tblGioHang.getRowCount() == 0) {
                Msgbox.alert(this, "Không có sản phẩm để xóa");
            } else {
                if (row2 < 0) {
                    Msgbox.alert(this, "Vui lòng chọn sản phẩm để xóa!");
                    return;
                } else {
                    dtmGioHang.removeRow(row2);
                    donHang();
                    capNhatHoaDon();
                     Msgbox.alert(this, "Xóa sản phẩm thành công");
                }
            }
        } catch (Exception e) {
            Msgbox.alert(this, "Xóa sản phẩm thất bại");
            e.printStackTrace();
        }
    }
    
    public void luuHoaDon() {
        try {
            if (Msgbox.confirm(this, "Bạn muốn tạo hóa đơn mới ?")) {
                lamMoi();
                String mess = hdService.insert(getFormHD());
                showHoaDonCho();
                Msgbox.alert(this, mess);
                
            }
        } catch (Exception e) {
            Msgbox.alert(this, "Tạo hóa đơn thất bại");
            e.printStackTrace();
        }
    }
    // update
    public void showSize() {
        if(cbbSize.getSelectedIndex() > 0) {
            listSanPhamRes = SPService.getSPByTenSize(cbbSize.getSelectedItem().toString());
            showDetailsSPCT(listSanPhamRes);
        } else {
            listSanPhamRes = SPService.getALL();
            showDetailsSPCT(listSanPhamRes);
        }
        txtTimKiem.setText("");
    }
    
    public void showDanhMuc() {
        if(cbbDanhMucSP.getSelectedIndex() > 0) {
            listSanPhamRes = SPService.getSPByTenDM(cbbDanhMucSP.getSelectedItem().toString());
            showDetailsSPCT(listSanPhamRes);
        } else {
            listSanPhamRes = SPService.getALL();
            showDetailsSPCT(listSanPhamRes);
        }
        txtTimKiem.setText("");
    }
    
    public void timKiem() {
        if (txtTimKiem.getText().trim().equals("")) {
            cbbDanhMucSP.setSelectedIndex(0);
        } else {
            formSPCT.removeItem();
            listSanPhamRes = SPService.selectByTimKiem(txtTimKiem.getText().trim());
            showDetailsSPCT(listSanPhamRes);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        cbbSize = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbDanhMucSP = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbMaHD = new javax.swing.JLabel();
        btnTao = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbTienThua = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbbHTTT = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        scrollGhiChu = new javax.swing.JScrollPane();
        txtghiChu1 = new javax.swing.JTextArea();
        btnHuyHoaDon1 = new javax.swing.JButton();
        btnLamMoi1 = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnTKKhachHang = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        btnPanelKH = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbDiemTL = new javax.swing.JLabel();
        chkDoiDiem = new javax.swing.JCheckBox();
        lbHoTen = new javax.swing.JLabel();
        btnXoaSP = new javax.swing.JButton();
        btnXoaTatCa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1421, 796));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm sản phẩm");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Hóa đơn chờ");

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Người tạo", "Khách hàng", "TG tạo", "Trạng thái", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonCho);

        cbbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSizeItemStateChanged(evt);
            }
        });

        jLabel4.setText("Size");

        jLabel6.setText("Loại sản phẩm");

        cbbDanhMucSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDanhMucSPItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDanhMucSP, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDanhMucSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Giỏ hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setResizable(false);
            tblGioHang.getColumnModel().getColumn(1).setResizable(false);
            tblGioHang.getColumnModel().getColumn(2).setResizable(false);
            tblGioHang.getColumnModel().getColumn(3).setResizable(false);
            tblGioHang.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Mã hóa đơn:");

        lbMaHD.setForeground(new java.awt.Color(255, 0, 0));
        lbMaHD.setText("Vui lòng tạo!");

        btnTao.setBackground(new java.awt.Color(255, 204, 0));
        btnTao.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnTao.setText("Tạo");
        btnTao.setPreferredSize(new java.awt.Dimension(101, 25));
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Tổng tiền:");

        lbTongTien.setText("0");

        jLabel28.setText("VNÐ");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Tiền khách đưa:");

        txtTienKhachDua.setText("0");
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        jLabel36.setText("VNÐ");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Tiền thừa:");

        lbTienThua.setText("0");

        jLabel39.setText("VNÐ");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Hình thức thanh toán:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Ghi chú:");

        txtghiChu1.setColumns(20);
        txtghiChu1.setRows(5);
        scrollGhiChu.setViewportView(txtghiChu1);

        btnHuyHoaDon1.setBackground(new java.awt.Color(255, 204, 0));
        btnHuyHoaDon1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnHuyHoaDon1.setText("Hủy hóa đơn");
        btnHuyHoaDon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDon1ActionPerformed(evt);
            }
        });

        btnLamMoi1.setBackground(new java.awt.Color(255, 204, 0));
        btnLamMoi1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnLamMoi1.setText("Làm mới");
        btnLamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoi1ActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(255, 204, 0));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(51, 51, 51));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setBorder(null);
        btnThanhToan.setEnabled(false);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("SÐT:");

        txtSDT.setEnabled(false);

        btnTKKhachHang.setBackground(new java.awt.Color(255, 204, 0));
        btnTKKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search_client_24px.png"))); // NOI18N
        btnTKKhachHang.setEnabled(false);
        btnTKKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKKhachHangActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Họ tên");

        btnPanelKH.setBackground(new java.awt.Color(255, 204, 0));
        btnPanelKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPanelKH.setText("+");
        btnPanelKH.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Điểm tích lũy:");

        lbDiemTL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiemTL.setText("0");

        chkDoiDiem.setText("Đổi điểm");
        chkDoiDiem.setEnabled(false);

        lbHoTen.setText("  ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDiemTL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkDoiDiem))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel39)))
                                    .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(btnHuyHoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(scrollGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnPanelKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnTKKhachHang))))
                .addGap(82, 82, 82))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTKKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPanelKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiemTL)
                    .addComponent(chkDoiDiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongTien)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTienThua)
                    .addComponent(jLabel39)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuyHoaDon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        btnXoaSP.setBackground(new java.awt.Color(255, 204, 0));
        btnXoaSP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoaSP.setForeground(new java.awt.Color(51, 51, 51));
        btnXoaSP.setText("Xóa sản phẩm");
        btnXoaSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        btnXoaSP.setPreferredSize(new java.awt.Dimension(60, 30));
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnXoaTatCa.setBackground(new java.awt.Color(255, 204, 0));
        btnXoaTatCa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoaTatCa.setForeground(new java.awt.Color(51, 51, 51));
        btnXoaTatCa.setText("Xóa tất cả");
        btnXoaTatCa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        btnXoaTatCa.setPreferredSize(new java.awt.Dimension(60, 30));
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnXoaTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked
        clickHoaDonCho();
    }//GEN-LAST:event_tblHoaDonChoMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int column = tblGioHang.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblGioHang.getRowHeight();

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnTKKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKKhachHangActionPerformed
        KhachHang kh1 = getFormKH();
        if (kh1 == null) {
            Msgbox.alert(this, "Không tìm thấy khách hàng");
            lbHoTen.setText("");
            kh = null;
        } else {
            lbHoTen.setText(kh1.getHoTen());
            kh = kh1;
            HoaDon hd = getFormHD();
            String mess = hdService.update(hd);
            Msgbox.alert(this, mess);
            showHoaDonCho();
        }
    }//GEN-LAST:event_btnTKKhachHangActionPerformed

    
    
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        thanhToan();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnLamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoi1ActionPerformed

    private void btnHuyHoaDon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDon1ActionPerformed

    }//GEN-LAST:event_btnHuyHoaDon1ActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        luuHoaDon();
    }//GEN-LAST:event_btnTaoActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        xoaSanPham();
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaActionPerformed
        xoaTatCa();      
    }//GEN-LAST:event_btnXoaTatCaActionPerformed

    private void cbbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSizeItemStateChanged
        // update
        showSize();
    }//GEN-LAST:event_cbbSizeItemStateChanged

    private void cbbDanhMucSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDanhMucSPItemStateChanged
        // update
        showDanhMuc();
    }//GEN-LAST:event_cbbDanhMucSPItemStateChanged

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        timKiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHoaDon1;
    private javax.swing.JButton btnLamMoi1;
    private javax.swing.JButton btnPanelKH;
    private javax.swing.JButton btnTKKhachHang;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.JComboBox<String> cbbDanhMucSP;
    private javax.swing.JComboBox<String> cbbHTTT;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JCheckBox chkDoiDiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDiemTL;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbTienThua;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollGhiChu;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextArea txtghiChu1;
    // End of variables declaration//GEN-END:variables
}

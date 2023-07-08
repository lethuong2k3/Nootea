package DomainModels;

import java.util.Date;

public class HoaDon {
    private String ID;
    private String MaHD;
    NhanVien nv;
    KhachHang kh;
    private Date NgayTao;
    private double tienThua;
    private double tongTien;
    private double thanhToan;
    HinhThucThanhToan httt;
    private String trangThai;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(String ID, String MaHD, NhanVien nv, KhachHang kh, Date NgayTao, double tienThua, double tongTien, double thanhToan, HinhThucThanhToan httt, String trangThai, String ghiChu) {
        this.ID = ID;
        this.MaHD = MaHD;
        this.nv = nv;
        this.kh = kh;
        this.NgayTao = NgayTao;
        this.tienThua = tienThua;
        this.tongTien = tongTien;
        this.thanhToan = thanhToan;
        this.httt = httt;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(double thanhToan) {
        this.thanhToan = thanhToan;
    }

    public HinhThucThanhToan getHttt() {
        return httt;
    }

    public void setHttt(HinhThucThanhToan httt) {
        this.httt = httt;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   

    
    
}

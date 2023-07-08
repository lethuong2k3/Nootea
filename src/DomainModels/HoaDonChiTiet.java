package DomainModels;

public class HoaDonChiTiet {
    private String ID;
    HoaDon hd;
    SanPham sp;
    private double donGia;
    private int soLuong;
    private double thanhToan;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String ID, HoaDon hd, SanPham sp, double donGia, int soLuong, double thanhToan) {
        this.ID = ID;
        this.hd = hd;
        this.sp = sp;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhToan = thanhToan;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(double thanhToan) {
        this.thanhToan = thanhToan;
    }
    
}

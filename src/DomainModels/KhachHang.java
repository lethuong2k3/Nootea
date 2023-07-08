package DomainModels;

public class KhachHang {
    private String ID;
    private String MaKH;
    private String HoTen;
    private String GioiTinh;
    private String SDT;
    private String DiaChi;

    public KhachHang() {
    }

    public KhachHang(String ID, String MaKH, String HoTen, String GioiTinh, String SDT, String DiaChi) {
        this.ID = ID;
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
}

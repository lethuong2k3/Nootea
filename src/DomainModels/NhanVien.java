package DomainModels;

public class NhanVien {
    private String ID;
    private String TaiKhoan;
    private String MatKhau;
    private String HoTen;
    private String GioiTinh;
    private String NgaySinh;
    private String SDT;
    private String DiaChi;
    ChucVu cv;
    private String TrangThai;

    public NhanVien() {
    }

    public NhanVien(String ID, String TaiKhoan, String MatKhau, String HoTen, String GioiTinh, String NgaySinh, String SDT, String DiaChi, ChucVu cv, String TrangThai) {
        this.ID = ID;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.cv = cv;
        this.TrangThai = TrangThai;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
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

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public ChucVu getCv() {
        return cv;
    }

    public void setCv(ChucVu cv) {
        this.cv = cv;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}

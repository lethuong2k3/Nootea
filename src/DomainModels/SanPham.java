package DomainModels;

public class SanPham {
    private String ID;
    private String MaSP;
    private String TenSP;
    private double Gia;
    private String MoTa;
    private int TrangThai;
    private String hinhAnh;
    Size size;
    DanhMucSP danhMuc;

    public SanPham() {
    }

    public SanPham(String ID, String MaSP, String TenSP, double Gia, String MoTa, int TrangThai, String hinhAnh, Size size, DanhMucSP danhMuc) {
        this.ID = ID;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
        this.hinhAnh = hinhAnh;
        this.size = size;
        this.danhMuc = danhMuc;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public DanhMucSP getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMucSP danhMuc) {
        this.danhMuc = danhMuc;
    }
    
}

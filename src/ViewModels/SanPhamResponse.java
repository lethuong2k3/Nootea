package ViewModels;

public class SanPhamResponse {
    private String ID;
    private String MaSP;
    private String TenSP;
    private String DuongDanAnh;
    private String TenDM;
    private double GiaSize;
    private double Gia;
    private String TenSize;

    public SanPhamResponse() {
    }

    public SanPhamResponse(String ID, String MaSP, String TenSP, String DuongDanAnh, String TenDM, double GiaSize, double Gia, String TenSize) {
        this.ID = ID;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DuongDanAnh = DuongDanAnh;
        this.TenDM = TenDM;
        this.GiaSize = GiaSize;
        this.Gia = Gia;
        this.TenSize = TenSize;
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

    public String getDuongDanAnh() {
        return DuongDanAnh;
    }

    public void setDuongDanAnh(String DuongDanAnh) {
        this.DuongDanAnh = DuongDanAnh;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }

    public double getGiaSize() {
        return GiaSize;
    }

    public void setGiaSize(double GiaSize) {
        this.GiaSize = GiaSize;
    }

    public String getTenSize() {
        return TenSize;
    }

    public void setTenSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public double getGia() {
        return Gia + getGiaSize();
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

  
   
    
    public Object[] getData() {
        return new Object[]{ID, TenSP, DuongDanAnh, TenDM, Gia, TenSize};
    }
}

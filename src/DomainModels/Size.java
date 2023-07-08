package DomainModels;

public class Size {
    private String ID;
    private String MaSize;
    private String TenSize;
    private double Gia;
    private int TrangThai;

    public Size() {
    }

    public Size(String ID, String MaSize, String TenSize, double Gia, int TrangThai) {
        this.ID = ID;
        this.MaSize = MaSize;
        this.TenSize = TenSize;
        this.Gia = Gia;
        this.TrangThai = TrangThai;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaSize() {
        return MaSize;
    }

    public void setMaSize(String MaSize) {
        this.MaSize = MaSize;
    }

    public String getTenSize() {
        return TenSize;
    }

    public void setTenSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}

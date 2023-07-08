package DomainModels;

public class LoaiSanPham {
    private String ID;
    private String maLSP;
    private String ten;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String ID, String maLSP, String ten) {
        this.ID = ID;
        this.maLSP = maLSP;
        this.ten = ten;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(String maLSP) {
        this.maLSP = maLSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    
}

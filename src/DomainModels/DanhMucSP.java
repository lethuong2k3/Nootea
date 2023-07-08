package DomainModels;

public class DanhMucSP {
    private String ID;
    private String MaDM;
    private String TenDM;
    private int TrangThai;

    public DanhMucSP() {
    }
    
    public DanhMucSP(String ID, String MaDM, String TenDM, int TrangThai) {
        this.ID = ID;
        this.MaDM = MaDM;
        this.TenDM = TenDM;
        this.TrangThai = TrangThai;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaDM() {
        return MaDM;
    }

    public void setMaDM(String MaDM) {
        this.MaDM = MaDM;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}

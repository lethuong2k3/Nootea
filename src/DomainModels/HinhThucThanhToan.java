package DomainModels;

public class HinhThucThanhToan {
    private String ID;
    private String MaHTTT;
    private String Ten;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(String ID, String MaHTTT, String Ten) {
        this.ID = ID;
        this.MaHTTT = MaHTTT;
        this.Ten = Ten;
    }

    @Override
    public String toString() {
        return Ten;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaHTTT() {
        return MaHTTT;
    }

    public void setMaHTTT(String MaHTTT) {
        this.MaHTTT = MaHTTT;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
    
}

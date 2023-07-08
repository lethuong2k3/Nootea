package DomainModels;

public class ChucVu {
    private String ID;
    private String MaCV;
    private String Ten;

    public ChucVu() {
    }

    public ChucVu(String ID, String MaCV, String Ten) {
        this.ID = ID;
        this.MaCV = MaCV;
        this.Ten = Ten;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
    
}

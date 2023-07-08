package Services;

import DomainModels.NhanVien;
import java.util.List;

public interface NhanVienService {
    
    List<NhanVien> getALL();
    
    NhanVien getOne(String TaiKhoan);
    
}

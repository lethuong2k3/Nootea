package Responsitories;

import DomainModels.NhanVien;
import java.util.List;

public interface NhanVienRepository {
    
    List<NhanVien> getALL();
    
    NhanVien getOne(String TaiKhoan);
    
}

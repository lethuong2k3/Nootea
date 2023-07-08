package Responsitories;

import DomainModels.KhachHang;
import java.util.List;

public interface KhachHangRepository {
    
    List<KhachHang> getALL();
    
    KhachHang getOne(String sdt);
    
}

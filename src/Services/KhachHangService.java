package Services;

import DomainModels.KhachHang;
import java.util.List;

public interface KhachHangService {
    
    List<KhachHang> getALL();
    
    KhachHang getOne(String sdt);
    
}

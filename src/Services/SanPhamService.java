package Services;

import DomainModels.SanPham;
import ViewModels.SanPhamResponse;
import java.util.List;

public interface SanPhamService {
    List<SanPhamResponse> getALL();
    
    List<SanPhamResponse> getSPByTenSize(String TenSize);
    
    List<SanPhamResponse> getSPByTenDM(String TenDM);
    
    SanPham getOne(String ma);
    
    List<SanPhamResponse> selectByTimKiem(String key);
    
}

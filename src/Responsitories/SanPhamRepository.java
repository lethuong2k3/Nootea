package Responsitories;

import DomainModels.SanPham;
import ViewModels.SanPhamResponse;
import java.util.List;

public interface SanPhamRepository {
    
    List<SanPhamResponse> getALL();
    
    List<SanPhamResponse> getSPByTenSize(String TenSize);
    
    List<SanPhamResponse> getSPByTenDM(String TenDM);
    
    SanPham getOne(String ma);
    // update
    List<SanPhamResponse> selectByTimKiem(String key);
}

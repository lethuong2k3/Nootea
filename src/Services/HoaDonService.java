package Services;

import DomainModels.HoaDon;
import java.util.List;

public interface HoaDonService {
    
    String insert(HoaDon hd);
    
    String update(HoaDon hd);
    
    int updateNoKH(HoaDon hd);
    
    
    List<HoaDon> selectByHDChoTT();
    
    HoaDon selectByMaHD(String maHD);
    
    
}

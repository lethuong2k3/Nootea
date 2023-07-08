package Services;

import DomainModels.HoaDonChiTiet;
import java.util.List;

public interface HoaDonCTService {
    
    int insert(HoaDonChiTiet hdct);
    
    int delete (String IDHD);
    
    List<HoaDonChiTiet> selectByID(String idHoaDon);
    
}

package Responsitories;

import DomainModels.HoaDonChiTiet;
import java.util.List;

public interface HoaDonCTRepository {
    
    int insert (HoaDonChiTiet hdct);
    
    int delete (String IDHD);
    
     List<HoaDonChiTiet> selectByID(String idHoaDon);
     
}

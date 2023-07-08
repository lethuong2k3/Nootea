package Responsitories;

import DomainModels.HoaDon;
import java.util.List;

public interface HoaDonRepository {

    int insert(HoaDon hd);
    
    int update(HoaDon hd);
    
    int updateNoKH(HoaDon hd);
    
    List<HoaDon> selectByHDChoTT();
    
    HoaDon selectByMaHD(String maHD);
    
    
}

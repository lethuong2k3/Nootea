package Services.impl;

import DomainModels.HoaDon;
import Responsitories.HoaDonRepository;
import Responsitories.impl.HoaDonRepositoryImpl;
import Services.HoaDonService;
import java.util.List;

public class HoaDonServiceImpl implements HoaDonService{
    
    private HoaDonRepository hoaDonRep = new HoaDonRepositoryImpl();
    
    @Override
    public List<HoaDon> selectByHDChoTT() {
        return hoaDonRep.selectByHDChoTT();
    }
    
    @Override
    public HoaDon selectByMaHD(String maHD) {
        return hoaDonRep.selectByMaHD(maHD);
    }

    @Override
    public String insert(HoaDon hd) {
        int addHoaDon = hoaDonRep.insert(hd);
        if (addHoaDon > 0) {
            return "Tạo hóa đơn thành công!";
        }
        return "Tạo hóa đơn thất bại!";
    }
    
    @Override
    public String update(HoaDon hd) {
        int updateHoaDon = hoaDonRep.update(hd);
        if (updateHoaDon > 0) {
            return "Cập nhật hóa đơn thành công!";
        }
        return "Cập nhật hóa đơn thất bại!";
    }

    @Override
    public int updateNoKH(HoaDon hd) {
        return hoaDonRep.updateNoKH(hd);
    }
    
}

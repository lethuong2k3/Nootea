package Services.impl;

import DomainModels.KhachHang;
import Responsitories.KhachHangRepository;
import Responsitories.impl.KhachHangRepositoryImpl;
import Services.KhachHangService;
import java.util.List;

public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangRepository khachHangRep = new KhachHangRepositoryImpl();
    @Override
    public List<KhachHang> getALL() {
        return khachHangRep.getALL();
    }

    @Override
    public KhachHang getOne(String sdt) {
        return khachHangRep.getOne(sdt);
    }
    
}

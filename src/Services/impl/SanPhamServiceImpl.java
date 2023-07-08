package Services.impl;

import DomainModels.SanPham;
import Responsitories.SanPhamRepository;
import Responsitories.impl.SanPhamRepositoryImpl;
import Services.SanPhamService;
import ViewModels.SanPhamResponse;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService{
    private SanPhamRepository sanPhamRep = new SanPhamRepositoryImpl();
    @Override
    public List<SanPhamResponse> getALL() {
        return sanPhamRep.getALL();
    }

    @Override
    public List<SanPhamResponse> getSPByTenSize(String TenSize) {
        return sanPhamRep.getSPByTenSize(TenSize);
    }

    @Override
    public List<SanPhamResponse> getSPByTenDM(String TenDM) {
        return sanPhamRep.getSPByTenDM(TenDM);
    }

    @Override
    public SanPham getOne(String ma) {
        return sanPhamRep.getOne(ma);
    }

    @Override
    public List<SanPhamResponse> selectByTimKiem(String key) {
        return sanPhamRep.selectByTimKiem(key);
    }
    
}

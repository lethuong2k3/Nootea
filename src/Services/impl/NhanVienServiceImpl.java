package Services.impl;

import DomainModels.NhanVien;
import Responsitories.NhanVienRepository;
import Responsitories.impl.NhanVienRepositoryImpl;
import Services.NhanVienService;
import java.util.List;

public class NhanVienServiceImpl implements NhanVienService{
    private NhanVienRepository NhanVienRep = new NhanVienRepositoryImpl();
    @Override
    public List<NhanVien> getALL() {
        return NhanVienRep.getALL();
    }

    @Override
    public NhanVien getOne(String TaiKhoan) {
        return NhanVienRep.getOne(TaiKhoan);
    }
    
}

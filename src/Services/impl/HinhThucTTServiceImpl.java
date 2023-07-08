package Services.impl;

import DomainModels.HinhThucThanhToan;
import Responsitories.HinhThucTTRepository;
import Responsitories.impl.HinhThucTTRepositoryImpl;
import Services.HinhThucTTService;
import java.util.List;

public class HinhThucTTServiceImpl implements HinhThucTTService{
    private HinhThucTTRepository htttRep = new HinhThucTTRepositoryImpl();
    @Override
    public List<HinhThucThanhToan> getALL() {
        return htttRep.getALL();
    }
    
}

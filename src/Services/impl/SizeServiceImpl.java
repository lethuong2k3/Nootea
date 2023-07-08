package Services.impl;

import DomainModels.Size;
import Responsitories.SizeRepository;
import Responsitories.impl.SizeRepositoryImpl;
import Services.SizeService;
import java.util.List;

public class SizeServiceImpl implements SizeService{
    private SizeRepository SizeRep = new SizeRepositoryImpl();
    @Override
    public List<Size> getALL() {
        return SizeRep.getALL();
    }
    
}

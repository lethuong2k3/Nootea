package Services.impl;

import DomainModels.DanhMucSP;
import Responsitories.DanhMucSPRepository;
import Responsitories.impl.DanhMucSPRepositoryImpl;
import Services.DanhMucSPService;
import java.util.List;

public class DanhMucSPServiceImpl implements DanhMucSPService{
    private DanhMucSPRepository DanhMucSPRep = new DanhMucSPRepositoryImpl();

    @Override
    public List<DanhMucSP> getALL() {
        return DanhMucSPRep.getALL();
    }

    @Override
    public DanhMucSP getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
    
}

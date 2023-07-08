package Responsitories;

import DomainModels.DanhMucSP;
import java.util.List;

public interface DanhMucSPRepository {
    
    List<DanhMucSP> getALL();
    
    DanhMucSP getOne();
    
}

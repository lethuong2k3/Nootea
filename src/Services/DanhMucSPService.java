package Services;

import DomainModels.DanhMucSP;
import java.util.List;

public interface DanhMucSPService {
    
    List<DanhMucSP> getALL();
    
    DanhMucSP getOne();
    
}

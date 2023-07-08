package Utilities;

import DomainModels.NhanVien;

public class Auth {
    
    public static NhanVien user = null;
    
     public static void clear() {
        Auth.user = null;
    }
     
     public static boolean isLogin() {
        return Auth.user != null;
    }
     
}

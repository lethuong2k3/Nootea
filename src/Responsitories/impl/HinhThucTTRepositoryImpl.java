package Responsitories.impl;

import DomainModels.HinhThucThanhToan;
import Responsitories.HinhThucTTRepository;
import Utilities.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HinhThucTTRepositoryImpl implements HinhThucTTRepository{

    @Override
    public List<HinhThucThanhToan> getALL() {
        List<HinhThucThanhToan> listHTTT = new ArrayList<>();
        String query = "SELECT [Id], [MAHTTT], [Ten] FROM [dbo].[HinhThucThanhToan]";
        ResultSet rs = JDBC_Helper.selectTongQuat(query);
        try {
            while (rs.next()) {
                HinhThucThanhToan httt = new HinhThucThanhToan();
                httt.setID(rs.getString("Id"));
                httt.setMaHTTT(rs.getString("MAHTTT"));
                httt.setTen(rs.getString("Ten"));
                listHTTT.add(httt);
            }
            return listHTTT;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}

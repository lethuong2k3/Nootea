package Responsitories.impl;

import DomainModels.Size;
import Responsitories.SizeRepository;
import Utilities.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SizeRepositoryImpl implements SizeRepository{

    @Override
    public List<Size> getALL() {
        List<Size> listSize = new ArrayList<>();
        String query = "SELECT [ID], [MaSize], [TenSize], [Gia], [TrangThai] FROM [dbo].[Size]";
        ResultSet rs = JDBC_Helper.selectTongQuat(query);
        try {
            while (rs.next()) {
                Size s = new Size();
                s.setID(rs.getString("ID"));
                s.setMaSize(rs.getString("MaSize"));
                s.setTenSize(rs.getString("TenSize"));
                s.setGia(rs.getDouble("Gia"));
                s.setTrangThai(rs.getInt("TrangThai"));
                listSize.add(s);
            }
            return listSize;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}

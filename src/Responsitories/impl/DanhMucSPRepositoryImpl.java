package Responsitories.impl;

import DomainModels.DanhMucSP;
import Responsitories.DanhMucSPRepository;
import Utilities.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class DanhMucSPRepositoryImpl implements DanhMucSPRepository{

    @Override
    public List<DanhMucSP> getALL() {
        List<DanhMucSP> listDanhMucSP = new ArrayList<>();
        String query = "SELECT [ID], [MaDM], [TenDM], [TrangThai] FROM [dbo].[DanhMucSP]";
        ResultSet rs = JDBC_Helper.selectTongQuat(query);
        try {
            while (rs.next()) {
                DanhMucSP dmSP = new DanhMucSP();
                dmSP.setID(rs.getString("ID"));
                dmSP.setMaDM(rs.getString("MaDM"));
                dmSP.setTenDM(rs.getString("TenDM"));
                dmSP.setTrangThai(rs.getInt("TrangThai"));
                listDanhMucSP.add(dmSP);
            }
            return listDanhMucSP;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public DanhMucSP getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}

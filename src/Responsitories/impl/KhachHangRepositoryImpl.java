package Responsitories.impl;

import DomainModels.KhachHang;
import Responsitories.KhachHangRepository;
import Utilities.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangRepositoryImpl implements KhachHangRepository{

    @Override
    public List<KhachHang> getALL() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String query = "SELECT [ID], [MaKH], [hoTen], [gioiTinh], [SDT],[diaChi] FROM [dbo].[KhachHang]";
        ResultSet rs = JDBC_Helper.selectTongQuat(query);
        try {
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getString("ID"));
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoTen(rs.getString("hoTen"));
                kh.setGioiTinh(rs.getString("gioiTinh"));
                kh.setSDT(rs.getString("SDT"));
                kh.setDiaChi(rs.getString("diaChi"));
                listKhachHang.add(kh);
            }
            return listKhachHang;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public KhachHang getOne(String sdt) {
        String query = "SELECT [ID], [MaKH], [hoTen], [gioiTinh], [SDT],[diaChi] FROM [dbo].[KhachHang] WHERE SDT = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(query, sdt);
        try {
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getString("ID"));
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoTen(rs.getString("hoTen"));
                kh.setGioiTinh(rs.getString("gioiTinh"));
                kh.setSDT(rs.getString("SDT"));
                kh.setDiaChi(rs.getString("diaChi"));
                return kh;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}

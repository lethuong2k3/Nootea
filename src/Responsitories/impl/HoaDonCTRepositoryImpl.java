package Responsitories.impl;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.SanPham;
import Responsitories.HoaDonCTRepository;
import Utilities.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonCTRepositoryImpl implements HoaDonCTRepository{
    @Override
    public List<HoaDonChiTiet> selectByID(String idHoaDon) {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        String query = "SELECT IDHD, IDSP, MaSP, TenSP, DonGia, SoLuong, ThanhToan FROM HoaDonChiTiet LEFT JOIN SanPham ON HoaDonChiTiet.IDSP = SanPham.ID WHERE IDHD = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(query, idHoaDon);
        try {
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                HoaDon hd = new HoaDon();
                SanPham sp = new SanPham();
                hd.setID(rs.getString("IDHD")); sp.setID(rs.getString("IDSP")); sp.setTenSP(rs.getString("TenSP")); sp.setMaSP(rs.getString("MaSP"));
                hdct.setHd(hd); hdct.setSp(sp); hdct.setDonGia(rs.getDouble("DonGia")); 
                hdct.setSoLuong(rs.getInt("SoLuong")); hdct.setThanhToan(rs.getDouble("ThanhToan"));
                listHDCT.add(hdct);
            }
            return listHDCT;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int insert(HoaDonChiTiet hdct) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet] ([IDHD], [IDSP], [DonGia], [SoLuong], [ThanhToan]) VALUES (?, ?, ?, ?, ?)";
        return JDBC_Helper.updateTongQuat(query, hdct.getHd().getID(), hdct.getSp().getID(), hdct.getDonGia(), hdct.getSoLuong(), hdct.getThanhToan());
    }

    @Override
    public int delete(String IDHD) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet] WHERE IDHD = ?";
        return JDBC_Helper.updateTongQuat(query, IDHD);
    }
    
}

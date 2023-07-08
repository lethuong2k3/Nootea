package Responsitories.impl;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import Responsitories.NhanVienRepository;
import Utilities.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienRepositoryImpl implements NhanVienRepository{

    @Override
    public List<NhanVien> getALL() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        String query = "SELECT [ID], [TaiKhoan], [MatKhau], [HoTen], [GioiTinh], [NgaySinh], \n" +
                       "[SDT], [DiaChi], [IDCV], [TrangThai] FROM [dbo].[NhanVien]";
        ResultSet rs = JDBC_Helper.selectTongQuat(query);
        try {
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                NhanVien nv = new NhanVien();
                nv.setID(rs.getString("ID"));
                nv.setTaiKhoan(rs.getString("TaiKhoan"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgaySinh(rs.getString("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DiaChi"));
                cv.setID(rs.getString("IDCV"));
                nv.setCv(cv);
                nv.setTrangThai(rs.getString("TrangThai"));
                listNhanVien.add(nv);
            }
            return listNhanVien;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public NhanVien getOne(String TaiKhoan) {
        String query = "SELECT [ID], [TaiKhoan], [MatKhau], [HoTen], [GioiTinh], [NgaySinh], \n" +
                       "[SDT], [DiaChi], [IDCV], [TrangThai] FROM [dbo].[NhanVien] WHERE TaiKhoan = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(query, TaiKhoan);
        try {
            while (rs.next()) { 
                ChucVu cv = new ChucVu();
                NhanVien nv = new NhanVien();
                nv.setID(rs.getString("ID"));
                nv.setTaiKhoan(rs.getString("TaiKhoan"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgaySinh(rs.getString("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DiaChi"));
                cv.setID(rs.getString("IDCV"));
                nv.setCv(cv);
                nv.setTrangThai(rs.getString("TrangThai"));
                return nv;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}

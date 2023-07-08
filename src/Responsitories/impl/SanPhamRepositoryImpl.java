package Responsitories.impl;

import DomainModels.DanhMucSP;
import DomainModels.SanPham;
import DomainModels.Size;
import Responsitories.SanPhamRepository;
import Utilities.JDBC_Helper;
import ViewModels.SanPhamResponse;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamRepositoryImpl implements SanPhamRepository{

    @Override
    public List<SanPhamResponse> getALL() {
        List<SanPhamResponse> listSanPham = new ArrayList<>();
        String query = "Select SanPham.ID, MaSP, TenSP, HinhAnh, TenDM, SanPham.Gia, TenSize, Size.Gia 'GiaSize' from SanPham \n" +
                       "join DanhMucSP on SanPham.IDDanhMuc = DanhMucSP.ID\n" +
                       "join Size on SanPham.IDSize = Size.ID WHERE SanPham.TrangThai = 1";
        ResultSet rs = JDBC_Helper.selectTongQuat(query);
        try {
            while (rs.next()) {
                SanPhamResponse sanPham = new SanPhamResponse();
                sanPham.setID(rs.getString("ID")); sanPham.setMaSP(rs.getString("MaSP"));sanPham.setTenSP(rs.getString("TenSP")); sanPham.setDuongDanAnh(rs.getString("HinhAnh"));
                sanPham.setTenDM(rs.getString("TenDM")); sanPham.setGia(rs.getDouble("Gia")); sanPham.setTenSize(rs.getString("TenSize"));
                sanPham.setGiaSize(rs.getDouble("GiaSize"));
                listSanPham.add(sanPham);
            }
            return listSanPham;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<SanPhamResponse> getSPByTenSize(String TenSize) {
        List<SanPhamResponse> listSanPham = new ArrayList<>();
         String query = "Select SanPham.ID, MaSP, TenSP, HinhAnh, TenDM, SanPham.Gia, TenSize, Size.Gia 'GiaSize' from SanPham\n" +
                        "join DanhMucSP on SanPham.IDDanhMuc = DanhMucSP.ID\n" +
                        "join Size on SanPham.IDSize = Size.ID WHERE TenSize = ? AND SanPham.TrangThai = 1";                 
        ResultSet rs = JDBC_Helper.selectTongQuat(query, TenSize);
        try {
            while (rs.next()) {
                SanPhamResponse sanPham = new SanPhamResponse();
                sanPham.setID(rs.getString("ID")); sanPham.setMaSP(rs.getString("MaSP")); sanPham.setTenSP(rs.getString("TenSP")); sanPham.setDuongDanAnh(rs.getString("HinhAnh"));
                sanPham.setTenDM(rs.getString("TenDM")); sanPham.setGia(rs.getDouble("Gia")); sanPham.setTenSize(rs.getString("TenSize"));
                sanPham.setGiaSize(rs.getDouble("GiaSize"));
                listSanPham.add(sanPham);
            }
            return listSanPham;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<SanPhamResponse> getSPByTenDM(String TenDM) {
        List<SanPhamResponse> listSanPham = new ArrayList<>();
         String query = "Select SanPham.ID, MaSP, TenSP, HinhAnh, TenDM, SanPham.Gia, TenSize, Size.Gia 'GiaSize' from SanPham\n" +
                        "join DanhMucSP on SanPham.IDDanhMuc = DanhMucSP.ID\n" +
                        "join Size on SanPham.IDSize = Size.ID\n" +
                        "WHERE TenDM = ? AND SanPham.TrangThai = 1";
        ResultSet rs = JDBC_Helper.selectTongQuat(query, TenDM);
        try {
            while (rs.next()) {
                SanPhamResponse sanPham = new SanPhamResponse();
                sanPham.setID(rs.getString("ID")); sanPham.setMaSP(rs.getString("MaSP")); sanPham.setTenSP(rs.getString("TenSP")); sanPham.setDuongDanAnh(rs.getString("HinhAnh"));
                sanPham.setTenDM(rs.getString("TenDM")); sanPham.setGia(rs.getDouble("Gia")); sanPham.setTenSize(rs.getString("TenSize"));
                sanPham.setGiaSize(rs.getDouble("GiaSize"));
                listSanPham.add(sanPham);
            }
            return listSanPham;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public SanPham getOne(String ma) {
        String query = "SELECT * FROM SanPham Where MaSP = ? AND TrangThai = 1";
        ResultSet rs = JDBC_Helper.selectTongQuat(query, ma);
        try {
            while (rs.next()) {
                SanPham sp = new SanPham();
                DanhMucSP dm = new DanhMucSP();
                Size sz = new Size();
                sp.setID(rs.getString("ID")); sp.setMaSP(rs.getString("MaSP")); sp.setMaSP("MaSP"); sp.setTenSP(rs.getString("TenSp"));
                sp.setGia(rs.getDouble("Gia")); sp.setMoTa(rs.getString("MoTa")); sp.setTrangThai(rs.getInt("TrangThai"));
                dm.setID(rs.getString("IDDanhMuc")); sz.setID(rs.getString("IDSize"));
                sp.setSize(sz); sp.setDanhMuc(dm);
                return sp;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    // update
    @Override
    public List<SanPhamResponse> selectByTimKiem(String key) {
         List<SanPhamResponse> listSanPham = new ArrayList<>();
         String query = "Select SanPham.ID, MaSP, TenSP, HinhAnh, TenDM, SanPham.Gia, TenSize, Size.Gia 'GiaSize' from SanPham \n" +
                       "join DanhMucSP on SanPham.IDDanhMuc = DanhMucSP.ID\n" +
                       "join Size on SanPham.IDSize = Size.ID WHERE (MaSP Like ? OR TenSP Like ?) AND SanPham.TrangThai = 1";
        ResultSet rs = JDBC_Helper.selectTongQuat(query, "%" + key + "%", "%" + key + "%");
        try {
            while (rs.next()) {
                SanPhamResponse sanPham = new SanPhamResponse();
                sanPham.setID(rs.getString("ID")); sanPham.setMaSP(rs.getString("MaSP")); sanPham.setTenSP(rs.getString("TenSP")); sanPham.setDuongDanAnh(rs.getString("HinhAnh"));
                sanPham.setTenDM(rs.getString("TenDM")); sanPham.setGia(rs.getDouble("Gia")); sanPham.setTenSize(rs.getString("TenSize"));
                sanPham.setGiaSize(rs.getDouble("GiaSize"));
                listSanPham.add(sanPham);
            }
            return listSanPham;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}

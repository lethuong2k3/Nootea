package Responsitories.impl;

import DomainModels.HinhThucThanhToan;
import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Responsitories.HoaDonRepository;
import Utilities.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonRepositoryImpl implements HoaDonRepository{
    
    @Override
    public HoaDon selectByMaHD(String maHD) {
        String query = "SELECT HoaDon.ID, MaHD, NhanVien.MANV, NhanVien.HoTen as 'HoTenNV', KhachHang.MaKH, KhachHang.hoTen as 'HoTenKH', KhachHang.diaChi, KhachHang.SDT, \n" +
                       "NgayTao, HoaDon.TrangThai, HinhThucThanhToan.MAHTTT,HinhThucThanhToan.Ten as 'TenHTTT', tienThuaTraKhach, TongTien, ThanhToan, HoaDon.GhiChu\n" +
                       "FROM HoaDon LEFT JOIN NhanVien ON HoaDon.IDNV = NhanVien.ID\n" +
                                   "LEFT JOIN KhachHang ON HoaDon.IDKH = KhachHang.ID\n" +
                                   "LEFT JOIN HinhThucThanhToan ON HoaDon.IDHTTT = HinhThucThanhToan.Id Where MaHD = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(query, maHD);
        try {                
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                NhanVien nv = new NhanVien();
                KhachHang kh = new KhachHang();
                HinhThucThanhToan httt = new HinhThucThanhToan();
                httt.setMaHTTT(rs.getString("MAHTTT")); httt.setTen(rs.getString("TenHTTT"));
                nv.setTaiKhoan(rs.getString("MANV")); nv.setHoTen(rs.getString("HoTenNV"));
                hd.setID(rs.getString("ID"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNv(nv); hd.setNgayTao(rs.getDate("NgayTao")); hd.setTrangThai(rs.getString("TrangThai"));
                kh.setMaKH(rs.getString("MaKH")); kh.setHoTen(rs.getString("HoTenKH")); kh.setDiaChi(rs.getString("diaChi")); kh.setSDT(rs.getString("SDT"));
                hd.setKh(kh);
                hd.setHttt(httt);
                hd.setTienThua(rs.getDouble("tienThuaTraKhach"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setThanhToan(rs.getDouble("ThanhToan"));
                hd.setGhiChu(rs.getString("GhiChu"));
                return hd;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<HoaDon> selectByHDChoTT() {
        List<HoaDon> listHD = new ArrayList<>();
        String query = "SELECT HoaDon.ID, MaHD, NhanVien.MANV, NhanVien.HoTen as 'HoTenNV', KhachHang.MaKH, KhachHang.hoTen as 'HoTenKH', KhachHang.diaChi, KhachHang.SDT, \n" +
                       "NgayTao, HoaDon.TrangThai, HinhThucThanhToan.MAHTTT,HinhThucThanhToan.Ten as 'TenHTTT', tienThuaTraKhach, TongTien, ThanhToan, HoaDon.GhiChu\n" +
                       "FROM HoaDon LEFT JOIN NhanVien ON HoaDon.IDNV = NhanVien.ID\n" +
                                   "LEFT JOIN KhachHang ON HoaDon.IDKH = KhachHang.ID\n" +
                                   "LEFT JOIN HinhThucThanhToan ON HoaDon.IDHTTT = HinhThucThanhToan.Id Where HoaDon.TrangThai LIKE N'%Chờ thanh toán%'";
        ResultSet rs = JDBC_Helper.selectTongQuat(query);
        try {                
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                NhanVien nv = new NhanVien();
                KhachHang kh = new KhachHang();
                HinhThucThanhToan httt = new HinhThucThanhToan();
                httt.setMaHTTT(rs.getString("MAHTTT")); httt.setTen(rs.getString("TenHTTT"));
                nv.setTaiKhoan(rs.getString("MANV")); nv.setHoTen(rs.getString("HoTenNV"));
                hd.setID(rs.getString("ID"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNv(nv); hd.setNgayTao(rs.getDate("NgayTao")); hd.setTrangThai(rs.getString("TrangThai"));
                kh.setMaKH(rs.getString("MaKH")); kh.setHoTen(rs.getString("HoTenKH")); kh.setDiaChi(rs.getString("diaChi")); kh.setSDT(rs.getString("SDT"));
                hd.setKh(kh);
                hd.setHttt(httt);
                hd.setTienThua(rs.getDouble("tienThuaTraKhach"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setThanhToan(rs.getDouble("ThanhToan"));
                hd.setGhiChu(rs.getString("GhiChu"));
                listHD.add(hd);
            }
            return listHD;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(HoaDon hd) {
        String query = "UPDATE [dbo].[HoaDon] SET [IDNV] = ?, [IDKH] = ?,\n" +
                       "[tienThuaTraKhach] = ?, [TongTien] = ?,[ThanhToan] = ?, [IDHTTT] = ?, [TrangThai] = ?, [GhiChu] = ? WHERE MaHD = ?";
        return JDBC_Helper.updateTongQuat(query, hd.getNv().getID(), hd.getKh().getID(), hd.getTienThua(), hd.getTongTien(),
        hd.getThanhToan(), hd.getHttt().getID(), hd.getTrangThai(), hd.getGhiChu(), hd.getMaHD()
        );
    }
    
    @Override
    public int insert(HoaDon hd) {
        String query = "INSERT INTO [dbo].[HoaDon] ([IDNV], [NgayTao], [tienThuaTraKhach],\n" +
                       "[TongTien], [ThanhToan], [IDHTTT], [TrangThai], [GhiChu]) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return JDBC_Helper.updateTongQuat(query, hd.getNv().getID(), hd.getNgayTao(),
        hd.getTienThua(), hd.getTongTien(), hd.getThanhToan(), hd.getHttt().getID(), hd.getTrangThai(), hd.getGhiChu());
    }

    @Override
    public int updateNoKH(HoaDon hd) {
         String query = "UPDATE [dbo].[HoaDon] SET [IDNV] = ?, \n" +
                       "[tienThuaTraKhach] = ?, [TongTien] = ?,[ThanhToan] = ?, [IDHTTT] = ?, [TrangThai] = ?, [GhiChu] = ? WHERE MaHD = ?";
        return JDBC_Helper.updateTongQuat(query, hd.getNv().getID(), hd.getTienThua(), hd.getTongTien(),
        hd.getThanhToan(), hd.getHttt().getID(), hd.getTrangThai(), hd.getGhiChu(), hd.getMaHD()
        );
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DANG TRUNG ANH
 */
public class MonHoc implements Serializable{
    private String tenMonHoc;
    private String maHocPhan;
    private int soChuong;
    private String gioiThieu;
    
    private ArrayList<DeThi> dsDeThi;
    private ArrayList<CauHoiTracNghiem> dsCauHoiTN;
    private ArrayList<CauHoiTuLuan> dsCauHoiTL;
    //-----------------------------
    public MonHoc(){
     
    }
    public MonHoc(String tenMonHoc, String maHocPhan, int soChuong,String gioiThieu){
        this.tenMonHoc = tenMonHoc;
        this.maHocPhan = maHocPhan;
        this.soChuong = soChuong;
        this.gioiThieu = gioiThieu;
    }
    //---------------------

    public ArrayList<CauHoiTracNghiem> getDsCauHoiTN() {
        return dsCauHoiTN;
    }

    public void setDsCauHoiTN(ArrayList<CauHoiTracNghiem> dsCauHoiTN) {
        this.dsCauHoiTN = dsCauHoiTN;
    }

    public ArrayList<CauHoiTuLuan> getDsCauHoiTL() {
        return dsCauHoiTL;
    }

    public void setDsCauHoiTL(ArrayList<CauHoiTuLuan> dsCauHoiTL) {
        this.dsCauHoiTL = dsCauHoiTL;
    }

    public ArrayList<DeThi> getDsDeThi() {
        return dsDeThi;
    }

    public void setDsDeThi(ArrayList<DeThi> dsDeThi) {
        this.dsDeThi = dsDeThi;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public int getSoChuong() {
        return soChuong;
    }

    public void setSoChuong(int soChuong) {
        this.soChuong = soChuong;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    @Override
    public String toString() {
        return tenMonHoc;
    }
    
}

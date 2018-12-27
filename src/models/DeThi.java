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
public class DeThi implements Serializable{
    private String tenDe;
    private String namHoc;
    private String kyHoc;
    private int thoiGian;
    
    private ArrayList<CauHoiTracNghiem> dsCauHoiTN;
    private ArrayList<CauHoiTuLuan> dsCauHoiTL;

    
    
    public DeThi() {
        
    }

    public DeThi(String tenDe, String namHoc, String kyHoc, int thoiGian, ArrayList<CauHoiTracNghiem> dsCauHoiTN, ArrayList<CauHoiTuLuan> dsCauHoiTL) {
        this.tenDe = tenDe;
        this.namHoc = namHoc;
        this.kyHoc = kyHoc;
        this.thoiGian = thoiGian;
        this.dsCauHoiTN = dsCauHoiTN;
        this.dsCauHoiTL = dsCauHoiTL;
    }

    public String getTenDe() {
        return tenDe;
    }

    public void setTenDe(String tenDe) {
        this.tenDe = tenDe;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    
    public String toString() {
        return tenDe;
    }

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
}

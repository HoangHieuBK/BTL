/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author DANG TRUNG ANH
 */
public class CauHoiTuLuan extends CauHoi {

    private String goiYDapAn;
    
    public CauHoiTuLuan() {
        
    }

    public CauHoiTuLuan(String deBai,String doKho,String chuong, String goiYDapAn) {
        super(deBai, doKho, chuong);
        this.goiYDapAn = goiYDapAn;
    }

    public String getGoiYDapAn() {
        return goiYDapAn;
    }

    public void setGoiYDapAn(String goiYDapAn) {
        this.goiYDapAn = goiYDapAn;
    }


    @Override
    public String inThongTinCauHoi() {
        String noiDung = "";
        noiDung += "Đề bài : " + getDeBai() + "\n";
        noiDung += "-------------------------------\n";
        noiDung += "Thông tin chi tiết :" + "\n";
        noiDung += "Gợi ý đáp án : " + getGoiYDapAn() + "\n";
        noiDung += "Độ khó : " + getDoKho() + "\n";
        noiDung += "Chương : " + getChuong() + "\n";
        return noiDung;
    }

    @Override
    public String inCauHoi() {
        String info = this.getDeBai() + "\n";
        info += getGoiYDapAn() + "\n";
        return info;
    }

}

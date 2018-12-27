/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author DANG TRUNG ANH
 */
public class CauHoiTracNghiem extends CauHoi {

    private ArrayList<DapAn> dapAn; // Kết tập 
    private boolean coTheXaoTronDuoc;

    public CauHoiTracNghiem() {
    }

    public CauHoiTracNghiem(String deBai, String doKho, String chuong, ArrayList<DapAn> dapAn) {
        super(deBai, doKho, chuong);
        this.dapAn = dapAn;
    }

    public ArrayList<DapAn> getDapAn() {
        return dapAn;
    }

    public void setDapAn(ArrayList<DapAn> dapAn) {
        this.dapAn = dapAn;
    }

    public boolean isCoTheXaoTronDuoc() {
        return coTheXaoTronDuoc;
    }

    public void setCoTheXaoTronDuoc(boolean coTheXaoTronDuoc) {
        this.coTheXaoTronDuoc = coTheXaoTronDuoc;
    }

    @Override
    public String inCauHoi() {
        int count = 64;
        String info = this.getDeBai() + "\n";
        for (DapAn da : this.getDapAn()) {
            count++;
            info +=(char) count +"."+ da.getNoiDung() + "\n";
        }
        return info;

    }

    @Override
    public String inThongTinCauHoi() {
        int count = 64;
        String noiDung = getDeBai() + "\n";
        String dapAnDung = "";
        for (DapAn dapAn : getDapAn()) {
            count++;
            noiDung += (char) count;
            noiDung += "." + dapAn.getNoiDung() + "\n";
            if (dapAn.isDapAnDung()) {
                dapAnDung += (char) count + " ";
            }
        }

        noiDung += "------------------------------------" + "\n";
        noiDung += "Thông tin chi tiết :" + "\n";
        noiDung += "Đáp án : " + dapAnDung + "\n";
        noiDung += "Độ khó : " + getDoKho() + "\n";
        noiDung += "Chương : " + getChuong() + "\n";
        if (isCoTheXaoTronDuoc()) {
            noiDung += "Các đáp án có thể xáo trộn ";
        } else {
            noiDung += "Các đáp án không thể xáo trộn";
        }
        return noiDung;
    }

}

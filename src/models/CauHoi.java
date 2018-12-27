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
public abstract class CauHoi implements Serializable{
    private String deBai;
    private String doKho;
    private String chuong;
    
    public CauHoi(){
    }
    
    public CauHoi(String deBai, String doKho, String chuong) {
        this.deBai = deBai;
        this.doKho = doKho;
        this.chuong = chuong;
    }
    
    public String getDeBai() {
        return deBai;
    }

    public void setDeBai(String deBai) {
        this.deBai = deBai;
    }

    public String getDoKho() {
        return doKho;
    }

    public void setDoKho(String doKho) {
        this.doKho = doKho;
    }

    public String getChuong() {
        return chuong;
    }

    public void setChuong(String chuong) {
        this.chuong = chuong;
    }
    
    public abstract String inCauHoi();
    public abstract String inThongTinCauHoi();
 
    public String toString() {
        return deBai;
    }
}

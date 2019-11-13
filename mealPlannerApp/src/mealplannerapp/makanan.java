/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealplannerapp;

/**
 *
 * @author asus
 */
public class makanan {
    private String nama;
    private int harga;
    public makanan(String s, int h){
        nama = s;
        harga = h;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
    public String toString(){
        return nama + " " + harga;
    }
}

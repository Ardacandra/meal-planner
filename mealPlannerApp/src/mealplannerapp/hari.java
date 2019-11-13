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
public class hari {
    private String nama;
    makanan pagi;
    makanan siang;
    makanan malam;
    public hari(String s){
        nama = s;
    }
    public String getName(){
        return nama;
    }
}

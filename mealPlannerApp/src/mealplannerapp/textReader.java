/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealplannerapp;

import java.io.*;

/**
 *
 * @author asus
 */
public class textReader {
    private BufferedReader BR;
    private heap h = new heap(15);
    int i = 0;
    public textReader(String alamat) throws FileNotFoundException, IOException{
            BR = new BufferedReader(new FileReader(alamat));
            String temp = BR.readLine();
            while(temp != null){
                int splitIndex = temp.indexOf("-");
                String nama = temp.substring(0, splitIndex);
                int harga = Integer.parseInt(temp.substring(splitIndex+1));
                h.insert(nama, harga);
                i++;
                temp = BR.readLine();
            }
            BR.close();
    }
    public heap getMenu(){
        return h;
    } 
}

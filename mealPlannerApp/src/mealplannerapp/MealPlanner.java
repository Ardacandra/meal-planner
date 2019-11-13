/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealplannerapp;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author asus
 */
public class MealPlanner {
    private int budget;
    private int sisa;
    private heap makanpagi;
    private heap makansiang;
    private heap makanmalam;
    private hari[] seminggu ={new hari("Senin"),new hari("Selasa"),new hari("Rabu"),new hari("Kamis"),new hari("Jumat"),new hari("Sabtu"),new hari("Minggu")};
    
    public MealPlanner(int i)throws FileNotFoundException, IOException {
        budget = i;
        sisa = i;
        textReader tr = new textReader("src\\mealplannerapp\\makanpagi.txt");
        makanpagi = tr.getMenu();
        tr = new textReader ("src\\mealplannerapp\\makansiang.txt");
        makansiang = tr.getMenu();
        tr = new textReader ("src\\mealplannerapp\\makanmalam.txt");
        makanmalam = tr.getMenu(); 
    }
    public hari[] setMeal(){
        int budgetSehari = budget/7;
        int excess = 0;
        for(hari h : seminggu){
            h.pagi = makanpagi.pilihMakanan(budgetSehari/3);
            sisa -= h.pagi.getHarga();
            excess = budgetSehari/3 - h.pagi.getHarga();
            h.siang = makansiang.pilihMakanan(budgetSehari/3 + excess);
            sisa -= h.siang.getHarga();
            excess = (budgetSehari/3 + excess) - h.siang.getHarga();
            h.malam = makanmalam.pilihMakanan(budgetSehari/3 + excess);
            sisa -= h.malam.getHarga();
        }
        return seminggu;
    }
    public void showMenu(int pilihan){
        switch(pilihan){
            case 1 :
                makanpagi.display();
                break;
            case 2 :
                makansiang.display();
                break;
            case 3 :
                makanmalam.display();
                break;
        }
    }
    public void display(){
        for(hari h : seminggu){
            System.out.println("\n" + h.getName() + ":");
            System.out.println("Pagi\t:" + h.pagi);
            System.out.println("Siang\t:" + h.siang);
            System.out.println("Malam\t:" + h.malam);
        }
        System.out.println("\nSisa\t:" + sisa);
    }
    public void ganti(int hari, int waktu, int menu){
        switch (waktu){
            case 1 :
                if(sisa + seminggu[hari-1].pagi.getHarga() < makanpagi.getMakanan(menu-1).getHarga()){
                    System.out.println("Sisa uang tidak cukup.");
                    break;
                }
                sisa += seminggu[hari-1].pagi.getHarga();
                seminggu[hari-1].pagi = makanpagi.getMakanan(menu-1);
                sisa -= makanpagi.getMakanan(menu-1).getHarga();
                break;
            case 2 :               
                if(sisa + seminggu[hari-1].siang.getHarga() < makansiang.getMakanan(menu-1).getHarga()){
                    System.out.println("Sisa uang tidak cukup.");
                    break;
                }
                sisa += seminggu[hari-1].siang.getHarga();
                seminggu[hari-1].siang = makansiang.getMakanan(menu-1);
                sisa -= makansiang.getMakanan(menu-1).getHarga();
                break;
            case 3 :           
                if(sisa + seminggu[hari-1].malam.getHarga() < makanmalam.getMakanan(menu-1).getHarga()){
                    System.out.println("Sisa uang tidak cukup.");
                    break;
                }
                sisa += seminggu[hari-1].malam.getHarga();
                seminggu[hari-1].malam = makanmalam.getMakanan(menu-1);
                sisa -= makanmalam.getMakanan(menu-1).getHarga();
                break;
        }
    }
}

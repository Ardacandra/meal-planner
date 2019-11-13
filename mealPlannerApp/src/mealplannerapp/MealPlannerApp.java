/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealplannerapp;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class MealPlannerApp  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("-------------\nMEAL PLANNER\n-------------");
        System.out.println("Berapa budget makan anda selama seminggu?");
        int budget = in.nextInt();
        MealPlanner mp = new MealPlanner(budget);
        mp.setMeal();
        int pilihan =0;
        do{
            System.out.println("\nPilih menu :\n1.Tampilkan\n2.Ganti\n3.Selesai");
            pilihan = in.nextInt();
            switch(pilihan){
                case 1 : 
                    mp.display();
                    break;
                case 2 :
                    System.out.println("Mau ganti hari apa?\n1.Senin\n2.Selasa\n3.Rabu\n4.Kamis\n5.Jumat\n6.Sabtu\n7.Minggu");
                    int pilihHari = in.nextInt();
                    System.out.println("Mau ganti kapan?\n1.Pagi\n2.Siang\n3.Malam");
                    int pilihWaktu = in.nextInt();
                    System.out.println("Ganti makanan apa (ketik urutan nya) :");
                    mp.showMenu(pilihWaktu);
                    int makananPengganti = in.nextInt();
                    mp.ganti(pilihHari, pilihWaktu, makananPengganti);
                    break;
                case 3 :
                    break;
            }
        }while(pilihan != 3);
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealplannerapp;
import java.util.Random;
/**
 *
 * @author asus
 */
public class heap {
    private makanan[] heapArray;
    private int maxSize;
    private int currentSize;
    public heap(int nx){
        maxSize = nx;
        currentSize = 0;
        heapArray = new makanan[maxSize];
    }
    public boolean isEmpty(){
        return currentSize==0;
    }
    public int getMin(){
        int minimumElement = heapArray[currentSize/2].getHarga();
        for(int i=1 + currentSize/2 ; i < currentSize ; i++){
            minimumElement = Math.min(minimumElement, heapArray[i].getHarga());
        }
        return minimumElement;
    }
    public int getMax(){
        return heapArray[0].getHarga();
    }
    public boolean insert(String nama,int key){
        if(currentSize==maxSize)
            return false;
        makanan newNode = new makanan(nama,key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }
    public void trickleUp(int index){
        int parent = (index-1)/2;
        makanan bottom = heapArray[index];
        
        while(index > 0 && heapArray[parent].getHarga() < bottom.getHarga()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent-1)/2;
        }
        heapArray[index] = bottom;
    }
    public makanan remove(){
        makanan root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
    public void trickleDown(int index){
        int largerChild;
        makanan top = heapArray[index];
        while(index < currentSize/2){
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;
            
            if(rightChild < currentSize && heapArray[leftChild].getHarga() < heapArray[rightChild].getHarga())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            
            if(top.getHarga() >= heapArray[largerChild].getHarga())
                break;
            
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
    public makanan pilihMakanan(int budget){
        Random rand = new Random();     // agar pilihan makanan bervariasi
        int index = 0;
        while((2*index+2) < currentSize  && heapArray[2*index+1]!=null){
            if(budget >= heapArray[index].getHarga()){
                int i = rand.nextInt(4);
                switch (i){
                    case 0 :
                    case 1 :
                        return heapArray[index];        //agar kemungkinan makanan tersebut dipilih 50%
                    case 2 :
                        index = 2*index+1;
                        break;
                    case 3 :
                        index = 2*index+2;
                        if(heapArray[index] == null)
                            index--;
                        break;
                }
            }
            else{                                       //kalau harganya terlalu mahal, pergi ke anak kiri atau kanan secara random
                int i = rand.nextInt(2);
                switch (i){
                    case 0 :
                        index = 2*index+1;
                        break;
                    case 1 :
                        index = 2*index+2;
                        if(heapArray[index] == null)
                            index--;
                        break;             
                }
            }
        }
        if (heapArray[index].getHarga() > budget){
            for(int i= 1 + currentSize/2 ; i < currentSize ; i++){
                if(heapArray[i].getHarga() <= budget)    //cek apakah budget nya cukup untuk mmembeli suatu makanan
                    return heapArray[i];
            }      
            return new makanan("Puasa", 0);         //kalau budgetnya tidak cukup untuk makan
        }
        return heapArray[index];
    }
    public void display(){
        int i = 1;
        for (makanan m : heapArray){
            System.out.println(i + ". " + m);
            i++;
        }
        System.out.println();
    }
    public makanan getMakanan(int index){
        return heapArray[index];
    }
}

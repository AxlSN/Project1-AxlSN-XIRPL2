/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class DaftarMenu {
    private ArrayList<Menu> daftarMenu;
    public DaftarMenu(){
        daftarMenu = new ArrayList<>();
    }
    public void tambahMenu(Menu menu){
       daftarMenu.add(menu);
    }
    public void getMenuByKategori(String kategori){
      System.out.println("========== " + kategori + " ==========");

        for (int i = 0; i < daftarMenu.size(); i++){
            Menu m = daftarMenu.get(i);
            if (m.getKategori().equals(kategori)){
                System.out.println((i + 1)+ ". " + m.getNama_menu() + "\t"+ m.getHarga());
            }
        }
    }
    public void tampilDaftarMenu(){
        System.out.println("========== RAMEN BERKAH ==========");
        getMenuByKategori("Ramen");
        getMenuByKategori("Kuah");
        getMenuByKategori("Toping");
        getMenuByKategori("Minuman");
    }
    public Menu pilihMenu(){
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Nomor Menu yang dipesan : ");
            int no_menu = input.nextInt();
            Menu m = daftarMenu.get(no_menu - 1);
            if(!m.getKategori().equalsIgnoreCase("Kuah")){
                return m;
            }
            else {
                System.out.println("[Error] Pesan dulu Menu Ramen");
                return pilihMenu();
            }
        }
        catch (IndexOutOfBoundsException err){
            System.out.println("[Error] Pesanan Tidak Tersedia");
            return pilihMenu();
        }
        catch (InputMismatchException err){
            System.out.println("[Error] Mohon masukan nomor menu");
            return pilihMenu();
        }
    }
    public Menu pilihKuah(){
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Kuah (sesuai nomor menu) : ");
            int no_menu = input.nextInt();

            Menu m = daftarMenu.get(no_menu-1);

            if (m.getKategori().equalsIgnoreCase("Kuah")){
                return m;
            }
            else{
                System.out.println("[Error] Bukan Menu Kuah");
                return pilihKuah();
            }
        }
        catch (IndexOutOfBoundsException err){
            System.out.println("[Error] Pesanan Tidak Tersedia");
            return pilihKuah();
        }
        catch (InputMismatchException err){
            System.out.println("[Error] Mohon masukan nomor kuah");
            return pilihKuah();
        }
    }
}

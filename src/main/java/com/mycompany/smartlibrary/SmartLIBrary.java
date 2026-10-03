package com.mycompany.smartlibrary;
import java.util.Scanner;

public class SmartLIBrary {
    
    public static void cariKoleksi(String judul, koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari buku dengan Judul: " + judul);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.print("- Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("koleksi tidak ditemukan");
    }
    
    public static void cariKoleksi(int tahunTerbit, koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari buku dengan (Angka) Tahun Terbit: " + tahunTerbit);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getTahunTerbit()  == tahunTerbit) {
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Koleksi tidak ditemukan");
    }
    
    public static void simulasiPinjam(koleksi item) {
        item.caraPinjam();
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        koleksi[] daftarKoleksi = new koleksi[10];
        
        int jumlahKoleksi = 0;
        boolean isRunning = true;
        
        System.out.println ("===========================================");
        System.out.println ("===== Selamat Datang di Smart Library =====");
        System.out.println ("===========================================");
        
        while (isRunning) {
            System.out.println ("\nMenu Utama:");
            System.out.println ("1. Tambah Koleksi");
            System.out.println ("2. Lihat Daftar Koleksi");
            System.out.println ("3. Cari Buku (Fitur Overloading)");
            System.out.println ("4. keluar");
            System.out.println ("Pilih menu (1-4): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch(pilihan) {
                case 1 -> {
                    if (jumlahKoleksi < daftarKoleksi.length) {
                        System.out.println ("\n-- Pilih Jenis Koleksi --");
                        System.out.println ("1. Buku Cetak Fisik.");
                        System.out.println ("2. E-Book Digital");
                        System.out.println("3. Majalah");
                        System.out.print ("Pilihan (1/2/3): ");
                        
                        int jenis = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Masukkan Judul: ");
                        String judulBaru = scanner.nextLine();
                        
                        System.out.print("Masukkan Pengarang: ");
                        String pengarangBaru = scanner.nextLine();
                        
                        System.out.print("Masukkan Tahun Terbit: ");
                        int tahunBaru = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (jenis == 1 ) {
                            System.out.print("Masukkan Jumlah Halaman: ");
                            int halaman = scanner.nextInt();
                            scanner.nextLine();
                            daftarKoleksi[jumlahKoleksi] = new BukuCetak(judulBaru, pengarangBaru, tahunBaru, halaman);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran File (MB): ");
                            int ukuran = scanner.nextInt();
                            scanner.nextLine();
                            daftarKoleksi[jumlahKoleksi] = new EBook(judulBaru, pengarangBaru, tahunBaru, ukuran);
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Edisi/Bulan: ");
                            String edisi = scanner.nextLine();
                            daftarKoleksi [jumlahKoleksi] = new Majalah(judulBaru, pengarangBaru, tahunBaru, edisi);
                        }
                        
                        jumlahKoleksi++;
                        System.out.println ("Sukses! objek Koleksi berhasil diciptakan dan ditambahkan ke rak. ");
                    } else {
                         System.out.println ("Maaf, Kapasitas rak buku sudah penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n=== Daftar Koleksi di Perpustakaan ===.");
                    if (jumlahKoleksi == 0) {
                        System.out.println("Belum ada buku yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahKoleksi; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarKoleksi[i].tampilkanInfo();
                            simulasiPinjam(daftarKoleksi[i]);
                            
                            daftarKoleksi[i].hitungDendaKeterlambatan();
                            if (daftarKoleksi [i] instanceof DapatDipinjam) {
                                DapatDipinjam itemFisik = (DapatDipinjam) daftarKoleksi[i];
                                itemFisik.prosesPinjamFisik();
                            }
                            if (daftarKoleksi [i] instanceof DapatDinilai){
                                DapatDinilai itemBisaDinilai = (DapatDinilai) daftarKoleksi[i];
                                itemBisaDinilai.beriRating(5);
                            }
                            
                            System.out.println();
                        }
                        
                        System.out.println("* Total Item Perpustakaan: " + koleksi.totalKoleksiBerhasilDibuat);
                    }
                    System.out.println("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3-> {
                    System.out.println("\n-- Fitur Cari koleksi --");
                    System.out.println("1. Cari berdasarkan Judul Teks (String)");
                    System.out.println("2. Cari berdasarkan Tahun (Integer) ");
                    System.out.println("Pilih (1/2) :");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (modeCari == 1) {
                        System.out.print("Masukkan Judul: ");
                        String kataKunci = scanner.nextLine();
                        cariKoleksi(kataKunci, daftarKoleksi, jumlahKoleksi); 
                    } else if (modeCari == 2) {
                        System.out.println("Masukkan Tahun: ");
                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();
                        cariKoleksi(angkaKunci, daftarKoleksi, jumlahKoleksi);
                    } else {
                        System.out.println("pilihan tidak valid.");
                    }
                    
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
            
                }
                case 4 -> {
                    
                }
                default -> {
                    System.out.println("Pilihan tidak valid. silakan masukkan angka 1-3. ");
                    scanner.nextLine();
                }
            }
        }
    }
}

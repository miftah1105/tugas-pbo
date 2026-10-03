package com.mycompany.smartlibrary;

public class EBook extends koleksi implements DapatDinilai {
    private int ukuranFileMB;
    
    public EBook(String judul, String pengarang, int tahunTerbit, int ukuranFileMB) {
        super(judul, pengarang, tahunTerbit);
        this.ukuranFileMB = ukuranFileMB;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[E-Book] Judul: %-15s | pengarang: %-10s | Tahun: %d | ukuran: %d MB%n",
                this.judul, this.pengarang, this.tahunTerbit, this.ukuranFileMB) ;
    }
    @Override
    public void caraPinjam() {
        System.out.println("-> Info Pinjam: E-Book dipinjam dengan cara di-download melalui aplikasi/situs web.");
    }
    
    @Override
    public void hitungDendaKeterlambatan(){
        System.out.println("-> Aturan Denda: Tidak ada denda. Akses otomatis dicabut jika masa pinjam habis.");
    }
    
   @Override
    public void beriRating(int bintang) {
        System.out.println("-> [ULASAN BUKU] Buku fisik ini mendapat rating" + bintang + "/5 Bintang.");
    }
}

package com.mycompany.smartlibrary;

public class Majalah extends koleksi implements DapatDipinjam {
    private String edisi;
    
    public Majalah(String judul, String pengarang, int tahunTerbit, String edisi) {
        super(judul, pengarang, tahunTerbit);
        this.edisi = edisi;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Majalah]  Judul: %-15s | penerbit: %10s | Tahun: %d | Edisi: %s%n",
        this.judul, this.pengarang, this.tahunTerbit, this.edisi);
    }
    
    
    @Override
    public void caraPinjam() {
        System.out.println("-> Info Pinjam: Majalah terbitan terbaru hanya dapat dibaca di ruang baca, tidak untuk dibawa pulang. ");
    }
    
    @Override
    public void hitungDendaKeterlambatan(){
        System.out.println("-> Aturan Denda: Rp. 2.000 / hari keterlambatan");
    }
    
    @Override
    public void prosesPinjamFisik(){
        System.out.println("-> [PROSES PINJAM] Majalah Tidak Boleh Dibawa Pulang");
    }
}

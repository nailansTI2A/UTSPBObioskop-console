import java.util.Scanner;

public class Film {
    private String id;
    private String judul;
    private String genre;
    private int durasi; // menit
    private double hargaTiket;
    private int stokTiket;

    public Film(String id, String judul, String genre, int durasi, double hargaTiket, int stokTiket) {
        this.id = id;
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.hargaTiket = hargaTiket;
        this.stokTiket = stokTiket;
    }

    public String getId() { return id; }
    public String getJudul() { return judul; }
    public int getDurasi() { return durasi; }
    public double getHargaTiket() { return hargaTiket; }
    public int getStokTiket() { return stokTiket; }

    public boolean cukupStok(int jumlah) {
        return stokTiket >= jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stokTiket) {
            stokTiket -= jumlah;
        } else {
            stokTiket = 0;
        }
    }

    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Film: ID=" + id + ", Judul=" + judul + ", Genre=" + genre + ", Durasi=" + durasi + ", Harga=" + hargaTiket + ", Stok=" + stokTiket);
    }

    public void lihatData() {
        System.out.println("ID = " + id + ", Judul = " + judul + ", Genre = " + genre + ", Durasi = " + durasi + " menit, Harga = " + (long)hargaTiket + ", Stok = " + stokTiket);
    }
}

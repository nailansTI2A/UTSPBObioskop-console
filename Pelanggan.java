import java.util.ArrayList;
import java.util.Scanner;

public class Pelanggan extends Pengguna {
    private String nomorHP;
    private ArrayList<RiwayatPemesanan> daftarRiwayat = new ArrayList<>();

    public Pelanggan(String id, String nama, String nomorHP) {
        super(id, nama);
        this.nomorHP = nomorHP;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public void tambahRiwayat(RiwayatPemesanan riwayat) {
        daftarRiwayat.add(riwayat);
        riwayat.setPelanggan(this);
    }

    public void lihatRiwayat() {
        System.out.println("Riwayat Pemesanan untuk Pelanggan " + nama + ":");
        if (daftarRiwayat.isEmpty()) {
            System.out.println("Tidak ada riwayat pemesanan.");
        } else {
            for (RiwayatPemesanan r : daftarRiwayat) {
                r.tampilkanRiwayat();
            }
        }
    }

    @Override
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Pelanggan: ID=" + id + ", Nama=" + nama + ", NoHP=" + nomorHP);
    }

    @Override
    public void lihatData() {
        System.out.println("ID = " + id + ", Nama = " + nama + ", No HP = " + nomorHP);
    }
}

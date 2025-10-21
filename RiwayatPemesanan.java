import java.time.LocalDate;

public class RiwayatPemesanan {
    private String idPemesanan;
    private Film film;
    private int jumlahTiket;
    private String tanggal;
    private Pelanggan pelanggan;

    public RiwayatPemesanan(String idPemesanan, Film film, int jumlahTiket, LocalDate tanggal) {
        this.idPemesanan = idPemesanan;
        this.film = film;
        this.jumlahTiket = jumlahTiket;
        this.tanggal = tanggal.toString();
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public String getIdPemesanan() {
        return idPemesanan;
    }

    public void tampilkanRiwayat() {
        System.out.println("=== Riwayat Pemesanan ===");
        System.out.println("ID Pemesanan : " + idPemesanan);
        System.out.println("Judul Film   : " + film.getJudul());
        System.out.println("Jumlah Tiket : " + jumlahTiket);
        System.out.println("Tanggal      : " + tanggal);
        if (pelanggan != null) {
            System.out.println("Pelanggan    : " + pelanggan.getNama());
        }
        System.out.println("==========================");
    }
}

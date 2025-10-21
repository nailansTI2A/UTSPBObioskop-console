import java.time.LocalDate;

public class Pemesanan {
    private String id;
    private LocalDate tanggalPesan;
    private int jumlahTiket;
    private double totalHarga;
    private Film film;
    private JadwalTayang jadwal;
    private Pelanggan pelanggan;
    private Petugas petugas;

    public Pemesanan(String id, Film film, JadwalTayang jadwal, Pelanggan pelanggan, Petugas petugas, int jumlahTiket) {
        this.id = id;
        this.film = film;
        this.jadwal = jadwal;
        this.pelanggan = pelanggan;
        this.petugas = petugas;
        this.jumlahTiket = jumlahTiket;
        this.tanggalPesan = LocalDate.now();
        this.totalHarga = film.getHargaTiket() * jumlahTiket;

        // kurangi stok film saat pemesanan dibuat
        this.film.kurangiStok(jumlahTiket);
    }

    public String getId() { return id; }
    public LocalDate getTanggalPesan() { return tanggalPesan; }
    public int getJumlahTiket() { return jumlahTiket; }
    public double getTotalHarga() { return totalHarga; }
    public Film getFilm() { return film; }
    public JadwalTayang getJadwal() { return jadwal; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public Petugas getPetugas() { return petugas; }

    public void pesanTiket() {
        System.out.println("=== Pemesanan Berhasil ===");
        System.out.println("ID Pemesanan : " + id);
        System.out.println("Film         : " + film.getJudul());
        System.out.println("Pelanggan    : " + pelanggan.getNama());
        System.out.println("Jumlah Tiket : " + jumlahTiket);
        System.out.println("Total Harga  : " + totalHarga);
        System.out.println("Tanggal Pesan: " + tanggalPesan);
        System.out.println("===========================");
    }

    public void lihatData() {
        System.out.println("IDPemesanan = " + id +
                ", IDFilm = " + film.getId() +
                ", Judul = " + film.getJudul() +
                ", Jumlah = " + jumlahTiket +
                ", Total = " + totalHarga +
                ", Tanggal = " + tanggalPesan);
    }
}

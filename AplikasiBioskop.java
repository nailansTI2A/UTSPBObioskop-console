import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiBioskop {
    private ArrayList<Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList<Film> daftarFilm = new ArrayList<>();
    private ArrayList<JadwalTayang> daftarJadwal = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<Pemesanan> daftarPemesanan = new ArrayList<>();
    private Petugas petugasAktif;

    public void inisialisasiData() {
        // Data dummy awal agar testing lebih mudah
        daftarPetugas.add(new Petugas("P01", "Admin", "admin", "pass"));
        daftarFilm.add(new Film("F01", "Jatuh Cinta di Bioskop", "Drama", 120, 45000.0, 50));
        daftarFilm.add(new Film("F02", "Laskar Pelangi", "Inspiratif", 110, 40000.0, 40));
        daftarJadwal.add(new JadwalTayang("J01", daftarFilm.get(0), "2025-10-20", "19:00"));
        daftarJadwal.add(new JadwalTayang("J02", daftarFilm.get(1), "2025-10-21", "20:00"));
        daftarPelanggan.add(new Pelanggan("C01", "Naila", "08123456789"));
    }

    public boolean loginPetugas(String username, String password) {
        for (Petugas p : daftarPetugas) {
            if (p.login(username, password)) {
                petugasAktif = p;
                return true;
            }
        }
        return false;
    }

    public void kelolaPetugas(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID Petugas: ");
            String id = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            Petugas p = new Petugas(id, nama, username, password);
            daftarPetugas.add(p);
            p.tambahData(scanner);
            System.out.println("Data Petugas berhasil ditambahkan!");
        } else if (opsi == 2) {
            System.out.println("Daftar Petugas:");
            for (Petugas p : daftarPetugas) {
                p.lihatData();
            }
        } else {
            System.out.println("Opsi tidak valid.");
        }
    }

    public void kelolaFilm(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID Film: ");
            String id = scanner.nextLine();
            System.out.print("Judul: ");
            String judul = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Durasi (menit): ");
            int durasi = scanner.nextInt();
            System.out.print("Harga Tiket: ");
            double harga = scanner.nextDouble();
            System.out.print("Stok Tiket: ");
            int stok = scanner.nextInt();
            scanner.nextLine();
            Film f = new Film(id, judul, genre, durasi, harga, stok);
            daftarFilm.add(f);
            f.tambahData(scanner);
            System.out.println("Data Film berhasil ditambahkan!");
        } else if (opsi == 2) {
            System.out.println("Daftar Film:");
            for (Film f : daftarFilm) {
                f.lihatData();
            }
        } else {
            System.out.println("Opsi tidak valid.");
        }
    }

    public void kelolaJadwal(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID Jadwal: ");
            String id = scanner.nextLine();
            System.out.print("ID Film: ");
            String idFilm = scanner.nextLine();
            Film selectedFilm = null;
            for (Film f : daftarFilm) {
                if (f.getId().equals(idFilm)) {
                    selectedFilm = f;
                    break;
                }
            }
            if (selectedFilm == null) {
                System.out.println("Film tidak ditemukan.");
                return;
            }
            System.out.print("Tanggal Tayang (YYYY-MM-DD): ");
            String tanggal = scanner.nextLine();
            System.out.print("Jam Tayang (HH:MM): ");
            String jam = scanner.nextLine();
            JadwalTayang j = new JadwalTayang(id, selectedFilm, tanggal, jam);
            daftarJadwal.add(j);
            j.tambahData(scanner);
            System.out.println("Data Jadwal berhasil ditambahkan!");
        } else if (opsi == 2) {
            System.out.println("Daftar Jadwal Tayang:");
            for (JadwalTayang j : daftarJadwal) {
                j.lihatData();
            }
        } else {
            System.out.println("Opsi tidak valid.");
        }
    }

    public void kelolaPelanggan(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 3. Lihat Riwayat");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID Pelanggan: ");
            String id = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Nomor HP: ");
            String hp = scanner.nextLine();
            Pelanggan pl = new Pelanggan(id, nama, hp);
            daftarPelanggan.add(pl);
            pl.tambahData(scanner);
            System.out.println("Data Pelanggan berhasil ditambahkan!");
        } else if (opsi == 2) {
            System.out.println("Daftar Pelanggan:");
            for (Pelanggan pl : daftarPelanggan) {
                pl.lihatData();
            }
        } else if (opsi == 3) {
            System.out.print("ID Pelanggan: ");
            String id = scanner.nextLine();
            Pelanggan target = null;
            for (Pelanggan pl : daftarPelanggan) {
                if (pl.getId().equals(id)) {
                    target = pl;
                    break;
                }
            }
            if (target != null) {
                target.lihatRiwayat();
            } else {
                System.out.println("Pelanggan tidak ditemukan.");
            }
        } else {
            System.out.println("Opsi tidak valid.");
        }
    }

    public void kelolaPemesanan(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Pemesanan 2. Lihat Riwayat Pemesanan");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID Pemesanan: ");
            String id = scanner.nextLine();
            System.out.print("ID Pelanggan: ");
            String idPl = scanner.nextLine();
            System.out.print("ID Film: ");
            String idFilm = scanner.nextLine();
            System.out.print("ID Jadwal: ");
            String idJadwal = scanner.nextLine();
            System.out.print("Jumlah Tiket: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            Pelanggan selectedPelanggan = null;
            for (Pelanggan pl : daftarPelanggan) {
                if (pl.getId().equals(idPl)) {
                    selectedPelanggan = pl;
                    break;
                }
            }
            if (selectedPelanggan == null) {
                System.out.println("Pelanggan tidak ditemukan.");
                return;
            }

            Film selectedFilm = null;
            for (Film f : daftarFilm) {
                if (f.getId().equals(idFilm)) {
                    selectedFilm = f;
                    break;
                }
            }
            if (selectedFilm == null) {
                System.out.println("Film tidak ditemukan.");
                return;
            }

            JadwalTayang selectedJadwal = null;
            for (JadwalTayang j : daftarJadwal) {
                if (j.getId().equals(idJadwal)) {
                    selectedJadwal = j;
                    break;
                }
            }
            if (selectedJadwal == null) {
                System.out.println("Jadwal tidak ditemukan.");
                return;
            }

            if (!selectedFilm.cukupStok(jumlah)) {
                System.out.println("Stok tiket tidak mencukupi.");
                return;
            }

            String idPemesanan = id;
            Pemesanan pem = new Pemesanan(idPemesanan, selectedFilm, selectedJadwal, selectedPelanggan, petugasAktif, jumlah);
            daftarPemesanan.add(pem);

            RiwayatPemesanan riwayat = new RiwayatPemesanan(idPemesanan, selectedFilm, jumlah, LocalDate.now());
            selectedPelanggan.tambahRiwayat(riwayat);

            pem.pesanTiket();
            System.out.println("Pemesanan berhasil disimpan ke Riwayat Pemesanan!");
        } else if (opsi == 2) {
            System.out.println("Daftar Riwayat Pemesanan:");
            if (daftarPemesanan.isEmpty()) {
                System.out.println("Tidak ada pemesanan.");
            } else {
                for (Pemesanan p : daftarPemesanan) {
                    p.lihatData();
                }
            }
        } else {
            System.out.println("Opsi tidak valid.");
        }
    }
}

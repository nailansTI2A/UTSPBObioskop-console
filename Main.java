import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AplikasiBioskop app = new AplikasiBioskop();

        // Inisialisasi data
        app.inisialisasiData();

        // Login
        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.println("Login Aplikasi Bioskop");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (app.loginPetugas(username, password)) {
                loginSuccess = true;
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Username atau password salah. Coba lagi.");
            }
        }

        // Menu utama
        boolean running = true;
        while (running) {
            System.out.println("\nMenu Aplikasi Bioskop");
            System.out.println("1. Petugas");
            System.out.println("2. Data Film");
            System.out.println("3. Jadwal Tayang");
            System.out.println("4. Pelanggan");
            System.out.println("5. Pemesanan Tiket");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = -1;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    app.kelolaPetugas(scanner);
                    break;
                case 2:
                    app.kelolaFilm(scanner);
                    break;
                case 3:
                    app.kelolaJadwal(scanner);
                    break;
                case 4:
                    app.kelolaPelanggan(scanner);
                    break;
                case 5:
                    app.kelolaPemesanan(scanner);
                    break;
                case 6:
                    running = false;
                    System.out.println("Keluar dari aplikasi. Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}

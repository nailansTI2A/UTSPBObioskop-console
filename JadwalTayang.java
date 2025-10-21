import java.util.Scanner;

public class JadwalTayang {
    private String id;
    private Film film;
    private String tanggal;  // format sederhana: YYYY-MM-DD
    private String jamTayang; // format HH:mm

    public JadwalTayang(String id, Film film, String tanggal, String jamTayang) {
        this.id = id;
        this.film = film;
        this.tanggal = tanggal;
        this.jamTayang = jamTayang;
    }

    public String getId() { return id; }
    public Film getFilm() { return film; }
    public String getTanggal() { return tanggal; }
    public String getJamTayang() { return jamTayang; }

    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Jadwal: ID=" + id + ", IDFilm=" + film.getId() + ", Tanggal=" + tanggal + ", Jam=" + jamTayang);
    }

    public void lihatData() {
        System.out.println("IDJadwal = " + id + ", IDFilm = " + film.getId() + ", Judul = " + film.getJudul() + ", Tanggal = " + tanggal + ", Jam = " + jamTayang);
    }
}

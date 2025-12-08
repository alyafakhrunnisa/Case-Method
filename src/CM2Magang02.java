// link github : https://github.com/alyafakhrunnisa/Case-Method/tree/main/src

import java.util.ArrayList;
import java.util.Scanner;

// untuk menyimpan data pendaftar magang
class Magang {
    String nama;
    String nim;
    String prodi;
    String perusahaan;
    int semester;
    String status;

    //
    Magang(String nama, String nim, String prodi, String perusahaan, int semester, String status) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.perusahaan = perusahaan;
        this.semester = semester;
        this.status = status;
    }
}

public class CM2Magang02 {
    static Scanner sc = new Scanner(System.in);

    // untuk menyimpan semua data pendaftar
    static ArrayList<Magang> data = new ArrayList<>();

    public static void main(String[] args) {
        int pilih; // variabel menu

        do {
            System.out.println("\n=== Sistem Pendaftaran Magang Mahasiswa ===");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar Magang");
            System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
            System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = sc.nextInt();
            sc.nextLine();

            // switch menu
            switch (pilih) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilSemua();
                    break;
                case 3:
                    cariProdi();
                    break;
                case 4:
                    hitungStatus();
                    break;
                case 5:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilih != 5); // ulangi sampai pilih 5 jika ingin keluar pilih 5
    }

    // function tambah data
    static void tambahData() {
        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        System.out.print("Program Studi: ");
        String prodi = sc.nextLine();
        System.out.print("Perusahaan Tujuan Magang: ");
        String perusahaan = sc.nextLine();

        // validasi semester
        int semester;
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester = sc.nextInt();
            sc.nextLine();
            if (semester == 6 || semester == 7) break;
            System.out.println("Semester hanya boleh 6 atau 7!");
        }

        // validasi status
        String status;
        while (true) {
            System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine();
            if (status.equalsIgnoreCase("Diterima") ||
                status.equalsIgnoreCase("Menunggu") ||
                status.equalsIgnoreCase("Ditolak")) {
                break;
            }
            System.out.println("Status tidak valid!"); // ulangi input jika status tidak valid
        }

        // simpan data
        data.add(new Magang(nama, nim, prodi, perusahaan, semester, status));
        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + data.size());
    }

    // function tampil semua data
    static void tampilSemua() {
        if (data.isEmpty()) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        // header tabel
        System.out.printf("\n%-3s %-10s %-12s %-20s %-10s %-10s\n",
                "No", "Nama", "NIM", "Prodi", "Semester", "Status"); 

        // tampil data  
        int no = 1;
        for (Magang m : data) {
            System.out.printf("%-3d %-10s %-12s %-20s %-10d %-10s\n",
                    no++, m.nama, m.nim, m.prodi, m.semester, m.status);
        }
    }

    //function cari prodi
    static void cariProdi() {
        if (data.isEmpty()) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        System.out.print("Masukkan Program Studi: ");
        String cari = sc.nextLine();

        // header tabel
        System.out.printf("\n%-3s %-10s %-12s %-20s %-10s %-10s\n",
                "No", "Nama", "NIM", "Prodi", "Semester", "Status");

        // tampil data yang sesuai prodi
        int no = 1;
        boolean ada = false;
        for (Magang m : data) {
            if (m.prodi.equalsIgnoreCase(cari)) {
                ada = true;
                System.out.printf("%-3d %-10s %-12s %-20s %-10d %-10s\n",
                        no++, m.nama, m.nim, m.prodi, m.semester, m.status);
            }
        }

        if (!ada) System.out.println("Tidak ada pendaftar untuk program studi tersebut.");
    }

    // function untuk menghitung jumlah status
    static void hitungStatus() {
        // inisialisasi counter
        int diterima = 0, menunggu = 0, ditolak = 0;

        // hitung status
        for (Magang m : data) {
            if (m.status.equalsIgnoreCase("Diterima")) diterima++;
            else if (m.status.equalsIgnoreCase("Menunggu")) menunggu++;
            else if (m.status.equalsIgnoreCase("Ditolak")) ditolak++;
        }

        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
        System.out.println("Total pendaftar: " + data.size());
    }
}
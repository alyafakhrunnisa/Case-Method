// link github : https://github.com/alyafakhrunnisa/Case-Method/tree/main/src

import java.util.Scanner;

public class CM2Magang02 {

    static Scanner sc = new Scanner(System.in);

    // kapasitas maksimum 100 pendaftar
    static String[][] data = new String[100][6];
    static int jumlahData = 0; // menghitung berapa data yang sudah terisi

    public static void main(String[] args) {

        int pilih;

        // pilihan menu
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

        } while (pilih != 5);
    }

    static void tambahData() {
        if (jumlahData >= 100) {
            System.out.println("Data penuh! Tidak bisa menambah lagi.");
            return;
        }

        System.out.print("Nama Mahasiswa: ");
        data[jumlahData][0] = sc.nextLine();

        System.out.print("NIM: ");
        data[jumlahData][1] = sc.nextLine();

        System.out.print("Program Studi: ");
        data[jumlahData][2] = sc.nextLine();

        System.out.print("Perusahaan Tujuan Magang: ");
        data[jumlahData][3] = sc.nextLine();

        // Validasi semester
        while (true) {
            System.out.print("Semester (6 atau 7): ");
            String sem = sc.nextLine();

            if (sem.equals("6") || sem.equals("7")) {
                data[jumlahData][4] = sem;
                break;
            }
            System.out.println("Semester hanya boleh 6 atau 7!");
        }

        // Validasi status
        while (true) {
            System.out.print("Status (Diterima/Menunggu/Ditolak): ");
            String status = sc.nextLine();

            if (status.equalsIgnoreCase("Diterima") ||
                status.equalsIgnoreCase("Menunggu") ||
                status.equalsIgnoreCase("Ditolak")) {

                data[jumlahData][5] = status;
                break;
            }
            System.out.println("Status tidak valid!");
        }

        jumlahData++;
        System.out.println("Data berhasil ditambahkan! Total pendaftar: " + jumlahData);
    }

    // Fungsi untuk menampilkan semua data pendaftar
    static void tampilSemua() {
        if (jumlahData == 0) {
            System.out.println("Belum ada pendaftar");
            return;
        }

        System.out.printf("\n%-3s %-10s %-12s %-15s %-10s %-10s\n",
                "No", "Nama", "NIM", "Prodi", "Semester", "Status");

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-3d %-10s %-12s %-15s %-10s %-10s %-10s\n",
                    (i + 1),
                    data[i][0], data[i][1], data[i][2],
                    data[i][4], data[i][5]);
        }
    }

    // Fungsi untuk mencari pendaftar berdasarkan program studi
    static void cariProdi() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data");
            return;
        }

        System.out.print("Masukkan Program Studi yang dicari : ");
        String cari = sc.nextLine();

        System.out.printf("\n%-3s %-10s %-12s %-15s %-10s %-10s\n",
                "No", "Nama", "NIM", "Prodi", "Semester", "Status");

        int nomor = 1;
        boolean ada = false;

        for (int i = 0; i < jumlahData; i++) {
            if (data[i][2].equalsIgnoreCase(cari)) {
                ada = true;
                System.out.printf("%-3d %-10s %-12s %-15s %-10s %-10s\n",
                        nomor++,
                        data[i][0], data[i][1], data[i][2],
                        data[i][4], data[i][5]);
            }
        }

        if (!ada) {
            System.out.println("Tidak ada pendaftar untuk prodi " + cari);
        }
    }

    // Fungsi untuk menghitung jumlah pendaftar berdasarkan status
    static void hitungStatus() {
        int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < jumlahData; i++) {
            String s = data[i][5];

            if (s.equalsIgnoreCase("Diterima")) diterima++;
            else if (s.equalsIgnoreCase("Menunggu")) menunggu++;
            else if (s.equalsIgnoreCase("Ditolak")) ditolak++;
        }

        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
        System.out.println("Total pendaftar: " + jumlahData);
    }
}

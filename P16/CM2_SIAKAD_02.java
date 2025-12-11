package P16;
import java.util.Scanner;

public class CM2_SIAKAD_02 {
    static Scanner agung = new Scanner(System.in);

    static class pegawai02 {
        String nama02 = "(Belum diisi)";
        String nik02 = "-";
        double gajiPokok02 = 0;
        boolean status02 = false;
        int JumlahAnak02 = 0;
        int lamaKerja02 = 0;
        boolean sudahIsi02 = false;
    }

    public static void main(String[] args) {
        System.out.println("=== SISTEM PENGGAJIAN MULTI PEGAWAI (ARRAY 2D) ===");
        System.out.print("Masukkan Jumlah Pegawai : ");
        int jmlPegawai02 = agung.nextInt();

        pegawai02[] peg02 = new pegawai02[jmlPegawai02];
        for (int i = 0; i < jmlPegawai02; i++) {
            peg02[i] = new pegawai02();
        }

        int menu02 = 0;

        while (menu02 !=3) {
            System.out.println("-".repeat(50));
            System.out.println("1. Input/Edit Data Pegawai");
            System.out.println("2. Lihat Slip Gaji Pegawai");
            System.out.println("3. Keluar");
            System.out.println("-".repeat(50));
            System.out.print("Pilih Menu (1-3) : ");
            menu02 = agung.nextInt();

            switch (menu02) {
                case 1:
                    inputDataPegawai02(peg02);
                    break;
                case 2:
                    lihatSlipGaji02(peg02);
                    break;
                case 3:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    //bagian input
    static void inputDataPegawai02(pegawai02[] peg02) {
        System.out.println();
        System.out.println("=".repeat(17) + " DAFTAR PEGAWAI " + "=".repeat(17));

        for (int i = 0; i < peg02.length; i++) {
            System.out.println((i + 1) + ". " + peg02[i].nama02 + " / " + peg02[i].nik02);
        }

        System.out.println("=".repeat(50));
        System.out.println();
        System.out.print("Pilih Pegawai (1-2): ");
        int pilih02 = agung.nextInt() - 1;
        agung.nextLine();

        System.out.println("Pegawai terplih: " + peg02[pilih02].nama02 + " / " + peg02[pilih02].nik02);
        System.out.println();
        System.out.println("=".repeat(12) + " INPUT DATA PEGAWAI No. " + (pilih02 + 1) + " " + "=".repeat(12));

        if (peg02[pilih02].nama02.equals("(Belum diisi)")) {
            System.out.print("Nama : ");
            peg02[pilih02].nama02 = agung.nextLine();
            System.out.print("NIK  : ");
            peg02[pilih02].nik02 = agung.nextLine();
            
        }

        //buat input gaji
        do {
            System.out.print("Gaji Pokok (>0): ");
            peg02[pilih02].gajiPokok02 = agung.nextDouble();

            if (peg02[pilih02].gajiPokok02 <= 0) {
                System.out.println("Input Gaji Tidak Valid! Input Ulang!");
            }

        } while (peg02[pilih02].gajiPokok02 <= 0);

        //buat input status nikah
        String status;
        do {
            System.out.print("Menikah? (y/n): ");
            status = agung.next().toLowerCase();

            if (!status.equals("y") && !status.equals("n")) {
            }

        } while (!status.equals("y") && !status.equals("n"));

        peg02[pilih02].status02 = status.equals("y");

        //buat input jumlah anak
        do {
            System.out.print("Jumlah Anak: ");
            peg02[pilih02].JumlahAnak02 = agung.nextInt();

            if (peg02[pilih02].JumlahAnak02 < 0) {
                System.out.println("Tidak ada jumlah anak negatif! Input ulang!");
            }

        } while (peg02[pilih02].JumlahAnak02 < 0);

        //buat input lama kerja
        do {
            System.out.print("Lama Kerja (tahun): ");
            peg02[pilih02].lamaKerja02 = agung.nextInt();

            if (peg02[pilih02].lamaKerja02 < 0) {
                System.out.println("Invalid tidak boleh negatif! Input ulang!");
            }
        } while (peg02[pilih02].lamaKerja02 < 0);

        peg02[pilih02].sudahIsi02 = true;
        System.out.println("[OK] Data Pegawai Disimpan.");
    }

    //bagian hitung 
    static double hitungTunjanganIstri02(pegawai02 n) {
        if (n.status02) {
            return 0.10 * n.gajiPokok02;
        } else {
            return 0;
        }
    }

    static double hitungTunjanganAnak02(pegawai02 n) {
        int anak02; 
        if (n.JumlahAnak02 > 3) {
            anak02 = 3;
        } else {
            anak02 = n.JumlahAnak02;
        }

        return anak02 * 0.02 * n.gajiPokok02;
    }

    static double hitungBonus02(pegawai02 n) {
        if (n.lamaKerja02 > 10) {
            return 0.10 * n.gajiPokok02;
        } else {
            return 0;
        }
    }

    static double hitungGajiKotor(pegawai02 n) {
        return n.gajiPokok02 + hitungTunjanganIstri02(n) + hitungTunjanganAnak02(n) + hitungBonus02(n);
    }

    static double hitungPajak02(double gajiKotor02) {
        return 0.05 * gajiKotor02;
    }

    static double hitungGajiBersih02(pegawai02 n) {
        double gajiKtr02 = hitungGajiKotor(n);
        return gajiKtr02 - hitungPajak02(gajiKtr02);
    }

    //bagian Lihat slip gaji
    static void lihatSlipGaji02 (pegawai02[] peg02) {
        System.out.println("=".repeat(25) + " DAFTAR PEGAWAI " + "=".repeat(25));

        for (int i = 0; i < peg02.length; i++) {
            System.out.println((i + 1) + ". " + peg02[i].nama02 + " / " + peg02[i].nik02);
        }

        System.out.println("=".repeat(50));
        System.out.print("Pilih Pegawai (1-2): ");
        int pilih02 = agung.nextInt() - 1;
        System.out.println("Pegawai terpilih: " + peg02[pilih02].nama02 + " / " + peg02[pilih02].nik02);

        pegawai02 n = peg02[pilih02];

        double tIstri02 = hitungTunjanganIstri02(n);
        double tAnak02 = hitungTunjanganAnak02(n);
        double bonus02 = hitungBonus02(n);
        double gKotor02 = hitungGajiKotor(n);
        double pajak02 = hitungPajak02(gKotor02);
        double gBersih02 = hitungGajiBersih02(n);

        System.out.println("=".repeat(25) + " SLIP GAJI " + "=".repeat(25));
        System.out.println("Nama               : " + n.nama02);
        System.out.println("NIK                : " + n.nik02);
        System.out.println("Gaji Pokok         : Rp. " + n.gajiPokok02);
        System.out.println("Tunjangan Istri    : Rp. " + tIstri02);
        System.out.println("Tunjangan Anak     : Rp. " + tAnak02);
        System.out.println("Bonus              : Rp. " + bonus02);
        System.out.println("-".repeat(50));
        System.out.println("Gaji Kotor (Gross) : Rp. " + gKotor02);
        System.out.println("Pajak (5%)         : Rp. " + pajak02);
        System.out.println("-".repeat(50));
        System.out.println("Gaji Bersih (Net)  : Rp. " + gBersih02);

    }
}
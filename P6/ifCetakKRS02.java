package P6;
import java.util.Scanner;

public class ifCetakKRS02 {
    public static void main(String[] args) {

        String cetak02;
        boolean uktLunas02;

        Scanner agung =  new Scanner(System.in);
        
        System.out.println("--- Cetak KRS SIAKAD ---");
        System.out.print("Apakah UKT sudah lunas? (true/false) : ");
        uktLunas02 = agung.nextBoolean();

        if (uktLunas02) {
            System.out.println("Pembayaran UKT terverifikasi");
            System.out.println("Silahkan cetak KRS dan minta tanda tangan DPA");
        } else {
            System.out.println("“Registrasi ditolak. Silakan lunasi UKT terlebih dahulu");
        }

        // cetak02 = uktLunas02 ? "Pembayaran UKT terverifikasi" + ", Silahkan cetak KRS dan minta tanda tangan DPA" : "Maaf, registrasi anda ditolak";
        // System.out.println(cetak02);

    }
}

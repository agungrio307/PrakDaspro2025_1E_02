package P6;
import java.util.Scanner;

public class switchCetakKRS02 {
    public static void main(String[] args) {
        
        int semester02;

        Scanner agung = new Scanner(System.in);

        System.out.println("--- Cetak KRS SIAKAD ---");
        System.out.print("Masukkan Semester saat ini: ");
        semester02 = agung.nextInt();

        switch (semester02) {
            case 1:
                System.out.println("KRS Semester 1 ditampilkan");
                break;
            case 2:
                System.out.println("KRS Semester 2 ditampilkan");
                break;
            case 3:
                System.out.println("KRS Semester 3 ditampilkan");
                break;
            case 4:
                System.out.println("KRS Semester 4 ditampilkan");
                break;
            case 5:
                System.out.println("KRS Semester 5 ditampilkan");
                break;
            case 6:
                System.out.println("KRS Semester 6 ditampilkan");
                break;
            case 7:
                System.out.println("KRS Semester 7 ditampilkan");
                break;
            case 8:
                System.out.println("KRS Semester 8 ditampilkan");
                break;
            default:
                System.out.println("Semester tidak valid");

        }
    }
}

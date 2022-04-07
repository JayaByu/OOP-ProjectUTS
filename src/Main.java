import java.util.Scanner;
import java.util.Vector;

class menu {
    menu() {
        System.out.println("Emoni");
        System.out.println("1. Pembuatan akun");
        System.out.println("2. Isi Saldo");
        System.out.println("3. Cek Saldo");
        System.out.println("4. Transfer Saldo");
        System.out.println("5. Exit");
    }
}

class input {
    input() {
        System.out.print(">> ");
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
    }   

    public void PembuatanAkun() {
        System.out.println("Nama Akun : ");
        System.out.println("Nomor HandPhone : ");
        System.out.println("Saldo Awal : ");
    }

    public void IsiSaldo() {
        System.out.println("Saldo Tambahan : ");
        System.out.println("Nomor Virtual Account : ");
    }

    public void CekSaldo() {
        System.out.println("Jumlah Saldo : ");
    }

    public void Transfer() {
        System.out.println("Input Nomor Virtual Account : ");
        System.out.println("Jumlah Saldo Transfer : ");
    }

    public Main() {
        Scanner sc = new Scanner(System.in);
        Vector<eMoney> duit = new Vector<>();

        int input = -1;
        boolean isRun = true;

        do {
            do {
                new menu();
                new input();
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    input = -1;
                }
                sc.nextLine();
            } while (input < 1 || input > 5);

            switch (input) {
                case 1:
                    PembuatanAkun();
                    break;
                case 2:
                    IsiSaldo();
                    break;
                case 3:
                    CekSaldo();
                    break;
                case 4:
                    Transfer();
                    break;
                case 5:
                    isRun = !isRun;
                    break;

                default:
                    break;
            }
        } while (isRun);
    }

}

import java.util.Scanner;

class menu {
    menu() {
        System.out.println("Welcome to We-Money");
        System.out.println("===================");
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
    Scanner sc = new Scanner(System.in); 
    
    public void clear() {
    	for (int i = 0; i < 25; i++) {
			System.out.println();
		}
    }
    
    public Main() { 
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
            } while (input < 0 || input > 5);

            switch (input) {
                case 0:
                	
                    break;
                case 1:
                	
                    break;
                case 2:
                	clear();
                	IsiSaldo();
                    break;
                case 3:
                	
                    break;
                case 4:
                	
                    break;
                case 5:
                    isRun = !isRun;
                    break;
                default:
                    break;
            }
        } while (isRun);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}

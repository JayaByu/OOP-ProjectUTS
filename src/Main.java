import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

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
    Random random = new Random();
    Vector <eMoney> duit = new Vector<>();
	
    public void clear() {
    	for (int i = 0; i < 25; i++) {
			System.out.println();
		}
    }
    
//Bagian 1
    public void PembuatanAkun() {
        String nama = "";
        String nomor = "";
        String noVA = "";
        String verify;
        int saldo = 0;
        int r1, r2, r3;
        System.out.println("Masukan Data Diri Anda");
        System.out.println("=======================\n");
        do {
        	System.out.print("Nama Akun : ");
        	nama = sc.nextLine();
		} while (nama.length()<1);
        do {
            System.out.print("Nomor HandPhone : ");
            nomor = sc.nextLine();
        } while (nomor.length() < 12 || nomor.length() > 13);
        r1 = random.nextInt(10);
        r2 = random.nextInt(10);
        r3 = random.nextInt(10);
        noVA = nomor+r1+r2+r3;
        do {
        	System.out.print("Masukan saldo awal [minimal 50000]: ");
        	try {
    			saldo = sc.nextInt();
    		} catch (Exception e) {
    			// TODO: handle exception
    			saldo = 0;
    		}
        	sc.nextLine();
		} while (saldo<50000);
        
        do {
        	System.out.print("\nApakah anda yakin untuk membuat akun [Y/N] : ");
            verify = sc.nextLine();
		} while (!verify.equals("Y") && !verify.equals("n") && !verify.equals("y") && !verify.equals("N"));
        
        clear();
        if(verify.equals("Y")) {
        	System.out.println("\n\n\nAkun berhasil dibuat");
			System.out.println("====================");
			System.out.println();
			System.out.println("Nama               : "+nama);
			System.out.println("No Virtual Account : "+noVA+"   <-Penting Diingat");
			System.out.println("Total Saldo        : "+saldo);
			System.out.println();
			duit.add(new eMoney(noVA, saldo, new dataUser(nama, nomor)));
        }
        else {
        	System.out.println("\n\nPembuatan akun dibatalkan");
        	System.out.println();
        }
    }	
	
	
//Menu 2
public void IsiSaldo() {
    	if(duit.isEmpty()) {
    		System.out.println("Mohon maaf masih belum terdapat akun yang terdaftar\n\n");
    	}
    	else {
    		boolean run = true;
    		int i =0;
    		String uji="";
    		int saldoTambahan;
    		String verify;
    		System.out.print("Masukan Nomor Virtual Account Anda: ");
    		uji= sc.nextLine();
    		
    		do {
    			if(uji.equals(duit.get(i).getNoVA())){
    				do {
    					System.out.print("Berapa banyak saldo We-Money yang ingin diisi [Minimal : 10000]: ");
    					try {
    						saldoTambahan= sc.nextInt();
    					} catch (Exception e) {
    						// TODO Auto-generated catch block
    						saldoTambahan=0;
    					}
    					sc.nextLine();
    				} while (saldoTambahan<10000);
    				
    				clear();
    				System.out.println("Preview isi saldo We-Money");
    				System.out.println("==========================");
    				System.out.println("Nama               : "+duit.get(i).getDataUser().getNama());
    				System.out.println("No Virtual Account : "+duit.get(i).getNoVA());
    				System.out.println("Saldo tambahan     : "+saldoTambahan);
    				do {
    		        	System.out.print("Apakah akun yang ingin diisi saldo sudah benar? [Y/n] (case sensitive): ");
    		            verify = sc.nextLine();
    				} while (!verify.equals("Y") && !verify.equals("n") && !verify.equals("y") && !verify.equals("N"));
    		        clear();
    				if(verify.equals("Y")) {
    		        	System.out.println("\n\n\nSaldo berhasil ditambahkan");
    					System.out.println("====================");
    					System.out.println();
    					System.out.println("Nama               : "+duit.get(i).getDataUser().getNama());
    					System.out.println("No Virtual Account : "+duit.get(i).getNoVA());
    					System.out.println("Saldo Awal         : "+duit.get(i).getSaldo());
    					System.out.println("Tambahan Saldo     : "+saldoTambahan);
    					duit.get(i).setSaldo(saldoTambahan+duit.get(i).getSaldo());
    					System.out.println("\nTotal Saldo        : "+duit.get(i).getSaldo());
    					System.out.println();
    		        }
    		        else {
    		        	System.out.println("\n\nPengisian saldo dibatalkan\n\n");
    		        	System.out.println();
    		        }    				
    				run= false;
    			}
    			i++;
    		} while (i< duit.size());
    		if(run== true) {
    			clear();
    			System.out.println("Mohon maaf nomor Virtual Account anda tidak ditemukan\n\n");
    		}
    	}
    }

	
	

//MENU VALIDASI
    public void validasi(){
    	System.out.print("Ketik apapun untuk lanjut: ");
    	sc.nextLine();
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
                	clear();
                    	PembuatanAkun();
                    	validasi();
                    	clear();
                    	break;
                case 2:
                	clear();
                    	IsiSaldo();
                    	validasi();
                    	clear();
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

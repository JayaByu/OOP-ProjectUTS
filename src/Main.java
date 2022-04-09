import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


//pada class ini berfungsi sebagai tampilan menu dari WeMoney
class menu {
    menu() {
        System.out.println("Welcome to We-Money");
        System.out.println("===================");
        // terdapat fitur angka 0 untuk sebagai admin
        System.out.println("1. Pembuatan akun");
        System.out.println("2. Isi Saldo");
        System.out.println("3. Cek Saldo");
        System.out.println("4. Transfer Saldo");
        System.out.println("5. Exit");
    }
}


//pada kelas ini akan mengeluarkan tanda tempat buat input
class input {
    input() {
        System.out.print(">> ");
    }
}

public class Main {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    Vector <eMoney> duit = new Vector<>();
    
    
    // CLEAR berfungsi sebagai melakukan pembersihan layar tampilan
    public void clear() {
    	for (int i = 0; i < 25; i++) {
			System.out.println();
		}
    }
    
    
    // FITUR 1, melakukan pembuatan akun dari user.
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
        // pemggunaan OR disini dikarenakan banyak karakter yang dimau adalah antara 12
        // - 13 angka.
        // oleh karena itu dibuat kurang dari 12 atau inputan lebih dari 13 akan di
        // ulang.
        
        
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
        // Pada bagian validasi ini menggunakan konsep AND, hal ini dikarenakan kita
        // meminta inputan dengan penerapan case sensitive
        // Logika disini menunjukan apabila inputan bukan Y & n maka dia akan meminta
        // inputan ulang.

        
        
        clear();
        if(verify.equalsIgnoreCase("y")) {
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
    
    
    // FITUR 2, pada vitur ini kita bisa melakukan pengisian saldo WeMoney,
    // menggunakan VA
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
    		
    		do {// pada bagian ini berfungsi sebagai pencari virtual account user yang ingin
                // diisi saldonya
    			if(uji.equals(duit.get(i).getNoVA())){// Virtual Account ditemukan
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
    				
    				//verifikasi benar atau tidak nama sama no.virtual account yang diinginkan.
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
                    // Pada bagian validasi ini menggunakan konsep AND, hal ini dikarenakan kita
                    // meminta inputan dengan penerapan case sensitive
                    // Logika disini menunjukan apabila inputan bukan Y & n maka dia akan meminta
                    // inputan ulang.
    				
    				clear();
    				if(verify.equalsIgnoreCase("y")) {
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
    
    
    
    // FITUR 3, pada fitur ini kita dapat melakukan pengecekan saldo
    public void CekSaldo() {
    	if (duit.isEmpty()) {
    		System.out.println("Mohon maaf masih belum terdapat akun yang terdaftar\n\n");
		}
    	else {
    		boolean run = true;
    		int i =0;
    		String uji="";
    		System.out.print("Masukan Nomor Virtual Account Anda: ");
    		uji= sc.nextLine();
    		
    		do { // pada bagian ini berfungsi sebagai pencari virtual account user yang ingin
                // melakukan di cek saldonya
    			if(uji.equals(duit.get(i).getNoVA())){
    		        clear();
    		        	System.out.println("\n\n\nTampilan Saldo Anda");
    					System.out.println("====================");
    					System.out.println();
    					System.out.println("Nama               : "+duit.get(i).getDataUser().getNama());
    					System.out.println("No Virtual Account : "+duit.get(i).getNoVA());
    					System.out.println("Total Saldo        : "+duit.get(i).getSaldo());
    					System.out.println();
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
    
    
    
    // FITUR 4, pada fitur ini kita bisa melakukan transfer ke akun WeMoney orang
    // lain yang sudah didata oleh sistem
    public void Transfer() {
    	if(duit.isEmpty()) {
    		System.out.println("Mohon maaf masih belum terdapat akun yang terdaftar\n\n");
    	}
    	else {
    		boolean run = true;
    		boolean run2 = true;
    		int i =0,j=0;
    		String ujiVA="";
    		String uji="";
    		int transferan;
    		String verify;
    		System.out.print("Masukan Nomor Virtual Account Anda: ");
    		ujiVA= sc.nextLine();
    		do {// pada bagian ini berfungsi sebagai pencari virtual account user yang ingin
                // melakukan transfer
    			
    			if(duit.get(j).getNoVA().equals(ujiVA)) { 
    				System.out.print("Masukan Nomor Virtual Account Tujuan Anda: ");
    	    		uji= sc.nextLine();
    	    		
    				do {// Pada bagian ini berfungsi sebagai pencarian dari pada Virtual Account yg
                        // dituju
    					
            			if(uji.equals(duit.get(i).getNoVA())){//VA Tujuan ditemukan
            				do {
            					System.out.print("Berapa banyak saldo We-Money yang ingin diisi [Minimal : 10000]: ");
            					try {
            						transferan= sc.nextInt();
            					} catch (Exception e) {
            						// TODO Auto-generated catch block
            						transferan=0;
            					}
            					sc.nextLine();
            				} while (transferan<10000);
            				
            				//verifikasi benar atau tidak nama sama no.virtual account yang diinginkan.
            				clear();
            				System.out.println("Preview akun tujuan");
            				System.out.println("==========================");
            				System.out.println("Nama               : "+duit.get(i).getDataUser().getNama());
            				System.out.println("No Virtual Account : "+duit.get(i).getNoVA());
            				System.out.println("Saldo tambahan     : "+transferan);
            				do {
            		        	System.out.print("Apakah akun yang ingin ditransfer sudah benar? [Y/N] : ");
            		            verify = sc.nextLine();
            				} while (!verify.equals("Y") && !verify.equals("n") && !verify.equals("y") && !verify.equals("N"));
                            // Pada bagian validasi ini menggunakan konsep AND, hal ini dikarenakan kita
                            // meminta inputan dengan penerapan case sensitive
                            // Logika disini menunjukan apabila inputan bukan Y & n maka dia akan meminta
                            // inputan ulang.
            				
            				clear();
                            // pada bagian dibawah berfungsi sebagai validasi apakah saldo yang ingin di
                            // transfer cukup.
            				if(verify.equalsIgnoreCase("y")) {
            					if(transferan>duit.get(j).getSaldo()) {
                        			System.out.println("Mohon maaf saldo anda tidak mencukupi, proses transfer dibatalkan\n\n");
            					}
            					else {
            						System.out.println("\n\n\nTransfer Berhasil Dilakukan");
                					System.out.println("====================");
                					System.out.println();
                					System.out.println("Nama               : "+duit.get(i).getDataUser().getNama());
                					System.out.println("No Virtual Account : "+duit.get(i).getNoVA());
                					System.out.println("Nominal Transfer   : "+transferan);
                					duit.get(j).setSaldo(duit.get(j).getSaldo()-transferan); // saldo pengirim akan
                                    														// dikurangi
                					duit.get(i).setSaldo(duit.get(i).getSaldo()+transferan); // saldo penerima akan
                                    														// ditambah
                					System.out.println();
            					}
            		        }
            		        else {
            		        	System.out.println("\n\nTransfer antar akun dibatalkan\n\n");
            		        	System.out.println();
            		        }
            				
            				
            				run= false;
            			}
            			i++;
            		} while (i< duit.size());
            		if(run== true) {
            			clear();
            			System.out.println("Mohon maaf nomor Virtual Account tujuan tidak ditemukan\n\n");
            		}
            		
            		run2= false;
    			}
        		j++;
			} while (j<duit.size());
    		
    		if(run2== true) {
    			clear();
    			System.out.println("Mohon maaf nomor Virtual Account anda tidak ditemukan\n\n");
    		}
    		
    	}
    }
    
    
    //MENU ADMIN
    public void Admin() {
    	if(duit.isEmpty()) {
    		System.out.println("Mohon maaf tidak adak akun yang tersimpan pada sistem");
    		System.out.println("======================================================");
    	}
    	else {
			System.out.println("Database User Rekening");
    		for (int i = 0; i < duit.size(); i++){
    			System.out.println("=========================================================================");
    			System.out.println(duit.get(i).getNoVA()+"    | "+duit.get(i).getDataUser().getNama()+"    | "+duit.get(i).getSaldo());
    		}
    		//remove
    	}
    }
    
    
    //MENU VALIDASI
    public void validasi(){
    	System.out.print("Ketik apapun untuk lanjut: ");
    	sc.nextLine();
    }
    
    
    //MAIN PROGRAM
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
                	clear();
                    Admin();
                    System.out.println("\n\n\n");
                    validasi();
                    clear();
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
                	clear();
                    CekSaldo();
                    validasi();
                    clear();
                    break;
                case 4:
                	clear();
                    Transfer();
                    validasi();
                    clear();
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

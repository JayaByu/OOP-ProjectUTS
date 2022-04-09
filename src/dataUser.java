public class dataUser {
    private String Nama;
    private String Nomor;

    public dataUser(String nama, String nomor) {
        Nama = nama;
        Nomor = nomor;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getNomor() {
        return Nomor;
    }

    public void setNomor(String nomor) {
        Nomor = nomor;
    }

}

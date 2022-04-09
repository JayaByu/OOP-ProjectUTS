public class eMoney {
    private String noVA;
    private int Saldo;
    private dataUser dataUser;

    public eMoney(String noVA, int saldo, dataUser dataUser) {
        this.noVA = noVA;
        Saldo = saldo;
        this.dataUser = dataUser;
    }

    public dataUser getDataUser() {
        return dataUser;
    }

    public void setDataUser(dataUser dataUser) {
        this.dataUser = dataUser;
    }

    public String getNoVA() {
        return noVA;
    }

    public void setNoVA(String noVA) {
        this.noVA = noVA;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

}
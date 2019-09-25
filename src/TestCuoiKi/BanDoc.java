package TestCuoiKi;

public class BanDoc {//(mã bạn đọc, Họ tên, địa chỉ, Số ĐT),
    private int idBD;
    private String nameBD,address,numberP;
    private static int idBDATUTO_INCREAMENT = 10000;
    public BanDoc(String nameBD, String address, String numberP) {
        idBD = idBDATUTO_INCREAMENT++;
        this.nameBD = nameBD;
        this.address = address;
        this.numberP = numberP;
    }

    public int getIdBD() {
        return idBD;
    }

    public void setIdBD(int idBD) {
        this.idBD = idBD;
    }

    public String getNameBD() {
        return nameBD;
    }

    public void setNameBD(String nameBD) {
        this.nameBD = nameBD;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberP() {
        return numberP;
    }

    public void setNumberP(String numberP) {
        this.numberP = numberP;
    }
}

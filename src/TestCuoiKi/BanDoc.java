package TestCuoiKi;

public class BanDoc {//(mã bạn đọc, Họ tên, địa chỉ, Số ĐT),
    private int idBD;
    private String nameBD,address,numberP;
    private static int idBDATUTO_INCREAMENT = 10000;
    public BanDoc(String nameBD, String address, String numberP) {
        this.nameBD = nameBD;
        this.address = address;
        this.numberP = numberP;
    }
}

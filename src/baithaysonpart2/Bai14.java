package baithaysonpart2;

public class Bai14 {
    public static void main(String[] args) {
        SoPhuc soPhuc = new SoPhuc();
        SoPhuc sp = new SoPhuc();
        soPhuc.nhap();
        sp.nhap();
        SoPhuc result = new SoPhuc();
        result = sp.nhan(soPhuc);
        result.in();
    }
}

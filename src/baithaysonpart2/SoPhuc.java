package baithaysonpart2;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class SoPhuc {
    private float a;
    private float b;

    public SoPhuc() {
        a = b = 0;
    }

    public SoPhuc(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public SoPhuc cong(SoPhuc sp) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.a = this.a + sp.a;
        soPhuc.b = this.b + sp.b;
        return soPhuc;
    }

    public SoPhuc tru(SoPhuc sp) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.a = this.a - sp.a;
        soPhuc.b = this.b - sp.b;
        return soPhuc;
    }

    public SoPhuc nhan(SoPhuc sp) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.a = this.a * sp.a - this.b * sp.b;
        soPhuc.b = this.a * sp.b + this.b * sp.a;
        return soPhuc;
    }

    public SoPhuc chia(SoPhuc sp) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.a = (float) ((this.a * sp.a + this.b * sp.b) / (Math.pow(this.a, 2) + Math.pow(this.b, 2)));
        soPhuc.b = (float) ((this.a * sp.b - this.b * sp.a) / (Math.pow(this.a, 2) + Math.pow(this.b, 2)));
        return soPhuc;
    }

    public SoPhuc nghichDao(SoPhuc sp) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.a = (float) (sp.a / (Math.pow(this.a, 2) + Math.pow(this.b, 2)));
        soPhuc.b = (float) (-sp.b / (Math.pow(this.a, 2) + Math.pow(this.b, 2)));
        return soPhuc;
    }

    public boolean bangNhau(SoPhuc sp) {
        return this.a == sp.a && this.b == sp.b;
    }

    public float modul(SoPhuc sp) {
        return (float) Math.sqrt(Math.pow(sp.a, 2) + Math.pow(sp.b, 2));
    }

    public boolean lonHon(SoPhuc sp) {
        return modul(this) > modul(sp);
    }

    public boolean nhoHon(SoPhuc sp) {
        return modul(this) < modul(sp);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        this.a = sc.nextFloat();
        this.b = sc.nextFloat();
    }

    public void in() {
        System.out.println(this.a + " + j" + this.b);
    }

}

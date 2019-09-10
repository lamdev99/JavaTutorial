package baithaysonpart2;

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
    public SoPhuc cong(SoPhuc sp){
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.a = this.a + sp.a;
        soPhuc.b = this.b + sp.b;
        return soPhuc;
    }
    public SoPhuc tru(SoPhuc sp){
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.a = this.a - sp.a;
        soPhuc.b = this.b - sp.b;
        return soPhuc;
    }

}

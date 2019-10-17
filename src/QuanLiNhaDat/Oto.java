package QuanLiNhaDat;

public class Oto extends PTGT implements TinhGia{
    private String kieuDc;
    private int soCn;
    public boolean isOto(){
        return true;
    }
    @Override
    public int getGia(){
        if(this.getMau().equals("Do")){
            return this.getGia()/100*110;
        }
        return this.getGia();
    }
    public Oto(String soKhungXe, int nam, int gia, String hangSX, String mau, String kieuDc, int soCn) {
        super(soKhungXe, nam, gia, hangSX, mau);
        this.kieuDc = kieuDc;
        this.soCn = soCn;
    }

    @Override
    public String toString() {
        return "Oto{" +
                super.toString()+
                "kieuDc='" + kieuDc + '\'' +
                ", soCn=" + soCn +
                '}';
    }
}

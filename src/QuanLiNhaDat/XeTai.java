package QuanLiNhaDat;

public class XeTai extends  PTGT implements TinhGia{
    private int trongtai;
    public boolean isOto(){
        return false;
    }
    @Override
    public int getGia(){
        if(this.getMau().equals("Trang")){
            return this.getGia()/100*90;
        }
        return this.getGia();
    }
    public XeTai(String soKhungXe, int nam, int gia, String hangSX, String mau, int trongtai) {
        super(soKhungXe, nam, gia, hangSX, mau);
        this.trongtai = trongtai;
    }

    @Override
    public String toString() {
        return "XeTai{" +
                super.toString()+
                "trongtai=" + trongtai +
                '}';
    }
}

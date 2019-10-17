package QuanLiNhaDat;

public class PTGT {
    private int nam,gia;
    private String soKhungXe,hangSX,mau;
    public boolean isOto(){
      return true;
    };
    public PTGT(String soKhungXe, int nam, int gia, String hangSX, String mau) {
        this.soKhungXe = soKhungXe;
        this.nam = nam;
        this.gia = gia;
        this.hangSX = hangSX;
        this.mau = mau;
    }

    public PTGT() {
    }

    public String getSoKhungXe() {
        return soKhungXe;
    }

    public void setSoKhungXe(String soKhungXe) {
        this.soKhungXe = soKhungXe;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    @Override
    public String toString() {
        return "" +
                "soKhungXe=" + soKhungXe +
                ", nam=" + nam +
                ", gia=" + gia +
                ", hangSX='" + hangSX + '\'' +
                ", mau='" + mau + '\''
                ;
    }
}

package javaRegex;

public class IntIPhoneNumber extends PhoneNumber {
    private  int maqg;
    boolean isPhoneNumber;

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "maqg=" + maqg +
                "ma vung= "+getMavung()+
                "sdt= "+getSdt()+
                '}';
    }

    public IntIPhoneNumber(int maqg, int mavung, int sdt) {
        super(mavung, sdt);
        this.maqg = maqg;
        isPhoneNumber = false;
    }
    public boolean getIs(){
        return isPhoneNumber;
    }
    public IntIPhoneNumber(int maqg) {
        this.maqg = maqg;
    }

    public int getMaqg() {
        return maqg;
    }

    public void setMaqg(int maqg) {
        this.maqg = maqg;
    }
}

package javaRegex;

public class PhoneNumber {
    private int mavung,sdt;
    boolean isPhoneNumber;
    public PhoneNumber(int mavung, int sdt) {
        isPhoneNumber = true;
        this.mavung = mavung;
        this.sdt = sdt;
    }
    public boolean getIs(){
        return isPhoneNumber;
    }
    public PhoneNumber() {
    }

    public int getMavung() {
        return mavung;
    }

    public void setMavung(int mavung) {
        this.mavung = mavung;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "mavung=" + mavung +
                ", sdt=" + sdt +
                ", isPhoneNumber=" + isPhoneNumber +
                '}';
    }
}

package LTHDT;

import java.io.Serializable;

public class Sach implements Serializable {
    //mã sách, Tên sách, Tác giả, Chuyên ngành, Năm xuất bản, Số lượng
    private int idSach;
    private static int idSachAuto = 10000;
    private String nameBook,author,major,year,quantity;

    public Sach(String nameBook, String author, String major, String year, String quantity) {
        this.idSach = idSachAuto++;
        this.nameBook = nameBook;
        this.author = author;
        this.major = major;
        this.year = year;
        this.quantity = quantity;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "idSach=" + idSach +
                ", nameBook='" + nameBook + '\'' +
                ", author='" + author + '\'' +
                ", major='" + major + '\'' +
                ", year='" + year + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

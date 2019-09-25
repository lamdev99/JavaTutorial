package TestCuoiKi;

import java.io.Serializable;
class Sach implements Serializable {//(mã sách, Tên sách, Tác giả, Chuyên ngành, Năm xuất bản,Số lượng)
    private int idBook,year,quantity;
    private String nameBook,authorName,object;
    private static int idAUTO_INCREAMENT = 10000;

    @Override
    public String toString() {
        return "Sach{" +
                "idBook=" + idBook +
                ", year=" + year +
                ", quantity=" + quantity +
                ", nameBook='" + nameBook + '\'' +
                ", authorName='" + authorName + '\'' +
                ", object='" + object + '\'' +
                '}';
    }

    public Sach(){
        this.idBook = idAUTO_INCREAMENT++;
    }
    public Sach( int year, int quantity, String nameBook, String authorName, String object) {
        this.idBook = idAUTO_INCREAMENT++;
        this.year = year;
        this.quantity = quantity;
        this.nameBook = nameBook;
        this.authorName = authorName;
        this.object = object;
    }
    public int getIdBook(){
        return this.idBook;
    }
    public void setIdBook(int idBook){
        this.idBook = idBook;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}

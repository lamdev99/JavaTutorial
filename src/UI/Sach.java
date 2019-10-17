package UI;

public class Sach {
    private int id;
    private String name,author,year;
    private static int idT = 10000;

    public Sach(String name, String author, String year) {
        this.id = idT++;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }
}

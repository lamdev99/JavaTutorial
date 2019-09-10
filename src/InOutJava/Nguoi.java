package InOutJava;

public class Nguoi {
    private String name;
    private int age;

    public Nguoi() {
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Nguoi(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

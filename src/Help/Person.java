package Help;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void display(){
        System.out.println("Name: "+this.name);
    }
    public boolean hasSameName(Person p){
        return this.name.equals(p.getName());
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                '}';
    }
}


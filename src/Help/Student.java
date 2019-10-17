package Help;

public class Student extends Person {
    private int studentID;

    public Student() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Student(String name, int studentID) {
        super(name);
        this.studentID = studentID;
    }
    public void display(){
        System.out.println(this.getName()+" "+this.studentID);
    }
    public boolean isEqual(Student s){
        if(this.hasSameName(s)&&this.getStudentID()==s.getStudentID())  return true;
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString()+
                "studentID=" + studentID +
                '}';
    }
}

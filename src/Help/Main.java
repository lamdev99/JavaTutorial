package Help;


import java.util.Scanner;

public class Main {
    static Person[] p = new Person[10];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        init();
        ktraSV();
        ktraSVNV();
    }
    public static void init(){
        for(int i = 0; i < 10;  i++){
            System.out.println("1.Student\t" +
                    "2.Employee");
            int choose;
            choose = sc.nextInt();
            sc.nextLine();
            if(choose==1){
                String name;int id;
                System.out.print("Name: "); name = sc.nextLine();

                System.out.print("ID: ");id = sc.nextInt();
                p[i] = new Student(name,id);
            }
            else{
                String name;double salary;
                System.out.print("Name: "); name = sc.nextLine();

                System.out.print("Salary: ");salary = sc.nextDouble();
                p[i]=new Employee(name,salary);
            }
        }
    }
    public static void ktraSV(){
        int[] d = new int[10];
        System.out.println("DS sinh vien trung ten");
        int count = 0;
        for(int i = 0; i < 10; i++){
            if(p[i] instanceof Student){
                for(int j = i+1; j < 10; j++){
                    if(p[j] instanceof Student){
                        Student a = (Student) p[i];
                        Student b = (Student) p[j];
                        if(a.isEqual(b))    count++;
                        //System.out.println(1);
                    }
                }
                if(count>0&&d[i]==0){
                    System.out.println(p[i]);
                    d[i] = 1;
                }
                count = 0;
            }
        }
    }
    public static void ktraSVNV(){
        int[] d = new int[10];
        System.out.println("SV trung ten nhan vien");
        int count = 0;
        for(int i = 0; i < 10; i++){
            if(p[i] instanceof Student){
                for(int j = i+1; j < 10; j++){
                    if(p[j] instanceof Employee){
                        if(p[i].hasSameName(p[j])){
                            count++;
                        }
                    }
                }
                if(count>0&&d[i]==0) {System.out.println(p[i]); d[i]=1;}
            }
        }
    }
}

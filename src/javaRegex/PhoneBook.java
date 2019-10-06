package javaRegex;

import java.util.*;

public class PhoneBook {
    static  Set<PhoneNumber> myList = new HashSet<>();
    static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choose = -1;
        while(choose!=0){
            System.out.println("Nhap vao lua chon\t" +
                    "1.Them 1 so dien thoai\t" +
                    "2.Tim sdt theo ma vung\t" +
                    "3.Liet ke so dien thoai\t" +
                    "4.Tinh tong so dien thoai tung vung\t" +
                    "0.Thoat");
            choose = sc.nextInt();
            switch (choose){
                case 1:{
                    addNum();
                    break;
                }
                case 2:{
                    find();
                    break;
                }
                case 3:{
                    display();
                    break;
                }
                case 4:{

                }
                default:break;
            }
        }

    }

    public static void addNum() {
        while (true) {
            System.out.println("Nhap vao loai dien thoai\t" +
                    "1.Noi vung\t" +
                    "2.Ngoai nuoc");
            int c = sc.nextInt();
            sc.nextLine();
            List<String> listTest = new ArrayList<>();
            if(c == 1){
                String s = sc.nextLine();
                StringTokenizer st = new StringTokenizer(s,"-");
                while(st.hasMoreTokens()) listTest.add(st.nextToken());
                if(listTest.size()==2){
                    if(listTest.get(0).charAt(0)!='0') break;
                    else if(testMv(listTest.get(0))&&regexTest(listTest.get(1))){
                        PhoneNumber pn = new PhoneNumber(Integer.parseInt(listTest.get(0)),Integer.parseInt(listTest.get(1)));
                        myList.add(pn);
                        break;
                    }
                }
            }
            else if(c==2){
                String s = sc.nextLine();
                StringTokenizer st = new StringTokenizer(s,"-");
                while(st.hasMoreTokens()) listTest.add(st.nextToken());
                if(listTest.size()==3){
                    if(listTest.get(0).charAt(0)=='0')  break;
                    else if(regexTest(listTest.get(0))&&regexTest(listTest.get(1))&&
                    regexTest(listTest.get(2))){
                        IntIPhoneNumber ipn = new IntIPhoneNumber(Integer.parseInt(listTest.get(0)),Integer.parseInt(listTest.get(1)),
                                Integer.parseInt(listTest.get(2)));
                        myList.add(ipn);
                        break;
                    }
                }
            }
        }
    }
    public static boolean regexTest(String s){
        return s.matches("\\d+");
    }
    public static boolean testMv(String s){
        return s.matches("^0\\d{3,4}$");
    }
    public static void find(){
        System.out.println("Nhap vao ma vung");
        String s = sc.nextLine();
        if(s.charAt(0)=='0'){
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(0);

        }
    }
    public static void findInArray(String s,boolean isPN){
            for(PhoneNumber pn: myList){
                if(pn.getIs()==isPN){
                    if(pn.getMavung()==Integer.parseInt(s)){
                        System.out.println(pn);
                    }
                }
            }
    }
    public static void display(){
        int choose = -1;
        boolean cont = true;
        while (choose!=0) {
            System.out.println("1.In ra sdt trong nuoc\t" +
                    "2.In ra sdt ngoai nuoc\t" +
                    "3.In tat ca\t" +
                    "0.Out");
            choose = sc.nextInt();
            switch (choose){
                case 1:{
                    for(PhoneNumber pn: myList){
                        if(pn.getIs()){
                            System.out.println(pn);
                        }
                    }
                    break;
                }
                case 2:{
                    for(PhoneNumber pn: myList){
                        if(!pn.getIs()){
                            System.out.println(pn);
                        }
                    }
                    break;
                }
                case 3:{
                    for(PhoneNumber pn: myList){
                        System.out.println(pn);
                    }
                }
            }

        }
    }
}

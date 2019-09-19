package QuanLiNhaDat;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

    class SinhVien {
        String id, name, className, grade;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getId() {
            return id;
        }

        public String getClassName() {
            return className;
        }

        public String getName() {
            return name;
        }

        public String getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return "Sinh vien: " + name + "\n" +
                    "ID: " + id + "\n" +
                    "Class Name: " + className + "\n" +
                    "Grade: " + grade + "\n";
        }

        public SinhVien() {
        }
    }

    class CompareSV implements Comparator<SinhVien> {
        @Override
        public int compare(SinhVien sv1, SinhVien sv2) {
            return sv1.name.compareToIgnoreCase(sv2.name);
        }
    }

    public class bac {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            List<SinhVien> listSinhVien = new ArrayList<>();
            int n = in.nextInt();
            in.nextLine();
            SinhVien[] SinhViens = new SinhVien[n];
            for (int i = 0; i < n; i++) {
                SinhViens[i] = new SinhVien();
                SinhViens[i].setName(in.nextLine());
                SinhViens[i].setId(in.nextLine());
                SinhViens[i].setClassName(in.nextLine());
                SinhViens[i].setGrade(in.nextLine());
                listSinhVien.add(SinhViens[i]);
            }
            sortSinhVien(listSinhVien);
            for (SinhVien sv : listSinhVien) {
                System.out.println(sv);
            }
        }

        public static List<SinhVien> sortSinhVien(List<SinhVien> sinhViens) {
            Collections.sort(sinhViens, new CompareSV());
            return sinhViens;
        }
    }

import java.io.*;
import java.util.*;

public class StudentManager {
    private Check check;
    private ArrayList<Student> students;
    private String path;

    public StudentManager() {
        check = new Check();
        path = "D:\\thimodule2\\src\\student.csv";
        students = new ArrayList<>();

    }
    public ArrayList<Student> getStudents(){
        return students;
    }

    public void add(Scanner scanner) {
        String id = check.checkStringId(scanner, "Id");
        String name = check.checkString(scanner, "Name");
        int age = check.checkInt(scanner, "Age");
        String gender = check.checkString(scanner, "Gender");
        String address = check.checkStringId(scanner, "Address");
        double avgScore = check.checkDouble(scanner, "Average score");
        Student student = new Student(id, name, age, gender, address, avgScore);
        students.add(student);
    }

    public void upgrade(Scanner scanner) {
        System.out.println("Enter id of student: ");
        String idCheck = scanner.nextLine();
        if (!idCheck.equals("")) {
            boolean flag = true;
            for (Student student : students) {
                if (student.getId().equals(idCheck)) {
                    String id = check.checkStringId(scanner, "ID");
                    student.setId(id);
                    String name = check.checkString(scanner, "Name");
                    student.setName(name);
                    int age = check.checkInt(scanner, "Age");
                    student.setAge(age);
                    String gender = check.checkString(scanner, "Gender");
                    student.setGender(gender);
                    String address = check.checkString(scanner, "address");
                    student.setAddress(address);
                    double avgScore = check.checkDouble(scanner, "Average score");
                    student.setAvgScore(avgScore);
                    System.out.println("Upgrade successfully.");
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Couldn't find any students with this id.");
            }
        }

    }


    public void delete(Scanner scanner) {
        System.out.println("Enter id of student: ");
        String idCheck = scanner.nextLine();
        if (!idCheck.equals("")) {
            boolean flag = true;
            for (Student student : students) {
                if (student.getId().equals(idCheck)) {
                    flag = false;
                    String confirm = scanner.nextLine();
                    if (confirm.equals("Y")) {
                        students.remove(student);
                        System.out.println("Delete successfully");
                    }
                }
            }
            if (flag) {
                System.out.println("Couldn't find any students with this id.");
            }
        }
    }

    public void sortAsc(Scanner scanner) {

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getAvgScore() - o2.getAvgScore());
            }
        });
    }

    public void sortDesc(Scanner scanner) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o2.getAvgScore() - o1.getAvgScore());
            }
        });
    }


    public void display(Scanner scanner) {
        if (students.size() == 0) {
            System.out.println("There are currently no students in the list");
        } else {
            for (Student student : students) {
                String confirm = scanner.nextLine();
                if (confirm.equals("")) {
                    System.out.println(student);
                }
            }
        }
    }

    public void readFile() {
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                String code = arr[0];
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                double GPA = Double.parseDouble((arr[5]));
                Student student = new Student(code, name, age, gender, address, GPA);
                arrayList.add(student);
                str = bufferedReader.readLine();
                students = arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void writeFile(ArrayList<Student> list) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : students) {
                bufferedWriter.write(student.displayCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



import java.util.Scanner;

public class StudentSystem {
    private StudentManager studentManager;
    private Scanner scanner;

    public StudentSystem() {
        studentManager = new StudentManager();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        do {
            System.out.println("Student Management Program");
            System.out.println("1.Display all student");
            System.out.println("2.Add student");
            System.out.println("3.Upgrade student");
            System.out.println("4.Delete student");
            System.out.println("5.Sort");
            System.out.println("6.Read file");
            System.out.println("7.Write file");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManager.display(scanner);
                    break;
                case 2:
                    studentManager.add(scanner);
                    break;
                case 3:
                    studentManager.upgrade(scanner);
                    break;
                case 4:
                    studentManager.delete(scanner);
                    break;
                case 5:
                    menuSort();
                    break;
                case 6:
                    studentManager.readFile();
                    break;
                case 7:
                    studentManager.writeFile(studentManager.getStudents());
                    break;
                case 0:
                    System.exit(0);

            }
        } while (true);
    }

    public void menuSort() {
        do {
            System.out.println("Sort students by average score");
            System.out.println("1.Sort by ascending score");
            System.out.println("2.Sort by points descending");
            System.out.println("3.Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 3){
                break;
            }
           switch (choice){
               case 1:
                   studentManager.sortAsc(scanner);
                   break;
               case 2:
                   studentManager.sortDesc(scanner);
                   break;
           }

        } while (true);
    }
}

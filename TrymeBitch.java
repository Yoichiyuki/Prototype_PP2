import java.util.*;

class TrymeBitch{
    private Scanner key = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<ClassSession> sessions = new ArrayList<>();

    private AuthService authServ = new AuthService();
    private AttendanceService attendServ = new AttendanceService();

    public static void main(String[] args) {
        TrymeBitch gok = new TrymeBitch();
        gok.start();
    }
        
        public void start(){
            while (true) { 
                System.out.println("\n=== Attendance System ===");
                System.out.println("1. Sign Up");
                System.out.println("2. Log In");
                System.out.println("3. Exit");

                int pick = key.nextInt();
                key.nextLine();

                switch (pick) {
                    case 1 -> signUp();
                    case 2 -> logIn();
                    case 3 -> {
                        System.out.print("Bye bitch!");
                        return;
                    }
                }
                
            }
        }

        private void signUp(){
            System.out.println("Enter your name Bitch: ");
            System.out.print("Enter name: ");
            String name = key.nextLine();

            System.out.print("Role (student/teacher): ");
            String role = key.nextLine();

            User user;
            if (role.equalsIgnoreCase("student")) {
                user = new Student(users.size() + 1, name);
            } else {
                user = new Teacher(users.size() + 1, name);
            }

            users.add(user);
            System.out.println("Account created!");
        }

        

        private void logIn() {
            System.out.print("Enter name: ");
            String name = key.nextLine();

            for (User user : users) {
                if (user.name.equalsIgnoreCase(name)) {
                    System.out.println("Login successful!");

                    if (user instanceof Teacher) {
                        teacherMenu((Teacher) user);
                    } else if (user instanceof Student) {
                        studentMenu((Student) user);
                    }
                    return;
                }
            }

            System.out.println("User not found.");
        }

        private void teacherMenu(Teacher teacher) {
            while (true) {
                System.out.println("\n--- Teacher Menu ---");
                System.out.println("1. Create Class");
                System.out.println("2. View Classes");
                System.out.println("3. Logout");

                int choice = key.nextInt();
                key.nextLine();

                switch (choice) {
                    case 1 -> createClass();
                    case 2 -> viewClasses();
                    case 3 -> { return; }
                }
            }
        }

        private void studentMenu(Student student) {
            while (true) {
                System.out.println("\n--- Student Menu ---");
                System.out.println("1. Mark Attendance");
                System.out.println("2. Logout");

                int choice = key.nextInt();
                key.nextLine();

                switch (choice) {
                    case 1 -> markAttendance(student);
                    case 2 -> { return; }
                }
            }
        }

        private void createClass() {
            System.out.print("Enter class name: ");
            String name = key.nextLine();

            ClassSession session = new ClassSession(name);
            sessions.add(session);

            System.out.println("Class created!");

        }

        private void viewClasses() {
            if (sessions.isEmpty()) {
                System.out.println("No classes available.");
                return;
            }

            System.out.println("\n--- Class List ---");
            for (int i = 0; i < sessions.size(); i++) {
                System.out.println((i + 1) + ". " + sessions.get(i));
            }
        }

        private void markAttendance(Student student) {
            if (sessions.isEmpty()) {
                System.out.println("No classes available.");
                return;
            }

            System.out.println("Select class:");
            for (int i = 0; i < sessions.size(); i++) {
                System.out.println((i + 1) + ". " + sessions.get(i));
            }

            int choice = key.nextInt();
            key.nextLine();

            ClassSession session = sessions.get(choice - 1);

            AttendanceRecord record = new AttendanceRecord(
                student.id,
                "TODAY",
                "Present"
            );

            session.recordAttendance(record);

            System.out.println("Attendance recorded!");
        }
    
    
}

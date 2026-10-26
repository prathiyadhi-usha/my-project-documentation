import java.util.ArrayList;
import java.util.Scanner;

class Participant {
    int id;
    String name;
    String program;
    boolean attendance;

    Participant(int id, String name, String program) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.attendance = false;
    }
}

public class TrainingSystem {

    static ArrayList<Participant> participants =
            new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Find participant using ID
    static Participant findParticipant(int id) {
        for (Participant p : participants) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    // 1. Register participant
    static void addParticipant() {
        System.out.print("Enter Participant ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findParticipant(id) != null) {
            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Enter Participant Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Training Program: ");
        String program = sc.nextLine();

        participants.add(
                new Participant(id, name, program));

        System.out.println(
                "Participant Registered Successfully!");
    }

    // 2. View all participants
    static void viewParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants found.");
            return;
        }

        System.out.println("\n--- Participant Details ---");

        for (Participant p : participants) {
            System.out.println("ID: " + p.id);
            System.out.println("Name: " + p.name);
            System.out.println("Program: " + p.program);
            System.out.println("Attendance: "
                    + (p.attendance ? "Present" : "Absent"));
            System.out.println("--------------------------");
        }
    }

    // 3. Update participant details
    static void updateParticipant() {
        System.out.print("Enter Participant ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Participant p = findParticipant(id);

        if (p == null) {
            System.out.println("Participant Not Found!");
            return;
        }

        System.out.print("Enter New Name: ");
        p.name = sc.nextLine();

        System.out.print("Enter New Training Program: ");
        p.program = sc.nextLine();

        System.out.println("Details Updated Successfully!");
    }

    // 4. Delete participant
    static void deleteParticipant() {
        System.out.print("Enter Participant ID to delete: ");
        int id = sc.nextInt();

        Participant p = findParticipant(id);

        if (p != null) {
            participants.remove(p);
            System.out.println("Participant Deleted Successfully!");
        } else {
            System.out.println("Participant Not Found!");
        }
    }

    // 5. Mark attendance
    static void markAttendance() {
        System.out.print("Enter Participant ID: ");
        int id = sc.nextInt();

        Participant p = findParticipant(id);

        if (p != null) {
            p.attendance = true;
            System.out.println("Attendance Marked Successfully!");
        } else {
            System.out.println("Participant Not Found!");
        }
    }

    // 6. Main menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println(" TRAINING PROGRAM MANAGEMENT");
            System.out.println("================================");
            System.out.println("1. Register Participant");
            System.out.println("2. View Participants");
            System.out.println("3. Update Participant");
            System.out.println("4. Delete Participant");
            System.out.println("5. Mark Attendance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addParticipant();
                    break;

                case 2:
                    viewParticipants();
                    break;

                case 3:
                    updateParticipant();
                    break;

                case 4:
                    deleteParticipant();
                    break;

                case 5:
                    markAttendance();
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
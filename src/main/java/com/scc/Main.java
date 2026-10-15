package com.scc;

import com.scc.dao.UserDao;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final UserDao userDao = new UserDao();

    public static void main(String[] args) {

        System.out.println("\n===========================================");
        System.out.println(" MEDICINE DISTRIBUTION AND EXPIRATION TRACKING SYSTEM");
        System.out.println("===========================================");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        String choice = sc.nextLine();

        switch (choice) {

            case "1":
                System.out.println("Login feature is not yet available.");
                break;

            case "2":
                System.out.print("Enter new Username: ");
                String user = sc.nextLine();

                System.out.print("Enter password: ");
                String pass = sc.nextLine();

                System.out.print(
                        "Select Role [1] ADMINISTRATOR | [2] PHARMACIST: "
                );

                int roleChoice;

                try {
                    roleChoice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid role selection!");
                    return;
                }

                String role;

                switch (roleChoice) {
                    case 1:
                        role = "ADMINISTRATOR";
                        break;

                    case 2:
                        role = "PHARMACIST";
                        break;

                    default:
                        role = null;
                }

                if (role != null) {
                    boolean registered =
                            userDao.registerUser(user, pass, role);

                    if (registered) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed!");
                    }

                } else {
                    System.out.println("Invalid role selection!");
                }

                break;

            case "3":
                System.out.println("Thank you for using the system!");
                break;

            default:
                System.out.println("Invalid menu choice!");
        }

        sc.close();
    }
}

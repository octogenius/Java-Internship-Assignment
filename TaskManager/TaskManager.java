import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) throws IOException {

        for (String input: args) {

            if (input.contains("-createUser")) {
                createUser();
            }

            else if (input.contains("-showAllUsers")) {
                showAllUsers();
            }

            else if (input.contains("-addTask")) {
                addTask();
            }

            else if (input.contains("-showTasks")) {
                showTasks();
            }

            else {
                System.out.print("Unrecognized command.");
            }

        }

    }

    public static void createUser() {

        Scanner input = new Scanner(System.in);

        String firstName, lastName, username;

        System.out.print("First name: ");
        firstName = input.nextLine();

        System.out.print("Last name: ");
        lastName = input.nextLine();

        System.out.print("Username: ");
        username = input.nextLine();

        File f = new File("C:\\Java-Internship-Assignment\\TaskManager\\users\\" + username);

        if (f.mkdir()) {
            System.out.println("User " + username + " successfully created.");
        } else {
            System.out.println("Username already registered.");
        }

        try {
            File file = new File("C:\\Java-Internship-Assignment\\TaskManager\\users\\" + username + "\\info.txt");
            File tasksFile = new File("C:\\Java-Internship-Assignment\\TaskManager\\users\\" + username + "\\tasks.txt");

            if (file.createNewFile()) {
                System.out.print("");
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(file);

            writer.write(firstName + " " + lastName);
            writer.close();

            FileWriter writer2 = new FileWriter(tasksFile);

            writer.write("");
            writer.close();

        } catch (Exception ignored) {}

    }

    public static void showAllUsers() {

        File directoryPath = new File("C:\\Java-Internship-Assignment\\Task Manager\\users");

        String[] contents = directoryPath.list();

        for (int i = 0; i < contents.length; i++) {
            System.out.print(contents[i]);
        }

    }

    public static void addTask() {

        try {

            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);

            System.out.print("Assignee's username: ");
            String username = input.nextLine();

            System.out.println("Task title: ");
            String taskTitle = input2.nextLine();

            String filename= "C:\\Java-Internship-Assignment\\Task Manager\\users\\" + username + "\\tasks.txt";

            FileWriter fw = new FileWriter(filename,true);

            fw.write(taskTitle + "\n");
            fw.close();

        } catch(Exception ignored) {}

    }

    public static void showTasks() {

        Scanner input = new Scanner(System.in);

        String username = input.nextLine();
        System.out.print("Input username: ");

        try {
            File myObj = new File("C:\\Java-Internship-Assignment\\Task Manager\\users\\" + username + "\\tasks.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
        } catch (Exception e) {

        }


    }

}
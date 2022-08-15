import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<User> users = new ArrayList<>();

        Scanner scanner = new Scanner(new File("C:\\Users\\Three\\IdeaProjects\\HomeWork\\src\\users.csv"));
        while (scanner.hasNextLine() == true) {
            String line = scanner.nextLine();
            String[] strings = line.split(",");
            String login = strings[0];
            String name = strings[1];
            int age = Integer.parseInt(strings[2]);
            int bonus = Integer.parseInt(strings[3]);
            User user = new User(login, name, age, bonus);
            users.add(user);
        }
        System.out.println(users);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String json = new Gson().toJson(user);
            System.out.println(json);


        }



    }
}

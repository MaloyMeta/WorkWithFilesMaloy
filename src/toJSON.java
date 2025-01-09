import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class toJSON {

    static class User{   //Створення класу User

        private String name;
        private int age;

        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }

        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
    }

    public static void convertToJSON(String inputFileName,String outputFileName){
        List<User> users = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(inputFileName))) { // Зчитування файлу рядками
            String line = bf.readLine(); // Пропуск першого рядка з заголовком

            while ((line = bf.readLine()) != null) {
                String[] parts = line.split(" "); //Розділення за пробілами

                if (parts.length == 2) { // Якщо 2 параметри: записуємо.
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    users.add(new User(name, age));
                }
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            try (FileWriter writer = new FileWriter(outputFileName)) {
                gson.toJson(users, writer);
            }

            System.out.println("Файл успішно записаний: " + outputFileName);
        }catch (IOException e){
            System.err.println("Error " + e.getMessage());
        }
        }
    }


import java.io.*;
import java.util.regex.*;

public class PhoneNumberValidator {

    public static void printValidNumbers(String fileName) {

        String regex = "^(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})$"; //Шаблон для номерів
        Pattern patern = Pattern.compile(regex);

        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) { //Читання файлу

            System.out.println("Trying to read file: " + fileName);
            String line;

            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    Matcher matcher = patern.matcher(line); // перевірка на схожість з патерном
                    if (matcher.matches()) {
                        System.out.println(line);
                    }
                }
            }
        }catch (IOException e){
            System.err.println("Something wrong, but IDK " + e.getMessage());
        }
    }
}

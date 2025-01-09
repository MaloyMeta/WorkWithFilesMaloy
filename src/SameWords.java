import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SameWords {
    public static void CountWordsFreq(String fileName){
        Map<String, Integer> wordCounter = new HashMap<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){ //зчитування файлу
            String line;
            while ((line = bf.readLine()) != null){
                String[] words = line.split("\\s+"); //Розділення за пробілом

            for (String word:words){
                wordCounter.put(word,wordCounter.getOrDefault(word,0)+ 1); //лічильник
            }
            }
            List<Map.Entry<String,Integer>> sortedMap = new ArrayList<>(wordCounter.entrySet()); // Перевод до List для сортування
            sortedMap.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue()); //Сортування за спаданням

            for (Map.Entry<String,Integer> entry: sortedMap){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }catch (IOException e){
            System.err.println("Виникла помилка: " + e.getMessage());
        }
    }
}

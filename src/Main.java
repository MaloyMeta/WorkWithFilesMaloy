public class Main{
    public static void main(String[] args) {
        String[] files = {"src/file.txt","src/file2.txt","src/file3.txt"};
        String outputFile = "src/outFile.txt";
        PhoneNumberValidator.printValidNumbers(files[0]); //Завдання 1
        toJSON.convertToJSON(files[1],outputFile); //Завдання 2
        SameWords.CountWordsFreq(files[2]); //Завдання 3
    }
}
import java.io.*;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        //Объединение файлов в один новый
        OutputStream finalFile;
        FileInputStream fileText;

        try {
            // Первоначально я делал через readAllBytes, но потом дошло, что он копирует до первого пробела
            finalFile = new FileOutputStream("finalFile.txt");
            fileText = new FileInputStream("file1.txt");
            finalFile.write(fileText.readAllBytes());
            fileText = new FileInputStream("file2.txt");
            // Потом попробовал через сканнер и сработало с учетом пробелов.
            Scanner scanner = new Scanner(fileText);
            String s = scanner.nextLine();
            finalFile.write(s.getBytes());
            finalFile.close();

        } catch (IOException e){ }


        try {
            fileText = new FileInputStream("finalFile.txt");
            System.out.println(wordSearch(fileText));
            fileText.close();
        } catch (IOException e){ }


    }

    //поиск слова в файле
    public static boolean wordSearch(FileInputStream f) {

                Scanner scanner = new Scanner(f);
                String s = scanner.nextLine();
                scanner = new Scanner(System.in);
                System.out.println(s);
                String word = scanner.nextLine();
                System.out.println(word);
                scanner.close();
                return s.contains(word);
    }
}

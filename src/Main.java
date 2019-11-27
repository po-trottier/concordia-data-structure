import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
  static final String file1 = "ar_test_file1.txt";
  static final String file2 = "ar_test_file2.txt";
  static final String file3 = "ar_test_file3.txt";

  public static void main(String[] args) {
    String[] file1Content = readFile(file1);
    String[] file2Content = readFile(file2);
    String[] file3Content = readFile(file3);
    if (file1Content.length == 0 || file2Content.length == 0 || file3Content.length == 0) {
      System.out.println("Something went wrong while reading the files");
      return;
    }

     SmartAR registration1 = new SmartAR(file1Content.length);
     SmartAR registration2 = new SmartAR(file2Content.length);
     SmartAR registration3 = new SmartAR(file3Content.length);
  }

  static String[] readFile(String file) {
    var path = Paths.get("TestFiles", file);
    try {
      return Files.readString(path).split("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new String[0];
  }
}

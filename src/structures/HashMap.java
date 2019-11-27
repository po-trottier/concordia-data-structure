package structures;

// LinkedHashMap Documentation:
// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
import java.util.LinkedHashMap;
import javafx.util.Pair;

public class HashMap {
  private LinkedHashMap<String, Pair[]> internalMap;

  public HashMap(int size) {
    // Initialize the LinkedHashMap with the right size and a Load Factor of 1
    this.internalMap = new LinkedHashMap<>(size, 1);
  }

  public void migrate(Sequence sequence) {
    // Migrate all the data from the sequence to the map
    String[] keys = sequence.allKeys();
    for (String key : keys) {
      this.internalMap.put(key, sequence.get(key));
    }
  }

  public boolean isEmpty() {
    return this.internalMap.isEmpty();
  }
}

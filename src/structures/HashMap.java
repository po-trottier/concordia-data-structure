package structures;

// LinkedHashMap Documentation:
// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
import java.util.LinkedHashMap;

public class HashMap {
  private LinkedHashMap<String, Object[]> internalMap;

  public HashMap(int size) {
    this.internalMap = new LinkedHashMap<>(size);
  }

  public void migrate(Sequence sequence) {
    // TODO Iterate through the sequence and add every item to the map
  }

  public boolean isEmpty() {
    return this.internalMap.isEmpty();
  }
}

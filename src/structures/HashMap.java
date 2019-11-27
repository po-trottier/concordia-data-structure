package structures;

// LinkedHashMap Documentation:
// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;
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

  public Pair[] get(String key) {
    return internalMap.get(key);
  }

  public void add(String key, Pair<String, Object> value) {
    if (internalMap.get(key) != null) {
      ArrayList<Pair> data = new ArrayList<>(Arrays.asList(internalMap.get(key)));
      data.add(value);
      internalMap.remove(key);
      internalMap.put(key, data.toArray(new Pair[0]));
    } else {
      internalMap.put(key, new Pair[] { value });
    }
  }

  public void remove(String key) {

  }

  public String[] allKeys() {

    return new String[0];
  }

  public String nextKey(String key) {

    return key;
  }

  public String prevKey(String key) {

    return key;
  }

  public boolean isEmpty() {
    return this.internalMap.isEmpty();
  }
}

package structures;

// LinkedHashMap Documentation:
// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Pair;

class HashMap {
  private LinkedHashMap<String, Pair[]> internalMap;

  HashMap(int size) {
    // Initialize the LinkedHashMap with the right size
    // and a Load Factor of 1 to minimize collisions
    this.internalMap = new LinkedHashMap<>(size, 1f);
  }

  void migrate(Sequence sequence) {
    // Migrate all the data from the sequence to the map
    String[] keys = sequence.allKeys();
    for (String key : keys) {
      this.internalMap.put(key, sequence.get(key));
    }
  }

  Pair[] get(String key) {
    return this.internalMap.get(key);
  }

  boolean contains(String key) {
    if (this.internalMap.get(key) == null)
      return false;
    var isEmpty = this.internalMap.get(key).length == 0;
    var isHistory = this.internalMap.get(key).length == 1
                 && this.internalMap.get(key)[0].getKey().equals("History");
    return !isEmpty && !isHistory;
  }

  void add(String key, Pair<String, Object> value) {
    if (key == null || key.isEmpty())
      return;
    if (this.internalMap.get(key) != null) {
      ArrayList<Pair> data = new ArrayList<>(Arrays.asList(this.internalMap.get(key)));
      data.add(value);
      this.internalMap.remove(key);
      this.internalMap.put(key, data.toArray(new Pair[0]));
    } else {
      this.internalMap.put(key, new Pair[] { value });
    }
  }

  void remove(String key) {

  }

  Pair[] history(String key) {

    return new Pair[0];
  }

  String[] allKeys() {
    return quickSort(this.internalMap.keySet().toArray(new String[0]));
  }

  String firstKey() {
    return this.internalMap.keySet().toArray(new String[0])[0];
  }

  String nextKey(String key) {
    // This is not optimal but we don't have a choice with hash maps
    var iter = this.internalMap.keySet().iterator();
    // While the iterator has a next
    while (iter.hasNext()) {
      // Look to see if the key matches
      if (iter.next().equals(key))
        // If it does return the next one
        return iter.next();
    }
    return null;
  }

  String prevKey(String key) {
    // This is not optimal but we don't have a choice with hash maps
    var keys = this.internalMap.keySet().toArray(new String[0]);
    // If the array of keys is empty element is the first one then return null
    if (keys.length < 1 || keys[0].equals(key))
      return null;
    // Otherwise iterate until you find the key and return the previous one
    for (int i = 1; i < keys.length; i++) {
      if (keys[i].equals(key))
        return keys[i - 1];
    }
    return null;
  }

  boolean isEmpty() {
    return this.internalMap.isEmpty();
  }

  private String[] quickSort(String[] keys) {
    // TODO Sort the keys
    return keys;
  }
}

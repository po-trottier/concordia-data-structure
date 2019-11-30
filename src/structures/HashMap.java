package structures;

// LinkedHashMap Documentation:
// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

class HashMap {
  private LinkedHashMap<String, SimpleEntry[]> internalMap;

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

  SimpleEntry[] get(String key) {
    // Return the entry for a given key
    return this.internalMap.get(key);
  }

  boolean contains(String key) {
    // If the entry is null then the map doesn't contain the key
    if (this.internalMap.get(key) == null)
      return false;
    var isEmpty = this.internalMap.get(key).length == 0;
    var isHistory = this.internalMap.get(key).length == 1
                 && this.internalMap.get(key)[0].getKey().equals("History");
    // If the entry doesn't have values or only a history then it was removed
    return !isEmpty && !isHistory;
  }

  void add(String key, SimpleEntry<String, Object> value) {
    // Reserve the "History" keyword for the program
    if (value.getKey().equals("History"))
      throw new RuntimeException("\"History\" is a reserved keyword. Please use another name.");
    // If the key is null or empty then it's invalid
    if (key == null || key.isEmpty())
      return;
    // If we're not adding a new entry then append the last one
    if (this.internalMap.get(key) != null) {
      ArrayList<SimpleEntry> data = new ArrayList<>(Arrays.asList(this.internalMap.get(key)));
      data.add(value);
      this.internalMap.remove(key);
      this.internalMap.put(key, data.toArray(new SimpleEntry[0]));
    } else {
      // Simply store the desired data when it's a new entry
      this.internalMap.put(key, new SimpleEntry[] { value });
    }
  }

  void remove(String key) {
    SimpleEntry[] temp = this.internalMap.get(key);
    this.internalMap.remove(key);
    this.internalMap.put(key, new SimpleEntry[]{new SimpleEntry("History", temp)});
  }

  SimpleEntry[] history(String key) {
    // Find the value with the "History" key
    for (SimpleEntry nvp : this.internalMap.get(key)) {
      if (nvp.getKey().equals("History"))
        return ((SimpleEntry[]) nvp.getValue());
    }
    return null;
  }

  String[] allKeys() {
    // Return the list of all sorted keys
    return quickSort(this.internalMap.keySet().toArray(new String[0]));
  }

  String firstKey() {
    // Return the first key in the map
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
    // Set the pivot to be the last element of list
    String pivot = keys[keys.length - 1];
    // Split the elements into left and right groups
    ArrayList<String>[] values = split(keys, pivot);
    // Return the sorted array
    return quickSortRecursive(values[0].toArray(new String[0]), values[1].toArray(new String[0]), pivot);
  }

  private String[] quickSortRecursive(String[] left, String[] right, String pivot) {
    String[] smaller = left;
    String[] larger = right;
    // If we're not at the leaves then sort the sub-tree
    if (left.length > 1) {
      String newPivot = smaller[left.length - 1];
      smaller = Arrays.copyOfRange(smaller, 0, smaller.length - 1);
      ArrayList<String>[] values = split(smaller, newPivot);
      smaller = quickSortRecursive(values[0].toArray(new String[0]), values[1].toArray(new String[0]), newPivot);
    }
    if (right.length > 1) {
      String newPivot = larger[larger.length - 1];
      larger = Arrays.copyOfRange(larger, 0, larger.length - 1);
      ArrayList<String>[] values = split(larger, newPivot);
      larger = quickSortRecursive(values[0].toArray(new String[0]), values[1].toArray(new String[0]), newPivot);
    }
    // Concatenate smaller and larger
    String[] result = new String[smaller.length + larger.length + 1];
    int pos = 0;
    for (String element : smaller) {
      result[pos] = element;
      pos++;
    }
    result[pos] = pivot;
    pos++;
    for (String element : larger) {
      result[pos] = element;
      pos++;
    }
    // Return the merged array
    return result;
  }

  private ArrayList<String>[] split(String[] keys, String pivot) {
    // Elements smaller and larger than the pivot respectively
    ArrayList<String> left = new ArrayList<>();
    ArrayList<String> right = new ArrayList<>();
    // Add the elements to the proper arrays;
    for (int i = 0; i < keys.length; i++) {
      if (i == keys.length - 1)
        break;
      if (compareStrings(keys[i], pivot))
        right.add(keys[i]);
      else
        left.add(keys[i]);
    }
    return new ArrayList[]{left, right};
  }

  private boolean compareStrings(String a, String b) {
    // Returns true if string "a" is 'bigger' than string "b"
    for (int i = 0; i < a.length(); i++) {
      if (i >= b.length())
        return true;
      if (a.charAt(i) > b.charAt(i))
        return true;
      else if (a.charAt(i) < b.charAt(i))
        return false;
    }
    return a.length() < b.length();
  }
}

package structures;

// LinkedHashMap Documentation:
// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.AbstractMap.SimpleEntry;
import java.util.Random;

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

    SimpleEntry[] value = this.internalMap.get(key);

    this.internalMap.remove(key);

    this.internalMap.put("History",value);

  }

  SimpleEntry[] history(String key) {
    // Find the value with the "History" key
    for (SimpleEntry nvp : this.internalMap.get(key)) {
      if (nvp.getKey().equals("History"))
        return ((ArrayList<SimpleEntry>) nvp.getValue()).toArray(new SimpleEntry[0]);
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

    int left = 0;  //first element of list
    int right = keys.length - 2; //before-last element of list
    int pivot = keys.length - 1; //Last element of list

    quickSortRecursive(keys, left, right);

    return keys;
  }

  private void quickSortRecursive(String[] keys, int left, int right) {

      String start = keys[left] ;
      String end = keys[right] ;

      if (compareStrings(end, start)) {
          int partitionIndex = partition(keys, left, right);

          quickSortRecursive(keys, left, partitionIndex - 1);
          quickSortRecursive(keys, partitionIndex + 1, right);


      }
  }


    private int partition(String keys[], int begin, int end) {

        int partitionIndex = 0;

        return partitionIndex;
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

   //


}

import javafx.util.Pair;

import structures.HashMap;
import structures.Sequence;

public class SmartAR {
  // Number of elements in the structure
  private int size;
  // The threshold defining if the structure is large or not
  private int threshold = 50000;
  // The flag to know if we need to use space-efficient or time-efficient algorithms
  private boolean isLarge;
  // The structure used to store data in case the large flag is TRUE
  private HashMap map;
  // The structure used to store data in case the large flag is FALSE
  private Sequence sequence;

  SmartAR(int size) {
    // Assign the initial values
    this.size = size;
    this.isLarge = this.size >= this.threshold;

    // Initialize the structure properly depending on the size
    if (isLarge) {
      map = new HashMap(this.size);
      sequence = null;
    } else {
      map = null;
      sequence = new Sequence();
    }
  }

  public void setThreshold(int threshold) {
    // Store the current value for isLarge
    boolean prevIsLarge = this.isLarge;

    // Set the threshold and update isLarge
    this.threshold = threshold;
    this.isLarge = this.size >= this.threshold;

    // If isLarge didn't changed, then job is done
    if(prevIsLarge == this.isLarge)
      return;

    // If isLarge changed, then migrate data to new structure
    if (this.isLarge) {
      this.map.migrate(this.sequence);
      this.sequence = null;
    } else {
      this.sequence.migrate(this.map);
      this.map = null;
    }
  }

  public void setKeyLength(int length) {
    // TODO.. Seems pretty useless though so Let's implement last if at all.
  }

  public String[] generate(int n) {
    // TODO Generate n unique, non-existing keys
    return new String[n];
  }

  public String[] allKeys() {
    // TODO Return all the keys sorted Lexicographically
    return new String[0];
  }

  public void add(String key, Object value) {
    // TODO Add a new entry to the structure
  }

  public void remove(String key) {
    // TODO Remove an existing entry from the structure and add it to the history for that key
  }

  public Pair[] getValues(String key) {
    // TODO Return the value for a given key
    return new Pair[]{new Pair<>(null, null)};
  }

  public String nextKey(String key) {
    // TODO Simply return the next key in the structure. Return null if no next key
    return "Next Key";
  }

  public String prevKey(String key) {
    // TODO Simply return the previous key in the structure. Return null if no previous key
    return "Prev Key";
  }

  public Pair[] prevCars(String key) {
    // TODO Return the history Pair[] for the given key
    return new Pair[]{new Pair<>(null, null)};
  }
}

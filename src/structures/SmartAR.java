package structures;

import javafx.util.Pair;

import structures.HashMap;
import structures.Sequence;

public class SmartAR {
  // Number of elements in the structure
  private int size;
  // The threshold defining if the structure is large or not (Default = 50,000)
  private int threshold = 50000;
  // The flag to know if we need to use space-efficient or time-efficient algorithms
  private boolean isLarge;
  // The structure used to store data in case the large flag is TRUE
  private HashMap map;
  // The structure used to store data in case the large flag is FALSE
  private Sequence sequence;

  public SmartAR(int size) {
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
    if (isLarge) {
      return map.allKeys();
    } else {
      return sequence.allKeys();
    }
  }

  public void add(String key, Pair<String, Object> value) {
    if (isLarge) {
      map.add(key, value);
    } else {
      sequence.add(key, value);
    }
  }

  public void remove(String key) {
    if (isLarge) {
      map.remove(key);
    } else {
      sequence.remove(key);
    }
  }

  public Pair[] getValues(String key) {
    if (isLarge) {
      return map.get(key);
    } else {
      return sequence.get(key);
    }
  }

  public String firstKey() {
    if (isLarge) {
      return map.firstKey();
    } else {
      return sequence.firstKey();
    }
  }

  public String nextKey(String key) {
    if (isLarge) {
      return map.nextKey(key);
    } else {
      return sequence.nextKey(key);
    }
  }

  public String prevKey(String key) {
    if (isLarge) {
      return map.prevKey(key);
    } else {
      return sequence.prevKey(key);
    }
  }

  public Pair[] prevCars(String key) {
    if (isLarge) {
      return map.history(key);
    } else {
      return sequence.history(key);
    }
  }
}

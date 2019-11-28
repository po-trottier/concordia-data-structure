package structures;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;

class LinkedNode {
  private String key;
  private ArrayList<Pair<String, Object>> values;
  private LinkedNode next = null;

  LinkedNode(String key) {
    this.key = key;
    values = new ArrayList<>();
  }

  String getKey() {
    // Get the key for the current node
    return this.key;
  }

  Pair[] getValues() {
    // Get the values for the current node
    return this.values.toArray(new Pair[0]);
  }

  LinkedNode getNext() {
    // Get the next node after the current node
    return this.next;
  }

  void setNext(LinkedNode next) {
    // Set the next element after the current node
    this.next = next;
  }

  void setValues(Pair<String, Object>[] newValues) {
    // Add a value to the values ArrayList
    this.values = new ArrayList<>(Arrays.asList(newValues));
  }

  void addValue(Pair<String, Object> newValue) {
    // Add a value to the values ArrayList
    this.values.add(newValue);
  }

  void remove() {
    // "Remove" the noe by setting the History and clearing the rest of the values
    var prevValues = this.values;
    this.values = new ArrayList<>();
    this.values.add(new Pair<>("History", prevValues));
  }

  boolean isLast() {
    // Get whether this is the last node in the linked list of not
    return this.next == null;
  }

  boolean isEmpty() {
    // Get whether this node is empty or only contains a history (it was removed).
    var noValues = (this.values == null);
    var historyOnly = (this.values != null
                    && this.values.size() == 1
                    && this.values.get(0).getKey().equals("History"));
    return (noValues || historyOnly);
  }
}

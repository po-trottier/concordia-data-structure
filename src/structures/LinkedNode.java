package structures;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;

class LinkedNode {
  private String key;
  private ArrayList<SimpleEntry<String, Object>> values;
  private LinkedNode next = null;

  //O(1)
  LinkedNode(String key) {
    this.key = key;
    values = new ArrayList<>();
  }

  //O(1)
  String getKey() {
    // Get the key for the current node
    return this.key;
  }

  //O(1)
  SimpleEntry[] getValues() {
    // Get the values for the current node
    return this.values.toArray(new SimpleEntry[0]);
  }

  //O(1)
  LinkedNode getNext() {
    // Get the next node after the current node
    return this.next;
  }

  //O(1)
  void setNext(LinkedNode next) {
    // Set the next element after the current node
    this.next = next;
  }

  //O(1)
  void setValues(SimpleEntry<String, Object>[] newValues) {
    // Add a value to the values ArrayList
    this.values = new ArrayList<>(Arrays.asList(newValues));
  }

  //O(1)
  void addValue(SimpleEntry<String, Object> newValue) {
    // Add a value to the values ArrayList
    this.values.add(newValue);
  }

  //O(1)
  void remove() {
    // "Remove" the node by setting the History and clearing the rest of the values
    var prevValues = this.values;
    this.values = new ArrayList<>();
    this.values.add(new SimpleEntry<>("History", prevValues));
  }

  //O(1)
  boolean isLast() {
    // Get whether this is the last node in the linked list of not
    return this.next == null;
  }

  //O(1)
  boolean isEmpty() {
    // Get whether this node is empty or only contains a history (it was removed).
    var noValues = (this.values == null);
    var historyOnly = (this.values != null
                    && this.values.size() == 1
                    && this.values.get(0).getKey().equals("History"));
    return (noValues || historyOnly);
  }
}

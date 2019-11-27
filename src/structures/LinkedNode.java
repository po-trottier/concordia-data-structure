package structures;

public class LinkedNode {
  private LinkedNode next = null;
  private Object[] value = null;

  public boolean isLast() {
    return this.next == null;
  }
  public boolean isEmpty() {
    return this.value == null;
  }
}

# smart-automobile-registration

Design Decisions and Semantics

---

### Design implementation

The two main data structures used in the implementation of the SmartAR were Hash Maps and Sequences.

### Sequences:

* Used when the input size is smaller in order to improve the space complexity of the algorithm. 
* Time complexity is less of a concern since the size of the data input (n) is significantly smaller
* The sequences were implemented using the Linked Node data type that can be found in the LinkedNode.java file
* The sequence is then Heap sorted into a lexicographic order


### Hash Map:

* Used for larger input sizes in order to improve the time complexity since the input size is already very large
* Space complexity is a concern but it was more practical to focus on time since we will already be using a lot of space
* The Hash Map is sorted using a quick sort algorithm to really maximize its efficiency and minimize the time complexity


### Overview

* When a file with a very large number of keys is presented, Hash Maps are used, below the threshold, a sequence is used.
* The threshold is set at the initialization of the SmartAR
* Even if a element is deleted, it always remains in history

# smart-automobile-registration

An optimized smart automobile registration class

---

### 2 ADTs

* Array 1 - Space efficient
    * linked list based node-list
    * Use heap sort to return all keys
* Array 2 - Time efficient
    * Hash table 
    * Quick sort with hash table keys
    
In both cases, pointer holds the same value type/structure
* ArrayList\<Objects\>
* First element is the History (previous cars)
    * History is populated every time an entry is removed
    * The key is kept, then the value is moved inside the history object
    * This will result in a recursive history object until it's empty  

### Methods:

* Threshold between 100 - 500K inclusively
    * Bigger than threshold = Hash table or AVL Tree
    * Smaller = sequence  
    
* Set key length - Length is between 6 and 12

* Generate multiple non-existing keys and create sequence 

* allKeys - returns as a sorted sequence - lexicographic order

* add - add a value with a given key
    * value can be any feature of the car or the owner
    
* remove - Removes entry for a given key

* getValues - return values for a give key 

* nextKey - returns next key

* preKey - returns previous key

* previousCars - returns sequence of cars previously registered with a given key (sorted in reverse chronological order)


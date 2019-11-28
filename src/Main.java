import static tests.Tests.*;
import static tests.Utils.*;

////////////////////////////////////////////////////////////////////
// Written by:
//  - Nimit Jaggi (40032159)
//  - Pierre-Olivier Trottier (40059235)
////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////
// Important Information:
//
// - The main ADT is called SmartAR (Found in /structures)
// - It uses many underlying structures
// - The tests are written in a separate file for cleanliness sake
// - The detailed report for the decisions is in the README.md file
////////////////////////////////////////////////////////////////////

public class Main {
  public static void main(String[] args) {
    // STEP #1: Read the files
    title("Reading Test Files");
    readTestFiles();

    // STEP #2: Create and populate the SmartARs
    title("Populating SmartARs");
    createAndPopulate();

    // STEP #3: Display all the keys sorted Lexicographically
    title("Displaying all Sorted Keys");
    getAllSortedKeys();

    // STEP #4: Remove a few items
    title("Removing some elements");
    removeSomeElements();

    // STEP #5: Remove a few items
    title("Adding back some element");
    addRemovedElements();

    // STEP #6: Remove a few items
    title("Displaying \"new\" elements");
    getRemovedElements();

    // STEP #7: Remove a few items
    title("Getting previous cars");
    getPreviousCars();

    // STEP #8: Iterate forward by getting the next key
    title("Iterating Forward");
    iterateForward();

    // STEP #9: Iterate backwards by getting the previous key
    title("Iterating Backwards");
    iterateBackwards();

    // STEP #10: Add new non-existing items (new keys)
    title("Adding new unique items");
    addUniqueItems();
  }
}

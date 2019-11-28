package tests;

import java.util.ArrayList;

import structures.SmartAR;

import static tests.Utils.*;

public class Tests {
  // Test Files
  private static final String file1 = "ar_test_file1.txt";
  private static final String file2 = "ar_test_file2.txt";
  private static final String file3 = "ar_test_file3.txt";
  // Test Files Content
  private static String[] file1Content;
  private static String[] file2Content;
  private static String[] file3Content;
  // SmartARs for Test Files
  private static SmartAR registration1;
  private static SmartAR registration2;
  private static SmartAR registration3;
  // Removed Elements
  private static ArrayList<String> removedElements1;
  private static ArrayList<String> removedElements2;
  private static ArrayList<String> removedElements3;
  
  public static void readTestFiles() {
    // Read the content of the test files
    file1Content = readFile(file1);
    file2Content = readFile(file2);
    file3Content = readFile(file3);
    System.out.println("Done");
    // If any of them is empty then something went wrong
    if (file1Content.length == 0 || file2Content.length == 0 || file3Content.length == 0)
      System.out.println("Something went wrong while reading the files");
  }

  public static void createAndPopulate() {
    // Create a new structures.SmartAR for a Test File then populate it
    registration1 = new SmartAR(file1Content.length);
    populateAR(registration1, file1Content, 1);
    registration2 = new SmartAR(file2Content.length);
    populateAR(registration2, file2Content, 2);
    registration3 = new SmartAR(file3Content.length);
    populateAR(registration3, file3Content, 3);
  }

  public static void getAllSortedKeys() {
    // Debug Log to show the order in which the elements are returned
    getSortedKeys(registration1, 1);
    getSortedKeys(registration2, 2);
    getSortedKeys(registration3, 3);
  }

  public static void removeSomeElements() {
    // Removed 100 elements from the SmartARs
    removedElements1 = removeRandom(registration1);
    removedElements2 = removeRandom(registration2);
    removedElements3 = removeRandom(registration3);
    System.out.println("Done");
  }

  public static void addRemovedElements() {
    // Re-Added the 100 removed elements from the SmartARs
    addElements(registration1, removedElements1);
    addElements(registration2, removedElements2);
    addElements(registration3, removedElements3);
    System.out.println("Done");
  }

  public static void getRemovedElements() {
    // Display 1 of the Re-Added elements for each structures.SmartAR
    getRemoved(registration1, removedElements1, 1);
    getRemoved(registration2, removedElements2, 2);
    getRemoved(registration3, removedElements3, 3);
  }

  public static void getPreviousCars() {
    // Display 1 of the removed car's history for each structures.SmartAR
    getHistory(registration1, removedElements1, 1);
    getHistory(registration2, removedElements2, 2);
    getHistory(registration3, removedElements3, 3);
  }

  public static void iterateForward() {
    moveForward(registration1, 1);
    moveForward(registration2, 2);
    moveForward(registration3, 3);
  }

  public static void iterateBackwards() {
    moveBackwards(registration1, 1);
    moveBackwards(registration2, 2);
    moveBackwards(registration3, 3);
  }

  public static void addUniqueItems() {
    addNewItems(registration1, 1);
    addNewItems(registration2, 2);
    addNewItems(registration3, 3);
  }
}

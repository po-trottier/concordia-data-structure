package tests;

import java.util.ArrayList;

import structures.SmartAR;

import static tests.Utils.*;

public class Tests {
  // Test Files
  private static final String FILE_1 = "ar_test_file1.txt";
  private static final String FILE_2 = "ar_test_file2.txt";
  private static final String FILE_3 = "ar_test_file3.txt";
  // Test Files Content
  private static String[] FILE_1_CONTENT;
  private static String[] FILE_2_CONTENT;
  private static String[] FILE_3_CONTENT;
  // SmartARs for Test Files
  private static SmartAR AR_1;
  private static SmartAR AR_2;
  private static SmartAR AR_3;
  // Removed Elements
  private static ArrayList<String> REMOVED_1;
  private static ArrayList<String> REMOVED_2;
  private static ArrayList<String> REMOVED_3;
  
  public static void readTestFiles() {
    // Read the content of the test files
    FILE_1_CONTENT = readFile(FILE_1);
    FILE_2_CONTENT = readFile(FILE_2);
    FILE_3_CONTENT = readFile(FILE_3);
    System.out.println("Done");
    // If any of them is empty then something went wrong
    if (FILE_1_CONTENT.length == 0 || FILE_2_CONTENT.length == 0 || FILE_3_CONTENT.length == 0)
      System.out.println("Something went wrong while reading the files");
  }

  public static void createAndPopulate() {
    // Create a new structures.SmartAR for a Test File then populate it
    AR_1 = new SmartAR(FILE_1_CONTENT.length);
    populateAR(AR_1, FILE_1_CONTENT, 1);
    AR_2 = new SmartAR(FILE_2_CONTENT.length);
    populateAR(AR_2, FILE_2_CONTENT, 2);
    AR_3 = new SmartAR(FILE_3_CONTENT.length);
    populateAR(AR_3, FILE_3_CONTENT, 3);
  }

  public static void getAllSortedKeys() {
    // Debug Log to show the order in which the elements are returned
    getSortedKeys(AR_1, 1);
    getSortedKeys(AR_2, 2);
    getSortedKeys(AR_3, 3);
  }

  public static void removeSomeElements() {
    // Removed 100 elements from the SmartARs
    REMOVED_1 = removeRandom(AR_1);
    REMOVED_2 = removeRandom(AR_2);
    REMOVED_3 = removeRandom(AR_3);
    System.out.println("Done");
  }

  public static void addRemovedElements() {
    // Re-Added the 100 removed elements from the SmartARs
    addElements(AR_1, REMOVED_1);
    addElements(AR_2, REMOVED_2);
    addElements(AR_3, REMOVED_3);
    System.out.println("Done");
  }

  public static void getRemovedElements() {
    // Display 1 of the Re-Added elements for each structures.SmartAR
    getRemoved(AR_1, REMOVED_1, 1);
    getRemoved(AR_2, REMOVED_2, 2);
    getRemoved(AR_3, REMOVED_3, 3);
  }

  public static void getPreviousCars() {
    // Display 1 of the removed car's history for each structures.SmartAR
    getHistory(AR_1, REMOVED_1, 1);
    getHistory(AR_2, REMOVED_2, 2);
    getHistory(AR_3, REMOVED_3, 3);
  }

  public static void iterateForward() {
    moveForward(AR_1, 1);
    moveForward(AR_2, 2);
    moveForward(AR_3, 3);
  }

  public static void iterateBackwards() {
    moveBackwards(AR_1, 1);
    moveBackwards(AR_2, 2);
    moveBackwards(AR_3, 3);
  }

  public static void addUniqueItems() {
    addNewItems(AR_1, 1);
    addNewItems(AR_2, 2);
    addNewItems(AR_3, 3);
  }
}

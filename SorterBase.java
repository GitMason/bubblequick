import java.util.Random;

public abstract class SorterBase {
  
  // declare member variables here
  // make them all private, and access them only through the accessors below
  private int[] numList;      // array that contains the numbers that will be sorted
  private int   getCount = 0; // counts how many times getNum has been called
  private int   setCount = 0; // counts how many times setNum has been called 
  
  public SorterBase(String a, // the name of the sort algorithm, for print()
                    int n)    // size of internal array 
  {
    newIncreasing(n);
    
    // populate an internal array of numbers 0...n-1 and scramble it
  }
 
  public String getName()        { return ""; } // algorithm name
  public int    getSize()        { return 0; }  // internal array length
  public long   getNumSwaps()    { return 0; }  // maintain counters for various operations
  public long   getNumCompares() { return 0; }
  public long   getNumGets()     { return 0; }
  public long   getNumSets()     { return 0; }
  public int  getNum(int i){                    // fetch an internal array value out (and count it)
    getCount++;
    return(numList[i]); 
  } 
  public void setNum(int i, int x) {            // set a value into the internal array (and count it)
    setCount++;
    numList[i] = x;
  }
  public void resetCounters() {
    getCount = 0;
    setCount = 0;
  }
  
  
  public void newIncreasing(int n) { // populate internal array 0...n-1
    numList = new int[n];
    for (int i = 0; i < n; i++) {
      numList[i] = i;
      //System.out.println(numList[i]);
    }
  } 
  
  public void newDecreasing(int n) {   // populate internal array n-1...0
    numList = new int[n];
    for (int i = 0; i < n; i++) {
      numList[i] = n - (i + 1);
      //System.out.println(numList[i]);
    }
  }
  
  public void newScramble(int n) {     // populate internal array with values 0...n-1, scrambled
    // the standard way to scramble n numbers is
    // i=0; j=a random index 0 <= j < n: swap the values at indices i and j
    // i=1; j=a random index 0 <= j < n: swap the values at indices i and j
    // ...
    // You will need to google to find out how to get java to give you random numbers 0 <= j < n
  }
  
  public boolean isSorted() {return false;} // test whether internal array is sorted (in increasing order)
  
  public void print(boolean print_nums) {   // print all the counters, and optionally the internal array
    if (print_nums) {
      System.out.println("The method getNum has been called " + getCount + " times.");
      System.out.println("The method setNum has been called " + setCount + " times.");
      
      for (int i = 0; i < numList.length; i++) {
        System.out.print(numList[i] + " ");
      }
      System.out.print("\n");
    }
  }
 
  // this is for comparing internal array values at indices i and j -- must be counted in getNumCompares()
  public boolean indexLessThan(int i, int j) { return false; }
  
  // this is for comparing actual values x and y -- must be counted in numCompares()
  public boolean valueLessThan(int x, int y) { return false; }
  
  // this is for swapping internal array values at indices i and j -- must be counted in getNumSwaps()
  public void indexSwap(int i, int j) {  }
  
  // note there is no valueSwap(int x, int y), because java only passes by value, not by reference, 
  // so a function valueSwap() cannot cause the values of x and y to swap in the perspective of the caller
  
  // This function is to be overridden by various sorters
  // Because the internal array is private, values cannot be gotten out without hitting the 'get' counter
  // sort should use indexLessThan(), to ensure comparisons get properly counted
  // If an algorithm cannot be done in place, then calls to getNum() and setNum() will be counted
  // The caller must use valueLessThan() and not cheat on the comparison count by using uncounted <
  public abstract void sort();
}

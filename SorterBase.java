import java.util.Random;

public abstract class SorterBase {

  // declare member variables here
  // make them all private, and access them only through the accessors below
  
  public SorterBase(String a, // the name of the sort algorithm, for print()
                    int n)    // size of internal array 
  {
    // populate an internal array of numbers 0...n-1 and scramble it
  }
 
  public String getName()        { return ""; } // algorithm name
  public int    getSize()        { return 0; }  // internal array length
  public long   getNumSwaps()    { return 0; }  // maintain counters for various operations
  public long   getNumCompares() { return 0; }
  public long   getNumGets()     { return 0; }
  public long   getNumSets()     { return 0; }
  public int  getNum(int i)      { return 0; } // fetch an internal array value out (and count it)
  public void setNum(int i,int x)    {   }     // set a value into the internal array (and count it)
  public void resetCounters() {  }
  
  public void newIncreasing(int n) {  } // populate internal array 0...n-1
  
  public void newDecreasing(int n) {  } // populate internal array n-1...0
  
  public void newScramble(int n) {     // populate internal array with values 0...n-1, scrambled
    // the standard way to scramble n numbers is
    // i=0; j=a random index 0 <= j < n: swap the values at indices i and j
    // i=1; j=a random index 0 <= j < n: swap the values at indices i and j
    // ...
    // You will need to google to find out how to get java to give you random numbers 0 <= j < n
  }
  
  public boolean isSorted() { return false;} // test whether internal array is sorted (in increasing order)
  
  public void print(boolean print_nums) {  } // print all the counters, and optionally the internal array
 
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

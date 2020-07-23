import java.util.concurrent.ThreadLocalRandom;

public abstract class SorterBase {
  
  // declare member variables here
  // make them all private, and access them only through the accessors below
  private int[] numList;        // array that contains the numbers that will be sorted
  private long   getCount = 0;  // counts how many times getNum has been called
  private long   setCount = 0;  // counts how many times setNum has been called 
  private long   swapCount = 0; // counts how many times indexSwap has been called
  private long   compCount = 0; // counts how many times indexLessThan and valueLessThan have been called
  private String  algName = "";
    
    
  public SorterBase(String a, // the name of the sort algorithm, for print()
                    int n)    // size of internal array 
  {
    newScramble(n);
    algName = a;

    // populate an internal array of numbers 0...n-1 and scramble it
  }
  public String getName()        { return algName; } // algorithm name
  public int    getSize()        { return numList.length; }  // internal array length
  public long   getNumSwaps()    { return swapCount; }  // maintain counters for various operations
  public long   getNumCompares() { return compCount; }
  public long   getNumGets()     { return getCount; }
  public long   getNumSets()     { return setCount; }
  
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
    swapCount = 0;
    compCount = 0;
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
  
  public void clearList(){
    for(int i = 0; i < getSize(); i++){
      setNum(i, 0);
    }
    resetCounters();
  }
  
  public void newScramble(int n) {     // populate internal array with values 0...n-1, scrambled
    newIncreasing(n);
    for(int i = 0; i < n; i++){
      indexSwap(i, ThreadLocalRandom.current().nextInt(0, n));
    resetCounters();
    }


    // the standard way to scramble n numbers is
    // i=0; j=a random index 0 <= j < n: swap the values at indices i and j
    // i=1; j=a random index 0 <= j < n: swap the values at indices i and j
    // ...
    // You will need to google to find out how to get java to give you random numbers 0 <= j < n
  }
  
  public boolean isSorted() { // test whether internal array is sorted (in increasing order)
    for(int i = 0; i < numList.length - 1; i++){
      if(numList[i] > numList[i + 1] - 1){return(false);}
    }
    return(true);  
  }
  public void addHeaders(){
    System.out.println("ALG,N,COMPS,SWAPS,GETS,SETS,TOTAL,SORTED");
  }
  
  public void print(boolean print_nums) {   // print all the counters, and optionally the internal array
    System.out.print(getName() + "," + getSize() + "," + getNumCompares() + "," + getNumSwaps() + "," + getNumGets() + "," + getNumGets() + ",");
    System.out.print(getSize() + compCount + swapCount + getCount + setCount + ",");
    if(isSorted()){System.out.print("yes");}
    else{System.out.print("no");}
    System.out.print("\n");
    if (print_nums) {
      for (int i = 0; i < numList.length; i++) {
        System.out.print(numList[i] + " ");
      }
      System.out.print("\n");
    }
  }
 
  // this is for comparing internal array values at indices i and j -- must be counted in getNumCompares()
  public boolean indexLessThan(int i, int j) {
    compCount++;
    if(numList[i] < numList[j]) {return true;}
    else {return false;}
  }
  
  // this is for comparing actual values x and y -- must be counted in numCompares()
  public boolean valueLessThan(int x, int y) { 
    compCount++;
    if(x < y) {return true;}
    else {return false;}
  }
  
  // this is for swapping internal array values at indices i and j -- must be counted in getNumSwaps()
  public void indexSwap(int i, int j) {
    int holder; // to hold one of the swapped values
    holder = numList[j];
    numList[j] = numList[i];
    numList[i] = holder;
    swapCount++;
  }
  
  // note there is no valueSwap(int x, int y), because java only passes by value, not by reference, 
  // so a function valueSwap() cannot cause the values of x and y to swap in the perspective of the caller
  
  // This function is to be overridden by various sorters
  // Because the internal array is private, values cannot be gotten out without hitting the 'get' counter
  // sort should use indexLessThan(), to ensure comparisons get properly counted
  // If an algorithm cannot be done in place, then calls to getNum() and setNum() will be counted
  // The caller must use valueLessThan() and not cheat on the comparison count by using uncounted <
  public abstract void sort();
}

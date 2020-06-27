import java.util.Random;

public abstract class SorterBase {

  private String algorithm;
  private long compareCounter;
  private long swapCounter;
  private long getCounter;
  private long setCounter;
  private int[] nums;
  

  public SorterBase(String a, int n) { 
    algorithm = a;
    newScramble(n); // resetCounters()
  }
 
  public String getName()        { return algorithm;      }
  public int    getSize()        { return nums.length;    }
  public long   getNumSwaps()    { return swapCounter;    }
  public long   getNumCompares() { return compareCounter; }
  public long   getNumGets()     { return getCounter;     }
  public long   getNumSets()     { return setCounter;     }
  public int getNum(int i)       { getCounter++;
                                   return nums[i];        }
  public void setNum(int i,int x){ setCounter++;
                                   nums[i] = x;           }
  public void resetCounters() {
    compareCounter = 0;
    swapCounter = 0;
    getCounter = 0;
    setCounter = 0;
  }
  
  public void newIncreasing(int n) {
    nums = new int[n];
    for (int i=0; i<n; ++i) {
      nums[i] = i;
    }
    resetCounters();
  }
  
  public void newDecreasing(int n) {
    nums = new int[n];
    for (int i=0; i<n; ++i) {
      nums[i] = n - i - 1;
    }
    resetCounters();
  }
  
  public void newScramble(int n) {
    Random randy = new Random();
    newIncreasing(n);
    for (int i=0; i<n; ++i) {
      int j = randy.nextInt(n); // returns 0...n-1
      indexSwap(i, j);
    }
    resetCounters();
  }
  
  public boolean isSorted() {
    // a correct sort will always be 0,1,2,3,...n-1
    for (int i=0; i<nums.length-1; ++i) {
      if (nums[i] != i) {      // if any number is out of place...
        return false;          // nope
      }
    }                          // if we make it out of the loop...
    return true;               // yep
  }
  
  public void print(boolean print_nums) {
    System.out.printf("ALG,%s,N,%d,COMPS,%d,SWAPS,%d,GETS,%d,SETS,%d,TOTAL,%d,SORTED,%s\n", 
                      getName(), getSize(), 
                      compareCounter,  swapCounter,  getCounter,  setCounter,
                      compareCounter + swapCounter + getCounter + setCounter,
                      (isSorted() ? "yes" : "no"));
    if (print_nums) {
      for (int i=0; i<getSize(); ++i) {
        System.out.printf("%d ", nums[i]);
      }
      System.out.printf("\n");
    }                 
  }
 
  // this is for comparing nums[i] and nums[j]
  // this calls getNum() for both so they both take a +1 hit on getCounter
  public boolean indexLessThan(int i, int j) {
    compareCounter++;
    return (getNum(i) < getNum(j)); // getCounter += 2
  }
  
  // this is for comparing actual values x and y
  public boolean valueLessThan(int x, int y) {
    compareCounter++;
    return (x < y); // getCounter was incremented when x, y were fetched
  }
  
  // this is for swapping nums[i] and nums[j]
  public void indexSwap(int i, int j) {
    swapCounter++;
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  
  // note there is no valueSwap(int x, int y), because java only passes by value, not by reference, 
  // so a function valueSwap() cannot cause the values of x and y to swap in the perspective of the caller
  
  // This function is to be overridden by various sorters
  // Because nums is private, values cannot be gotten out without hitting getCounter
  // sort should use indexLessThan(), to ensure comparisons get properly counted
  // If an algorithm cannot be done in place, then getNum() and setNum() will count.
  // The caller must use valueLessThan() and not cheat on the comparison count by using uncounted <
  public abstract void sort();
}

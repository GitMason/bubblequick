
public class SorterQuick extends SorterBase {
  
  public SorterQuick(int n) { 
    super("Quick", n);
  }
  
  public void sort() {
    sortRange(0, getSize()-1);
  }
  
  // sort the elements from i=lo...hi (inclusive)
  public void sortRange(int lo, int hi) {
    if (hi <= lo) {  // sort i...i, i.e. just one thing
      return;        // nothing to do
    }
    
    if (hi == lo+1) { // sort i...i+1, i.e. just two adjacent things
      if (indexLessThan(hi, lo)) {
        indexSwap(lo, hi);
      }
      return;
    }
    
    // ok so we have at least 3 items to sort.
    // copy them out into a temp array
    int n = hi-lo+1; // e.g. lo=10, hi=13 --> n=4
    int[] temp = new int[n];
    for (int i=lo; i<=hi; ++i) { // inclusive of hi
      temp[i-lo] = getNum(i);    // getCounter++
    }
    
    int pivot = temp[0];
    int isma = lo; // this is where the next <pivot value will go
    int ibig = hi; // this is where the next >pivot value will go
    for (int i=1; i<n; ++i)  { // not 0, save the pivot for last
      if (valueLessThan(temp[i], pivot)) { // compareCounter++
        setNum(isma, temp[i]);             // setCounter++
        isma++;                            // skooch
      } else {       // temp[i] > pivot
        setNum(ibig, temp[i]);             // setCounter
        ibig--;
      }
    }
    // when we're all done, pivot goes in isma=ibig
    if (isma != ibig) {
      System.out.printf("ERROR: unexpected condition!!");
    }
    setNum(isma, pivot);
    
    // now all of lo...isma-1 are < pivot
    // and all of ibig+1...hi are > pivot
    sortRange(lo, isma-1);
    // pivot is already in the right place
    sortRange(ibig+1, hi);
  }
 
}

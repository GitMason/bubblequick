
public class SorterQuick extends SorterBase {
  public SorterQuick(int n) { 
    super("Quick", n);
  }
  
  public void sort() {
    sortRange(0, getSize()-1);
    
  }
  
  private int[] temp;
  
  // sort the elements from i=lo...hi (inclusive)
  public void sortRange(int lo, int hi) {
     
    
    if(hi < lo){return;}                // checks for 0 length array
    if(hi == lo){return;}               // checks for 1 length array
    else if(hi - lo == 1){              // checks for 2 length array
      if(indexLessThan(hi, lo)){
        indexSwap(lo, hi);              // swap if out of order
        return;
      }     
    }
    else{
      temp = new int[hi - lo + 1];
      int j = 0;
      for (int i = lo; i <= hi; i++){    // set temp to the same values as numList
        temp[j] = getNum(i);
        j++;
        
      }
      
      int pivot = temp[0];
      //clearList();                     // for testing and making things easier to look at
      
      int bottomRange = lo;                
      int topRange = hi;
      
      for(int i = 1; i < temp.length; i++){
        if (temp[i] < pivot){
          setNum(bottomRange, temp[i]);
          bottomRange++;
        }
        else{
          setNum(topRange, temp[i]);
          topRange--;
        }
        
      }
      setNum(topRange, pivot);
      sortRange(lo, topRange - 1);          // calls itself so that it sorts smaller and smaller ranges
      sortRange(topRange + 1, hi);          // until all base cases are fulfilled
    }

   
    }
  

      
    




    // QuickSort is a 'recursive' sort because this function calls itself.
    // Here's how it works. Copy out values at indices lo...hi into a temporary external array
    // Pick ay element of the temporary array (might as well be the first or last) to be the 'pivot'
    // Go through the non-pivot elements of the temporary array,
    // Stick the less-than-pivot values back in the internal array, in positions lo, lo+1, lo+2, ...
    // Stick the more-than-pivot values back in the internal array, in positions hi, hi-1, hi-2, ...
    // When you're done there will be one spot left to put the pivot
    // Now lo...hi is reordered into 3 groups, from left to right:
    // 1. less-than-pivot 
    // 2. then the  pivot (group of one)
    // 3. more-than-pivot 
    // The pivot is EXACTLY where it belongs in the final ordering (why?)
    // Groups 1 and 3 are also occupying the ranges they should occupy in the final ordering (why?),
    // but out of order in those ranges.
    // The secret sauce is, at the end of this function sortRange() we call this same function sortRange() -- 
    // twice; once each for the sub-ranges that define groups 1 and 3.
    
    // VERY important for recursive functions: you MUST protect against infinite recursion by opening the
    // function by handling the appropriate 'base cases', like what if the range includes only 1 or 2 numbers? 
    // Or even what if the range includes 0 numbers?
    
    // I have set this up so that the range lo,hi is inclusive (on both ends), and the main sort() function
    // calls sortRange(0, getSize()-1); If it works better for the way you want to think about it, feel
    // free to redefine it more java-style, like sortRange(int first_index, int last_index_plus_one), 
    // in which case you would change the main function to sortRange(0, getSize())
  
 
}


public class SorterBubble extends SorterBase {
  
  public SorterBubble(int n) { 
    super("Bubble", n);
  }
  
  public void sort() {
    int n = getSize(); // this is how many we have
    for (int bubbi=n-1; bubbi>=0; bubbi--) {   // bubbi = n-1, n-2, ...0
      // inside this loop we will start at 0 and bubble the maximum up to position bubbi
      for (int i=0; i<bubbi; ++i) {            // i   = 0...bubbi-1
                                               // i+1 = 1...bubbi
        // look at i and i+1; bubble up the larger one
        if (indexLessThan(i+1, i)) {
          indexSwap(i, i+1);
        }
      }
    }
  }

  
}

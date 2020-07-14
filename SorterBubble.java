
public class SorterBubble extends SorterBase {
  
  public SorterBubble(int n) { 
    super("Bubble", n);
  }
  
  public void sort() {
    for(int rounds = 0; rounds < getSize(); rounds++){     // # of times the loop goes thru and bubbleswaps
      for(int i = 0; i < getSize() - 1; i++){
        if(indexLessThan(i + 1, i)){
          indexSwap(i, i + 1);
        }
      }
    }
  }

  
}

public class SorterMain {
  public static void main(String[] args) { 
    SorterBubble bubbly = new SorterBubble(10);
    bubbly.print(true);
    bubbly.sort();
    bubbly.print(true); 
    
    SorterQuick quickly = new SorterQuick(10);
    quickly.print(true);
    quickly.sort();
    quickly.print(true);
    
    for (int n=100; n<=1000; n+=100) {
      bubbly = new SorterBubble(n);
      bubbly.sort();
      bubbly.print(false);
    }
   
    for (int n=100; n<=1000; n+=100) {
      quickly = new SorterQuick(n);
      quickly.sort();
      quickly.print(false);
    }
  }
}

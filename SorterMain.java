public class SorterMain {
  public static void main(String[] args) { 
    
    SorterBubble bubbly = new SorterBubble(10);  // construct a bubble-sorter with 1..10 scrambled
    bubbly.newScramble(10);
    bubbly.print(true);                          // print the state of the sorter (true-->and also all 10 numbers)
    bubbly.sort();                               // perform a bubble sort to put the numbers in order
    bubbly.print(true);                          // print the state again, as well as the sorted numbers

    
    
    
    
    SorterQuick quickly = new SorterQuick(10);   // construct a quick-sorter with 1..10 scrambled
    //quickly.print(true);                         // ...
    //quickly.sort();
    //quickly.print(true);
    
    // Now we'll exercise the sorters on 100, 200, 300, ... 1000 numbers
    for (int n=100; n<=1000; n+=100) {
      bubbly = new SorterBubble(n);              // construct a bubble-sorter with scrambled numbers, but don't print
      bubbly.sort();                             // sort
      bubbly.print(false);                       // print the state but not the numbers
    }
   
    for (int n=100; n<=1000; n+=100) {           // same for quick-sort
      quickly = new SorterQuick(n);
      quickly.sort();
      quickly.print(false);
    }
  }
}

# bubblequick
An empty Java shell for creating a comparison of Bubble and Quick sorts


SorterBase is a base class that both SorterBubble and SorterQuick inherit
from. Most of the work will be done in SorterBase, to create shared methods that
both particular sorts will use.

SorterBubble and SorterQuick inherit all of their basic functionality in common
from SorterBase. Each needs to implement/override only 1 function of their own,
the constructor (which should call the base class constructor with 'super') and
the sort() function (which implements the particular kind of sort). (Although
you can see in SorterQuick there is a helper function sort(lo,hi), it will take
a while to get to that).

SorterMain is the main program (class with 'public static void main()'). The
first group of lines runs the bubble-sorter through a small test on 1..10 and
the second group does the same with the quick-sorter. In the stubs, that code
compiles and runs but prints nothing. When complete, the output of those two
tests might look something like

    ALG,Bubble,N,10,COMPS,0,SWAPS,0,GETS,0,SETS,0,TOTAL,0,SORTED,no
    2 9 8 4 7 5 1 3 6 0 
    ALG,Bubble,N,10,COMPS,45,SWAPS,31,GETS,90,SETS,0,TOTAL,166,SORTED,yes
    0 1 2 3 4 5 6 7 8 9 
    ALG,Quick,N,10,COMPS,0,SWAPS,0,GETS,0,SETS,0,TOTAL,0,SORTED,no
    5 0 9 6 7 4 2 8 1 3 
    ALG,Quick,N,10,COMPS,21,SWAPS,1,GETS,27,SETS,23,TOTAL,72,SORTED,yes
    0 1 2 3 4 5 6 7 8 9 

Note that in the state string, all of the statistics are 0, but after the sort,
you can see a tally of how many COMParisons, and how many SWAPS were used in the
sort, how many time the value of a number had to be fetched with GET, and how
many times the value of a number in the sorter had to be modified with
SET. TOTAL just adds up all those operations, and SORTED says yes or no, based
on double-checking whether the internal numbers are indeed correctly sorted.

The loops at the end run the sorters on larger cases. The output can be saved to
a .csv file and opened in a spreadsheet, and various columns graphed, to compare
the efficiency of the two algorithms.
# ChessNQueensOnBoard

This is a solution for the n queens on the board chess puzzle.
As an example you have to put eight queens on a board with a size of 8x8 fields. 
No queen should attack another one.

In this case the solution could look like this:<br>
X O X X X X X X <br>
X X X O X X X X <br>
X X X X X O X X <br>
X X X X X X X O <br>
X X O X X X X X <br>
O X X X X X X X <br>
X X X X X X O X <br>
X X X X O X X X 

(X == empty field, O == Queen).

There are many brute force solutions on the internet. This is also a kind of brute force solution, with the difference that this program respect a special structure. The program only shows the first possible result. This solution is pretty fast. With normal brute force it could take a really long time, to get a result on a e.g. 1000x1000 field. This method brings a result in just some secounds. 



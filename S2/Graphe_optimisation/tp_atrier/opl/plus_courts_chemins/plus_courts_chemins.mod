/*********************************************
 * OPL 12.9.0.0 Model
 * Author: Windows
 * Creation Date: 18 Mar 2019 at 13:37:43
 *********************************************/
  //test
//avec un tuple : //IBM
int n =...;
int s =...;
int t =...;

range Sommets= 1 ..n;
tuple Arrete { int i;int j;}

{Arrete} Arretes =...;
int duree[Arretes] = ...;


dvar boolean x[Arretes];

 minimize
 sum(<i,j> in Arretes) duree[<i,j>]*x[<i,j>];
 
 subject to{
	
	pr: 	 
		forall(so in Sommets) 
			//sum(i in Sub[s], j in Nbs[i] inter Compl[s]) x[<i,j>]- sum(i in Compl[s], j in Nbs[i] inter Sub[s]) x[<i,j>] == 0;
			sum(<i,j> in Arretes) x[<i,j>] - sum(<i,y> in Arretes) x[<i,y>] == 0;
	de:
		forall(so in Sommets)
			//sum(i in Sub[s], j in Nbs[i] inter Compl[s]) x[<i,j>] - sum(i in Compl[s], j in Nbs[i] inter Sub[s]) x[<i,j>] == 1;
			sum(<i,s> in Arretes) x[<i,s>] - sum(<s,y> in Arretes) x[<s,y>] == -1;
	tr:
		forall(so in Sommets)
		  //sum(i in Sub[t], j in Nbs[i] inter Compl[t]) x[<i,j>] - sum(i in Compl[t], j in Nbs[i] inter Sub[t]) x[<i,j>] == -1;	
			sum(<i,t> in Arretes) x[<i,t>] - sum(<t,y> in Arretes) x[<t,y>] == 1;
	
 };
 
 {Arrete} Used={e|e in Arretes : x[e]==1}; 
 
execute
{
writeln("Used edges",Used);
}
 
 
 
 
  /*forall(s in Sommets)
	 	sum(<i,j> in Arretes) x[<i,j>] + sum(<i,y> in Arretes) x[<i,y>] == 2;
	   	
	 forall(s in Subtours)
	   sum(i in Sommets: s.subtour[i] != 0) 
	   	x[<minl(i,s.subtour[i]), maxl(i,s.subtour[i])>] 
	  	 <= s.size -1;
	  	 */
 

/* 
tuple Subtour {int size; int subtour[Sommets];}
{Subtour} Subtours = ...;

 range bj =1..n; 
range bi =1..n; 
dvar boolean x2[bi][bj];
  int n = ...;//nb sommet
 
dvar float+ u[2..n];
dvar boolean v[1..n][1..n];

float duree [1..n][1..n]=...;

minimize
  sum (i in 1..n,j in 1..n)v[i][j]*duree[i][j];
  
  subject to{
  	init:
  		forall (j in 1..n)
  		  sum(i in 1..n) v[i][j]==1;
  	end:
	  	forall (i in 1..n)
  		  sum(j in 1..n) v[i][j]==1;
  		 tour:
  		forall (i in 2..n,j in 2..n )
  		  u[i]-u[j]+(n-1)*v[i][j]<=n-2;     
    
  }
  
execute
{
writeln("Used edges",Used);
}
*/
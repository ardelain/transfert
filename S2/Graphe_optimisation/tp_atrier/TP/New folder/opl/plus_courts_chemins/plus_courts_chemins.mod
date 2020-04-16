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

range Nodes= 1 ..n;
{int} NodeSet = asSet(Nodes);

range Sommets= 1 ..n;
tuple Arrete { int i;int j;}

{Arrete} Arretes =...;
int duree[Arretes] = ...;

//{Arrete} chemins1;
//{Arrete} chemins2;

{int} Nbs[i in Sommets]={j|<i,j> in Arretes};
{int} Nbs2[i in Sommets]={j|<j,i> in Arretes};

dvar boolean x[Arretes];

 minimize
 sum(<i,j> in Arretes) duree[<i,j>]*x[<i,j>];
 
 subject to{
	forall(i in Sommets)
	  if(i == s)
	  	sum(y in Nbs) x[y] - sum(y in Nbs2) x[y] == 1;
	  	
	  else if(i == t)
	 	 sum(<i,j> in Nbs) x[<i,j>] - sum(<i,j> in Nbs2) x[<i,j>] == -1;
	 	 
	  else
		sum(<i,j> in Nbs) x[<i,j>] - sum(<i,j> in Nbs2) x[<i,j>] == 0;
				
 };
 
 {Arrete} Used={e|e in Arretes : x[e]==1}; 
 
execute
{
writeln("Used edges",Used);
}
 
 /*
 pr: 	
		forall(so in Sommets)
		  forall(ar in Arretes) 
			if(ar.i == so || ar.j == so)
				sum(<i,j> in Arretes) x[<i,j>] - sum(<i,j> in Arretes) x[<i,j>] == 0;
	de:
		forall(so in Sommets)
		  forall(ar in Arretes)
			if(ar.i == t || ar.j == t)
				sum(<i,j> in Arretes) x[<i,j>]  - sum(<i,j> in Arretes) x[<i,j>] == -1;
		
	tr:
		forall(so in Sommets)
		  forall(ar in Arretes)
			if(ar.i == s || ar.j == s)
				sum(<i,j> in Arretes) x[<i,j>] - sum(<i,j> in Arretes) x[<i,j>] == 1;
 
 */
 ////sum(i in Sub[s], j in Nbs[i] inter Compl[s]) x[<i,j>]- sum(i in Compl[s], j in Nbs[i] inter Sub[s]) x[<i,j>] == 0;
 
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
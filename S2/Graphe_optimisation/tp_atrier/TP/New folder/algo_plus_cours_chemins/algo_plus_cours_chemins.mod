int n =...;//nombre de sommet
int s =...;//sommet de départ
int t =...;//sommet de fin

range Sommets= 1 ..n;
tuple Arrete { int i;int j;}

{Arrete} Arretes with i in Sommets,j in Sommets=...;
int duree[Arretes] = ...;

int cout[Arretes] = ...;

{int} Nbs[i in Sommets]={j|<i,j> in Arretes};
{int} Nbs2[i in Sommets]={j|<j,i> in Arretes};

dvar boolean x[Arretes];

 minimize
sum(<i,j> in Arretes) duree[<i,j>] *x[<i,j>] >=10;
 
 subject to{
 	tt: 
	forall(i in Sommets)
	  if(i == s )
	  	sum(j in Nbs[i]) x[<s,j>] - sum(j in Nbs2[i]) x[<s,j>] == 1;
	  	
	  else if(i == t)
	 	 sum(j in Nbs[i]) x[<i,j>] - sum(j in Nbs2[i]) x[<j,i>] == -1;
	 	 
	  else
		sum(j in Nbs[i]) x[<i,j>] - sum(j in Nbs2[i]) x[<j,i>] == 0;
		
 };
 
 {Arrete} Used={e|e in Arretes : x[e]==1};
 int duree_t = sum(<i,j> in Arretes) duree[<i,j>]*x[<i,j>];
 int cout_t = sum(<i,j> in Arretes) cout[<i,j>]*x[<i,j>];
 
execute
{
writeln("Sommet utilisé: ",Used);
writeln("Duree : ",duree_t);
writeln("Cout : ",cout_t);
}
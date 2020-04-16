
int n=...;
range Nodes= 1..n;

tuple Edge{ int u; int v;}
{Edge} Edges with u in Nodes, v in Nodes=...;
{int} NbsIn[i in Nodes]={j|<i,j> in Edges};
{int} NbsOut[i in Nodes]={j|<j,i> in Edges};

dvar boolean x [Nodes];

minimize
sum(i in Nodes) x[i];

subject to{
	forall(i in Nodes)
x[i] + sum(j in NbsIn[i]) x[j] + sum(j in NbsOut[i]) x[j] >=1;
};	


{int} Dom={i|i in Nodes : x[i]==1};

execute
{
writeln("Dominant Sommets",Dom);
}


int n=...;
range Nodes= 1..n;

tuple Edge { int u; int v; }
{Edge} Edges with u in Nodes, v in Nodes=...;

dvar boolean x [Nodes];


maximize
	sum(i in Nodes) x[i];

subject to{
	forall (<u,v> in Edges)
		 x[u] + x[v] <= 1;
};	

{int} Stb={i|i in Nodes : x[i]==1};

execute
{
	writeln("Ensemble Stable",Stb);
}


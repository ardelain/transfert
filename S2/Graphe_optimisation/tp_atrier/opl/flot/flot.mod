/*********************************************
 * OPL 12.9.0.0 Model
 * Author: Windows
 * Creation Date: 19 Mar 2019 at 00:12:11
 *********************************************/
int NumNodes = ...;   // Number of nodes
range Nodes = 1..NumNodes;

// Get the supply (positive) and demand (negative)
// at each node

int SupDem[Nodes] = ...;

// Create a record to hold information about each arc
tuple arc {
key int fromnode;
key int tonode;
float cost;
float ub;
}

// Get the set of arcs

{arc} Arcs = ...;

// The network flow model has decision variables indexed on 
// the arcs.

dvar float+ Flow[a in Arcs] in 0 .. a.ub;

dexpr float TotalFlow = sum (a in Arcs) a.cost * Flow[a];
minimize TotalFlow;
subject to {
// Preserve flows at each node.  Note the use of slicing
forall (i in Nodes)
	ctNodeFlow:
       sum (<i,j,c,ub> in Arcs) Flow[<i,j,c,ub>]
     - sum (<j,i,c,ub> in Arcs) Flow[<j,i,c,ub>] == SupDem[i];
 }
 
 
 execute DISPLAY {
    writeln("\n<from node,to node,Flow[a]>\n");
    for(var a in Arcs)
       if(Flow[a] > 0)
         // writeln("<",a.fromnode,",",a.tonode,",",Flow[a],">");
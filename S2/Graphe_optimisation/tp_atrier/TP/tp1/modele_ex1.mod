/*********************************************
 * OPL 12.8.0.0 Model
 * Author: ardelain
 * Creation Date: 12 mars 2019 at 08:19:01
 *********************************************/
float temp;
dvar float+ x;
dvar float y;

execute{
	var before = new Date();
	temp = before.getTime();
}

minimize
4* x- 2* y;
subject to {
 x-y>=1;
}

execute{
	var after = new Date();
	writeln("solving time =",after.getTime()-temp);
}

execute{
	cplex.getObjValue()
}
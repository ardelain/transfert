/*********************************************
 * OPL 12.8.0.0 Model
 * Author: ardelain
 * Creation Date: 12 mars 2019 at 08:42:53
 *********************************************/

 {string} Products = ... ;
 {string} Factories = ... ;
 
 float r[Products]=...;
 float t[Products][Factories]=...;
 float c[Factories]=...;
 
 dvar float+ x[Products];
 
 maximize
 sum(p in Products) r[p]*x[p];
 
 subject to{
 forall(i in Factories)
   c1:
 	sum(p in Products) t[p][i]* x[p] <= c[i];   
 }
 
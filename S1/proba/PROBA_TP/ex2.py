import random
import numpy
import sys
sys.setrecursionlimit(5000)
from scipy.stats import norm
from scipy.optimize import fsolve
import matplotlib.pyplot as plt

from scipy.stats import norm
import boite_noire as bn

def genere_loi_tabulee(L_e,L_p,nb):
    L_p_added = []
    L_final = []
    for i in range(0,len(L_p)):
        if i==0:
            prec=0
        else:
            prec=L_p_added[i-1]
        L_p_added.append(prec+L_p[i])

    for i in range(0,nb):
        rand=random.uniform(0,1)
        for j in range (0,len(L_p_added)):
            if rand <= L_p_added[j]:
                L_final.append(L_e[j])
                break
    return L_final

def f(n):
    freq = 0
    for i in range(0,n):
        res = genere_loi_tabulee([0,1],[0.9,0.1],1)[0]
        if res == 1:
            freq = freq + 1
    return freq/n

def genere_n_f(n_essais_max):
    l = []
    th = numpy.arange(1,n_essais_max,1)
    y = numpy.arange(0,1,0.1)
    for i in range(1,n_essais_max+1):
        l.append(abs(f(i)-0.1))
    #plt.plot(l,'C1',label='f(n)-P(X=1)/P(X=1)')
    #plt.plot(th,numpy.divide(1,numpy.power(th,0.4)),'C2',label='approx')
    plt.plot(l,'C1',label='f(n)-P(X=1)')
    plt.plot(th,numpy.divide(1,numpy.power(13*th,0.5)),'C2',label='approx')
    plt.show()

def verif_rep(risque,alpha,N,nb_tests):
    L = (f(N) for i in range(nb_tests))
    L = (abs(u-0.1) for u in L)
    L = (1 for u in L if u >= alpha)
    return sum(L)/nb_tests

#Les parentheses sont mieux !!! Ne prend pas de mémoire (=itérateur)
#L = [f(N) for i in range(nb_tests)]
#L = [abs(u-0.1) for u in L]
#L = [1 for u in L if u > alpha]
#return sum(L)

#QUESTION 1
#L_e = [0,1]
#L_p = [0.9,0.1]
#R = [0]*N
#for cpt <- 1 à N
#   valeurs <- loi_tab(Le,Lp,cpt)
#   R[cpt-1] <- abs(valeurs.count(1)/cpt-0.1)
#
#N = 3   :   [0,0,1] R[0]=1/3   [1,1,1] R[1]=1   [0,1,1] R[2]=2/3
#-> Irrégulier, les points ne sont pas relatifs aux précédents
#On voit les points abérants, il n'influence pas la suite de la courbe
#

#L_e,l_p,R
#valeurs <- loi_tabulée(Le,Lp,N)
#R[0] = valeurs[0]
#for cpt<-1 to N
#   R[cpt]<-R[cpt-1] + valeurs(cpt)
#R = [abs(a/cpt - 0.1) for cpt,a in enumerate R]
#
#



def min_n(precision,fiabilite):
    alpha = 1 - fiabilite
    c = norm.ppf(1-alpha/2,loc = 0,scale = 1)
    nb_it = 30
    n = 0
    f = 0.25
    while(n < nb_it and n*f < 5 and n*(1-f) < 5):

        n = fsolve((x,(((c/(x*c^2))*sqrt(x*f*(x-f)+(c^2/4))-precision))),nb_it+10)
        nb_it = max(nb_it,n+1)
    return (nb_it,f)

#Pour jeu pocker
#fct_a_rep_0_1 sera
#carre = 4 1 ou full 2 3
#def carte_carre()
#   main = genere_main(jeu,5,1)[0]
#   verif main in toutes les mains qui contiennent un carré
#                           =prod cartésien des 1*4, 2*4... avec toutes les autres cartes

#QUESTION 13
#Plus la proba basse -> plus note hausse avec plafond 100
#Par exemple arctan & tan hyperbolique(plus simple, e^x-e^-x/e^x+e^-x) (recalées)


print("APPROCHE GRAPHIQUE")
print(f(250))

#print(genere_n_f(400))

print("VERIFICATION")
print(verif_rep(0.01,0.50,250,100000))

#print(min_n(0.95,0.01,(x=(1 if bn.quota()=='oui'else 0))))
#print(min_n(0.95,0.01))

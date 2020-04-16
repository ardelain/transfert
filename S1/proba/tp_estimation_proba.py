from scipy.stats import norm
import matplotlib.pyplot as plt
import random
import numpy
import sys
sys.setrecursionlimit(4444)
from scipy.optimize import fsolve
#import boite_noire as bn


###############################################################################################
#       TP : Estimation :
###############################################################################################

##plt.plot([7, 9, 5])
##plt.ylabel('Label 1')
##plt.show()

# -> les quotas : prendre des echantillions au hasard dans des categories

# Pour le poker:
# e = [0,1]
# p = [0.9, 0.1]

# erreur absolue : |(p(x = 1) - f(x))|

# erreur relative : (|p(x = 1) - f(x)|)/p(x = 1)

# P(|O - o| <= y) >= x

# asymptotique a 0, fonction ecrase plus vite si puissance denominateur supperieur a  1/(3.2n¹⁵)

#1)approche graphique

def gener_b(nb):
	L_realisations = []
	for i in range(0,nb):
		L_realisations.append(0)
	for y in range(1,nb):
		v = 0
		for i in range(1,n):
			r = random.uniform(0,1)
			if r < p:
				v = v + 1
				L_bin.append(1)
			else:
				L_bin.append(0)
		L_realisations[v] = L_realisations[v] + 1
	return L_realisations

def gener_l_t(e,p,nb):
        lt=[]
        lpadd = []
        for n in range(0,len(p)):
                if n != 0 :
                        pre = lpadd[n-1]
                else:
                        pre = 0
                lpadd.append(pre+p[n])
        for i in range(0,nb):
                r = random.uniform(0,1)
                for y in range(0,len(lpadd)):
                        if r <= lpadd[y] :
                                lt.append(e[y])
                                break
        return lt

#2)cration des outils
#3)
def frequence(nb):
        f = 0
        for n in range(0,nb):
                res = gener_l_t([0,1],[0.9,0.1],1)[0]#............................................................CHANGE VAL
                if res == 1:
                         f = f +1
        return f/nb

def gener_f(nbmax):
        L = []
        t = numpy.arange(L,nbmax,L)
        y = numpy.arange(0,1,0.1)
        for n in range(L,nbmax+1):
                L.append(abs(fraquence(n) - 0.1))
        plt.plot(L,'1',label='f(n)-P(X=1)')
        numpD = numpy.divide(L,numpy.power(13*t,0.5))
        plt.plot(t,numpD,'2',label='ENV')
        plt.show()

def verifierlareponse(r,a,nn,ntestes):
        LV = []
        for n in range(ntestes):
                LV.append(frequence(nn))
        LV2 = []
        for n in LV:
                LV2.append(abs(n-0.1))
        for n in range(0,len(LV2)-1):
                if a <= n:
                        LV2[n] = 1
        return sum(LV2)/ntestes

####################################

def min_(pre,fiab):
##        a = 1 - fiab
##        b = norm.ppf(1-a/2,l=0,sc=1)
##        nbi = 30
##        n = 0
##        fr = 0.25
##        while(n<nbi and n*fr < 5 and n*(1-fr)):
##                n= fsolve((x,(((b/(x*c^2))*sqrt(x*fr*(x-fr)+(c^2/4))-pre))),nbi+10)
##                nbi = max(nbi,n+1)
        return 0##(nb,fr)

###############################################################################################

#-> Irrégulier, les points ne sont pas relatifs aux précédents

#Q13 plus la probabilite est basse plus la note est haute (max 100)

###############################################################################################
#EXEC :

print("#################################")

print(frequence(250))

print("#################################")

print(verifierlareponse(0.01,0.50,250,100000))

print("#################################")

print(min_(0.95,0.01))

print("#################################")



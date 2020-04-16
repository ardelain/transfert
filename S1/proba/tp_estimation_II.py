from scipy.stats import norm
import matplotlib.pyplot as plt
import random
import csv
import numpy as np
import TP3_etu as et
###############################################################################################
#       TP : Estimation II :
###############################################################################################
# timeit -> temps moyen d'xecution -> voir mediane


#estimateur teta --> faire pour 100 000 valeurs (significativement plus plus grand que N)
#ici N = 100
#T=[]
#for h = 0 to limite donnée par le tamps dispo
    #T.append( estimer TETA)
# calc moyen (T[h]-TETA)/TETA

def estimateur(nbs):
    L = []
    for i in range(100):
        L.append(i )
    ni = 2 * np.means(L) -1;
    return

n = et.impossible()
nbs = []
for i in range(0,100):
    nbs.append(et.impossible())
print (n)
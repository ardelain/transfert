#################################################################################
#################################################################################
import random
import sys
import numpy
from scipy.stats import norm
import matplotlib.pyplot as plt
sys.setrecursionlimit(4444)
#################################################################################
#################################################################################
        
# TP1 Probabilité et statistique : Génération de variable aléatoire.
       
#################################################################################
#################################################################################
        
L = [4,13,42]
A = [0]*75 #liste de 75 de 0

L_e =["toto",22,"chat","mange"]
L_p =[0.1,0.4,0.2,0.3]
nb = 5#si grand stockage L_c en memoire
L_c =[0.1,0.5,0.7,1] #de L_p  --> a construire dans la methode
#alpha dans ]0,0.1] -> 0.1
#alpha dans ]0.1,0.5] -> 0.4
#alpha dans ]0.5,0.7] -> 0.2
#alpha dans ]0.7,1] -> 0.1

#nrandom = random.randint(a,b);
#nrandom = random.uniform(a,b);
       
#################################################################################
#################################################################################        

def genere_loi_tabulee(L_evenements,L_probas,nb):
	sortie = []
	L_cc = []
	var = 0
	for i in range(0,len(L_probas)):
		if i == 0:
			var = L_probas[i]
		else :
			var = L_cc[-1] + L_probas[i]
		L_cc.append(var)
	#print (L_cc)
	for i in range(0,nb):
		r = random.uniform(0,1)
		for i in range(0,len(L_cc)):
			if r <= L_cc[i] :
				sortie.append(L_evenements[i])
	return sortie


def gener_binomiale(n,p,nb):
	L_realisations = []
	L_bin = []
	for i in range(0,n):
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
	#print (L_bin)
	return L_realisations

def gener_arrangement(n,nb):
	res = []
	res.extend(range(0,n+1))
	#print(res)
	L_realisations = []
	for i in range(0,nb):
		v = random.randrange(0,n-1,1)
		#v = round(random.uniform(0,n-1))#-1
		res[v],res[i] = res[i],res[v]
		L_realisations.insert(i,res[i])
	return L_realisations

def gener_arrangement_w(n,nb):
        if (n<=0 or nb>n):
                print("pb")
                return
        p = [1/n]*(n-1)
        return genere_loi_tabulee(range(0,n),p,nb)

def produit_cartesien(E1,E2):
	res = ()
	for i in range(0,len(E2)):
		for y in range(0,len(E1)):
			tup1 = tuple([(E2[i],E1[y])])
			res = res + tup1 #.append([E1[i],E1[y]])
	return res

def creer_jeu():
        cartes=[]
        #tup = produit_cartesien(["As",2,3,4,5,6,7,8,9,10,"Valet","Dame","Roi"],["Coeur","Pic","Carreau","Trefle"])
        ensemble = ["Coeur","Pic","Carreau","Trefle"]
        valeur = ["As","Valet","Dame","Roi"]
        valeur.extend(range(2,11))
        carthes_pd = []
        for i in ensemble:
                for y in valeur:
                        carthes_pd.append((i,y))      
        cartes.extend(carthes_pd)#produit_cartesien(ensemble,valeur)
        return cartes
        
#################################################################################
#################################################################################
        
#2.2
#print (genere_loi_tabulee(L_e,L_p,nb))

#2.3
#print (gener_binomiale(2,0.25,10))
#plt.plot(gener_binomiale(2,0.25,10))
#plt.ylabel('Label 1')
#plt.show()

#3.1
#print (gener_arrangement(52,50))
#print ("****************************************************************************************************")
jeu = creer_jeu()
print (jeu)
##print (len(jeu))
print("****************************************************************************************************")


#tirer dans le meme jeu
def gener_main_w(j,nb,nbmains):
        #...
        return 0

#tirer dans un jeu neuf
def gener_main(j,nb,nbmains):
        #...
        return 0

#BARB
def elem_iterable(e,n,p):
        #...
        return 0

def gener_barb(f):
        #...
        return 0

#Marche Aleatoire
def marche_alea_l(j,nb,nbmains):
        #...
        return 0

#Souris et labyrinthe
def afficher_lab(l):
        #...
        return 0

def souris_deplacement(l):
        #...
        return 0

def souris_avance(l,p,n):
        #...
        return 0


#Demonstration (generer /demontrer)
def demontrer(regle,theo,THEO):
        #...
        return 0
def generer(nb):
        #...
        return 0
def genere_interessant(nb):
        #...
        return 0

def generer_test(n):
        #...
        return 0
#TAQUIN
def soluble(l):
        #...
        return 0

def melangetaquin(n,p):
        #...
        return 0

def demontrer(t,p):
        #...
        return 0

#MOTS
def nb_chiffre(l,p,n):
        #...
        return 0

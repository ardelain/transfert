#!/usr/bin/python
# -*- coding: utf-8 -*
import numpy as np
import matplotlib.pyplot as plt
import csv
import random

from scipy import optimize
from scipy.stats  import norm



def impossible():
     maxi = random.randint(10,12345678)
     def closure():
        return random.randint(1,maxi)
     return closure


def recupere_csv(mon_nom_fichier):
     def retype(chaine):
          ch = chaine.strip()
          ch = ch.replace(',','.',1)
          try:
               return int(ch)
          except ValueError:
               try:
                    return float(ch)
               except ValueError:
                    return ch
          
     raw_data = []
     with open(mon_nom_fichier, newline='') as csvfile:
          spamreader = csv.reader(csvfile, delimiter='\t', quotechar='|')
          for row in spamreader:
               raw_data.append(row)
   
     raw_data = [[retype(c) for c in l ] for l in raw_data]
     return raw_data


def erreur_quadratique(modele_choisi, p, donnees):
# ###############################################################################
# # Synopsis :                                                                  #
# # Calcule la moyenne des erreurs quadratiques pour un modèle                  #
# # défini par 'modèle_choisi' et ses paramètres 'p' sur un ensemble de données #
# ###############################################################################
#                                                                                
# #########################################################################      
# # Entrées                                                               #      
# # modèle choisi est une fonction qui prend en entrée :                  #      
# # 1) x un tuple (qui représente une suituation)                         #      
# # 2) param un tuple (qui représentent les paramètres du modèle)         #      
# # qui renvoie la valeur du modèle (un float) dans la situation indiquée #      
# # avec les paramètres choisis                                           #      
# #                                                                       #      
# # p est un tuple contenant les paramètres du modèle                     #      
# # données est une liste contenant les couples (situation, réponse)      #      
# # où les situations sont des tuples de float                            #      
# #########################################################################      
#                                                                                
# ####################################                                           
# # Sortie                           #                                           
# # moyenne des erreurs quadratiques #                                           
# ####################################                                           

     erreurs = ((y - modele_choisi(x, p))**2 for (x,y) in donnees)
     return sum(erreurs)/len(donnees)


def recherche_param(data, F,  extremes_graine, nb_graines=1 ):
##################################################################################################
# Synopsis :                                                                                     #
# Renvoie les paramètres qui permettent d'atteindre un minimum                                   #
# local de la moyenne des erreurs quadratiques lors d'une régression                             #
# des données contenues dans data                                                                #
##################################################################################################

##################################################################################################
# Remarque :                                                                                     #
# Il peut être intéressant de modifier le solveur utilisé,                                       #
# ce qui peut alors imposer d'ajouter des entrées (jacobien, hessienne)                          #
##################################################################################################

###################################################################################################
# Entrées :                                                                                       #
# data est une liste dont les éléments sont des couples (u,v)                                     #
# 1) tous les 'u' sont des tuples de floats de même dimension (n)                                 #
# qui représentent une situation connue                                                           #
# 2) tous les 'v' sont des floats qui représentent une réponse                                    #
# adaptée à la situation connue 'u'                                                               #
#                                                                                                 #
# F est une fonction dont les entrées sont :                                                      #
# - x     : un tuple de dimension 'n'                                                             #
# - param : un tuple                                                                              #
# et qui renvoie                                                                                  #
# - un float                                                                                      #
#                                                                                                 #
# extremes_graines est un couple  (min_domaine, max_domaine) où                                   #
# min_domaine est un tuple indiquant les valeurs minimales (a priori) de param,                   #
# et max_domaine ses valeurs maximales                                                            #
# Attention : s'il n'y a qu'un paramètre, par exemple a pripori dans [1, 2],                      #
# alors extremes_graine = ((1,),(2,)) (il faut que ce soient des listes, et (1)                   #
# n'est pas interprété comme une liste)                                                           #
#                                                                                                 #
# nb_graines est un paramètre optionnel dan IN tel que, plus il est haut,                         #
# plus il y a de chances que la fonction renvoie une solution de bonne qualité.                   #
# Il correspond au nombre de fois où l'algorithme de recherche de minimisation                    #
# va être relancé, en partant d'une nouvelle graine                                               #
###################################################################################################

####################################################################################################
# Sortie :                                                                                         #
# recherche_param va rechercher un tuple 'param' qui permet d'obtenir les                          #
# paramètres qui permettent de faire coller au mieux les 'f(u)' et les 'v' :                       #
# $$Argmin_{param}\left(\sum_{(u, v)\, \in\, data_{x}}                                             #
# \left(F(u, param)-v\right)^{2}\right)$$                                                          #
###################################################################################################
     
     result =[0]*nb_graines
     premier = True
     for cpt in range(nb_graines):
          graine = [np.random.uniform(extremes_graine[0][k],
                                      extremes_graine[1][k])
                    for k in range(len(extremes_graine[0]))]
          tmp = optimize.minimize(lambda p:  erreur_quadratique(F,p,data),
                                  graine,
                                  method='nelder-mead')['x']
          if premier:
               result = tmp
               erreur_result = erreur_quadratique(F, result, data)
               premier = False
          else:
               erreur_tmp =  erreur_quadratique(F, tmp, data)
               if erreur_tmp < erreur_result :
                    result = tmp
                    erreur_result = erreur_quadratique(F, result, data)
     return result


def genere_droite_bruitee(n):
# #########################################################
# # Synopsis :                                            #
# # Génere 'n' données sur la droite  $y = -3 x^{2}-5x+2$ #
# # puis les perturbe les ordonnées d'un tout petit peu   #
# #########################################################
#                                                         
# ######################################                  
# # Entrée :                           #                  
# # n : le nombre de couples à générer #                  
# ######################################                  
#                                                         
# ########################################################
# # Sortie :                                             #
# # une liste de n couples, dont la première composante  #
# # est un tuple de UN élément (valeur de l'abscisse) et #
# # l'ordonnée un float (valeur de l'ordonnée)           #
# ########################################################
     return 'A faire'


def separe(L):
####################################################################
# ##################################################################
# # Synopsis :                                                     #
# # Prend une liste en entrée et la sépare een deux listes,        #
# # chaque élément de la liste de départ a une chance sur 2 d'être #
# # dans la première ou dans la deuxième                           #
# ##################################################################
#                                                                   
# #####################                                             
# # Entrée:           #                                             
# # La liste complète #                                             
# #####################                                             
#                                                                   
# #######################################                           
# # Sortie :                            #                           
# # Un couple contenant les deux listes #                           
# #######################################                           
####################################################################
     return 'A faire'




def modele_1(situation, param):
# ########################################################## 
# # Synopsis :                                             # 
# # Renvoie la valeur du modèle (un float), connaisant la  # 
# # situation  ainsi que les paramètres du modèle          # 
# ########################################################## 
#                                                            
# ###########################################################
# # Entrees :                                               # 
# # situation : un tuple de float représentant la situation #
# # param : un tuple de float représentant les paramètres   #
# ###########################################################
#                                                            
# #############                                              
# # Sortie :  #                                              
# # un float  #                                              
# #############
     return 'A faire'


def genere_deux_variables(n):
     return 'A faire'


def modele_deux_variables(x, param):
     return 'A faire'

def modele_polynome_reel(situation, param):
     return 'A faire'







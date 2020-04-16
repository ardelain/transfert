from random import randint
import sys

def afficher_matrice(matrice):
    for i in range(len(matrice)):
        print(matrice[i])
    print("")

#Définition des différentes statégies
#Returns 0 pour coopérer/se taire, 1 pour trahir/denoncer
def strat_gentille(coup_precedent_autre):
    return 0

def strat_mechante(coup_precedent_autre):
    return 1

def strat_lunatique(coup_precedent_autre):
    return randint(0,1)

def strat_donnant_donnant(coup_precedent_autre):
    if coup_precedent_autre is None:
        return 0
    return coup_precedent_autre

#Comparaison des stratégies deux à deux grâce à la méthode du tournoi

#Méthode faisant jouer une stratégie contre une autre sur n coups
def play_vs(n,strat1,strat2):
    coups1=[]
    coups2=[]
    coups1.append(strat1(None))
    coups2.append(strat2(None))
    for i in range(n-1):
        coups1.append(strat1(coups2[i]))
        coups2.append(strat2(coups1[i]))
    return (coups1,coups2)

#Méthode réccupérant les points de chaque joueur en fonction de leur coup
#Grâce à la matrice des gains
def get_points_from_coups(matrix,n,coups1,coups2):
    points1=[]
    points2=[]
    for i in range(n):
        #Retrouver le score dans la matrice
        #ligne = coupJ1 ; colonne = coupJ2 ; coup=0 pour coop, 1 pour dénoncer
        #0 ou 1 si J1 ou J2
        points1.append(matrix[coups1[i]][coups2[i]][0])
        points2.append(matrix[coups1[i]][coups2[i]][1])
    return (points1,points2)

#Méthode du tournoi
def tournoi(n,matrix):
    strats=[strat_gentille,strat_mechante,strat_lunatique,strat_donnant_donnant]
    matrice_gains_I=[0]*4
    for i in range(4):
        matrice_gains_I[i]=[0]*4
    matrice_gains_II=[0]*4
    for i in range(4):
        matrice_gains_II[i]=[0]*4

    for i in range(len(strats)):
        for j in range(len(strats)):
            #sys.stdout.write(strats[i].__name__+" "+strats[j].__name__+"\n")
            (coups1,coups2) = play_vs(n,strats[i],strats[j])
            (points1,points2) = get_points_from_coups(matrix,n,coups1,coups2)
            #sys.stdout.write("Le total pour le joueur I est "+str(sum(points1))+"\n")
            #sys.stdout.write("Le total pour le joueur II est "+str(sum(points2))+"\n\n")
            matrice_gains_I[i][j]=sum(points1)
            matrice_gains_II[i][j]=sum(points2)
    return (matrice_gains_I,matrice_gains_II)

def calculs_gains_strats(an,bn,cn,dn,matrice_gains):
    #CALCUL des en, où e={a,b,c,d} les effectifs des différentes stratégies
    an = 250
    bn = 250
    cn = 250
    dn = 250
    #effectif total
    e = an+bn+cn+dn
    sys.stdout.write("Effectifs à la génération n: "+str(an)+"\t"+str(bn)+"\t"+str(cn)+"\t"+str(dn)+"\t\t\n")
    sys.stdout.write("tot e ="+str(e)+"\n")

    #CALCUL des points gagnés à la génération n par chacune des stratégies
    G_A_n = (an-1)*matrice_gains[0][0]+bn*matrice_gains[0][1]+cn*matrice_gains[0][2]+dn*matrice_gains[0][3]
    G_B_n = an*matrice_gains[1][0]+(bn-1)*matrice_gains[1][1]+cn*matrice_gains[1][2]+dn*matrice_gains[1][3]
    G_C_n = an*matrice_gains[2][0]+bn*matrice_gains[2][1]+(cn-1)*matrice_gains[2][2]+dn*matrice_gains[2][3]
    G_D_n = an*matrice_gains[3][0]+bn*matrice_gains[3][1]+cn*matrice_gains[3][2]+(dn-1)*matrice_gains[3][3]
    sys.stdout.write("Gains à la génération n : A="+str(G_A_n)+"\tB="+str(G_B_n)+"\tC="+str(G_C_n)+"\tD="+str(G_D_n)+"\t\n")
    #Calcul du total de spoints gagnés à la génération n par toutes les strats
    tn = an*G_A_n+bn*G_B_n+cn*G_C_n+dn*G_D_n
    sys.stdout.write("Total des points à la génératon n ="+str(tn)+"\n")

    #Effectifs n+1
    an_1 = (e*an*G_A_n)/tn
    bn_1 = (e*bn*G_B_n)/tn
    cn_1 = (e*cn*G_C_n)/tn
    dn_1 = (e*dn*G_D_n)/tn
    #effectif total, égal à celui de départ
    e_1 = an_1+bn_1+cn_1+dn_1
    sys.stdout.write("Effectifs à la génération n+1 "+str(an_1)+"\t"+str(bn_1)+"\t"+str(cn_1)+"\t"+str(dn_1)+"\t\t\n")
    sys.stdout.write("tot e="+str(e_1)+"\n")

#PREMIERE MATRICE DU PRISONNIER
sys.stdout.write("Premiere matrice du dilemme du prisonnier :\n")
matrix=[[(2,1),(-5,4)],[(3,-2),(-2,-1)]]
afficher_matrice(matrix)
(matrice_gains_I,matrice_gains_II) = tournoi(1000,matrix)

#POUR LE JOUEUR I
sys.stdout.write("JOUEUR I \n Matrice de gains :\n")
afficher_matrice(matrice_gains_I)
calculs_gains_strats(250,250,250,250,matrice_gains_I)
sys.stdout.write("La stratégie D, donnant-donnant donne le plus de points\n\n")
#POUR LE JOUEUR II
sys.stdout.write("JOUEUR II\n Matrice de gains : \n")
afficher_matrice(matrice_gains_II)
calculs_gains_strats(250,250,250,250,matrice_gains_II)
sys.stdout.write("La stratégie A, gentille donne le plus de points\n\n")
sys.stdout.write("On peut en conclure ici, qu'il est effectivement plus "+\
"bénéfique pour les deux joueurs de coopérer\n\n\n")


#DEUXIEME MATRICE DU PRISONNIER
sys.stdout.write("Deuxième matrice du dilemme du prisonnier :\n")
matrix=[[(3,3),(0,5)],[(5,0),(1,1)]]
afficher_matrice(matrix)
(matrice_gains_I,matrice_gains_II) = tournoi(1000,matrix)

#POUR LE JOUEUR I
sys.stdout.write("JOUEUR I \n Matrice de gains :\n")
afficher_matrice(matrice_gains_I)
calculs_gains_strats(250,250,250,250,matrice_gains_I)
sys.stdout.write("La stratégie B, méchante donne le plus de points\n\n")
#POUR LE JOUEUR II
sys.stdout.write("JOUEUR II\n Matrice de gains : \n")
afficher_matrice(matrice_gains_II)
calculs_gains_strats(250,250,250,250,matrice_gains_II)
sys.stdout.write("La stratégie A, gentille donne le plus de points\n\n")
sys.stdout.write("Ici, pour le joueur I la stratégie méchante domine mais la "+\
"donnant-donnant la chevauche.\n")
sys.stdout.write("On peut donc également en conclure qu'il est "+\
"préférable pour les deux joueurs de coopérer\n\n\n")

import random
import numpy
import sys
import matplotlib.pyplot as plt

sys.setrecursionlimit(5000)



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


def genere_binomiale(n,p,nb):
    if (n<0 or p<=0 or p>1):
        print("erreur")
        return -1
    L_real = []
    for i in range(0,nb):
        L_real.append(numpy.random.binomial(n, p))
    return L_real

#MELANGE
#Pas juste techniquement,
##car on peut piocher 2 fois la même chose alors qu'il n'y a pas de remise
##+ trop long car quand il reste peu de cartes, il peut mettre longtemps à trouver la derniere
def genere_arrangement_wrg(n,nb):
    if (n<=0 or nb>n):
        print("erreur")
        return -1
    L_p = [1/n] * (n-1)
    return genere_loi_tabulee(range(0,n),L_p,nb)

def genere_arrangement(n,nb):
    if (n<=0 or nb>n):
        print("erreur")
        return -1
    list = []
    main = []
    list.extend(range(0,n))
    for k in range(0,nb):
        i = random.randrange(k,n,1) #n-1 to n
        list[i], list[k] = list[k], list[i]
        main.insert(k,list[k])
    return main

def produit_cartesien(E1,E2):
    couples = []
    for i in E1:
        for j in E2:
            couples.append((i,j))
    return couples

def creer_jeu():
    cartes = []
    bois = ["pic","carreau","coeur","trefle"]
    val = ["as","valet","dame","roi"]
    val.extend(range(2,11))
    cartes.extend(produit_cartesien(bois,val))
    return cartes

#Tirer dans le même jeu
def genere_mains_wrg(jeu,nb_cartes,nb_mains):
    L_real = []
    main_valid = False
    pb = False
    for i in range(0,nb_mains):
        main_valid = False
        main = []
        while(main_valid == False):
            main = []
            arrangement = genere_arrangement_wrg(len(jeu),nb_cartes)
            if arrangement != -1:
                for j in arrangement:
                    pb = False
                    if jeu[j] in main:
                        pb = True
                        break
                    main.append(jeu[j])
                if pb == False and len(main) == 5:
                    for m in main:
                        jeu.remove(m)
                    main_valid = True
            else:
                print("Pb arrangement : trop de cartes demandées pour le jeu")
                return -1
        L_real.append(main)
    return L_real

#Tirer dans un jeu neuf
def genere_mains(jeu,nb_cartes,nb_mains):
    L_real = []
    for i in range(0,nb_mains):
        main = []
        arrangement = genere_arrangement(len(jeu),nb_cartes)
        if arrangement != -1:
            for j in arrangement:
                main.append(jeu[j])
        else:
            print("Pb arrangement : trop de cartes demandées pour le jeu")
            return -1
        L_real.append(main)
    return L_real

#BARB
#n elements aléatoires? de E^p
def element_from_iterable(E,n,p):
    if n<0 or p<0:
        print("erreur")
        return -1
    #Att p = 0
    L_real = []
    L_real.extend(E)
    liste_finale = []
    for i in range(1,p):
        L_real.extend(produit_cartesien(L_real,E))
    arr = genere_arrangement(len(L_real),n)
    if arr == -1:
        return -1
    print(L_real)
    for a in arr:
        liste_finale.append(L_real[a])
    return liste_finale


def genere_barb(feuilles):
    p_r1 = 1/4
    p_r2 = 1/4
    p_r3 = 1 - p_r1 - p_r2
    p_regles = [p_r1,p_r2,p_r3]
    r = genere_loi_tabulee([1,2,3],p_regles,1)[0]
    if r == 1:
        return [genere_loi_tabulee(feuilles,[1/len(feuilles)]*len(feuilles),1)[0],p_r1]
    elif r == 2:
        return [[],p_r2]
    else:
        a_gauche = genere_barb(feuilles)
        a_droit = genere_barb(feuilles)
        return [[a_gauche[0],a_droit[0]],p_r3*a_gauche[1]*a_droit[1]]



#Marche aléatoire
def marche_aleatoire_ligne():
    #aller à gauche -> 1
    #x>0 -> x+1
    #0 sinon
    #aller à droite -> 2
    #x<9 -> x-1
    #0 sinon
    Lf= {1:{0:[1,0]},2:{-9:[-1,0]}}


#Souris et labyrinthe
def afficher_lab(lab):
    for l in lab:
        for c in l:
            sys.stdout.write(str(c))
        print("")
    print("")
def where_can_mouse_go(lab_souris):
    directions = []
    for i in range(0,len(lab_souris)):
        for j in range(0,len(lab_souris[i])):
            if lab_souris[i][j] == "S":
                if j+1 < len(lab_souris[i]) and lab_souris[i][j+1] == 1:
                    directions.append([0,1])
                if j-1 >=0 and lab_souris[i][j-1] == 1:
                    directions.append([0,-1])
                if i+1 < len(lab_souris) and lab_souris[i+1][j] == 1:
                    directions.append([1,0])
                if i-1 >=0 and lab_souris[i-1][j] == 1:
                    directions.append([-1,0])
    return directions
#Par default, direction = Est
#-1,0 Nord, 1,0 Sud, 0,1 Est, 0,-1 Ouest
def avancer_souris_lab(lab,pos,n):
    lab_souris = lab.copy()
    if lab_souris[pos[0]][pos[1]] != 0:
        lab_souris[pos[0]][pos[1]] = "S"
    else:
        print("erreur de position")
        return -1
    directions = [1,2,3,4]
    direction = [0,1]
    position = pos.copy()
    afficher_lab(lab_souris)
    for i in range(0,n):
        L_e = []
        L_p = []
        possible_directions = where_can_mouse_go(lab_souris)
        if direction in possible_directions:
            L_e.append(direction)
            L_p.append((2/3) if len(possible_directions) != 1 else 1)
            possible_directions.remove(direction)
            for d in possible_directions:
                L_e.append(d)
                L_p.append((1/3)/len(possible_directions))
        else:
            for d in possible_directions:
                L_e.append(d)
                L_p.append(1/len(possible_directions))
        direction = genere_loi_tabulee(L_e,L_p,1)[0]
        lab_souris[position[0]+direction[0]][position[1]+direction[1]] = "S"
        lab_souris[position[0]][position[1]] = 1
        position = [position[0]+direction[0],position[1]+direction[1]]
        afficher_lab(lab_souris)
    return position

#DEMONSTRATION AUTO
#Ne peut pas fonctionner car on ne peut pas savoir quelle règle a été utilisée
def demontrer_th(regles,th,th_base):
    sys.stdout.write("Le theoreme "+th+"se demontre par :\n")
    while(th != th_base):
        for r,v in regles.items():
            if v in th:
                sys.stdout.write(th+" devient ")
                th = th.replace(v,r,1)
                sys.stdout.write(th+"\n")
    print("Voilà !")
    print("")
#demontre nb théorèmes de manière aléatoire
def generer_th(nb):
    th_base = "MI"
    regles = {"I":["IU","IUIU"],"II":["U"],"UU":[""],"UIIU":["I"]}
    ths = [th_base]
    #Appliquer une règle aleat. à un th choisi aléatoirement
    while len(ths) != nb+1:
        th = genere_loi_tabulee(ths,[1/len(ths)]*len(ths),1)[0]
        for r,v in sorted(regles.items(), key=lambda x: random.random()):
            if r in th:
                value = genere_loi_tabulee(v,[1/len(v)]*len(v),1)[0]
                #Replace first occurence
                if th.replace(r,value,1) not in ths:
                    sys.stdout.write(th+" devient "+th.replace(r,value,1)+" grâce à la regle "+\
                    r+" -> "+value+"\n")
                    ths.append(th.replace(r,value,1))
                    break
    ths.remove('MI')
    return ths

def generer_th_interessant(nb):
    #ths = []
    #while len(ths) != nb:
    #    ths.extend(generer_th(nb-len(ths)))
    #    ths = list(set(ths))
    #    for th in ths:
    #        if len(th) > 10:
    #            ths.remove(th)
    #return ths
    graphe = {}
    th_base = "MI"
    regles = {"I":["IU","IUIU"],"II":["U"],"UU":[""],"UIIU":["I"]}
    ths = [th_base]
    #Appliquer une règle aleat. à un th choisi aléatoirement
    while len(ths) != nb+1:
        th = genere_loi_tabulee(ths,[1/len(ths)]*len(ths),1)[0]
        for r,v in sorted(regles.items(), key=lambda x: random.random()):
            if r in th:
                value = genere_loi_tabulee(v,[1/len(v)]*len(v),1)[0]
                #Replace first occurence
                new_th = th.replace(r,value,1)
                if new_th not in ths and len(new_th) <10:
                    sys.stdout.write(th+" devient "+new_th+" grâce à la regle "+\
                    r+" -> "+value+"\n")
                    if th not in graphe:
                        graphe[th] = []
                    graphe[th].append(new_th)
                    ths.append(new_th)
                    break
    ths.remove('MI')
    print(graphe)
    return ths

def genere_th_test(nb):
    ths = []
    while len(ths) != nb:
        ths.extend(generer_th_interessant(nb-len(ths)))
        ths = list(set(ths))
        for th in ths:
            if len(th) > 10:
                ths.remove(th)
    return ths

#TAQUIN
def is_soluble(taquin_list):
    n = 0
    a = taquin_list.index('V')
    pos = a
    taquin_list[len(taquin_list)-1], taquin_list[a] = taquin_list[a], taquin_list[len(taquin_list)-1]

    n = n+1
    for i in range(len(taquin_list)-1,0,-1):
        a = taquin_list.index(i)
        taquin_list[i-1], taquin_list[a] = taquin_list[a], taquin_list[i-1]
        n= n+1
    if n % 2 == (len(taquin_list)-(pos+1)) % 2 :
        return True
    return False

def melange_taquin(n,p):
    m = 0
    taquin_tab=[0]*n
    for i in range(n):
        taquin_tab[i] = [0] * p
    is_soluble_b = False
    while is_soluble_b != True:
        #possible si permutation paire
        list_taquin = genere_arrangement(n*p,n*p)
        list_taquin = [x+1 for x in list_taquin]
        a = list_taquin.index(n*p)
        list_taquin[a] = "V"
        is_soluble_b = is_soluble(list_taquin.copy())

    for i in range(0,n):
        for j in range(0,p):
            taquin_tab[i][j] = list_taquin[m]
            m = m + 1
    print(taquin_tab)

def atteignables_taquin(taquin_tab,pos):
    list = []
    if pos[1]+1 < len(taquin_tab[0]) -1:
        list.append(taquin_tab[pos[0]][pos[1]+1])
    if pos[1]-1 >= 0:
        list.append(taquin_tab[pos[0]][pos[1]-1])
    if pos[0]+1 < len(taquin_tab) -1:
        list.append(taquin_tab[pos[0]+1][pos[1]])
    if pos[0]-1 >= 0:
        list.append(taquin_tab[pos[0]-1][pos[1]])
    return list

#MOTS
#renvoie dans un tableau le nombre de chaque chiffre du prefixe
def nombre_chiffre(prefixe):
    list = [0]*10
    for c in prefixe:
        list[int(c)] = list[int(c)] + 1
    return list


#METHODE
print("METHODE")
L_e = ["toto",22,"chat","mange"]
L_p = [0.1,0.4,0.2,0.3]
nb=5
print(genere_loi_tabulee(L_e,L_p,nb))
print(genere_binomiale(2,0.5,5))
#plt.plot([4,13,42], [0.25,0.5,1], 'ro')
#plt.axis([0, 43, 0, 1])
#plt.plot([0.25,0.5,1],[4,13,42], 'ro')
#plt.axis([0, 1, 0, 43])
#plt.show()
print("")

#MELANGE
print("MELANGE")
print(genere_arrangement(52,5))
print(creer_jeu())
jeu = creer_jeu()
#mains = genere_mains(jeu,15,2)
#print(mains)
print("")

#BARB
print("BARB")
print(element_from_iterable([1,2],2,2))
print("")
barb = genere_barb([1,2])
print(barb[0])
sys.stdout.write("Proba : "+str(barb[1])+"\n")
print("")
#Marche

#SOURIS
print("SOURIS")
lab = [[0,0,1,0],[1,1,1,1],[0,0,1,0]]
avancer_souris_lab(lab,[1,0],5)
print("")

#DEMONTRER THS
print("THEOREMES")
print(generer_th(6))
print("")
#max 228
print(generer_th_interessant(5))
print("")

#TAQUIN
print("TAQUIN")
melange_taquin(4,4)
print("")

#MOTS
print("MOTS")
print(nombre_chiffre("1123345678889"))

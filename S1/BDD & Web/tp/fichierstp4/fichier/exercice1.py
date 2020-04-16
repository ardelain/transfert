#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Importation de l'API.
import xml.etree.ElementTree as ET

# Chemin vers le fichier xml.
FILE = 'championnat.xml'

# Création du parser et récupération de l'arbre XML du document.
root = ET.parse(FILE).getroot()

#E1Q1 -> Elle renvoit les fils directes de championnat
#Leur tag ('clubs','journees') et leurs attributs (ici vides).
def afficher_enfants(subtree):
    for child in subtree:
        print (child.tag, child.attrib)
        #foreach club
        for club in child.findall('club'):
            att_id = club.attrib['id']
            nom = club.find('nom').text
            ville = club.find('ville').text
            #On affiche le Nom l'Id et la Ville
            print("Nom : "+nom+"("+att_id+")	Ville : "+ville)
            #foreach journée
        for journee in child.findall('journee'):
            att_num = journee.attrib['num']
            date_journee = journee.find('date').text
            #On afficher son Num, et sa date
            print("Journee "+att_num+" le "+date_journee)
            #foreach rencontre de chaque journée
            for rencontre in journee.findall('rencontre'):
            	club_rec = rencontre.find('clubReceveur').text
    	        club_inv = rencontre.find('clubInvite').text
            	score = rencontre.find('score').text
            	#On affiche les clubs participant et le score
            	print("		Rencontre entre :")
            	print("		"+club_rec+"(rec) et "+club_inv+"(inv)")
            	print("		score : "+score)
			
afficher_enfants(root)

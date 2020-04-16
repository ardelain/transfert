#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Importation de l'API.
import xml.etree.ElementTree as ET

# Chemin vers le fichier xml.
FILE = 'championnat.xml'

# Création du parser et récupération de l'arbre XML du document.
root = ET.parse(FILE).getroot()

#E1Q1 -> La fonction renvoit les enfants directes de championnat
#Leur tag ('clubs','journees') ainsi que leurs attributs (ici vides).
def afficher_enfants(subtree):
    for child in subtree:
        print (child.tag, child.attrib)
        for club in child.findall('club'):
            att_id = club.attrib['id']
            nom = club.find('nom').text
            ville = club.find('ville').text
            print("Nom : "+nom+"("+att_id+")	Ville : "+ville)
        for journee in child.findall('journee'):
            att_num = journee.attrib['num']
            date_journee = journee.find('date').text
            print("Journee "+att_num+" le "+date_journee)
            for rencontre in journee.findall('rencontre'):
            	club_rec = rencontre.find('clubReceveur').text
    	        club_inv = rencontre.find('clubInvite').text
            	score = rencontre.find('score').text
            	print("		Rencontre entre :")
            	print("		"+club_rec+"(rec) et "+club_inv+"(inv)")
            	print("		score : "+score)
			
afficher_enfants(root)

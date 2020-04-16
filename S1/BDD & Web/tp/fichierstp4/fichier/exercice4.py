#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Importation de l'API.
import xml.etree.ElementTree as ET

# Chemin vers le fichier xml.
FILE = 'championnat.xml'

# Création du parser et récupération de l'arbre XML du document.
root = ET.parse(FILE).getroot()

#E4
def xml_clubs(subtree):
    route_elem = ET.Element("root")
    championnat_elem= ET.SubElement(route_elem,'championnat')
    clubs_elem= ET.SubElement(championnat_elem, 'clubs')
    
    #foreach club
    for club in subtree.findall('clubs/club'):
		#Ici crée les balises club,nom et ville
        att_id = club.attrib['id']
        club_elem=ET.SubElement(clubs_elem,'club',id=att_id)
        nom_elem=ET.SubElement(club_elem,'nom')
        nom_elem.text=club.find('nom').text
        ville_elem=ET.SubElement(club_elem,'ville')
        ville_elem.text=club.find('ville').text
		
		#Ici On crée la balise des rencontres ( receveur)
        rencontres_elem=ET.SubElement(club_elem,'rencontresReceveur')
        #foreach rencontre
        for rencontre in subtree.findall('journees/journee/rencontre'):
			#Si le receveur == club
            rec=rencontre.find('clubReceveur').text
            if(rec == att_id):
				#On ajoute la balise rencontre et son contenu à rencontresReceveur
                ajouter_rencontre(rencontre,rencontres_elem)
    tree = ET.ElementTree(route_elem)
    tree.write("E4.xml")

def ajouter_rencontre(rencontre,racine):
	rencontre_elem=ET.SubElement(racine,'rencontre')
	clubInv_elem=ET.SubElement(rencontre_elem,'clubInvite')
	clubInv_elem.text=rencontre.find('clubInvite').text
	score_elem=ET.SubElement(rencontre_elem,'score')
	score_elem.text=rencontre.find('score').text

xml_clubs(root)

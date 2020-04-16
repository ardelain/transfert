#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Importation de l'API.
import xml.etree.ElementTree as ET

# Chemin vers le fichier xml.
FILE = 'championnat.xml'

# Création du parser et récupération de l'arbre XML du document.
root = ET.parse(FILE).getroot()


def nb_buts_championnat_par_club(subtree):

	route_elem= ET.Element("root")
	clubs_elem= ET.SubElement(route_elem,'clubs')
    
    
	
	for club in subtree.findall('./clubs/club'):
		club_elem= ET.SubElement(clubs_elem, 'club')
		club_elem.set('id',club.attrib['id'])
		rencontre= ET.SubElement(club_elem, 'rencontresReceveur')

	for rencontre in subtree.findall('./journees/journee/rencontre'):
		club_rec = rencontre.find('clubReceveur').text
		if club_rec is  not None:
			ajouter_rencontre(rencontre, route_elem)

	tree = ET.ElementTree(route_elem)
	tree.write("E4.xml")
	

def ajouter_rencontre(rencontre, racine):
	#
	for club in racine.findall('./clubs/club'):
		att_id = club.attrib['id']
		if att_id == rencontre.find('clubReceveur').text:
			doc = ET. SubElement ( rencontre , "rencontresReceveurs" )

#verifier_match_manquant(root)
nb_buts_championnat_par_club(root)
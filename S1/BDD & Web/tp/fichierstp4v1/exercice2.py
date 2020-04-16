#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Importation de l'API.
import xml.etree.ElementTree as ET

# Chemin vers le fichier xml.
FILE = 'championnat.xml'

# Création du parser et récupération de l'arbre XML du document.
root = ET.parse(FILE).getroot()

#E2Q1
def verifier_journee_nb_rencontres(subtree):
	print("Les journees ne vérifiant pas au moins 10 rencontres sont les nums:")
	for journee in subtree.findall('./journees/journee'):
		if(len(journee.findall('rencontre'))<10):
			print(journee.attrib['num'])

def build_xml_journees_rencontres(subtree):
    route_elem = ET.Element("root")
    championnat_elem= ET.SubElement(route_elem,'championnat')
    journees_elem= ET.SubElement(championnat_elem, 'journees')
    for journees in subtree.findall('journees'):
        for journee in journees.findall('journee'):
            journee_elem=ET.SubElement(journees_elem, 'journee')
            journee_elem.set('num',journee.attrib['num'])
            for rencontre in journee.findall('rencontre'):
                rencontre_elem= ET.SubElement(journee_elem, 'rencontre')
                receveur_elem= ET.SubElement(rencontre_elem,'clubReceveur')
                receveur_elem.text= rencontre.find('clubReceveur').text
                invite_elem= ET.SubElement(rencontre_elem,'clubInvite')
                invite_elem.text= rencontre.find('clubInvite').text
    tree = ET.ElementTree(route_elem)
    tree.write("E2Q2.xml")
	
verifier_journee_nb_rencontres(root)
build_xml_journees_rencontres(root)

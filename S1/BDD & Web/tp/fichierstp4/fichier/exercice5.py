#!/usr/bin/env python
# -*- coding: utf-8 -*-
from datetime import datetime

# Importation de l'API.
import xml.etree.ElementTree as ET

# Chemin vers le fichier xml.
FILE = 'championnat.xml'

# Création du parser et récupération de l'arbre XML du document.
root = ET.parse(FILE).getroot()
	
#E5
def are_journees_chronologiques(subtree):
	all_journees=[]
	for journee in subtree.findall('./journees/journee'):
		all_journees.append(journee)
	for i in range(1,len(all_journees)):
		if not is_pair_correct(all_journees[i-1],all_journees[i]):
			print("journee num: "+str(all_journees[i].attrib['num'])+" avant journee: "+str(all_journees[i-1].attrib['num']))
	

def is_pair_correct(journee1,journee2):
	date_j1 = datetime.strptime(journee1.find('date').text,'%Y-%m-%d')
	date_j2 = datetime.strptime(journee2.find('date').text,'%Y-%m-%d')
	return (date_j1-date_j2).days<=0
	
are_journees_chronologiques(root)

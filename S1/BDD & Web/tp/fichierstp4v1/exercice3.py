#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Importation de l'API.
import xml.etree.ElementTree as ET

# Chemin vers le fichier xml.
FILE = 'championnat.xml'

# Création du parser et récupération de l'arbre XML du document.
root = ET.parse(FILE).getroot()

#E3Q1
def verifier_match_manquant(subtree):
	#Decrit tous les couples présents | receveur -> list(invites)
	couples = {}
	#Decrit tous les couples manquants | receveur -> invite
	couples_manquants = {}
	#Decrit les couples manquants dans les deux sens (0 match effectué)
	matchs_manquants = {}
	#On remplit le tableau des couples de rencontres
	for rencontre in subtree.findall('./journees/journee/rencontre'):
		club_rec = rencontre.find('clubReceveur').text
		club_inv = rencontre.find('clubInvite').text
		if club_rec not in couples:
			couples[club_rec] = []
		couples[club_rec].append(club_inv)
	#Pour chaque receveur, on regarde qui il n'a pas reçu en tant qu'invité
	for rec in couples:
		missing_list = who_is_missing_from_list(subtree,rec,couples)
		for inv in missing_list:
			#Si c'est réciproque, il n'y a pas eu de match entre les deux clubs
			if rec in who_is_missing_from_list(subtree,inv,couples):
				if (rec not in matchs_manquants) and (inv not in matchs_manquants):
					matchs_manquants[rec]=[]
					matchs_manquants[rec].append(inv)
				elif (rec not in matchs_manquants) and (rec not in matchs_manquants[inv]):
					matchs_manquants[inv].append(rec)
			else:
				if rec not in couples_manquants:
					couples_manquants[rec]=[]
				couples_manquants[rec].append(inv)
	#Affichage
	for rec,l_inv in couples_manquants.items():
		for inv in l_inv:
			print("Il manque le match : "+rec+"(rec) contre "+inv+"(inv)")
	for rec,l_inv in matchs_manquants.items():
		for inv in l_inv:
			print("Aucun match entre les equipes "+rec+" et "+inv)

#Retourne la liste des clubs n'étant pas présent en tant qu'invité de club_name dans couples.
def who_is_missing_from_list(subtree,club_name,couples):
	club_list = []
	for club in subtree.findall('./clubs/club'):
		att_id = club.attrib['id']
		if att_id not in couples[club_name] and att_id!=club_name:
			club_list.append(att_id)
	return club_list
	
#E3Q2
def nb_buts_championnat_par_club(subtree):
	#club -> club:score
	buts_donnes = {}
	#club -> nb buts
	buts_recus = {}
	
	
	for rencontre in subtree.findall('./journees/journee/rencontre'):
		club_rec = rencontre.find('clubReceveur').text
		club_inv = rencontre.find('clubInvite').text
		score = str.split(rencontre.find('score').text)
		if club_rec not in buts_donnes:
			buts_donnes[club_rec]={}
		if club_inv not in buts_donnes[club_rec]:
			buts_donnes[club_rec][club_inv]=0
		buts_donnes[club_rec][club_inv]+=int(score[0])
		
		if club_inv not in buts_donnes:
			buts_donnes[club_inv]={}
		if club_rec not in buts_donnes[club_inv]:
			buts_donnes[club_inv][club_rec]=0
		buts_donnes[club_inv][club_rec]+=int(score[1])
		
		if club_rec not in buts_recus:
			buts_recus[club_rec]=0
		if club_inv not in buts_recus:
			buts_recus[club_inv]=0
		buts_recus[club_rec]+=int(score[1])
		buts_recus[club_inv]+=int(score[0])
	
	for club in subtree.findall('./clubs/club'):
		tot_buts_donnes=0
		att_id = club.attrib['id']
		if att_id not in buts_donnes or att_id not in buts_recus:
			print("Le club "+att_id+" n'a pas joué de match")
			break
		best_score=find_best_score(buts_donnes,att_id)
		for club,score in buts_donnes[att_id].items():
			tot_buts_donnes+=score
		print("Le club "+att_id)
		print("A donné : "+str(tot_buts_donnes)+" buts")
		print("A reçu : "+str(buts_recus[att_id])+" buts")
		print("Il a marqué le plus contre "+list(best_score)[0]+" avec "+str(best_score[list(best_score)[0]])+" buts")


#verifier_match_manquant(root)
nb_buts_championnat_par_club(root)

route_elem = ET.Element("root")
    championnat_elem= ET.SubElement(route_elem,'clubs')
    journees_elem= ET.SubElement(championnat_elem, 'club')
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
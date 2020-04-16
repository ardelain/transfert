# TP2 note :

# Cbm interroger de personne pour savoir si cest fiable.
# methode des quotas : prendre dans des categories des personnes au hasard 

# Poker:
# l_e = [0,1]
# l_p = [0.9, 0.1]

# erreur absolue : |(p(x = 1) - f(x))|

# erreur relative : (|p(x = 1) - f(x)|)/p(x = 1)

# On veut etre proche de 0 avec une bonne probabilite.
# 2 sortes dincertitudes : precision ou mensonge compromis, 2arguments pour les fonctions, fiabilite et precision.

# P(|O - o| <= y) >= x

# doner une equation pour la courbe trouvee

# asymptotique a 0, régler la hauteur : coeff au numérateur / descendre la fonction avec coeff au denominateur / la fonction secrasera plus vite si puissance supp du denominateur : 1/(3.2n¹⁵)

# 1 - alpha

from scipy.stats import norm
import matplotlib.pyplot as plt

# print(norm.ppf(0.975, loc = 0, scale = 1))

# print(norm.cdf(1.96, loc = 0, scale = 1))

plt.plot([7, 9, 5])
plt.ylabel('Label 1')
plt.show()
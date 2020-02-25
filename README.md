# programmer un moteur de recherche

#### Le but de ce TP est de programmer un moteur de recherche simple mais fonctionnel.

  * Ils’agit de créer un site permettant à l’utilisateur de faire des recherchessur les pages Wikipédia françaises. Le langage de programmation n’est pas imposé maisl’efficacité doit être au rendez-vous.Vous devrez rendre un rapport au formatpdfrésumant le fonctionnant du moteur, expli-quant les choix techniques que vous avez dû faire, et répondant aux principales questions desfiches de TP (longueur indicative : 10 pages).

## L'Evaluation :
  se fera principalementsur le produit fini : le site du moteur de recherche doit être fonctionnel à la fin du cours.Un moteur de recherche basique fonctionne sur ce principe très simple :
    — ordonner « une fois pour toutes » les pages d’internet par « score » décroissant ;
    — lors d’une requête, renvoyer toutes les pages, triées par score décroissant, qui contiennentles mots cherchés.Pour ce genre de moteur, donc, le résultat ne dépend pas de la fréquence des mots dans lapage, mais seulement du score de la page. Toutefois, afin d’améliorer la qualité des résultats,on pourra ensuite prendre en compte d’une façon ou d’une autre la fréquence des mots dansles pages.

## La pertinence du moteur de recherche

dépend évidemment du score attribué à chaquepage. Nous allons utiliser lepagerankqui a fait le succès de Google. Celui-ci attribue un scoreplus élevé aux pages qui reçoivent plus de liens, l’idée étant qu’une page reçoit d’autant plusde liens qu’elle est plus populaire.

## Les Etapes :

 Pour concevoir notre moteur de recherche, nous allons procéder en différentes étapes :
 1. (TP1)(durée indicative : 3 à 4 séances)programmer un « collecteur » (en anglais :webcrawler) qui indexera les pages Wikipédia en suivant les liens des pages.
 *  Ce collecteur aura deux tâches :— « apprendre » le graphe orientéGdes pages visitées (un sommet = une page ; unarc = un lien),

 2. — associer à chacun des mots français les plus fréquents la liste des pages danslesquelles il apparaît ;
 * (TP2)(durée indicative : 2 à 3 séances)à partir du grapheGobtenu, calculer lepagerankde chaque sommet.
 *    Pour chaque mot, trier par ordre depagerankdécroissant la liste des pages contenantce mot ;

  3.  (TP3)(durée indicative : 2 séances)réaliser le site de sorte que, sur une requête del’utilisateur, il affiche l’ensemble des pages contenant tous les mots de la requête, parordre depagerankdécroissant.Conseil: à chaque étape, testez rigoureusement vos fonctions pour être certain de leurbon fonctionnement avant de passer à l’étape suivante.

package app.youcef.com.stock2.Services

import app.youcef.com.stock2.Model.*


/**
 * Created by hp on 17/04/2018.
 */
object DataService {
    var nbJaimeActeur1=0
    var nbJaimePasActeur1=0


    val saison= listOf(
            Saison("13 reasons why",1,"reasons_why_saison1") ,
            Saison("13 reasons why",2,"reasons_why_saison2"),
            Saison("13 reasons why",3,"reasons_why_saison5"),
            Saison("13 reasons why",4,"reasons_why_saison4"),
            Saison("13 reasons why",5,"reasons_why_saison1") ,
            Saison("13 reasons why",6,"reasons_why_saison2"),
            Saison("13 reasons why",7,"reasons_why_saison5"),
            Saison("13 reasons why",8,"reasons_why_saison4")
    )
    val episodes= listOf(
            Episode("13 reasons why",1,1,"reasons_why_saison1") ,
            Episode("13 reasons why",1,2,"reasons_why_saison2"),
            Episode("13 reasons why",1,3,"reasons_why_saison5"),
            Episode("13 reasons why",1,4,"reasons_why_saison4"),
            Episode("13 reasons why",1,5,"reasons_why_saison1") ,
            Episode("13 reasons why",1,6,"reasons_why_saison2"),
            Episode("13 reasons why",1,7,"reasons_why_saison5"),
            Episode("13 reasons why",1,8,"reasons_why_saison4")
    )





    val salles= listOf(
            Salle("Cinéma l'Afrique","salle1","Rue des Frères Meslem, Sidi M'Hamed",3.053656799999999,36.7645417),
            Salle("Ibn Khaldoun","salle2","12,، Dr Ch. Saadane St",3.0568673000000217,36.7736041),
            Salle("Cinéma Gaumont Parnasse","salle3","3 Rue d'Odessa, 75015 Paris, France",2.3245039999999335,48.8430536),
            Salle("Cinéma L'Algéria","salle4"," 52 Rue Didouche Mourad, Alger",3.0529629000000114,36.7668907)
    )

    val mesSalles= listOf(
            Salle("Cinéma l'Afrique","salle1","Rue des Frères Meslem, Sidi M'Hamed",3.053656799999999,36.7645417),
            Salle("Ibn Khaldoun","salle2","12,، Dr Ch. Saadane St",3.0568673000000217,36.7736041)
    )





    /* Pour prendre les details d'un filme soit à partir de l'accueil soit à partir du fragment film */
    var filmesAprendreDetails:List<Filme> = arrayListOf()
    var seriesAprendreDetails:List<Serie> = arrayListOf()
    var personnes:List<Personne> = arrayListOf()






}
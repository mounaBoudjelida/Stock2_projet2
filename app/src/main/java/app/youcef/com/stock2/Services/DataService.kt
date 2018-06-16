package app.youcef.com.stock2.Services

import app.youcef.com.stock2.Model.*
import app.youcef.com.stock2.R

/**
 * Created by hp on 17/04/2018.
 */
object DataService {
    var nbJaimeActeur1=0
    var nbJaimePasActeur1=0
    var nbJaimeSerie1=0
    var nbJaimePasSerie1=0
    var nbJaimeFilme1=0
    var nbJaimePasFilme1=0
    val personnes= listOf(
            Personne("Georges Clooney","6 mai 1991","acteur_1"),
            Personne("Matt Damon","14/01/1994","acteur_2"),
            Personne("Channing Tatum","14/01/1994","acteur_3"),
            Personne("jensen ackles","14/01/1994","acteur_10"),
            Personne("Gibson Mel","14/01/1994","acteur_5"),
            Personne("Josh Duhamel","14/01/1994","acteur_6"),
            Personne("ian somerhalder ","14/01/1994","acteur_7"),
            Personne("Will Smith","14/01/1994","acteur_8"),
            Personne("Taylor Lautner","14/01/1994","acteur_9")

    )

    val series= listOf(
            Serie("13 reasons why","reasons_why",0),
            Serie("The good doctor","good_doctor",1),
            Serie("Suits","suits",2),
            Serie("Game Of Thrones","game_of_thrones",3),
            Serie("Vikings","vikings",4),
            Serie("WestWorld","west_world",5),
            Serie("Mr Robot","mr_robot",6),
            Serie("Vampire Diaries","vampire_daries",7),
            Serie("Arrow","arrow",8),
            Serie("Greys anatomy","greys_anatomie",9) ,
            Serie("Dr House","dr_house",10)
    )
    val seriesEncours= listOf(
            Serie("Suits","suits",2),
            Serie("Game Of Thrones","game_of_thrones",3),
            Serie("Vikings","vikings",4),
            Serie("Arrow","arrow",8),
            Serie("Greys anatomy","greys_anatomie",9)
    )

    val mesSeries= listOf(
            Serie("Suits","suits",2),
            Serie("Game Of Thrones","game_of_thrones",3),
            Serie("Vikings","vikings",4)
    )



    val seriesLiees1= listOf(
            Serie("Suits","suits",2)
    )
    val seriesLiees2= listOf(
            Serie("Dr House","dr_house",10),
            Serie("Greys anatomy","greys_anatomie",9)
    )
    val seriesLiees3= listOf(
            Serie("13 reasons why","reasons_why",0)
    )
    val seriesLiees4= listOf(
            Serie("Vikings","vikings",4),
            Serie("WestWorld","west_world",5)
    )
    val seriesLiees5= listOf(
            Serie("Game Of Thrones","game_of_thrones",3),
            Serie("WestWorld","west_world",5)
    )
    val seriesLiees6= listOf(
            Serie("Game Of Thrones","game_of_thrones",3),
            Serie("Vikings","vikings",4)
    )
    val seriesLiees7= listOf(
            Serie("","",0)
    )
    val seriesLiees8= listOf(
            Serie("Arrow","arrow",8)
    )
    val seriesLiees9= listOf(
            Serie("Vampire Diaries","vampire_daries",7)
    )
    val seriesLiees10= listOf(
            Serie("The good doctor","good_doctor",1),
            Serie("Dr House","dr_house",10)
    )
    val seriesLiees11= listOf(
            Serie("The good doctor","good_doctor",1),
            Serie("Greys anatomy","greys_anatomie",9)
    )


    val seriesLiees = listOf(
            seriesLiees1,
            seriesLiees2,
            seriesLiees3,
            seriesLiees4,
            seriesLiees5,
            seriesLiees6,
            seriesLiees7,
            seriesLiees8,
            seriesLiees9,
            seriesLiees10,
            seriesLiees11
    )




    val filmes= listOf(
            Filme("Avatar 2","film1",null,0),
            Filme("Transformers 3","film2",null,1),
            Filme("Guardians","film3","30",2),
            Filme("Pirates des caraïbes","film4","12",3),
            Filme("La taupe","film5","24",4),
            Filme("Underworld","film6",null,5),
            Filme("La belle et la bête","film7","10",6)

    )

    val mesFilmes= listOf(
            Filme("Avatar 2","film1",null,0),
            Filme("Transformers 3","film2",null,1),
            Filme("Guardians","film3","30",2),
            Filme("Underworld","film6",null,5),
            Filme("La belle et la bête","film7","10",6)

    )

    val filmesProject= listOf(
            Filme("Pirates des caraïbes","film4","Salle 12",3),
            Filme("La taupe","film5","Salle 24",4),
            Filme("La belle et la bête","film7","Salle 10",6),
            Filme("Guardians","film3","Salle 30",2)
    )

    val filmesLies1= listOf(
            Filme("Transformers 3","film2",null,1)
    )

    val filmesLies2= listOf(
            Filme("Avatar 2","film1",null,0)
    )

    val filmesLies3= listOf(
            Filme("Pirates des caraïbes","film4","Salle 12",3)
    )

    val filmesLies4= listOf(
            Filme("Underworld","film6",null,5),
            Filme("La belle et la bête","film7","10",6)
    )

    val filmesLies5= listOf(
            Filme("Pirates des caraïbes","film4","Salle 12",3)
    )

    val filmesLies6= listOf(
            Filme("La belle et la bête","film7","10",7),
            Filme("Pirates des caraïbes","film4","Salle 12",3)
    )

    val filmesLies7= listOf(
            Filme("Underworld","film6",null,6),
            Filme("Pirates des caraïbes","film4","Salle 12",3)
    )

    val filmesLies = listOf(
            filmesLies1,
            filmesLies2,
            filmesLies3,
            filmesLies4,
            filmesLies5,
            filmesLies6,
            filmesLies7
    )

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


    var commentaireAvatar= arrayListOf(
            Commentaire("j'ai adoré la planète"),
            Commentaire("Belle mise en oeuvre"),
            Commentaire("trop suréaliste")
    )

    var commentaireTransformers= arrayListOf(
            Commentaire("Tropd'incohérences"),
            Commentaire("J'ai pas aimé"),
            Commentaire("Scénaristiquement bon")
    )

    var commentaireGuardians= arrayListOf(
            Commentaire("")
    )

    var commentairePirate= arrayListOf(
            Commentaire("Vive jack sparrow"),
            Commentaire("ce filme est excllent")
    )

    var commentaireLataupe= arrayListOf(
            Commentaire("")
    )

    var commentaireUnderworld= arrayListOf(
            Commentaire("excellent filme"),
            Commentaire("J'attends la suite avec impatience"),
            Commentaire("La suite est deja sortie"),
            Commentaire("Beau filme"),
            Commentaire("Ennuyeux"),
            Commentaire("filme assez classique dans l'ensemble")
    )

    var commentaireLabelle= arrayListOf(
            Commentaire("Très proche du vrai comte"),
            Commentaire("Ca ma rappellé mon enfance")
    )


    var commentaires= listOf(
            commentaireAvatar,
            commentaireTransformers,
            commentaireGuardians,
            commentairePirate,
            commentaireLataupe,
            commentaireUnderworld,
            commentaireLabelle

    )

    var commentaire13ReasonsWhy= arrayListOf(
            Commentaire("J'ai adoré cette série 1"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")
    )
    var commentaireTheGoodDoctor= arrayListOf(
            Commentaire("J'ai adoré cette série 2"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )
    var commentaireSuits= arrayListOf(
            Commentaire("J'ai adoré cette série 3"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )
    var commentaireGameOfThrones= arrayListOf(
            Commentaire("J'ai adoré cette série 4"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireVikings= arrayListOf(
            Commentaire("J'ai adoré cette série 5"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireWestWorld= arrayListOf(
            Commentaire("J'ai adoré cette série 6"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireMrRobot= arrayListOf(
            Commentaire("J'ai adoré cette série 7"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireVampireDiaries= arrayListOf(
            Commentaire("J'ai adoré cette série 8"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireArrow= arrayListOf(
            Commentaire("J'ai adoré cette série 9"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireHereAndNow= arrayListOf(
            Commentaire("J'ai adoré cette série 10"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireGreysAnatomy= arrayListOf(
            Commentaire("J'ai adoré cette série 11"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )

    var commentaireDrHouse= arrayListOf(
            Commentaire("J'ai adoré cette série 12"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice"),
            Commentaire("J'ai adoré cette série"),
            Commentaire("Une série triste"),
            Commentaire("J'ai aimé l'actrice")

    )
    var commentaireActeur1= arrayListOf(
            Commentaire("J'aime ses rélisations 1"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur2= arrayListOf(
            Commentaire("J'aime ses rélisations 2"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur3= arrayListOf(
            Commentaire("J'aime ses rélisations 3"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur4= arrayListOf(
            Commentaire("J'aime ses rélisations 4"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur5= arrayListOf(
            Commentaire("J'aime ses rélisations 5"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur6= arrayListOf(
            Commentaire("J'aime ses rélisations 6"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur7= arrayListOf(
            Commentaire("J'aime ses rélisations 7"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur8= arrayListOf(
            Commentaire("J'aime ses rélisations 8"),
            Commentaire("un autre commentaire")
    )
    var commentaireActeur9= arrayListOf(
            Commentaire("J'aime ses rélisations 9"),
            Commentaire("un autre commentaire")
    )
    var listeVide= arrayListOf<Commentaire>()
    fun getListeCommentaireSerie( serieTitle:String):ArrayList<Commentaire>{
        when(serieTitle){
            series[0].title->return commentaire13ReasonsWhy
            series[1].title->return commentaireTheGoodDoctor
            series[2].title->return commentaireSuits
            series[3].title->return commentaireGameOfThrones
            series[4].title->return commentaireVikings
            series[5].title->return commentaireWestWorld
            series[6].title->return commentaireMrRobot
            series[7].title->return commentaireVampireDiaries
            series[8].title->return commentaireArrow
            series[9].title->return commentaireHereAndNow
            series[10].title->return commentaireGreysAnatomy
            series[11].title->return commentaireDrHouse
            else ->return listeVide

        }
    }
    fun getListeCommentairePersonne( personneNom:String):ArrayList<Commentaire>{
        when(personneNom){
            personnes[0].nomPrenom->return commentaireActeur1
            personnes[1].nomPrenom->return commentaireActeur2
            personnes[2].nomPrenom->return commentaireActeur3
            personnes[3].nomPrenom->return commentaireActeur4
            personnes[4].nomPrenom->return commentaireActeur5
            personnes[5].nomPrenom->return commentaireActeur6
            personnes[6].nomPrenom->return commentaireActeur7
            personnes[7].nomPrenom->return commentaireActeur8
            personnes[8].nomPrenom->return commentaireActeur9

            else ->return listeVide

        }
    }

    fun getListeCommentaireFilme( filmeTitle:String):ArrayList<Commentaire>{
        when(filmeTitle){
            filmes[0].title->return commentaires[0]
            filmes[1].title->return commentaires[1]
            filmes[2].title->return commentaires[2]
            filmes[3].title->return commentaires[3]
            filmes[4].title->return commentaires[4]
            filmes[5].title->return commentaires[5]
            filmes[6].title->return commentaires[6]
            else ->return listeVide

        }
    }

    fun addCommentairePersonne(c:Commentaire, personneNom:String){
        when(personneNom){
            personnes[0].nomPrenom-> commentaireActeur1.add(c)
            personnes[1].nomPrenom-> commentaireActeur2.add(c)
            personnes[2].nomPrenom-> commentaireActeur3.add(c)
            personnes[3].nomPrenom->commentaireActeur4.add(c)
            personnes[4].nomPrenom-> commentaireActeur5.add(c)
            personnes[5].nomPrenom-> commentaireActeur6.add(c)
            personnes[6].nomPrenom-> commentaireActeur7.add(c)
            personnes[7].nomPrenom-> commentaireActeur8.add(c)
            personnes[8].nomPrenom-> commentaireActeur9.add(c)

        }
    }
    fun addCommentaireSerie( c:Commentaire,serieTitle:String){
        when(serieTitle){
            series[0].title->commentaire13ReasonsWhy.add(c)
            series[1].title->commentaireTheGoodDoctor.add(c)
            series[2].title->commentaireSuits.add(c)
            series[3].title->commentaireGameOfThrones.add(c)
            series[4].title->commentaireVikings.add(c)
            series[5].title->commentaireWestWorld.add(c)
            series[6].title->commentaireMrRobot.add(c)
            series[7].title->commentaireVampireDiaries.add(c)
            series[8].title->commentaireArrow.add(c)
            series[9].title->commentaireHereAndNow.add(c)
            series[10].title->commentaireGreysAnatomy.add(c)
            series[11].title->commentaireDrHouse.add(c)
        }
    }

    fun addCommentaireFilme( c:Commentaire,filmeTitle:String){
        when(filmeTitle){
            filmes[0].title->commentaires[0].add(c)
            filmes[1].title->commentaires[1].add(c)
            filmes[2].title->commentaires[2].add(c)
            filmes[3].title->commentaires[3].add(c)
            filmes[4].title->commentaires[4].add(c)
            filmes[5].title->commentaires[5].add(c)
            filmes[6].title->commentaires[6].add(c)

        }
    }
}
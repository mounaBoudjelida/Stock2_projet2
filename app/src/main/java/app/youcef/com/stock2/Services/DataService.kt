package app.youcef.com.stock2.Services

import android.util.Log
import app.youcef.com.stock2.Model.*
import app.youcef.com.stock2.R
import app.youcef.com.stock2.remote.FilmeAPIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

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















    var k =listOf(12,8)
    val filmesLies1:List<Filme> = arrayListOf(Filme(1,2,true,65.0,"djdj",98.0
    ,"\\/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg","english","origin title",k,"",
    true,"over",null,null,null))

    val filmesLies2= filmesLies1

    val filmesLies3= filmesLies1

    val filmesLies4= filmesLies1

    val filmesLies5=filmesLies1

    val filmesLies6=filmesLies1
    val filmesLies7= filmesLies1

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
        return listeVide


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
        /*when(filmeTitle){
            filmes[0].title->return commentaires[0]
            filmes[1].title->return commentaires[1]
            filmes[2].title->return commentaires[2]
            filmes[3].title->return commentaires[3]
            filmes[4].title->return commentaires[4]
            filmes[5].title->return commentaires[5]
            filmes[6].title->return commentaires[6]
            else ->return listeVide

        }*/
        return commentaires[6]
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
            series[0].name->commentaire13ReasonsWhy.add(c)
            series[1].name->commentaireTheGoodDoctor.add(c)
            series[2].name->commentaireSuits.add(c)
            series[3].name->commentaireGameOfThrones.add(c)
            series[4].name->commentaireVikings.add(c)
            series[5].name->commentaireWestWorld.add(c)
            series[6].name->commentaireMrRobot.add(c)
            series[7].name->commentaireVampireDiaries.add(c)
            series[8].name->commentaireArrow.add(c)
            series[9].name->commentaireHereAndNow.add(c)
            series[10].name->commentaireGreysAnatomy.add(c)
            series[11].name->commentaireDrHouse.add(c)
        }
    }

    fun addCommentaireFilme( c:Commentaire,filmeTitle:String){
        when(filmeTitle){


        }
    }


    var filmes:List<Filme> = arrayListOf()
    var series:List<Serie> = arrayListOf()
    var seriesEnCoursDeProjection:List<Serie> = arrayListOf()
    var seriesLiees:List<Serie> = arrayListOf()

    var filmesProject:List<Filme> = listOf(Filme(1,2,true,65.0,"DataServiceTitle",98.0
    ,"\\/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg","english","origin title",k,"",
            true,"over",null,null,null))








}
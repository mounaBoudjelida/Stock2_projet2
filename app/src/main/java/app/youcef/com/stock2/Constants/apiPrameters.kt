package app.youcef.com.stock2.Constants

/**
 * Created by hp on 18/06/2018.
 */
object ApiParam {
    const val baseImageURL = "https://image.tmdb.org/t/p/w185"
    const val apiKey="52aca7db58968787fad3466df0bf4f3d"
    const val baseURL="http://api.themoviedb.org/3/"
    const val urlMoviePopular="movie/popular"
    const val urlMovieNowPlaying="movie/now_playing"
    const val urlSerieAiringToday="tv/airing_today"
    const val urlSimilarSerie="tv/{tv_id}/similar"
    const val urlActeurs="person/popular"
    const val urlDetailsActeur="person/{person_id}"
    const val urlDetailsFilm="movie/{movie_id}"
    const val urlSimilarMovies="movie/{movie_id}/similar"
    const val urlCommentaireMovie="movie/{movie_id}/reviews"
    const val urlSerie="tv/popular"
    const val urlCommentaireSerie="tv/{tv_id}/reviews"
}
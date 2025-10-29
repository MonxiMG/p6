package es.ua.eps.filmoteca.data

object FilmsProvider {
    val films: List<Film> = listOf(
        Film("The Godfather", "Francis Ford Coppola", 1972, "Crime", "Clásico absoluto."),
        Film("Alien", "Ridley Scott", 1979, "Sci-Fi", "Terror espacial."),
        Film("Spirited Away", "Hayao Miyazaki", 2001, "Animation", "Obra maestra Ghibli."),
        Film("Inception", "Christopher Nolan", 2010, "Thriller", "Sueños dentro de sueños.")
    )
}

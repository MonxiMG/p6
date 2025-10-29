package es.ua.eps.filmoteca.data

data class Film(
    val title: String,
    val director: String,
    val year: Int,
    val genre: String,
    val notes: String = ""
)

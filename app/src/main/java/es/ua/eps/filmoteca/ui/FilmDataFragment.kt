package es.ua.eps.filmoteca.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import es.ua.eps.filmoteca.R
import es.ua.eps.filmoteca.data.FilmsProvider

private const val ARG_INDEX = "arg_index"

class FilmDataFragment : Fragment() {

    private var tvTitle: TextView? = null
    private var tvDirector: TextView? = null
    private var tvYear: TextView? = null
    private var tvGenre: TextView? = null
    private var tvNotes: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_film_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvDirector = view.findViewById(R.id.tvDirector)
        tvYear = view.findViewById(R.id.tvYear)
        tvGenre = view.findViewById(R.id.tvGenre)
        tvNotes = view.findViewById(R.id.tvNotes)

        // Si viene un índice por argumentos (modo small tras navegación), muéstralo
        val index = arguments?.getInt(ARG_INDEX)
        index?.let { showFilm(it) }
    }

    fun showFilm(index: Int) {
        val film = FilmsProvider.films[index]
        tvTitle?.text = film.title
        tvDirector?.text = getString(R.string.detail_director, film.director)
        tvYear?.text = getString(R.string.detail_year, film.year)
        tvGenre?.text = getString(R.string.detail_genre, film.genre)
        tvNotes?.text = film.notes
    }

    companion object {
        fun newInstance(index: Int): FilmDataFragment {
            return FilmDataFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_INDEX, index)
                }
            }
        }
    }
}

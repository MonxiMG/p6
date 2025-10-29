package es.ua.eps.filmoteca.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import es.ua.eps.filmoteca.data.FilmsProvider

class FilmListFragment : ListFragment() {

    interface Callbacks {
        fun onFilmSelected(index: Int)
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as? Callbacks
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val titles = FilmsProvider.films.map { it.title }
        listAdapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_list_item_1, titles)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        // Notificamos a la Activity (Ejercicio 2)
        callbacks?.onFilmSelected(position)
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }
}

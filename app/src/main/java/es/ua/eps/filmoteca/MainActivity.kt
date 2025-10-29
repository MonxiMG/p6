package es.ua.eps.filmoteca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import es.ua.eps.filmoteca.ui.FilmDataFragment
import es.ua.eps.filmoteca.ui.FilmListFragment

class MainActivity : AppCompatActivity(), FilmListFragment.Callbacks {

    private val isTwoPane: Boolean
        get() = (supportFragmentManager.findFragmentById(R.id.frag_detail) != null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Android decidirá qué layout cargar según el tamaño:
        // - small: activity_main.xml (FrameLayout)
        // - large: activity_main_sw600dp.xml (dos fragments estáticos)
        setContentView(R.layout.activity_main)

        // Solo en small, si es la primera vez, insertamos la lista en el contenedor.
        if (!isTwoPane && savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.main_container, FilmListFragment())
            }
        }

        // En two-pane no hay que hacer nada: los fragment estáticos ya están en el layout.
    }

    // ===== Ejercicio 2: respuesta al click =====
    override fun onFilmSelected(index: Int) {
        if (isTwoPane) {
            // Pantalla grande: actualizamos el fragment de detalle ya presente
            val detail =
                supportFragmentManager.findFragmentById(R.id.frag_detail) as? FilmDataFragment
            detail?.showFilm(index)
        } else {
            // Pantalla pequeña: navegamos al fragment de detalle
            val detail = FilmDataFragment.newInstance(index)
            supportFragmentManager.commit {
                replace(R.id.main_container, detail)
                addToBackStack(null)
            }
        }
    }
}

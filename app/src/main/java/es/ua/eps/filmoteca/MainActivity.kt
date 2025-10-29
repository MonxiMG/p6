package es.ua.eps.filmoteca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.appbar.MaterialToolbar
import es.ua.eps.filmoteca.ui.FilmDataFragment
import es.ua.eps.filmoteca.ui.FilmListFragment

class MainActivity : AppCompatActivity(), FilmListFragment.Callbacks {

    // Solo existe frag_detail en el layout de tablets (two-pane)
    private val isTwoPane: Boolean
        get() = supportFragmentManager.findFragmentById(R.id.frag_detail) != null

    private var toolbar: MaterialToolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Android escogerá el layout móvil o el de tablet según el tamaño
        setContentView(R.layout.activity_main)

        // En móviles, activity_main.xml tiene una Toolbar con id toolbar; en tablets no
        toolbar = findViewById(R.id.toolbar)
        toolbar?.let {
            setSupportActionBar(it) // ← imprescindible para que aparezca la flecha
            it.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }

        if (!isTwoPane && savedInstanceState == null) {
            // Móvil: cargamos la lista en el contenedor
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.main_container, FilmListFragment())
            }
        }

        // Mantén la flecha sincronizada con el back stack (móvil)
        supportFragmentManager.addOnBackStackChangedListener { updateUpButton() }
        updateUpButton()
    }

    // Llega el click desde la lista
    override fun onFilmSelected(index: Int) {
        if (isTwoPane) {
            // Tablet: actualiza el detalle estático
            (supportFragmentManager.findFragmentById(R.id.frag_detail) as? FilmDataFragment)
                ?.showFilm(index)
        } else {
            // Móvil: navega al detalle
            val detail = FilmDataFragment.newInstance(index)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.main_container, detail)
                addToBackStack("detail")
            }
            // El listener actualizará la flecha automáticamente
        }
    }

    // Soporte del botón “Up” se dirige al listado
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    // Muestra/oculta la flecha solo si hay algo en el back stack (y si hay Toolbar)
    private fun updateUpButton() {
        if (toolbar == null) return // En tablets no hay Toolbar en este layout
        val showUp = supportFragmentManager.backStackEntryCount > 0
        supportActionBar?.setDisplayHomeAsUpEnabled(showUp)
        // Centra/ajusta el título
        supportActionBar?.title = getString(R.string.app_name)
    }
}

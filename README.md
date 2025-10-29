# Filmoteca con Fragmentos

## Qué se ha hecho

Se ha adaptado la aplicación Filmoteca para que utilice **Fragments** en
lugar de Activities.\
Se han creado dos fragments principales: - `FilmListFragment`, que
muestra la lista de películas. - `FilmDataFragment`, que muestra los
datos de la película seleccionada.

Además, se ha desarrollado una `MainActivity` que: - En **pantallas
pequeñas**, muestra solo un fragmento (lista o detalle) y gestiona las
transiciones entre ellos. - En **pantallas grandes**, muestra ambos
fragments simultáneamente (lista a la izquierda y detalle a la derecha).

## Problemas encontrados

-   **Error con los iconos adaptativos (`ic_launcher`)**, al estar en la
    carpeta incorrecta (`mipmap-anydpi` en lugar de
    `mipmap-anydpi-v26`).
-   **La flecha de retroceso no aparecía en la Toolbar** porque el tema
    no estaba configurado como `NoActionBar`.
-   **El fragment de detalle no se actualizaba** en modo tablet al
    seleccionar una nueva película.

## Cómo se han resuelto

-   Se movieron los iconos a la carpeta correcta (`mipmap-anydpi-v26`) y
    se regeneraron con el asistente *Image Asset*.
-   Se cambió el tema a `Theme.Material3.DayNight.NoActionBar` y se
    configuró la Toolbar como `ActionBar` con
    `setSupportActionBar(toolbar)`.
-   Se añadió una interfaz de comunicación entre fragments y la lógica
    en `MainActivity` para actualizar el detalle en pantallas grandes.

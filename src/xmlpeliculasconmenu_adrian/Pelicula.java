// Adrian Gimenez Muñoz - EXAMEN 11/02/2026

package xmlpeliculasconmenu_adrian;

public class Pelicula {
    // Atributos privados
    private String titulo;
    private int duracion; // En minutos
    private String genero; // Misterio, Aventura, Comedia, etc
    private String urlTrailer;

    // Constructor para inicializar los objetos fácilmente
    
    public Pelicula(String titulo, int duracion, String genero, String urlTrailer) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.urlTrailer = urlTrailer;
    }

    // Getters
    
    public String getTitulo() { return titulo; }
    public int getDuracion() { return duracion; }
    public String getGenero() { return genero; }
    public String getUrlTrailer() { return urlTrailer; }

    // Método toString para enseñar la película en listas
    
    @Override
    public String toString() {
        return titulo + " (" + duracion + " min)";
    }
}

public class WidgetFraseMotivacional {
    private String frase;
    private String autor;
    private String fecha;

    public WidgetFraseMotivacional(String frase, String autor, String fecha) {
        this.frase = frase;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}

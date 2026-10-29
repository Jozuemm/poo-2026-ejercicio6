

public class WidgetTareas {
    private String tarea;
    private String fecha;
    private boolean completada;

    public WidgetTareas(String tarea, String fecha, boolean completada) {
        this.tarea = tarea;
        this.fecha = fecha;
        this.completada = completada;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    
}



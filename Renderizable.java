import javax.swing.JComponent;

public interface Renderizable extends Comparable<Renderizable> {
    String renderizar();
    JComponent obtenerVista();

    int getId();
    String getNombre();
    double getMemoriaKB();
}
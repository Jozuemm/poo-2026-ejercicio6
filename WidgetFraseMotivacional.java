import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WidgetFraseMotivacional extends WidgetBase {
    private String frase;
    private String autor;
    private String fecha;

    private JPanel panel;
    private JTextArea texto;

    public WidgetFraseMotivacional(String frase, String autor, String fecha) {
        super("Frase de " + autor, 60);
        this.frase = frase;
        this.autor = autor;
        this.fecha = fecha;

        panel = new JPanel(new BorderLayout());

        texto = new JTextArea(5, 20);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setText(renderizar());

        panel.add(new JScrollPane(texto), BorderLayout.CENTER);
    }

    @Override
    public String renderizar() {
        return "Frase del día - " + fecha
                + "\n\n\"" + frase + "\""
                + "\n\nAutor: " + autor;
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
        texto.setText(renderizar());
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        texto.setText(renderizar());
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        texto.setText(renderizar());
    }
}
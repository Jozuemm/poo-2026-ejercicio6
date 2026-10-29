import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WidgetTareas extends WidgetBase implements Interactivo {
    private ArrayList<String> pendientes;
    private ArrayList<String> completadas;
    private String fecha;

    private JPanel panel;
    private JTextArea texto;
    private JButton boton;

    public WidgetTareas(String fecha) {
        super("Tareas del " + fecha, 150);
        this.fecha = fecha;
        pendientes = new ArrayList<>();
        completadas = new ArrayList<>();

        panel = new JPanel(new BorderLayout(10, 10));

        texto = new JTextArea(6, 20);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        boton = new JButton("Completar primera tarea");

        boton.addActionListener(e -> {
            interactuar();
        });

        panel.add(new JScrollPane(texto), BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);

        actualizarVista();
    }

    public void agregarTarea(String tarea) {
        if (tarea == null || tarea.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La tarea no puede estar vacía."
            );
        }

        pendientes.add(tarea.trim());
        actualizarVista();
    }

    @Override
    public String renderizar() {
        String resultado = "Tareas del " + fecha + "\n\n";

        resultado += "Pendientes:\n";

        if (pendientes.isEmpty()) {
            resultado += "No hay tareas pendientes.\n";
        } else {
            for (String tarea : pendientes) {
                resultado += "- " + tarea + "\n";
            }
        }

        resultado += "\nCompletadas:\n";

        if (completadas.isEmpty()) {
            resultado += "Todavía no hay tareas completadas.\n";
        } else {
            for (String tarea : completadas) {
                resultado += "- " + tarea + "\n";
            }
        }

        return resultado;
    }

    @Override
    public void interactuar() {
        if (!pendientes.isEmpty()) {
            String tarea = pendientes.remove(0);
            completadas.add(tarea);
        }

        actualizarVista();
    }

    private void actualizarVista() {
        texto.setText(renderizar());
        boton.setEnabled(!pendientes.isEmpty());
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        actualizarVista();
    }
}
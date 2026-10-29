import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WidgetAlerta extends WidgetBase implements Interactivo {
    private String mensaje;
    private String tipo;
    private String fecha;
    private boolean leida;

    private JPanel panel;
    private JTextArea texto;
    private JButton boton;

    public WidgetAlerta(String mensaje, String tipo, String fecha) {
        super("Alerta de prioridad " + tipo, 100);
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fecha = fecha;
        this.leida = false;

        panel = new JPanel(new BorderLayout(10, 10));

        texto = new JTextArea(5, 20);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        boton = new JButton("Marcar como leída");

        boton.addActionListener(e -> {
            interactuar();
        });

        panel.add(new JScrollPane(texto), BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);

        actualizarVista();
    }

    @Override
    public String renderizar() {
        String estado;

        if (leida) {
            estado = "Leída";
        } else {
            estado = "Pendiente de leer";
        }

        return "Alerta - " + fecha
                + "\nPrioridad: " + tipo
                + "\n\n" + mensaje
                + "\n\nEstado: " + estado;
    }

    @Override
    public void interactuar() {
        leida = true;
        actualizarVista();
    }

    private void actualizarVista() {
        texto.setText(renderizar());
        boton.setEnabled(!leida);
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        actualizarVista();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        actualizarVista();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        actualizarVista();
    }

    public boolean isLeida() {
        return leida;
    }
}
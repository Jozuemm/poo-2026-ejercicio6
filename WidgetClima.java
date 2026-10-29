import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WidgetClima extends WidgetBase implements Interactivo {
    private String ciudad;
    private double temperatura;
    private String descripcion;
    private boolean enCelsius;

    private JPanel panel;
    private JLabel etiqueta;

    public WidgetClima(String ciudad, double temperatura,
                       String descripcion) {
        super("Clima de " + ciudad, 120);

        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.descripcion = descripcion;
        this.enCelsius = true;

        panel = new JPanel(new BorderLayout(10, 10));
        etiqueta = new JLabel(renderizar());

        JButton boton = new JButton("Cambiar °C / °F");

        boton.addActionListener(e -> {
            interactuar();
        });

        panel.add(etiqueta, BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);
    }

    @Override
    public String renderizar() {
        double temperaturaMostrada;
        String unidad;

        if (enCelsius) {
            temperaturaMostrada = temperatura;
            unidad = "°C";
        } else {
            temperaturaMostrada = temperatura * 9.0 / 5.0 + 32;
            unidad = "°F";
        }

        return ciudad + ": "
                + String.format("%.1f", temperaturaMostrada)
                + " " + unidad + " - " + descripcion;
    }

    @Override
    public void interactuar() {
        enCelsius = !enCelsius;
        actualizarVista();
    }

    private void actualizarVista() {
        etiqueta.setText(renderizar());
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
        actualizarVista();
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        actualizarVista();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        actualizarVista();
    }
}
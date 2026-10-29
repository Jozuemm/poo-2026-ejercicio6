import java.awt.BorderLayout;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WidgetReloj extends WidgetBase {
    private ZoneId zonaHoraria;
    private JPanel panel;
    private JLabel etiqueta;
    private Timer temporizador;

    public WidgetReloj(String zonaHoraria) {
        super("Reloj de " + zonaHoraria, 80);
        this.zonaHoraria = ZoneId.of(zonaHoraria);

        panel = new JPanel(new BorderLayout());
        etiqueta = new JLabel(renderizar(), JLabel.CENTER);

        panel.add(etiqueta, BorderLayout.CENTER);

        temporizador = new Timer(1000, e -> {
            etiqueta.setText(renderizar());
        });

        panel.addHierarchyListener(e -> {
            if (panel.isShowing()) {
                temporizador.start();
            } else {
                temporizador.stop();
            }
        });
    }

    @Override
    public String renderizar() {
        ZonedDateTime ahora = ZonedDateTime.now(zonaHoraria);

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return ahora.format(formato)
                + " - " + zonaHoraria.getId();
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    public String getZonaHoraria() {
        return zonaHoraria.getId();
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = ZoneId.of(zonaHoraria);
        etiqueta.setText(renderizar());
    }
}
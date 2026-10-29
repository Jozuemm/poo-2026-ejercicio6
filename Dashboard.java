import java.util.ArrayList;
import java.util.Collections;

public class Dashboard {
    private ArrayList<Renderizable> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
        init();
    }

    public void init() {
        widgets.clear();

        widgets.add(new WidgetClima(
                "Ciudad de Guatemala", 25, "Soleado"
        ));

        widgets.add(new WidgetClima(
                "Quetzaltenango", 16, "Nublado"
        ));

        widgets.add(new WidgetReloj("America/Guatemala"));
        widgets.add(new WidgetReloj("Europe/Madrid"));

        WidgetTareas tareasUniversidad =
                new WidgetTareas("28/10/2026");

        tareasUniversidad.agregarTarea("Terminar ejercicio de POO");
        tareasUniversidad.agregarTarea("Repasar interfaces");

        widgets.add(tareasUniversidad);

        WidgetTareas tareasPersonales =
                new WidgetTareas("29/10/2026");

        tareasPersonales.agregarTarea("Ordenar el escritorio");
        tareasPersonales.agregarTarea("Preparar la mochila");

        widgets.add(tareasPersonales);

        widgets.add(new WidgetFraseMotivacional(
                "Cada paso pequeño también cuenta.",
                "Anónimo",
                "28/10/2026"
        ));

        widgets.add(new WidgetFraseMotivacional(
                "Aprender requiere práctica y paciencia.",
                "Anónimo",
                "29/10/2026"
        ));

        widgets.add(new WidgetAlerta(
                "La entrega del ejercicio vence hoy.",
                "Alta",
                "28/10/2026"
        ));

        widgets.add(new WidgetAlerta(
                "Recuerda revisar el material de clase.",
                "Media",
                "29/10/2026"
        ));
    }

    public ArrayList<Renderizable> getWidgets() {
        return new ArrayList<>(widgets);
    }

    public Renderizable buscarPorId(int id) {
        for (Renderizable widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }

        return null;
    }

    public ArrayList<Renderizable> buscarPorNombre(String nombre) {
        ArrayList<Renderizable> resultados = new ArrayList<>();

        if (nombre == null || nombre.trim().isEmpty()) {
            return resultados;
        }

        String busqueda = nombre.trim()
                .toLowerCase(java.util.Locale.ROOT);

        for (Renderizable widget : widgets) {
            String nombreWidget = widget.getNombre()
                    .toLowerCase(java.util.Locale.ROOT);

            if (nombreWidget.contains(busqueda)) {
                resultados.add(widget);
            }
        }

        return resultados;
    }

    public boolean interactuarConWidget(int id) {
        Renderizable widget = buscarPorId(id);

        if (widget instanceof Interactivo) {
            Interactivo interactivo = (Interactivo) widget;
            interactivo.interactuar();
            return true;
        }

        return false;
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }
}

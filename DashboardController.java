import java.util.ArrayList;

public class DashboardController {
    private Dashboard modelo;
    private DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.alBuscar(e -> buscar());
        vista.alMostrarTodos(e -> mostrarTodos());
        vista.alOrdenar(e -> ordenar());
        vista.alInteractuar(e -> interactuar());

        mostrarTodos();
    }

    private void mostrarTodos() {
        ArrayList<Renderizable> widgets = modelo.getWidgets();

        vista.mostrarWidgets(widgets);
        vista.mostrarMensaje(
                "Mostrando " + widgets.size() + " widgets."
        );
    }

    private void buscar() {
        String nombre = vista.getTextoBusqueda();

        if (nombre.isEmpty()) {
            vista.mostrarMensaje("Escribe un nombre para buscar.");
            return;
        }

        ArrayList<Renderizable> resultados =
                modelo.buscarPorNombre(nombre);

        vista.mostrarWidgets(resultados);
        vista.mostrarMensaje(
                "Se encontraron " + resultados.size() + " widgets."
        );
    }

    private void ordenar() {
        modelo.ordenarPorMemoria();
        vista.mostrarWidgets(modelo.getWidgets());

        vista.mostrarMensaje(
                "Todos los widgets ordenados de menor a mayor memoria."
        );
    }

    private void interactuar() {
        int id;

        try {
            id = Integer.parseInt(vista.getTextoId());
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Ingresa un ID numérico válido.");
            return;
        }

        Renderizable widget = modelo.buscarPorId(id);

        if (widget == null) {
            vista.mostrarMensaje("No existe un widget con ese ID.");
            return;
        }

        boolean realizada = modelo.interactuarConWidget(id);

        if (realizada) {
            vista.mostrarWidgets(modelo.getWidgets());
            vista.mostrarMensaje(
                    "Interacción ejecutada en: " + widget.getNombre()
            );
        } else {
            vista.mostrarMensaje(
                    "Este widget es informativo y no permite interacción."
            );
        }
    }
}
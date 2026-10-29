import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DashboardView extends JFrame {
    private JPanel panelWidgets;

    private JTextField campoBusqueda;
    private JTextField campoId;

    private JButton botonBuscar;
    private JButton botonMostrarTodos;
    private JButton botonOrdenar;
    private JButton botonInteractuar;

    private JLabel etiquetaEstado;

    public DashboardView() {
        setTitle("Dashboard de widgets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel(
                "Mi Dashboard",
                JLabel.CENTER
        );

        titulo.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        JPanel controles = new JPanel(new FlowLayout());

        campoBusqueda = new JTextField(12);
        botonBuscar = new JButton("Buscar nombre");
        botonMostrarTodos = new JButton("Mostrar todos");
        botonOrdenar = new JButton("Ordenar por memoria");

        campoId = new JTextField(4);
        botonInteractuar = new JButton("Interactuar");

        controles.add(new JLabel("Nombre:"));
        controles.add(campoBusqueda);
        controles.add(botonBuscar);
        controles.add(botonMostrarTodos);
        controles.add(botonOrdenar);

        controles.add(new JLabel("ID:"));
        controles.add(campoId);
        controles.add(botonInteractuar);

        panelSuperior.add(titulo, BorderLayout.NORTH);
        panelSuperior.add(controles, BorderLayout.CENTER);

        panelWidgets = new JPanel(new GridLayout(0, 2, 15, 15));

        panelWidgets.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JScrollPane desplazamiento = new JScrollPane(panelWidgets);

        etiquetaEstado = new JLabel("Bienvenido al Dashboard.");

        etiquetaEstado.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        add(panelSuperior, BorderLayout.NORTH);
        add(desplazamiento, BorderLayout.CENTER);
        add(etiquetaEstado, BorderLayout.SOUTH);
    }

    public void mostrarWidgets(List<Renderizable> widgets) {
        panelWidgets.removeAll();

        for (Renderizable widget : widgets) {
            JComponent vista = widget.obtenerVista();

            String titulo = "ID " + widget.getId()
                    + " | " + widget.getNombre()
                    + " | " + widget.getMemoriaKB() + " KB";

            vista.setBorder(
                    BorderFactory.createTitledBorder(titulo)
            );

            panelWidgets.add(vista);
        }

        panelWidgets.revalidate();
        panelWidgets.repaint();
    }

    public String getTextoBusqueda() {
        return campoBusqueda.getText().trim();
    }

    public String getTextoId() {
        return campoId.getText().trim();
    }

    public void mostrarMensaje(String mensaje) {
        etiquetaEstado.setText(mensaje);
    }

    public void alBuscar(ActionListener accion) {
        botonBuscar.addActionListener(accion);
    }

    public void alMostrarTodos(ActionListener accion) {
        botonMostrarTodos.addActionListener(accion);
    }

    public void alOrdenar(ActionListener accion) {
        botonOrdenar.addActionListener(accion);
    }

    public void alInteractuar(ActionListener accion) {
        botonInteractuar.addActionListener(accion);
    }
}
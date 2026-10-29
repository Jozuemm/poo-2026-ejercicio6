public abstract class WidgetBase implements Renderizable {
    private static int siguienteId = 1;

    private final int id;
    private final String nombre;
    private final double memoriaKB;

    protected WidgetBase(String nombre, double memoriaKB) {
        this.id = siguienteId;
        siguienteId++;

        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getMemoriaKB() {
        return memoriaKB;
    }

    @Override
    public int compareTo(Renderizable otro) {
        return Double.compare(
                this.memoriaKB,
                otro.getMemoriaKB()
        );
    }
}
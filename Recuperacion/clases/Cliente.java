package clases;

public class Cliente {
    private final int TOTAL = 100;

    // Atributos
    private String nombre;
    private String email;
    private Producto[] historial = new Producto[TOTAL];
    private int ultimo;

    /**
     *  Constructor de la clase Cliente
     * @param nombre
     * @param email
     */
    public Cliente(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
        this.historial = new Producto[TOTAL];
        this.ultimo = 0;
    }

    /**
     *  mientras que haya espacio para rellenar historial sea verdadero y el siguiente
     *  espacio no supere el limite del array es decir sea "null", suma 1 al contador 
     *  del espacio que tenemos en el array en caso de que este supere el limite 
     *  saltará una excepción
     * @param producto
     */
    public void agregarCompra(Producto producto){
        this.historial[this.ultimo] = producto;
        this.ultimo = 0;
        while ((this.ultimo < TOTAL) && (this.historial[this.ultimo] !=null)) {
            this.ultimo++;
        }
    }

    public void mostrarHistorial(){
        for (Producto item : historial) {
            if (item != null) {
                System.out.println("Compra: "+item.getTitutlo());    
            }
            
        }
    }
}

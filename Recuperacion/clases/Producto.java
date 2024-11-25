package clases;

public class Producto {
    private final int TOTAL = 100;
    // Atributos
    private int id;
    private String titulo;
    private String tipo;
    private float precio;
    private int stock;

    private Producto[] productos = new Producto[TOTAL];
    private int ultimo;
    
    /**
     * Constructor de la clase producto
     * @param id
     * @param titulo
     * @param tipo
     * @param precio
     * @param stock
     */
    public Producto(int id, String titulo, String tipo, float precio, int stock ){
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
        this.productos = new Producto[TOTAL];
        this.ultimo = 0;
    }

    /**
     * get de titulo
     * @return
     */
    public String getTitulo(){
        return this.titulo;
    }

    /**
     * Setter de stock
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    /**
     * Mostrar los productos almacenados en el array
     */
    public void mostrarProductos() {
        for (Producto item : productos) {
            if (item!=null) {
                System.out.println("Producto: "+ item);
            }
        }
    }


}
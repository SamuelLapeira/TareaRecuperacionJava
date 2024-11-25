package clases;

public class Producto {

    private int id;
    private String titulo;
    private String tipo;
    private float precio;
    private int stock;
    
    /**
     * 
     */
    public Producto(int id, String titulo, String tipo, float precio, int stock ){
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

}
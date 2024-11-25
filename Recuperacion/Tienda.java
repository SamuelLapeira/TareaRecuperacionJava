/*************************************************************
 * Nombre: Samuel Lapeira Pérez                              *
 * Curso: 2º DAW                                             *
 * Tarea: Recuperación Programación 1º DAW                   *
 * Fecha: 25/11/2024                                         *
 *************************************************************/

import clases.Producto;

import java.util.Scanner;

import javax.swing.text.html.parser.Parser;

import clases.Cliente;
public class Tienda {
    public static Producto[] productos = new Producto[20] ;
    public static Cliente[] clientes = new Cliente[5] ;
    public static void main(String[] args) {
        inicializarDatos();
        boolean salir = false;
        int opcion = 0;

        do {
            opcion = 0;
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Gestión de Prodcutos");
            System.out.println("2. Realizar Venta");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    menuGestion();
                    break;
                
                case 2:
                    menuVenta();
                    break;
                case 3:
                    System.out.println("Cerrando programa... \n");
                    salir = true ;
                    break;
                default:
                    break;
            }
            
        } while (!salir);
    }
    
    /**
     *  Menú para la gestión
     * @param opcion
     */
    public static void menuGestion() {
        int id;
        String titulo;
        String tipo;
        float precio;
        int stock;
        boolean volver = false ;

        int opcion = 0;
        do {
            System.out.println("=== Gestión de Productos ===");
            System.out.println("1. Añadir nuevo producto");
            System.out.println("2. Mostrar Productos disponibles");
            System.out.println("3. Buscar productos por titulo");
            System.out.println("4. Actualizar el stock");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    System.out.print("\nID: ");
                    id = Integer.parseInt(System.console().readLine());
                    System.out.print("Titulo: ");
                    titulo = System.console().readLine();
                    System.out.print("Tipo: ");
                    tipo = System.console().readLine();
                    System.out.print("Precio: ");
                    precio = Integer.parseFloat(System.console().readLine());
                    System.out.print("Stock: ");
                    stock = Integer.parseInt(System.console().readLine());
                    Producto Libro = new Producto(id,titulo,tipo,precio,stock);
                    anadirProducto(Libro);
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProductoPorTitulo();
                    break;
                case 4:
                    actualizarStock();
                    break;
                case 5:
                    volver = true ;
                    break;
            }
        } while (!volver); 
    }

    /**
     * Funcion para inicializar los datos de los array productos y clientes
     * al iniciar el programa
     */
    public static void inicializarDatos(){
        // array productos
        productos[0] = new Producto(0, "Cien años de soledad", "Novela", 250.0f, 15);
        productos[1] = new Producto(1, "El Quijote", "Clásico", 180.0f, 30);
        productos[2] = new Producto(2, "1984", "Ficción distópica", 200.0f, 25);
        productos[3] = new Producto(3, "El gran Gatsby", "Literatura americana", 220.0f, 10);
        productos[4] = new Producto(4, "Harry Potter y la piedra filosofal", "Fantasía", 300.0f, 50);
        productos[5] = new Producto(5, "La sombra del viento", "Suspenso", 230.0f, 12);
        productos[6] = new Producto(6, "El código Da Vinci", "Thriller", 210.0f, 20);
        productos[7] = new Producto(7, "La metamorfosis", "Ficción", 150.0f, 40);
        productos[8] = new Producto(8, "Orgullo y prejuicio", "Romántico", 180.0f, 18);
        productos[9] = new Producto(9, "Sapiens: De animales a dioses", "No ficción", 350.0f, 8);
        // Array de clientes
        clientes[0] = new Cliente("samuel", "samuellapeira@gmail.com");
        clientes[1] = new Cliente("alberto", "albertolapeira@gmail.com");
        clientes[2] = new Cliente("juan", "juancid@gmail.com");
        clientes[3] = new Cliente("adrian", "adrianbueno@gmail.com");
        clientes[4] = new Cliente("rafa", "rafamaldonado@gmail.com");

        clientes[0].agregarCompra(productos[1]);
        clientes[0].agregarCompra(productos[2]);
        clientes[0].agregarCompra(productos[3]);
        clientes[0].agregarCompra(productos[4]);
        clientes[0].agregarCompra(productos[5]);
    }

    /**
     *  Funcion para añadir un nuevo producto
     * @param producto
     */
    public static void anadirProducto(Producto producto){
        boolean añadido = false;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null ) {
                productos[i] = producto;
                // Perdon por esto no sabia como más cerrarlo 
                i = productos.length; 
                System.out.println("Producto añadido correctamente");   
                añadido = true;           
            } 
        }
        if (añadido == false) {
            System.out.println("Colección completa, no se ha podido agregar el producto.");
        }
    }

    /**
     * Muestra los productos de forma consecutiva
     */
    public static void mostrarProductos(){
        for (Producto item : productos) {
            if (item != null) {
                System.out.println(item.getTitulo());
            }
        }
    }

    /**
     * Busca mediante un bucle foreach un producto que no sea nulo
     * y contenga el mismo titulo que el introducido por teclado
     */
    public static void buscarProductoPorTitulo(){
        String titulo; 

        System.out.print("Introduce el título del producto a buscar: ");
        titulo = System.console().readLine();

        for (Producto item : productos) {
            
            if (item != null && item.getTitulo().equals(titulo)) {
                System.out.println("Producto encontrado: " + item.getTitulo());
            }
            
        }
    }

    /**
     * Función que solicita al usuario el numero de id del producto que quiere actualizar
     * para posteriormente modificar su stock 
     */
    public static void actualizarStock(){
        int id = 0;
        int nuevoStock = 0;
        boolean encontrado = false;

        System.out.print("Introduce el ID del producto a actualizar: ");
        id = Integer.parseInt(System.console().readLine());
        System.out.println("");

        System.out.print("Introduce la nueva cantidad de stock: ");
        nuevoStock = Integer.parseInt(System.console().readLine());

        do {
            for (Producto item : productos) {
                if (item != null && item.getId() == id) {
                    item.setStock(nuevoStock);
                    System.out.println("Stock actualizado correctamente.");
                    encontrado = true ;
                }
            }
        } while (!encontrado);
            
        if (encontrado == false) {
            System.out.println("Producto no encontrado.");
        }

    }
    ///////////////////////////////////////////////////// 
    /**
     * Menú para realizar las ventas
     * @param opcion
     */
    public static void menuVenta() {
        int opcion;
        boolean volver = false;

        while (!volver) {
            opcion = 0;
            System.out.println("=== Realizar Venta ===");
            System.out.println("1. Seleccionar producto");
            System.out.println("2. Seleccionar cliente");
            System.out.println("3. Confirmar venta");
            System.out.println("4. Aplicar descuento aleatorio");
            System.out.println("5. Ver historial de compras");
            System.out.println("6. Ver productos más vendidos");
            System.out.println("7. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    seleccionarProductoVenta();
                    break;
                case 2:
                    seleccionarClienteVenta();
                    break;
                case 3:
                    confirmarVenta();
                    break;
                case 4:
                    aplicarDescuento();
                    break;
                case 5:
                    mostrarHistorial();
                    break;
                case 6:
                    verProductosMasVendidos();
                    break;
                case 7:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    private static Producto productoSeleccionado = null;
    /**
     * función para seleccionar un producto en concreto
     */
    private static void seleccionarProductoVenta() {
        int idProducto;
        Producto productoSeleccionado;
        boolean encontrado = false;
        System.out.println("=== Seleccionar Producto ===");
        System.out.println("Selecciona el ID del producto:");

        // Mostrar productos disponibles
        for (Producto producto : productos) {
            if (producto != null && producto.getStock() > 0) {
                System.out.println(producto.getId() + ". " + producto.getTitulo() + " - Stock: " + producto.getStock());
            }
        }

        idProducto = Integer.parseInt(System.console().readLine());

        for (Producto item : productos) {
            if (item != null && item.getId() == idProducto && item.getStock() > 0) {
                    productoSeleccionado = item;
                    System.out.println("Producto seleccionado: " + item.getTitulo());
                    encontrado = true ;
            } else {
                System.out.println("No hay stock disponible para este producto.");
            }
        }
        if (encontrado == false) {
            System.out.println("Producto no encontrado.");
        }
        
    }

    private static Cliente clienteSeleccionado = null;
    /**
     * Funcion para seleccionar un cliente en concreto
     */
    private static void seleccionarClienteVenta() {
        int idCliente;
        boolean encontrado = false;
        System.out.println("=== Seleccionar Cliente ===");
        System.out.println("Selecciona el ID del cliente:");

        // Mostrar clientes disponibles
        for (Producto item : productos) {
            if (item != null && item.getStock() > 0) {
                System.out.println(item.getId() + ". " + item.getTitulo() + " - Stock: " + item.getStock());
            }
        }

        idCliente = Integer.parseInt(System.console().readLine());

        for (Producto item : clientes) {
            if (item != null && item.getId() == idCliente && item.getStock() > 0) {
                    clienteSeleccionado = item;
                    System.out.println("Producto seleccionado: " + item.getTitulo());
                    encontrado = true ;
            } else {
                System.out.println("No hay stock disponible para este producto.");
            }
        }
        if (encontrado == false) {
            System.out.println("Producto no encontrado.");
        }
        
    }

    /**
     * Confirma la venta de un producto en caso de que hayan sido
     * seleccionados tanto el producto como el cliente
     */
    private static void confirmarVenta() {
        if (productoSeleccionado == null) {
            System.out.println("No has seleccionado ningún producto.");
        }
        if (clienteSeleccionado == null) {
            System.out.println("No has seleccionado ningún cliente.");
        }
        if (clienteSeleccionado != null && productoSeleccionado != null) {
            
        
            // Confirmar venta solo si hay stock disponible
            if (productoSeleccionado.getStock() > 0) {
                // Reducir stock
                productoSeleccionado.setStock(productoSeleccionado.getStock() - 1);
        
                // Añadir compra al historial del cliente
                clienteSeleccionado.agregarCompra(productoSeleccionado);
        
                System.out.println("Venta confirmada. El cliente " + clienteSeleccionado.getNombre() +
                        " ha comprado " + productoSeleccionado.getTitulo() + ".");
            } else {
                System.out.println("No hay stock suficiente para realizar la venta.");
            }
        }
    }
    

    /**
     * Funcion que aplica un descuento de forma aleatoria en caso de 
     * que se hayan seleccionado tanto producto como cliente
     */
    private static void aplicarDescuento() {
        if (productoSeleccionado == null) {
            System.out.println("No has seleccionado ningún producto.");
        }
        if (clienteSeleccionado == null) {
            System.out.println("No has seleccionado ningún cliente.");
        }

        if (clienteSeleccionado != null && productoSeleccionado != null) {
            // Aplicar descuento aleatorio entre 5% y 20%
            double descuento = Math.random() * (0.20 - 0.05) + 0.05;
            float precioConDescuento = productoSeleccionado.getPrecio() * (1 - descuento);
        
            System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
            System.out.println("Nuevo precio del producto: " + precioConDescuento + "€");
        
            // Actualizar el precio con descuento
            productoSeleccionado.setPrecio(precioConDescuento);
        }
    }


    
}
     

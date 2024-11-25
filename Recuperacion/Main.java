import clases.Producto;
import clases.Cliente;
public class Main {
    
    public static void main(String[] args) {
        // Crear un array de Producto de tamaño 5
        Producto[] productos = {
            new Producto(0, "Cien años de soledad", "Novela", 250.0f, 15),
            new Producto(1, "El Quijote", "Clásico", 180.0f, 30),
            new Producto(2, "1984", "Ficción distópica", 200.0f, 25),
            new Producto(3, "El gran Gatsby", "Literatura americana", 220.0f, 10),
            new Producto(4, "Harry Potter y la piedra filosofal", "Fantasía", 300.0f, 50),
            new Producto(5, "La sombra del viento", "Suspenso", 230.0f, 12),
            new Producto(6, "El código Da Vinci", "Thriller", 210.0f, 20),
            new Producto(7, "La metamorfosis", "Ficción", 150.0f, 40),
            new Producto(8, "Orgullo y prejuicio", "Romántico", 180.0f, 18),
            new Producto(9, "Sapiens: De animales a dioses", "No ficción", 350.0f, 8)
        };

        Cliente[] clientes = {
            new Cliente("samuel", "samuellapeira@gmail.com"),
            new Cliente("alberto", "albertolapeira@gmail.com"),
            new Cliente("juan", "juancid@gmail.com"),
            new Cliente("adrian", "adrianbueno@gmail.com"),
            new Cliente("rafa", "rafamaldonado@gmail.com")
        
            
        };

        
        
    }
}
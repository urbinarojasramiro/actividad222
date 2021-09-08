/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.verduleria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author escor
 */
public class Verduleria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long numeroBase = 1000;
        boolean esDuoc = false;
        
        
        Scanner s = new Scanner(System.in);
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Bienvenido, ingrese su nombre:");
        Cliente cliente = new Cliente();
        String nombre = s.nextLine();
        cliente.setNombre(nombre);
        boolean esClienteValido = false;
        cliente.validateRun(esClienteValido, s, cliente);
        
        esClienteValido = cliente.validatePhone(esClienteValido, s, cliente);
        System.out.println("Ingrese su direccion:");
        String direccion = s.nextLine();
        cliente.setDireccion(direccion);
        
        cliente.validateMail(esClienteValido, s, cliente);
        int opcion = 0;
        Solicitud solicitud = new Solicitud();
        solicitud.crearNumeroSolicitud(numeroBase);
        solicitud.setFecha(date);
        while(opcion != 5){
            System.out.println("1.-Ingresar productos");
            System.out.println("2.-Ver detalle de pedido");
            System.out.println("5.-Salir");
            opcion = s.nextInt();
            if(opcion == 1){
                
                System.out.println("Ingrese el producto que necesita");
                Producto zanahoria = new Producto(1000, "Verdura","Zanahoria", 890, 1000);
                Producto pepino = new Producto(1010, "Verdura","Pepino", 579, 1);
                Producto pinha = new Producto(5000, "Fruta","Piña", 900, 1);
                Producto arandano = new Producto(5005, "Fruta","Arandanos", 1490, 125);
                System.out.println("1.- " + zanahoria.toString());
                System.out.println("2.- " + pepino.toString());
                System.out.println("3.- " + pinha.toString());
                System.out.println("4.- " + arandano.toString());
                int selectedProduct = s.nextInt();
                if(selectedProduct == 1){
                    System.out.println("Ingrese la cantidad en gramos: ");
                    int cantidad = s.nextInt();
                    s.nextLine();
                    solicitud.agregarProducto(zanahoria.getDescripcion());
                    double precioGramos = zanahoria.getPrecio() * cantidad / zanahoria.getTipoCantidad();
                    int precio = (int) (solicitud.getTotal() + precioGramos); 
                    solicitud.setTotal(precio);
                }
                if(selectedProduct == 2){
                    System.out.println("Ingrese la cantidad: ");
                    int cantidad = s.nextInt();
                    s.nextLine();
                    solicitud.agregarProducto(pepino.getDescripcion());
                    int precio = (int) (solicitud.getTotal() + pepino.getPrecio()); 
                    solicitud.setTotal(precio * cantidad);
                }
                
                if(selectedProduct == 3){
                    System.out.println("Ingrese la cantidad: ");
                    int cantidad = s.nextInt();
                    s.nextLine();
                    solicitud.agregarProducto(pinha.getDescripcion());
                    int precio = (int) (solicitud.getTotal() + pinha.getPrecio()); 
                    solicitud.setTotal(precio * cantidad);
                }
                
                if(selectedProduct == 4){
                    System.out.println("Ingrese la cantidad en gramos: ");
                    int cantidad = s.nextInt();
                    s.nextLine();
                    solicitud.agregarProducto(arandano.getDescripcion());
                    double precioGramos = arandano.getPrecio() * cantidad / arandano.getTipoCantidad();
                    int precio = (int) (solicitud.getTotal() + precioGramos); 
                    solicitud.setTotal(precio);
                }
                
            }
            
            if(opcion == 2){
                solicitud.mostrarDetallePedido(solicitud);
            }
            
        }
        
        
        
        System.out.println("Es usted un Alumno o funcionario de duoc?\n1.- Si\n2.- No");
        int respuesta = s.nextInt();
        if(respuesta == 1){
            esDuoc = true;
        }
        solicitud.realizarDescuento(esDuoc);
        
        solicitud.mostrarDetallePedido(solicitud);
    }
    
}

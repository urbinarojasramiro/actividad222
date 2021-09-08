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
        
        esClienteValido = false;
        while(!esClienteValido){
            System.out.println("Ingrese su numero de telefono:");
            String telefono = s.nextLine();
            if(telefono.length() == 8){
                esClienteValido = true;
                cliente.setTelefono(Long.parseLong(telefono));
            }else{
                System.out.println("El número telefónico debe tener 8 digitos");
            }
        }
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
                Producto zanahoria = new Producto(1000, "Verdura","Zanahoria", 850, 1000);
                Producto pepino = new Producto(1000, "Verdura","Pepino", 579, 1);
                Producto pinha = new Producto(1000, "Fruta","Piña", 1789, 1);
                Producto arandano = new Producto(1000, "Fruta","Arandanos", 1490, 1);
                System.out.println("1.- " + zanahoria.toString());
                System.out.println("2.- " + pepino.toString());
                System.out.println("3.- " + pinha.toString());
                System.out.println("4.- " + arandano.toString());
                int selectedProduct = s.nextInt();
                if(selectedProduct == 1){
                    solicitud.agregarProducto(zanahoria.getDescripcion());
                    int precio = (int) (solicitud.getTotal() + zanahoria.getPrecio()); 
                    solicitud.setTotal(precio);
                }
                
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

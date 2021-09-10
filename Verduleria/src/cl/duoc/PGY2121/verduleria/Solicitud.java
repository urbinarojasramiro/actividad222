/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.verduleria;

import java.util.Date;

/**
 *
 * @author escor
 */
public class Solicitud {
    private long numero;
    private Date fecha;
    private String cliente;
    private int total;
    private String productos;

    public Solicitud(long numero, Date fecha, String cliente, int total, String productos) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.productos = productos;
    }

    public Solicitud() {
    }
    
    public void agregarProducto(String producto){
        if(this.productos == null){
            this.productos = producto;
        }else{
            this.productos = this.productos + ";" + producto;
        }
    }
    
    public void mostrarDetallePedido(Solicitud solicitud){
        System.out.println("Estimado " + solicitud.getCliente()+" Su pedido es el siguiete:");
        System.out.println("Numero de pedido: " + solicitud.getNumero());
        System.out.println("Fecha de compra: " + solicitud.getFecha());
        String[] productoArray = solicitud.getProductos().split(";");
        for(int i = 0; i < productoArray.length; i++) {
            System.out.println(productoArray[i]);
        }
        System.out.println("Total Compra: " + solicitud.getTotal());
    }
    
    public void realizarDescuento(boolean esDuoc){
        if(esDuoc){
            double descuento = this.total * 0.3;
            this.total = this.total -  (int) Math.round(descuento);
        }
    }
    
    public void crearNumeroSolicitud(long numeroBase){
        this.numero = numeroBase + 1;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
    
    
}

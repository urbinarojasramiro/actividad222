/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.verduleria;

/**
 *
 * @author escor
 */
public class Producto {
    private long codigo;
    private String subCategoria;
    private String descripcion;
    private long precio;
    private long tipoCantidad;

    public Producto(long codigo, String subCategoria, String descripcion, long precio, long tipoCantidad) {
        this.codigo = codigo;
        this.subCategoria = subCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoCantidad = tipoCantidad;
    }

    public Producto() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public long getTipoCantidad() {
        return tipoCantidad;
    }

    public void setTipoCantidad(long tipoCantidad) {
        this.tipoCantidad = tipoCantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", subCategoria=" + subCategoria + ", descripcion=" + descripcion + ", precio=" + precio + ", tipoCantidad=" + tipoCantidad + '}';
    }
    
    
    
}

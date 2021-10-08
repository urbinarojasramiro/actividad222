/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.verduleria;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author escor
 */
public class Cliente {
    private int run;
    private String dv;
    private String nombre;
    private String mail;
    private String direccion;
    private long telefono;
    private List<String> lista;

    public Cliente(int run, String dv, String nombre, String mail, String direccion, long telefono) {
        this.run = run;
        this.dv = dv;
        this.nombre = nombre;
        this.mail = mail;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente() {
    }
    
    public void validateMail(boolean esClienteValido, Scanner s, Cliente cliente) {
        esClienteValido = false;
        while(!esClienteValido){
            System.out.println("Ingrese su mail:");
            String mail = s.nextLine();
            if(mail.length() > 6){
                esClienteValido = true;
                cliente.setMail(mail);
            }else{
                System.out.println("El mail debe tener al menos 6 letras");
            }
        }
    }
    
    public void validateRun(boolean esClienteValido, Scanner s, Cliente cliente) {
        while(!esClienteValido){
            System.out.println("Ingrese su run:");
            int run = s.nextInt();
            s.nextLine();
            
            System.out.println("Ingrese su digito verificador:");
            String dv = s.nextLine();
            int m = 0;
            int t = 1;
            for (; run != 0; run /= 10) {
                t = (t + run % 10 * (9 - m++ % 6)) % 11;
            }
            char dvs = dv.charAt(0);
            if (dvs == (char) (t != 0 ? t + 47 : 75)) {
                esClienteValido = true;
                cliente.setRun(run);
                cliente.setDv(dv);
            }else{
                System.out.println("El rut es invalido, ingrese nuevamente");
            }
        }
    }
    
    public boolean validatePhone(boolean esClienteValido, Scanner s, Cliente cliente) throws NumberFormatException {
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
        return esClienteValido;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
    
    
}

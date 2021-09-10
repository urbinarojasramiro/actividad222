/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dudasprueba;

import java.util.Date;

/**
 *
 * @author escor
 */
public class Prueba {
    private String nombreAlumno;
    private double nota;
    private Date fechaPrueba;

    public Prueba(String nombreAlumno, double nota, Date fechaPrueba) {
        this.nombreAlumno = nombreAlumno;
        this.nota = nota;
        this.fechaPrueba = fechaPrueba;
    }

    public Prueba() {
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Date getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(Date fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }
    
    
    
}

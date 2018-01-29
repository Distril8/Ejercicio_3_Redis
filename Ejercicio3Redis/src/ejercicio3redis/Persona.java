/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3redis;

/**
 *
 * @author DAVID
 */
public class Persona {
    private String cedula;
    private String Nombre;
    private String apellido;
    private String fechaNace;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(String fechaNace) {
        this.fechaNace = fechaNace;
    }
    
}

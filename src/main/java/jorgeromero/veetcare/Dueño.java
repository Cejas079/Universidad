/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jorgeromero.veetcare;

/**
 *
 * @author jorge romero
 */
import java.util.ArrayList;
import java.util.List;

public class Dueño {
  
    private String idDueño; 
    private String nombre;
    private String telefono;
    
    private List<Mascota> mascotas;

    
    public Dueño(String idDueño, String nombre, String telefono) {
        this.idDueño = idDueño;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mascotas = new ArrayList<>(); 
    }


    public void agregarMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }


    public String getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(String idDueño) {
        this.idDueño = idDueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

   
    @Override
    public String toString() {
        return "Dueño [ID=" + idDueño + ", Nombre=" + nombre + ", Teléfono=" + telefono + ", Cantidad de Mascotas=" + mascotas.size() + "]";
    }
}

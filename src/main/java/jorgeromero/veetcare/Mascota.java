/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jorgeromero.veetcare;

/**
 *
 * @author jorge romero
 */
public class Mascota {
    private String id;
    private String nombre;
    private String especie;


    public Mascota(String id, String nombre, String especie) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
    }

 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    @Override
    public String toString() {
        return "Mascota [ID=" + id + ", Nombre=" + nombre + ", Especie=" + especie + "]";
    }
}

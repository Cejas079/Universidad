/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jorgeromero.veetcare;

/**
 *
 * @author jorge romero
 */
public class HistoriaClinica {
    private String idMascota;      
    private String fechaAtencion;  
    private String motivo;         
    private String observaciones; 

  
    public HistoriaClinica(String idMascota, String fechaAtencion, String motivo, String observaciones) {
        this.idMascota = idMascota;
        this.fechaAtencion = fechaAtencion;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

  
    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

        @Override
    public String toString() {
        return "Historia Clínica [Mascota ID=" + idMascota + 
               ", Fecha=" + fechaAtencion + 
               ", Motivo=" + motivo + 
               ", Observaciones=" + observaciones + "]";
    }
}

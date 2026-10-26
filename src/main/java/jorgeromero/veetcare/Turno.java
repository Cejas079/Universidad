/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jorgeromero.veetcare;

/**
 *
 * @author jorge romero
 */
public class Turno {
    private String idMascota; // 
    private String fechaTurno; // mes-dia
    private String motivo;

 
    public Turno(String idMascota, String fechaTurno, String motivo) {
        this.idMascota = idMascota;
        this.fechaTurno = fechaTurno;
        this.motivo = motivo;
    }

  
    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(String fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Turno [Mascota ID=" + idMascota + ", Fecha/Turno=" + fechaTurno + ", Motivo=" + motivo + "]";
    }
}

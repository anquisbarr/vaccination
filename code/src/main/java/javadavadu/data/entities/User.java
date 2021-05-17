package data.entities;

import javax.persistence.*;
import static config.GlobalConstants.DB_CHAR_LENGTH;
import static config.GlobalConstants.DB_DNI_LENGTH;
import static config.GlobalConstants.DB_TELF_LENGTH;

import java.util.Calendar;

@Entity
@Table(name = "ciudadanos")
public class User {

    @Id
    @Column(name = "dni", length = DB_DNI_LENGTH)
    private String dni;

    @Column(name = "nombres", length = DB_CHAR_LENGTH, nullable = false, insertable = true)
    private String nombres;

    @Column(name = "apellido_p", length = DB_CHAR_LENGTH, nullable = false, insertable = true)
    private String apellidoP;

    @Column(name = "apellido_m", length = DB_CHAR_LENGTH, nullable = false, insertable = true)
    private String apellidoM;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false, insertable = true)
    private Calendar fechaNacimiento;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vacunacion")
    private Calendar fechaVacunacion;

    @Column(name = "telefono", length = DB_TELF_LENGTH)
    private String telefono;

    @Column(name = "correo_electronico", length = DB_CHAR_LENGTH)
    private String correoElectronico;
    
    public User(){
        //DEFAULT CONSTRUCTOR    
    }

    public User(String dni, String nombres, String apellidoP, String apellidoM, Calendar fechaNacimiento, 
                String telefono, String correoElectronico){
        this.dni = dni;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        setFechaVacunacion();
    }

    public void setFechaVacunacion(){
        fechaVacunacion = (Calendar) fechaNacimiento.clone();
        fechaVacunacion.add(Calendar.DAY_OF_YEAR, 5);
        fechaVacunacion.add(Calendar.MONTH, 1);
        fechaVacunacion.add(Calendar.YEAR,2022-fechaNacimiento.get(Calendar.YEAR));  
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Calendar getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public Calendar getFechaVacunacion(){
        return this.fechaVacunacion;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
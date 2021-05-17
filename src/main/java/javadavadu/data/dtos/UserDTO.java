package data.dtos;

import java.util.Calendar;

public class UserDTO {
    String dtoDni;
    String dtoNombres;
    String dtoApellidoP;
    String dtoApellidoM;
    Calendar dtoFechaNacimiento;
    String dtoTelefono;
    String dtoCorreoElectronico;

    public UserDTO(){
        //DEFAULT CONSTRUCTOR
    }

    public String getDtoDni() {
        return dtoDni;
    }

    public void setDtoDni(String dtoDni) {
        this.dtoDni = dtoDni;
    }

    public String getDtoNombres() {
        return dtoNombres;
    }

    public void setDtoNombres(String dtoNombres) {
        this.dtoNombres = dtoNombres;
    }

    public String getDtoApellidoP() {
        return dtoApellidoP;
    }

    public void setDtoApellidoP(String dtoApellidoP) {
        this.dtoApellidoP = dtoApellidoP;
    }

    public String getDtoApellidoM() {
        return dtoApellidoM;
    }

    public void setDtoApellidoM(String dtoApellidoM) {
        this.dtoApellidoM = dtoApellidoM;
    }

    public Calendar getDtoFechaNacimiento() {
        return dtoFechaNacimiento;
    }

    public void setDtoFechaNacimiento(Calendar dtoFechaNacimiento) {
        this.dtoFechaNacimiento = dtoFechaNacimiento;
    }

    public String getDtoTelefono() {
        return dtoTelefono;
    }

    public void setDtoTelefono(String dtoTelefono) {
        this.dtoTelefono = dtoTelefono;
    }

    public String getDtoCorreoElectronico() {
        return dtoCorreoElectronico;
    }

    public void setDtoCorreoElectronico(String dtoCorreoElectronico) {
        this.dtoCorreoElectronico = dtoCorreoElectronico;
    }

}
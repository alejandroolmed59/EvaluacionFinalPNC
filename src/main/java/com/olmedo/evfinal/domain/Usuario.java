package com.olmedo.evfinal.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(schema = "public", name = "usuario")
public class Usuario{
    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idmunicipio")
    private Municipio municipio;

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Size(min=3, max=30, message ="El campo no puede quedar vacio y maximo de 30 caracteres")
	@Column(name = "nombre")
    private String nombre;
	
	@Size(min=4, max=30, message ="El campo no puede quedar vacio y maximo de 30 caracteres")
    @Column(name = "apellido")
    private String apellido;
	
	@Size(min=4, max=30, message ="Minimo 4  y maximo de 30 caracteres")
    @Column(name = "nombreusuario")
    private String nombreUsuario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechanac")
    private Date fechaBD;
    
    @Size(min=4, max=100, message ="Minimo 4 caracteres y maximo de 30")
    @Column(name = "direccion")
    private String direccion;
    
    @Size(min=4, max=30, message ="Minimo 4 caracteres y maximo de 30")
    @Column(name = "contrasennia")
    private String contrasennia;

    @Column(name = "edad")
    private String edad;
    
    @Column(name = "estado")
    private boolean estado;

    @Column(name = "isadmin")
    private boolean admin;


    public Date getFechaBD() {
        return fechaBD;
    }

    public void setFechaBD(Date fechaBD) {
        this.fechaBD = fechaBD;
    }

    public Usuario() {
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Usuario(int idUsuario, Municipio municipio, String nombre, String apellido, String nombreUsuario, String nombre1, String direccion, String contrasennia, boolean estado, boolean admin) {
        this.idUsuario = idUsuario;
        this.municipio = municipio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre1;
        this.direccion = direccion;
        this.contrasennia = contrasennia;
        this.estado = estado;
        this.admin = admin;
    }

	public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasennia() {
        return contrasennia;
    }

    public void setContrasennia(String contrasennia) {
        this.contrasennia = contrasennia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEdad1Delegate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fechaBD );
        if (this.fechaBD == null) return "";
        else {
            LocalDate localFechaNac = LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()).toLocalDate();
            int edad = Period.between(localFechaNac, LocalDate.now()).getYears();
            return new Integer(edad).toString();
        }
    }
}

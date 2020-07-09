package com.olmedo.evfinal.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @NotEmpty(message = "El campo nombre no puede estar vacio")
	@Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "El campo apellido no puede estar vacio")
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty(message = "El campo nombre usuario no puede estar vacio")
    @Column(name = "nombreusuario")
    private String nombreUsuario;

    @NotNull(message = "El campo fecha no puede estar vacio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechanac")
    private Date fechaBD;


    @NotEmpty(message = "El campo direccion no puede estar vacio")
    @Column(name = "direccion")
    private String direccion;

    @NotEmpty(message = "El campo contrasennia no puede estar vacio")
    @Column(name = "contrasennia")
    private String contrasennia;

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
<<<<<<< HEAD
=======


    public String getEdadDelegate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fechaBD );
        if (this.fechaBD == null) return "";
        else {
            LocalDate localFechaBD = LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()).toLocalDate();
            int edad = Period.between(localFechaBD, LocalDate.now()).getYears();
            return new Integer(edad).toString();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUsuario == null) ? 0 :idUsuario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (idUsuario == null) {
            if (other.idUsuario != null)
                return false;
            } else if (!idUsuario.equals(other.idUsuario))
                return false;
            return true;
    }

    @Override
    public String toString() {
        return "User [id=" + idUsuario + ", username=" + nombreUsuario + ", password=" + contrasennia + "]";
    }
>>>>>>> 2be82afd61b07a8b09701942456d399d4e457e74
}

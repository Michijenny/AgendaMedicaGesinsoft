/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 *
 * @author enriq
 */
@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    private String tipoDocumento;
    @Column(unique = true)
    private String documento;
    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private String genero;
    private String fechanacimiento;
    private String estadoCivil;
    private String grupoSanguineo;
    @Column(unique = true)
    private String email;
    private String foto;
    @Column(unique = true)
    private int telefon1;
    private int telefon2;
    private int telefon3;
    private String direccion;
 
    @ManyToOne
    private Ciudad ciudad;
    
    public Persona() {
    }

   

    //RELACION PERSONA USUARIO
   /* @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;*/

    public Persona(Integer idPersona, String tipoDocumento, String documento, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String genero, String fechanacimiento, String estadoCivil, String grupoSanguineo, String email, String foto, int telefon1, int telefon2, int telefon3, String direccion) {
        this.idPersona = idPersona;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.genero = genero;
        this.fechanacimiento = fechanacimiento;
        this.estadoCivil = estadoCivil;
        this.grupoSanguineo = grupoSanguineo;
        this.email = email;
        this.foto = foto;
        this.telefon1 = telefon1;
        this.telefon2 = telefon2;
        this.telefon3 = telefon3;
        this.direccion = direccion;
    }

}

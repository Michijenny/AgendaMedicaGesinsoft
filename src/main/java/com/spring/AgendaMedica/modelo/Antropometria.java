/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "antropometria")
public class Antropometria {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAntropometria;
    private String fecha;
    private Integer edad;
    private double peso;
    private double talla;
    private double tronco;
    private double dsuspino;
    private double envergadura;
    private double bicipital;
    private double ileocristal;
    private double supraespinal;
    private double axilar;
    private double abdominal;
    private double tricipital;
    private double subescapular;
    private double pectoral;
    private double gemelo;
    private double muslofrontal;
    private double humeral;
    private double femoral;
    private double biacromial;
    private double biileocretideo;
    private double toraxap;
    private double muslo;
    private double tobillo;
    private double biliacodi;
    private double muñeca;
    private double toraxtrans;
    private double cefalico;
    private double torax;
    private double antebrazo;
    private double tobillo1;
    private double cintura;
    private double cuello;
    private double bicipitalrel;
    private double bicitalflex;
    private double muslo1;
    private double cadera;
    private double muñeca1;
    private double gemelo1;
    private double abdomen;
    private double acroestiloide;
    private double medioestdact;
    private double trocanterea;
    private double tribiallateral;
    private double tibMdMaleolar;
    private double acroradial;
    private double ilioespinal;
    private double trocTipLat;
    private double pie;
    private String anotaciones;
    private String prescripciones;

    public Antropometria() {
    }

    public Antropometria(Integer idAntropometria, Integer edad, double peso, double talla, double tronco, double dsuspino, double envergadura, double bicipital, double ileocristal, double supraespinal, double axilar, double abdominal, double tricipital, double subescapular, double pectoral, double gemelo, double muslofrontal, double humeral, double femoral, double biacromial, double biileocretideo, double toraxap, double muslo, double tobillo, double biliacodi, double muñeca, double toraxtrans, double cefalico, double torax, double antebrazo, double tobillo1, double cintura, double cuello, double bicipitalrel, double bicitalflex, double muslo1, double cadera, double muñeca1, double gemelo1, double abdomen, double acroestiloide, double medioestdact, double trocanterea, double tribiallateral, double tibMdMaleolar, double acroradial, double ilioespinal, double trocTipLat, double pie, String anotaciones, String prescripciones) {
        this.idAntropometria = idAntropometria;
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
        this.tronco = tronco;
        this.dsuspino = dsuspino;
        this.envergadura = envergadura;
        this.bicipital = bicipital;
        this.ileocristal = ileocristal;
        this.supraespinal = supraespinal;
        this.axilar = axilar;
        this.abdominal = abdominal;
        this.tricipital = tricipital;
        this.subescapular = subescapular;
        this.pectoral = pectoral;
        this.gemelo = gemelo;
        this.muslofrontal = muslofrontal;
        this.humeral = humeral;
        this.femoral = femoral;
        this.biacromial = biacromial;
        this.biileocretideo = biileocretideo;
        this.toraxap = toraxap;
        this.muslo = muslo;
        this.tobillo = tobillo;
        this.biliacodi = biliacodi;
        this.muñeca = muñeca;
        this.toraxtrans = toraxtrans;
        this.cefalico = cefalico;
        this.torax = torax;
        this.antebrazo = antebrazo;
        this.tobillo1 = tobillo1;
        this.cintura = cintura;
        this.cuello = cuello;
        this.bicipitalrel = bicipitalrel;
        this.bicitalflex = bicitalflex;
        this.muslo1 = muslo1;
        this.cadera = cadera;
        this.muñeca1 = muñeca1;
        this.gemelo1 = gemelo1;
        this.abdomen = abdomen;
        this.acroestiloide = acroestiloide;
        this.medioestdact = medioestdact;
        this.trocanterea = trocanterea;
        this.tribiallateral = tribiallateral;
        this.tibMdMaleolar = tibMdMaleolar;
        this.acroradial = acroradial;
        this.ilioespinal = ilioespinal;
        this.trocTipLat = trocTipLat;
        this.pie = pie;
        this.anotaciones = anotaciones;
        this.prescripciones = prescripciones;
    }
    
    //RELACION DE MUCHOS A UNO ANTROPOMETRIA PACIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPaciente", referencedColumnName ="idPaciente")
    private Paciente idPaciente;
    
    //RELACION CON LA TABLA  ANTROPOMETRIA - DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idDoctor", referencedColumnName ="idDoctor")
    private Doctor idDoctor;

}

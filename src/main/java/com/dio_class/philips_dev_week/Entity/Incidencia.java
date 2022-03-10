package com.dio_class.philips_dev_week.Entity;

import javax.persistence.*;

@Entity
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long Regiao_id;
    private Integer Mes;
    private Long Faixa_id;
    private Long Qnt_exames;

    public Incidencia(Long regiao_id, Integer mes, Long faixa_id, Long qnt_exames) {
        Regiao_id = regiao_id;
        Mes = mes;
        Faixa_id = faixa_id;
        Qnt_exames = qnt_exames;
    }

    public Incidencia(){}

    public Long getId() {
        return id;
    }

    public Long getRegiao_id() {
        return Regiao_id;
    }

    public void setRegiao_id(Long regiao_id) {
        Regiao_id = regiao_id;
    }

    public Integer getMes() {
        return Mes;
    }

    public void setMes(Integer mes) {
        Mes = mes;
    }

    public Long getFaixa_id() {
        return Faixa_id;
    }

    public void setFaixa_id(Long faixa_id) {
        Faixa_id = faixa_id;
    }

    public Long getQnt_exames() {
        return Qnt_exames;
    }

    public void setQnt_exames(Long qnt_exames) {
        Qnt_exames = qnt_exames;
    }
}

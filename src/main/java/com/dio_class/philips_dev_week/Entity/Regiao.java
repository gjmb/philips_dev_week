package com.dio_class.philips_dev_week.Entity;

import javax.persistence.*;

@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String regiao;
    private Integer total_exames;

    public Regiao(long l, String regiao, int total_exames) {
        this.regiao = regiao;
        this.total_exames = total_exames;
    }

    public Regiao(){}

    public Long getId() {
        return id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Integer getTotal_exames() {
        return total_exames;
    }

    public void setTotal_exames(Integer total_exames) {
        this.total_exames = total_exames;
    }
}

package com.incdivcorp.esgincdivcorp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_MONITORAMENTO_DIVERSIDADE")
public class MonitoramentoDiversidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A área (ex: RH, TI) é obrigatória.")
    @Size(max = 100, message = "A área deve ter no máximo 100 caracteres.")
    private String area;

    @NotNull(message = "O indicador (ex: Gênero, Etnia) é obrigatório.")
    @Size(max = 255, message = "O indicador deve ter no máximo 255 caracteres.")
    private String indicador;

    @NotNull(message = "O percentual é obrigatório.")
    @DecimalMin(value = "0.0", message = "O percentual não pode ser negativo.")
    @Column(precision = 5, scale = 2)
    private BigDecimal percentual;

    @NotNull(message = "A data de registro é obrigatória.")
    private LocalDate dataRegistro;

    public MonitoramentoDiversidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = percentual;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
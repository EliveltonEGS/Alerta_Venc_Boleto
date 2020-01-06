package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Boletos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(length = 200, nullable = false)
    private String beneficiario;

    @Column(nullable = false, precision = 6, scale = 2)
    private Double valor;

    //data de vencimento do boleto
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtVenc;

    //pagou ou não pagou o boleto
    @Column(length = 3, nullable = false)
    private String status;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDtVenc() {
        return dtVenc;
    }

    public void setDtVenc(Date dtVenc) {
        this.dtVenc = dtVenc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Boletos{" + "codigo=" + codigo + ", beneficiado="
                + beneficiario + ", valor=" + valor + ", dtVenc="
                + dtVenc + ", status=" + status + '}';
    }

}

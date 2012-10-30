package org.timecontrol.domain;

public class TijdRegistratie {

    private String code;

    private Double uren;

    public TijdRegistratie() {
        super();
    }

    public TijdRegistratie(String code, Double uren) {
        this.code = code;
        this.uren = uren;
    }

    public Double getUren() {
        return uren;
    }

    public void setUren(Double uren) {
        this.uren = uren;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TijdRegistratie{" +
                "code='" + code + '\'' +
                '}';
    }
}

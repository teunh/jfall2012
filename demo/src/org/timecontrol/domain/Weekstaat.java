package org.timecontrol.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: teunh
 * Date: 10/29/12
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Weekstaat {

    private int weeknummer;

    private int jaar;

    private List<TijdRegistratie> tijdRegistraties = new ArrayList<>();

    public Weekstaat() {
    }

    public Weekstaat(int weeknummer, int jaar, List<TijdRegistratie> tijdRegistraties) {
        this.weeknummer = weeknummer;
        this.jaar = jaar;
        this.tijdRegistraties.addAll(tijdRegistraties);
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public List<TijdRegistratie> getTijdRegistraties() {
        return tijdRegistraties;
    }

    public void setTijdRegistraties(List<TijdRegistratie> tijdRegistraties) {
        this.tijdRegistraties = tijdRegistraties;
    }

    public int getWeeknummer() {
        return weeknummer;
    }

    public void setWeeknummer(int weeknummer) {
        this.weeknummer = weeknummer;
    }

    public void addRegistratie(TijdRegistratie registratie) {
        this.tijdRegistraties.add(registratie);
    }
}

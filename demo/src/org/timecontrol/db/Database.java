package org.timecontrol.db;

import org.timecontrol.domain.TijdRegistratie;
import org.timecontrol.domain.Weekstaat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Database {

    INSTANCE();

    private List<Weekstaat> weekstaten = new ArrayList<>();

    private Database() {
         init();
    }

    private void init() {
        weekstaten.add(new Weekstaat(40, 2012, Arrays.asList(new TijdRegistratie("DESIGN", 2.0), new TijdRegistratie("REVIEW", 10.0), new TijdRegistratie("PROOF OF CONCEPT", 28.0))));
        weekstaten.add(new Weekstaat(41, 2012, Arrays.asList(new TijdRegistratie("IMPLEMENTING", 32.0), new TijdRegistratie("DESIGN", 10.0), new TijdRegistratie("DEMO", 1.0))));
        weekstaten.add(new Weekstaat(42, 2012, Arrays.asList(new TijdRegistratie("BUGFIXING", 1.0), new TijdRegistratie("DESIGN", 12.0), new TijdRegistratie("IMPLEMENTING", 27.0))));
        weekstaten.add(new Weekstaat(43, 2012, Arrays.asList(new TijdRegistratie("IMPLEMENTING", 10.0), new TijdRegistratie("DESIGN", 10.0), new TijdRegistratie("DOCUMENTEREN", 20.0))));
        weekstaten.add(new Weekstaat(44, 2012, Arrays.asList(new TijdRegistratie("DESIGN", 1.0), new TijdRegistratie("DOCUMENTEREN", 1.0))));
    }

    public Weekstaat getWeekstaat(int jaar, int weeknummer) {
        for (Weekstaat weekstaat : this.weekstaten) {
            if (weekstaat.getJaar() == jaar && weekstaat.getWeeknummer() == weeknummer) {
                return weekstaat;
            }
        }
        return null;
    }

    public void save(int jaar, int weeknummer, TijdRegistratie registratie) {
        Weekstaat weekstaat = getWeekstaat(jaar, weeknummer);
        weekstaat.addRegistratie(registratie);
    }

    public List<Weekstaat> getWeekstaten() {
        return Collections.unmodifiableList(this.weekstaten);
    }
}

package de.onsite.ood.datapump2;

import java.util.Random;

class DatabaseStore {
    private Random random = new Random();
    DatabaseStore(String user, String password, String jdbcurl) {
        // just a fake class, so no content here
    }

    /**
     * diese Methode speichert beliebige Werte, benötigt aber eine eindeutige ID.
     * Die Wahl der Id hat keine weitere Bedeutung
     *
     * @param id
     * @param value
     */
    void save(long id, Object value) {
        if (random.nextInt(10) == 0)
            throw new IllegalStateException("Die Datenbank ist kaputt, bitte verwende für die nächsten 10 Aufrufe einen Textstore");
        System.out.println("Stored in DB: " + value);
    }

}

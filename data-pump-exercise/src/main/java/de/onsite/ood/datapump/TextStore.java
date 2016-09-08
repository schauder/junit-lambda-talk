package de.onsite.ood.datapump;

import java.io.File;

class TextStore {
    TextStore(File file) {
        // just a fake class, so no content here
    }

    /**
     * speichert String, in dem sie an das Ende der Datei anghängt werden
     *
     * Werte müssen also erst in einen String umgewandelt werden.
     */
    void write(String value) {
        System.out.println("stored in text file: " + value);
    }

}

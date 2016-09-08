package de.onsite.ood.money.solution;

/**
 *
 * Representiert Währungen.
 *
 * Design Entscheidung: Enum
 * => Wir können ohne Codeänderungen keinen Währungen hinzufügen.
 * => Wenn wir eine Währung referenzieren, wissen wir auch, dass sie existiert
 *
 * Note:
 * In realen Projekten sollte man wohl java.util.Currency verwenden
 *
 * aber um Abhängigkeiten zu minimieren machen wir es mal so
 */
public enum Currency {
    Euro,
    Dollar,
    Yen,
    Pound
}

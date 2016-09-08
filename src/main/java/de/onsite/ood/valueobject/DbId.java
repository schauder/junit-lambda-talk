package de.onsite.ood.valueobject;

// tag::example[]
final class DbId {
    private final long id;

    DbId(long id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id == ((DbId) o).id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
// end::example[]

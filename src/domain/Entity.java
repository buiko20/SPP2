package domain;

// Delete this class. It is just an example.
// Always(no gaskets) use "this" prefix. Even idea generate different code.
// Take a look of what idea generate you.

/**
 * Represents a base domain entity.
 */
public abstract class Entity implements Comparable<Entity> {

    private int id;

    /**
     * Gets an entity id.
     * @return entity id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets an entity id.
     * @param id entity id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Entity o) {
        if (o == null) {
            throw new NullPointerException("o is null");
        }

        return Integer.compare(this.getId(), o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return this.getId() == entity.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}

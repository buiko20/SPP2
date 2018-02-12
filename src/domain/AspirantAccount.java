package domain;

/**
 * Represents a...
 */
public class AspirantAccount implements Comparable<AspirantAccount> {

    // TODO: write here necessary data and fields.
    // TODO: implement Comparable<AspirantAccount>.
    // TODO: override equals and hashCode. P.S. alt+insert or ctrl+o and idea will do it for you.
    // Note: do not forget about javadoc.
    // Note: for get methods use "Gets a...", for set methods - "Sets a...".
    // For boolean and other similar types use "Gets/Sets a value indicating..."

    private int id;
    private int data1;
    private String field1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Example. Delete this.
    @Override
    public int compareTo(AspirantAccount o) {
        if (o == null) {
            throw new NullPointerException("o is null");
        }

        return Integer.compare(this.getId(), o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        AspirantAccount that = (AspirantAccount) o;

        if (this.getId() != that.getId()) return false;
        if (data1 != that.data1) return false;
        return field1.equals(that.field1);
    }

    @Override
    public int hashCode() {
        int result = this.getId();
        result = 31 * result + data1;
        result = 31 * result + field1.hashCode();
        return result;
    }
}

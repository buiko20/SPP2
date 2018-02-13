package domain;

/**
 * Represents an aspirant account domain model.
 */
public class AspirantAccount implements Comparable<AspirantAccount> {

    private int id;
    private String email;
    private String password;
    private int aspirantProfileId;

    /**
     * Initializes a new instance of the {@link AspirantAccount model}
     * @param id aspirant account id
     */
    public AspirantAccount(int id) {
        this.id = id;
    }

    /**
     * Initializes a new instance of the {@link AspirantAccount model}
     * @param id aspirant account id
     * @param email aspirant email
     * @param password aspirant password
     * @param aspirantProfileId aspirant profile id
     */
    public AspirantAccount(int id, String email, String password, int aspirantProfileId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.aspirantProfileId = aspirantProfileId;
    }

    /**
     * Gets an aspirant account id
     * @return aspirant account id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets an aspirant email
     * @return aspirant email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets an aspirant email
     * @param email aspirant email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets an aspirant password
     * @return aspirant password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets an aspirant password
     * @param password aspirant password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets an aspirant profile id
     * @return aspirant profile id
     */
    public int getAspirantProfileId() {
        return aspirantProfileId;
    }

    /**
     * Sets an aspirant profile id
     * @param aspirantProfileId aspirant profile id
     */
    public void setAspirantProfileId(int aspirantProfileId) {
        this.aspirantProfileId = aspirantProfileId;
    }

    @Override
    public int compareTo(AspirantAccount obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }

        return Integer.compare(this.getId(), obj.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        AspirantAccount aspirantAccount = (AspirantAccount)obj;

        return this.getId() == aspirantAccount.getId();
    }
}

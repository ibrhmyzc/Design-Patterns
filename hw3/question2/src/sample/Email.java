package sample;

public class Email {
    private String ownerName;
    private String emailAddress;

    /**
     * Constructor for Email class
     * @param ownerName name of the owner
     * @param emailAddress email address
     */
    public Email(String ownerName, String emailAddress) {
        this.ownerName = ownerName;
        this.emailAddress = emailAddress;
    }

    /**
     * Getter for owner name
     * @return name of the owner
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Setter for the owner
     * @param ownerName sets the owner name
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Getter for the email address
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter for the email adress
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

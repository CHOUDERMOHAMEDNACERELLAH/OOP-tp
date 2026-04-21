package tp7.exo2.simple;

public class Client extends IntegratedElement {
    private static final long serialVersionUID = 1L;

    private String email;
    private int loyaltyPoints;

    public Client(String id, String name, String email, int loyaltyPoints) {
        super(id, name, "Client");
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getEmail() {
        return email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public void validate() throws InvalidDataException {
        validateCommon();
        if (email == null || !email.contains("@")) {
            throw new InvalidDataException("Email is invalid.");
        }
        if (loyaltyPoints < 0) {
            throw new InvalidDataException("Points cannot be negative.");
        }
    }

    @Override
    public String toTextLine() {
        return "CLIENT;" + getId() + ";" + getName() + ";" + email + ";" + loyaltyPoints;
    }

    @Override
    public String display() {
        return super.display() + ", email=" + email + ", points=" + loyaltyPoints;
    }
}

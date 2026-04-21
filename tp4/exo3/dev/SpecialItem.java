package tp4.exo3.dev;

public class SpecialItem extends Item {
    private String category;
    private boolean restricted;

    public SpecialItem(String title, String code, int year, String category, boolean restricted) {
        super(title, code, year);
        this.category = category;
        this.restricted = restricted;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public void showReference() {
        System.out.println("Reference for: " + getTitle() + " [" + category + "]");
    }

    public void checkAccess() {
        if (restricted) {
            System.out.println(getTitle() + " is RESTRICTED. Special permission required.");
        } else {
            System.out.println(getTitle() + " is available for general access.");
        }
    }

    public String toString() {
        return "Special | " + getTitle() + " | Code: " + getCode() + " | Year: " + getYear()
                + " | Cat: " + category + " | Restricted: " + restricted;
    }
}

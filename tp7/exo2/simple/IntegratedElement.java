package tp7.exo2.simple;

import java.io.Serializable;

public abstract class IntegratedElement implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String category;

    public IntegratedElement(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    protected void validateCommon() throws InvalidDataException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidDataException("ID cannot be empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be empty.");
        }
    }

    public abstract void validate() throws InvalidDataException;

    public abstract String toTextLine();

    public String display() {
        return "[" + category + "] " + id + " - " + name;
    }
}

package tp4.exo3.simple;

public class Item {
    private String title;
    private String code;
    private int year;

    public Item(String title, String code, int year) {
        this.title = title;
        this.code = code;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Item [title=" + title + ", code=" + code + ", year=" + year + "]";
    }
}

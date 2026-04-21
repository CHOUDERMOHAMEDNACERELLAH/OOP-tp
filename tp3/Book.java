public class Book {
    String title;
    String author;
    int pages;

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    void display() {
        System.out.println("Title: " + title + " | Author: " + author + " | Pages: " + pages);
    }

    boolean isBigBook() {
        return pages >= 300;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling", 450);
        Book b2 = new Book("Clean Code", "Robert Martin", 310);
        Book b3 = new Book("The Little Prince", "Antoine de Saint-Exupery", 96);

        b1.display();
        System.out.println("Is big book: " + b1.isBigBook());
        System.out.println();

        b2.display();
        System.out.println("Is big book: " + b2.isBigBook());
        System.out.println();

        b3.display();
        System.out.println("Is big book: " + b3.isBigBook());
    }
}

import java.util.Scanner;
class Book{
    String name;
    String author;
    double price;
    int num_pages;

Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    // Setters
    void setName(String name) {
        this.name = name;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setNumPages(int num_pages) {
        this.num_pages = num_pages;
    }

    // Getters
    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }

    double getPrice() {
        return price;
    }

    int getNumPages() {
        return num_pages;
    }

    // toString method
    public String toString() {
        return "Book Details:\n" +
               "Name: " + name + "\n" +
               "Author: " + author + "\n" +
               "Price:" + price + "\n" +
               "Pages: " + num_pages;
    }
}

public class BookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Book " + i + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of Pages: ");
            int pages = sc.nextInt();
            sc.nextLine(); // consume newline

            Book b = new Book(name, author, price, pages);
            System.out.println("\n" + b.toString());
        }

        sc.close();
    }
}
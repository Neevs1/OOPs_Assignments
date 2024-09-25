import java.util.Scanner;


class Publication {
    protected String title;
    protected double price;
    protected int copies;

    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public void saleCopy(int quantity) {
        if (quantity <= copies) {
            copies -= quantity;
            System.out.println("Sold " + quantity + " copies of " + title);
        } else {
            System.out.println("Not enough copies to sell.");
        }
    }

    public double totalSales() {
        return (copies * price);
    }
}


class Book extends Publication {
    private String author;

    public Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }

    public void orderCopies(int quantity) {
        copies += quantity;
        System.out.println("Ordered " + quantity + " new copies of " + title);
    }

    @Override
    public String toString() {
        return "Book Title: " + title + ", Author: " + author + ", Price: " + price + ", Copies Available: " + copies;
    }
}


class Magazine extends Publication {
    private String currentIssue;

    public Magazine(String title, double price, int copies, String currentIssue) {
        super(title, price, copies);
        this.currentIssue = currentIssue;
    }

    public void orderQty(int quantity) {
        copies += quantity;
        System.out.println("Ordered " + quantity + " new copies of " + title);
    }

    public void receiveIssue(String issue) {
        currentIssue = issue;
        System.out.println("Received new issue: " + currentIssue + " for " + title);
    }

    @Override
    public String toString() {
        return "Magazine Title: " + title + ", Current Issue: " + currentIssue + ", Price: " + price + ", Copies Available: " + copies;
    }
}


public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, auth, currIssue, Mname;
        int cop;
        double prz;

        // Enter Book details
        System.out.println("Enter book details: \n");
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Price: ");
        prz = sc.nextDouble();
        System.out.print("Copies: ");
        cop = sc.nextInt();
        sc.nextLine(); 

        Book book1 = new Book(name, prz, cop, "Joshua Bloch");

        // Enter Magazine details
        System.out.println("\nEnter Magazine details: \n");
        System.out.print("Name: ");
        Mname = sc.nextLine();
        System.out.print("Price: ");
        prz = sc.nextDouble();
        System.out.print("Copies: ");
        cop = sc.nextInt();
        sc.nextLine();
        System.out.print("Current Issue: ");
        currIssue = sc.nextLine();

        Magazine magazine1 = new Magazine(Mname, prz, cop, currIssue);

     
        System.out.println("\nBook Details: " + book1);
        System.out.println("Magazine Details: " + magazine1);

        // Order copies of the book
        System.out.print("Enter no of copies to order : ");
        int numcop=sc.nextInt();
        book1.orderCopies(numcop);
        System.out.println("After ordering copies: " + book1);

        // Sell some copies
        book1.saleCopy(3);
        System.out.println("Total sales from books: $" + book1.totalSales());

        // Order more copies of the magazine
        magazine1.orderQty(10);
        System.out.println("After ordering magazine copies: " + magazine1);

        // Receive a new issue
        magazine1.receiveIssue("October 2023");
        System.out.println("Updated Magazine: " + magazine1);

        // Sell some copies of the magazine
        magazine1.saleCopy(5);
        System.out.println("Total sales from magazines: $" + magazine1.totalSales());

        sc.close(); // Close the scanner
    }
}

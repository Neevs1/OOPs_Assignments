import java.util.*;

class publication{
	String title;
	int price,copies=50,sale;
	void saleCopy(){
		System.out.println("Total number of sales is");		
	}
	
}

class book extends publication{
	Scanner sc = new Scanner(System.in);
	boolean cop=false;
	int ordered;
	String Author;
	void orderCopies() {
		System.out.println("Enter name of book(Substitute spaces with underscores)");
		title = sc.next();
		title.replace('_',' ');
		System.out.println("Enter name of Author(Substitute spaces with underscores)");
		Author = sc.next();
		Author.replace('_',' ');
		do{System.out.println("Enter number of copies");
		ordered = sc.nextInt();
		if(ordered>this.copies) {
			System.out.println("Sorry, out of stock. Only "+this.copies+" books available");
			cop = true;
		}else {
			this.copies=this.copies-ordered;
			cop=false;
		}
		}while(cop==true);
		System.out.println("Enter price per copy");
		price = sc.nextInt();
	}
	
	void saleCopy() {
		sale = copies * price;
		
		System.out.println("Total sale for "+title+" by "+Author+" selling "+copies+" copies is "+sale);
	}
	
}

class magazine extends publication{
	String currentIssue;
	int qty;
	void receiveCopies() {
		
	}
}

public class Assignment2 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int totalCopies=0;
		long totalSale=0;
		
		String cont = "";
		
		
		do {
			System.out.println("Do you wish to purchase books(enter 1) or magazines(enter 2)");
			int c1 = sc.nextInt();
			switch(c1) {
			case 1:
				System.out.println("Enter number of titles");
				int no_b=sc.nextInt();
				book[] books = new book[no_b];
				for(int i=0;i<no_b;i++) {
					System.out.println("Enter information of book "+(i+1));
					books[i]=new book();
					books[i].orderCopies();
					totalCopies=totalCopies+books[i].ordered;
				}
				for(int i=0;i<no_b;i++) {
					books[i].saleCopy();
					totalSale=totalSale+books[i].sale;
				}
				break;
			case 2:
				System.out.println("Enter number of titles");
				int no_m=sc.nextInt();
				magazine[] mag = new magazine[no_m];
				for(int i=0;i<no_m;i++) {
					System.out.println("Enter information of book "+(i+1));
					mag[i]=new magazine();
					//mag[i].orderCopies();
					totalCopies=totalCopies+mag[i].copies;
				}
				for(int i=0;i<no_m;i++) {
					mag[i].saleCopy();
					totalSale=totalSale+mag[i].sale;
				}
				break;
				
			default:
				System.out.println("Invalid selection");
				break;
			}
			
		}while(cont.equals("yes"));
		
		/*for(int i=0;i<2;i++) {
			books[i]=new book();
			books[i].orderCopies();
			totalCopies=totalCopies+books[i].copies;
		}
		for(int i=0;i<2;i++) {
			books[i].saleCopy();
			totalSale=totalSale+books[i].sale;
		}*/
		System.out.println("Total copies sold are "+totalCopies+"\nTotal sales are "+totalSale);
		
	}

}

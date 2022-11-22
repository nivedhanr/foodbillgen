import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Product
{
    private int menucode;
    private String customer;
    private int qty;
    private double rate;
    private double totalPrice;



    Product(String customerName,int id, int qty, double price, double totalPrice)
    {
        this.menucode=menucode;
        this.customer = customer;
        this.qty = qty;
        this.rate = rate;
        this.totalPrice = totalPrice;
    }



    static void display(ArrayList<Product> p) {
        System.out.println("\n--------------Transaction History---------------\n");
        for (Product e : p) {
            System.out.println(("Name:" + e.customer));
            System.out.println(("Id:" + e.menucode));
            System.out.println(("Company:" + e.qty));
            System.out.println(("Contact:" + e.totalPrice));
            System.out.println("   ");
        }
    }



    public void display()
    {
        System.out.println("Product: " +menucode +"\n"+"Customer Name "+ customer +"\n" + "Quantity "+ qty +"\n" +
                "Single Piece Price:" +rate +"\n" + "Total price"+ totalPrice);
    }
}
class Shopping {
    public static void main(String args[]) {
        int quantity = 0;
        double rate = 0.0;
        double totalPrice = 0.0;
        double overAllPrice = 0.0;
        char choice = '\0';
        int flag1 = 0;
        Scanner scan = new Scanner(System.in);
        List<Product> product = new ArrayList<Product>();
        while (flag1==0) {
            System.out.println("1.Tea,2.Coffee 3.Snacks 4.Idli 5.Dosa");
            System.out.print("Enter Customer Name: ");
            String customername = scan.next();
            do {
                System.out.print("Product ID: ");
                int menucode = scan.nextInt();
                System.out.print("Quantity: ");
                quantity = scan.nextInt();
                switch (menucode) {
                    case 1:
                        rate = 10;
                        totalPrice = 10 * quantity;
                        break;
                    case 2:
                        rate = 15;
                        totalPrice = 15 * quantity;
                        break;
                    case 3:
                        rate = 10;
                        totalPrice = 10 * quantity;
                        break;
                    case 4:
                        rate = 8;
                        totalPrice = 8 * quantity;
                        break;
                    case 5:
                        rate = 6;
                        totalPrice = 6 * quantity;
                        break;
                    case 6:
                        choice = 'n';
                    default:
                        System.out.println("invalid input");



                }
                overAllPrice = overAllPrice + totalPrice;
                product.add(new Product(customername, menucode, quantity, rate, totalPrice));
                System.out.print("Want to add more items? (y or n): ");
                choice = scan.next().charAt(0);
                scan.nextLine();
            }
            while (choice == 'y' || choice == 'Y');
            int flag = 0;
            do {
                System.out.println("1.Generate Bill 2.View All transactions  3.Exit");
                int menu = scan.nextInt();
                switch (menu) {
                    case 1:
                        System.out.println("Total Amount (Rs.) " + overAllPrice);
                        break;
                    case 2:
                        for (Product p : product) {
                            p.display();
                        }
                        break;
                    case 3:
                        flag = 1;
                        break;
                }
            } while (flag == 0);



        }
    }
}
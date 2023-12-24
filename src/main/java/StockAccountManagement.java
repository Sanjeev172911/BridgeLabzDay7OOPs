import java.util.ArrayList;
import java.util.Scanner;

class Stock{
    String shareName;
    int sharePrice;
    int numberOfShare;

    public Stock(String name,int price,int count){
        this.sharePrice=price;
        this.shareName=name;
        this.numberOfShare=count;
    }

    int valueOfStock(){
        return sharePrice*numberOfShare;
    }

}
public class StockAccountManagement {
    static ArrayList<Stock>stockCollection;
    static Scanner input=new Scanner(System.in);
    public static int totalValueOfStocks(){
        int total=0;

        for(Stock stock:stockCollection){
            total+=stock.valueOfStock();
        }

        return total;
    }

    public static void printValueOfEachStock(){
        for(Stock stock:stockCollection){
            System.out.println("Stock Name "+stock.shareName);
            System.out.println("Value of stock "+stock.valueOfStock());
        }
    }

    public static void main(String[] args) {
        stockCollection=new ArrayList<>();

        System.out.println("Enter the number of stock you want to buy ");
        int number=input.nextInt();

        for(int i=0;i<number;i++){
            System.out.println("Enter the name of Stock");
            input.nextLine();
            String name=input.nextLine();
            System.out.println("Enter the price of stock");
            int price=input.nextInt();
            System.out.println("Enter the number of stock ypu want to buy");
            int numberOfStock=input.nextInt();

            Stock stock=new Stock(name,price,numberOfStock);
            stockCollection.add(stock);
        }

        printValueOfEachStock();
        System.out.println("Total Value of Each Stock is "+totalValueOfStocks());
    }


}


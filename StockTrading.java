import java.util.*;

class stocks{
    String stockname;
    String stocksymbol;
    double price;
    public stocks(String stockname,String stocksymbol,double price){
        this.stockname=stockname;
        this.stocksymbol=stocksymbol;
        this.price=price;
    }
    public double getPrice() {
        return price;
    }
    public String getStockname() {
        return stockname;
    }
    public String getStocksymbol() {
        return stocksymbol;
    } 
}
class MyDetails{
    String name;
    double Amount;
    stocks s;
    String buyingStockSymbol;
    public MyDetails(String name,double Amount,String buyingStockSymbol) {
       this.Amount=Amount;
       this.name=name;
       this.buyingStockSymbol=buyingStockSymbol;
    }
    public double getAmount() {
        return Amount;
    }
    public String getName() {
        return name;
    }
    public stocks getS() {
        return s;
    }
    public String getBuyingStockSymbol() {
        return buyingStockSymbol;
    }
}
class buyingStocks{
    stocks s;
    MyDetails details;
    
}
class sellingStocks{
    stocks s;
    String sellingStockSymbol;
    public sellingStocks(String sellingStockSymbol){
        this.sellingStockSymbol=sellingStockSymbol;
    }

}
class StockManager{
    ArrayList<stocks> stocksArrayList=new ArrayList<>();
    ArrayList<MyDetails> DetailsArrayList=new ArrayList<>();

    stocks s1=new stocks("ANDROID","AND" ,9000.0);
    stocks s2=new stocks("APPLE","IOS" ,10000.0);
    stocks s3=new stocks("VIVO","VV" ,6000.0);
    stocks s4=new stocks("OPPO","OP" ,2000.0);

    void InitializeStocks(){
        stocksArrayList.add(s1);
        stocksArrayList.add(s2);
        stocksArrayList.add(s3);
        stocksArrayList.add(s4);
    }
    void displayStocks(){
        for(stocks s:stocksArrayList){
            System.out.println(" "+s.getStockname()+" "+s.getStocksymbol()+" "+s.getPrice());
        }
    }

    void InitializeDetails(String name,double Amount,String buyingStockSymbol){
        MyDetails d1=new MyDetails(name, Amount,buyingStockSymbol);
        DetailsArrayList.add(d1);
    }
    void displaydetails(){
        for(MyDetails d:DetailsArrayList){
            System.out.println(" " +d.getName()+" "+(d.getAmount())+" "+d.getBuyingStockSymbol());
        }
    }
}
class StockTrading{
    public static void main(String[] args) {
        StockManager st=new StockManager();
        st.InitializeStocks();
        Scanner sc=new Scanner(System.in);
        
        while (true) { 
        System.out.println("1.For Stocks");
        System.out.println("2.Buy Stocks");
        //System.out.println("3:Sell Stocks");
        //System.out.println("4.Exit");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
            st.displayStocks();
            break;
            case 2:
            System.out.println("Enter name of buyer:");
            String name=sc.next();
            System.out.println("Enter the amount in your account:");
            double Amount=sc.nextInt();
            System.out.println("Enter symbol of stock you want to buy");
            String buyingStockSymbol=sc.next();
            st.InitializeDetails(name, Amount,buyingStockSymbol);
            st.displaydetails();
            break;
            default:
            sc.close();
        }
   
        }
        
    }
}
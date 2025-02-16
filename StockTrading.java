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
    //stocks s;
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
    public String getBuyingStockSymbol() {
        return buyingStockSymbol;
    }
}
class StockManager{
    ArrayList<stocks> stocksArrayList=new ArrayList<>();

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

    stocks findStock(String buyingStockSymbol){
        for(stocks s:stocksArrayList){
            if(s.getStocksymbol().equals(buyingStockSymbol)){
                return s;
            }
        }
        return null;
    }
}
class buyingStocks{
    StockManager sManager;
    ArrayList<MyDetails> DetailsArrayList=new ArrayList<>();
    public buyingStocks(StockManager sManager) {
     this.sManager=sManager;
    }
    void buyStock(String name,double Amount,String buyingStockSymbol){
        stocks st=sManager.findStock(buyingStockSymbol);
        if(st!=null && Amount>=st.getPrice()){
            MyDetails details=new MyDetails(name,Amount,buyingStockSymbol);
            DetailsArrayList.add(details);
            System.out.println("Stock buyed");
        }
        else{
            System.out.println("Stock not found");
        }
    }
    void displaydetails(){
        
        for(MyDetails d:DetailsArrayList){
            stocks buyingStockPrice= sManager.findStock(d.buyingStockSymbol);
            System.out.println(" "+d.getName()+" "+(d.getAmount()-buyingStockPrice.getPrice())+" "+d.getBuyingStockSymbol());
        }
    }
    
}
class sellingStocks{
    StockManager sManager;

    public sellingStocks(StockManager sManager) {
        this.sManager = sManager;
    }
    void sellStocks(String sellingStockSymbol){
        stocks st=sManager.findStock(sellingStockSymbol);
        if(st!=null){
            System.out.println("Sucessfully sold");
        }
        else{
            System.out.println("Stock not found");
        }
    }

}
class StockTrading{
    public static void main(String[] args) {
        StockManager st=new StockManager();
        st.InitializeStocks();
        buyingStocks buy = new buyingStocks(st);
        sellingStocks sell=new sellingStocks(st);
        Scanner sc=new Scanner(System.in);
        
        while (true) { 
        System.out.println("1.For Stocks");
        System.out.println("2.Buy Stocks");
        System.out.println("3:Sell Stocks");
        System.out.println("4.Exit");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
            st.displayStocks();
            break;
            case 2:
            System.out.println("Enter name of buyer:");
            String name=sc.next();
            System.out.println("Enter the amount in your account:");
            double Amount=sc.nextDouble();
            System.out.println("Enter symbol of stock you want to buy");
            String buyingStockSymbol=sc.next();
            buy.buyStock(name,Amount,buyingStockSymbol);
            buy.displaydetails();
            break;
            case 3:
            System.out.println("Enter symbol of stock you want to sell: ");
            String sellingStockSymbol=sc.next();
            sell.sellStocks(sellingStockSymbol);
            break;
            case 4:
            sc.close();
            System.exit(0);
            default:
            sc.close();
        }
   
        }
        
    }
}
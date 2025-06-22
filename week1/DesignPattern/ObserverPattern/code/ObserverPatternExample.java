public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("StockMobile");
        Observer webApp = new WebApp("StockWeb");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockData("GOOGL", 2734.87);
        stockMarket.setStockData("AAPL", 186.23);
    }
}

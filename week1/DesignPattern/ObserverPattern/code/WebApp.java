public class WebApp implements Observer {
    private String websiteName;

    public WebApp(String websiteName) {
        this.websiteName = websiteName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(websiteName + " site update: " + stockName + " is now $" + price);
    }
}

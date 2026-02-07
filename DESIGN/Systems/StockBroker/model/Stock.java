package model;

public class Stock {
    private String stockId;
    private String stockName;
    private double stockPrice;

    public Stock(String stockId, String stockName, double stockPrice) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    public String getStockId() {
        return stockId;
    }

    public String getStockName() {
        return stockName;
    }
    
    public double getStockPrice() {
        return stockPrice;
    }   

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }
}

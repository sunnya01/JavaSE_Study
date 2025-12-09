package Proj03.domain;

public class NoteBook implements Equipment{

    private String model;//机器的型号
    private double price;//机器的价格

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return this.model+'('+this.price+')';
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public NoteBook() {
    }
}

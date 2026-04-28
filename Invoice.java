public class Invoice {

    private String invoiceid;
    private String bookingid;
    private double roomcost;
    private double extras;
    private double taxes;
    private double total;

    public Invoice(String invoiceid, String bookingid, double roomcost, double extras, double taxes) {
        this.invoiceid = invoiceid;
        this.bookingid = bookingid;
        this.roomcost = roomcost;
        this.extras = extras;
        this.taxes = taxes;
        this.total = 0;
    }

    public double generate() {
        this.total = roomcost + extras + taxes;
       
        return total;
    }

    public void addExtra(double amount) {
        this.extras += amount;
        System.out.println( amount + "Total extras: " + extras);
    }

    public void applyDiscount(double discount) {
        this.total -= discount;
        System.out.println( + discount + "New total: " + total);
    }

    // Getters
    public String getInvoiceid() { return invoiceid; }
    public double getTotal()     { return total; }
}

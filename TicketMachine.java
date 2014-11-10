/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private double price;
    // The amount of money entered by a customer so far.
    private double balance;
    // The total amount of money collected by this machine.
    private double total;
    // The price of a discount ticket from this machine
    private double discountPrice;
    // The discount to be applied to the tickets of the machine
    private double discount;
    // Makes the TicketMachine able to print discount tickets
    private boolean canDiscount;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(double cost, double discountAmount, boolean ableToDiscount)
    {
        price = cost;
        if (ableToDiscount == true)
        {
            if (discountAmount >= 0 && discountAmount < 100){
                discount = discountAmount;
            }else{
                discount = 0;
            }
            discountPrice = cost * ((100 - discount) / 100);
        }else{
            discountPrice = cost;
            discount = 0;
        }
        canDiscount = ableToDiscount;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * @Return the price of a discount ticket
     */
    public double getDiscountPrice()
    {
        return discountPrice;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * Return the discount value to be applied to the tickets
     */
    public double getDiscount()
    {
        return discount;
    }
    
    public boolean setCanDiscount(boolean ableToDiscount)
    {
        canDiscount = ableToDiscount;
        return canDiscount;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(double amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " euro(s).");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            double amountLeftToPay = price - balance;
            System.out.println("You must insert at least: " +
            //Sustituido "price - balance" por variable local
                               amountLeftToPay + " more euro(s).");
                    
        }
    }
    
    /**
     * Print a DISCOUNT ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printDiscountTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + discountPrice + " euro(s).");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + discountPrice;
            // Reduce the balance by the prince.
            balance = balance - discountPrice;
        }
        else {
            //Creacion de variable local y asignacion de valor
            double amountLeftToPay = discountPrice - balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more euro(s).");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public double refundBalance()
    {
        double amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    /**
     * Devuelve el dinero que falta meter para poder sacar un ticket
     */
    public double getAmountLeftToPay()
    {
        double amountLeftToPay = 0;
        if (price > balance)
        {
            amountLeftToPay = price - balance;
        }
        return amountLeftToPay;
    }
    
    /**
     * Vacia por completo la maquina
     */
    public double emptyMachine(){
        double existentMoney = total;
        total = 0;
        return existentMoney;
    }
}

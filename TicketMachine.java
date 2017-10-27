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
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //para comprobar si el billete es premiado o no.
    private boolean premio;
    //guardar el numero de billetes
    private int numeroMaximoBilletes;

    private int billetesVendidos;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean billeteGanador, int numeroDeBilletes)
    {
        price = cost;
        balance = 0;
        total = 0;
        premio = billeteGanador;
        billetesVendidos = 0;
        numeroMaximoBilletes = numeroDeBilletes;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(billetesVendidos < numeroMaximoBilletes){
            if(amount > 0) {
                balance = balance + amount;
            }
            else {
                System.out.println("Use a positive amount rather than: " +
                    amount);
            }
        }
        else{
            System.out.println("Se han vendido todos los billetes");
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(billetesVendidos < numeroMaximoBilletes){
            if(balance >= price) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();

                if(premio == true){
                    System.out.println("###############");
                    System.out.println("Ticket Premiado!!");
                    System.out.println("###############");
                }

                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
                
                billetesVendidos = billetesVendidos + 1;
            }
            else {
                System.out.println("You must insert at least: " +
                    (price - balance) + " more cents.");

            }
        }
        else{
            System.out.println("Todos los billetes vendidos");
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * vacia la maquina de monedas, si esta una operacion en curso devuelve -1 
     * y nos muestra un mensaje de error
     */
    public int emptyMachine()
    {
        int totalDevuelto = -1;
        totalDevuelto = total;
        if(balance == 0){
            total = 0;
            balance = 0;
        }
        else{
            System.out.println("Hay una operacion en curso");
        }
        return totalDevuelto;
    }

    /**
     * public int emptyMachine()
    +    {
    +        int totalDevuelto;
    +        totalDevuelto = balance;
    +        total = 0;
    +        balance = 0;
    +        return totalDevuelto;
    +    }
     */
}

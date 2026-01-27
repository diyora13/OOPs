package L5;

public class Transaction {

    private final String payer;
    private final String payee;
    private final int amount;
    private final String method;
    private final int fee;
    private final int total;
    private final String status;
    private final String route; // which overload got selected

    Transaction(String payer, String payee, int amount, String method,
                int fee, int total, String status, String route) {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        this.method = method;
        this.fee = fee;
        this.total = total;
        this.status = status;
        this.route = route;
    }

    public void print() {
        System.out.println(
                "Payer: " + payer +
                        " Payee: " + payee +
                        " Amount: " + amount +
                        " Method: " + method +
                        " Fee: " + fee +
                        " Total: " + total +
                        " Status: " + status +
                        " Route: " + route
        );
    }

}

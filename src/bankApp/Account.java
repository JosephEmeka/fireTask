package bankApp;


public class Account extends Bank{

    private String name;
    private int balance;

    private String pin;

    private int number;

        public int getBalance(){
            return balance;
        }

        public void setBalance(int balance){
            balance = this.balance;
        }

        public void deposit(int amount){
            if(amount > 0) balance += amount;
        }

    public void withdraw(int amount, String myPin){
        if(amount > 0) balance += amount;
    }

    public void validatePin(String data) {
        if (pin.length()!= 4) {
            IllegalArgumentException exception;
            exception = new IllegalArgumentException("pin must be four digits long");
            throw exception;

        }
    }

}


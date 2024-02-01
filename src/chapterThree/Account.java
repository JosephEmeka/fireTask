package chapterThree;


public class Account{
    private int balance;

        public int getBalance(){
            return balance;
        }
        public void setBalance(int balance){
            balance = this.balance;
        }

        public void deposit(int amount){
            if(amount > 0) balance += amount;
        }

    public void withdraw(int amount){
        if(amount > 0) balance += amount;
    }




}


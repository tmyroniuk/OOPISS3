package plans;

public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(String str) {
        super(str);
    }
}

package services;

public class PayPalService implements OnlinePaymentService{
    private static final double  PAYMENT_FEE = 0.02;//taxa de juros em decimal 
    private static final double MOMTHLY_INTERREST  = 0.01;//taxa mensal
             
    @Override
    public double paymentFee(double amount) {
        return amount * PAYMENT_FEE;
        
    }

    @Override
    public double interest(double amount, int months) {
        return amount * months * MOMTHLY_INTERREST;
    }

    
    
    
}

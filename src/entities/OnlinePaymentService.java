package entities;


public interface OnlinePaymentService {
    public double valorpagamento(double quantia);
    public double parcelas(double quantia, int meses);
}

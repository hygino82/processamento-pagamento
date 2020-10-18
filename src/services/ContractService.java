package services;

import entities.Contract;
import entities.Installment;
import java.util.Calendar;


public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;
//construtor vai fornecer o paymentService
    public ContractService() {
    }

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }
    
    
    public void processContract(Contract contract,int months){
        //List<Installment> lista = new ArrayList<>();
        double basicQuota = contract.getTotalValue() / months;
        //pega valor do contrato e acha parcela básica = 200.00
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(contract.getDate());
        //gera o calendario
        for (int i = 1;i <= months;i++){
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
            //202.00
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            //206.04
            calendar.add(Calendar.MONTH, 1 );//aumenta 1 mes cada laço
            contract.getInstallments().add(new Installment(calendar.getTime(), fullQuota));
        }
        
    }

    
    
    
}

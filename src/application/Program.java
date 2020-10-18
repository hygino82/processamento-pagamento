package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        
        Date date = sdf.parse(sc.next());
        
        
        System.out.print("Contract value: ");
        double value = sc.nextDouble();
        System.out.print("Enter number of installments: ");
        int numberInstallments = sc.nextInt();
        System.out.println("Installments: ");
        double amount = (double) value / numberInstallments;
        
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
            
        for (int i = 1;i <= numberInstallments;i++){
            System.out.printf("Quota #%d\n", i);
            double parc = amount * (1 + 0.01 * i);
            double parcPay = parc * 1.02;
            
            calendar.add(Calendar.MONTH, 1 );//aumenta 1 mes cada laço
           
            System.out.println("Mes :" + sdf.format(calendar.getTime()));
            System.out.printf("%.2f\n", parc);
            System.out.printf("%.2f\n", parcPay);
        }

       
        sc.close();
    }
    
}

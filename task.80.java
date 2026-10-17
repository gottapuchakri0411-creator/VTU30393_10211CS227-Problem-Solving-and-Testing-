 import java.util.Scanner;

// Base Payment interface as specified
interface Payment {
    void pay(double amount);
    double getProcessingFeeRate();
    String getName();
}

// Concrete payment methods
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Implementation for credit card transaction execution
    }

    @Override
    public double getProcessingFeeRate() {
        return 0.02; // 2% processing fee
    }

    @Override
    public String getName() {
        return "CreditCard";
    }
}

class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Implementation for UPI transaction execution
    }

    @Override
    public double getProcessingFeeRate() {
        return 0.01; // 1% processing fee
    }

    @Override
    public String getName() {
        return "UPI";
    }
}

class NetBankingPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Implementation for Net Banking transaction execution
    }

    @Override
    public double getProcessingFeeRate() {
        return 0.015; // 1.5% processing fee
    }

    @Override
    public String getName() {
        return "NetBanking";
    }
}

// Abstract PaymentProcessor class
abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

// Concrete implementation of PaymentProcessor
class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        double fee = amount * payment.getProcessingFeeRate();
        double finalAmount = amount + fee;
        payment.pay(finalAmount);
        return finalAmount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            double amount = scanner.nextDouble();

            Payment payment = switch (type) {
                case 1 -> new CreditCardPayment();
                case 2 -> new UPIPayment();
                case 3 -> new NetBankingPayment();
                default -> null;
            };

            if (payment != null) {
                double finalAmount = processor.processPayment(payment, amount);
                System.out.printf("%s %.2f%n", payment.getName(), finalAmount);
            }
        }

        scanner.close();
    }
}


OUTPUT

3
1 1000
2 2000
3 5000
CreditCard 1020.00
UPI 2020.00
NetBanking 5075.00

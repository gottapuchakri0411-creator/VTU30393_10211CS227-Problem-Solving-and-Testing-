
import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    double rentPerDay;

    Vehicle(String vehicleNumber, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay;
    }

    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 0.90;
    }
}

class Truck extends Vehicle {
    Truck(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 1.20;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int type = sc.nextInt();
            String number = sc.next();
            double rent = sc.nextDouble();
            int days = sc.nextInt();

            Vehicle vehicle;

            if (type == 1) {
                vehicle = new Car(number, rent);
            } else if (type == 2) {
                vehicle = new Bike(number, rent);
            } else {
                vehicle = new Truck(number, rent);
            }

            System.out.printf("%s %.2f%n",
                    vehicle.vehicleNumber,
                    vehicle.calculateRent(days));
        }

        sc.close();
    }
}

1 CAR101 2000 3
2 BIKE201 500 4
3 TRUCK301 3000 2
CAR101 6000.00
BIKE201 1800.00
TRUCK301 7200.00

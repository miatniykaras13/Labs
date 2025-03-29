package Lab_6;

import java.util.Scanner;

public class SteeringWheel
{
    private int serialNumber;
    public SteeringWheel(int serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    public SteeringWheel set(Scanner sc)
    {
        SteeringWheel object = new SteeringWheel(0);
        System.out.print("Введите серийный номер руля: ");
        object.serialNumber  = sc.nextInt();
        return object;
    }
    public int getSerialNumber()
    {
        return serialNumber;
    }
}

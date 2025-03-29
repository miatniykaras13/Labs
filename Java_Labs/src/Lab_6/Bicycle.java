package Lab_6;

import java.util.Scanner;

public class Bicycle
{
    private enum Type
    {
        NotDefined,
        City,
        Road,
        Hybrid,
        MTB,
        BMX,
        Trial
    }
    private Wheel[] wheels;
    private SteeringWheel steeringWheel;
    private Type type;
    private String brand;
    private int serialNumber;
    private boolean isMoving;
    private boolean isDestroyed;



    public Bicycle(String brand, SteeringWheel steeringWheel,
               Type type, Wheel wheels[], int serialNumber) {
        this.type = type;
        this.steeringWheel = steeringWheel;
        this.wheels = wheels;
        this.serialNumber = serialNumber;
    }

    public String toString() {
        String string = "";
        String t = "Не определен";
        if(type == Type.City)
        {
            t = "Городской";
        }
        if(type == Type.Road)
        {
            t = "Шоссейный";
        }
        if(type == Type.Hybrid)
        {
            t = "Гибрид";
        }
        if(type == Type.MTB)
        {
            t = "Горный";
        }
        if(type == Type.BMX)
        {
            t = "BMX";
        }
        if(type == Type.Trial)
        {
            t = "Trial";
        }
        string += "Марка: " + brand +"; Тип: " + t + "; Серийный номер рамы: " + serialNumber + "; Серийный номер руля: " + steeringWheel.getSerialNumber() + "Информация о колесах: [";
        for (int i = 0; i < 2; ++i) {
            string += wheels[i].toString() + ((i<1)?"; ":"");
        }

        return string + "]";
    }

    public static Bicycle set(Scanner scanner) {
        Bicycle object = new Bicycle("", new SteeringWheel(0), Type.NotDefined, new Wheel[2], 0);

        System.out.print("Введите марку велосипеда: ");
        object.brand = scanner.next();

        System.out.println("Введите тип велосипеда");
        System.out.println("1-Городской");
        System.out.println("2-Шоссейный");
        System.out.println("3-Гибрид");
        System.out.println("4-Горный");
        System.out.println("5-BMX");
        System.out.println("6-Trial");
        while (true)
        {
            int val = scanner.nextInt();
            if(val == 1)
            {
                object.type = Type.City;
                break;
            }
            if(val == 2)
            {
                object.type = Type.Road;
                break;
            }
            if(val == 3)
            {
                object.type = Type.Hybrid;
                break;
            }
            if(val == 4)
            {
                object.type = Type.MTB;
                break;
            }
            if(val == 5)
            {
                object.type = Type.BMX;
                break;
            }
            if(val == 6)
            {
                object.type = Type.Trial;
                break;
            }
            System.out.println("Такого типа нет.");
        }
        System.out.print("Введите информацию о руле: \n");
        object.steeringWheel = object.steeringWheel.set(scanner);

        System.out.print("Введите информацию о колесах: \n");
        for(int i = 0; i < 2; i++)
        {
            if(i == 0)
                System.out.println("Переднее колесо");
            if(i == 1)
                System.out.println("Заднее колесо");
            object.wheels[i] = Wheel.set(scanner);
        }

        System.out.println("Введите серийный номер рамы велосипеда: ");
        object.serialNumber = scanner.nextInt();

        return object;
    }

    public void move()
    {
        if(isDestroyed)
        {
            System.out.println("Велосипед сломан. Движение невозможно.");
            return;
        }
        if(isMoving)
        {
            System.out.println("Велосипед уже двигается");
            return;
        }
        if (wheels[1].getDiameter() != wheels[0].getDiameter()) {
            System.out.println("Колеса разных диаметров, велосипед не может двигаться");
            return;
        }
        if(wheels[1].getPressure() <= 1 || wheels[0].getPressure() <= 1)
        {
            System.out.println("Давление в колесах слишком низкое, велосипед не может двигаться");
            return;
        }

        System.out.println("Велосипед двигается");
        isMoving = true;
    }

    public void stop() {
        if(isDestroyed)
        {
            System.out.println("Велосипед сломан");
            return;
        }
        if(!isMoving) {
            System.out.println("Велосипед уже стоит");
            return;
        }
        System.out.println("Велосипед затормозил");
        isMoving = false;
    }

    public void destroy()
    {
        isDestroyed = true;
        System.out.println("Велосипед сломался");
        isMoving = false;
    }
}

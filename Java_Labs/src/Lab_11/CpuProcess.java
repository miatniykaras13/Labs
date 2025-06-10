package Lab_11;

import java.util.Random;


class CpuProcess
{
    private static int nextId = 1;
    private final int id;
    private final int serviceTime;

    public CpuProcess(int minServiceTime, int maxServiceTime)
    {
        this.id = nextId++;
        Random random = new Random();
        this.serviceTime = random.nextInt(maxServiceTime - minServiceTime + 1) + minServiceTime;
    }

    public int getId() {
        return id;
    }

    public int getServiceTime() {
        return serviceTime;
    }
}

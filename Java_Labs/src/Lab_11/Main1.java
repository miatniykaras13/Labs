package Lab_11;

import java.util.Random;


public class Main1
{
    public static void main(String[] args)
    {
        int totalProcesses = 20;
        int firstQueueCapacity = 3;
        int secondQueueThreshold = 2;
        int minGenDelay = 100;
        int maxGenDelay = 300;
        int minServiceTime = 500;
        int maxServiceTime = 1000;

        Cpu cpu = new Cpu(firstQueueCapacity, secondQueueThreshold);

        Thread cpuThread = new Thread(cpu);
        cpuThread.start();

        Thread generationThread = new Thread(() ->
        {
            Random random = new Random();
            for (int i = 0; i < totalProcesses; i++)
            {
                try
                {
                    int delay = random.nextInt(maxGenDelay - minGenDelay + 1) + minGenDelay;
                    Thread.sleep(delay);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                CpuProcess process = new CpuProcess(minServiceTime, maxServiceTime);
                System.out.println("Сгенерирован процесс с ID " + process.getId());
                cpu.addProcess(process);
            }
            cpu.setGenerationCompleted(true);
            System.out.println("Генерация процессов завершена.");
        });
        generationThread.start();

        try
        {
            generationThread.join();
            cpuThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }
}

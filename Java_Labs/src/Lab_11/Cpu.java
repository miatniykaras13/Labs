package Lab_11;


class Cpu implements Runnable {
    private final CpuQueue firstQueue;
    private final CpuQueue secondQueue;
    private final int secondQueueThreshold;



    //statistics
    private int processedFromSecondQueue = 0;
    private int totalProcessed = 0;
    private int maxSecondQueueSize = 0;

    private volatile boolean generationCompleted = false;

    public Cpu(int firstQueueCapacity, int secondQueueThreshold)
    {
        this.firstQueue = new CpuQueue("Первая очередь", firstQueueCapacity);
        this.secondQueue = new CpuQueue("Вторая очередь", 0);
        this.secondQueueThreshold = secondQueueThreshold;

    }


    public synchronized void addProcess(CpuProcess process) {
        boolean addedInFirst = firstQueue.addProcess(process);
        if (!addedInFirst)
        {
            secondQueue.forceAddProcess(process);
            int currentSize = secondQueue.size();
            if (currentSize > maxSecondQueueSize)
            {
                maxSecondQueueSize = currentSize;
            }
        }
    }

    public void setGenerationCompleted(boolean flag) {
        generationCompleted = flag;
    }


    public void startProcessing()
    {
        while (!generationCompleted || !firstQueue.isEmpty() || !secondQueue.isEmpty())
        {
            boolean processedAny = false;


            if (!firstQueue.isEmpty() && secondQueue.size() < secondQueueThreshold)
            {
                CpuProcess process = firstQueue.getPeekProcess();
                if (process != null)
                {
                    processService(process, "из первой очереди");
                    totalProcessed++;
                    processedAny = true;
                }
                firstQueue.removeProcess();
            }

            else if (!secondQueue.isEmpty() && (generationCompleted || secondQueue.size() >= secondQueueThreshold))
            {
                CpuProcess process = secondQueue.getPeekProcess();
                if (process != null)
                {
                    processService(process, "из второй очереди");
                    processedFromSecondQueue++;
                    totalProcessed++;
                    processedAny = true;
                }
                secondQueue.removeProcess();
            }

            if (!processedAny)
            {
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Обслуживание всех процессов завершено.");
        printStatistics();
    }

    private void processService(CpuProcess process, String queueInfo)
    {
        System.out.println("Начинается обслуживание процесса ID " + process.getId() + " " + queueInfo +
                ". Время обслуживания: " + process.getServiceTime() + " мс");
        try
        {
            Thread.sleep(process.getServiceTime());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Завершено обслуживание процесса ID " + process.getId() + " " + queueInfo + ".");
    }

    public void printStatistics()
    {
        System.out.println("\n=== Статистика моделирования ===");
        System.out.println("Общее количество обработанных процессов: " + totalProcessed);
        if (totalProcessed > 0)
        {
            double percentage = (processedFromSecondQueue / (double) totalProcessed) * 100;
            System.out.printf("Процент процессов, обслуженных из второй очереди: %.2f%%\n", percentage);
        }
        else
        {
            System.out.println("Процессов для обслуживания не было.");
        }
        System.out.println("Максимальный размер второй очереди: " + maxSecondQueueSize);
    }

    @Override
    public void run() {
        startProcessing();
    }
}

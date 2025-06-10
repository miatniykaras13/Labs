package Lab_11;

import java.util.LinkedList;
import java.util.Queue;


class CpuQueue
{
    private final Queue<CpuProcess> queue = new LinkedList<>();
    private final int capacity;
    private final String queueName;

    public CpuQueue(String queueName, int capacity)
    {
        this.queueName = queueName;
        this.capacity = capacity;
    }

    public synchronized boolean addProcess(CpuProcess process)
    {
        if (capacity > 0 && queue.size() >= capacity)
        {
            return false;
        }
        else
        {
            queue.add(process);
            System.out.println("[" + queueName + "] Процесс ID " + process.getId() +
                    " добавлен. Текущий размер: " + queue.size());
            return true;
        }
    }
    public synchronized void forceAddProcess(CpuProcess process)
    {
        queue.add(process);
        System.out.println("[" + queueName + "] Процесс ID " + process.getId() +
                " добавлен (без ограничения). Текущий размер: " + queue.size());
    }
    
    public synchronized void removeProcess()
    {
        CpuProcess process = queue.poll();
        if (process != null)
        {
            System.out.println("[" + queueName + "] Процесс ID " + process.getId() +
                    " удалён. Текущий размер: " + queue.size());
        }

    }



    public synchronized int size() {
        return queue.size();
    }

    public synchronized CpuProcess getPeekProcess() { return queue.peek(); }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}

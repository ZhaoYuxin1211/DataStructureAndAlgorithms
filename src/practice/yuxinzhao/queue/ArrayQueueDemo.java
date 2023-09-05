package practice.yuxinzhao.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s:show 显示队列");
            System.out.println("e:exit 退出程序");
            System.out.println("a:add 添加数据到队列");
            System.out.println("g:get 从队列中取出数据");
            System.out.println("h:head 从队列中读取头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    System.out.println("Exit the program.");
                    loop = false;
                    break;
                case 'a':
                    System.out.println("Please enter a number:");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int v = arrayQueue.getQueue();
                        System.out.println("You get the value: " + v);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = arrayQueue.peed();
                        System.out.println("The head of queue is " + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    //并未模拟环形队列，因此此数组队列空间只能利用一次
    static class ArrayQueue {
        private int maxSize;    //数组的最大容量
        private int front;  //队列头
        private int rear;   //队列尾
        private int[] arr;  //用于存储数据，模拟队列

        //构造器
        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;
        }

        //判断队列是否已满
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return front == rear;
        }

        //添加数据
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("This queue is full and you cannot add data in it.");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        //出队列
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("This queue is empty. You cannot get data from it.");
            }
            front++;
            return arr[front];
        }

        //显示队列的所有数据
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("This queue is empty.");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d\n", i, arr[i]);
            }
        }

        //显示队列头数据
        public int peed() {
            if (isEmpty()) {
                throw new RuntimeException("This queue is empty.");
            }
            return arr[front + 1];
        }
    }
}

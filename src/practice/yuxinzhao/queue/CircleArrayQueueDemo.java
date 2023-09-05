package practice.yuxinzhao.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        circleArray circleArray = new circleArray(4);
        char key;
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
                    circleArray.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    System.out.println("Exit the program.");
                    loop = false;
                    break;
                case 'a':
                    System.out.println("Please enter a number:");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int v = circleArray.getQueue();
                        System.out.println("You get the value: " + v);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = circleArray.peed();
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

    static class circleArray {
        private int maxSize;    //数组的最大容量
        private int front;  //队列头
        private int rear;   //队列尾
        private int[] arr;  //用于存储数据，模拟队列

        //构造器
        public circleArray(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = 0;
            rear = 0;
        }

        //判断队列是否已满
        public boolean isFull() {
            return (rear + 1) % maxSize == front;
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
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }

        //出队列
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("This queue is empty. You cannot get data from it.");
            }
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        //求有效数据个数
        public int size() {
            return (rear - front + maxSize) % maxSize;
        }

        //显示队列的所有数据
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("This queue is empty.");
                return;
            }
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        //显示队列头数据
        public int peed() {
            if (isEmpty()) {
                throw new RuntimeException("This queue is empty.");
            }
            return arr[front];
        }

    }
}

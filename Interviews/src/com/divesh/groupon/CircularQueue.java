package com.divesh.groupon;

public class CircularQueue {
	private Object arr[];
	private int size, head, tail;
	private int MAXSIZE;

	public CircularQueue() {
		// default empty constructors as we will be using initialise
	}

	public void initialize(int maxSize) {
		MAXSIZE = maxSize;
		arr = new Object[MAXSIZE];
		head = tail = -1; // initialisation of the head and tail points to -1
		size = 0;// initial size to the queue is 0;
	}
    
	public synchronized boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public synchronized boolean isFull() {
		return size == MAXSIZE ? true : false;
	}
	
	public synchronized int getSize() {
		return size ;
	}
	public  int getMaxSize() {
		return MAXSIZE ;
	}
	public synchronized void enqueue(Object element) {
       if(isFull())
       {
    	   System.out.println("Queue is full");
       }
       else{
    	   if(isEmpty())
    	   {  // put element at starting of array and initialise tail and head
    		   arr[0]=element;  
    		   tail = head = 0;
    	   }
    	   else{
    		   if(tail != MAXSIZE-1)
    		   { //condition to check if tail is at last element of array.
    			   tail++;
    		   }
    		   else 
    		   {
    			   tail=0;
    		   }
    		   arr[tail]= element;
    	   }
    	   size++; // finally increasing the size of the queue
       }
	}
	public synchronized Object dequeue() {
       if(isEmpty())
       {
    	   System.out.println("Queue is empty");
    	   return null;
       }
       else{
    	   Object element = arr[head];
    	   if(head != MAXSIZE-1)
    		   head++;
    	   else 
    		   head--;
    	   // check if queue become empty if yes than set head n tail to -1
    	   if(isEmpty()){
    		   head = tail = -1;
    	   }
    	   size--; // finally decreasing the size of the queue 
    	   return element;
       }
	}
    /**helper function to test the above class
     * @throws InterruptedException */
	public static void main(String args[]) throws InterruptedException
	{
		CircularQueue queue = new CircularQueue();
		queue.initialize(5);
		
//		for(int i = 0; i <4;i++)
//			queue.enqueue(i);
		Thread t1 = new Thread(new Producer(queue));
		Thread t2 = new Thread(new Consumer(queue));
		t1.setName("producer");
		t2.setName("consumer");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(queue.getSize());
	}
}

class Producer implements Runnable{
	/**helper Class  to test queue class in multiThread enviroment*/
	CircularQueue queue;
	public Producer(CircularQueue queue) {
	this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
			System.out.println(Thread.currentThread().getName() +": " + queue.getSize());
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class Consumer implements Runnable{
	/**helper Class  to test queue class in multiThread enviroment*/
	CircularQueue queue;
	public Consumer(CircularQueue queue) {
	this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			queue.dequeue();
			System.out.println(Thread.currentThread().getName() +": "+ queue.getSize());
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
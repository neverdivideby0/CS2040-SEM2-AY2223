import java.util.*;
import java.io.*;

public class teque {
    public static void main(String[] args) {

        Kattio io = new Kattio (System.in, System.out);
        int numOfOperations = io.getInt();

        QueueArr frontTeque = new QueueArr();
        QueueArr backTeque = new QueueArr();

        for (int i=0; i<numOfOperations;i++){

            String operationGiven = io.getWord();
            Integer numberInput = io.getInt();

            if (operationGiven.equals("push_back")){
                backTeque.push_back(numberInput);
                
                if (backTeque.size - frontTeque.size > 0){
                    frontTeque.push_back(backTeque.get(0));
                    backTeque.removeFront();
                }
            }

            else if (operationGiven.equals("push_front")){
                frontTeque.push_front(numberInput);

                if (frontTeque.size - backTeque.size > 1){
                    backTeque.push_front(frontTeque.get(frontTeque.size-1));
                    frontTeque.removeBack();
                }
            } 

            else if (operationGiven.equals("push_middle")){
                //frontTeque shorter than backTeque, we push to the back of the frontTeque
                if (frontTeque.size <= backTeque.size){
                    frontTeque.push_back(numberInput);
                    
                }
                //if frontTeque longer than backTeque, we push to the front of the backTeque
                else{
                  backTeque.push_front(numberInput);
                }
              
            }
            else if (operationGiven.equals("get")){
                //empty teque capacity is always at least 2
                if (numberInput< frontTeque.size){
                    io.println(frontTeque.get(numberInput));
                } else {
                    numberInput = numberInput-frontTeque.size;
                    io.println(backTeque.get(numberInput));
                }
            }
        }
        io.close();
    }
}


  class QueueArr{
        public int[] arr;
        public int front, back;
        public int capacity;
        public final int INITSIZE = 1;
        public int size;

    
        public QueueArr() {
            arr = new int[INITSIZE]; // create array of integers
            front = 0; // the queue is empty
            back = 0;
            size = 0;
            capacity = INITSIZE;
        }
    
        public boolean empty() { 
            return (front == back); 
        }
    
        public Integer get(int index) {
            if (empty()) return null;
            else {
            //calculate the actual index of the element based on the front pointer and the input index using the modulo operator.
            //Finally, you return the element at the calculated index. CIRCULAR ARRAY...
            int actualIndex = (front + index) % arr.length;
            return arr[actualIndex];
            }
        }
    
        public void push_front(Integer item) {
            if (((back+1)%capacity) == front){ // one space left means array is full, we are enlarging it
              enlargeArr();
            }
            //use the modulo function and create your own formula to wrap around the array to maintain the circular queue
            front = (front - 1 + capacity) % capacity;
            arr[front] = item;
            size++;
        }

        public void push_back(Integer item) {
            if (((back+1)%capacity) == front){ // array is full
                enlargeArr();
            }
            //lecture given way to maintain circular queue (so it doesnt go out of bounds)
            arr[back] = item;
            back = (back + 1) % capacity;
            size++;
            }

        public void removeFront(){
            front = (front + 1) % capacity;
            size--;
        }

        public void removeBack(){
            back = (back - 1 + capacity) % capacity;
            size--;

        }
    
        public boolean enlargeArr() {
            int newSize = capacity * 2;
            int[] temp = new int[newSize];
            for (int j=0; j < capacity; j++) {
                // copy the front (1st) element, 2nd element, ...,  in the 
                // original array to the 1st (index 0), 2nd (index 1), ...,
                // position in the enlarged array
                temp[j] = arr[(front+j) % capacity];
            }
            front = 0; 
            back = capacity - 1;
            arr = temp;
            capacity = newSize;
            return true;
        }

    }
    

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

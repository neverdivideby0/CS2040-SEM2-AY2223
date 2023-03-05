import java.util.*;
import java.io.*;

public class joinstrings {
    public static void main(String[] args) {
        Kattio io = new Kattio (System.in, System.out);

        //each word is a node
        HashMap<Integer, TailedLinkedList> libraryOfWords = new HashMap<Integer, TailedLinkedList>();

        int numOfWords = io.getInt();
        //this creates the library of words
         for (int i=0 ; i<numOfWords; i++ ){
            String word = io.getWord();
            TailedLinkedList listOfWords = new TailedLinkedList();
            listOfWords.addWordBack(word);
            libraryOfWords.put(i,listOfWords);
        }

        int lastNum = 0;
        for (int i=0 ; i<numOfWords-1; i++ ){
            int firstOperation = io.getInt()-1;
            lastNum=firstOperation;
            int secondOperation = io.getInt()-1;
            //adding a tailed linked list to the back of a tailed linked list
            (libraryOfWords.get(firstOperation)).addListBack(libraryOfWords.get(secondOperation));
        }
        libraryOfWords.get(lastNum).print();
        io.close();
    }

}

class TailedLinkedList {
  // attributes
  public ListNode head;
  public ListNode tail;
  public int num_nodes;


  // Return number of items in list
  public int size() { return num_nodes; }

    // non-interface helper methods
    public ListNode getHead() { return head; }
    public ListNode getTail() { return tail; }

      // Add a node word to this tailedlinkedlist
  public void addWordBack(String word) {
    ListNode wordAsNode = new ListNode(word);
    head = wordAsNode;
    tail = wordAsNode;
    num_nodes++;
  }
  // Add item to back of list
  public void addListBack(TailedLinkedList newList) {
    tail.next = newList.head;
    tail = newList.tail;
    num_nodes += newList.size();
  }
  // Print values of nodes in list.
  public void print() {
      ListNode cur = head;
      System.out.print(cur.getItem());
      for (int i=1; i < num_nodes; i++) {
       cur = cur.getNext();
       System.out.print(cur.getItem());
    }
  }
}

class ListNode {
    /* attributes */
    public String item;
    public ListNode next;

    /* constructors */
    public ListNode(String val) { this(val, null); }

    public ListNode(String val, ListNode n) { 
        item = val; 
        next = n; 
    }

    /* get the next ListNode */
    public ListNode getNext() { return next; }

    /* get the item of the ListNode */
    public String getItem() { return item; }

    /* set the item of the ListNode */
    public void setItem(String val) { item = val; }

    /* set the next reference */
    public void setNext(ListNode n) { next = n; }
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
    

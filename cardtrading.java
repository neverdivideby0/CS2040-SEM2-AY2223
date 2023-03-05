import java.util.*;
import java.io.*;

public class cardtrading {
    public static void main(String[] args) {
    Kattio katt = new Kattio (System.in, System.out);

    int numOfCards = katt.getInt(); //N
    int numOfTypes = katt.getInt(); //T
    int numOfCombos = katt.getInt(); //K
    
    int[] arrayOfCardFreq = new int [numOfTypes];
    Arrays.fill(arrayOfCardFreq,0);

    for (int i = 0; i < numOfCards; i++){
        int nextCardType = katt.getInt();
        if (nextCardType > 0 && nextCardType <= numOfTypes){
            arrayOfCardFreq[nextCardType-1]++;
        }
    }
    Card[] arrayOfCardsDatabase = new Card[numOfTypes];

    for (int i = 0 ; i < numOfTypes ; i++) {
        long nextBuyPrice = katt.getLong();
        long nextSellPrice = katt.getLong();
        long opportunityCost = arrayOfCardFreq[i]*nextSellPrice + (2-arrayOfCardFreq[i])*nextBuyPrice;
        Card nextCard = new Card(nextBuyPrice, nextSellPrice, opportunityCost, arrayOfCardFreq[i]);
        arrayOfCardsDatabase[i] = nextCard;
        }

    Arrays.sort(arrayOfCardsDatabase, new opportunityCostComparator());

    long money = 0;
    long spentMoney = 0;
    long earnMoney = 0;
    for (int i = 0; i < numOfCombos && numOfCombos<=numOfTypes; i++) {
        if (arrayOfCardsDatabase[i].getFreq() == 2) {
            money=0;
        } else if (arrayOfCardsDatabase[i].getFreq() == 0){
            money = arrayOfCardsDatabase[i].getBuyPrice()*2;
        } else{
            money = arrayOfCardsDatabase[i].getBuyPrice();
        }
        spentMoney += money;
    }

    for (int i = numOfCombos ; i < numOfTypes ; i++) {
        if (arrayOfCardsDatabase[i].getFreq() == 2) {
        money= arrayOfCardsDatabase[i].getSellPrice() * 2;
    } else if (arrayOfCardsDatabase[i].getFreq() == 0){
        money=0;
    }  else{
        money = arrayOfCardsDatabase[i].getSellPrice();
    }
        earnMoney += money;
    }

    katt.println(earnMoney- spentMoney);
    katt.close();
    }
}


class Card {
    long buyPrice;
    long sellPrice;
    long opportunityCost;
    long freq;
    
        public Card(long buyPrice, long sellPrice, long opportunityCost, long freq) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.opportunityCost = opportunityCost;
        this.freq = freq;
    }
    
    public void setOpportunityCost(long opportunityCost) {
        this.opportunityCost = opportunityCost;
        }

    public long getBuyPrice(){
        return buyPrice;
    }
    public long getSellPrice(){
        return sellPrice;
    }
    public long getOpportunityCost(){
        return opportunityCost;
    }
    public long getFreq(){
        return freq;
    }
}

class opportunityCostComparator implements Comparator<Card> {
    public int compare(Card card1, Card card2){
        return (int) (card1.getOpportunityCost() - card2.getOpportunityCost());
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


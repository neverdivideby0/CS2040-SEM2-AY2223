import java.util.*;
import java.util.Map.Entry;
import java.io.*;


public class conformity {
    public static void main(String[] args) {
        HashMap<Set<String>, Integer> uniqueCombi = new HashMap<>();
        Kattio io = new Kattio (System.in, System.out);
        int numOfFrosh = io.getInt();

        for (int i=1; i<= numOfFrosh; i++){
            int moduleCode1 = io.getInt();
            int moduleCode2 = io.getInt();
            int moduleCode3 = io.getInt();
            int moduleCode4 = io.getInt();
            int moduleCode5 = io.getInt();

            Set<String> moduleCodeList = new HashSet<String>();
            moduleCodeList.add(Integer.toString(moduleCode1));
            moduleCodeList.add(Integer.toString(moduleCode2));
            moduleCodeList.add(Integer.toString(moduleCode3));
            moduleCodeList.add(Integer.toString(moduleCode4));
            moduleCodeList.add(Integer.toString(moduleCode5));
            if (uniqueCombi.containsKey(moduleCodeList)){
                Integer currentCounter = uniqueCombi.get(moduleCodeList);
                currentCounter++;
                uniqueCombi.put(moduleCodeList,currentCounter);
            } else {
                uniqueCombi.put(moduleCodeList,1);
            }
        }

        int totalMaxValue = 0;
        int maxValue = Collections.max(uniqueCombi.values());

        for (Entry<Set<String>, Integer> entry : uniqueCombi.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                totalMaxValue += maxValue;
            }
        }
        io.println(totalMaxValue);
        io.close();
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


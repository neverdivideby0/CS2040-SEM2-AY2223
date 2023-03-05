import java.util.*;

public class sortOfSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringComparator StringComp = new StringComparator();
        int numOfNames = 1;

        while(numOfNames!=0){

            numOfNames = sc.nextInt();
            List<String>nameList = new ArrayList<>();

            for (int i = 0 ;  i < numOfNames ; i++) {
                String name = sc.next();
                nameList.add(name);
            }
            Collections.sort(nameList, StringComp);

            for (int i = 0 ;  i < numOfNames ; i++) {
                System.out.println(nameList.get(i));
            }
            System.out.println();
        }
    }
}


class StringComparator implements Comparator<String> {
    public int compare(String string1, String string2){
    return string1.substring(0,2).compareTo(string2.substring(0,2));
    }   
}

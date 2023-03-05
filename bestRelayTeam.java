import java.util.*;


public class bestRelayTeam {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int numOfRunners = sc.nextInt();
        sc.nextLine();
      
        //got class need to instaintiate
        otherLapComparator otherLapCompare = new otherLapComparator();
        Runner runnerList[] = new Runner[numOfRunners];

        for (int i = 0; i < numOfRunners; i++){
            String runnerName = sc.next();

            Double runnerFirstLegTime = sc.nextDouble();

            Double runnerOtherLegTime = sc.nextDouble();
            //collect all the data and create a runner then add him to an array of runners
            runnerList[i] = new Runner(runnerName, runnerFirstLegTime, runnerOtherLegTime);
            }

        List<Runner> list = Arrays.asList(runnerList);
        //sort the runner list by the other leg timing
        Collections.sort(list,otherLapCompare);

        List<String>finalList = new ArrayList<>();
        Double minValue = Double.MAX_VALUE;
        for (int i = 0; i < numOfRunners; i++){
             //iterate through every runner got a chance to be the first runner
             //get the best 3 other timings for them.
             Double totalOtherTime = 0.0;
             List<String>tempList = new ArrayList<>();
             tempList.add(list.get(i).getName());
          
             for (int j = 0, counter=0; counter < 3  && j < list.size(); j++){
                 if (!(list.get(i).getName()).equals(list.get(j).getName())){
                    Double tempValue = list.get(j).getOtherLapTime();
                    totalOtherTime += tempValue;
                    tempList.add(list.get(j).getName());
                    counter++;
                 }
                 }
                 totalOtherTime = totalOtherTime + list.get(i).getFirstLapTime();
          
                if (totalOtherTime < minValue){
                    minValue = totalOtherTime;
                    finalList = tempList;
                 }
            }
      
            System.out.println(minValue);

            for(int i = 0; i < 4; i++){
                System.out.println(finalList.get(i));
            }
    }
}

// it has more than 1 attribute so array out of the qn, not enough to just String array and Double array, let alone 3 arrays.
// Cant link all 3 of them.. Best bet is to array a Runner class
// need to create an Object Runner that compasses all 3 attributes (name, timing 1 and timing 2). So create a basic Runner class
// initialise it and implement getter methods and toString()
class Runner {
    public String name;
    public Double firstLapTime;
    public Double otherLapTime;

    public Runner(String name, Double firstLapTime, Double otherLapTime) {
        this.name = name;
        this.firstLapTime = firstLapTime;
        this.otherLapTime = otherLapTime;
    }
    public String getName(){
        return name;
    }
    public Double getFirstLapTime(){
        return firstLapTime;
    }
    public Double getOtherLapTime(){
        return otherLapTime;
    }
    @Override
    public String toString() {
        return name + "-" + firstLapTime + "-" + otherLapTime;
    }
}

//create a comparator class that has a specific method that is to compare the runner object classes
class otherLapComparator implements Comparator<Runner> {
    public int compare(Runner runner1, Runner runner2){
        //the compare method usually returns int, either 1,0 or -1 so if we compare the first lap timing (double type)
        //we have to have a return type of int,
        if (Double.compare(runner1.getOtherLapTime(), runner2.getOtherLapTime()) == 0) {
 
            return 0;
        }
        else if (Double.compare(runner1.getOtherLapTime(), runner2.getOtherLapTime()) < 0) {
 
            return -1;
        }
        else {
 
            return 1;
        }
    }
}

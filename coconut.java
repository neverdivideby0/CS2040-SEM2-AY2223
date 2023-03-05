import java.util.*;

public class coconut {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int numOfSyllables = sc.nextInt();
        int numOfPlayers = sc.nextInt();
        List<Player>nameList = new ArrayList<Player>(numOfPlayers);

        for (int i = 0; i<numOfPlayers ; i++){
            Player nextPlayer = new Player(i,0);
            nameList.add(nextPlayer);
        }

        int indexPointer = 0;
        while (nameList.size() > 1) {
            indexPointer = (indexPointer + numOfSyllables - 1) % nameList.size();
            
            //folded hands -> status = 0
            //if its touched
            if (nameList.get(indexPointer).getPlayerState()==0){
                nameList.get(indexPointer).addNextPlayerState();
                //create new hand
                Player newPlayer = new Player(indexPointer,1);
                //add to the right side.
                nameList.add(indexPointer+1, new Player(nameList.get(indexPointer).getPlayerNumber(),1));
                //dont need change indexPointer
            }
            
            //fist -> status = 1
            //if its touched
            //must be else if
            else if (nameList.get(indexPointer).getPlayerState()==1) {
                nameList.get(indexPointer).addNextPlayerState();
                //indexPointer + 1? cuz it starts with the next hand in the clockwise order
                indexPointer++;
            }
          
            //palm down -> status =2
            //if palm is touched remove
            else if (nameList.get(indexPointer).getPlayerState()==2) {
                nameList.remove(indexPointer);
                //indexPointer + 1? cuz it starts with the next hand in the clockwise order
            }
        }
        System.out.println(nameList.get(0).getPlayerNumber()+1);
    }
}

class Player {
    int playerNumber;
    int playerState;

    public Player(int playerNumber, int playerState){
        this.playerNumber=playerNumber;
        this.playerState= playerState;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    public int getPlayerState() {
        return playerState;
    }
    public void addNextPlayerState() {
        this.playerState =  playerState + 1;
    }
}


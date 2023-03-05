import java.util.Scanner;

public class peasoup {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int numOfRestaurants = sc.nextInt();
        int numOfMenuItems;
        String restaurantName;
        String menuItem;
        Boolean thereIsPeaSoup=false;
        Boolean thereIsPancakes=false;
        String faveRestaurant = "";

        for (int i = 0; i < numOfRestaurants; i++){

            numOfMenuItems=sc.nextInt();

            sc.nextLine();
            restaurantName=sc.nextLine();
            System.out.println(restaurantName);

            thereIsPeaSoup=false;
            thereIsPancakes=false;
            for (int j = 0; j < numOfMenuItems; j++){
                menuItem=sc.nextLine();

                if (menuItem.equals("pea soup")){
                    thereIsPeaSoup=true;
                }
                if (menuItem.equals("pancakes")){
                    thereIsPancakes=true;
                }
            }
            if (thereIsPeaSoup == true && thereIsPancakes==true) {
                faveRestaurant = restaurantName;
                break;
                }
        }
        if (thereIsPeaSoup == true && thereIsPancakes==true){
            System.out.println(faveRestaurant);
        }
        else{
            System.out.println("Anywhere is fine I guess");
        }
    }
}

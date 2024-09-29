import java.util.Scanner;

public class Seats {

    //variables
    static private int counter = 0;
    static private String answer = "";

    //methods
    public void printMatrix(String[][] a){
        for(int row = 0; row < a.length; row++){
            for(int col = 0; col < a[row].length; col++){
                System.out.print(a[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void seatSelector(String[][] a) {
        int temp = 0;
        for (int row = 0; row < a.length; row++) {
            if(a[row][0].equals(String.valueOf(answer.charAt(0)))){
                for(int col = 1; col < a[row].length; col++){
                    if(a[row][col].equals(String.valueOf(answer.charAt(1)))){
                        a[row][col] = String.valueOf('X');
                        counter++;
                        temp++;
                    }
                }
            }
        }
        if(temp == 0){
            System.out.println("The seat you have chosen is occupied, Please choose another seat\n");
        }
    }

    //start of main
    public static void main(String[] args){
        //scanner
        Scanner scan = new Scanner(System.in);

        Seats seat = new Seats();
        String[][] seats = new String[7][5];
        for (int row = 0; row < seats.length; row++){
            seats[row][0] = String.valueOf(row + 1);
            for(int col = 1; col < seats[row].length; col++){
                seats[row][col] = String.valueOf((char)('A' + col - 1));
            }
        }

        System.out.println("You will be selecting seats for this airplane.");
        seat.printMatrix(seats);
        System.out.println();
        System.out.println("You will input the seat selection using the row number and then" +
                " the seat letter (ex - 3B)");
        System.out.println("Please enter the seat number or Q to quit.\n");

        //while loop
        while(counter < 28){
            answer = scan.nextLine();
            if(answer.equals("Q")){
                System.exit(0);
            }
            seat.seatSelector(seats);
            seat.printMatrix(seats);
            System.out.println();
            System.out.println("Please enter the seat number or Q to quit.\n");
        }
    }
}

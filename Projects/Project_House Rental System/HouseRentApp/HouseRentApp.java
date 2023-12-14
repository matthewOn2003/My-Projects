package src.Project_RentHouseSys.HouseRentApp;

import src.Project_RentHouseSys.HouseRentView.HouseRentView;

public class HouseRentApp {
    public static void main(String[] args) {
        /* HouseView class
        1. display page
        2. Receive user input
        3. Call HouseService to complete the operation of the house information.
         /*

        /* HouseService class
        1. Respond to the call of HouseView. 2.
        2. complete the operation of the house information (CRUD)
         */

        /*HouseDomain class
        1. a House object represents the information of a house. 2.
        2. Since we haven't learned about databases yet, we'll use an array to store the house information.
         */

        /*Utily class
        1. Utility class to get user's input

         */

        /*HouseRentApp
        1. main method, program entry
        2. create house object, show main menu
        3. I put it in a package, looks neat
         */

        new HouseRentView().mainMenu();

    }
}

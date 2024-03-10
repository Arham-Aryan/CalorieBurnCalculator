/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calorieburncalculator;

public class CalorieBurnCalculator {
    public static void main(String[] args) {
        // Part a: Calculate Intake
        String foodItem = "pizza";  
        int caloriesPerItem = 285;  // Calories per serving of the chosen food (source: https://www.calorieking.com/)
        int numberOfItems = 5;      // Number of servings

        int totalCaloriesConsumed = caloriesPerItem * numberOfItems;

        // Part b: Burn It Off
        // Data points for calories burned per hour at 3.0 mph walking speed
        int[][] weightData = {{150, 314}, {200, 418}};  // {{Weight in pounds, Calories burned per 60 minutes}}

        // Calculate the slope (m) and y-intercept (b) for the linear relationship
        int x1 = weightData[0][0];
        int y1 = weightData[0][1];
        int x2 = weightData[1][0];
        int y2 = weightData[1][1];

        double slope = (double) (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;

        // Convert weight to kilograms
        double weightKg = 75;  // Replace with the user's weight in kilograms
        double weightLbs = weightKg * 2.20462;

        // Calculate calorie burn rate per minute using the linear equation
        double caloriesBurnedPerMinute = (slope * weightLbs + yIntercept) / 60;

        // Part c: How Far Can You Walk
        double walkingSpeedMph = 3.0;
        double walkingSpeedKph = walkingSpeedMph * 1.60934;  // Convert mph to kph

        // Calculate how many minutes you can walk based on calorie consumption
        double minutesCanWalk = totalCaloriesConsumed / caloriesBurnedPerMinute;

        // Calculate how far you can walk in kilometers
        double distanceKm = (minutesCanWalk / 60) * walkingSpeedKph;

        // Part d: Number of Steps
        double heightCm = 175;  // Replace with the user's height in centimeters
        double strideLengthM = heightCm * 0.43;  // Stride length in meters

        // Calculate the number of steps based on distance traveled
        double steps = (distanceKm * 1000) / strideLengthM;

        // Part e: How many laps?
        double trackDiameterM = 200;  // Diameter of the circular track in meters

        // Calculate the number of laps required to burn off the calories
        double laps = distanceKm / (trackDiameterM / 1000);

        // Print the results
        System.out.println(numberOfItems + " " + foodItem + "s contain a total of " + totalCaloriesConsumed + " calories.");
        System.out.println("You are " + weightKg + " kilograms or " + String.format("%.2f", weightLbs) + " pounds.");
        System.out.println("When walking, you consume " + String.format("%.2f", caloriesBurnedPerMinute) + " calories per minute.");
        System.out.println("You would be able to walk " + String.format("%.2f", minutesCanWalk) + " minutes if you ate " + numberOfItems + " " + foodItem + "s.");
        System.out.println("You would be able to walk " + String.format("%.2f", distanceKm) + " km.");
        System.out.println("In that time, you will take " + (int) steps + " steps.");
        System.out.println("You will take " + String.format("%.2f", laps) + " laps around the track.");
        System.out.println("Program terminated normally.");
    }
}

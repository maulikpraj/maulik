/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm;

import java.util.Scanner;

/**
 *
 * @author mauli
 */
public class PermitSystem {
    public static boolean isValidPermit(String permitNumber) {
        return permitNumber.matches("\\d{6}");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String permitNumber;

        // Step 1: Validate permit number
        while (true) {
            System.out.print("Enter a 6-digit permit number: ");
            permitNumber = sc.nextLine();
            if (isValidPermit(permitNumber)) {
                break;
            } else {
                System.out.println("❌ Invalid format. Please enter exactly 6 digits.");
            }
        }

        // Step 2: Display categories
        System.out.println("\nChoose a Permit Category:");
        for (PermitCategory category : PermitCategory.values()) {
            System.out.println("- " + category);
        }

        // Step 3: Get category input
        System.out.print("Enter category name (e.g., GENERAL, STUDENT): ");
        String inputCategory = sc.nextLine().toUpperCase();

        try {
            PermitCategory selected = PermitCategory.valueOf(inputCategory);

            // Step 4: Create permit
            Permit permit = new Permit(permitNumber, selected);
            System.out.println("\n✅ Permit created successfully!");
            System.out.println(permit);

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid category. Program exiting.");
        }

        sc.close();
    }
}

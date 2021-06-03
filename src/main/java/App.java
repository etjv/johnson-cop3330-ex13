/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Edmund Johnson V
 */

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Simple interest is something you use only when making a quick guess. Most investments use a compound interest formula, which will be much more accurate. And this formula requires you to incorporate exponents into your programs.

Write a program to compute the value of an investment compounded over time. The program should ask for the starting amount, the number of years to invest, the interest rate, and the number of periods per year to compound.

The formula you’ll use for this is A = P(1 + r/n)^(n*t) where

P is the principal amount.
r is the annual rate of interest.
t is the number of years the amount is invested.
n is the number of times the interest is compounded per year.
A is the amount at the end of the investment.
Example Output
What is the principal amount? 1500
What is the rate? 4.3
What is the number of years? 6
What is the number of times the interest is compounded per year? 4
$1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.
Constraints
Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
Ensure that fractions of a cent are rounded up to the next penny.
Ensure that the output is formatted as money.
 */
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] arg) {
        float principal = getPrincipal();
        float interest = getInterest();
        float years = getYears();
        float n = getCompounded();
        System.out.println(output(principal, interest, years, n));
    }

    private static float getPrincipal(){
        System.out.print("What is the principal amount? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static float getInterest(){
        System.out.print("What is the rate? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static float getYears(){
        System.out.print("What is the number of years? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static float getCompounded(){
        System.out.print("What is the number of times the interest is compounded per year? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static String output(float p, float i, float y, float n){
        double total = p * (Math.pow((1 + ((i / 100) / n)), (n * y)));
        BigDecimal d = new BigDecimal(Double.toString(total));
        DecimalFormat dc = new DecimalFormat("#.##");
        return "$" + dc.format(p) + " invested at " + dc.format(i) + "% for " + dc.format(y) + " years compounded " + dc.format(n) + " times per year is $" + dc.format(total) + ".";
    }
}

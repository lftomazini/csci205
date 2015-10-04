/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Oct 3, 2015
 * Time: 3:36:12 PM
 *
 * Project: csci205
 * Package: lab12
 * File: ScanWebPage
 * Description:
 *
 * ****************************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 *
 * @author as062
 */
public class ScanWebPage {
    public static String address;

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException, IOException, IllegalArgumentException {
//        String address;
        while (true) {
            try {
                Scanner addr = new Scanner(System.in);
                System.out.print("Input URL:");
                address = addr.next();
                URL locator = new URL(address);
                BufferedInputStream in = new BufferedInputStream(
                        locator.openStream());
                break;
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException:" + e.getMessage());
            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IOException:" + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException:" + e.getMessage());
            }

        }

        Scanner addr = new Scanner(System.in);
        URL locator = new URL(address);
        Scanner in = new Scanner(locator.openStream());

        System.out.printf("What tag do you want to scan for? ");
        String tag = addr.next();
        Pattern p = Pattern.compile("\\b" + tag + "\\b\\s+(\\w+)=\"([^\"]+)\"");
        Scanner f = new Scanner(System.in);
        System.out.printf("Enter the file name to store the results: ");
        String name = f.next();
        PrintWriter out = new PrintWriter(name);
        String sMatch;
        int num = 0;
        while ((sMatch = in.findWithinHorizon(p, 0)) != null) {
            out.println("Found: <" + sMatch + ">");
            MatchResult match = in.match();
            out.println("Parameter: " + match.group(1));
            out.println("Value: " + match.group(2));
            num++;
        }

        out.close();
        System.out.println("Wrote " + num + " <" + tag + "> to " + name);
        System.out.println("Goodbye");
    }
}

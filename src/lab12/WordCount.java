/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Oct 4, 2015
 * Time: 3:14:15 PM
 *
 * Project: csci205
 * Package: lab12
 * File: WordCount
 * Description:
 *
 * ****************************************
 */
package lab12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author as062
 */
public class WordCount {

    public int word;
    public int lines;
    public int character;
    public File readFile;

    public WordCount(String filename) {
        readFile = new File(filename);
        this.word = 0;
        this.lines = 0;
        this.character = 0;
        this.readFile = new File(filename);

    }

    public WordCount(File f) {
        readFile = f;
        this.word = 0;
        this.lines = 0;
        this.character = 0;
        this.readFile = f;
    }

    public void doIt() throws FileNotFoundException, IOException {

        BufferedReader buf = new BufferedReader(new FileReader(readFile));

        int ch;
        do {
            ch = buf.read();
            if (ch >= 0) {
                this.character += 1;
            }
        } while (ch >= 0);

        Scanner in = new Scanner(new FileInputStream(readFile));
        while (in.hasNext() == true) {
            this.word++;
            in.next();
        }

        Scanner in2 = new Scanner(new FileInputStream(readFile));
        while (in2.hasNextLine() == true) {
            this.lines++;
            in2.nextLine();
        }

    }

    @Override
    public String toString() {
        String s = " " + this.lines + " " + this.word + " " + this.character + " " + readFile;
        return s;
    }
}

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 7, 2015
 * Time: 3:13:34 PM
 *
 * Project: csci205
 * Package: lab05
 * File: DNA
 * Description:
 *
 * ****************************************
 */
package lab05;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lffct001
 */
public class DNAsim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print(
                "What should be the length of the DNA sequence to be simulated? ");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        System.out.print(
                "What is the desired GC-content [%] in the sequence to be simulated? ");
        double gcContent = in.nextDouble();

        char[] nucleotides = new char[length];
        nucleotides = generateDNA(length, gcContent);

        printDNAStats(nucleotides);

        printLongestRepeat(nucleotides);
    }

    /**
     * Generates a biased sequence of nucleotides
     *
     * @param length The length of the sequence
     * @param gcContent The biases value of nucleotides G and C
     * @return The array with the sequence of nucleotides
     */
    public static char[] generateDNA(int length, double gcContentPct) {
        char[] sequence = new char[length];
        Random seed = new Random();
        char[] nucleotides = new char[100];
        int bias = (int) gcContentPct;

        if (bias % 2 != 0) {
            bias += 1;
        }

        for (int i = 0; i < bias; i += 2) {
            nucleotides[i] = 'G';
            nucleotides[i + 1] = 'C';
        }

        for (int i = bias; i < 100; i += 2) {
            nucleotides[i] = 'A';
            nucleotides[i + 1] = 'T';
        }

        String s = new String(nucleotides);

        for (int i = 0; i < length; i++) {
            sequence[i] = s.charAt(seed.nextInt(s.length()));
            System.out.println(sequence[i]);
        }

        return sequence;
    }

    /**
     * Prints statistics about the nucleotide sequence
     *
     * @param dna The sequence to be analyzed
     */
    public static void printDNAStats(char[] dna) {
        int size = dna.length;
        System.out.printf("A:  %d  (%.1f%%)%n", countNucleotides(dna, 'A'),
                          ((double) countNucleotides(dna, 'A') / size) * 100);
        System.out.printf("C:  %d  (%.1f%%)%n", countNucleotides(dna, 'C'),
                          ((double) countNucleotides(dna, 'C') / size) * 100);
        System.out.printf("G:  %d  (%.1f%%)%n", countNucleotides(dna, 'G'),
                          ((double) countNucleotides(dna, 'G') / size) * 100);
        System.out.printf("T:  %d  (%.1f%%)%n", countNucleotides(dna, 'T'),
                          ((double) countNucleotides(dna, 'T') / size) * 100);
    }

    /**
     * Counts the number of times a nucleotide appears in the sequence
     *
     * @param dna The sequence to be analyzed
     * @param nucleotide de nucleotide base to check the frequency
     * @return The number of times the nucleotide appears
     */
    public static int countNucleotides(char[] dna, char nucleotide) {
        String s = new String(dna);
        int sizeString = s.length();
        int frequency = 0;

        for (int i = 0; i < sizeString; i++) {
            if (s.charAt(i) == nucleotide) {
                frequency++;
            }
        }

        return frequency;
    }

    /**
     * Prints the size of the longest repeated nucleotide and its position in
     * the sequence
     *
     * @param dna The sequence to be analyzed
     */
    public static void printLongestRepeat(char[] dna) {
        int size = dna.length;

        int longestRepeated = 1;
        int aux = 1;
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                if (dna[i] == dna[i + 1]) {
                    aux++;
                } else {
                    if (aux > longestRepeated) {
                        index = i - longestRepeated;
                        longestRepeated = aux;
                    }
                    aux = 1;
                }
            } else {
                if (aux > longestRepeated) {
                    index = i - longestRepeated + 1;
                    longestRepeated = aux;
                }
            }
        }

        System.out.println(
                "Longest repeated nucleotide: " + longestRepeated + " " + dna[index] + " starting at index " + index);
    }
}

/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2015
* Instructor: Brian King
* Section: 10am
*
* Name: Luis Felipe Franco Candeo Tomazini
* Date: 08/25/2015
*
* Lab / Assignment: Lab01
*
* Description: Hello World
*
* *****************************************/

package lab01;
public class Hello
{
 public static void main( String[] args ){
 long startTime = System.nanoTime();
 
 System.out.println("Programming is not a spectator sport!");
 //long estimatedTime = (System.nanoTime() - startTime)/1000000;
 System.out.println("Time to execute: " + (double)((System.nanoTime() - startTime)/1000000.0) + " ms");
 System.exit(0);
 }
}

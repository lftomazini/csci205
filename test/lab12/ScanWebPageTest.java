/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Oct 3, 2015
 * Time: 4:00:31 PM
 *
 * Project: csci205
 * Package: lab12
 * File: ScanWebPageTest
 * Description:
 *
 * ****************************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as062
 */
public class ScanWebPageTest {

    public ScanWebPageTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ScanWebPage.
     */
    @Test
    public void testMain() throws Exception {
        String address = "http://www.bucknell.edu";
        URL locator = new URL(address);
        BufferedInputStream in = new BufferedInputStream(locator.openStream());
    }

    @Test(expected = FileNotFoundException.class)
    public void FileNotFoundExceptionTest() throws IOException, FileNotFoundException {
        System.out.println("FileNotFoundException");
        String address = "http://www.bucknell.edu/blah.html";
        URL locator = new URL(address);
        BufferedInputStream in = new BufferedInputStream(locator.openStream());
    }

    @Test(expected = MalformedURLException.class)
    public void MalformedURLExceptionTest() throws IOException {
        System.out.println("MalformedURLExceptionTest");
        String address = "www.bucknell.edu";
        URL locator = new URL(address);
        BufferedInputStream in = new BufferedInputStream(locator.openStream());
    }

    @Test(expected = IOException.class)
    public void IOExceptionTest() throws IOException {
        System.out.println("expected = MalformedURLException.class");
        String address = "http://www.bucknell.ed";
        URL locator = new URL(address);
        BufferedInputStream in = new BufferedInputStream(locator.openStream());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgumentExceptionTest() throws IOException, IllegalArgumentException {
        System.out.println("IllegalArgumentException");
        String address = "http:\\www.bucknell.edu";
        URL locator = new URL(address);
        BufferedInputStream in = new BufferedInputStream(locator.openStream());
    }
}

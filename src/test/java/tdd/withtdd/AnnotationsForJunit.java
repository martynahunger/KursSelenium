package tdd.withtdd;

import org.junit.*;

import static org.junit.Assert.assertEquals;


public class AnnotationsForJunit {

    //private static WebDriver driver;

    @BeforeClass
    public static void classSetUp() {
        System.out.println("classSetUp()");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("classTearDown()");
    }

    @Before
    public void setUp() {
        System.out.println("setUp()");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    public void test1() {
        System.out.println("test1()");
        assertEquals(3.33, 10.0/3.0, 0.01);
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        System.out.println("test2()");
        String test = null;
        test.length();
    }

    @Ignore("Will be fixed later.")
    @Test
    public void test3() {
        System.out.println("test3()");
    }
}

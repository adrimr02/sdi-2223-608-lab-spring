package es.uniovi.notaineitor;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder( MethodOrderer.OrderAnnotation.class )
class NotaneitorApplicationTests {
    static String PathFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    static String Geckodriver = "C:\\Users\\adria\\OneDrive\\Documentos\\Uniovi\\3er Curso\\SDI\\Practicas\\Sesion 6\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";

    //static String Geckodriver = "C:\\Dev\\tools\\selenium\\geckodriver-v0.30.0-win64.exe";
    //static String PathFirefox = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
    //static String Geckodriver = "/Users/USUARIO/selenium/geckodriver-v0.30.0-macos";
    //Común a Windows y a MACOSX
    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://localhost:8090";
    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    //Antes de la primera prueba
    @BeforeAll
    static public void begin() {}

    @BeforeEach
    public void setUp(){
        driver.navigate().to(URL);
    }

    @Test
    @Order(1)
    void PR01(){}
    @Test
    @Order(2)
    void PR02(){}
    @Test
    @Order(3)
    void PR03(){}
    @Test
    @Order(4)
    void PR04(){}
    @Test
    @Order(5)
    void PR05(){}
    @Test
    @Order(6)
    void PR06(){}
    @Test
    @Order(7)
    void PR07(){}
    @Test
    @Order(8)
    void PR08(){}
    @Test
    @Order(9)
    void PR09(){}
    @Test
    @Order(10)
    void PR10(){}

    //Después de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }

    //Al finalizar la última prueba
    @AfterAll
    static public void end() {
        //Cerramos el navegador al finalizar las pruebas
        driver.quit();
    }

}
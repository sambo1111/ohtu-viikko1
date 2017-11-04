package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiLaittaaLiikaa() {
        varasto.lisaaVarastoon(10);
        varasto.lisaaVarastoon(1);
        
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiOttaaLiikaa() {
        varasto.lisaaVarastoon(10);
        assertEquals(10, varasto.otaVarastosta(100), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktorissaEiVoiLaittaaLiikaa() {
        Varasto v = new Varasto(10,100);
        assertEquals(10, v.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktorissaEiVoiLaittaaNegatiivista() {
        Varasto v = new Varasto(-10,-10);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, v.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriToimiiOikeinKunLaitetaanOikein() {
        Varasto v = new Varasto(100, 10);
        assertEquals(10, v.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void yhdenParametrinKonstruktoriToimiiOikein() {
        Varasto v = new Varasto(10);
        assertEquals(10, v.getTilavuus(), vertailuTarkkuus);
        v = new Varasto(-10);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toStringToimii() {
        varasto.lisaaVarastoon(4);
        assertEquals("saldo = 4.1, vielä tilaa 6.0", varasto.toString());
    }
    
    @Test
    public void eiVoiLisataNegatiivista() {
        varasto.lisaaVarastoon(10);
        varasto.lisaaVarastoon(-10);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiOttaaNegatiivista() {
        varasto.lisaaVarastoon(10);
        varasto.otaVarastosta(-10);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
}
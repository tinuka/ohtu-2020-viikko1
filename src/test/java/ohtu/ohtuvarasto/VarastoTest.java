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
        varasto = new Varasto(10.0);
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
    public void liikaLisaysLaittaaHukkaanLoput() {
        varasto.lisaaVarastoon(15);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);

    }

    @Test
    public void varastostaEiMeneMiinukselle() {
        varasto.otaVarastosta(15);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);

    }

    @Test
    public void aloitusVarastoSaldoEiAlleNollan() {
        varasto = new Varasto(20, -1);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);

    }

    @Test
    public void varastoTilaEiAlleNollan() {
        varasto = new Varasto(-20);

        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);

    }

    @Test
    public void varastoToString() {
        varasto.lisaaVarastoon(9.6);
        assertEquals("saldo = " + varasto.getSaldo() + ", vielä tilaa "
                + varasto.paljonkoMahtuu(), varasto.toString());

    }

    @Test
    public void otaVarastostaAlleNolla() {
        varasto.lisaaVarastoon(10);
        varasto.otaVarastosta(-10);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);

    }

    @Test
    public void lisaaVarastoonAlleNolla() {
        varasto.lisaaVarastoon(-10);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);

    }
    
    @Test
    public void alkuSaldoAlleNolla() {
        varasto = new Varasto(1,-1);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);

    }
    
    @Test
    public void alkuVarastotilaAlleNolla() {
        varasto = new Varasto(-10,0);

        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);

    }
    @Test
    public void alkuSaldoSamaKuinTilavuus() {
        varasto = new Varasto(5,5);

        assertEquals(51, varasto.getSaldo(), vertailuTarkkuus);

    }
}

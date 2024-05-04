import domain.Dicionario;
import exceptions.PalavraNaoEncontradaException;
import org.junit.Assert;
import org.junit.Test;
import util.TipoDicionario;

public class DicionarioTest {
    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("cAR", "Carro", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("BOOK", "Livro", TipoDicionario.PORTUGUES);

        Assert.assertEquals("Carro", dicionario.traduzir("CAR", TipoDicionario.PORTUGUES));
        Assert.assertEquals("Livro", dicionario.traduzir("book", TipoDicionario.PORTUGUES));
        Assert.assertEquals("Car", dicionario.traduzir("carro", TipoDicionario.INGLES));
        Assert.assertEquals("Book", dicionario.traduzir("lIVRO", TipoDicionario.INGLES));
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);

        String traducao = dicionario.traduzir("CANETA", TipoDicionario.INGLES);
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontradaEmPortugues() throws PalavraNaoEncontradaException {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("PaPer", "Papel", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("tiger", "Tigre", TipoDicionario.PORTUGUES);

        String traducao = dicionario.traduzir("Lápis", TipoDicionario.PORTUGUES);
    }
}

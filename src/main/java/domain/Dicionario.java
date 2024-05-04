package domain;

import exceptions.PalavraNaoEncontradaException;
import util.TipoDicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> palavraPortugues = new HashMap<>();
    private Map<String, String> palavraIngles = new HashMap<>();
    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario) {
        switch (dicionario) {
            case PORTUGUES:
                this.palavraPortugues.put(palavra.toLowerCase(),traducao);
                break;
            case INGLES:
                this.palavraIngles.put(palavra.toLowerCase(), traducao);
                break;
        }
    }

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca) throws PalavraNaoEncontradaException {
        String palavraTraduzida = null;

        switch(dicionarioDeBusca) {
            case PORTUGUES:
                if (!this.palavraPortugues.containsKey(palavra.toLowerCase())) {
                    throw new PalavraNaoEncontradaException();
                } else {
                    palavraTraduzida = this.palavraPortugues.get(palavra.toLowerCase());
                }
                break;
            case INGLES:
                if (!this.palavraIngles.containsKey(palavra.toLowerCase())) {
                    throw new PalavraNaoEncontradaException();
                } else {
                    palavraTraduzida = this.palavraIngles.get(palavra.toLowerCase());
                }
                break;
        }
        return palavraTraduzida;
    }
}

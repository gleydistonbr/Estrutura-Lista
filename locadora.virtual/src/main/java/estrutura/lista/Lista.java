package estrutura.lista;

import java.util.Iterator;

public class Lista<T> implements Ilista<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public Lista() {

    }

    public Lista(No<T> inicio, No<T> fim, int tamanho) {
        this.inicio = inicio;
        this.fim = fim;
        this.tamanho = tamanho;
    }

    public void adicionarInicio(T elemento) {
        No<T> novo = new No(elemento);
        if (this.isEmpty()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            this.inicio.setAnterior(novo);
            this.inicio = novo;
            this.tamanho++;
        }

    }

    @Override
    public void adicionarFinal(T elemento) {
        if (this.isEmpty()) {
            this.adicionarInicio(elemento);
        } else {
            No<T> novo = new No(elemento);
            this.fim.setProximo(novo);
           novo.setAnterior(this.fim);
           this.fim = novo;
           this.tamanho++;
        }

    }

    @Override
    public void adicionarPosicao(int possicao, T elemento) {
        if (possicao == 0) {
            this.adicionarInicio(elemento);
        } else if (possicao == this.tamanho()) {
            this.adicionarFinal(elemento);
        } else {
            No<T> anterior = this.buscar(possicao - 1);
            No<T> proximo = anterior.getProximo();
            No<T> novo = new No(anterior.getProximo());
            this.tamanho++;
        }
    }

    @Override
    public void removerInicio() {
        if (!this.posicaoOculpada(0)) {
            throw new IllegalArgumentException("Lista esta vazia");
        }
        this.inicio = this.inicio.getProximo();
        this.tamanho--;
        if (this.isEmpty()) {
            this.fim = null;
        }
    }

    @Override
    public void removerFinal() {
        if (!this.posicaoOculpada(this.tamanho - 1)) {
            throw new IllegalArgumentException("Lista esta vazia");
        }
        if (this.tamanho() == 1) {
            this.removerInicio();
        } else {
            No<T> novo = this.fim.getAnterior();
            novo.setProximo(null);
            this.fim = novo;
            this.tamanho--;
        }
    }

    @Override
    public void removerFinalPosicao(int posicao) {
        if (!this.posicaoOculpada(posicao)) {
            throw new IllegalArgumentException("Lista esta vazia");
        }
        if (posicao == 0) {
            this.removerInicio();
        } else if (posicao == this.tamanho() - 1) {
            this.removerFinal();
        } else {
            No<T> novo = this.pegarElemento(posicao - 1);
            No<T> atual = this.fim.getProximo();
            No<T> proximo = atual.getProximo();

            novo.setProximo(proximo);
            proximo.setAnterior(novo);
            this.tamanho--;

        }
    }

    @Override
    public No<T> buscar(int posicao) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Posição não existe");
        }
        No<T> obj = this.inicio;
        for (int i = 0; i < posicao; i++) {
            obj = obj.getProximo();

        }
        return obj;
    }

    @Override
    public boolean contem(T elemento) {
        No<T> atual = this.inicio;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;

    }

    public boolean posicaoOculpada(int posicao) {
        return posicao >= 0 && posicao < this.tamanho();

    }

    public No<T> pegarElemento(int posicao) {
        if (!this.posicaoOculpada(posicao)) {
            throw new IllegalArgumentException("Lista esta vazia ");
        }
        No<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void limpar() {
        Lista lista = new Lista();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista(this.inicio);
    }

   
}

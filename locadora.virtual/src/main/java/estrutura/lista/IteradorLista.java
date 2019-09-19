package estrutura.lista;

import java.util.Iterator;

public class IteradorLista<T> implements Iterator<T> {

    private No<T> atual;
    
    public IteradorLista(No<T> inicio){
        this.atual = inicio;
    }

    @Override
    public boolean hasNext() {
        if (atual != null) {
            return true;
        }
        return false;
    }

    @Override
    public T next() { 
        if (atual == null) {
            throw new IllegalStateException("Não possui elemento");
        } else {
            T retorno = this.atual.getElemento();
            this.atual = this.atual.getProximo();
            return retorno;
        }
    }

}

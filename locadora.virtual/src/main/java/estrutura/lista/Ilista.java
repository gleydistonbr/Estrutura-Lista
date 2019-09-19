package estrutura.lista;

public interface Ilista<T> extends Iterable<T>{
    
    public void adicionarInicio(T elemento);
    public void adicionarFinal(T elemento);
    public void adicionarPosicao(int indice, T elemento);
    
    public void removerInicio();
    public void removerFinal();
    public void removerFinalPosicao(int indice);
    
    
    public No<T> buscar(int posicao);
    public boolean contem(T elemento);
    public int tamanho();
    
    
    
    
}

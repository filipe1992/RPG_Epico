package Interfaces;

public interface Personagem {

    public boolean usarArma();
    
    public float getDinheiro();
    
    public void setDinheiro(float dinheiro);
    
    public byte getLife();
    
    public void setLife(byte life);
    
    public abstract void subirdenivel();
    
    public abstract void atacar(Personagem outro);

    public abstract void fugir();
    
    @Override
    public String toString();
}

package Interfaces;

public interface Personagem {

    public boolean usarArmarnatural();

    public boolean usarArmaSobrehumano();
    
    public float getDinheiro();
    
    public void setDinheiro(float dinheiro);
    
    public byte getLife();
    
    public void setLife(byte life);
    
    @Override
    public String toString();

}

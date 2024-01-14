public class NombreNegatifException extends Exception{
    private int vale;
    private String msg;
    public NombreNegatifException(int vale){
        this.vale = vale;
    }
    public NombreNegatifException(String msg, int valeur){
        this.msg = msg;
        this.vale = valeur;
    }

    public int getValeur() {
        return vale;
    }
    @Override
    public String toString() {
        return "NombreNegatifException{" +
                "valeur=" + vale +
                ", msg='" + msg + '\'' +
                '}';
    }
}

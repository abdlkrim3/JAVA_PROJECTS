public class Application {
    public static void main(String[] args) {
        try{
            EntierNaturel entier = new EntierNaturel(   0);
            entier.decrementer();
            entier.decrementer();
        }
        catch(NombreNegatifException e){
            System.out.println(e);
        }
    }
}

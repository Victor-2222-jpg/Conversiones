package Class;

public class farenheit extends grados {

   public farenheit parse(Celcius c){
         Double valor = c.getValor() * 9/5 + 32;
         farenheit f = new farenheit();
         f.setValor(valor);
         f.setTipo("F");
       return this;
   }

    public farenheit parse(kelvin k){
         Double valor = (k.getValor() - 273.15) * 9/5 + 32;
         farenheit f = new farenheit();
         f.setValor(valor);
         f.setTipo("F");
         return this;
    }
}


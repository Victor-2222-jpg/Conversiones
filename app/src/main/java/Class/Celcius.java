package Class;

public class Celcius extends grados {


    public Celcius parse(farenheit f){
        Double valor = (f.getValor()- 32) * 5/9;
        Celcius c = new Celcius();
        c.setValor(valor);
        c.setTipo("C");
        return this;
    }

    public Celcius parse(kelvin k){

        Double valor = k.getValor() - 273.15;
        Celcius c = new Celcius();
        c.setValor(valor);
        c.setTipo("C");
        return this;

    }
}

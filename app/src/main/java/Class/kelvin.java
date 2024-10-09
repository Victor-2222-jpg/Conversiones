package Class;

public class kelvin extends grados {

    public kelvin parse(Celcius c){
        Double valor = c.getValor() + 273.15;
        kelvin k = new kelvin();
        k.setValor(valor);
        k.setTipo("K");
        return this;

    }

    public kelvin parse(farenheit f){
        Double valor = (f.getValor() - 32) * 5/9 + 273.15;
        kelvin k = new kelvin();
        k.setValor(valor);
        k.setTipo("K");
        return this;
    }

}

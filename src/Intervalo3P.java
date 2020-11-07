public class Intervalo3P extends Intervalo {
    private double puntoIntermedio;

    public Intervalo3P () {
        // Llamada implícita al constructor vacío de la clase padre
        // super();
        this.puntoIntermedio = Intervalo.ORIGEN;
    }

    public Intervalo3P (double extremoInferior, double extremoSuperior) {
        super(extremoInferior, extremoSuperior);
        // this.puntoIntermedio = super.puntoMedio(); // Mismos métodos a no ser que puntoMedio se escriba en Intervalo3P
        this.puntoIntermedio = this.puntoMedio();
    }

    public Intervalo3P (double extremoInferior, double extremoSuperior, double puntoIntermedio) {
        super(extremoInferior, extremoSuperior);
        this.puntoIntermedio = puntoIntermedio;
    }

    public Intervalo3P (Intervalo intervalo) {
        super(intervalo);
        //this.puntoIntermedio = super.puntoMedio();
        //this.puntoIntermedio = this.puntoMedio();
        this.puntoIntermedio = intervalo.puntoMedio();
    }

    public Intervalo3P (Intervalo intervalo, double puntoIntermedio) {
        super(intervalo);
        this.puntoIntermedio = puntoIntermedio;
    }

    public Intervalo3P (double extremo) {
        super(extremo);
        //this.puntoIntermedio = super.puntoMedio();
        this.puntoIntermedio = this.puntoMedio();
    }



    @Override
    public String toString() {
        /*return this.getClass().getName() +
                "[" + this.getExtremoInferior() +
                ", " + this.puntoIntermedio +
                ", " + this.getExtremoSuperior() + "]";
        */
        return super.toString().replaceFirst(",", ", " + this.puntoIntermedio + ",");
    }

    public boolean igual (Intervalo3P intervalo) {
        return super.igual(intervalo) && this.puntoIntermedio == intervalo.puntoIntermedio;
    }
}
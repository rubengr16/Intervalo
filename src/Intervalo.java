class Intervalo {
    // Atributos o Propiedades, private pq no se deben poder modificar dsd fuera
    private double extremoInferior;
    private double extremoSuperior;

    private final double ORIGEN = 0.0; // Variable constante, SIEMPRE en MAYÚSCULAS

    // Constructores (sobrecargados)
    public Intervalo(){
        extremoInferior = ORIGEN;
        extremoSuperior = ORIGEN;
    }

    public Intervalo(double extremoInferior, double extremoSuperior){
        this.extremoInferior = extremoInferior; // El this elimina ambigüedad, entonces referencia al objeto en tiempo de ejecución,
        this.extremoSuperior = extremoSuperior; // en este caso, determina que cuando la clase se ejecute, entonces es su atributo
    }

    public Intervalo(Intervalo intervalo){
        // this(intervalo.extremoInferior, intervalo.extremoSuperior); // Se refiere al constructor del objeto en ejecución
        this.extremoInferior = intervalo.extremoInferior; // Como estamos en la propia clase, no es necesario usar un getter
        this.extremoSuperior = intervalo.extremoSuperior;
    }

	// Métodos públicos

    public double getExtremoInferior() { // Ambos getter son idempotentes, no molestan ni dan problemas si se tienen de más
        return extremoInferior;          // en cambio, setter no
    }

    public double getExtremoSuperior() {
        return extremoSuperior;
    }

    @Override // Code > Override > Seleccionamos los métodos que queramos modificar
    public String toString() {
       return (this.getClass().getName() + "[ " + this.extremoInferior + ", " + this.extremoSuperior + "]");
        // recupera desde el teclado los extremos del intervalo
    }

    public void recoger() {
        // a desarrollar
	}

	public void mostrar() {
        System.out.println(this.toString());
    }

	public double longitud() {
        return this.extremoSuperior - this.extremoInferior;
	}

	public double puntoMedio() {
        return this.longitud()/2 + this.extremoInferior;
	}

	public boolean igual(Intervalo intervalo) {
        return this.extremoInferior == intervalo.extremoInferior
                        && this.extremoSuperior == intervalo.extremoSuperior;
	}

	public boolean distinto(Intervalo intervalo) {
        return !this.igual(intervalo);
	}

	public boolean anterior(Intervalo intervalo) {
        return this.extremoSuperior < intervalo.extremoInferior;
	}

	public boolean posterior(Intervalo intervalo) {
        return this.extremoInferior > intervalo.extremoSuperior;
	}

	public boolean incluye(double punto) {
        return this.extremoInferior <= punto
                        && punto <= this.extremoSuperior;
	}

	public boolean incluye(Intervalo intervalo) {
        return this.incluye(intervalo.extremoInferior)
                        && this.incluye(intervalo.extremoSuperior);
	}

	public boolean intersecta(Intervalo intervalo) {
        return this.incluye(intervalo.extremoInferior)
                        || this.incluye(intervalo.extremoSuperior)
                        || intervalo.incluye(this.extremoInferior)
                        || intervalo.incluye(this.extremoSuperior);
	}

	public Intervalo interseccion(Intervalo intervalo) {
        // a desarrollar
        return null;
	}

	public Intervalo suma(Intervalo intervalo) {
        // a desarrollar
        return null;
	}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.copia();
    }

    public Intervalo copia() {
        return new Intervalo(this);
    }

    public Intervalo desplazar(int valor){
        return new Intervalo(this.extremoInferior + valor, this.extremoInferior + valor);
    }
}

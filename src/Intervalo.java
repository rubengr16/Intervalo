import java.util.Scanner;

class Intervalo {
    // Atributos o Propiedades, private pq no se deben poder modificar dsd fuera
    private double extremoInferior;
    private double extremoSuperior;

    private final double ORIGEN = 0.0; // Variable constante (final), SIEMPRE en MAYÚSCULAS
                                       // Algo es estático si se puede acceder sin instanciar, acceso estático sin necesidad dinámica

    // Constructores (sobrecargados)
    public Intervalo (){
        extremoInferior = ORIGEN;
        extremoSuperior = ORIGEN;
    }

    public Intervalo (double extremoInferior, double extremoSuperior){
       /* if (extremoInferior > extremoSuperior){
           cambiar(extremoInferior, extremoSuperior);
        }
        this.extremoInferior = extremoInferior; // El this elimina ambigüedad, entonces referencia al objeto en tiempo de ejecución,
        this.extremoSuperior = extremoSuperior; // en este caso, determina que cuando la clase se ejecute, entonces es su atributo
        */
        this.extremoInferior = Math.min(extremoInferior, extremoSuperior); // Usando Math es más sencillo
        this.extremoSuperior = Math.max(extremoInferior, extremoSuperior);
    }

    public Intervalo (Intervalo intervalo) {
        // this(intervalo.extremoInferior, intervalo.extremoSuperior); // Se refiere al constructor del objeto en ejecución
    this(); // construye el intervalo vacío y luego lo modificamos
    if (intervalo != null) {
        this.extremoInferior = intervalo.extremoInferior;
        this.extremoSuperior = intervalo.extremoSuperior;
    }
    }

    // Métodos privados
    private double round(double value, int places) {
        //a desarrollar
        return 0;
    }

	// Métodos públicos
    public double getExtremoInferior () { // Ambos getter son idempotentes, no molestan ni dan problemas si se tienen de más
        return extremoInferior;           // en cambio, setter no
        // return this.round(this.extremoInferior, REDONDEO);
    }

    public double getExtremoSuperior () {
        return extremoSuperior;
        //return this.round(this.extremoSuperior, REDONDEO);
    }

    @Override // Code > Override > Seleccionamos los métodos que queramos modificar
    public String toString () {
       return (this.getClass().getName() + "[ " + this.extremoInferior + ", " + this.extremoSuperior + "]");
    }

    public void recoger () {
        // Recuperar por teclado los extremos de un intervalo
        double extremoInferior, extremoSuperior;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Extremo Inferior: ");
        extremoInferior = scanner.nextDouble();
        System.out.println("Extremo Inferior: ");
        extremoSuperior = scanner.nextDouble();
        scanner.close();
        /*
		double aux = extremoSuperior;
		if(extremoSuperior < extremoInferior) {
			extremoSuperior = extremoInferior;
			extremoInferior = aux;
		}
		this.extremoInferior = extremoInferior;
		this.extremoSuperior = extremoSuperior;
		*/
        this.extremoInferior = Math.min(extremoInferior, extremoSuperior);
        this.extremoSuperior = Math.max(extremoInferior, extremoSuperior);
    }

	public void mostrar () {
        System.out.println(this.toString());
    }

	public double longitud () {
        // Devuelve la longitud del intervalo
        return this.extremoSuperior - this.extremoInferior;
	}

	public double puntoMedio () {
        // devuelve el punto medio del intervalo
        return this.longitud()/2 + this.extremoInferior;
	}

    @Override
    public boolean equals (Object obj) {
        return this.igual((Intervalo) obj); // Necesario castear objeto, porque que sea objeto no implica ser intervalo
    }

    public boolean igual (Intervalo intervalo) {
        boolean iguales = false;
        if (intervalo != null) {
           /* if (intervalo.extremoInferior > intervalo.extremoSuperior) {
                cambiar(extremoInferior, extremoSuperior);
            }
            return this.extremoInferior == intervalo.extremoInferior
                    && this.extremoSuperior == intervalo.extremoSuperior;*/
            return this.extremoInferior == Math.min(intervalo.extremoInferior, intervalo.extremoSuperior)
                    && this.extremoSuperior == Math.max(intervalo.extremoInferior, intervalo.extremoSuperior);
        }
        return iguales;
	}

	public boolean distinto (Intervalo intervalo) {
        return !this.igual(intervalo);
	}

	public boolean anterior (Intervalo intervalo) {
        return this.extremoSuperior < intervalo.extremoInferior;
	}

	public boolean posterior (Intervalo intervalo) {
        return this.extremoInferior > intervalo.extremoSuperior;
	}

	public boolean incluye (double punto) {
        return this.extremoInferior <= punto
                        && punto <= this.extremoSuperior;
	}

	public boolean incluye (Intervalo intervalo) {
        return this.incluye(intervalo.extremoInferior)
                        && this.incluye(intervalo.extremoSuperior);
	}

	public boolean intersecta (Intervalo intervalo) {
        return this.incluye(intervalo.extremoInferior)
                        || this.incluye(intervalo.extremoSuperior)
                        || intervalo.incluye(this.extremoInferior)
                        || intervalo.incluye(this.extremoSuperior);
	}

	public Intervalo interseccion (Intervalo intervalo) {
        Intervalo resultado = null;
        /*if (this.intersecta(intervalo)){
            if(this.incluye(intervalo)) {
                resultado = new Intervalo(intervalo);
            } else if (intervalo.incluye(this)) {
                resultado = new Intervalo(this);
            } else if (this.incluye(intervalo.extremoInferior)) {
                resultado = new Intervalo(intervalo.extremoInferior, this.extremoSuperior);
            } else if (intervalo.incluye(this.extremoInferior)) {
                resultado = new Intervalo(this.extremoInferior, intervalo.extremoSuperior);
            }
        }*/
        if (this.intersecta(intervalo)) {
            double extremoInferior = Math.max(this.extremoInferior, intervalo.extremoInferior);
            double extremoSuperior = Math.min(this.extremoSuperior, intervalo.extremoSuperior);
            resultado = new Intervalo(extremoInferior, extremoSuperior);
        }
        return resultado;
	}

	public Intervalo suma (Intervalo intervalo) {
        Intervalo resultado = null;
        /*if (this.intersecta(intervalo)){
            if (this.incluye(intervalo)) {
                resultado = new Intervalo(this);
            } else if (intervalo.incluye(this)) {
                resultado = new Intervalo(intervalo);
            } else if (this.incluye(intervalo.extremoInferior)) {
                resultado = new Intervalo(this.extremoInferior, intervalo.extremoSuperior);
            } else if (intervalo.incluye(this.extremoInferior)) {
                resultado = new Intervalo(intervalo.extremoInferior, this.extremoSuperior);
            }
        }*/
        if(this.intersecta (intervalo)) {
            double extremoInferior = Math.min(this.extremoInferior, intervalo.extremoInferior);
            double extremoSuperior = Math.max(this.extremoSuperior, intervalo.extremoSuperior);
            resultado = new Intervalo(extremoInferior, extremoSuperior);
        }
        return resultado;
	}

    @Override
    protected Object clone() throws CloneNotSupportedException { // No se necesita importar porquue Object class está en el
                                                                 // paquete java.lang (java language)
        return this.copia();                                     // Todos los intervalos son objetos, pero no todos los objetos intervalos
    }

    public Intervalo copia () {
        return new Intervalo(this);
    }

    public Intervalo desplazar (double valor){
        return new Intervalo(this.extremoInferior + valor, this.extremoInferior + valor);
    }

    public void autoDesplazar (double valor){
        this.extremoInferior += valor;
        this.extremoInferior += valor;
    }

    /*public void cambiar (double extremoInferior, double extremoSuperior) { // Innecesario si usamos Math
        double Superior = extremoInferior;
        this.extremoInferior = extremoSuperior;
        this.extremoSuperior = Superior;
    }*/
}

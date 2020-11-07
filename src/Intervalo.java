import java.util.Scanner;

class Intervalo {
    // Atributos o Propiedades, private pq no se deben poder modificar dsd fuera
    private double extremoInferior;
    private double extremoSuperior;

    public /*protected*/ static final double ORIGEN = 0.0; // Variable constante (final), SIEMPRE en MAYÚSCULAS
                                       // Algo es estático si se puede acceder sin instanciar, acceso estático sin necesidad dinámica
    private final int REDONDEO = 2;

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
        this.setExtremoInferior(Math.min(extremoInferior, extremoSuperior)); // Usando Math es más sencillo
        this.setExtremoSuperior(Math.max(extremoInferior, extremoSuperior));
    }

    public Intervalo (Intervalo intervalo) {
        // this(intervalo.extremoInferior, intervalo.extremoSuperior); // Se refiere al constructor del objeto en ejecución
        this(); // construye el intervalo vacío y luego lo modificamos, si no se pone está implicito
        if (intervalo != null) {
            this.extremoInferior = intervalo.extremoInferior; // se podría usar el set
            this.extremoSuperior = intervalo.extremoSuperior;
        }
    }

    public Intervalo(double extremo) {
        this(extremo, Intervalo.ORIGEN);
        /*this();
        if (extremo > ORIGEN) {
            this.setExtremoSuperior(extremo);
        } else {
            this.setExtremoInferior(extremo);
        }*/
    }

    // Métodos privados
    private double redondea(double valor) {
        // redondea a <REDONDEO> decimales el <valor> proporcionado
        // BigDecimal bd = new BigDecimal(valor);
        // bd = bd.setScale(numDecimales, RoundingMode.HALF_UP);
        // return bd.doubleValue();
        long factor = (long) Math.pow(10, REDONDEO); // Calcula los decimales a redondear
        valor = valor * factor; // Multiplica por 10^factor para conservar los decimales deseados
        long tmp = Math.round(valor); // Redondea
        return (double) tmp / factor; // Divide por 10^factor para devolver los decimales deseados a su sitio
    }

    public void setExtremoInferior(double valor) {
        this.extremoInferior = this.redondea(valor);
    }

    public void setExtremoSuperior(double valor) {
        this.extremoSuperior = this.redondea(valor);
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
        this.setExtremoInferior(Math.min(extremoInferior, extremoSuperior));
        this.setExtremoSuperior(Math.max(extremoInferior, extremoSuperior));
    }

	public void mostrar () {
        System.out.println(this.toString());
    }

	public double longitud () {
        // Devuelve la longitud del intervalo
        return this.redondea(this.extremoSuperior - this.extremoInferior);
	}

	public double puntoMedio () {
        // devuelve el punto medio del intervalo
        return this.longitud()/2 + this.extremoInferior;
	}

    @Override
    public boolean equals (Object obj) {
        boolean iguales = false;
        if (obj instanceof Intervalo) {
            iguales = this.igual((Intervalo) obj);
        }
        return iguales; // Necesario castear objeto, porque que sea objeto no implica ser intervalo
    }

    public boolean igual (Intervalo intervalo) {
        boolean iguales = false;
        if (intervalo != null) {
           /* if (intervalo.extremoInferior > intervalo.extremoSuperior) {
                cambiar(extremoInferior, extremoSuperior);
            }
            return this.extremoInferior == intervalo.extremoInferior
                    && this.extremoSuperior == intervalo.extremoSuperior;*/
            iguales = this.extremoInferior == Math.min(intervalo.extremoInferior, intervalo.extremoSuperior)
                    && this.extremoSuperior == Math.max(intervalo.extremoInferior, intervalo.extremoSuperior);
        }
        return iguales;
	}

	public boolean distinto (Intervalo intervalo) {
        return !this.igual(intervalo);
	}

	public boolean anterior (Intervalo intervalo) {
        boolean anterior = false;
        if(intervalo != null) {
            anterior = this.extremoSuperior < intervalo.extremoInferior;
        }
        return anterior;
	}

	public boolean posterior (Intervalo intervalo) {
        boolean posterior = false;
        if(intervalo != null) {
            posterior = this.extremoInferior > intervalo.extremoSuperior;
        }
        return posterior;
	}

	public boolean incluye (double punto) {
        return this.extremoInferior <= punto
                        && punto <= this.extremoSuperior;
	}

	public boolean incluye (Intervalo intervalo) {
        boolean incluye = false;
        if(intervalo != null) {
            incluye = this.incluye(intervalo.extremoInferior) && this.incluye(intervalo.extremoSuperior);
        }
        return incluye;
	}

	public boolean intersecta (Intervalo intervalo) {
        boolean intersecta = false;
        if(intervalo != null) {
            intersecta = this.incluye(intervalo.extremoInferior)
                    || this.incluye(intervalo.extremoSuperior)
                    || intervalo.incluye(this.extremoInferior)
                    || intervalo.incluye(this.extremoSuperior);
        }
        return intersecta;
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

    public Intervalo diferencia(Intervalo intervalo) {
        Intervalo resultado = null;
        double extremoInferior, extremoSuperior;
        if (!this.intersecta(intervalo)) {
            // extremoInferior = Math.max(this.extremoInferior, intervalo.extremoInferior);
            // extremoSuperior = Math.min(this.extremoSuperior, intervalo.extremoSuperior);
            // resultado = new Intervalo(extremoInferior, extremoSuperior);
            if(this.anterior(intervalo)) {
                resultado = new Intervalo(this.extremoSuperior, intervalo.extremoInferior);
            } else {
                resultado = new Intervalo(intervalo.extremoSuperior, this.extremoInferior);
            }
        }
        return resultado;
    }

    public double distancia(Intervalo intervalo) {
        // return new Intervalo(this.diferencia(intervalo)).longitud();
        return (this.diferencia(intervalo) != null)?this.diferencia(intervalo).longitud():0.0;
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

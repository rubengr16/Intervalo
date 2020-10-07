public class Main {
        public static void main(String[] args) { // static pq existe antes del tiempo de ejcución
            Intervalo i1 = new Intervalo();
            Intervalo i2 = new Intervalo(2.15, 7.15);
            Intervalo i3 = new Intervalo(i2);
            Intervalo i4 = new Intervalo(8.0,10.0);
            Intervalo i5 = new Intervalo(3.0, 17.0);

            i1.mostrar();
            i2.mostrar();
            i3.mostrar();
            i4.mostrar();
            i5.mostrar();

            System.out.println("Longitud " + i1 + " : " + i1.longitud());
            System.out.println("Longitud " + i2 + " : " + i2.longitud());
            System.out.println("Longitud " + i4 + " : " + i4.longitud());

            System.out.println("Punto medio " + i1 + " : " + i1.puntoMedio());
            System.out.println("Punto medio " + i2 + " : " + i2.puntoMedio());
            System.out.println("Punto medio " + i4 + " : " + i4.puntoMedio());

            System.out.println("¿Iguales " + i2 + " e " + i3 + " ?: " + i2.igual(i3));
            System.out.println("¿Iguales " + i2 + " e " + i1 + " ?: " + i2.igual(i1));

            System.out.println("¿Distintos " + i2 + " e " + i3 + " ?: " + i2.distinto(i3));
            System.out.println("¿Distintos " + i2 + " e " + i1 + " ?: " + i2.distinto(i1));

            System.out.println("¿Anterior " + i2 + " a " + i4 + " : " + i2.anterior(i4));

            System.out.println("¿Posterior " + i2 + " a " + i4 + " : " + i2.posterior(i4));

            System.out.println("¿Incluye " + i2 + " a 1.5 : " + i2.incluye(1.5));
            System.out.println("¿Incluye " + i2 + " a 3.5 : " + i2.incluye(3.5));

            System.out.println("¿Incluye " + i2 + " a " + i4 + " : " + i2.incluye(i4));
            System.out.println("¿Incluye " + i5 + " a " + i4 + " : " + i5.incluye(i4));

            System.out.println("¿Intersecta " + i2 + "al " + i5 + "?: " + i2.intersecta(i5));
            System.out.println("¿Intersecta " + i4 + "al " + i5 + "?: " + i4.intersecta(i5));

            System.out.println("intersección " + i2 + " e " + i5 + "?: " + i2.interseccion(i5));
            System.out.println("intersección " + i4 + " e " + i5 + "?: " + i4.interseccion(i5));

            System.out.println("¿Suma " + i2  +" e " + i4 + "?: " + i2.suma(i4));
            System.out.println("¿Suma " + i2 + " e " + i5 + "?: " + i2.suma(i5));

            System.out.println("Desplazar " + i2 + "con 3.5: " + i2.desplazar(3.5));

            i1.recoger();
            i1.mostrar();

            // Modificar código para devolver 2 decimales redondeados
        }
}

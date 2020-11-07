public class Main {
        public static void main(String[] args) { // static pq existe antes del tiempo de ejcución
            Intervalo i0 = new Intervalo();
            Intervalo i1 = new Intervalo(5.0);
            Intervalo i2 = new Intervalo(4.0, 8.0);
            Intervalo i3 = new Intervalo(i2);
            Intervalo i4 = new Intervalo(8.0,10.0);
            Intervalo i5 = new Intervalo(3.0, 17.0);

            Intervalo3P i3P1 = new Intervalo3P();
            Intervalo3P i3P2 = new Intervalo3P(5.0);
            Intervalo3P i3P3 = new Intervalo3P(4.0, 8.0);
            Intervalo3P i3P4 = new Intervalo3P(4.0, 8.0, 7.0);
            Intervalo3P i3P5 = new Intervalo3P(new Intervalo(5.5));


            Intervalo lista[] = new Intervalo[]{i0, i1, i2, i3P1, i3P2, i3P3, i3P4};


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

            /* System.out.println("intersección " + i2 + " e " + i5 + "?: " + i2.interseccion(i5));
            System.out.println("intersección " + i4 + " e " + i5 + "?: " + i4.interseccion(i5));

            System.out.println("¿Suma " + i2  +" e " + i4 + "?: " + i2.suma(i4));
            System.out.println("¿Suma " + i2 + " e " + i5 + "?: " + i2.suma(i5));

            System.out.println("Desplazar " + i2 + "con 3.5: " + i2.desplazar(3.5)); */

            i1.recoger();
            i1.mostrar();

            i3P1.mostrar();
            i3P2.mostrar();
            i3P3.mostrar();
            i3P4.mostrar();
            i3P5.mostrar();


            for (Intervalo i: lista) {
                i.mostrar();
            }

            System.out.println("------------");
            System.out.println("¿Iguales " + lista[1] + " al " + lista[4] + "?: " + lista[1].igual(lista[4]));
            System.out.println("¿Iguales " + i1 + " al " + i3P1 + "?: " + i1.igual(i3P1));
            System.out.println("¿Iguales " + lista[5] + " al " + lista[2] + "?: " + lista[5].igual(lista[2]));
            System.out.println("¿Iguales " + i3P5 + " al " + i2 + "?: " + i3P5.igual(i2));
            System.out.println("------------");
            System.out.println("¿Iguales " + lista[5] + " al " + lista[6] + "?: " + lista[5].igual(lista[6]));
            System.out.println("¿Iguales " + i3P3 + " al " + i3P4 + "?: " + i3P3.igual(i3P4));
            System.out.println("¿Iguales " + i3P3 + " al " + i3P4 + "?: " + ((Intervalo)i3P3).igual(i3P4));
            System.out.println("¿Iguales " + i3P3 + " al " + i3P4 + "?: " + i3P3.igual((Intervalo)i3P4));
        }
}

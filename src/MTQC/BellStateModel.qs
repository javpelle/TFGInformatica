namespace Quantum.Bell.Model {
    open Microsoft.Quantum.Intrinsic;
    open Microsoft.Quantum.Canon;
    open Microsoft.Quantum.Diagnostics;


    operation MainQuantum(count : Int, initial : Result) : (Int, Int, Int) {
         using ((q0, q1) = (Qubit(), Qubit())) {

             //Espacio para iniciar los Qubits
             
             //Ejectuamos el método guardando el output
             let(r1,r2,r3) =  TestBellState(q0,q1, count, initial);

             //Aseguramos que los qubits estén a 0 antes de liberaros
             Set(Zero, q0); 
	         Set(Zero, q1);

             //Devolvemos el resultado
             return (r1,r2,r3);
		}
	}


    operation Set(desired : Result, q1 : Qubit) : Unit {
        if (desired != M(q1)) {
            X(q1);
        }
    }


	operation TestBellState(q0: Qubit, q1 : Qubit, count : Int, initial : Result) : (Int, Int, Int) {

        mutable numOnes = 0; //Por defecto las variables en Q# son inmutables
	    mutable agree= 0; //Numero de veces en las que las medidas de los dos qubits coinciden
        //Los qubits se crearn dinamicamente con using, y al salir del bloque se liberan.

        for (test in 1..count) {
            Set(initial, q0);
			Set(Zero, q1);

			H(q0);
			CNOT(q0, q1);
			let res = M(q0);
			if (M(q1) == res) {
                    set agree += 1;
                }

            // Count the number of ones we saw:
            if (res == One) {
                set numOnes += 1;
            }
        }
		

    // Return number of times we saw a |0> and number of times we saw a |1>
        return (count-numOnes, numOnes, agree);
	}

}

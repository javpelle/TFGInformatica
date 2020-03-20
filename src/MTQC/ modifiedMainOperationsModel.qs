﻿namespace Quantum.Bell.Model {
    open Microsoft.Quantum.Intrinsic;
    open Microsoft.Quantum.Canon;
    open Microsoft.Quantum.Diagnostics;


    operation Set(desired : Result, q1 : Qubit) : Unit {
        if (desired != M(q1)) {
            X(q1);
        }
    }


	operation TestBellState(register : Qubit[] , count : Int, initial : Result) : (Int, Int, Int) {

        mutable numOnes = 0; //Por defecto las variables en Q# son inmutables
	    mutable agree= 0; //Numero de veces en las que las medidas de los dos qubits coinciden
        //Los qubits se crearn dinamicamente con using, y al salir del bloque se liberan.

        for (test in 1..count) {
            Set(initial, register[0]);
			Set(Zero, register[1]);

			H(register[0]);
			CNOT(register[0], register[1]);
			let res = M(register[0]);
			if (M(register[1]) == res) {
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

	operation MainQuantum() : (Int, Int, Int) {
		//Select desired Qubit number to be used
		using (register = Qubit[2]) {
		
			//Inicialize variables and Qubits
			let count = 1;
			let initial = Zero;
		
			//Call method and save output
			let(r1,r2,r3) =  TestBellState(register, count, initial);
		
			//Reset all qubits to Zero state
			ResetAll(register);
		
			//Return output
			return (r1,r2,r3);
			//DumpMachine("dump.txt");// If probabilistic test chosen. Don't change dump.txt
		}
	}
	}

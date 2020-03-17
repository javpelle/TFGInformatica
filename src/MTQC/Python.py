import qsharp
import Quantum.Bell.Model as qm

(a,b,c) = qm.MainQuantum.simulate(count=1, initial = 1)
print(a,b,c)
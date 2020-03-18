def AND_3(qc, qr, cr, and_qbits, target):
	and1 = and_qbits[0]
	and2 = and_qbits[1]
	and3 = and_qbits[2]
	aux = set(range(5)) - (set(and_qbits + [target]))
	aux = aux.pop()
	qc.AND([qr[and1]] + [qr[and2]], qr[aux], None)
	qc.AND([qr[aux]] + [qr[and3]], qr[target], None)
	qc.h(1)
# This code is part of MTQC.
#
# Copyright (c) 2020 Javier Pellejero, Luis Aguirre.
#
# This code is licensed under the MIT License. You may
# obtain a copy of this license in the LICENSE file in the root directory
# of this source tree or at https://github.com/javpelle/TFGInformatica/blob/master/LICENSE.

from tools.func_timeout import func_timeout, FunctionTimedOut

def run_shots (function, timeout, shots, keyStart = '_mtqc_s', keyEnd = '_mtqc_e', QStateTest = False):
	for i in range(shots):
		try:
			if QStateTest:
				doitReturnValue = func_timeout(timeout, function)
				aux = open("temp.txt", "r", encoding='utf-8') 
				res = open("result.txt", "a", encoding='utf-8')
				res.write(aux.read())
				aux.close()
				res.close()
			else:
				doitReturnValue = func_timeout(timeout, function)
				print(keyStart, doitReturnValue)
				print(keyEnd)
		except FunctionTimedOut:
			print (keyStart, "TimeLimit")
			print(keyEnd)
		except Exception as e:
			print (keyStart, e)
			print(keyEnd)

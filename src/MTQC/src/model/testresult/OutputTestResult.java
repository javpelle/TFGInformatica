package model.testresult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class OutputTestResult extends TestResult {

	private ArrayList<String> result;
	private HashMap<String, Integer> map;

	public OutputTestResult(String mutantName, int idTest) {
		super(mutantName, idTest);
		result = new ArrayList<String>();
	}

	public String getName() {
		return mutantName + "_" + Integer.toString(idTest);
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResult(String result) {
		this.result.add(result);
	}

	@Override
	public void make() {
		HashMap<String, Integer> map = new HashMap<>();
		for (String r : result) {
			if (map.containsKey(r)) {
				map.put(r, map.get(r) + 1);
			} else {
				map.put(r, 1);
			}
		}
		this.map = map;
	}

	public String toString() {
		String ret = "";
		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
			ret += "(" + entry.getKey() + ", " + entry.getValue() + ", "
					+ String.valueOf((double) Math.round(entry.getValue() * 1000.0 / result.size()) / 10.0) + "%)";
		}
		return ret;
	}

}

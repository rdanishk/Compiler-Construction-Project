package pkg;

import java.util.HashMap;
import java.util.Iterator;

public class MySymbolTable {

	private HashMap symTab = new HashMap();

	public MySymbolTable() {

	}

	public void put(String key, Object value) {
		symTab.put(key, value);
	}

	public Object get(String key) {
		return symTab.get(key);
	}

	public int getSize() {
		return symTab.size();
	}

	public void show() {
		Iterator it = symTab.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	public boolean checkValue(String tVal) { // Duplicate checking & Declaration
		// Checking
		if (symTab.containsValue(tVal))
			return true;
		else
			return false;
	}

	public String fetchType(String typeSub) { // Check Presence in SymbolTable
												// then fetch type
		String s = null;
		Iterator it = symTab.values().iterator();
		while (it.hasNext()) {
			s = it.next().toString();
			if (s.contains(" " + typeSub)) {
				if (s.contains("int")) {
					return "int";
				} else if (s.contains("float")) {
					return "float";
				}
			}
		}
		return null;
	}
}

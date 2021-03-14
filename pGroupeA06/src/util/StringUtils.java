package util;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {


    public static String diff(String a, String b) {
        return diffHelper(a, b, new HashMap<>()).getFirst();
    }

    private static Pair<String> diffHelper(String a, String b, Map<Long, Pair<String>> lookup) {
        long key = ((long) a.length()) << 32 | b.length();
        if (!lookup.containsKey(key)) {
            Pair<String> value;
            if (a.isEmpty() || b.isEmpty()) {
                value = new Pair<>(a, b);
            } else if (a.charAt(0) == b.charAt(0)) {
                value = diffHelper(a.substring(1), b.substring(1), lookup);
            } else {
                Pair<String> aa = diffHelper(a.substring(1), b, lookup);
                Pair<String> bb = diffHelper(a, b.substring(1), lookup);
                if (aa.first.length() + aa.second.length() < bb.first.length() + bb.second.length()) {
                    value = new Pair<>(a.charAt(0) + aa.first, aa.second);
                } else {
                    value = new Pair<>(bb.first, b.charAt(0) + bb.second);
                }
            }
            lookup.put(key, value);
        }
        return lookup.get(key);
    }

    public static class Pair<X> {
    	public final X first, second;
    	
        public Pair(X first, X second) {
            this.first = first;
            this.second = second;
        }
        
        public String getFirst() {
        	String x = (String) this.first;
        	String y =(String)this.second;
        	return (x.length()>y.length())?x:y;
        }
    }
}

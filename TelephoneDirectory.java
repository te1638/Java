import java.util.HashMap;
import java.util.Map;


public class TelephoneDirectory implements TelephoneCatalog {
    private Map<String, String> td;

    public TelephoneDirectory() {
        td = new HashMap<>();
    }

    @Override
    public void add(String k, String v) {
        td.put(k, v);
    }

    @Override
    public void get(String name) {
        for (Map.Entry<String, String> o : td.entrySet()) {
            if (o.getValue().equals(name)) {

                System.out.format("\nФамилия: %s, номер телефона :%s", o.getValue(), o.getKey());
            }
        }
    }


}



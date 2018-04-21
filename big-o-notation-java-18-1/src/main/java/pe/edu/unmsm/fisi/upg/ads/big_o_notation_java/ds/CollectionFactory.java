package pe.edu.unmsm.fisi.upg.ads.big_o_notation_java.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionFactory {
    public static Collection<String> getCollection(CollectionType collectionType) {
        switch (collectionType) {
            case ArrayList:
                return new ArrayList<String>();
            case HashSet:
                return new HashSet<String>();
            default:
                return new HashSet<String>();
        }
    }
}

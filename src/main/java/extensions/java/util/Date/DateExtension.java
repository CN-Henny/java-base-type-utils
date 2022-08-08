package extensions.java.util.Date;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.util.Date;

@Extension
public class DateExtension {
    public static Date toBigDecimal(@This Date a) {
        return a;
    }
    public static Integer toInteger(@This Date a) {
        return 1;
    }

}

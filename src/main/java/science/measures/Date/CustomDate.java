package science.measures.Date;

import manifold.science.api.AbstractMeasure;
import manifold.science.measures.Time;
import manifold.science.measures.TimeUnit;
import manifold.science.util.Rational;

import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import static java.time.temporal.ChronoUnit.*;

public final class CustomDate extends AbstractMeasure<CustomDateUnit, CustomDate> {

    public CustomDate(Rational value, CustomDateUnit unit, CustomDateUnit displayUnit) {
        super(value, unit, displayUnit);
    }
    public CustomDate( Rational value, CustomDateUnit unit )
    {
        this( value, unit, unit );
    }

    @Override
    public CustomDateUnit getBaseUnit() {
        return CustomDateUnit.BASE;
    }

    @Override
    public CustomDate make(Rational rational, CustomDateUnit customDateUnit, CustomDateUnit u1) {
        return new CustomDate( rational, customDateUnit, u1 );
    }


    @Override
    public CustomDate make(Rational value, CustomDateUnit unit )
    {
        return new CustomDate( value, unit, unit );
    }

    public long get( TemporalUnit unit )
    {
        if( unit == SECONDS )
        {
            return toBaseNumber().wholePart().longValue();
        }
        else if( unit == HOURS )
        {
            return toBaseNumber().wholePart().longValue()/3600;
        }
        else if( unit == NANOS )
        {
            return toBaseNumber().fractionPart().times( 1.0e9 ).longValue();
        }
        else
        {
            throw new UnsupportedTemporalTypeException( "Unsupported unit: " + unit );
        }
    }
}
package science.measures.Date;

import manifold.science.api.AbstractPrimaryUnit;
import manifold.science.api.Unit;
import manifold.science.api.UnitCache;
import manifold.science.measures.Length;
import manifold.science.measures.Time;
import manifold.science.measures.TimeUnit;
import manifold.science.util.Rational;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static manifold.science.util.CoercionConstants.r;

public final class CustomDateUnit extends AbstractPrimaryUnit<CustomDate, CustomDateUnit> {

    private static final UnitCache<CustomDateUnit> CACHE = new UnitCache<>();

    private final Duration _duration;
    private final boolean _fuzzyDuration;
    private final boolean _isDateBased;

    private CustomDateUnit( Rational sec, Duration duration, boolean fuzzyDuration, boolean isDateBase, String name, String symbol )
    {
        super( sec, name, symbol );
        _duration = duration;
        _fuzzyDuration = fuzzyDuration;
        _isDateBased = isDateBase;
    }

    public static CustomDateUnit get( Rational secondFactor, Duration duration, boolean fuzzyDuration, boolean isDateBased, String name, String symbol )
    {
        return CACHE.get( new CustomDateUnit( secondFactor, duration, fuzzyDuration, isDateBased, name, symbol ) );
    }

    @Override
    public CustomDate makeDimension(Number amount )
    {
        return new CustomDate( Rational.get( amount ), this );
    }

    public static final CustomDateUnit Second = get( 1 r, ChronoUnit.SECONDS.getDuration(), false, false, "Second", "s" );

    public static final CustomDateUnit Hour = get( 1 r * 60 * 60, ChronoUnit.HOURS.getDuration(), false, false, "Hour", "h" );

    public static final CustomDateUnit BASE = Second;

}

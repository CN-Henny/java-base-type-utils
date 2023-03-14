package com.Const.java.math.Bigdecimal;

import java.math.BigDecimal;

public class CustomConstBigDecmial {

    /**
     * 0-10
     *
     * @param null
     * @return
     * @author Henny
     * @cdate 2023/2/22 14:14
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:14
     * @exception
     * @since 2.1.37
     */
    private static final BigDecimal zeroThroughTen[] = {
            new BigDecimal(0),
            new BigDecimal(1),
            new BigDecimal(2),
            new BigDecimal(3),
            new BigDecimal(4),
            new BigDecimal(5),
            new BigDecimal(6),
            new BigDecimal(7),
            new BigDecimal(8),
            new BigDecimal(9),
            new BigDecimal(10),
    };

    /**
     * 零
     *
     * @param null
     * @return
     * @author Henny
     * @cdate 2023/2/22 14:14
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:14
     * @exception
     * @since 1.0
     */
    public static final BigDecimal ZERO =
            zeroThroughTen[0];

    /**
     * 一
     *
     * @param null
     * @return
     * @author Henny
     * @cdate 2023/2/22 14:13
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:13
     * @exception
     * @since 1.0
     */
    public static final BigDecimal ONE =
            zeroThroughTen[1];

    /**
     * 十
     *
     * @param null
     * @return
     * @author Henny
     * @cdate 2023/2/22 14:13
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:13
     * @exception
     * @since 1.0
     */
    public static final BigDecimal TEN =
            zeroThroughTen[10];

    /**
     * 一百
     *
     * @param null
     * @return
     * @author Henny
     * @cdate 2023/2/22 14:16
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:16
     * @exception
     * @since 1.0
     */
    public static final BigDecimal OneHundred =
            new BigDecimal(100);

    /**
     * 一千
     *
     * @param null
     * @return
     * @author Henny
     * @cdate 2023/2/22 14:16
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:16
     * @exception
     * @since 1.0
     */
    public static final BigDecimal OneThousand =
            new BigDecimal(1000);

    /**
     * 一万
     *
     * @param null
     * @return
     * @author Henny
     * @cdate 2023/2/22 14:16
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:16
     * @exception
     * @since 1.0
     */
    public static final BigDecimal TenThousand =
            new BigDecimal(10000);

}

package com.example.demo;


import cn.hutool.core.date.DateUnit;
import com.Utils.ColumnUtil;
import com.Utils.CustomTimeZone;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dlanqi.utils.CustomNumberUtils;
import extensions.java.lang.Object.ObjectExtension;
import manifold.science.measures.Length;
import manifold.science.measures.LengthUnit;
import manifold.science.util.Rational;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import science.measures.Date.CustomDate;
import science.measures.Date.CustomDateUnit;
import sun.util.calendar.ZoneInfo;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.dlanqi.utils.GPSUtils.pi;
import static java.time.temporal.ChronoUnit.*;
import static manifold.science.util.CoercionConstants.r;
import static manifold.science.util.UnitConstants.mph;
import static science.unit.CustomUnitConstants.*;

public class DemoApplication {

    public static void main(String[] args) {
        String sgsfsd = "123456789";
        //System.out.println(sgsfsd.customSubStrLast(90));

        BigDecimal sergse = new BigDecimal(100);
        sergse.customConvertToTenThousand();
        System.out.println(sergse.customDivideOneHundred());
        System.out.println(sergse.customMultiplyOneHundred());

        UserData ud = new UserData();
        UserData udccc = new UserData();
        List<UserDDDD> udddlist = new ArrayList<>();
        UserDDDD uddd = new UserDDDD();
        uddd.setUserId(1L);
        udddlist.add(uddd);
        ud.setUaer(udddlist);

        ud.customCopyPropertiesTo(udccc, 1);


        String athtrgr = "-1";
        Long gsfasefa = athtrgr.customToLong();

        BigDecimal aaa1 = new BigDecimal(1);
        BigDecimal aaa2 = new BigDecimal(3);
        BigDecimal aaa3 = aaa1.customDivideAll(aaa2);


        List<Long> trialCardasdList = new ArrayList<>();
        trialCardasdList.add(1L);
        trialCardasdList.add(2L);
        trialCardasdList.add(1L);
        trialCardasdList.add(1L);

        List<Long> cgrsdfavvv = trialCardasdList.customToLambdaDistinct(true, e -> e);

        // 最原始和基础的方式
        /*
        List<String> list = stream.collect(
                ()->new ArrayList(),
                (theList, item) -> theList.add(item),
                (list1, list2) -> list1.addAll(list2)
        );
        */
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        List<String> listDetail = stream.collect(
                () -> {
                    ArrayList<String> arrayList = new ArrayList<>();
                    System.out.println("第一个list诞生, size: " + arrayList.size());
                    return arrayList;
                },
                (theList, item) -> {
                    System.out.println("第二个list的size: " + theList.size());
                    theList.add(item);
                },
                (list1, list2) -> {
                    System.out.println("第三个list1的size: " + list1.size());
                    System.out.println("第四个list2的size: " + list2.size());
                    list1.addAll(list2);
                }
        );


        List<UserAAA> trialCardList = new ArrayList<>();
        UserAAA trialCard = new UserAAA();
        trialCard.setUserId(1243L);
        trialCard.setSix("1222");
        UserAAA trialCard1 = new UserAAA();
        trialCard1.setUserId(1231L);
        trialCard1.setSix("1111");
        UserAAA trialCard2 = new UserAAA();
        trialCard2.setUserId(1323L);
        trialCard2.setSix("12");
        trialCardList.add(trialCard2);
        trialCardList.add(trialCard1);
        trialCardList.add(trialCard);
        List<UserAAA> newstrialCardList22 = trialCardList.stream().sorted(Comparator.comparing(e -> e.getSix())).collect(Collectors.toList());
        List<UserAAA> newstrialCardList = trialCardList.customToLambdaDistinct(true, e -> e.getUserId() + e.getSix());
        List<UserAAA> newstrialCardList2 = trialCardList.customToLambdaDistinct(true, e -> e.getUserId());
        List<UserAAA> newstrialCardList3 = trialCardList.customToLambdaDistinct(true, e -> e.getSix());
        List<UserAAA> newstrialCardLis4t = trialCardList.customSort(e -> e.getUserId(), "");
        List<Long> dgdthyr = new ArrayList<>();
        dgdthyr.customAdd(1L).customAdd(1L).customAdd(1L).customAdd(1L);

        List<Long> dgdthyr1 = dgdthyr.customToLambdaDistinct(true, e -> e);


        List<UserAAA> newTrialCardList = trialCardList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(o -> o.getUserId() + o.getSix() + o.getPassWord()))), ArrayList::new));


        Double q1111 = 123.14234234;
        Double q2222 = 345.3634345352;
        Double q22222 = 345.3634345352;
        Double q22223 = 345.3634345352;
        Double q22224 = 345.3634345352;
        Double q22225 = 345.3634345352;
        Double q22226 = 345.3634345352;
        Double q22227 = 345.3634345352;
        Double q22228 = 345.3634345352;
        long start = System.currentTimeMillis();
        Double q3333 = q1111 + q2222 + q22222 + q22223 + q22224 + q22225 + q22226 + q22227 + q22228;
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        long start1 = System.currentTimeMillis();
        long finish2 = System.currentTimeMillis();
        Double q33333 = q1111.customSumAll(q2222, q22222, q22223, q22224, q22225, q22226, q22227, q22228);
        long timeElapsed3 = finish2 - start1;

        String ergsf = "asdas,1324,34523442";
        List<Long> sdgsdfd = new ArrayList<>();
        sdgsdfd.customIsNotNull();
        List<UserAAA> sgrgtresf = new ArrayList<>();
        sgrgtresf.customJoin(",");
        sdgsdfd.add(1L);
        Long atrht = sdgsdfd.customFindFirstOrDefault(new Long(0L));
        sdgsdfd.customAdd(123L);
        JSONArray asdfasdds = new JSONArray();
        JSONArray asdfds = null;
        JSONArray sfsfs = asdfds.customGetValue();
        Date date = new Date();
        System.out.println(date.customFormat("yyyy-MM-dd HH.mm.ss", CustomTimeZone.Asia_Shanghai));
        System.out.println(date.customSetTimeZone(CustomTimeZone.Asia_Shanghai));
        System.out.println(date.customSetTimeZone(CustomTimeZone.Europe_London));
        System.out.println(date.customSetTimeZone(CustomTimeZone.ECT));
        System.out.println(date.customFormat("yyyy-MM-dd HH.mm.ss", CustomTimeZone.AfricaAbidjan));
        System.out.println(date.customFormat("yyyy/MM/dd HH:mm:ss", CustomTimeZone.ECT));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.customToDate(CustomTimeZone.Asia_Shanghai));

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("-8"));  // 设置伦敦时区

        System.out.println(londonSdf.format(date));
        londonSdf.setTimeZone(TimeZone.getTimeZone("8"));  // 设置伦敦时区
        System.out.println(londonSdf.format(date));
        System.out.println(date);
        LocalDate localDate = LocalDate.now();

        LocalTime localTime = LocalTime.now();

        String thgg = "123456789";
        System.out.println(thgg.customSubStr(3, 2));
        System.out.println(thgg.customSubStr(3, -3));
        System.out.println(thgg.customSubStr(-3, 2));
        System.out.println(thgg.customSubStr(-3, -2));
        System.out.println(thgg.customSubStr(-2));
        System.out.println(thgg.customSubStr(2));

        //String a = "1,2,3";
        //List<Long> ger = a.customSplit(",",Long.class);


        List<String> s1 = new ArrayList<>();
        //s1.customAdd("1").customAdd("4").customAdd("3");
        //stringLambdaExtension.ok(e->e.toString());
        //s1.customToBigDecimalList(e -> e.customToBigDecimal());
        String atyy = "   ";
        Boolean rgfer = atyy.customIsBlank();
        Boolean gredf = atyy.customIsEmpty();

        long ms1 = System.currentTimeMillis();


        Double d1 = 11321313.126412321321312356;
        Integer decimalsLength = 2;
        Double errorBack = 1.1;
        String result = d1.customRoundUp(decimalsLength, errorBack).customNousedF_E();

        TreeSet<UserData> ta = new TreeSet<>(Comparator.comparing(o -> o.ceshi() + "#" + o.ceshi1()));
        UserData rreeq1 = new UserData();

        List<UserDDDD> userDDDDS = new ArrayList<>();
        UserDDDD userDDDD = new UserDDDD();
        userDDDD.setUserId(123L);

        List<UserAAA> userAAAS = new ArrayList<>();
        UserAAA userAAA = new UserAAA();
        userAAA.setUserId(1L);
        userAAAS.add(userAAA);
        userDDDD.setUaer1(userAAAS);
        userDDDDS.add(userDDDD);
        userDDDDS.add(userDDDD);
        String adfgfd = new String("111");
        String adfgafd = "111";
        List<UserData> uuu = new ArrayList<>();
        UserData u11 = new UserData();
        u11.setUserName("1");
        //u11.setSix("11");
        u11.setPassWord("111");
        u11.setUaer(userDDDDS);
        uuu.add(u11);
        ta.add(u11);
        UserData u111 = new UserData();
        u111.setUserName("2");
        u111.setSix("22");
        u111.setPassWord("222");
        u111.setUaer(userDDDDS);
        uuu.add(u111);
        List<String> filterStr = new ArrayList<>();
        filterStr.add("1");
        //filterStr.add("111");
        if ("qqqq" == u11.getUserName()) {
            String trhdgf = "1";
        }

        List<BigDecimal> a111 = new ArrayList<>();
        List<BigDecimal> a1111 = new ArrayList<>();
        a111.add(new BigDecimal(1));
        a111.add(new BigDecimal(4));
        a1111.add(new BigDecimal(2));


        BigDecimal t1 = new BigDecimal(2);
        BigDecimal t2 = new BigDecimal(4);
        //BigDecimal t3 = t1+t2;

        List<Integer> y1 = new ArrayList<>();
        List<Integer> y2 = new ArrayList<>();
        //Integer etrhdgf = y1 + y2;


        List<Long> atttt = uuu.customMoreLevelToLongList(e ->
                e.getUaer().customMoreLevelToLongList(f ->
                        f.getUaer1().customToLongList(g ->
                                g.getUserId())));

        //u11.customCopyPropertiesTo(u111);
        u11.customCopyPropertiesTo(u111);

        final BeanWrapper wrappedSource = new BeanWrapperImpl(u11);
        Supplier<Stream<String>> as = () -> Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName);
        Supplier<Stream<String>> finalAs = as;
        as = () -> finalAs.get().filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == "huangjingwei");
        as = () -> finalAs.get().filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == "1");
        String[] htrgrdfd = as.get().toArray(String[]::new);

        //BeanUtils.copyProperties(u111, u11);

        //nullPropertyNames.forEach((item,v)->{
        //    final BeanWrapper beanWrapper1 = new BeanWrapperImpl(u111);
        //    String[] allname = Stream.of(wrappedSource.getPropertyDescriptors())
        //            .map(FeatureDescriptor::getName)
        //            .toArray(String[]::new);
        //    allname.forEach((a,b)->{
        //        if(nullPropertyNames[item] == allname[a])
        //        {
        //            wrappedSource.setPropertyValue(allname[a],beanWrapper1.getPropertyValue(nullPropertyNames[item]));
        //        }
        //    });
        //});

        Stream<String> reyrygha = Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName);


        //BeanUtils.copyProperties(source, target, nullPropertyNames);


        String auuj = uuu.customGetFieldName(UserData::getUserName);


        System.out.println(ColumnUtil.getFieldName(UserData::getUserName));

        UserData u1111 = new UserData();
        u1111.setUserName("2");
        u1111.setSix("1");
        uuu.add(u1111);
        //uuu.customToBigDecimalList(e -> e.getUserName().customToBigDecimal());
        //uuu.customToLambdaSelect(e -> e.getUserName() == "1" && e.getSix() == "2");
        //u11.customConvert(UserData.class);
        //TreeSet<UserData> treeSet = new TreeSet<>(Comparator.comparing(UserData::getUserName));
        ////List<UserData> uuuu = uuu.customToLambdaquchong(e->e.getUserName());
        //List<UserData> uuuuu = uuu.customToLambdaquchong(e -> e.getUserName().and(e.getSix().and(e.getPassWord())));
        //List<UserData> uuuuuu = uuu.customToLambdaquchong(e -> e.getUserName().or(e.getUserName().or(e.getUserName())));
        //uuu.customToLambdaquchong(e->e.getUserName());
        //List<Long> tryhtrbgf = uuu.toLongList(e -> e.getUserName().customToLong());
        //uuu.toLambda(e->e.getUserName() == "1" && e.getUserName()!= "1");

        List<String> text = new ArrayList<>();
        List<UserData> user = new ArrayList<>();
        UserData u1 = new UserData();
        u1.setUserName("1");
        user.add(u1);
        UserData u2 = new UserData();
        u2.setUserName("2");
        user.add(u2);
        user.forEach(item -> {
            String a = item.getUserName();
            text.add(a.toString());
        });
        String rreeq = null;
        //rreeq.toLambda(item -> {
        //    System.out.println("ssdsdsd");
        //});

        Integer aasd = null;
        aasd.customIsNull();
        System.out.println("1");
        aasd.customIsNotNull();
        System.out.println("1");
        aasd.customIsNotNull(2).customSumAll();
        //JSONObject a = new JSONObject();
        //aasd.customLength();
        Double a = 1234567890123.123456789456;
        BigDecimal c = new BigDecimal("3.0000000000000000000000000");
        BigDecimal cc = new BigDecimal("0.0000000000000000000000000");
        BigDecimal ccc = new BigDecimal("2.12345678912340000000000000000");
        List<BigDecimal> cccccc = new ArrayList<>();
        cccccc.forEach(item -> {

        });
        //cccccc.customAdd(cc).customAdd(ccc);
        BigDecimal q1 = c.customSumAll(cc, ccc);
        //BigDecimal q4 = c.customDivideAll(3,BigDecimal.ROUND_HALF_DOWN,cc,ccc);
        BigDecimal q2 = c.customSumAll(cccccc);
        BigDecimal q3 = c.customSumAll(4, BigDecimal.ROUND_HALF_UP, cccccc);
        List<BigDecimal> bigDecimals = new ArrayList<>();
        UserData d = new UserData();
        //a.systemCustomGetModifyContent();
        //c.systemCustomGetModifyContent();
        //d.systemCustomGetModifyContent();
        Integer b = 0;
        Date aaa;
        //a.toInteger();
        System.out.println(a.customDecimalsLength());
        System.out.println(a.customRoundHalfUp(2));
        System.out.println(a.customRoundHalfDown(2));
        System.out.println(a.customRoundUp(2).customNousedF_E());
        System.out.println(a.customRoundDown(2));
        System.out.println(c);
        System.out.println(c);
        //Date c = new Date();
        //a.toInteger();
        //a.toString().toBigDecimal();
        Map<String, String> arr = new HashMap<>();
        arr.add("1", "1").add("2", "2");
        String aewew = "";
        String[] strings = new String[]{"a", "b", "c"};
        ArrayList<UserData> arrayList = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        //strings.toList();
        //ids.customAdd(1).customAdd(2).customAdd(3);
        //ids.add(1).add(2);
        //File asdasd = new File();
        //asdasd.file();
    }

}

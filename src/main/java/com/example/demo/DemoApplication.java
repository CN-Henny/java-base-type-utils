package com.example.demo;


import com.Utils.ColumnUtil;
import com.alibaba.fastjson.JSONObject;
import extensions.java.lang.Object.ObjectExtension;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoApplication {

    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>();
        //s1.customAdd("1").customAdd("4").customAdd("3");
        //stringLambdaExtension.ok(e->e.toString());
        //s1.customToBigDecimalList(e -> e.customToBigDecimal());

        Double d1 = 11321313.126412321321312356;
        Integer decimalsLength = 2;
        Double errorBack = 1.1;
        String result = d1.customRoundUp(decimalsLength,errorBack).customNousedF_E();

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
        if("qqqq" == u11.getUserName())
        {
            String trhdgf = "1";
        }

        List<Long> atttt = uuu.customMoreLeveToLongList(e->e.getUaer().customMoreLeveToLongList(f->f.getUaer1().customToLongList(g->g.getUserId())));

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
        uuu.testsstts(UserData::ceshi);
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

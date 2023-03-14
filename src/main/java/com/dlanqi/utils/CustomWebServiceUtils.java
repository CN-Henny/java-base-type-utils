package com.dlanqi.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.lang.reflect.Array;

/**
 * webservice调用工具
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author Rex
 * @since 2022/9/6 22:49
 */
public class CustomWebServiceUtils {

    /**
     * webservice通用调用
     *
     * @param webServiceUrl 地址
     * @param methodName    方法名
     * @param param         参数数据
     * @return {@link String}
     * @author Rex
     * @since 2022/9/7 11:26
     */
    public static String webServiceClientCommon(String webServiceUrl, String methodName, String... param) {
        String result = "";
        if (CustomStringUtils.isEmpty(webServiceUrl)) {
            throw new RuntimeException("地址不可为空");
        }
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(webServiceUrl);
        Object[] objects;
        try {
            objects = client.invoke(methodName, param);
            result = CustomStringUtils.getStr(Array.get(objects, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * webservice通用调用
     *
     * @param webServiceUrl 地址
     * @param methodName    方法名
     * @param param         参数数据
     * @return {@link String}
     * @author Rex
     * @since 2022/9/7 11:26
     */
    public static String webServiceClient(String webServiceUrl, String methodName, String param) {
        return webServiceClientCommon(webServiceUrl, methodName, "1", param);
    }

    /**
     * webservice通用调用返回json数据
     *
     * @param webServiceUrl 地址
     * @param methodName    方法名
     * @param param         参数数据
     * @return {@link JSONArray}
     * @author Rex
     * @since 2022/9/15 12:50
     */
    public static JSONArray webServiceClientJSONArray(String webServiceUrl, String methodName, String param) {
        JSONArray jsonArray;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = CustomObjectUtils.xml2Json(webServiceClientCommon(webServiceUrl, methodName, "1", param));
            if (!jsonObject.getJSONObject("info").containsKey("row")) {
                jsonArray = new JSONArray();
                jsonArray.add(jsonObject.getJSONObject("info"));
                return jsonArray;
            }
            Object o = jsonObject.getJSONObject("info").get("row");
            if (o instanceof JSONArray) {
                jsonArray = jsonObject.getJSONObject("info").getJSONArray("row");
            } else {
                jsonArray = new JSONArray();
                jsonArray.add(jsonObject.getJSONObject("info").getJSONObject("row"));
            }
        } catch (NullPointerException e) {
            jsonArray = new JSONArray();
            jsonArray.add(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return jsonArray;
    }

    public static void main(String[] args) {
        String webServiceUrl = "http://10.30.16.90:4432/WebService/CS_WebService.asmx?WSDL";
//        String s = webServiceClient("", "DataSnalysisStation", "1", "<root><info><row><BizType>OA</BizType><BizTypeName>人员信息</BizTypeName><susercode></susercode></row></info></root>");
//        String s = webServiceClient(webServiceUrl, "DataSnalysisStation", "<root><info><row><BizType>U9COrganization</BizType><BizTypeName>组织查询</BizTypeName><Orageid></Orageid></row></info></root>");
//        JSONArray jsonArray = webServiceClientJSONArray(webServiceUrl, "DataSnalysisStation", "<root><info><row><BizType>U9COrganization</BizType><BizTypeName>组织查询</BizTypeName><Orageid></Orageid></row></info></root>");
//        JSONArray jsonArray = webServiceClientJSONArray(webServiceUrl, "DataSnalysisStation", "<root><info><row><BizType>buddy</BizType><BizTypeName>供应商信息</BizTypeName><buddyname>上海</buddyname><Orageid></Orageid></row></info></root>");
        String queryU9 = String.format(
                "<root><info><row><benefitCode>ly002</benefitCode><bizType>ZFCommonCreateMiscShipSV</bizType><bizTypeName>杂发单创建</bizTypeName><costMny>14.0000000000</costMny><datebusstime>2022-12-08 16:07:20.565</datebusstime><descFlexSe>ly002</descFlexSe><itemCode>11JL-000001</itemCode><miscShipquery>8.000000</miscShipquery><miscShiptype>MiscShip001</miscShiptype><neterprisetid>001</neterprisetid><oazfCostCenter>1010</oazfCostCenter><oazfddkz>XMLYD2022120007</oazfddkz><oragcode>004</oragcode><oragid>1002206273323628</oragid><shipbinInf></shipbinInf><sooahcode>1600763797868384257</sooahcode><userCode>WYNJ014</userCode><wh>003</wh><ZPproject>1123test002</ZPproject></row></info></root>"
        );
//        String queryU9 = String.format(
//                "<root><info><row><BizType>U9CpurPrice</BizType><BizTypeName>物料价目表查询</BizTypeName><Oragid>%s</Oragid><ItemMastercode>%s</ItemMastercode><buddycode>%s</buddycode></row></info></root>"
//                ,"1002206273323628","11JL-000001", "001");
//        String queryU9 = String.format(
//                "<root><info><row><BizType>PartInfo</BizType><BizTypeName>料品信息</BizTypeName><Tcode>%s</Tcode><Spec></Spec><StockCode></StockCode><startTime></startTime><endTime></endTime><Orageid></Orageid><ItemMastername></ItemMastername><whname></whname></row></info></root>"
//                ,"11LY-000015");

        JSONArray jsonArray = webServiceClientJSONArray(webServiceUrl, "DataSnalysisStation", queryU9);
        System.out.println(jsonArray);
    }
}

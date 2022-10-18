package com.dlanqi.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 应用模块名称
 * Copyright: Copyright (C) 2020 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author Rex
 * @since 2020/11/11 13:57
 */
public class CustomFileUtils {
    /**
     * 读取资源文件中的mht模板文件
     * 
     * @param file
     * @return
     * @throws IOException
     */
    public static String readTemplate(File file) throws IOException {
        StringBuffer buffer = new StringBuffer("");
        BufferedReader br = null;
        try {
            buffer = new StringBuffer("");
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            while (br.ready()) {
                buffer.append((char) br.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return buffer.toString();
    }

    /**
     * 
     * 获取文件后缀
     * 
     * @param fileName 文件名称
     * @return {@link String}
     * @author Rex
     * @since 2022-04-28 11:22:46
     */
    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.'));
    }
}

/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.tools.configure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * <p>Description : ResourceUtil</p>
 * <p>Created on  : 2018-09-11 16:39</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class ResourceUtil {
    private static final String DEFAULT_ENCODE = "UTF-8";
    private static final int HASHMAP_INIT_CAPACITY = 16;

    private ResourceUtil() {
    }

    /**
     * <p>description : 从jar中读取文件内容</p>
     * <p>create   on : 2018-09-11 16:44:14</p>
     *
     * eg: ResourceUtil.readFileFromJar("config.xml")
     * 相对于jar包中的资源路径
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static String readFileFromJar(String path) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        StringBuffer buffer = new StringBuffer();
        BufferedReader in = null;
        String line = "";
        try {
            in = new BufferedReader(new InputStreamReader(loader.getResourceAsStream(path), DEFAULT_ENCODE));
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        String input = buffer.toString();
        return input;
    }

    /**
     * <p>description : 从源码中读取文件</p>
     * <p>create   on : 2018-09-12 16:02:35</p>
     *
     * eg: ResourceUtil.readFileFromCode("src/main/resources/config.xml")
     * 相对于代码中的资源路径
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static String readFileFromCode(String url) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(url), DEFAULT_ENCODE));
            String s;
            for (s = reader.readLine(); s != null; s = reader.readLine()) {
                sb.append(lineSeparator);
                sb.append(s);
            }
            return sb.toString().replaceFirst(lineSeparator, "");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return "";
    }

    /**
     * <p>description : 从resouces中获取property</p>
     * <p>create   on : 2018-09-11 16:51:13</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static String readPropertyFromResources(String propertiesPath, String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesPath);
        return resourceBundle.getString(key);
    }

    /**
     * <p>description : 从resouces中获取properties转化为map返回</p>
     * <p>create   on : 2018-09-11 16:51:13</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static Map<String, String> readPropertiesFromResources(String propertiesPath) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesPath);
        Map<String, String> map = new HashMap(HASHMAP_INIT_CAPACITY);
        for (String key : resourceBundle.keySet()) {
            map.put(key, resourceBundle.getString(key));
        }
        return map;
    }
}

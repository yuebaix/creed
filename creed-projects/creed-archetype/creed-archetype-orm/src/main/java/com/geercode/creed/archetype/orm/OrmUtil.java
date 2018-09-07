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

package com.geercode.creed.archetype.orm;

/**
 * <p>Description : Orm工具类</p>
 * <p>Created on  : 2018-09-07 16:44</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class OrmUtil {
    public static final String TYPE_JAVA_BOOLEAN = "Boolean";
    public static final String TYPE_JAVA_INTEGER = "Integer";
    public static final String TYPE_JAVA_LONG = "Long";
    public static final String TYPE_JAVA_DOUBLE = "Double";
    public static final String TYPE_JAVA_BIGDECIMAL = "BigDecimal";
    public static final String TYPE_JAVA_STRING = "String";
    public static final String TYPE_JAVA_DATE = "Date";

    public static final String TYPE_JAVA_PKG = "java.lang.";

    public static final String TYPE_DB_TINYINT = "tinyint";
    public static final String TYPE_DB_SMALLINT = "smallint";
    public static final String TYPE_DB_INT = "int";
    public static final String TYPE_DB_BIGINT = "bigint";
    public static final String TYPE_DB_DECIMAL = "decimal";
    public static final String TYPE_DB_DOUBLE = "double";
    public static final String TYPE_DB_VARCHAR = "varchar";
    public static final String TYPE_DB_DATETIME = "datetime";
    public static final String TYPE_DB_TIMESTAMP = "timestamp";

    private OrmUtil() {
    }

    /**
     * <p>description : 用数据库表字段类型转换为java类型</p>
     * <p>create   on : 2018-09-07 16:57:59</p>
     *
     * @author jerryniu
     * @version 1.0.0
     *
     * @param type 数据库字段类型文本
     * @return java.lang.String 转化到的java类型文本
     */
    public static String getJavaType(final String type) {
        String lowerCaseType = type.toLowerCase();
        if (lowerCaseType.startsWith(TYPE_DB_VARCHAR)) {
            return TYPE_JAVA_STRING;
        }
        if (lowerCaseType.startsWith(TYPE_DB_DATETIME) || lowerCaseType.startsWith(TYPE_DB_TIMESTAMP)) {
            return TYPE_JAVA_DATE;
        }
        if (lowerCaseType.startsWith(TYPE_DB_INT) || lowerCaseType.equalsIgnoreCase(TYPE_DB_SMALLINT)) {
            return TYPE_JAVA_INTEGER;
        }
        if (lowerCaseType.startsWith(TYPE_DB_TINYINT)) {
            return TYPE_JAVA_BOOLEAN;
        }
        if (lowerCaseType.startsWith(TYPE_DB_BIGINT)) {
            return TYPE_JAVA_LONG;
        }
        if (lowerCaseType.startsWith(TYPE_DB_DECIMAL)) {
            return TYPE_JAVA_BIGDECIMAL;
        }
        if (lowerCaseType.startsWith(TYPE_DB_DOUBLE)) {
            return TYPE_JAVA_DOUBLE;
        } else {
            return TYPE_JAVA_STRING;
        }
    }

    /**
     * <p>description : 用数据库表字段类型转换为java类型全称</p>
     * <p>create   on : 2018-09-07 17:09:48</p>
     *
     * @author jerryniu
     * @version 1.0.0
     *
     * @param type 数据库字段类型文本
     * @return java.lang.String 转化到的java类型全称文本
     */
    public static String getJavaFullType(final String type) {
        return TYPE_JAVA_PKG + getJavaType(type);
    }
}

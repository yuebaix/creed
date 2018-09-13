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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description : 根据数据库生成mybatis 配置文件</p>
 * <p>Created on  : 2018-09-07 14:48</p>
 *
 * @author LiKe
 */
public class AutoCreateMybatisFile {
    private PackageConfig packageConfig;
    private MysqlDataSourceConfig dbconfig;
    private FilePathConfig pathConfig;

    public void setPackageConfig(PackageConfig packageConfig) {
        this.packageConfig = packageConfig;
    }

    public void setDbconfig(MysqlDataSourceConfig dbconfig) {
        this.dbconfig = dbconfig;
    }

    public void setPathConfig(FilePathConfig pathConfig) {
        this.pathConfig = pathConfig;
    }

    /**
     * 创建 model  及对应的service serviceImpl mapper
     *
     * @param table 表名
     */
    public void createMappers(String table) {
        try {
            List<TableColumnInfo> listColumns = dbconfig.getTableColumns(table);
            List<String> model = createModel(packageConfig, listColumns);
            File javaFile = new File(pathConfig.getModelPath() + getClassName(table) + ".java");
            if (!javaFile.exists()) {
                writeLines(javaFile, model);
            } else {
                List<String> list = readLines(javaFile);
                List<String> oldList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).indexOf("**********") > 0) {
                        i++;
                        oldList = list.subList(i, list.size());
                        break;
                    }
                }
                model.remove(model.size() - 1);
                model.addAll(oldList);
                writeLines(javaFile, model);
            }

            File servceFile = new File(pathConfig.getServicePath() + getClassName(table) + "Service.java");
            if (!servceFile.exists()) {
                String serviceStr = createService(packageConfig, getClassName(table));
                writeStringToFile(servceFile, serviceStr);
            }

            File file = new File(pathConfig.getServiceImplPath() + getClassName(table) + "ServiceImpl.java");
            if (!file.exists()) {
                String serviceImplStr = createServiceImpl(packageConfig, getClassName(table));
                writeStringToFile(file, serviceImplStr);
            }

            File path = new File(pathConfig.getMapperpath());
            if (!path.exists()) {
                boolean flag = path.mkdirs();
                if (!flag) {
                    throw new RuntimeException("创建路径失败");
                }
            }
            File mapperFile = new File(pathConfig.getMapperpath() + "BaseModelMapper.java");
            List<String> lines = new ArrayList<>();
            if (mapperFile.exists()) {
                lines = readLines(mapperFile);
            }
            List<String> serviceImplStr = createMapper(packageConfig, lines, getClassName(table));
            writeLines(mapperFile, serviceImplStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 创建mybatis plus 配置类
     *
     * @param isOverwrite 是否覆盖
     */
    public void createMybatisPlusPConfig(boolean isOverwrite) {
        try {
            File path = new File(pathConfig.getConfigPath());
            if (!path.exists()) {
                boolean flag = path.mkdirs();
                if (!flag) {
                    throw new RuntimeException("创建路径失败");
                }
            }
            File configFile = new File(pathConfig.getConfigPath() + "MybatisPlusConfig.java");
            if (isOverwrite || !configFile.exists()) {
                List<String> lines = createMybatisPlusPConfig(packageConfig);
                writeLines(configFile, lines);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 创建mybatis plus  配置文件
     */
    private List<String> createMybatisPlusPConfig(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.add("package " + pkgConf.getConfigPackage() + "; \n\n");
        lines.add("import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;");
        lines.add("import org.mybatis.spring.annotation.MapperScan;");
        lines.add("import org.springframework.context.annotation.Bean;");
        lines.add("import org.springframework.context.annotation.Configuration;");
        lines.add("@Configuration");
        lines.add("@MapperScan(\"" + pkgConf.getMapperPackage() + "*\")");
        lines.add("public class MybatisPlusConfig  {");
        lines.add("\t@Bean");
        lines.add("\tpublic PaginationInterceptor paginationInterceptor() {");
        lines.add("\t\treturn new PaginationInterceptor();");
        lines.add("\t}");
        lines.add("}");
        return lines;
    }

    /**
     * 创建基础 baseservice 类
     *
     * @param isOverwrite 是否覆盖
     */
    public void createBaseService(boolean isOverwrite) {
        try {
            File path = new File(pathConfig.getBaseServicePath());
            if (!path.exists()) {
                boolean flag = path.mkdirs();
                if (!flag) {
                    throw new RuntimeException("创建路径失败");
                }
            }
            File configFile = new File(pathConfig.getBaseServicePath() + "BaseService.java");
            if (isOverwrite || !configFile.exists()) {
                List<String> lines = createBaseService(packageConfig);
                writeLines(configFile, lines);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<String> createBaseService(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.add("package " + pkgConf.getBaseServicePackage() + "; \n");
        lines.add("import com.baomidou.mybatisplus.core.metadata.IPage;");
        lines.add("import com.baomidou.mybatisplus.extension.service.IService;");
        lines.add("import java.util.*;");
        lines.add("public interface BaseService<T> extends IService<T> {");

        lines.add(" /**\n"
                + "     *  根据自定义语句查询数据\n"
                + "     * @param myBatisSqlId  xml 中slq ID\n"
                + "     * @param conditions 条件\n"
                + "     * @return\n"
                + "     */");
        lines.add("\tpublic Object getObjectBySqlId(String myBatisSqlId, Object conditions);");
        lines.add("    /**\n"
                + "     * 根据 sqlid 查询数据返回单个数据\n"
                + "     * @param myBatisSqlId\n"
                + "     * @param conditions\n"
                + "     * @param\n"
                + "     * @return\n"
                + "     */");
        lines.add("\tpublic List getListBySqlId(String myBatisSqlId, Object conditions);");
        lines.add(" /**\n"
                + "     * 根据自定义语句查询数据\n"
                + "     *\n"
                + "     * @param querySqlId  查询居ID\n"
                + "     * @param countSqlId  查询总记录数语句。\n"
                + "     * @param param       参数\n"
                + "     * @param pageSize    每页大小\n"
                + "     * @param currentPage 查询当前页。\n"
                + "     * @return\n"
                + "     */");
        lines.add("\tpublic IPage<Object> queryPageBySqlId(String querySqlId, String countSqlId,"
                + " Map<String, Object>  param, Long pageSize, Long currentPage);");

        lines.add("}");
        return lines;
    }

    /**
     * 创建基础 baseserviceIMPL 类
     *
     * @param isOverwrite 是否覆盖
     */
    public void createBaseServiceImpl(boolean isOverwrite) {
        try {
            File path = new File(pathConfig.getBaseServiceImplPath());
            if (!path.exists()) {
                boolean flag = path.mkdirs();
                if (!flag) {
                    throw new RuntimeException("创建路径失败");
                }
            }
            File configFile = new File(pathConfig.getBaseServiceImplPath() + "BaseServiceImpl.java");
            if (isOverwrite || !configFile.exists()) {
                List<String> lines = createBaseServiceImpl(packageConfig);
                writeLines(configFile, lines);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<String> createBaseServiceImpl(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.addAll(createBaseServiceImplOne(pkgConf));
        lines.addAll(createBaseServiceImplTwo(pkgConf));
        lines.addAll(createBaseServiceImplThree(pkgConf));
        lines.addAll(createBaseServiceImplFour(pkgConf));
        return lines;
    }

    private List<String> createBaseServiceImplOne(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.add("package " + pkgConf.getBaseServiceImplPackage() + "; \n");
        lines.add("import com.baomidou.mybatisplus.core.mapper.BaseMapper;");
        lines.add("import com.baomidou.mybatisplus.core.metadata.IPage;");
        lines.add("import com.baomidou.mybatisplus.extension.plugins.pagination.Page;");
        lines.add("import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;");
        lines.add("import " + pkgConf.getBaseServicePackage() + ".BaseService;");
        lines.add("import org.mybatis.spring.SqlSessionTemplate;");
        lines.add("import org.slf4j.*;");
        lines.add("import org.springframework.beans.factory.annotation.Autowired;");
        lines.add("import java.lang.reflect.ParameterizedType;");
        lines.add("import java.util.*;");
        lines.add("public class BaseServiceImpl<M extends BaseMapper<T>,T>"
                + " extends ServiceImpl<M,T> implements BaseService<T> {");
        lines.add("\t @Autowired");
        lines.add("\t private SqlSessionTemplate sqlSession;");
        lines.add("\t Logger logger=LoggerFactory.getLogger(this.getClass());");
        return lines;
    }

    private List<String> createBaseServiceImplTwo(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.add(" /**\n"
                + "     *  根据自定义语句查询数据\n"
                + "     * @param myBatisSqlId  xml 中slq ID\n"
                + "     * @param conditions 条件\n"
                + "     * @return\n"
                + "     */");
        lines.add("\tpublic Object getObjectBySqlId(String myBatisSqlId, Object conditions){");
        lines.add("\t\t String model = getModel();");
        lines.add("\t\t String statement = \"\" + model + \"Mapper.\" + myBatisSqlId;");
        lines.add("\t\t Object object = sqlSession.selectOne(statement, conditions);");
        lines.add("\t\t return object;");
        lines.add("\t}");
        return lines;
    }

    private List<String> createBaseServiceImplThree(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.add("    /**\n"
                + "     * 根据 sqlid 查询数据返回单个数据\n"
                + "     * @param myBatisSqlId\n"
                + "     * @param conditions\n"
                + "     * @param\n"
                + "     * @return\n"
                + "     */");
        lines.add("\t@Override");
        lines.add("\tpublic List getListBySqlId(String myBatisSqlId, Object conditions){");
        lines.add("\t\t String model = getModel();");
        lines.add("\t\t logger.info(\" this service class is {}\",this.getClass().toString());");
        lines.add("\t\t String statement = \"\"+model+\"Mapper.\" + myBatisSqlId;");
        lines.add("\t\t List list =  sqlSession.selectList(statement, conditions);");
        lines.add("\t\t return list;");
        lines.add("\t}");
        return lines;
    }

    private List<String> createBaseServiceImplFour(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.add(" /**\n"
                + "     * 根据自定义语句查询数据\n"
                + "     *\n"
                + "     * @param querySqlId  查询居ID\n"
                + "     * @param countSqlId  查询总记录数语句。\n"
                + "     * @param param       参数\n"
                + "     * @param pageSize    每页大小\n"
                + "     * @param currentPage 查询当前页。\n"
                + "     * @return\n"
                + "     */");
        lines.add("\t@Override");
        lines.add("\tpublic IPage<Object> queryPageBySqlId(String querySqlId, String countSqlId,"
                + "Map<String, Object>  param, Long pageSize, Long currentPage){");
        lines.add("\t\t String model = getModel();");
        lines.add("\t\t  List<Object> list = null;");
        lines.add("\t\t  String statement = \"\" + model + \"Dao.\" + countSqlId;");
        lines.add("\t\t Long totalSize =  sqlSession.selectOne(statement, param);");
        lines.add("\t\t IPage<Object> page = new Page<>(currentPage,pageSize,totalSize);");
        lines.add("\t\t Long pageStart = Long.parseLong((page.getCurrent() - 1) * pageSize + \"\");");
        lines.add("\t\t param.put(\"startRow\", pageStart);");
        lines.add("\t\t param.put(\"endRow\", pageSize);");
        lines.add("\t\t statement = \"\" + model + \"Dao.\" + querySqlId;");
        lines.add("\t\t list = sqlSession.selectList(statement, param);");
        lines.add("\t\t page.setRecords(list);");
        lines.add("\t\t return page;");
        lines.add("    private String getModel( ) {\n"
                + "        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())"
                + ".getActualTypeArguments()[1];\n"
                + "        String paths = entityClass.toString();\n"
                + "        String model = paths.substring(paths.lastIndexOf(\".\") + 1, paths.length());\n"
                + "        return model;\n"
                + "    }");
        lines.add("}");
        return lines;
    }

    /**
     * 创建mybatis plus   base entity
     */
    private List<String> createMybatisPlusBaseEntity(PackageConfig pkgConf) {
        List<String> lines = new ArrayList<>();
        lines.add("package " + pkgConf.getModelPackage() + "; \n\n");
        lines.add("import com.baomidou.mybatisplus.extension.activerecord.Model;");
        lines.add("public abstract class  BaseEntity<T extends Model> extends Model<T> {");
        lines.add("}");
        return lines;
    }

    /**
     * 创建model父类
     *
     * @param isOverwrite 是否覆盖
     */
    public void createMybatisPlusBaseEntity(boolean isOverwrite) {
        try {
            File path = new File(pathConfig.getModelPath());
            if (!path.exists()) {
                boolean flag = path.mkdirs();
                if (!flag) {
                    throw new RuntimeException("创建路径失败");
                }
            }
            File configFile = new File(pathConfig.getModelPath() + "BaseEntity.java");
            if (isOverwrite || !configFile.exists()) {
                List<String> lines = createMybatisPlusBaseEntity(packageConfig);
                writeLines(configFile, lines);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<String> createMapper(PackageConfig pkgConf, List<String> lines, String name) {
        String model = "import " + pkgConf.getModelPackage() + "." + name + ";";
        String mapper = "    public interface " + name + "Mapper   extends BaseMapper<" + name + "> {}";
        if (lines.isEmpty()) {
            lines.add("package " + pkgConf.getMapperPackage() + "; \n\n");
            lines.add("import com.baomidou.mybatisplus.core.mapper.BaseMapper;");
            lines.add(model);
            lines.add("public class BaseModelMapper  {");
            lines.add(mapper);
            lines.add("}");
        } else {
            if (!lines.contains(model)) {
                lines.add(1, model);
                lines.add(lines.size() - 1, mapper);
            }
        }
        return lines;
    }

    private String createServiceImpl(PackageConfig pkgConf, String name) {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + pkgConf.getServiceImplPackage() + "; \n");
        sb.append("import " + pkgConf.getMapperPackage() + ".BaseModelMapper;\n");
        sb.append("import " + pkgConf.getBaseServiceImplPackage() + ".BaseServiceImpl;\n");
        sb.append("import " + pkgConf.getServicePackage() + "." + name + "Service;\n");
        sb.append("import " + pkgConf.getModelPackage() + "." + name + ";\n");
        sb.append("import org.springframework.stereotype.Service;\n  ");
        sb.append("@Service\n");
        sb.append("public class " + name + "ServiceImpl extends BaseServiceImpl<BaseModelMapper." + name + "Mapper,"
                + name + ">  implements " + name + "Service {\n");
        sb.append("}\n");
        return sb.toString();
    }

    /**
     * 创建Service
     */
    public String createService(PackageConfig pkgConf, String name) {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + pkgConf.getServicePackage() + "; \n\n\n");
        sb.append("import " + pkgConf.getModelPackage() + "." + name + ";\n");
        sb.append("import  " + pkgConf.getBaseServicePackage() + ".BaseService;\n");
        sb.append("public interface " + name + "Service  extends BaseService<" + name + ">   {\n\n\n");
        sb.append("}\n");
        return sb.toString();
    }

    private List<String> createModel(PackageConfig pkgConf, List<TableColumnInfo> list) throws Exception {
        TableColumnInfo table = list.get(0);
        List<String> sb = new ArrayList<>();
        sb.add("package  " + pkgConf.getModelPackage() + "; \n");
        sb.add("import com.baomidou.mybatisplus.annotation.TableId;");
        sb.add("import com.baomidou.mybatisplus.annotation.TableName;");
        sb.add("import lombok.Data;");
        sb.add("import java.util.Date;");
        sb.add("import java.io.Serializable;");
        sb.add("import java.math.BigDecimal;\n");
        sb.add("/**");
        sb.add("*" + table.getTableName() + "");
        sb.add("* 表名：" + table.getTableComment() + "");
        sb.add("*/");

        sb.add("@Data");
        sb.add("@TableName(\"" + table.getTableName() + "\")");
        sb.add("public class " + getClassName(table.getTableName()) + " extends BaseEntity<"
                + getClassName(table.getTableName()) + "> {\n");

        StringBuffer sm = new StringBuffer();
        String id = "id";
        for (TableColumnInfo rs : list) {
            String columnName = rs.getColumnName();
            String columnComment = rs.getColumnComment();
            String columnType = rs.getColumnType();
            String columnKey = rs.getColumnKey();
            sb.add("    /** " + columnComment + " */ ");
            String propertiesName = getPropertiesName(columnName);
            //String first=propertiesName.substring(0,1);
            //String firstUpperCOl = propertiesName.replaceFirst(first,first.toUpperCase());
            if (columnKey != null && !"".equals(columnKey)) {
                sb.add("    @TableId");
                id = propertiesName;
            }
            sb.add("    private " + OrmUtil.getJavaType(columnType) + "  " + propertiesName + " ; \n");
        }
        sm.append("    @Override\n");
        sm.append("    protected Serializable pkVal() {");
        sm.append("        return   this." + id + ";");
        sm.append("    }\n");
        sb.add("\n");
        sb.add(sm.toString());
        sb.add("/*********************************以下可以写自定义的方法*****************************/\n\n");
        sb.add("}\n");
        return sb;
    }

    private String getClassName(String tableName) {
        String[] names = tableName.split("_");
        StringBuffer sb = new StringBuffer();
        for (String s : names) {
            String first = s.substring(0, 1).toUpperCase();
            String other = s.substring(1, s.length()).toLowerCase();
            sb.append(first + other);
        }
        return sb.toString();
    }

    private List<String> readLines(File file) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            String line = null;
            while ((line = read.readLine()) != null) {
                lines.add(line);
            }
            read.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lines;
    }

    private void writeLines(File file, List<String> lines) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"));
        for (String arr : lines) {
            writer.write(arr);
            writer.newLine();
        }
        writer.close();
    }

    private void writeStringToFile(File file, String string) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"));
        writer.write(string);
        writer.close();
    }

    private String getClassNameLower(PackageConfig pkgConf, String tableName) {
        String[] names = tableName.split("_");
        StringBuffer sb = new StringBuffer();
        for (String s : names) {
            String first = s.substring(0, 1).toUpperCase();
            String other = s.substring(1, s.length()).toLowerCase();
            sb.append(first + other);
        }
        /*String ss = sb.toString();
        String first = ss.substring(0, 1).toLowerCase();
        String other = ss.substring(1, ss.length());*/
        //return first+other;
        return pkgConf.getModelPackage() + "." + getClassName(tableName);
    }

    private String getPropertiesName(String columnName) {
        char[] c = columnName.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if (ch == '_') {
                i++;
                ch = c[i];
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

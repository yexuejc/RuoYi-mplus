
package pvm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
public class CodeGenerator {
    //是否是需要包含的表名：false为排除表
    boolean isInclude = false;
    String projectPath = "C:\\home";
    //基类DO
    String superEntityClass = "com.ruoyi.common.core.domain.BaseEntity";
    //排除公共字段
    String[] superEntityColumns = {"is_del", "version", "create_by", "create_time", "update_time", "update_by", "remark"};

    @Test
    public void generateCode() {
        String packageName = "com.ruoyi.system";
//        isInclude = true;
        start(packageName, "");
    }

    public void db(AutoGenerator mpg) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setUrl("jdbc:mysql://192.168.31.222:3306/frp-admin")
                .setUsername("root")
                .setPassword("ZAQ!2wsx")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        mpg.setDataSource(dsc);
    }

    public void start(String packageName, String... tableNames) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
//        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig()
                .setOutputDir(projectPath)
                .setAuthor("yexuejc")
                .setFileOverride(true)
                .setEnableCache(false)
                .setSwagger2(false)
                .setActiveRecord(false)
                .setBaseResultMap(true)
//                .setEntityName("%sDO")
                .setServiceName("%sSrv")
                .setMapperName("%sMapper")
                .setServiceImplName("%sSrvImpl")
                .setControllerName("%sCtrl")
                .setXmlName("%sMapper")
                .setBaseColumnList(true)
                .setIdType(IdType.UUID);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        db(mpg);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };


        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/xml/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/mapper/xml/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);

        /*cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir(filePath);
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });*/


        mpg.setCfg(cfg);


        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);

        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setEntityBuilderModel(true)
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .entityTableFieldAnnotationEnable(true)
                .setTablePrefix("frp_")
                .setSuperEntityClass(superEntityClass)
                .setSuperEntityColumns(superEntityColumns)
                .setNaming(NamingStrategy.underline_to_camel);
        if (isInclude) {
            //需要包含的表名
            strategyConfig.setInclude(tableNames);
        } else {
            //需要排除的表名
            strategyConfig.setExclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        }
        mpg.setStrategy(strategyConfig);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


}
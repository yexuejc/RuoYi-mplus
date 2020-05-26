package com.ruoyi.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.incrementer.PostgreKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus 配置文件
 *
 * @author maxf
 * @version 1.0
 * @ClassName MybatisPlusConfig
 * @Description
 * @date 2018/12/13 11:34
 */
//Spring boot方式
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     * 开启分页插件出现异常 <a href="https://gitee.com/baomidou/mybatis-plus/issues/IMNH3">https://gitee.com/baomidou/mybatis-plus/issues/IMNH3</a>
     *
     * @update 2018-9-12 17:30:57
     * @version 0.1.2
     */
    @Bean
    @ConditionalOnProperty(name = "ruoyi.mybatis.plus.pager.enable", matchIfMissing = true)
    @ConditionalOnMissingBean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    @Bean
    @ConditionalOnMissingBean
    public MetaObjectHandler metaObjectHandler() {
        return new MplusMetaObjectHandler();
    }

    /**
     * 注入主键生成器
     */
    @Bean
    @ConditionalOnMissingBean
    public IKeyGenerator keyGenerator() {
        return new PostgreKeyGenerator();
    }

    /**
     * 注入sql注入器
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultSqlInjector sqlInjector() {
        return new DefaultSqlInjector();
    }

    /**
     * 乐观锁插件
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}

package iunsuccessful.demo.xxljob.config;

import com.xxl.job.core.executor.XxlJobExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by szyue on 2018/08/08 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Configuration
@ComponentScan(basePackages = "iunsuccessful.demo.xxljob.jobhandler")
public class XxlJobConfig implements EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

    private Environment environment;


    private String adminAddresses;


    private String appName;


    private String ip;


    private int port;


    private String accessToken;


    private String logPath;


    private int logRetentionDays;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();

        String adminAddresses = environment.getProperty("xxl.job.admin.addresses");

        String appName = environment.getProperty("xxl.job.executor.appname");

        String ip = environment.getProperty("xxl.job.executor.ip");

        int port = Integer.valueOf(environment.getProperty("xxl.job.executor.port"));

        String accessToken = environment.getProperty("xxl.job.accessToken");

        String logPath = environment.getProperty("xxl.job.executor.logpath");

        int logRetentionDays = Integer.valueOf(environment.getProperty("xxl.job.executor.logretentiondays"));

        xxlJobExecutor.setAdminAddresses(adminAddresses);
        xxlJobExecutor.setAppName(appName);
        xxlJobExecutor.setIp(ip);
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAccessToken(accessToken);
        xxlJobExecutor.setLogPath(logPath);
        xxlJobExecutor.setLogRetentionDays(logRetentionDays);

        return xxlJobExecutor;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}

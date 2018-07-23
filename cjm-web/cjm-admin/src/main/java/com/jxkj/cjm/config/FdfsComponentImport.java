package com.jxkj.cjm.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 
* @ClassName: FdfsComponentImport 
* @Description: TODO(fdfs 配置类) 
* @author cjm
* @date 2018年5月8日 上午9:49:23 
*
 */
@Import(FdfsClientConfig.class)
@Configuration
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FdfsComponentImport {

}

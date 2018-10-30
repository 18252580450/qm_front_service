package com.asiainfo.qm.manage.util;


import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Spring应用上下文通用类，用于支持普通java类获取Spring Bean
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;
    private static byte[] key = new byte[0];

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;

        synchronized(key) {
            try {// 针对Spring Boot做特殊处理
                key.notifyAll();
            }
            catch(IllegalMonitorStateException e) {
                throw new FatalBeanException("SpringContextUtil init failed", e);
            }
        }
    }

    private static ApplicationContext getApplicationContext() {
        if(context == null) {// 针对Spring Boot做特殊处理
            synchronized(key) {
                try {
                    key.wait();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return context;
    }

    public static String getMessage(String key) {
        MessageSource messageSource = (MessageSource)getBean("messageSource");
        return messageSource.getMessage(key, null, null);
    }

    // 通过name获取 Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    // 通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    // 通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}

package com.asiainfo.qm.manage.util;

import com.google.common.collect.Maps;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//import com.unicom.kc.manage.demo.exception.ConvertBeanException;

public class BeanDictUtils {
	 
	    @SuppressWarnings("rawtypes")
		public static Object convert(Object dest, Map<String, Object> newProperties) throws IllegalAccessException,
		            InvocationTargetException, NoSuchMethodException{
	        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
	        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
	        Map<String, Class> propertyMap = Maps.newHashMap();
	        for (PropertyDescriptor d : descriptors) {
	            if (!"class".equalsIgnoreCase(d.getName())) {
	                propertyMap.put(d.getName(), d.getPropertyType());
	            }
	        }
	        newProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
	        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
	        propertyMap.forEach((k, v) -> {
	            try {
	                if (!newProperties.containsKey(k)) {
							dynamicBean.setValue(k, propertyUtilsBean.getNestedProperty(dest, k));
	                }
	            } catch (Exception e) {
//	            	throw new ConvertBeanException(e.getMessage());
	           }
	        });
	        newProperties.forEach((k, v) -> {
	            try {
	                dynamicBean.setValue(k, v);
	           } catch (Exception e) {
//	        	   throw new ConvertBeanException(e.getMessage());
	           }
	        });
	        Object target = dynamicBean.getTarget();
	        return target;
	    }
	    public static class DynamicBean {
	        private Object target;
	        private BeanMap beanMap;
	        @SuppressWarnings("rawtypes")
			public DynamicBean(Class superclass, Map<String, Class> propertyMap) {
	            this.target = generateBean(superclass, propertyMap);
	            this.beanMap = BeanMap.create(this.target);
	        }
	        public void setValue(String property, Object value) {
	            beanMap.put(property, value);
	        }
	        public Object getValue(String property) {
	            return beanMap.get(property);
	        }
	        public Object getTarget() {
	            return this.target;
	        }
	        @SuppressWarnings("rawtypes")
			private Object generateBean(Class superclass, Map<String, Class> propertyMap) {
	            BeanGenerator generator = new BeanGenerator();
	            if (null != superclass) {
	                generator.setSuperclass(superclass);
	            }
	            BeanGenerator.addProperties(generator, propertyMap);
	            return generator.create();
	        }
	    }
}

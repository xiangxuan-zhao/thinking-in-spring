package org.geekbang.thinking.in.java.beans;

import java.beans.*;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/14
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(// System.out::println
                        propertyDescriptor -> {
                            Class<?> propertyType = propertyDescriptor.getPropertyType();
                            String propertyName = propertyDescriptor.getName();
                            if ("age".equals(propertyName)) {
                                propertyDescriptor.setPropertyEditorClass(PropertyString2Integer.class);

                            }
                        });
    }

    static class PropertyString2Integer extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}

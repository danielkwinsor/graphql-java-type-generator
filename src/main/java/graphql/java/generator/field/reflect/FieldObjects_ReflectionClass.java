package graphql.java.generator.field.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import graphql.java.generator.field.FieldObjectsStrategy;

/**
 * A reflection based, java Field centric class for generating data
 * on GraphQL fields.  This is as opposed to a Method centric way of generating
 * the same fields.
 * @author dwinsor
 *
 */
public class FieldObjects_ReflectionClass implements FieldObjectsStrategy {
    
    /**
     * Loops through all classes in the class heirarchy.
     * Looks at {@link java.lang.reflect.Field}s and returns those
     * which are suitable.
     */
    @Override
    public List<Object> getFieldRepresentativeObjects(Object object) {
        if (!(object instanceof Class<?>)) {
            return null;
        }
        Class<?> clazz = (Class<?>) object;
        List<Object> fieldObjects = new ArrayList<Object>();
        while (clazz != null && !clazz.isAssignableFrom(Object.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (int index = 0; index < fields.length; ++index) {
                Field field = fields[index];
                if (field.isSynthetic()) {
                    //The compiler added this field.
                    continue;
                }
                fieldObjects.add(field);
            }
            //we need to expose inherited fields
            clazz = clazz.getSuperclass();
        }
        return fieldObjects;
    }
}

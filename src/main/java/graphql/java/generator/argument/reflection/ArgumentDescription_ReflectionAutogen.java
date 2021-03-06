package graphql.java.generator.argument.reflection;

import java.lang.reflect.Type;

import graphql.java.generator.argument.ArgContainer;
import graphql.java.generator.argument.strategies.ArgumentDescriptionStrategy;
import graphql.java.generator.type.reflect.ReflectionUtils;

public class ArgumentDescription_ReflectionAutogen implements ArgumentDescriptionStrategy {
    
    @Override
    public String getArgumentDescription(ArgContainer container) {
        if (container == null) return null;
        Object object = container.getRepresentativeObject();
        if (object instanceof Type) {
            return getArgumentDescription((Type) object);
        }
        Class<?> clazz = ReflectionUtils.extractClassFromSupportedObject(object);
        if (clazz != null) {
            return getArgumentDescription(clazz);
        }
        return null;
    }
    
    protected String getArgumentDescription(Type type) {
        return "Autogenerated from j.l.r.Type [" + type.toString() + "]";
    }
    
    protected String getArgumentDescription(Class<?> clazz) {
        return "Autogenerated from j.l.Class [" + clazz.getCanonicalName() + "]";
    }
}

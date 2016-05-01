package graphql.java.generator.argument.strategies;

import graphql.java.generator.strategies.Strategy;
import graphql.schema.GraphQLInputType;

public interface ArgumentTypeStrategy extends Strategy {

    GraphQLInputType getArgumentType(Object object);
    
}
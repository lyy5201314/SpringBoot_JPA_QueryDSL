package com.zx.demo.base.common.orm.jpa;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;


public class BaseNameingStrategy extends SpringPhysicalNamingStrategy {
    private static final String TABLE_NAME_PREFXI="t_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment){
        Identifier identifier=super.toPhysicalTableName(name,jdbcEnvironment);
        return new Identifier(TABLE_NAME_PREFXI+identifier.getText().toLowerCase(),identifier.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        Identifier identifier=super.toPhysicalTableName(name,jdbcEnvironment);
        return new Identifier(identifier.getText().toUpperCase(),identifier.isQuoted());

    }

    @Override
    protected boolean isCaseInsensitive(JdbcEnvironment jdbcEnvironment){
        return false;
    }
}

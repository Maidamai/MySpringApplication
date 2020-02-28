package com.cai.myappweb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @author cjt
 * @date 2020/2/28 14:41
 */
@Aspect
@Configuration
public class TransactionAdviceConfig {
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.cai..service..*Impl.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {

        DefaultTransactionAttribute txAttr_REQUIRED = new DefaultTransactionAttribute();
        txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute txAttr_REQUIRED_READONLY = new DefaultTransactionAttribute();
        txAttr_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttr_REQUIRED_READONLY.setReadOnly(true);

        DefaultTransactionAttribute txAttr_ROLLBACK = new DefaultTransactionAttribute();
        txAttr_ROLLBACK.rollbackOn(new Exception());


        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("find*", txAttr_REQUIRED);
        source.addTransactionalMethod("find*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("query*", txAttr_REQUIRED);
        source.addTransactionalMethod("query*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("read*", txAttr_REQUIRED);
        source.addTransactionalMethod("read*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("get*", txAttr_REQUIRED);
        source.addTransactionalMethod("get*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("list*", txAttr_REQUIRED);
        source.addTransactionalMethod("list*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("count*", txAttr_REQUIRED);
        source.addTransactionalMethod("count*", txAttr_REQUIRED_READONLY);

        source.addTransactionalMethod("add*", txAttr_REQUIRED);
        source.addTransactionalMethod("add*", txAttr_ROLLBACK);
        source.addTransactionalMethod("insert*", txAttr_REQUIRED);
        source.addTransactionalMethod("insert*", txAttr_ROLLBACK);
        source.addTransactionalMethod("create*", txAttr_REQUIRED);
        source.addTransactionalMethod("create*", txAttr_ROLLBACK);
        source.addTransactionalMethod("update*", txAttr_REQUIRED);
        source.addTransactionalMethod("update*", txAttr_ROLLBACK);
        source.addTransactionalMethod("modify*", txAttr_REQUIRED);
        source.addTransactionalMethod("modify*", txAttr_ROLLBACK);
        source.addTransactionalMethod("edit*", txAttr_REQUIRED);
        source.addTransactionalMethod("edit*", txAttr_ROLLBACK);
        source.addTransactionalMethod("del*", txAttr_REQUIRED);
        source.addTransactionalMethod("del*", txAttr_ROLLBACK);
        source.addTransactionalMethod("remove*", txAttr_REQUIRED);
        source.addTransactionalMethod("remove*", txAttr_ROLLBACK);
        source.addTransactionalMethod("*", txAttr_REQUIRED);
        source.addTransactionalMethod("*", txAttr_ROLLBACK);


        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}

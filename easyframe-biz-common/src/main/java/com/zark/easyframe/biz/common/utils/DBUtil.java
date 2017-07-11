package com.zark.easyframe.biz.common.utils;

import java.util.Collection;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DBUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public static final String COMMON_INSERT_MAPPER_ID = "insertSelective";

    public static final String COMMON_UPDATE_MAPPER_ID = "updateByPrimaryKeySelective";

    public static final String COMMON_DELETE_MAPPER_ID = "deleteByPrimaryKey";

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        DBUtil.sqlSessionFactory = sqlSessionFactory;
    }

    public static void insertBatch(Class<?> mapperClass, Collection<?> objs) {
        new BatchTemplate() {

            @Override
            protected void singleOperation(SqlSession session, String statement, Object obj) {
                session.insert(statement, obj);
            }
        }.doBatch(sqlSessionFactory, mapperClass, COMMON_INSERT_MAPPER_ID, objs);
    }

    public static void updateBatch(Class<?> mapperClass, Collection<?> objs) {
        new BatchTemplate() {

            @Override
            protected void singleOperation(SqlSession session, String statement, Object obj) {
                session.update(statement, obj);
            }
        }.doBatch(sqlSessionFactory, mapperClass, COMMON_UPDATE_MAPPER_ID, objs);
    }

    public static void deleteBatch(Class<?> mapperClass, Collection<?> objs) {
        new BatchTemplate() {

            @Override
            protected void singleOperation(SqlSession session, String statement, Object obj) {
                session.update(statement, obj);
            }
        }.doBatch(sqlSessionFactory, mapperClass, COMMON_DELETE_MAPPER_ID, objs);
    }

    private static abstract class BatchTemplate {

        public void doBatch(SqlSessionFactory sqlSessionFactory, Class<?> mapperClass, String mapperId,
            Collection<?> objs) {
            SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
            try {
                for (Object obj : objs) {
                    singleOperation(session, mapperClass.getName() + "." + mapperId, obj);
                }
                session.commit();
                session.clearCache();
            } catch (Exception ex) {
                session.rollback();
                throw new RuntimeException("doBatch Exception.", ex);
            } finally {
                session.close();
            }
        }

        protected abstract void singleOperation(SqlSession session, String statement, Object obj);

    }

}

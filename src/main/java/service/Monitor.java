package service;

import dao.mapper.MonitorIndexMapper;
import dao.model.MonitorIndex;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.jvm.JvmMoniter;
import util.RunScriptUtil;

import java.io.IOException;
import java.io.InputStream;

public class Monitor {
    private MonitorIndex monitorIndex;
    private MonitorIndexMapper monitorIndexMapper;

//    public Monitor(){
//        String resource = "mybatis/mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            monitorIndexMapper = sqlSession.getMapper(MonitorIndexMapper.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    public MonitorIndex run(String processName, String processPort) {
        monitorIndex = JvmMoniter.run(processName, processPort);
        return monitorIndex;
        //monitorIndexMapper.insert(monitorIndex);
    }
}

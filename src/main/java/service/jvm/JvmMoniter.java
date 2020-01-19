package service.jvm;

import dao.mapper.MonitorIndexMapper;
import dao.model.MonitorIndex;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import util.RunScriptUtil;

import java.io.IOException;
import java.io.InputStream;

public class JvmMoniter {
//    private MonitorIndex monitorIndex;
//    private MonitorIndexMapper monitorIndexMapper;

//    public JvmMoniter(){
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
//
//    public void run(String processName) {
//        monitorIndex = RunScriptUtil.run(processName);
//        monitorIndexMapper.insert(monitorIndex);
//    }

    public static MonitorIndex run(String processName, String processPort) {
        return RunScriptUtil.runJvmMonitor(processName, processPort);
    }


}

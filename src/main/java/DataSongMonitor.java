import dao.mapper.MonitorIndexMapper;
import dao.model.MonitorIndex;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.Monitor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class DataSongMonitor {
    private static MonitorIndexMapper monitorIndexMapper;

    public static void main(String[] args){
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            monitorIndexMapper = sqlSession.getMapper(MonitorIndexMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                Monitor moniter = new Monitor();
                MonitorIndex monitorIndex = moniter.run("DataSongApplication", "15680");
                monitorIndexMapper.insert(monitorIndex);
            }
        };
        Timer timer = new Timer("DataSongMonitor");
        long delay  = 5000L;
        long period = 5000L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }
}

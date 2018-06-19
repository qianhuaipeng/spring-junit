package eastrobot.robotdev.dao;

import com.eastrobot.robotdev.dao.QueryDao;
import eastrobot.robotdev.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: alan.peng
 * description:
 * date: create in 17:17 2018/6/19
 * modified By：
 */
public class QueryDaoTest extends BaseTest{

    @Autowired
    private QueryDao queryDao;

    @Test
    public void queryTest(){
        queryDao.query();
    }
}

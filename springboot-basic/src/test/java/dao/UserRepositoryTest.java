package dao;

import com.kk.springbootbasic.dao.UserRepository;
import com.kk.springbootbasic.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.util.Date;


@SpringBootTest
public class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始调用jpa！");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new User("bb", "bb@126.com", "bb", "bb123456",formattedDate));
        userRepository.save(new User("cc", "cc@126.com", "cc", "cc123456",formattedDate));
    }

    @Test
    public void findByUserName() throws Exception {

        Assert.assertEquals(9, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }

    @Test
    public void findByUserNameOrEmail() throws Exception {
    }


}
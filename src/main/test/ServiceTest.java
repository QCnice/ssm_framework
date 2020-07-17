import com.geek.pojo.Dep;
import com.geek.pojo.Emp;
import com.geek.pojo.User;
import com.geek.service.DepService;
import com.geek.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sound.midi.VoiceStatus;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    DepService depService;
    @Test
    public void userServiceTest(){
        User user=userService.findUserByUserName("admin");
        System.out.println(user.getPassword());
    }
    @Test
    public void empServiceTest(){
        List<Dep>list=depService.findAllDep();
        for (Dep dep : list) {
            System.out.println(dep.getDepId()+" "+dep.getDepName());
            for (Emp emp : dep.getEmpList()) {
                System.out.println(emp.getEmpName()+"  "+emp.getSalary());
            }
        }
    }
}

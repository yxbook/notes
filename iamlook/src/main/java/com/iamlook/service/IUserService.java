package com.iamlook.service;

<<<<<<< HEAD
=======
import com.iamlook.model.User;

>>>>>>> 30f11e3654495d24a4f1456fab79ed8b4dbefdaa
import java.util.HashMap;
import java.util.List;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:57
 **/
public interface IUserService {


    List<String> queryUserList(HashMap hashMap);

<<<<<<< HEAD
    List queryUserList2(HashMap paraMap);

    List queryUserList(int i);
=======
    List queryAll();

    List<User> queryUserList(int id);
>>>>>>> 30f11e3654495d24a4f1456fab79ed8b4dbefdaa
}

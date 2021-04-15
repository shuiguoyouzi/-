package pro.yf.bj.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import pro.yf.bj.user.entity.User;

/**
 * 
   @desc    User模块的持久层
 * @author  云帆大师 微信/QQ:909904682
 * @time    2017-8-15
 *
 */
//@Repository("userMapper")//这个单词在此的意思为数据库,该注解标识出当前的类/模块即是持久层(Dao),
                         //userMapper说明当前这个是user模块的Dao,即可以理解为userDao
public interface UserMapper extends BaseMapper<User> {
	//删除
@Delete("delete from user where id = #{id}")
public void delete(User user);



@Select("select * from user")
public List<User>  fiandAll();

@Select("select * from user")
public Map<String, Object>  fiandAll1();
@Insert("insert into user (id,name,sex,age,phone,address,jf) values (#{id},#{name},#{sex},#{age},#{phone},#{address},#{jf})")
public void save(User u);

@Select("select * from user where id=#{id}")
public User queryById(String id);

@Update("update user set name=#{name},sex=#{sex},age=#{age},phone=#{phone},address=#{address},jf=#{jf} where id=#{id}")
public void update(User user);








	
}

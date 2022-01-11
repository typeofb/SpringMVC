package kr.co.androider.spring3.userMgmt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SmsSendDaoImpl implements ISmsSendDao{

	@Autowired
	@Qualifier("kepcoDB")
	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<HashMap<String, Object>> selectUser() {
		List<HashMap<String, Object>> user = null;
		try {
			user = sqlSession.selectList("user.selectUser", "30");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}

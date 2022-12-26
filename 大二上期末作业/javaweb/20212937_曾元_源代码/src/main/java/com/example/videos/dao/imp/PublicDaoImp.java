package com.example.videos.dao.imp;

import com.example.videos.dao.PublicDao;
import com.example.videos.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class PublicDaoImp implements PublicDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(JDBCUtils.getDataSource()));

    /**
     * @param encryptCode
     * @param email
     * @return
     */
    @Override
    public Boolean saveCodeByEmail(String encryptCode, String email) {
        String emailCountSql = "SELECT COUNT(id) FROM email_verification_codes WHERE email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email",email);
        Integer emailCount = namedParameterJdbcTemplate.queryForObject(emailCountSql, parameterSource,Integer.class);
        String sql = "";
        if (emailCount != 0){
            sql = "UPDATE email_verification_codes SET `code`=:code WHERE  `email`= :email";
        }else {
            sql = "INSERT INTO email_verification_codes (`email`, `code`) VALUES (:email, :code)";
        }
        MapSqlParameterSource parameterSource2 = new MapSqlParameterSource();
        parameterSource2.addValue("code", encryptCode);
        parameterSource2.addValue("email", email);
        Integer updateRow = namedParameterJdbcTemplate.update(sql,parameterSource2);
        if (updateRow!=null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * @param email
     * @return
     */
    @Override
    public String getCodeByEmail(String email) {
        String sql = "SELECT `code` FROM email_verification_codes WHERE email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        try{
            String code = namedParameterJdbcTemplate.queryForObject(sql,parameterSource,String.class);
            return code;

        }catch (Exception e){
            return null;
        }
    }
}

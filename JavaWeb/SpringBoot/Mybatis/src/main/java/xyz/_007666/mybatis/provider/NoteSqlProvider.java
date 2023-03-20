package xyz._007666.mybatis.provider;

import org.apache.ibatis.jdbc.SQL;

public class NoteSqlProvider {
    public String getUserByName(String string){
        return new SQL()
                .SELECT("*")
                .FROM("user")
                .WHERE("username like '%"+string+"%'")
                .toString();
    }
}

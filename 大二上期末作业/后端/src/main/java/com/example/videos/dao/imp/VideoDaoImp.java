package com.example.videos.dao.imp;

import com.example.videos.dao.VideoDao;
import com.example.videos.entity.User;
import com.example.videos.entity.Video;
import com.example.videos.mapper.VideoRowMapper;
import com.example.videos.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VideoDaoImp implements VideoDao {
    private final JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 根据视频id获得视频
     *
     * @param id
     */
    @Override
    public Video getVideoById(Integer id) {
        String sql = "SELECT id,update_time,`status`,title,cover,is_top,upload_user,`describe`,video_style,play_url FROM video WHERE id = ?";
        Video video = jdbc.queryForObject(sql,new VideoRowMapper(),id);
        return video;
    }

    /**
     * @param keyword
     * @param page
     * @return
     */
    @Override
    public List<Video> getVideoByKey(String keyword, Integer page) {
        /*

SELECT *
FROM (
    SELECT *
    FROM table_name
    WHERE id > (SELECT id FROM table_name WHERE name = 'John')
        AND id < (SELECT MIN(id) FROM table_name WHERE id > (SELECT id FROM table_name WHERE name = 'John'))
    LIMIT 100
)
OFFSET 200;





         */
        String sql = "";
        return null;
    }
}

package xyz._007666.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.server.CurdServer;

@RestController
@RequestMapping("curd")
public class CurdController {
    @Autowired
    private CurdServer curdServer;
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return curdServer.getUserById(id);
    }

    @PostMapping()
    public boolean saveUser(@RequestBody User user){
        return curdServer.saveUser(user);
    }
    @PutMapping()
    public boolean updateUser(@RequestBody User user){
        return curdServer.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id){
        return curdServer.deleteUser(id);
    }
}

package org.example.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    // 原有方法
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    // 新增方法1: 带参数的问候
    @GetMapping("/hello/{name}")
    public Map<String, String> helloWithName(@PathVariable String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "!");
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("name", name);
        return response;
    }

    // 新增方法2: 带查询参数的问候
    @GetMapping("/greeting")
    public Map<String, Object> greeting(
            @RequestParam(defaultValue = "Guest") String name,
            @RequestParam(defaultValue = "1") Integer times) {
        
        Map<String, Object> response = new HashMap<>();
        List<String> greetings = new ArrayList<>();
        
        for (int i = 0; i < times; i++) {
            greetings.add("Hello, " + name + "! (" + (i + 1) + ")");
        }
        
        response.put("name", name);
        response.put("times", times);
        response.put("greetings", greetings);
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

    // 新增方法3: 获取当前时间
    @GetMapping("/time")
    public Map<String, String> getTime() {
        Map<String, String> response = new HashMap<>();
        response.put("currentTime", LocalDateTime.now().toString());
        response.put("message", "当前服务器时间");
        return response;
    }

    // 新增方法4: 获取用户列表
    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        List<Map<String, Object>> users = new ArrayList<>();
        
        Map<String, Object> user1 = new HashMap<>();
        user1.put("id", 1);
        user1.put("name", "张三");
        user1.put("email", "zhangsan@test.com");
        users.add(user1);
        
        Map<String, Object> user2 = new HashMap<>();
        user2.put("id", 2);
        user2.put("name", "李四");
        user2.put("email", "lisi@test.com");
        users.add(user2);
        
        Map<String, Object> user3 = new HashMap<>();
        user3.put("id", 3);
        user3.put("name", "王五");
        user3.put("email", "wangwu@test.com");
        users.add(user3);
        
        return users;
    }

    // 新增方法5: 根据ID获取用户
    @GetMapping("/user/{id}")
    public Map<String, Object> getUserById(@PathVariable Integer id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "用户" + id);
        user.put("email", "user" + id + "@test.com");
        user.put("created", LocalDateTime.now().minusDays(id));
        return user;
    }

    // 新增方法6: POST请求 - 创建用户
    @PostMapping("/user")
    public Map<String, Object> createUser(@RequestBody Map<String, String> userData) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "用户创建成功");
        response.put("data", userData);
        response.put("createdAt", LocalDateTime.now());
        
        // 模拟生成ID
        int newId = new Random().nextInt(1000) + 1;
        response.put("userId", newId);
        
        return response;
    }

    // 新增方法7: PUT请求 - 更新用户
    @PutMapping("/user/{id}")
    public Map<String, Object> updateUser(
            @PathVariable Integer id, 
            @RequestBody Map<String, String> userData) {
        
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "用户更新成功");
        response.put("id", id);
        response.put("updatedData", userData);
        response.put("updatedAt", LocalDateTime.now());
        
        return response;
    }

    // 新增方法8: DELETE请求 - 删除用户
    @DeleteMapping("/user/{id}")
    public Map<String, Object> deleteUser(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "用户删除成功");
        response.put("deletedId", id);
        response.put("deletedAt", LocalDateTime.now());
        return response;
    }

    // 新增方法9: 健康检查
    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "HelloWorldService");
        response.put("version", "1.0.0");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    // 新增方法10: 文件上传模拟
    @PostMapping("/upload")
    public Map<String, Object> uploadFile(@RequestParam String fileName) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "文件上传成功");
        response.put("fileName", fileName);
        response.put("fileSize", new Random().nextInt(1024 * 1024) + " bytes");
        response.put("uploadedAt", LocalDateTime.now());
        return response;
    }
}
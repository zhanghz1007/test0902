package org.example.controller;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    // 1. 欢迎接口
    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "欢迎使用测试API");
        response.put("version", "1.0");
        response.put("time", LocalDateTime.now().toString());
        return response;
    }

    // 2. 用户信息接口
    @GetMapping("/user/{id}")
    public Map<String, Object> getUser(@PathVariable Integer id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "测试用户" + id);
        user.put("age", 20 + id);
        user.put("email", "user" + id + "@test.com");
        user.put("created", LocalDateTime.now().minusDays(id));
        user.put("active", true);
        return user;
    }

    // 3. 数据列表接口（带分页）
    @GetMapping("/items")
    public Map<String, Object> getItems(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {

        List<Map<String, Object>> items = new ArrayList<>();
        int start = (page - 1) * size;

        for (int i = 0; i < size; i++) {
            Map<String, Object> item = new HashMap<>();
            int itemId = start + i + 1;
            item.put("id", itemId);
            item.put("name", "商品" + itemId);
            item.put("price", 100 + new Random().nextInt(900));
            item.put("stock", new Random().nextInt(100));
            item.put("created", LocalDateTime.now().minusHours(itemId));
            items.add(item);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("size", size);
        response.put("total", 100);
        response.put("items", items);
        response.put("timestamp", LocalDateTime.now());

        return response;
    }

    // 4. 模拟不同响应状态
    @GetMapping("/test/{type}")
    public Map<String, Object> testResponse(@PathVariable String type) {
        Map<String, Object> response = new HashMap<>();
        response.put("type", type);
        response.put("timestamp", LocalDateTime.now());

        switch (type) {
            case "success":
                response.put("status", "成功");
                response.put("data", "操作成功完成");
                break;
            case "error":
                response.put("status", "错误");
                response.put("error", "处理过程中发生错误");
                break;
            case "empty":
                response.put("status", "空数据");
                response.put("data", Collections.emptyList());
                break;
            case "delay":
                try {
                    Thread.sleep(2000); // 2秒延迟
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                response.put("status", "延迟响应");
                response.put("message", "这是一个延迟响应");
                break;
            default:
                response.put("status", "未知类型");
                response.put("message", "未知的测试类型");
        }

        return response;
    }

    // 5. 返回各种数据类型
    @GetMapping("/types")
    public Map<String, Object> getDataTypes() {
        Map<String, Object> response = new HashMap<>();

        // 基本类型
        response.put("string", "字符串值");
        response.put("integer", 123);
        response.put("double", 45.67);
        response.put("boolean", true);
        response.put("nullValue", null);

        // 数组
        response.put("array", new String[]{"A", "B", "C"});

        // 列表
        response.put("list", Arrays.asList("Java", "Spring", "Boot"));

        // 对象
        Map<String, Object> nested = new HashMap<>();
        nested.put("field1", "value1");
        nested.put("field2", 999);
        response.put("object", nested);

        // 日期时间
        response.put("localDateTime", LocalDateTime.now());
        response.put("date", new Date());

        return response;
    }
}
package com.framework.code.controller;

import com.framework.code.domain.LsShebJiaoy;
import com.framework.code.service.LsShebJiaoyService;
import com.framework.core.bean.JsonResult;
import com.framework.core.mybatis.PageBounds;
import com.framework.core.mybatis.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/LsShebJiaoyController")
public class LsShebJiaoyController {

    @Autowired
    private LsShebJiaoyService service;

    /**
     * 分页查询
     * @param pb 分页模型(url?page=1&limit=20)
     * @param params 查询参数 url?page=1&limit=20&key1=value1&key2=value2
     */
    @GetMapping("/selectPageModel")
    public JsonResult selectPageModel(PageBounds pb, @RequestParam Map<String,Object> params) {
        PageModel<LsShebJiaoy> model = service.selectPageModel(pb, params);
        JsonResult result = new JsonResult(model.getList(), model.getTotal());
        return result;
    }

    /**
     * 主键查询
     * @param id 主键
     */
    @GetMapping("/selectByPrimaryKey")
    public JsonResult selectByPrimaryKey(String id) {
        LsShebJiaoy instance = service.selectByPrimaryKey(id);
        JsonResult result = new JsonResult(instance);
        return result;
    }

    /**
     * 主键删除
     * @param id 主键
     */
    @PostMapping("/deleteByPrimaryKey")
    public JsonResult deleteByPrimaryKey(String id) {
        service.deleteByPrimaryKey(id);
        return JsonResult.SUCCESS;
    }

    /**
     * 新增或更新
     * @param record 实体类
     */
    @PostMapping("/insertOrUpdate")
    public JsonResult insertOrUpdate(LsShebJiaoy record) {
        service.insertOrUpdate(record);
        return JsonResult.SUCCESS;
    }
}

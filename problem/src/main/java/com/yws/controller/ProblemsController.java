package com.yws.controller;

import com.yws.clients.RunClient;
import com.yws.clients.UserClient;
import com.yws.controller.utils.R;
import com.yws.pojo.Problems;
import com.yws.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/problem")
public class ProblemsController {

    @Autowired
    private IProblemService problemService;

    @Autowired
    private UserClient userClient;

    @Autowired
    private RunClient runClient;

//    @Autowired
//    private RestTemplate restTemplate;
    /**
     * 查询为get请求
     * 插入为post请求
     * 更新为put请求
     * 删除为delete请求
     *
     */
//    @PostMapping      //其中为请求体参数      更新删除都一样
//    public Boolean save(@RequestBody Problems problems){
//        return problemService.save(problems);
//    }

    @GetMapping("{id}")
    public R getById(@PathVariable int id){
        return new R(true,problemService.getById(id));
    }

    @GetMapping
    public R getAll(){
        return new R(true,problemService.list());
    }

    @GetMapping("{currentpage}/{pagesize}")
    public R getAllPage(@PathVariable int currentpage, @PathVariable int pagesize,Problems prob){
        return new R(true, problemService.getPage(currentpage,pagesize,prob));
    }
//        System.out.println(prob);

    // 在problem服务中调用user服务 通过id查询user
    //feign 的使用
    @GetMapping("userservice/{id}")
    public R getUserById(@PathVariable int id){
//        String url = "http://userservice/user/"+id;
//        User user = restTemplate.getForObject(url,User.class);
//        User user = userClient.getById(id);
//        return new R(true,user);
        return new R();
    }
    //@RequestParam("code") String code,@RequestParam("pid") Integer pid

    @PostMapping("judge")       //使用feign调用run服务
    public R judge(@RequestBody Map<String,String> param){
        Integer pid = Integer.parseInt(param.get("pid"));
        Problems problems = problemService.getById(pid);
        System.out.println(param);
        String runResult = runClient.getRunResult(param);
        System.out.println("runResult:"+runResult);
        System.out.println("getOutput:"+problems.getOutput());
        return new R(problems.getOutput().equals(runResult),runResult);

    }

//    @PostMapping("judge")
//    public R judge(String codetext){
//        MyClassLoader myClassLoader = new MyClassLoader();
//        try {
//            Class c = myClassLoader.loadClass("com.yws.Main");
//            Method method = c.getMethod("main", String[].class);
//            Object invoke = method.invoke(null, new Object[]{new String[]{}});
//            System.out.println("=================\n"+ invoke);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new R();
//    }

//    @PostMapping("judge")
////    public R judge(@RequestParam("code") String code,@RequestParam("pid") Integer pid){
//    public R judge(@RequestBody Map<String,String> param){
//        System.out.println(param);
//        CustomStringJavaCompiler compiler = new CustomStringJavaCompiler(param.get("code"));
//        boolean res = compiler.compiler();
//        if (res) {
//            System.out.println("编译成功");
//            System.out.println("compilerTakeTime：" + compiler.getCompilerTakeTime());
//            try {
//                compiler.runMainMethod();
//                System.out.println("runTakeTime：" + compiler.getRunTakeTime());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println(compiler.getRunResult());
//            System.out.println("诊断信息：" + compiler.getCompilerMessage());
//            System.out.println();
//        } else {
//            System.out.println("编译失败");
//            System.out.println(compiler.getCompilerMessage());
//        }
//        Integer pid = Integer.parseInt(param.get("pid"));
//        Problems pb = problemService.getById(pid);
//        boolean result =false;
//        if(pb!=null) result= pb.getOutput().equals(compiler.getRunResult());
//        return new R(res,result);
//    }



//如果要删除题目   要注意删除时存在的分页bug
}

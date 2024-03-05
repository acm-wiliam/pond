package com.yws.controller;

import com.yws.service.ExecuteStringSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller
@RestController
@RequestMapping("/run")
public class RunCodeController {
//    private Logger logger = LoggerFactory.getLogger(RunCodeController.class);

    @Autowired
    private ExecuteStringSourceService executeservice;

    String defaultSource = "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"code is null\");\n" +
            "    }\n" +
            "}";

//    @RequestMapping(path = {"/run"}, method = RequestMethod.POST)
    @PostMapping    //@RequestParam("code") String code,  @RequestParam("systemIn") String systemIn
    public String runCode(@RequestBody Map<String,String> param) {
        String code = param.get("code"), systemIn = param.get("systemIn");
        if(code==null) code = defaultSource;
        if(systemIn==null) systemIn="";
        String runResult = executeservice.execute( code, systemIn);
//        runResult = runResult.replaceAll(System.lineSeparator(), "<br/>"); // 处理html中换行的问题
//        System.out.println("code is "+code);
//        System.out.println("systemIn is "+systemIn);
//        System.out.println(runResult);
        return runResult;
    }
}

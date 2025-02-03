package com.tdf.Controller;

import com.tdf.entity.Employee;
import com.tdf.service.ExcelService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/excel/")
public class ExcelController {


    @Autowired
    private ExcelService excelService;

    @PostMapping("upload")
    public ResponseEntity<List<Employee>> upload(@RequestParam MultipartFile file){
        List<Employee> employee = excelService.processExcel(file);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }
}

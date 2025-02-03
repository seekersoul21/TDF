//package com.tdf.service;
//
//import com.tdf.entity.Employee;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.InputStream;
//import java.util.Iterator;
//import java.util.List;
//
//@Service
//public class ExcelService2 {
//
//    public List<Employee> processExcel(MultipartFile file) {
//
//        try(InputStream inputStream=file.getInputStream();
//            Workbook workbook=new XSSFWorkbook(inputStream);
//        ){
//            Sheet sheet=workbook.getSheetAt(0);
//            Iterator<Row>rowIterator=sheet.iterator();
//            DataFormatter dataFormatter=new DataFormatter();
//            if(rowIterator.hasNext()){
//                System.out.println(rowIterator);
//                rowIterator.next();
//            }
//            while(rowIterator.hasNext()){
//                Row row=rowIterator.next();
//                dataFormatter.formatCellValue(row.getCell(0));
//            }
//
//        }catch (Exception e){
//
//        }
//    }
//
//    }

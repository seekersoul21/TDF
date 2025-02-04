package com.tdf.service;

import com.tdf.dao.MetaDtaListDao;
import com.tdf.entity.Employee;
import com.tdf.entity.MetaDataList;
import com.tdf.repository.EmployeeRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

@Service
public class ExcelService {


    @Autowired
    private MetaDtaListDao metaDtaListDao;

    private final EmployeeRepository employeeRepository;

    public ExcelService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> processExcel(MultipartFile file) {


        List<Employee>employees=new ArrayList<>();
        try(InputStream inputStream=file.getInputStream();
            Workbook workbook=new XSSFWorkbook(inputStream);
        ){
            Sheet sheet=workbook.getSheetAt(0);
            Iterator<Row> rowIterator= sheet.iterator();
            String fileId=UUID.randomUUID().toString();
            DataFormatter dataFormatter=new DataFormatter();
            for(int i=0;i<sheet.getPhysicalNumberOfRows();i++){
                Row row=sheet.getRow(i);

                Cell cell0=row.getCell(0);
                Cell cell1=row.getCell(1);
                Cell cell2=row.getCell(2);
                Cell cell3=row.getCell(3);
                Cell cell4=row.getCell(4);

                if(i==0){

                    if (cell0 ==null || !cell0.getStringCellValue().equalsIgnoreCase("emp id")||
                            cell1 ==null || !cell1.getStringCellValue().equalsIgnoreCase("name")||
                            cell2 ==null || !cell2.getStringCellValue().equalsIgnoreCase("email")||
                            cell3 ==null || !cell3.getStringCellValue().equalsIgnoreCase("designation")||
                            cell4 ==null || !cell4.getStringCellValue().equalsIgnoreCase("mobile")){
                        throw new RuntimeException("invalid cell");
                    }

                }else if(i>0){

                    String empId=dataFormatter.formatCellValue(cell0);
                    String name=  dataFormatter.formatCellValue(cell1);
                    String email=dataFormatter.formatCellValue(cell2);
                    String designation=dataFormatter.formatCellValue(cell3);
                    String mobile=dataFormatter.formatCellValue(cell4);
                    Employee employee =new Employee(fileId,empId,name,email,designation,mobile);
                    employees.add(employee);

                }


            }
            List<Employee> savedEmployee = employeeRepository.saveAll(employees);

            MetaDataList metaDataList=new MetaDataList();
            metaDataList.setCreatedDate(new Date());
            metaDataList.setFileId(fileId);
            metaDataList.setSize(savedEmployee.size());
            metaDtaListDao.save(metaDataList);


        }catch (Exception e){
            e.printStackTrace();
        }

        return employees;
    }
}

package com.xl.backen.util.util;

import com.xl.backen.entity.Peoples;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * POI excel 导入导出people
 */
@SuppressWarnings("all")
public class PeoplesPOI {
    /**
     * 写入excel
     *
     * @throws IOException
     */
    public static String exportUser(File file, List<Peoples> peoples) throws IOException {
        return getString(file, peoples);
    }

    public static String getString(File file, List<Peoples> peoples) throws IOException {
        String[] title = {"姓名", "性别", "手机号", "身份证号"};

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = null;

        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }

        for (int i = 1; i <= peoples.size(); i++) {
            XSSFRow nextRow = sheet.createRow(i);

            XSSFCell nextCell = nextRow.createCell(0);
            nextCell.setCellValue(peoples.get(i - 1).getTruename());

            nextCell = nextRow.createCell(1);
            if (peoples.get(i - 1).getSex() == 1) {
                nextCell.setCellValue("男");
            } else {
                nextCell.setCellValue("女");
            }

            nextCell = nextRow.createCell(2);
            nextCell.setCellValue(peoples.get(i - 1).getMobile());

            nextCell = nextRow.createCell(3);
            nextCell.setCellValue(peoples.get(i - 1).getIdCard());
        }

        try {
            file.createNewFile();
            FileOutputStream stream = new FileOutputStream(file);
            workbook.write(stream);
            stream.close();
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            workbook.close();
        }

        return file.getName();
    }

    /**
     * 解析excel
     *
     * @throws FileNotFoundException
     */
    public static List<Peoples> importUser(MultipartFile file) throws Exception {
        List<Peoples> users = new ArrayList<Peoples>();

        XSSFWorkbook workBook = null;
        getExcel(file, users, workBook);
        return users;
    }

    public static void getExcel(MultipartFile file, List<Peoples> users, XSSFWorkbook workBook) throws IOException {
        try {
            workBook = new XSSFWorkbook(file.getInputStream());

            XSSFSheet sheet = workBook.getSheetAt(0);

            int lastRowNum = sheet.getLastRowNum();

            for (int i = 1; i <= lastRowNum; i++) {
                Peoples user = new Peoples();

                XSSFRow row = sheet.getRow(i);

                // 获取当前单元格最后的单元格列号
                XSSFCell cell = row.getCell(0);
                String truename = cell.getStringCellValue();
                user.setTruename(truename);

                cell = row.getCell(1);
                String r1 = cell.getStringCellValue();
                int sex = 0;
                if (r1.equals("男")) {
                    sex = 1;
                } else if (r1.equals("女")) {
                    sex = 2;
                } else {
                    throw new BusinessException(BusinessStatus.IMPORT_ERROR.getCode(),
                            BusinessStatus.IMPORT_ERROR.getMsg() + ": 第" + i + "行  第1列 校验错误");
                }


                user.setSex(sex);

                cell = row.getCell(2);
                if (cell == null) {
                    throw new BusinessException(500, "excel 第" + (i + 1) + "行第3列 数据为空");
                }
                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                String mobile = cell.getStringCellValue();
                if (StringUtils.isEmpty(mobile) || mobile.length() != 11) {
                    throw new BusinessException(BusinessStatus.IMPORT_ERROR.getCode(),
                            BusinessStatus.IMPORT_ERROR.getMsg() + ": 第" + (i + 1) + "行  第2列 校验错误");
                }
                user.setMobile(mobile);

                cell = row.getCell(3);
                if (cell == null) {
                    user.setIdCard("");
                } else {
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    String idCard = cell.getStringCellValue();
//				if (StringUtils.isEmpty(idCard) || idCard.length() != 18) {
//					throw new BusinessException(BusinessStatus.IMPORT_ERROR.getCode(),
//						BusinessStatus.IMPORT_ERROR.getMsg() + ": 第" + i + "行  第3列 校验错误");
//				}

                    user.setIdCard(idCard);
                }
                users.add(user);
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (workBook != null) {
                workBook.close();
            }
        }
    }
}
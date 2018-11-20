package com.xl.backen.util;

import com.xl.backen.entity.PartyRemember;
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
 * 导入导出党员信息
 */
public class PartyRememberPOI {
  /**
   * 写入excel
   *
   * @throws IOException
   */
  public static String exportUser(File file, List<PartyRemember> partyRemembers) throws IOException {
    return getString(file, partyRemembers);
  }

  /**
   * 解析excel
   *
   * @throws FileNotFoundException
   */
  public static List<PartyRemember> importUser(MultipartFile file) throws Exception {
    List<PartyRemember> users = new ArrayList<PartyRemember>();
    XSSFWorkbook workBook = null;
    getExcel(file, users, workBook);
    return users;
  }
  public static String getString(File file, List<PartyRemember> PartyRemember) throws IOException {
    String[] title = {"姓名", "手机号" };

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet();
    XSSFRow row = sheet.createRow(0);
    XSSFCell cell = null;

    for (int i = 0; i < title.length; i++) {
      cell = row.createCell(i);
      cell.setCellValue(title[i]);
    }

    for (int i = 1; i <= PartyRemember.size(); i++) {
      XSSFRow nextRow = sheet.createRow(i);

      XSSFCell nextCell = nextRow.createCell(0);
      nextCell.setCellValue(PartyRemember.get(i - 1).getTruename());

      nextCell = nextRow.createCell(1);
      nextCell.setCellValue(PartyRemember.get(i - 1).getPhone());
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
  public static void getExcel(MultipartFile file, List<PartyRemember> users, XSSFWorkbook workBook) throws IOException {
    try {
      workBook = new XSSFWorkbook(file.getInputStream());

      XSSFSheet sheet = workBook.getSheetAt(0);

      int lastRowNum = sheet.getLastRowNum();

      for (int i = 1; i <= lastRowNum; i++) {
        PartyRemember user = new PartyRemember();

        XSSFRow row = sheet.getRow(i);
        // 获取当前单元格最后的单元格列号
        XSSFCell cell = row.getCell(0);
        String truename = cell.getStringCellValue();
        user.setTruename(truename);

        cell = row.getCell(1);
        String phone = cell.getStringCellValue();
        user.setPhone(phone);
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

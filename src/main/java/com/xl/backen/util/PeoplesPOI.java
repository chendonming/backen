package com.xl.backen.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import static com.xl.backen.util.util.PeoplesPOI.getString;

/**
 * POI excel 导入导出people
 */
public class PeoplesPOI {
    /**
     * 写入excel
     *
     * @throws IOException
     */
    public static String exportUser(File file, List<Peoples> peoples) throws IOException {
        return getString(file, peoples);

    }

    /**
     * 解析excel
     *
     * @throws FileNotFoundException
     */
    public static List<Peoples> importUser(MultipartFile file) throws Exception {
        List<Peoples> users = new ArrayList<Peoples>();

        XSSFWorkbook workBook = null;
        com.xl.backen.util.util.PeoplesPOI.getExcel(file, users, workBook);
        return users;
    }
}
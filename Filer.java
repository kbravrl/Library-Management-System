/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Library;

import java.io.File;

abstract public class Filer {

    protected final File filePath = new File("C:\\Users\\kübra\\OneDrive\\Yeni klasör\\1.txt");
    protected final String FIELD_DELİMETER = ";";

    public File getFilePath() {
        return filePath;
    }

    public String getFIELD_DELİMETER() {
        return FIELD_DELİMETER;
    }
}

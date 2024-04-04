/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Storer extends Filer {

    public void store(List<Book> bookList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(getFilePath()))) {
            for (Book book : bookList) {
                String line = store(book);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Storer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String store(Book book) {
        return new StringBuilder().append(book.getBookId()).append(FIELD_DELİMETER)
                .append(book.getNameOfBook()).append(FIELD_DELİMETER)
                .append(book.getCategoryOfBook()).append(FIELD_DELİMETER)
                .append(book.getAuthorOfBook()).append(FIELD_DELİMETER)
                .append(book.getPublishingHouseOfBook()).append(FIELD_DELİMETER)
                .toString();
    }
}

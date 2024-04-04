/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loader extends Filer {

    public List<Book> load() {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                Book book = parse(line);
                bookList.add(book);
            }
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }

    public Book parse(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, FIELD_DELİMETER);
        long bookId = Long.parseLong(tokenizer.nextToken());
        String nameOfBook = tokenizer.nextToken();
        String categoryOfBook = tokenizer.nextToken();
        String authorOfBook = tokenizer.nextToken();
        String publishingHouseOfBook = tokenizer.nextToken();
        
        return new Book(bookId, nameOfBook, categoryOfBook, authorOfBook, publishingHouseOfBook);
    }
}

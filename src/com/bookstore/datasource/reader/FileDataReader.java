package com.bookstore.datasource.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public abstract class FileDataReader extends BaseDataReader{

    protected Reader getFileReader(String filePath) throws FileNotFoundException {
        return new FileReader(filePath);
    }
}

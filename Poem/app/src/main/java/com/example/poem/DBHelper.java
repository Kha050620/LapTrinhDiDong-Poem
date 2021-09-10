package com.example.poem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.poem.author.Author;
import com.example.poem.category.Category;
import com.example.poem.poem.Poem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper {
//    static int DB_VERSION = 1;
//    private String DB_PATH = "data/data/com.example.poem/databases/";
    SQLiteDatabase database = null;


    private static final String DB_NAME = "SQL_Poem.db";


    private Context context;

    public DBHelper(Context context) {
        this.context = context;
    }

    public SQLiteDatabase openDatabase() {
        File dbFile = context.getDatabasePath(DB_NAME);
        if (!dbFile.exists()) {
            try {
                copyDatabase(dbFile);
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void copyDatabase(File dbFile) throws IOException {
        InputStream is = context.getAssets().open(DB_NAME);
        OutputStream os = new FileOutputStream(dbFile);

        byte[] buffer = new byte[1024];
        while (is.read(buffer) > 0) {
            os.write(buffer);
        }

        os.flush();
        os.close();
        is.close();
    }

    private void closeDB(SQLiteDatabase db) {
        db.close();
    }

    public ArrayList<Category> loadCategory() {
        SQLiteDatabase db = openDatabase();
        ArrayList<Category> arr = new ArrayList<>();
        ArrayList<Poem> arrayList = new ArrayList<>();
        String sql = "select * from tblCategory";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String introduce = csr.getString(2);
                    String image = csr.getString(3);
                    arrayList = loadPoemByCateID(id);
                    arr.add(new Category(id, name,introduce, image, arrayList));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public ArrayList<Author> loadAuthor() {
        SQLiteDatabase db = openDatabase();
        ArrayList<Author> arr = new ArrayList<>();
        ArrayList<Poem> arrayList = new ArrayList<>();
        String sql = "select * from tblAuthor";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String introduce = csr.getString(2);
                    String image = csr.getString(3);
                    arrayList = loadPoemByAuthorID(id);
                    arr.add(new Author(id, name, introduce, image, arrayList));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public ArrayList<Poem> loadPoemByCateID(int cateID) {
        SQLiteDatabase db = openDatabase();
        ArrayList<Poem> arr = new ArrayList<>();
        Cursor csr = db.rawQuery("SELECT tblPoem.*,  tblCategory.name, tblAuthor.name from tblAuthor, tblCategory, tblPoem where tblAuthor.idAuthor = tblPoem.idAuthor and tblCategory.idCategory = tblPoem.idCategory and tblPoem.idCategory = ?", new String[]{cateID + ""});
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String introduce = csr.getString(2);
                    String image = csr.getString(3);
                    String content = csr.getString(4);
                    int favourite = csr.getInt(5);
                    int history = csr.getInt(6);
                    String nameCategory = csr.getString(9);
                    String nameAuthor = csr.getString(10);

                    arr.add(new Poem(id, name, introduce, image, content, favourite, history,nameCategory, nameAuthor));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public ArrayList<Poem> loadPoemByAuthorID(int authorID) {
        SQLiteDatabase db = openDatabase();
        ArrayList<Poem> arr = new ArrayList<>();
        Cursor csr = db.rawQuery("SELECT tblPoem.*,  tblCategory.name, tblAuthor.name from tblAuthor, tblCategory, tblPoem where tblAuthor.idAuthor = tblPoem.idAuthor and tblCategory.idCategory = tblPoem.idCategory and tblPoem.idAuthor = ?", new String[]{authorID + ""});
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String introduce = csr.getString(2);
                    String image = csr.getString(3);
                    String content = csr.getString(4);
                    int favourite = csr.getInt(5);
                    int history = csr.getInt(6);
                    String nameCategory = csr.getString(9);
                    String nameAuthor = csr.getString(10);

                    arr.add(new Poem(id, name, introduce, image, content, favourite, history,nameCategory, nameAuthor));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public ArrayList<Poem> loadPoemByFavourite(int fa) {
        SQLiteDatabase db = openDatabase();
        ArrayList<Poem> arr = new ArrayList<>();
        Cursor csr = db.rawQuery("SELECT tblPoem.*,  tblCategory.name, tblAuthor.name from tblAuthor, tblCategory, tblPoem where tblAuthor.idAuthor = tblPoem.idAuthor and tblCategory.idCategory = tblPoem.idCategory and favourite = ?", new String[]{fa + ""});
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String introduce = csr.getString(2);
                    String image = csr.getString(3);
                    String content = csr.getString(4);
                    int favourite = csr.getInt(5);
                    int history = csr.getInt(6);
                    String nameCategory = csr.getString(9);
                    String nameAuthor = csr.getString(10);

                    arr.add(new Poem(id, name, introduce, image, content, favourite, history,nameCategory, nameAuthor));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public ArrayList<Poem> loadPoemByHistory(int his) {
        SQLiteDatabase db = openDatabase();
        ArrayList<Poem> arr = new ArrayList<>();
        Cursor csr = db.rawQuery("SELECT tblPoem.*,  tblCategory.name, tblAuthor.name from tblAuthor, tblCategory, tblPoem where tblAuthor.idAuthor = tblPoem.idAuthor and tblCategory.idCategory = tblPoem.idCategory and history = ?", new String[]{his + ""});
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String introduce = csr.getString(2);
                    String image = csr.getString(3);
                    String content = csr.getString(4);
                    int favourite = csr.getInt(5);
                    int history = csr.getInt(6);
                    String nameCategory = csr.getString(9);
                    String nameAuthor = csr.getString(10);

                    arr.add(new Poem(id, name, introduce, image, content, favourite, history,nameCategory, nameAuthor));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public void updateFavoutite(int poemid, int favourite) {
        SQLiteDatabase db = openDatabase();
        ContentValues values = new ContentValues();
        if (favourite == 1){
            values.put("favourite", 0);
            db.update("tblPoem", values, "idPoem = ?", new String[]{String.valueOf(poemid)});
            closeDB(db);
        }
        else{
            values.put("favourite", 1);
            db.update("tblPoem", values, "idPoem = ?", new String[]{String.valueOf(poemid)});
            closeDB(db);
        }
    }
//    public boolean searchHistory(int idPoem) {
//        SQLiteDatabase db = openDatabase();
//        Cursor csr = db.rawQuery("select * from tblPoem where  idPoem = ? and history = 1", new String[]{String.valueOf(idPoem)});
//        if (csr != null) {
//            if (csr.moveToFirst()) {
//                do {
//                    return true;
//                } while (csr.moveToNext());
//            }
//        }
//        closeDB(db);
//        return false;
//    }

    public void updateHistory(int poemid, int history) {
        SQLiteDatabase db = openDatabase();
        ContentValues values = new ContentValues();
        if (history == 0){
            values.put("history", 1);
            db.update("tblPoem", values, "idPoem = ?", new String[]{String.valueOf(poemid)});
            closeDB(db);
        }
        else{
            values.put("history", 1);
            db.update("tblPoem", values, "idPoem = ?", new String[]{String.valueOf(poemid)});
            closeDB(db);
        }
    }



}

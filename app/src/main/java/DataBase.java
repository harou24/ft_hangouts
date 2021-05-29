import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts_manager";
    private static final String TABLE_NAME = "contacts";

    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final  String KEY_LAST_NAME = "last_name";
    private static final  String KEY_NICKNAME = "nickname";
    private static final  String KEY_PSEUDO = "pseudo";
    private static final  String KEY_PHONE_NUMBER = "phone_number";
    private static final String KEY_AGE = "age";



    private static final String TABLE_CREATE=
                                                "create table "+ TABLE_NAME + "("+ KEY_ID + "integer primary key autoincrement,"+
                                                        KEY_FIRST_NAME +" text not null,"+
                                                        KEY_LAST_NAME + " text not null,"+
                                                        KEY_NICKNAME + " text,"+
                                                        KEY_PSEUDO + " text,"+
                                                        KEY_PHONE_NUMBER + " text,"+
                                                        KEY_AGE + " integer)";

    public DataBase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        this.onCreate(db);
    }

    void add_contact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, contact.getFirst_name());
        values.put(KEY_LAST_NAME, contact.getLast_name());
        values.put(KEY_NICKNAME, contact.getNickname());
        values.put(KEY_PSEUDO, contact.getPseudo());
        values.put(KEY_PHONE_NUMBER, contact.getPhone_number());
        values.put(KEY_AGE, contact.getAge());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    Contact getContact(int id)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{KEY_ID, KEY_FIRST_NAME, KEY_LAST_NAME, KEY_NICKNAME, KEY_PSEUDO, KEY_PHONE_NUMBER, KEY_AGE},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            Integer.parseInt(cursor.getString(6)));
        return contact;
    }

    public Contact get_from_db(Cursor cursor)
    {
        Contact contact = new Contact();
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setFirst_name(cursor.getString(1));
        contact.setLast_name(cursor.getString(2));
        contact.setNickname(cursor.getString(3));
        contact.setPseudo(cursor.getString(4));
        contact.setPhone_number(cursor.getString(5));
        contact.setAge(Integer.parseInt(cursor.getString(6)));
        return contact;
    }

    public List<Contact> getAllContacts()
    {
        List<Contact> contactList = new ArrayList<Contact>();
        String select = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        if (cursor.moveToFirst())
        {
            do{
               Contact contact = get_from_db(cursor);
               contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }
}

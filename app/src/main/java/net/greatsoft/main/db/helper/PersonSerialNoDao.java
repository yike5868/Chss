package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.person.PersonSerialNo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PERSON_SERIAL_NO".
*/
public class PersonSerialNoDao extends AbstractDao<PersonSerialNo, Void> {

    public static final String TABLENAME = "PERSON_SERIAL_NO";

    /**
     * Properties of entity PersonSerialNo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property DistrictId = new Property(0, String.class, "districtId", false, "DISTRICT_ID");
        public final static Property SerialNo = new Property(1, Integer.class, "serialNo", false, "SERIAL_NO");
    };


    public PersonSerialNoDao(DaoConfig config) {
        super(config);
    }
    
    public PersonSerialNoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PERSON_SERIAL_NO\" (" + //
                "\"DISTRICT_ID\" TEXT," + // 0: districtId
                "\"SERIAL_NO\" INTEGER);"); // 1: serialNo
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PERSON_SERIAL_NO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PersonSerialNo entity) {
        stmt.clearBindings();
 
        String districtId = entity.getDistrictId();
        if (districtId != null) {
            stmt.bindString(1, districtId);
        }
 
        Integer serialNo = entity.getSerialNo();
        if (serialNo != null) {
            stmt.bindLong(2, serialNo);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PersonSerialNo entity) {
        stmt.clearBindings();
 
        String districtId = entity.getDistrictId();
        if (districtId != null) {
            stmt.bindString(1, districtId);
        }
 
        Integer serialNo = entity.getSerialNo();
        if (serialNo != null) {
            stmt.bindLong(2, serialNo);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public PersonSerialNo readEntity(Cursor cursor, int offset) {
        PersonSerialNo entity = new PersonSerialNo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // districtId
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1) // serialNo
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PersonSerialNo entity, int offset) {
        entity.setDistrictId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setSerialNo(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(PersonSerialNo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(PersonSerialNo entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
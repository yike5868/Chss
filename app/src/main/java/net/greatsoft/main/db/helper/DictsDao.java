package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.Dicts;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DICTS".
*/
public class DictsDao extends AbstractDao<Dicts, Void> {

    public static final String TABLENAME = "DICTS";

    /**
     * Properties of entity Dicts.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Dict_code = new Property(0, String.class, "dict_code", false, "DICT_CODE");
        public final static Property Dict_id = new Property(1, String.class, "dict_id", false, "DICT_ID");
        public final static Property Dict_name = new Property(2, String.class, "dict_name", false, "DICT_NAME");
        public final static Property Dict_version = new Property(3, String.class, "dict_version", false, "DICT_VERSION");
    };


    public DictsDao(DaoConfig config) {
        super(config);
    }
    
    public DictsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DICTS\" (" + //
                "\"DICT_CODE\" TEXT," + // 0: dict_code
                "\"DICT_ID\" TEXT," + // 1: dict_id
                "\"DICT_NAME\" TEXT," + // 2: dict_name
                "\"DICT_VERSION\" TEXT);"); // 3: dict_version
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DICTS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Dicts entity) {
        stmt.clearBindings();
 
        String dict_code = entity.getDict_code();
        if (dict_code != null) {
            stmt.bindString(1, dict_code);
        }
 
        String dict_id = entity.getDict_id();
        if (dict_id != null) {
            stmt.bindString(2, dict_id);
        }
 
        String dict_name = entity.getDict_name();
        if (dict_name != null) {
            stmt.bindString(3, dict_name);
        }
 
        String dict_version = entity.getDict_version();
        if (dict_version != null) {
            stmt.bindString(4, dict_version);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Dicts entity) {
        stmt.clearBindings();
 
        String dict_code = entity.getDict_code();
        if (dict_code != null) {
            stmt.bindString(1, dict_code);
        }
 
        String dict_id = entity.getDict_id();
        if (dict_id != null) {
            stmt.bindString(2, dict_id);
        }
 
        String dict_name = entity.getDict_name();
        if (dict_name != null) {
            stmt.bindString(3, dict_name);
        }
 
        String dict_version = entity.getDict_version();
        if (dict_version != null) {
            stmt.bindString(4, dict_version);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Dicts readEntity(Cursor cursor, int offset) {
        Dicts entity = new Dicts( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // dict_code
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // dict_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // dict_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // dict_version
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Dicts entity, int offset) {
        entity.setDict_code(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDict_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDict_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDict_version(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Dicts entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Dicts entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}